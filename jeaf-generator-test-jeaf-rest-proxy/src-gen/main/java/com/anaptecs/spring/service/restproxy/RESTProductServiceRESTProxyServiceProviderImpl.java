/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.http.protocol.HttpContext;

import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.TimeUnit;

/**
 * Class implements a service provider that acts as proxy for REST service RESTProductService.
 */
public final class RESTProductServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, RESTProductServiceRESTProxyServiceProvider {
  /**
   * Reference to the object that identifies this component. The reference is never null.
   */
  private static final ComponentID COMPONENT_ID;
  /**
   * Static initializer is used to create the components ComponentID object and its trace object.
   */
  static {
    // Create Component ID and trace object.
    Package lBasePackage = RESTProductServiceRESTProxyServiceProviderImpl.class.getPackage();
    COMPONENT_ID = new ComponentID("RESTProductServiceRESTProxyServiceProviderImpl", lBasePackage.getName());
  }

  /**
   * Reference to object holding all the required configuration values to delegate request to external REST service.
   */
  private RESTProductServiceConfiguration configuration;

  /**
   * HTTP client is used to handle communication to REST service.
   */
  private RESTProductServiceHttpClient httpClient;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Initialize configuration and http client.
    Configuration lComponentConfiguration = XFun.getConfigurationProvider().getComponentConfiguration(COMPONENT_ID);
    configuration = new RESTProductServiceConfiguration(lComponentConfiguration);
    httpClient = new RESTProductServiceHttpClient(configuration);
  }

  /**
   * Method checks state of this service provider implementation.
   * 
   * @return {@link HealthCheckResult} Result of the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    return httpClient.check(pLevel);
  }

  /**
   * Operation returns all available product.
   * 
   * 
   * @param pMaxResultSize
   * @return {@link Product}
   */
  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('?');
    lURIBuilder.append("maxResult=");
    lURIBuilder.append(pMaxResultSize);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    List<Product> lResult = httpClient.executeCollectionResultRequest(lRequest, null, 200, List.class, Product.class);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  @Override
  public Product getProduct( String pProductID ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append(pProductID);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, Product.class);
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pProduct into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pProduct);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, Boolean.class);
  }

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("sortiment/");
    lURIBuilder.append(pContext.getPathParam());
    lURIBuilder.append('?');
    lURIBuilder.append("q1=");
    lURIBuilder.append(pContext.getQueryParam());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("token", pContext.getAccessToken());
    lRequestBuilder.setHeader("lang",
        XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class).convert(pContext.getLanguage()));
    // Handle cookie parameters
    BasicCookieStore lCookieStore = new BasicCookieStore();
    HttpContext lLocalContext = new BasicHttpContext();
    lLocalContext.setAttribute(HttpClientContext.COOKIE_STORE, lCookieStore);
    BasicClientCookie lResellerCookie = new BasicClientCookie("reseller", String.valueOf(pContext.getResellerID()));
    String lCookieDomain = configuration.getCookieDomain();
    if (lCookieDomain != null) {
      lResellerCookie.setDomain(lCookieDomain);
    }
    String lCookiePath = configuration.getCookiePath();
    if (lCookiePath != null) {
      lResellerCookie.setPath(lCookiePath);
    }
    lCookieStore.addCookie(lResellerCookie);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, lLocalContext, 200, Sortiment.class);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("ChannelCode");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pChannelCode into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pChannelCode);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, ChannelCode.class);
  }

  /**
  * 
  */
  @Override
  public void ping( ) {
    // Create builder for HEAD request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.head();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
  * 
  */
  @Override
  public void testInit( ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-init");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("currencies/");
    lURIBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    List<CurrencyCode> lResult =
        httpClient.executeCollectionResultRequest(lRequest, null, 200, List.class, CurrencyCode.class);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("async-currencies/");
    lURIBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    List<CurrencyCode> lResult =
        httpClient.executeCollectionResultRequest(lRequest, null, 200, List.class, CurrencyCode.class);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * 
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-params");
    lURIBuilder.append('?');
    lURIBuilder.append("locale=");
    lURIBuilder.append(pLocaleQueryParam);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("Big-Header",
        XFun.getDatatypeConverterRegistry().getConverter(BigDecimal.class, String.class).convert(pBigDecimalHeader));
    // Handle cookie parameters
    BasicCookieStore lCookieStore = new BasicCookieStore();
    HttpContext lLocalContext = new BasicHttpContext();
    lLocalContext.setAttribute(HttpClientContext.COOKIE_STORE, lCookieStore);
    BasicClientCookie lGiveMeMoreCookiesCookie =
        new BasicClientCookie("giveMeMoreCookies", String.valueOf(pIntCookieParam));
    String lCookieDomain = configuration.getCookieDomain();
    if (lCookieDomain != null) {
      lGiveMeMoreCookiesCookie.setDomain(lCookieDomain);
    }
    String lCookiePath = configuration.getCookiePath();
    if (lCookiePath != null) {
      lGiveMeMoreCookiesCookie.setPath(lCookiePath);
    }
    lCookieStore.addCookie(lGiveMeMoreCookiesCookie);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, lLocalContext, 200, String.class);
  }

  /**
   * 
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-enum-params/");
    lURIBuilder.append(pChannelType);
    lURIBuilder.append('?');
    lURIBuilder.append("timeUnit=");
    lURIBuilder.append(pTimeUnit);
    lURIBuilder.append(',');
    lURIBuilder.append("extensibleEnum=");
    lURIBuilder.append(pExtensibleEnum);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }
}
