/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
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
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.problem.RESTProblemException;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

/**
 * Class implements a http client implementation that can be used to call RESTProductService. This implementation
 * supports a wide range of configuration parameters for Apache HTTP client and Resilience4J circuit breaker.
 */
@Component
public class RESTProductServiceHttpClient {
  /**
   * Maximum size of the connection pool.
   */
  @Value("${productservice.http.maxPoolSize}")
  private int maxPoolSize;

  /**
   * Maximum amount of idle connections in the connection pool.
   */
  @Value("${productservice.http.maxIdleConnections}")
  private int maxIdleConnections;

  /**
   * Keep alive duration for connection to REST service (in milliseconds)
   */
  @Value("${productservice.http.keepAliveDuration}")
  private int keepAliveDuration;

  /**
   * Parameter configures the time period in milliseconds after which a connection is validated before it is taken from
   * the pool again.
   */
  @Value("${productservice.http.validateAfterInactivityDuration}")
  private int validateAfterInactivityDuration;

  /**
   * Maximum amount of retries before a call to the REST service is considered to be failed.
   */
  @Value("${productservice.http.maxRetries}")
  private int maxRetries;

  /**
   * Interval in milliseconds after which the REST service is called again in case that retries are configured.
   */
  @Value("${productservice.http.retryInterval}")
  private int retryInterval;

  /**
   * Response timeout in milliseconds for calls to REST service. Please be aware that this is a very sensitive parameter
   * and needs to be fine-tuned for your purposes.
   */
  @Value("${productservice.http.responseTimeout}")
  private int responseTimeout;

  /**
   * Timeout in milliseconds to establish connections to the REST service. As connections are pooled this parameter
   * should not have a too strong influence on the overall behavior. However please ensure that it fits to your
   * environment.
   */
  @Value("${productservice.http.connectTimeout}")
  private int connectTimeout;

  /**
   * Instance of http client that is used to call proxied REST service. Configuration of HTTP client is according to the
   * defined configuration values.
   * 
   * @see #initializeHTTPClient()
   */
  private CloseableHttpClient httpClient;

  /**
   * Failure rate threshold (percent of requests) defines which amount of failed request must be exceeded due to
   * technical problems that the circuit breaker opens and no further request will be sent to the REST service.
   * 
   * Value must between 0 and 100.
   */
  @Value("${productservice.circuitbreaker.failureRateThreshold}")
  private int failureRateThreshold;

  /**
   * Duration in milliseconds that the circuit breaker stays open until request will be sent to the REST service again.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.durationInOpenState}")
  private int durationInOpenState;

  /**
   * Configures the duration in milliseconds above which calls are considered as slow and increase the slow calls
   * percentage.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.slowRequestDuration}")
  private int slowRequestDuration;

  /**
   * Configures the slow request threshold in percentage. The circuit breaker considers a call as slow when the call
   * duration is greater than <code>slowCallDuration</code>. When the percentage of slow calls is equal to or greater
   * than the threshold, the circuit breaker transitions to open and starts short-circuiting calls.
   * 
   * Value must between 0 and 100.
   */
  @Value("${productservice.circuitbreaker.slowRequestRateThreshold}")
  private int slowRequestRateThreshold;

  /**
   * Configures the number of permitted calls when the circuit breaker is half open.
   * 
   * The value must be zero or greater.
   */
  @Value("${productservice.circuitbreaker.permittedCallsInHalfOpenState}")
  private int permittedCallsInHalfOpenState;

  /**
   * Configures the size of the sliding window in seconds which is used to record the outcome of calls when the circuit
   * breaker is closed.
   * 
   * The value must be greater than 0.
   */
  @Value("${productservice.circuitbreaker.slidingWindowSizeSeconds}")
  private int slidingWindowSizeSeconds;

  /**
   * Circuit breaker instance that is used when calling the REST service.
   * 
   * @see #initializeCircuitBreaker()
   */
  private CircuitBreaker circuitBreaker;

  /**
   * Object mapper is used for serialization and deserialization of objects from Java to JSON and vice versa.
   */
  @Inject
  private ObjectMapper objectMapper;

