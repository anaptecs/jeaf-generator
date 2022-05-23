/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.service;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

// @Configuration
public class ProductServiceHttpClientConfiguration {
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

  @Bean
  ProductServiceHttpClientConfiguration getConfiguration( ) {
    return this;
  }

  public CloseableHttpClient httpClient( ) {
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

    // Create http client and return it.
    return lBuilder.build();
  }
}
