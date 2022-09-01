/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

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
import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;
import com.anaptecs.spring.service.ChildBeanParameterType;
import com.anaptecs.spring.service.LocalBeanParamType;

/**
 * Class implements a service provider that acts as proxy for REST service ProductService.
 */
public final class ProductServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, ProductServiceRESTProxyServiceProvider {
  /**
   * Reference to the object that identifies this component. The reference is never null.
   */
  private static final ComponentID COMPONENT_ID;
  /**
   * Static initializer is used to create the components ComponentID object and its trace object.
   */
  static {
    // Create Component ID and trace object.
    Package lBasePackage = ProductServiceRESTProxyServiceProviderImpl.class.getPackage();
    COMPONENT_ID = new ComponentID("ProductServiceRESTProxyServiceProviderImpl", lBasePackage.getName());
  }

  /**
   * Reference to object holding all the required configuration values to delegate request to external REST service.
   */
  private ProductServiceConfiguration configuration;

  /**
   * HTTP client is used to handle communication to REST service.
   */
  private ProductServiceHttpClient httpClient;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Initialize configuration and http client.
    Configuration lComponentConfiguration = XFun.getConfigurationProvider().getComponentConfiguration(COMPONENT_ID);
    configuration = new ProductServiceConfiguration(lComponentConfiguration);
    httpClient = new ProductServiceHttpClient(configuration);
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
   * @return {@link Product}
   */
  @Override
  public List<Product> getProducts( ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
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
    lURIBuilder.append("/products");
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
    lURIBuilder.append("/products");
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
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("sortiment/");
    lURIBuilder.append(pContext.getPathParam());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addParameter("q1", pContext.getQueryParam());
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
    lURIBuilder.append("/products");
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
    lURIBuilder.append("/products");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String deprecatedOperation( ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/operation");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * 
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/context");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addParameter("q1", pContext.getQueryParam());
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
    return httpClient.executeSingleObjectResultRequest(lRequest, lLocalContext, 200, String.class);
  }

  /**
   * 
   * @param pBeanParam
   */
  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/beanParams");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addParameter("q2", pBeanParam.getOldStyle());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("token", pBeanParam.getAccessToken());
    lRequestBuilder.setHeader("lang",
        XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class).convert(pBeanParam.getLanguage()));
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String deprecatedParams( @Deprecated int pParam1 ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/params");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("param1", String.valueOf(pParam1));
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * 
   * @param pBody
   * @return {@link String}
   */
  @Override
  public String deprecatedBody( @Deprecated String pBody ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/body");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pBody into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pBody);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * 
   * 
   * @param pProduct
   */
  @Override
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/complexBody");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pProduct into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pProduct);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @return {@link Product}
   */
  @Deprecated
  @Override
  public Product deprecatedComplexReturn( ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("deprecated/complexReturn");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, Product.class);
  }

  /**
   * 
   * @param pContext
   */
  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
    // Create builder for PATCH request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.patch();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("specific/");
    lURIBuilder.append(pContext.getPathParam());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addParameter("q1", pContext.getQueryParam());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("token", pContext.getAccessToken());
    lRequestBuilder.setHeader("lang",
        XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class).convert(pContext.getLanguage()));
    lRequestBuilder.setHeader("specificHeader", pContext.getSpecificHeader());
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
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, lLocalContext, 200);
  }

  /**
   * 
   * @param pChannelCode Channel Code that should be created.
   * 
   * @return {@link ChannelCode} Created channel code
   * 
   */
  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("ChannelCodeObject");
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
   * @param pCurrencies
   * @return {@link CurrencyCode}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("currencies");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pCurrencies into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pCurrencies);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
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
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("currencies/valid");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pCurrency into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pCurrency);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, CurrencyCode.class);
  }

  /**
   * 
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("codeTypeUsages");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Convert parameter pStringCode into request body.
    String lRequestBody = JSONTools.getJSONTools().writeObjectToString(pStringCode);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, IntegerCodeType.class);
  }

  /**
   * 
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("LocalBeanParam");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("localKey", pBeanParam.getLocalKey());
    lRequestBuilder.setHeader("localID", pBeanParam.getLocalID());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * 
   * @param pParent
   * @return {@link String}
   */
  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("ExternalBeanParam");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("novaKey", pParent.getNovaKey());
    lRequestBuilder.setHeader("tkID", pParent.getTkID());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * 
   * @param pChild
   * @return {@link String}
   */
  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("ChildBeanParam");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    lRequestBuilder.setHeader("novaKey", pChild.getNovaKey());
    lRequestBuilder.setHeader("tkID", pChild.getTkID());
    lRequestBuilder.setHeader("X-Child-Property", pChild.getChildProperty());
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }
}
