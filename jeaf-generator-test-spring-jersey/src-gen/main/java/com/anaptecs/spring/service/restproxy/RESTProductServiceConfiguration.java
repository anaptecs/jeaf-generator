/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class provides all the configuration parameters that are required by REST Proxy Service implementation.
 */
@Component
public class RESTProductServiceConfiguration {
  /**
   * URL of the REST service that is proxied by this service implementation.
   */
  @Value("${rESTProductService.externalURL}")
  private String externalServiceURL;

  /**
   * Domain of the cookie that is used in requests.
   */
  @Value("${rESTProductService.cookieDomain}")
  private String cookieDomain;

  /**
   * Path of the cookie that is used in requests.
   */
  @Value("${rESTProductService.cookiePath}")
  private String cookiePath;

  /**
   * Maximum size of the connection pool.
   */
  @Value("${rESTProductService.http.maxPoolSize}")
  private int maxPoolSize;

  /**
   * Maximum amount of idle connections in the connection pool.
   */
  @Value("${rESTProductService.http.maxIdleConnections}")
  private int maxIdleConnections;

  /**
   * Keep alive duration for connection to REST service (in milliseconds).
   */
  @Value("${rESTProductService.http.keepAliveDuration}")
  private int keepAliveDuration;

  /**
   * Parameter configures the time period in milliseconds after which a connection is validated before it is taken from
   * the pool again.
   */
  @Value("${rESTProductService.http.validateAfterInactivityDuration}")
  private int validateAfterInactivityDuration;

  /**
   * Maximum amount of retries before a call to the REST service is considered to be failed.
   */
  @Value("${rESTProductService.http.maxRetries}")
  private int maxRetries;

  /**
   * Interval in milliseconds after which the REST service is called again in case that retries are configured.
   */
  @Value("${rESTProductService.http.retryInterval}")
  private int retryInterval;

  /**
   * Response timeout in milliseconds for calls to REST service. Please be aware that this is a very sensitive parameter
   * and needs to be fine-tuned for your purposes.
   */
  @Value("${rESTProductService.http.responseTimeout}")
  private int responseTimeout;

  /**
   * Timeout in milliseconds to establish connections to the REST service. As connections are pooled this parameter
   * should not have a too strong influence on the overall behavior. However please ensure that it fits to your
   * environment.
   */
  @Value("${rESTProductService.http.connectTimeout}")
  private int connectTimeout;

  /**
   * Failure rate threshold (percent of requests) defines which amount of failed request must be exceeded due to
   * technical problems that the circuit breaker opens and no further request will be sent to the REST service.
   * 
   * Value must between 0 and 100.
   */
  @Value("${rESTProductService.circuitbreaker.failureRateThreshold}")
  private int failureRateThreshold;

  /**
   * Duration in milliseconds that the circuit breaker stays open until request will be sent to the REST service again.
   * 
   * The value must be zero or greater.
   */
  @Value("${rESTProductService.circuitbreaker.durationInOpenState}")
  private int durationInOpenState;

  /**
   * Configures the duration in milliseconds above which calls are considered as slow and increase the slow calls
   * percentage.
   * 
   * The value must be zero or greater.
   */
  @Value("${rESTProductService.circuitbreaker.slowRequestDuration}")
  private int slowRequestDuration;

  /**
   * Configures the slow request threshold in percentage. The circuit breaker considers a call as slow when the call
   * duration is greater than <code>slowCallDuration</code>. When the percentage of slow calls is equal to or greater
   * than the threshold, the circuit breaker transitions to open and starts short-circuiting calls.
   * 
   * Value must between 0 and 100.
   */
  @Value("${rESTProductService.circuitbreaker.slowRequestRateThreshold}")
  private int slowRequestRateThreshold;

  /**
   * Configures the number of permitted calls when the circuit breaker is half open.
   * 
   * The value must be zero or greater.
   */
  @Value("${rESTProductService.circuitbreaker.permittedCallsInHalfOpenState}")
  private int permittedCallsInHalfOpenState;

  /**
   * Configures the size of the sliding window in seconds which is used to record the outcome of calls when the circuit
   * breaker is closed.
   * 
   * The value must be greater than 0.
   */
  @Value("${rESTProductService.circuitbreaker.slidingWindowSizeSeconds}")
  private int slidingWindowSizeSeconds;

  /**
   * Method returns the URL of the REST service that is proxied by this service implementation.
   * 
   * @return String URL of the REST service. The Method never returns null.
   */
  public String getExternalServiceURL( ) {
    return externalServiceURL;
  }