  /**
   * Method is called after service startup and performs initialization of Apache HTTP Client.
   */
  @PostConstruct
  private void initializeHTTPClient( ) {
    XFun.getTrace().info("Initializing Apache HTTP Client for ProductService");
    // Create connection manager that can be used by multiple threads in parallel.
    SocketConfig lSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
    Registry<ConnectionSocketFactory> lRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
        .register(URIScheme.HTTP.id, PlainConnectionSocketFactory.getSocketFactory())
        .register(URIScheme.HTTPS.id, SSLConnectionSocketFactory.getSocketFactory()).build();
    // Configure connection manager according to provided configuration parameters
    PoolingHttpClientConnectionManager lConnectionManager = new PoolingHttpClientConnectionManager(lRegistry,
        PoolConcurrencyPolicy.LAX, PoolReusePolicy.LIFO, TimeValue.ofMilliseconds(keepAliveDuration));
    lConnectionManager.setMaxTotal(maxPoolSize);
    lConnectionManager.setDefaultMaxPerRoute(maxIdleConnections);
    lConnectionManager.setValidateAfterInactivity(TimeValue.ofMilliseconds(validateAfterInactivityDuration));
    lConnectionManager.setDefaultSocketConfig(lSocketConfig);
    // Create pool for http connections that is used for this proxy.
    HttpClientBuilder lBuilder = HttpClientBuilder.create();
    lBuilder.setConnectionManager(lConnectionManager);
    // Configure request specific parameters.
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

  /**
   * Method is called after service startup and performs initialization of resilience4J circuit breaker.
   */
  @PostConstruct
  private void initializeCircuitBreaker( ) {
    XFun.getTrace().info("Initializing Circuit Breaker for ProductService");
    // Create circuit break configuration for target.
    CircuitBreakerConfig.Builder lConfigBuilder = CircuitBreakerConfig.custom();
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

  /**
   * Method executes a HTTP request that is expected to return a collection of objects as result.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   * @param pCollectionClass Class object of collection class that should be returned e.g. java.util.List. The parameter
   * must not be null.
   * @param pTypeClass Type of the objects that will be inside the collection. The parameter must not be null.
   * @return T Collection of objects as it was defined by <code>pCollectionClass</code> and <code>pTypeClass</code>
   */
  @SuppressWarnings({ "rawtypes" })
  public <T> T executeCollectionResultRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode,
      Class<? extends Collection> pCollectionClass, Class<?> pTypeClass ) {
    // Check parameters
    Check.checkInvalidParameterNull(pRequest, "pRequest");
    Check.checkInvalidParameterNull(pCollectionClass, "pCollectionClass");
    Check.checkInvalidParameterNull(pTypeClass, "pTypeClass");
    // Create matching response type for collections as defined by the passed parameters
    TypeFactory lTypeFactory = objectMapper.getTypeFactory();
    JavaType lResponseType = lTypeFactory.constructCollectionType(pCollectionClass, pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pSuccessfulStatusCode, lResponseType);
  }

  /**
   * Method executes a HTTP request that is expected to return a single non collection object as result.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   * @param pTypeClass Type of the object that will be returned by the call. The parameter must not be null.
   * @return T Single object as it was defined by <code>pTypeClass</code>
   */
  public <T> T executeSingleObjectResultRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode,
      Class<?> pTypeClass ) {
    // Check parameters
    Check.checkInvalidParameterNull(pRequest, "pRequest");
    Check.checkInvalidParameterNull(pTypeClass, "pTypeClass");
    // Create matching response type as defined by the passed parameters
    TypeFactory lTypeFactory = objectMapper.getTypeFactory();
    JavaType lResponseType = lTypeFactory.constructType(pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pSuccessfulStatusCode, lResponseType);
  }

  /**
   * Method executes the passed HTTP request using the configured HTTP client and circuit breaker.
   * 
   * @param pRequest Request that should b executed. The parameter must not be null.
   * @param pSuccessfulStatusCode Status code that defines that the call was successful.
   * @param pResponseType Object describing the response type of the call.
   * @return T Object of defined response type. If the called REST resource returns no content as response then null
   * will be returned.
   */
  private <T> T executeRequest( ClassicHttpRequest pRequest, int pSuccessfulStatusCode, JavaType pResponseType ) {
    // Try to execute call to REST resource
    CloseableHttpResponse lResponse = null;
    try {
      // Decorate call to proxy with circuit breaker.
      Callable<CloseableHttpResponse> lCallable =
          CircuitBreaker.decorateCallable(circuitBreaker, new Callable<CloseableHttpResponse>() {
            @Override
            public CloseableHttpResponse call( ) throws IOException {
              return httpClient.execute(pRequest);
            }
          });
      // Execute request to REST resource
      lResponse = circuitBreaker.executeCallable(lCallable);
      // If call was successful then we have to convert response into real objects.
      int lStatusCode = lResponse.getCode();
      if (lStatusCode == pSuccessfulStatusCode) {
        T lResultObject;
        HttpEntity lEntity = lResponse.getEntity();
        if (lEntity.getContentLength() > 0) {
          lResultObject = objectMapper.readValue(lEntity.getContent(), pResponseType);
        }
        else {
          lResultObject = null;
        }
        return lResultObject;
      }
      // Error when trying to execute REST call.
      else {
        // Try to resolve some details using problem JSON.
        HttpEntity lEntity = lResponse.getEntity();
        if (lEntity.getContentLength() > 0) {
          throw new RESTProblemException(lStatusCode, lResponse.getEntity().getContent());
        }
        else {
          throw new RESTProblemException(lStatusCode);
        }
      }
    }
    // IOException can result from communication or serialization problems.
    catch (IOException e) {
      throw new JEAFSystemException(JSONMessages.REST_RESPONSE_PROCESSING_ERROR, e, pRequest.getRequestUri(),
          e.getMessage());
    }
    // Thanks to circuit breaker interface definition of Resilience4J we also have to catch java.lang.Exception ;-(
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
