/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.Callable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.problem.RESTProblemException;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.Builder;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

// @Configuration
// @Component
public class ProductServiceHttpClientSpring {
  /**
   * Maximum amount of idle connections in the connection pool.
   */
  @Value("${productservice.http.maxIdleConnections}")
  private int maxIdleConnections = 20;

  /**
   * Keep alive duration for connection to proxy target (in milliseconds)
   */
  @Value("${productservice.http.keepAliveDuration}")
  private int keepAliveDuration = 1 * 60 * 1000;

  /**
   * Parameter configures the time period in milliseconds after which a connection is validated before it is taken from
   * the pool again.
   */
  @Value("${productservice.http.validateAfterInactivityDuration}")
  private int validateAfterInactivityDuration = 10 * 1000;

  /**
   * Maximum amount of retries before a call to the proxy target is considered to be failed.
   */
  @Value("${productservice.http.maxRetries}")
  private int maxRetries = 1;

  /**
   * Interval in milliseconds after which the proxy target is called again in case that retries are configured.
   */
  @Value("${productservice.http.retryInterval}")
  private int retryInterval = 100;

  /**
   * Response timeout in milliseconds for calls to proxy target. Please be aware that this is a very sensitive parameter
   * and needs to be fine-tuned for your purposes. the response timeout has a very strong influence on the behavior of
   * your service to the outside world and also influences pipeline configuration values.
   */
  @Value("${productservice.http.responseTimeout}")
  private int responseTimeout = 10000;

  /**
   * Timeout in milliseconds to establish connections to the proxy target. As connections are pooled this parameter
   * should not have a too strong influence on the overall behavior. However please ensure that it fits to your
   * environment.
   */
  @Value("${productservice.http.connectTimeout}")
  private int connectTimeout = 10000;

  /**
   * Instance of http client that is used to call proxied REST service. Configuration of HTTP client is according to the
   * defined configuration values.
   * 
   * @see #initializeHTTPClient()
   */
  private CloseableHttpClient httpClient;

  /**
   * Failure rate threshold (percent of requests) defines which amount of failed request must be exceeded due to
   * technical problems that the circuit breaker opens and no further request will be sent to the proxy target.
   * 
   * Value must between 0 and 100.
   */
  @Value("${productservice.circuitbreaker.failureRateThreshold}")
  private int failureRateThreshold = 30;

  /**
   * Duration in milliseconds that the circuit breaker stays open until request will be sent to the proxy target again.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.durationInOpenState}")
  private int durationInOpenState = 1000;

  /**
   * Configures the duration in milliseconds above which calls are considered as slow and increase the slow calls
   * percentage.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.slowRequestDuration}")
  private int slowRequestDuration = 10000;

  /**
   * Configures the slow request threshold in percentage. The circuit breaker considers a call as slow when the call
   * duration is greater than <code>slowCallDuration</code>. When the percentage of slow calls is equal to or greater
   * than the threshold, the circuit breaker transitions to open and starts short-circuiting calls.
   * 
   * Value must between 0 and 100.
   */
  @Value("${productservice.circuitbreaker.slowRequestRateThreshold}")
  private int slowRequestRateThreshold = 30;

  /**
   * Configures the number of permitted calls when the circuit breaker is half open.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.permittedCallsInHalfOpenState}")
  private int permittedCallsInHalfOpenState = 5;

  /**
   * Configures the size of the sliding window in seconds which is used to record the outcome of calls when the circuit
   * breaker is closed.
   * 
   * The value must be greater than 0.
   */
  @Value("${productservice.circuitbreaker.slidingWindowSizeSeconds}")
  private int slidingWindowSizeSeconds = 5;

  /**
   * Circuit breaker instance that is used when calling the REST service.
   * 
   * @see #initializeCircuitBreaker()
   */
  private CircuitBreaker circuitBreaker;

  @Inject
  private ObjectMapper objectMapper;

  /**
   * Method is called after service startup and performs initialization of Apache HTTP Client.
   */
  @PostConstruct
  private void initializeHTTPClient( ) {
    System.out.println("Initializing Apache HTTP Client for ProductService");

    // Create connection manager that can be used by multiple threads in parallel.
    SocketConfig lSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();

    Registry<ConnectionSocketFactory> lRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
        .register(URIScheme.HTTP.id, PlainConnectionSocketFactory.getSocketFactory())
        .register(URIScheme.HTTPS.id, SSLConnectionSocketFactory.getSocketFactory()).build();

    PoolingHttpClientConnectionManager lConnectionManager = new PoolingHttpClientConnectionManager(lRegistry,
        PoolConcurrencyPolicy.LAX, PoolReusePolicy.LIFO, TimeValue.ofMilliseconds(keepAliveDuration));
    lConnectionManager.setDefaultMaxPerRoute(maxIdleConnections);
    lConnectionManager.setMaxTotal(maxIdleConnections);
    lConnectionManager.setValidateAfterInactivity(TimeValue.ofMilliseconds(validateAfterInactivityDuration));
    lConnectionManager.setDefaultSocketConfig(lSocketConfig);

    // Create pool for http connections that is used for this proxy.
    HttpClientBuilder lBuilder = HttpClientBuilder.create();
    lBuilder.setConnectionManager(lConnectionManager);

    // Define configuration for each request.
    RequestConfig.Builder lConfigBuilder = RequestConfig.custom();
    lConfigBuilder.setConnectionKeepAlive(TimeValue.ofMilliseconds(keepAliveDuration));
    lConfigBuilder.setConnectTimeout(Timeout.ofMilliseconds(connectTimeout));
    lConfigBuilder.setResponseTimeout(Timeout.ofMilliseconds(responseTimeout));
    lConfigBuilder.setExpectContinueEnabled(true);
    lBuilder.setDefaultRequestConfig(lConfigBuilder.build());

    // Define retry behavior.
    lBuilder.setRetryStrategy(new DefaultHttpRequestRetryStrategy(maxRetries, TimeValue.ofMilliseconds(retryInterval)));

    // Finally we have to create the http client.
    httpClient = lBuilder.build();
  }

