/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
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
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.HttpStatusAdapter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

/**
 * Class implements a http client implementation that can be used to call ProductService. This implementation supports a
 * wide range of configuration parameters for Apache HTTP client and Resilience4J circuit breaker.
 */
@Component
public class ProductServiceHttpClient {
  /**
   * Constant for problem JSON content type.
   */
  private static final String PROBLEM_JSON_CONTENT_TYPE = "application/problem+json";

  /**
   * Logger for this class.
   */
  private static final Logger logger = LoggerFactory.getLogger(ProductServiceHttpClient.class);

  /**
   * Reference to object holding all the required configuration values for the HTTP client and circuit breaker.
   */
  @Inject
  private ProductServiceConfiguration configuration;

  /**
   * Instance of http client that is used to call proxied REST service. Configuration of HTTP client is according to the
   * defined configuration values.
   * 
   * @see #initializeHTTPClient()
   */
  private CloseableHttpClient httpClient;

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
    // Create connection manager that can be used by multiple threads in parallel.
    SocketConfig lSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
    Registry<ConnectionSocketFactory> lRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
        .register(URIScheme.HTTP.id, PlainConnectionSocketFactory.getSocketFactory())
        .register(URIScheme.HTTPS.id, SSLConnectionSocketFactory.getSocketFactory()).build();
    // Configure connection manager according to provided configuration parameters
    PoolingHttpClientConnectionManager lConnectionManager =
        new PoolingHttpClientConnectionManager(lRegistry, PoolConcurrencyPolicy.LAX, PoolReusePolicy.LIFO,
            TimeValue.ofMilliseconds(configuration.getKeepAliveDuration()));
    lConnectionManager.setMaxTotal(configuration.getMaxPoolSize());
    lConnectionManager.setDefaultMaxPerRoute(configuration.getMaxIdleConnections());
    lConnectionManager
        .setValidateAfterInactivity(TimeValue.ofMilliseconds(configuration.getValidateAfterInactivityDuration()));
    lConnectionManager.setDefaultSocketConfig(lSocketConfig);
    // Create pool for http connections that is used for this proxy.
    HttpClientBuilder lBuilder = HttpClientBuilder.create();
    lBuilder.setConnectionManager(lConnectionManager);
    // Configure request specific parameters.
    RequestConfig.Builder lConfigBuilder = RequestConfig.custom();
    lConfigBuilder.setConnectionKeepAlive(TimeValue.ofMilliseconds(configuration.getKeepAliveDuration()));
    lConfigBuilder.setConnectTimeout(Timeout.ofMilliseconds(configuration.getConnectTimeout()));
    lConfigBuilder.setConnectionRequestTimeout(Timeout.ofMilliseconds(configuration.getConnectionRequestTimeout()));
    lConfigBuilder.setResponseTimeout(Timeout.ofMilliseconds(configuration.getResponseTimeout()));
    lConfigBuilder.setExpectContinueEnabled(true);
    lBuilder.setDefaultRequestConfig(lConfigBuilder.build());
    // Define retry behavior.
    lBuilder.setRetryStrategy(new DefaultHttpRequestRetryStrategy(configuration.getMaxRetries(),
        TimeValue.ofMilliseconds(configuration.getRetryInterval())));
    // Finally we have to create the http client.
    httpClient = lBuilder.build();
  }

  /**
   * Method is called after service startup and performs initialization of resilience4J circuit breaker.
   */
  @PostConstruct
  private void initializeCircuitBreaker( ) {
    // Create circuit break configuration for target.
    CircuitBreakerConfig.Builder lConfigBuilder = CircuitBreakerConfig.custom();
    lConfigBuilder.failureRateThreshold(configuration.getFailureRateThreshold());
    lConfigBuilder.waitDurationInOpenState(Duration.ofMillis(configuration.getDurationInOpenState()));
    lConfigBuilder.slowCallDurationThreshold(Duration.ofMillis(configuration.getSlowRequestDuration()));
    lConfigBuilder.slowCallRateThreshold(configuration.getSlowRequestRateThreshold());
    lConfigBuilder.permittedNumberOfCallsInHalfOpenState(configuration.getPermittedCallsInHalfOpenState());
    lConfigBuilder.slidingWindowSize(configuration.getSlidingWindowSizeSeconds());
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
  public <T> T executeCollectionResultRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode, Class<? extends Collection> pCollectionClass, Class<?> pTypeClass ) {
    // Create matching response type for collections as defined by the passed parameters
    JavaType lResponseType = objectMapper.getTypeFactory().constructCollectionType(pCollectionClass, pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, lResponseType);
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
  public <T> T executeSingleObjectResultRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode, Class<?> pTypeClass ) {
    // Create matching response type as defined by the passed parameters
    JavaType lResponseType = objectMapper.getTypeFactory().constructType(pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, lResponseType);
  }

  /**
   * Method executes a HTTP request that is expected to return no response content.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   */
  public void executeNoResponseContentRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode ) {
    // Execute request and return result.
    executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, null);
  }

  /**
   * Method executes the passed HTTP request using the configured HTTP client and circuit breaker.
   * 
   * @param pRequest Request that should b executed. The parameter must not be null.
   * @param pSuccessfulStatusCode Status code that defines that the call was successful.
   * @param pResponseType Object describing the response type of the call. The parameter may be null in case that
   * operation does not return any content e.g. void operations.
   * @return T Object of defined response type. If the called REST resource returns no content as response then null
   * will be returned.
   */
  private <T> T executeRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext, int pSuccessfulStatusCode,
      JavaType pResponseType ) {
    // Try to execute call to REST resource
    CloseableHttpResponse lResponse = null;
    URI lRequestURI = null;
    try {
      // For reasons of proper error handling we need to find out the request URI.
      lRequestURI = pRequest.getUri();
      // Trace request. Actually request logging is only done if log level is set to DEBUG.
      this.traceRequest(pRequest);
      // Decorate call to proxy with circuit breaker.
      Callable<CloseableHttpResponse> lCallable =
          CircuitBreaker.decorateCallable(circuitBreaker, new Callable<CloseableHttpResponse>() {
            @Override
            public CloseableHttpResponse call( ) throws IOException {
              return httpClient.execute(pRequest, pHttpContext);
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
          // Check if response logging is active.
          if (logger.isTraceEnabled()) {
            String lResponseBody = this.getContent(lEntity.getContent());
            this.traceResponse(lResponse, lRequestURI, lResponseBody);
            lResultObject = objectMapper.readValue(lResponseBody, pResponseType);
          }
          else {
            lResultObject = objectMapper.readValue(lEntity.getContent(), pResponseType);
          }
        }
        else {
          lResultObject = null;
        }
        return lResultObject;
      }
      // Error when trying to execute REST call.
      else {
        // If server provided problem JSON then we will return this information.
        if (PROBLEM_JSON_CONTENT_TYPE.equals(lResponse.getEntity().getContentType())) {
          ThrowableProblem lProblem =
              objectMapper.readValue(lResponse.getEntity().getContent(), ThrowableProblem.class);
          throw lProblem;
        }
        // Build up problem JSON from the information we have.
        else {
          // Try to resolve some details.
          ProblemBuilder lProblemBuilder = Problem.builder();
          HttpStatusAdapter lStatus = new HttpStatusAdapter(HttpStatus.valueOf(lStatusCode));
          lProblemBuilder.withStatus(lStatus);
          lProblemBuilder.withTitle(lStatus.getReasonPhrase());
          lProblemBuilder.withType(pRequest.getUri());
          HttpEntity lEntity = lResponse.getEntity();
          if (lEntity.getContentLength() > 0) {
            lProblemBuilder.withDetail(this.getContent(lEntity.getContent()));
          }
          throw lProblemBuilder.build();
        }
      }
    }
    //
    // In all the cases below we will use status code 500 INTERNAL_SERVER error as it is not the clients fault that the
    // request could not be processed
    //
    // IOException can result from communication or serialization problems.
    catch (IOException e) {
      logger.error("Exception occurred when try to call REST Service " + pRequest.toString(), e);
      ProblemBuilder lBuilder = Problem.builder();
      lBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lBuilder.withTitle(Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
      lBuilder.withType(lRequestURI);
      lBuilder.withDetail(e.getMessage());
      throw lBuilder.build();
    }
    // Thanks to circuit breaker interface definition of Resilience4J we have to handle RuntimeExceptions
    catch (RuntimeException e) {
      throw e;
    }
    // Thanks to circuit breaker interface definition of Resilience4J we also have to catch java.lang.Exception ;-(
    catch (Exception e) {
      logger.error("Exception occurred when try to call REST Service " + pRequest.toString(), e);
      ProblemBuilder lBuilder = Problem.builder();
      lBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lBuilder.withTitle(Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
      lBuilder.withType(lRequestURI);
      lBuilder.withDetail(e.getMessage());
      throw lBuilder.build();
    }
    // No matter what happened we have at least close the http response if possible.
    finally {
      if (lResponse != null) {
        try {
          lResponse.close();
        }
        catch (IOException e) {
          logger.error(
              "Unable to close http client response from REST Service " + configuration.getExternalServiceURL(), e);
        }
      }
    }
  }

  private void traceRequest( ClassicHttpRequest pRequest ) throws URISyntaxException, IOException {
    if (logger.isDebugEnabled()) {
      StringBuilder lBuilder = new StringBuilder();
      // Add first line with http method and URL
      lBuilder.append("Request: (");
      lBuilder.append(pRequest.getMethod());
      lBuilder.append(") ");
      lBuilder.append(pRequest.getUri());
      lBuilder.append(System.lineSeparator());

      // Add header fields
      List<String> lSensitiveHeaderNames = configuration.getSensitiveHeaderNames();
      lBuilder.append("Request Headers: ");
      for (Header lNextHeader : pRequest.getHeaders()) {
        // For security reasons sensitive headers have to be filtered out from tracing.
        if (lSensitiveHeaderNames.contains(lNextHeader.getName())) {
          lBuilder.append(lNextHeader.getName());
          lBuilder.append("='");
          lBuilder.append(lNextHeader.getValue());
          lBuilder.append("' ");
        }
      }
      lBuilder.append(System.lineSeparator());
      // Add body if request has one.
      HttpEntity lEntity = pRequest.getEntity();
      if (lEntity != null && lEntity.getContentLength() > 0) {
        lBuilder.append("Body: ");
        lBuilder.append(this.getContent(lEntity.getContent()));
      }
      // Finally really log the request.
      logger.debug(lBuilder.toString());
    }
  }

  private void traceResponse( CloseableHttpResponse pResponse, URI pRequestURI, String pBody )
    throws URISyntaxException, IOException {
    if (logger.isTraceEnabled()) {
      StringBuilder lBuilder = new StringBuilder();
      // Add first line with http method and URL
      lBuilder.append("Response: ");
      lBuilder.append(pRequestURI);
      lBuilder.append(System.lineSeparator());
      // Add http status code.
      lBuilder.append("Status Code: ");
      lBuilder.append(pResponse.getCode());
      lBuilder.append(System.lineSeparator());

      // Add header fields
      List<String> lSensitiveHeaderNames = configuration.getSensitiveHeaderNames();
      lBuilder.append("Response Headers: ");
      for (Header lNextHeader : pResponse.getHeaders()) {
        // For security reasons sensitive headers have to be filtered out from tracing.
        if (lSensitiveHeaderNames.contains(lNextHeader.getName())) {
          lBuilder.append(lNextHeader.getName());
          lBuilder.append("='");
          lBuilder.append(lNextHeader.getValue());
          lBuilder.append("' ");
        }
      }
      lBuilder.append(System.lineSeparator());
      // Add body if request has one.
      if (pBody != null) {
        lBuilder.append("Body: ");
        lBuilder.append(pBody);
      }
      // Finally really log the response.
      logger.debug(lBuilder.toString());
    }
  }

  /**
   * Method returns the content of the passed input stream.
   * 
   * @param pInputStream Stream to access the content. The parameter must not be null.
   * @return String Available content of the stream. The method never returns null.
   */
  private String getContent( InputStream pInputStream ) throws IOException {
    int lAvailableBytes = pInputStream.available();
    ByteArrayOutputStream lBytes = new ByteArrayOutputStream(lAvailableBytes);
    // Read as much bytes as possible into the buffer.
    int lBytesRead;
    byte[] lBuffer = new byte[128];
    while ((lBytesRead = pInputStream.read(lBuffer, 0, lBuffer.length)) != -1) {
      lBytes.write(lBuffer, 0, lBytesRead);
    }
    return new String(lBytes.toByteArray());
  }
}
