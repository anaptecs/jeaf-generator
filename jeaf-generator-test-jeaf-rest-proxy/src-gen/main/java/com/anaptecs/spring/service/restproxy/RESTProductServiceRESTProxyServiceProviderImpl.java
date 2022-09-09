/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.math.BigDecimal;
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
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;

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
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
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
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
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
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();
    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(configuration.getExternalServiceURL());
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("ChannelCode");
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
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
      lRequestBuilder.setHeader("Big-Header",
          XFun.getDatatypeConverterRegistry().getConverter(BigDecimal.class, String.class).convert(pBigDecimalHeader));
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
      lRequestBuilder.setHeader("Channel-Type",
          XFun.getDatatypeConverterRegistry().getConverter(ChannelType.class, String.class).convert(pChannelType));
    }
    else {
      lRequestBuilder.setHeader("Channel-Type", null);
    }
    if (pTimeUnit != null) {
      lRequestBuilder.setHeader("Time-Unit",
          XFun.getDatatypeConverterRegistry().getConverter(TimeUnit.class, String.class).convert(pTimeUnit));
    }
    else {
      lRequestBuilder.setHeader("Time-Unit", null);
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setHeader("Extensible-Enum", XFun.getDatatypeConverterRegistry()
          .getConverter(ExtensibleEnum.class, String.class).convert(pExtensibleEnum));
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
    lURIBuilder.append("/rest-products");
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
    lURIBuilder.append("/rest-products");
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
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-header-params/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pOffsetDateTime != null) {
      lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
          .getConverter(OffsetDateTime.class, String.class).convert(pOffsetDateTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Date-Time", null);
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetTime.class, String.class).convert(pOffsetTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Time", null);
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDateTime.class, String.class).convert(pLocalDateTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Date-Time", null);
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalTime.class, String.class).convert(pLocalTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Time", null);
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDate.class, String.class).convert(pLocalDate));
    }
    else {
      lRequestBuilder.setHeader("Local-Date", null);
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          XFun.getDatatypeConverterRegistry().getConverter(Calendar.class, String.class).convert(pCalendar));
    }
    else {
      lRequestBuilder.setHeader("Calendar", null);
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date",
          XFun.getDatatypeConverterRegistry().getConverter(java.util.Date.class, String.class).convert(pUtilDate));
    }
    else {
      lRequestBuilder.setHeader("Util-Date", null);
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp",
          XFun.getDatatypeConverterRegistry().getConverter(Timestamp.class, String.class).convert(pSQLTimestamp));
    }
    else {
      lRequestBuilder.setHeader("SQL-Timestamp", null);
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time",
          XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class).convert(pSQLTime));
    }
    else {
      lRequestBuilder.setHeader("SQL-Time", null);
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date",
          XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class).convert(pSQLDate));
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
    lURIBuilder.append("/rest-products");
    lURIBuilder.append('/');
    lURIBuilder.append("test-date-header-params-beans/");
    lURIBuilder.append(pPath);
    lRequestBuilder.setUri(lURIBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
    if (pHeaderParams != null) {
      if (pHeaderParams.getOffsetDateTime() != null) {
        lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pHeaderParams.getOffsetDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Date-Time", null);
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pHeaderParams.getOffsetTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Time", null);
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pHeaderParams.getLocalDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date-Time", null);
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pHeaderParams.getLocalTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Time", null);
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pHeaderParams.getLocalDate()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date", null);
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(java.util.Date.class, String.class).convert(pHeaderParams.getUtilDate()));
      }
      else {
        lRequestBuilder.setHeader("Util-Date", null);
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar", XFun.getDatatypeConverterRegistry()
            .getConverter(Calendar.class, String.class).convert(pHeaderParams.getCalendar()));
      }
      else {
        lRequestBuilder.setHeader("Calendar", null);
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp", XFun.getDatatypeConverterRegistry()
            .getConverter(Timestamp.class, String.class).convert(pHeaderParams.getSqlTimestamp()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Timestamp", null);
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time", XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class)
            .convert(pHeaderParams.getSqlTime()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Time", null);
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class)
            .convert(pHeaderParams.getSqlDate()));
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
