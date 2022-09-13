/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;

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
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.LocalBeanParamType;
import com.anaptecs.spring.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class implements a proxy for an REST Service. The proxy is implemented as Spring services. This way to developers it
 * looks like a plain Spring Service.
 * 
 * This implementation deals with everything that is required to call the external REST service including the following
 * things:
 * <ul>
 * <li>Serialization / deserialization between Java and JSON</li>
 * <li>Proper connection pooling and timeouts for HTTP requests</li>
 * <li>Proper setting of HTTP header</li>
 * <li>Circuit breaker in case of availabilities problems of the REST service</li>
 * </ul>
 * 
 * However, as an transactional context can not be propagated to another REST resource developers till have to take care
 * about proper transaction handling if needed.
 */
@Service
public class ProductServiceRESTProxy implements ProductService {
  /**
   * Logger for this class.
   */
  private static final Logger logger = LoggerFactory.getLogger(ProductServiceHttpClient.class);

  /**
   * Reference to object holding all the required configuration values to delegate request to external REST service.
   */
  @Inject
  private ProductServiceConfiguration configuration;

  /**
   * HTTP client is used to handle communication to REST service.
   */
  @Inject
  private ProductServiceHttpClient httpClient;

  /**
   * Object mapper is used for serialization and deserialization of objects from Java to JSON and vice versa.
   */
  @Inject
  private ObjectMapper objectMapper;

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
    // Set HTTP header(s)
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
    // Set HTTP header(s)
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
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pProduct into request body.
      String lRequestBody = objectMapper.writeValueAsString(pProduct);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, Boolean.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
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
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.addParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pContext != null) {
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      else {
        lRequestBuilder.setHeader("token", null);
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", null);
      }
    }
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
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("ChannelCode");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pChannelCode into request body.
      String lRequestBody = objectMapper.writeValueAsString(pChannelCode);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, ChannelCode.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
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
    // Set HTTP header(s)
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
    // Set HTTP header(s)
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
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.addParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pContext != null) {
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      else {
        lRequestBuilder.setHeader("token", null);
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", null);
      }
    }
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
    if (pBeanParam != null) {
      if (pBeanParam.getOldStyle() != null) {
        lRequestBuilder.addParameter("q2", pBeanParam.getOldStyle());
      }
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pBeanParam != null) {
      if (pBeanParam.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pBeanParam.getAccessToken());
      }
      else {
        lRequestBuilder.setHeader("token", null);
      }
      if (pBeanParam.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pBeanParam.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", null);
      }
    }
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
    // Set HTTP header(s)
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
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("deprecated/body");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pBody into request body.
      String lRequestBody = objectMapper.writeValueAsString(pBody);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
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
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("deprecated/complexBody");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pProduct into request body.
      String lRequestBody = objectMapper.writeValueAsString(pProduct);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      httpClient.executeNoResponseContentRequest(lRequest, null, 200);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
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
    // Set HTTP header(s)
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
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.addParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pContext != null) {
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      else {
        lRequestBuilder.setHeader("token", null);
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", null);
      }
      if (pContext.getSpecificHeader() != null) {
        lRequestBuilder.setHeader("specificHeader", pContext.getSpecificHeader());
      }
      else {
        lRequestBuilder.setHeader("specificHeader", null);
      }
    }
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
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("ChannelCodeObject");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pChannelCode into request body.
      String lRequestBody = objectMapper.writeValueAsString(pChannelCode);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, ChannelCode.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
  }

  /**
   * 
   * @param pCurrencies
   * @return {@link CurrencyCode}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("currencies");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pCurrencies into request body.
      String lRequestBody = objectMapper.writeValueAsString(pCurrencies);
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
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
  }

  /**
   * 
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("currencies/valid");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pCurrency into request body.
      String lRequestBody = objectMapper.writeValueAsString(pCurrency);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, CurrencyCode.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
  }

  /**
   * 
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    URI lRequestURI = null;
    try {
      // Create builder for POST request
      ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
      // Build URI of request
      StringBuilder lURIBuilder = new StringBuilder();
      lURIBuilder.append(configuration.getExternalServiceURL());
      lURIBuilder.append("/products");
      lURIBuilder.append('/');
      lURIBuilder.append("codeTypeUsages");
      lRequestBuilder.setUri(lURIBuilder.toString());
      lRequestURI = lRequestBuilder.getUri();
      // Set HTTP header(s)
      lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
      // Convert parameter pStringCode into request body.
      String lRequestBody = objectMapper.writeValueAsString(pStringCode);
      lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);
      // Execute request and return result.
      ClassicHttpRequest lRequest = lRequestBuilder.build();
      return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, IntegerCodeType.class);
    }
    catch (IOException e) {
      logger.error("Unable to serialize object(s) to JSON.", e);
      ProblemBuilder lProblemBuilder = Problem.builder();
      lProblemBuilder.withStatus(Status.INTERNAL_SERVER_ERROR);
      lProblemBuilder.withType(lRequestURI);
      lProblemBuilder.withDetail(e.getMessage());
      throw lProblemBuilder.build();
    }
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
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pBeanParam != null) {
      if (pBeanParam.getLocalKey() != null) {
        lRequestBuilder.setHeader("localKey", pBeanParam.getLocalKey());
      }
      else {
        lRequestBuilder.setHeader("localKey", null);
      }
      if (pBeanParam.getLocalID() != null) {
        lRequestBuilder.setHeader("localID", pBeanParam.getLocalID());
      }
      else {
        lRequestBuilder.setHeader("localID", null);
      }
    }
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
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pParent != null) {
      if (pParent.getNovaKey() != null) {
        lRequestBuilder.setHeader("novaKey", pParent.getNovaKey());
      }
      else {
        lRequestBuilder.setHeader("novaKey", null);
      }
      if (pParent.getTkID() != null) {
        lRequestBuilder.setHeader("tkID", pParent.getTkID());
      }
      else {
        lRequestBuilder.setHeader("tkID", null);
      }
    }
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
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pChild != null) {
      if (pChild.getNovaKey() != null) {
        lRequestBuilder.setHeader("novaKey", pChild.getNovaKey());
      }
      else {
        lRequestBuilder.setHeader("novaKey", null);
      }
      if (pChild.getTkID() != null) {
        lRequestBuilder.setHeader("tkID", pChild.getTkID());
      }
      else {
        lRequestBuilder.setHeader("tkID", null);
      }
      if (pChild.getChildProperty() != null) {
        lRequestBuilder.setHeader("X-Child-Property", pChild.getChildProperty());
      }
      else {
        lRequestBuilder.setHeader("X-Child-Property", null);
      }
    }
    // Execute request and return result.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, null, 200, String.class);
  }

  /**
   * 
   * @param pPath
   * @param pStartTimestamp
   * @param pStartTime
   * @param pLocalStartTimestamp
   * @param pLocalStartTime
   * @param pLocalStartDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-query-params/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pStartTimestamp != null) {
      lRequestBuilder.addParameter("startTimestamp", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.addParameter("startTime", DateTimeFormatter.ISO_OFFSET_TIME.format(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.addParameter("localStartTimestamp", DateTimeFormatter.ISO_DATE_TIME.format(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.addParameter("localStartTime", DateTimeFormatter.ISO_TIME.format(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.addParameter("localStartDate", DateTimeFormatter.ISO_DATE.format(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.addParameter("calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.addParameter("utilDate", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.addParameter("sqlTimestamp",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.addParameter("sqlTime", new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.addParameter("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pSQLDate));
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pPath
   * @param pQueryParams
   */
  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-query-params-beans/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pQueryParams != null) {
      if (pQueryParams.getOffsetDateTime() != null) {
        lRequestBuilder.addParameter("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.addParameter("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.addParameter("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.addParameter("localTime", DateTimeFormatter.ISO_TIME.format(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.addParameter("localDate", DateTimeFormatter.ISO_DATE.format(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.addParameter("utilDate",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.addParameter("calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getCalendar().getTime()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.addParameter("sqlTimestamp",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTimestamp()));
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.addParameter("sqlTime",
            new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTime()));
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.addParameter("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pQueryParams.getSqlDate()));
      }
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pPath
   * @param pOffsetDateTime
   * @param pOffsetTime
   * @param pLocalDateTime
   * @param pLocalTime
   * @param pLocalDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-header-params/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pOffsetDateTime != null) {
      lRequestBuilder.setHeader("Offset-Date-Time", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pOffsetDateTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Date-Time", null);
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time", DateTimeFormatter.ISO_OFFSET_TIME.format(pOffsetTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Time", null);
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time", DateTimeFormatter.ISO_DATE_TIME.format(pLocalDateTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Date-Time", null);
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pLocalTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Time", null);
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pLocalDate));
    }
    else {
      lRequestBuilder.setHeader("Local-Date", null);
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    else {
      lRequestBuilder.setHeader("Calendar", null);
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    else {
      lRequestBuilder.setHeader("Util-Date", null);
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pSQLTimestamp));
    }
    else {
      lRequestBuilder.setHeader("SQL-Timestamp", null);
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time", new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pSQLTime));
    }
    else {
      lRequestBuilder.setHeader("SQL-Time", null);
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date", new SimpleDateFormat("yyyy-MM-dd").format(pSQLDate));
    }
    else {
      lRequestBuilder.setHeader("SQL-Date", null);
    }
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pPath
   * @param pHeaderParams
   */
  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-header-params-beans/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pHeaderParams != null) {
      if (pHeaderParams.getOffsetDateTime() != null) {
        lRequestBuilder.setHeader("Offset-Date-Time",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pHeaderParams.getOffsetDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Date-Time", null);
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pHeaderParams.getOffsetTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Time", null);
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time",
            DateTimeFormatter.ISO_DATE_TIME.format(pHeaderParams.getLocalDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date-Time", null);
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pHeaderParams.getLocalTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Time", null);
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pHeaderParams.getLocalDate()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date", null);
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getUtilDate()));
      }
      else {
        lRequestBuilder.setHeader("Util-Date", null);
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getCalendar().getTime()));
      }
      else {
        lRequestBuilder.setHeader("Calendar", null);
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getSqlTimestamp()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Timestamp", null);
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time",
            new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pHeaderParams.getSqlTime()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Time", null);
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", new SimpleDateFormat("yyyy-MM-dd").format(pHeaderParams.getSqlDate()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Date", null);
      }
    }
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }
}
