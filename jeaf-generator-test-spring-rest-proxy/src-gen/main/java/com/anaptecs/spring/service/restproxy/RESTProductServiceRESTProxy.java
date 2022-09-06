/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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

import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.RESTProductService;
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
public class RESTProductServiceRESTProxy implements RESTProductService {
  /**
   * Logger for this class.
   */
  private static final Logger logger = LoggerFactory.getLogger(RESTProductServiceHttpClient.class);

  /**
   * Reference to object holding all the required configuration values to delegate request to external REST service.
   */
  @Inject
  private RESTProductServiceConfiguration configuration;

  /**
   * HTTP client is used to handle communication to REST service.
   */
  @Inject
  private RESTProductServiceHttpClient httpClient;

  /**
   * Object mapper is used for serialization and deserialization of objects from Java to JSON and vice versa.
   */
  @Inject
  private ObjectMapper objectMapper;

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
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addParameter("maxResult", String.valueOf(pMaxResultSize));
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
    lURIBuilder.append("/rest-products");
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
      lURIBuilder.append("/rest-products");
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
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("sortiment/");
    lURIBuilder.append(pContext.getPathParam());
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pContext.getQueryParam() != null) {
      lRequestBuilder.addParameter("q1", pContext.getQueryParam());
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
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
      lURIBuilder.append("/rest-products");
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
    lURIBuilder.append("/rest-products");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
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
    // Set HTTP header(s)
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
    // Set HTTP header(s)
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
    // Set HTTP header(s)
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
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pLocaleQueryParam != null) {
      lRequestBuilder.addParameter("locale", pLocaleQueryParam.toString());
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pBigDecimalHeader != null) {
      lRequestBuilder.setHeader("Big-Header", pBigDecimalHeader.toString());
    }
    else {
      lRequestBuilder.setHeader("Big-Header", null);
    }
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
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pTimeUnit != null) {
      lRequestBuilder.addParameter("timeUnit", pTimeUnit.toString());
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.addParameter("extensibleEnum", pExtensibleEnum.toString());
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @Override
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-enum-header-params");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pChannelType != null) {
      lRequestBuilder.setHeader("Channel-Type", pChannelType.toString());
    }
    else {
      lRequestBuilder.setHeader("Channel-Type", null);
    }
    if (pTimeUnit != null) {
      lRequestBuilder.setHeader("Time-Unit", pTimeUnit.toString());
    }
    else {
      lRequestBuilder.setHeader("Time-Unit", null);
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setHeader("Extensible-Enum", pExtensibleEnum.toString());
    }
    else {
      lRequestBuilder.setHeader("Extensible-Enum", null);
    }
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }

  /**
   * 
   * @param pLocalStartTimestamp
   * @param pStartTimestamp
   * @param pLocalStartTime
   * @param pStartTime
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLDate
   * @param pSQLTime
   * @param pSQLTimestamp
   */
  @Override
  public void testDateQueryParams( LocalDateTime pLocalStartTimestamp, OffsetDateTime pStartTimestamp,
      LocalTime pLocalStartTime, OffsetTime pStartTime, Calendar pCalendar, java.util.Date pUtilDate, Date pSQLDate,
      Time pSQLTime, Timestamp pSQLTimestamp ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-query-params");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Add query parameter(s) to request
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.addParameter("localStartTimestamp", pLocalStartTimestamp.toString());
    }
    if (pStartTimestamp != null) {
      lRequestBuilder.addParameter("startTimestamp", pStartTimestamp.toString());
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.addParameter("localStartTime", pLocalStartTime.toString());
    }
    if (pStartTime != null) {
      lRequestBuilder.addParameter("startTime", pStartTime.toString());
    }
    if (pCalendar != null) {
      lRequestBuilder.addParameter("calendar", pCalendar.toString());
    }
    if (pUtilDate != null) {
      lRequestBuilder.addParameter("utilDate", pUtilDate.toString());
    }
    if (pSQLDate != null) {
      lRequestBuilder.addParameter("sqlDate", pSQLDate.toString());
    }
    if (pSQLTime != null) {
      lRequestBuilder.addParameter("pSQLTime", pSQLTime.toString());
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.addParameter("pSQLTimestamp", pSQLTimestamp.toString());
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    // Execute request.
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    httpClient.executeNoResponseContentRequest(lRequest, null, 200);
  }
}