  @PostConstruct
  private void initializeCircuitBreaker( ) {
    System.out.println("Initializing Circuit Breaker for ProductService");

    // Create circuit break configuration for target.
    Builder lConfigBuilder = CircuitBreakerConfig.custom();
    lConfigBuilder.failureRateThreshold(failureRateThreshold);
    lConfigBuilder.waitDurationInOpenState(Duration.ofMillis(durationInOpenState));
    lConfigBuilder.slowCallDurationThreshold(Duration.ofMillis(slowRequestDuration));
    lConfigBuilder.slowCallRateThreshold(slowRequestRateThreshold);
    lConfigBuilder.permittedNumberOfCallsInHalfOpenState(permittedCallsInHalfOpenState);
    lConfigBuilder.slidingWindowSize(slidingWindowSizeSeconds);
    lConfigBuilder.recordExceptions(IOException.class, RuntimeException.class);

    CircuitBreakerRegistry lCircuitBreakerRegistry = CircuitBreakerRegistry.of(lConfigBuilder.build());
    circuitBreaker = lCircuitBreakerRegistry.circuitBreaker("Product Service Circuit Breaker");
  }

  public CloseableHttpResponse executeRequest( ClassicHttpRequest pRequest ) throws Exception {
    // Decorate call to proxy with circuit breaker.
    Callable<CloseableHttpResponse> lCallable =
        CircuitBreaker.decorateCallable(circuitBreaker, new Callable<CloseableHttpResponse>() {
          @Override
          public CloseableHttpResponse call( ) throws IOException {
            return httpClient.execute(pRequest);
          }
        });
    return circuitBreaker.executeCallable(lCallable);
  }

  @SuppressWarnings({ "rawtypes" })
  public <T> T executeCollectionResultRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode,
      Class<? extends Collection> pCollectionClass, Class<?> pTypeClass ) {

    TypeFactory lTypeFactory = objectMapper.getTypeFactory();
    JavaType lResponseType = lTypeFactory.constructCollectionType(pCollectionClass, pTypeClass);
    return executeRequest(pRequest, pSuccessfulStatusCode, lResponseType);
  }

  public <T> T executeSingleObjectResultRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode,
      Class<?> pTypeClass ) {

    TypeFactory lTypeFactory = objectMapper.getTypeFactory();
    JavaType lResponseType = lTypeFactory.constructType(pTypeClass);
    return executeRequest(pRequest, pSuccessfulStatusCode, lResponseType);
  }

  private <T> T executeRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode, JavaType lResponseType ) {
    // Try to execute call to REST resource
    CloseableHttpResponse lResponse = null;
    try {
      // Execute request to REST resource
      lResponse = this.executeRequest(pRequest);
      int lStatusCode = lResponse.getCode();

      // If call was successful then we have to convert response into real objects.
      if (lStatusCode == pSuccessfulStatusCode) {
        return objectMapper.readValue(lResponse.getEntity().getContent(), lResponseType);
      }
      // Error when trying to execute REST call.
      else {
        // Try to resolve some details using problem JSON.
        throw new RESTProblemException(lStatusCode, lResponse.getEntity().getContent());
      }
    }
    // IOException can result from communication or serialization problems.
    catch (IOException e) {
      throw new JEAFSystemException(JSONMessages.REST_RESPONSE_PROCESSING_ERROR, e, pRequest.getRequestUri(),
          e.getMessage());
    }
    // Thanks to circuit breaker interface definition of resilience4j we also have to catch java.lang.Exception ;-(
    catch (Exception e) {
      throw new JEAFSystemException(JSONMessages.REST_RESPONSE_PROCESSING_ERROR, e, pRequest.getRequestUri(),
          e.getMessage());
    }
    // No matter what happened we have at least close the http response if possible.
    finally {
      if (lResponse != null) {
        try {
          lResponse.close();
        }
        catch (IOException e) {
          XFun.getTrace().warn(JSONMessages.UNABLE_TO_CLOSE_HTTP_RESPONSE, e, pRequest.getRequestUri(), e.getMessage());
        }
      }
    }
  }
}