  /**
   * Method returns the domain of the cookie that is used in requests.
   * 
   * @return String Cookie domain that should be used.
   */
  public String getCookieDomain( ) {
    return cookieDomain;
  }

  /**
   * Method returns the path of the cookie that is used in requests.
   * 
   * @return String Cookie path that should be used.
   */
  public String getCookiePath( ) {
    return cookiePath;
  }

  /**
   * Method returns the maximum size of the connection pool.
   * 
   * @return int Maximum pool size.
   */
  public int getMaxPoolSize( ) {
    return maxPoolSize;
  }

  /**
   * Method returns the maximum amount of idle connections in the connection pool.
   * 
   * @return int Maximum amount of idle connections.
   */
  public int getMaxIdleConnections( ) {
    return maxIdleConnections;
  }

  /**
   * Method returns the keep alive duration for connection to REST service (in milliseconds).
   * 
   * @return int Connection keep alive duration.
   */
  public int getKeepAliveDuration( ) {
    return keepAliveDuration;
  }

  /**
   * Method returns the time period in milliseconds after which a connection is validated before it is taken from the
   * pool again.
   * 
   * @return int Time period in milliseconds after which a connection is validated before it is taken from the pool
   * again.
   */
  public int getValidateAfterInactivityDuration( ) {
    return validateAfterInactivityDuration;
  }

  /**
   * Method returns the maximum amount of retries before a call to the REST service is considered to be failed.
   * 
   * @return int Maximum amount of retries before a call to the REST service is considered to be failed.
   */
  public int getMaxRetries( ) {
    return maxRetries;
  }

  /**
   * Method returns the interval in milliseconds after which the REST service is called again in case that retries are
   * configured.
   * 
   * @return int Interval in milliseconds after which the REST service is called again in case that retries are
   * configured.
   */
  public int getRetryInterval( ) {
    return retryInterval;
  }

  /**
   * Method returns the response timeout in milliseconds for calls to REST service.
   * 
   * @return int Response timeout in milliseconds for calls to REST service.
   */
  public int getResponseTimeout( ) {
    return responseTimeout;
  }

  /**
   * Method returns the timeout in milliseconds to establish connections to the REST service. As connections are pooled
   * this parameter should not have a too strong influence on the overall behavior.
   * 
   * @return int Timeout in milliseconds to establish connections to the REST service.
   */
  public int getConnectTimeout( ) {
    return connectTimeout;
  }

  /**
   * Method returns the failure rate threshold (percent of requests) defines which amount of failed request must be
   * exceeded due to technical problems that the circuit breaker opens and no further request will be sent to the REST
   * service.
   * 
   * @return int Failure rate threshold.
   */
  public int getFailureRateThreshold( ) {
    return failureRateThreshold;
  }

  /**
   * Method returns the duration in milliseconds that the circuit breaker stays open until request will be sent to the
   * REST service again.
   * 
   * @return int Duration in milliseconds that the circuit breaker stays open until request will be sent to the REST
   * service again.
   */
  public int getDurationInOpenState( ) {
    return durationInOpenState;
  }

  /**
   * Method returns the duration in milliseconds above which calls are considered as slow and increase the slow calls
   * percentage.
   * 
   * @return int Duration in milliseconds above which calls are considered as slow.
   */
  public int getSlowRequestDuration( ) {
    return slowRequestDuration;
  }

  /**
   * Method returns the slow request threshold in percentage. The circuit breaker considers a call as slow when the call
   * duration is greater than <code>slowCallDuration</code>. When the percentage of slow calls is equal to or greater
   * than the threshold, the circuit breaker transitions to open and starts short-circuiting calls.
   * 
   * Value must between 0 and 100.
   * 
   * @return int Slow request threshold in percentage.
   */
  public int getSlowRequestRateThreshold( ) {
    return slowRequestRateThreshold;
  }

  /**
   * Method returns the number of permitted calls when the circuit breaker is half open.
   * 
   * @return int Number of permitted calls when the circuit breaker is half open.
   */
  public int getPermittedCallsInHalfOpenState( ) {
    return permittedCallsInHalfOpenState;
  }

  /**
   * Method returns the size of the sliding window in seconds which is used to record the outcome of calls when the
   * circuit breaker is closed.
   * 
   * The value must be greater than 0.
   * 
   * @return int Size of the sliding window in seconds which is used to record the outcome of calls.
   */
  public int getSlidingWindowSizeSeconds( ) {
    return slidingWindowSizeSeconds;
  }
}