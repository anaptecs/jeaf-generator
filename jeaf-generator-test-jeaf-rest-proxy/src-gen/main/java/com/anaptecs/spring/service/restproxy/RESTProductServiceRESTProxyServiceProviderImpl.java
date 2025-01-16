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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.jeaf.RESTRequestExecutorServiceProvider;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.composite.ComplexBookingID;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.ContextWithPrimitives;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.MultivaluedQueryParamsBean;
import com.anaptecs.spring.service.MySortCriteria;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;

/**
 * Class implements a service provider that acts as proxy for REST service {@link RESTProductService}.
 */
public final class RESTProductServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, RESTProductServiceRESTProxyServiceProvider {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  @JEAFServiceProvider
  private RESTRequestExecutorServiceProvider requestExecutor;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Nothing to do.
  }

  /**
   * Method checks state of this service provider implementation.
   *
   * @return {@link HealthCheckResult} Result of the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    return null;
  }

  /**
   * Operation returns all available product.
   *
   * @param pMaxResultSize
   * @return {@link List<Product>} My default comment
   */
  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.setQueryParameter("maxResult", String.valueOf(pMaxResultSize));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Product.class);
    List<Product> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @Override
  public Product getProduct( String pProductID ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append(pProductID);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Product.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pProduct My default comment
   * @return boolean
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pProduct as request body.
    lRequestBuilder.setBody(pProduct);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(boolean.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("sortiment/");
    lPathBuilder.append(pContext.getPathParam());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      // First we process custom headers then the explicit ones.
      for (Map.Entry<String, String> lNextEntry : pContext.getCustomHeaders().entrySet()) {
        lRequestBuilder.setHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
      }
      if (pContext.getIntCode() != null) {
        lRequestBuilder.setHeader("intCode", pContext.getIntCode().getCode());
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Sortiment.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("ChannelCode");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pChannelCode as request body.
    lRequestBuilder.setBody(pChannelCode);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(ChannelCode.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   */
  @Override
  public void ping( ) {
    // Create builder for HEAD request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.HEAD, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   */
  @Override
  public void testInit( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-init");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(CurrencyCode.class);
    List<CurrencyCode> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("async-currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(CurrencyCode.class);
    List<CurrencyCode> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pLocaleQueryParam != null) {
      lRequestBuilder.setQueryParameter("locale",
          XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class).convert(pLocaleQueryParam));
    }
    // Set HTTP header(s)
    if (pBigDecimalHeader != null) {
      lRequestBuilder.setHeader("Big-Header",
          XFun.getDatatypeConverterRegistry().getConverter(BigDecimal.class, String.class).convert(pBigDecimalHeader));
    }
    // Handle cookie parameters
    lRequestBuilder.setCookie("giveMeMoreCookies", String.valueOf(pIntCookieParam));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-enum-params/");
    lPathBuilder.append(pChannelType);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pTimeUnit != null) {
      lRequestBuilder.setQueryParameter("timeUnit",
          XFun.getDatatypeConverterRegistry().getConverter(TimeUnit.class, String.class).convert(pTimeUnit));
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setQueryParameter("extensibleEnum", XFun.getDatatypeConverterRegistry()
          .getConverter(ExtensibleEnum.class, String.class).convert(pExtensibleEnum));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @Override
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-enum-header-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pChannelType != null) {
      lRequestBuilder.setHeader("Channel-Type",
          XFun.getDatatypeConverterRegistry().getConverter(ChannelType.class, String.class).convert(pChannelType));
    }
    if (pTimeUnit != null) {
      lRequestBuilder.setHeader("Time-Unit",
          XFun.getDatatypeConverterRegistry().getConverter(TimeUnit.class, String.class).convert(pTimeUnit));
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setHeader("Extensible-Enum", XFun.getDatatypeConverterRegistry()
          .getConverter(ExtensibleEnum.class, String.class).convert(pExtensibleEnum));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
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
   * @param pCalendars
   */
  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<Calendar> pCalendars ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("startTimestamp", XFun.getDatatypeConverterRegistry()
          .getConverter(OffsetDateTime.class, String.class).convert(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.setQueryParameter("startTime",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetTime.class, String.class).convert(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("localStartTimestamp", XFun.getDatatypeConverterRegistry()
          .getConverter(LocalDateTime.class, String.class).convert(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.setQueryParameter("localStartTime",
          XFun.getDatatypeConverterRegistry().getConverter(LocalTime.class, String.class).convert(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.setQueryParameter("localStartDate",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDate.class, String.class).convert(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setQueryParameter("calendar",
          XFun.getDatatypeConverterRegistry().getConverter(Calendar.class, String.class).convert(pCalendar));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setQueryParameter("utilDate",
          XFun.getDatatypeConverterRegistry().getConverter(java.util.Date.class, String.class).convert(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setQueryParameter("sqlTimestamp",
          XFun.getDatatypeConverterRegistry().getConverter(Timestamp.class, String.class).convert(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.setQueryParameter("sqlTime",
          XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class).convert(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.setQueryParameter("sqlDate",
          XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class).convert(pSQLDate));
    }
    if (pCalendars != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (Calendar lNext : pCalendars) {
        lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext.getTime()));
      }
      lRequestBuilder.setQueryParameter("calendars", lValues);
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pPath
   * @param pQueryParams
   */
  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params-beans/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pQueryParams != null) {
      if (pQueryParams.getOffsetDateTime() != null) {
        lRequestBuilder.setQueryParameter("offsetDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.setQueryParameter("localDate", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.setQueryParameter("utilDate", XFun.getDatatypeConverterRegistry()
            .getConverter(java.util.Date.class, String.class).convert(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.setQueryParameter("calendar", XFun.getDatatypeConverterRegistry()
            .getConverter(Calendar.class, String.class).convert(pQueryParams.getCalendar()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.setQueryParameter("sqlTimestamp", XFun.getDatatypeConverterRegistry()
            .getConverter(Timestamp.class, String.class).convert(pQueryParams.getSqlTimestamp()));
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.setQueryParameter("sqlTime", XFun.getDatatypeConverterRegistry()
            .getConverter(Time.class, String.class).convert(pQueryParams.getSqlTime()));
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.setQueryParameter("sqlDate", XFun.getDatatypeConverterRegistry()
            .getConverter(Date.class, String.class).convert(pQueryParams.getSqlDate()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
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
   * @param pUtilDates
   */
  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate,
      Set<java.util.Date> pUtilDates ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-header-params/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pOffsetDateTime != null) {
      lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
          .getConverter(OffsetDateTime.class, String.class).convert(pOffsetDateTime));
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetTime.class, String.class).convert(pOffsetTime));
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDateTime.class, String.class).convert(pLocalDateTime));
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalTime.class, String.class).convert(pLocalTime));
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDate.class, String.class).convert(pLocalDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          XFun.getDatatypeConverterRegistry().getConverter(Calendar.class, String.class).convert(pCalendar));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date",
          XFun.getDatatypeConverterRegistry().getConverter(java.util.Date.class, String.class).convert(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp",
          XFun.getDatatypeConverterRegistry().getConverter(Timestamp.class, String.class).convert(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time",
          XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class).convert(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date",
          XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class).convert(pSQLDate));
    }
    if (pUtilDates != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (java.util.Date lNext : pUtilDates) {
        lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext));
      }
      lRequestBuilder.setHeader("util-dates", lValues);
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pPath
   * @param pHeaderParams
   */
  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-header-params-beans/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pHeaderParams != null) {
      if (pHeaderParams.getOffsetDateTime() != null) {
        lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pHeaderParams.getOffsetDateTime()));
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pHeaderParams.getOffsetTime()));
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pHeaderParams.getLocalDateTime()));
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pHeaderParams.getLocalTime()));
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pHeaderParams.getLocalDate()));
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(java.util.Date.class, String.class).convert(pHeaderParams.getUtilDate()));
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar", XFun.getDatatypeConverterRegistry()
            .getConverter(Calendar.class, String.class).convert(pHeaderParams.getCalendar()));
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp", XFun.getDatatypeConverterRegistry()
            .getConverter(Timestamp.class, String.class).convert(pHeaderParams.getSqlTimestamp()));
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time", XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class)
            .convert(pHeaderParams.getSqlTime()));
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class)
            .convert(pHeaderParams.getSqlDate()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pChannelTypeParam
   * @param pContext
   */
  @Override
  public void testCookieParams( ChannelType pChannelTypeParam, SpecialContext pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("cookies");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      // First we process custom headers then the explicit ones.
      for (Map.Entry<String, String> lNextEntry : pContext.getCustomHeaders().entrySet()) {
        lRequestBuilder.setHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
      }
      if (pContext.getIntCode() != null) {
        lRequestBuilder.setHeader("intCode", pContext.getIntCode().getCode());
      }
      if (pContext.getSpecificHeader() != null) {
        lRequestBuilder.setHeader("specificHeader", pContext.getSpecificHeader());
      }
    }
    // Handle cookie parameters
    if (pChannelTypeParam != null) {
      lRequestBuilder.setCookie("Channel-Type-Param",
          XFun.getDatatypeConverterRegistry().getConverter(ChannelType.class, String.class).convert(pChannelTypeParam));
    }
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
      if (pContext.getChannelType() != null) {
        lRequestBuilder.setCookie("Channel-Type", XFun.getDatatypeConverterRegistry()
            .getConverter(ChannelType.class, String.class).convert(pContext.getChannelType()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @Override
  public String testOptionalQueryParams( String query1, int query2 ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-optional-query-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (query1 != null) {
      lRequestBuilder.setQueryParameter("query1", query1);
    }
    lRequestBuilder.setQueryParameter("query2", String.valueOf(query2));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pComplextBookingID
   * @return boolean
   */
  @Override
  public boolean processComplexBookingID( ComplexBookingID pComplextBookingID ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("complex/");
    lPathBuilder.append(pComplextBookingID.getBookingID());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(boolean.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @Override
  public String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("dataTypesInHeader");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pBookingID != null) {
      lRequestBuilder.setHeader("BookingID", pBookingID.getBookingID());
    }
    if (pBookingCode != null) {
      lRequestBuilder.setHeader("BookingCode", pBookingCode.getCode());
    }
    if (pDoubleCode != null) {
      lRequestBuilder.setHeader("DoubleCode", pDoubleCode.getCode());
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("dataTypesInBeanHeader");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pContext != null) {
      if (pContext.getBookingID() != null) {
        lRequestBuilder.setHeader("bookingID", pContext.getBookingID().getBookingID());
      }
      if (pContext.getBookingCode() != null) {
        lRequestBuilder.setHeader("bookingCode", pContext.getBookingCode().getCode());
      }
      if (pContext.getDoubleCode() != null) {
        lRequestBuilder.setHeader("DoubleCode", pContext.getDoubleCode().getCode());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pIntegerArray
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrays( int[] pIntegerArray ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testPrimitiveArrayAsBody");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pIntegerArray as request body.
    lRequestBuilder.setBody(pIntegerArray);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBookingCode
   * @return {@link String}
   */
  @Override
  public String testDataTypeAsQueryParam( BookingCode pBookingCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testDataTypeAsQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pBookingCode != null) {
      lRequestBuilder.setQueryParameter("bookingCode", pBookingCode.getCode());
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testDataTypeAsBeanQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pBeanParam != null) {
      if (pBeanParam.getBookingCode() != null) {
        lRequestBuilder.setQueryParameter("bookingCode", pBeanParam.getBookingCode().getCode());
      }
      lRequestBuilder.setQueryParameter("maxResults", String.valueOf(pBeanParam.getMaxResults()));
      if (pBeanParam.getSortCriteria() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (MySortCriteria lNext : pBeanParam.getSortCriteria()) {
          lValues.add(lNext.getValue());
        }
        lRequestBuilder.setQueryParameter("sortCriteria", lValues);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testPrimitiveArrayAsQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pIntValues != null) {
      lRequestBuilder.setQueryParameter("intValues", pIntValues);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pStrings
   * @return {@link String}
   */
  @Override
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testSimpleTypesAsQueryParams");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pStrings != null) {
      lRequestBuilder.setQueryParameter("strings", pStrings);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pIntegers
   * @return {@link String}
   */
  @Override
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testPrimitiveWrapperArrayAsQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pIntegers != null) {
      lRequestBuilder.setQueryParameter("integers", pIntegers);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBean
   * @return {@link String}
   */
  @Override
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMultivaluedQueryParamsBean");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pBean != null) {
      if (pBean.getIntArray() != null) {
        lRequestBuilder.setQueryParameter("intArray", pBean.getIntArray());
      }
      if (pBean.getStrings() != null) {
        lRequestBuilder.setQueryParameter("strings", pBean.getStrings());
      }
      if (pBean.getIntegers() != null) {
        lRequestBuilder.setQueryParameter("integers", pBean.getIntegers());
      }
      if (pBean.getTimeUnits() != null) {
        lRequestBuilder.setQueryParameter("timeUnits", pBean.getTimeUnits());
      }
      if (pBean.getTimeUnitArray() != null) {
        lRequestBuilder.setQueryParameter("timeUnitArray", pBean.getTimeUnitArray());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @param pTimestamps
   * @param pLocalDates
   * @return {@link String}
   */
  @Override
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMulitvaluedDataTypeAsQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (IntegerCodeType lNext : pCodes) {
        lValues.add(String.valueOf(lNext.getCode()));
      }
      lRequestBuilder.setQueryParameter("codes", lValues);
    }
    if (pLongCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (LongCode lNext : pLongCodes) {
        lValues.add(lNext.getCode());
      }
      lRequestBuilder.setQueryParameter("longCodes", lValues);
    }
    if (pBookingIDs != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (BookingID lNext : pBookingIDs) {
        lValues.add(lNext.getBookingID());
      }
      lRequestBuilder.setQueryParameter("bookingIDs", lValues);
    }
    if (pTimestamps != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (OffsetDateTime lNext : pTimestamps) {
        lValues.add(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lNext));
      }
      lRequestBuilder.setQueryParameter("timestamps", lValues);
    }
    if (pLocalDates != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (LocalDate lNext : pLocalDates) {
        lValues.add(DateTimeFormatter.ISO_DATE.format(lNext));
      }
      lRequestBuilder.setQueryParameter("localDates", lValues);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pQueryBean
   * @return {@link String}
   */
  @Override
  public String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMulitvaluedDataTypeAsBeanQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pQueryBean != null) {
      if (pQueryBean.getLongCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LongCode lNext : pQueryBean.getLongCodes()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("longCodes", lValues);
      }
      if (pQueryBean.getCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (IntegerCodeType lNext : pQueryBean.getCodes()) {
          lValues.add(String.valueOf(lNext.getCode()));
        }
        lRequestBuilder.setQueryParameter("codes", lValues);
      }
      if (pQueryBean.getDoubleCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (DoubleCode lNext : pQueryBean.getDoubleCodes()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("doubleCodes", lValues);
      }
      if (pQueryBean.getBookingIDs() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (BookingID lNext : pQueryBean.getBookingIDs()) {
          lValues.add(lNext.getBookingID());
        }
        lRequestBuilder.setQueryParameter("bookingIDs", lValues);
      }
      if (pQueryBean.getBookingIDsArray() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (BookingID lNext : pQueryBean.getBookingIDsArray()) {
          lValues.add(lNext.getBookingID());
        }
        lRequestBuilder.setQueryParameter("bookingIDsArray", lValues);
      }
      if (pQueryBean.getOffsetDateTime() != null) {
        lRequestBuilder.setQueryParameter("offsetDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pQueryBean.getOffsetDateTime()));
      }
      if (pQueryBean.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pQueryBean.getOffsetTime()));
      }
      if (pQueryBean.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pQueryBean.getLocalDateTime()));
      }
      if (pQueryBean.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pQueryBean.getLocalTime()));
      }
      if (pQueryBean.getTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDateTime lNext : pQueryBean.getTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("timestamps", lValues);
      }
      if (pQueryBean.getTimes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (OffsetTime lNext : pQueryBean.getTimes()) {
          lValues.add(DateTimeFormatter.ISO_OFFSET_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("times", lValues);
      }
      if (pQueryBean.getStartTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (OffsetDateTime lNext : pQueryBean.getStartTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("startTimestamps", lValues);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @Override
  public String testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMultiValuedHeaderFieldsInBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pMultiValuedBean != null) {
      if (pMultiValuedBean.getNames() != null) {
        lRequestBuilder.setHeader("names", pMultiValuedBean.getNames());
      }
      if (pMultiValuedBean.getInts() != null) {
        lRequestBuilder.setHeader("ints", pMultiValuedBean.getInts());
      }
      if (pMultiValuedBean.getDoubles() != null) {
        lRequestBuilder.setHeader("doubles", pMultiValuedBean.getDoubles());
      }
      if (pMultiValuedBean.getCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pMultiValuedBean.getCodes()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("codes", lValues);
      }
      if (pMultiValuedBean.getStringCodeList() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pMultiValuedBean.getStringCodeList()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("stringCodeList", lValues);
      }
      if (pMultiValuedBean.getStartDate() != null) {
        lRequestBuilder.setHeader("startDate", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pMultiValuedBean.getStartDate()));
      }
      if (pMultiValuedBean.getDates() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDate lNext : pMultiValuedBean.getDates()) {
          lValues.add(DateTimeFormatter.ISO_DATE.format(lNext));
        }
        lRequestBuilder.setHeader("dates", lValues);
      }
      if (pMultiValuedBean.getTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDateTime lNext : pMultiValuedBean.getTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setHeader("timestamps", lValues);
      }
      if (pMultiValuedBean.getCalendars() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (Calendar lNext : pMultiValuedBean.getCalendars()) {
          lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext.getTime()));
        }
        lRequestBuilder.setHeader("calendars", lValues);
      }
      if (pMultiValuedBean.getUtilDates() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (java.util.Date lNext : pMultiValuedBean.getUtilDates()) {
          lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext));
        }
        lRequestBuilder.setHeader("utilDates", lValues);
      }
      if (pMultiValuedBean.getSqlTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (Timestamp lNext : pMultiValuedBean.getSqlTimestamps()) {
          lValues.add(lNext.toString());
        }
        lRequestBuilder.setHeader("sqlTimestamps", lValues);
      }
      if (pMultiValuedBean.getTimeUnits() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (TimeUnit lNext : pMultiValuedBean.getTimeUnits()) {
          lValues.add(lNext);
        }
        lRequestBuilder.setHeader("timeUnits", lValues);
      }
      if (pMultiValuedBean.getTimeUnitArray() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (TimeUnit lNext : pMultiValuedBean.getTimeUnitArray()) {
          lValues.add(lNext);
        }
        lRequestBuilder.setHeader("timeUnitArray", lValues);
      }
      if (pMultiValuedBean.getBase64() != null) {
        lRequestBuilder.setHeader("base64", pMultiValuedBean.getBase64());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pNames
   * @param pInts
   * @param pDoubles
   * @param pCodes
   * @param pStartDate
   * @param pTimestamps
   * @param pTimes
   * @param pBase64
   * @return {@link String}
   */
  @Override
  public String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes,
      byte[] pBase64 ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMultiValuedHeaderFields");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pNames != null) {
      lRequestBuilder.setHeader("names", pNames);
    }
    if (pInts != null) {
      lRequestBuilder.setHeader("ints", pInts);
    }
    if (pDoubles != null) {
      lRequestBuilder.setHeader("doubles", pDoubles);
    }
    if (pCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (StringCode lNext : pCodes) {
        lValues.add(lNext.getCode());
      }
      lRequestBuilder.setHeader("codes", lValues);
    }
    if (pStartDate != null) {
      lRequestBuilder.setHeader("startDate",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetDateTime.class, String.class).convert(pStartDate));
    }
    if (pTimestamps != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (OffsetDateTime lNext : pTimestamps) {
        lValues.add(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lNext));
      }
      lRequestBuilder.setHeader("timestamps", lValues);
    }
    if (pTimes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (OffsetTime lNext : pTimes) {
        lValues.add(DateTimeFormatter.ISO_OFFSET_TIME.format(lNext));
      }
      lRequestBuilder.setHeader("times", lValues);
    }
    if (pBase64 != null) {
      lRequestBuilder.setHeader("BASE_64", pBase64);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBookingID
   */
  @Override
  public void testBookingIDAsPathParam( BookingID pBookingID ) {
    // Create builder for PATCH request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.PATCH, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("booking-id-as-path-param/");
    lPathBuilder.append(pBookingID.getBookingID());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pBookingID
   */
  @Override
  public void testBookingIDAsHeaderParam( BookingID pBookingID ) {
    // Create builder for PATCH request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.PATCH, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("booking-id-as-header-param");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pBookingID != null) {
      lRequestBuilder.setHeader("bookingID", pBookingID.getBookingID());
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testContextWithPrimitives( ContextWithPrimitives pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-context-with-primitives");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      lRequestBuilder.setQueryParameter("aLong", String.valueOf(pContext.getALong()));
      if (pContext.getAVeryLong() != null) {
        lRequestBuilder.setQueryParameter("aVeryLong", XFun.getDatatypeConverterRegistry()
            .getConverter(Long.class, String.class).convert(pContext.getAVeryLong()));
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      lRequestBuilder.setHeader("aBoolean", pContext.isABoolean());
      if (pContext.getABooleanWrapper() != null) {
        lRequestBuilder.setHeader("aBooleanWrapper", XFun.getDatatypeConverterRegistry()
            .getConverter(Boolean.class, String.class).convert(pContext.getABooleanWrapper()));
      }
      lRequestBuilder.setHeader("anInt", pContext.getAnInt());
      if (pContext.getAnInteger() != null) {
        lRequestBuilder.setHeader("anInteger", XFun.getDatatypeConverterRegistry()
            .getConverter(Integer.class, String.class).convert(pContext.getAnInteger()));
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pAnInt
   * @param pAnInteger
   * @param pABoolean
   * @param pBooleanWrapper
   * @param pALong
   * @param pVeryLong
   * @return {@link String}
   */
  @Override
  public String testPrimitivesAsParams( int pAnInt, Integer pAnInteger, boolean pABoolean, Boolean pBooleanWrapper,
      long pALong, Long pVeryLong ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-primitives-as-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.setQueryParameter("pALong", String.valueOf(pALong));
    if (pVeryLong != null) {
      lRequestBuilder.setQueryParameter("pVeryLong",
          XFun.getDatatypeConverterRegistry().getConverter(Long.class, String.class).convert(pVeryLong));
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader("pAnInt", pAnInt);
    if (pAnInteger != null) {
      lRequestBuilder.setHeader("pAnInteger",
          XFun.getDatatypeConverterRegistry().getConverter(Integer.class, String.class).convert(pAnInteger));
    }
    lRequestBuilder.setHeader("pABoolean", pABoolean);
    if (pBooleanWrapper != null) {
      lRequestBuilder.setHeader("pBooleanWrapper",
          XFun.getDatatypeConverterRegistry().getConverter(Boolean.class, String.class).convert(pBooleanWrapper));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }
}