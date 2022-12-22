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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.RESTRequestExecutor;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
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
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.MultivaluedQueryParamsBean;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;

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
 * However, as an transactional context can not be propagated to another REST resource developers still have to take
 * care about proper transaction handling if needed.
 */
@Service
public class RESTProductServiceRESTProxy implements RESTProductService {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  private final RESTRequestExecutor requestExecutor;

  /**
   * Initialize object.
   * 
   * @param pRequestExecutor Dependency on concrete {@link RESTRequestExecutor} implementation that should be used.
   */
  public RESTProductServiceRESTProxy( RESTRequestExecutor pRequestExecutor ) {
    requestExecutor = pRequestExecutor;
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
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(RESTProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    lRequestBuilder.addQueryParam("maxResult", String.valueOf(pMaxResultSize));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    List<Product> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, Product.class);
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
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, Product.class);
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
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
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, Boolean.class);
  }

  /**
   * 
   * @param pContext
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
        lRequestBuilder.addQueryParam("q1", pContext.getQueryParam());
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
      else {
        lRequestBuilder.setHeader("token", (String) null);
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", (String) null);
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, Sortiment.class);
  }

  /**
   * 
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
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, ChannelCode.class);
  }

  /**
  * 
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
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
  * 
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
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
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
    List<CurrencyCode> lResult =
        requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, CurrencyCode.class);
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
    List<CurrencyCode> lResult =
        requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, CurrencyCode.class);
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
      lRequestBuilder.addQueryParam("locale", pLocaleQueryParam.toString());
    }
    // Set HTTP header(s)
    if (pBigDecimalHeader != null) {
      lRequestBuilder.setHeader("Big-Header", pBigDecimalHeader.toString());
    }
    else {
      lRequestBuilder.setHeader("Big-Header", (String) null);
    }
    // Handle cookie parameters
    lRequestBuilder.setCookie("giveMeMoreCookies", String.valueOf(pIntCookieParam));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
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
      lRequestBuilder.addQueryParam("timeUnit", pTimeUnit.toString());
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.addQueryParam("extensibleEnum", pExtensibleEnum.toString());
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
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
      lRequestBuilder.setHeader("Channel-Type", pChannelType.toString());
    }
    else {
      lRequestBuilder.setHeader("Channel-Type", (String) null);
    }
    if (pTimeUnit != null) {
      lRequestBuilder.setHeader("Time-Unit", pTimeUnit.toString());
    }
    else {
      lRequestBuilder.setHeader("Time-Unit", (String) null);
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setHeader("Extensible-Enum", pExtensibleEnum.toString());
    }
    else {
      lRequestBuilder.setHeader("Extensible-Enum", (String) null);
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
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
      lRequestBuilder.addQueryParam("startTimestamp", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.addQueryParam("startTime", DateTimeFormatter.ISO_OFFSET_TIME.format(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.addQueryParam("localStartTimestamp",
          DateTimeFormatter.ISO_DATE_TIME.format(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.addQueryParam("localStartTime", DateTimeFormatter.ISO_TIME.format(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.addQueryParam("localStartDate", DateTimeFormatter.ISO_DATE.format(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.addQueryParam("calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.addQueryParam("utilDate", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.addQueryParam("sqlTimestamp",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.addQueryParam("sqlTime", new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.addQueryParam("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pSQLDate));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
   * 
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
        lRequestBuilder.addQueryParam("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.addQueryParam("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.addQueryParam("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.addQueryParam("localTime", DateTimeFormatter.ISO_TIME.format(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.addQueryParam("localDate", DateTimeFormatter.ISO_DATE.format(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.addQueryParam("utilDate",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.addQueryParam("calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getCalendar().getTime()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.addQueryParam("sqlTimestamp",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTimestamp()));
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.addQueryParam("sqlTime",
            new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTime()));
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.addQueryParam("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pQueryParams.getSqlDate()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
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
      lRequestBuilder.setHeader("Offset-Date-Time", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pOffsetDateTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Date-Time", (String) null);
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time", DateTimeFormatter.ISO_OFFSET_TIME.format(pOffsetTime));
    }
    else {
      lRequestBuilder.setHeader("Offset-Time", (String) null);
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time", DateTimeFormatter.ISO_DATE_TIME.format(pLocalDateTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Date-Time", (String) null);
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pLocalTime));
    }
    else {
      lRequestBuilder.setHeader("Local-Time", (String) null);
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pLocalDate));
    }
    else {
      lRequestBuilder.setHeader("Local-Date", (String) null);
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    else {
      lRequestBuilder.setHeader("Calendar", (String) null);
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    else {
      lRequestBuilder.setHeader("Util-Date", (String) null);
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pSQLTimestamp));
    }
    else {
      lRequestBuilder.setHeader("SQL-Timestamp", (String) null);
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time", new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pSQLTime));
    }
    else {
      lRequestBuilder.setHeader("SQL-Time", (String) null);
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date", new SimpleDateFormat("yyyy-MM-dd").format(pSQLDate));
    }
    else {
      lRequestBuilder.setHeader("SQL-Date", (String) null);
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
   * 
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
        lRequestBuilder.setHeader("Offset-Date-Time",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pHeaderParams.getOffsetDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Date-Time", (String) null);
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pHeaderParams.getOffsetTime()));
      }
      else {
        lRequestBuilder.setHeader("Offset-Time", (String) null);
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time",
            DateTimeFormatter.ISO_DATE_TIME.format(pHeaderParams.getLocalDateTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date-Time", (String) null);
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pHeaderParams.getLocalTime()));
      }
      else {
        lRequestBuilder.setHeader("Local-Time", (String) null);
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pHeaderParams.getLocalDate()));
      }
      else {
        lRequestBuilder.setHeader("Local-Date", (String) null);
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getUtilDate()));
      }
      else {
        lRequestBuilder.setHeader("Util-Date", (String) null);
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getCalendar().getTime()));
      }
      else {
        lRequestBuilder.setHeader("Calendar", (String) null);
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getSqlTimestamp()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Timestamp", (String) null);
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time",
            new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pHeaderParams.getSqlTime()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Time", (String) null);
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", new SimpleDateFormat("yyyy-MM-dd").format(pHeaderParams.getSqlDate()));
      }
      else {
        lRequestBuilder.setHeader("SQL-Date", (String) null);
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
   * 
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
        lRequestBuilder.addQueryParam("q1", pContext.getQueryParam());
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
      else {
        lRequestBuilder.setHeader("token", (String) null);
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
      else {
        lRequestBuilder.setHeader("lang", (String) null);
      }
      if (pContext.getSpecificHeader() != null) {
        lRequestBuilder.setHeader("specificHeader", pContext.getSpecificHeader());
      }
      else {
        lRequestBuilder.setHeader("specificHeader", (String) null);
      }
    }
    // Handle cookie parameters
    if (pChannelTypeParam != null) {
      lRequestBuilder.setCookie("Channel-Type-Param", pChannelTypeParam.toString());
    }
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
      if (pContext.getChannelType() != null) {
        lRequestBuilder.setCookie("Channel-Type", pContext.getChannelType().toString());
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }

  /**
   * 
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
      lRequestBuilder.addQueryParam("query1", query1);
    }
    lRequestBuilder.addQueryParam("query2", String.valueOf(query2));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
   * @param pComplextBookingID
   * @return {@link Boolean}
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
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, Boolean.class);
  }

  /**
   * 
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
    else {
      lRequestBuilder.setHeader("BookingID", (String) null);
    }
    if (pBookingCode != null) {
      lRequestBuilder.setHeader("BookingCode", pBookingCode.getCode());
    }
    else {
      lRequestBuilder.setHeader("BookingCode", (String) null);
    }
    if (pDoubleCode != null) {
      lRequestBuilder.setHeader("DoubleCode", pDoubleCode.getCode());
    }
    else {
      lRequestBuilder.setHeader("DoubleCode", (String) null);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      else {
        lRequestBuilder.setHeader("bookingID", (String) null);
      }
      if (pContext.getBookingCode() != null) {
        lRequestBuilder.setHeader("bookingCode", pContext.getBookingCode().getCode());
      }
      else {
        lRequestBuilder.setHeader("bookingCode", (String) null);
      }
      if (pContext.getDoubleCode() != null) {
        lRequestBuilder.setHeader("DoubleCode", pContext.getDoubleCode().getCode());
      }
      else {
        lRequestBuilder.setHeader("DoubleCode", (String) null);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      lRequestBuilder.addQueryParam("bookingCode", pBookingCode.getCode());
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
        lRequestBuilder.addQueryParam("bookingCode", pBeanParam.getBookingCode().getCode());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      lRequestBuilder.addQueryParam("intValues", pIntValues);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      lRequestBuilder.addQueryParam("strings", pStrings);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      lRequestBuilder.addQueryParam("integers", pIntegers);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
        lRequestBuilder.addQueryParam("intArray", pBean.getIntArray());
      }
      if (pBean.getStrings() != null) {
        lRequestBuilder.addQueryParam("strings", pBean.getStrings());
      }
      if (pBean.getIntegers() != null) {
        lRequestBuilder.addQueryParam("integers", Arrays.asList(pBean.getIntegers()));
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @return {@link String}
   */
  @Override
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs ) {
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
      List<String> pCodesAsBasicType = new ArrayList<String>();
      for (IntegerCodeType lNext : pCodes) {
        pCodesAsBasicType.add(String.valueOf(lNext.getCode()));
      }
      lRequestBuilder.addQueryParam("codes", pCodesAsBasicType);
    }
    if (pLongCodes != null) {
      Set<Long> pLongCodesAsBasicType = new HashSet<Long>();
      for (LongCode lNext : pLongCodes) {
        pLongCodesAsBasicType.add(lNext.getCode());
      }
      lRequestBuilder.addQueryParam("longCodes", pLongCodesAsBasicType);
    }
    if (pBookingIDs != null) {
      List<String> pBookingIDsAsBasicType = new ArrayList<String>();
      for (BookingID lNext : pBookingIDs) {
        pBookingIDsAsBasicType.add(lNext.getBookingID());
      }
      lRequestBuilder.addQueryParam("bookingIDs", pBookingIDsAsBasicType);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
        Set<String> lLongCodes = new HashSet<String>();
        for (LongCode lNext : pQueryBean.getLongCodes()) {
          lLongCodes.add(lNext.getCode().toString());
        }
        lRequestBuilder.addQueryParam("longCodes", lLongCodes);
      }
      if (pQueryBean.getCodes() != null) {
        Set<String> lCodes = new HashSet<String>();
        for (IntegerCodeType lNext : pQueryBean.getCodes()) {
          lCodes.add(String.valueOf(lNext.getCode()));
        }
        lRequestBuilder.addQueryParam("codes", lCodes);
      }
      if (pQueryBean.getDoubleCodes() != null) {
        Set<String> lDoubleCodes = new HashSet<String>();
        for (DoubleCode lNext : pQueryBean.getDoubleCodes()) {
          lDoubleCodes.add(lNext.getCode().toString());
        }
        lRequestBuilder.addQueryParam("doubleCodes", lDoubleCodes);
      }
      if (pQueryBean.getBookingIDs() != null) {
        Set<String> lBookingIDs = new HashSet<String>();
        for (BookingID lNext : pQueryBean.getBookingIDs()) {
          lBookingIDs.add(lNext.getBookingID());
        }
        lRequestBuilder.addQueryParam("bookingIDs", lBookingIDs);
      }
      if (pQueryBean.getBookingIDsArray() != null) {
        Set<String> lBookingIDsArray = new HashSet<String>();
        for (BookingID lNext : pQueryBean.getBookingIDsArray()) {
          lBookingIDsArray.add(lNext.getBookingID());
        }
        lRequestBuilder.addQueryParam("bookingIDsArray", lBookingIDsArray);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
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
      else {
        lRequestBuilder.setHeader("names", (String) null);
      }
      if (pMultiValuedBean.getInts() != null) {
        lRequestBuilder.setHeader("ints", pMultiValuedBean.getInts());
      }
      else {
        lRequestBuilder.setHeader("ints", (String) null);
      }
      if (pMultiValuedBean.getDoubles() != null) {
        lRequestBuilder.setHeader("doubles", Arrays.asList(pMultiValuedBean.getDoubles()));
      }
      else {
        lRequestBuilder.setHeader("doubles", (String) null);
      }
      if (pMultiValuedBean.getCodes() != null) {
        List<String> lValues = new ArrayList<String>();
        for (StringCode lNext : pMultiValuedBean.getCodes()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setHeader("codes", lValues);
      }
      else {
        lRequestBuilder.setHeader("codes", (String) null);
      }
      if (pMultiValuedBean.getStringCodeList() != null) {
        List<String> lValues = new ArrayList<String>();
        for (StringCode lNext : pMultiValuedBean.getStringCodeList()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setHeader("stringCodeList", lValues);
      }
      else {
        lRequestBuilder.setHeader("stringCodeList", (String) null);
      }
      if (pMultiValuedBean.getStartDate() != null) {
        lRequestBuilder.setHeader("startDate", DateTimeFormatter.ISO_DATE.format(pMultiValuedBean.getStartDate()));
      }
      else {
        lRequestBuilder.setHeader("startDate", (String) null);
      }
      if (pMultiValuedBean.getDates() != null) {
        List<String> lValues = new ArrayList<String>();
        for (LocalDate lNext : pMultiValuedBean.getDates()) {
          lValues.add(DateTimeFormatter.ISO_DATE.format(lNext));
        }
        lRequestBuilder.setHeader("dates", lValues);
      }
      else {
        lRequestBuilder.setHeader("dates", (String) null);
      }
      if (pMultiValuedBean.getTimestamps() != null) {
        List<String> lValues = new ArrayList<String>();
        for (LocalDateTime lNext : pMultiValuedBean.getTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setHeader("timestamps", lValues);
      }
      else {
        lRequestBuilder.setHeader("timestamps", (String) null);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * 
   * @param pNames
   * @param pInts
   * @param pDoubles
   * @param pCodes
   * @param pStartDate
   * @param pTimestamps
   * @param pTimes
   * @return {@link String}
   */
  @Override
  public String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes ) {
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
    else {
      lRequestBuilder.setHeader("names", (String) null);
    }
    if (pInts != null) {
      lRequestBuilder.setHeader("ints", pInts);
    }
    else {
      lRequestBuilder.setHeader("ints", (String) null);
    }
    if (pDoubles != null) {
      lRequestBuilder.setHeader("doubles", pDoubles);
    }
    else {
      lRequestBuilder.setHeader("doubles", (String) null);
    }
    if (pCodes != null) {
      List<String> lValues = new ArrayList<String>();
      for (StringCode lNext : pCodes) {
        lValues.add(lNext.getCode().toString());
      }
      lRequestBuilder.setHeader("codes", lValues);
    }
    else {
      lRequestBuilder.setHeader("codes", (String) null);
    }
    if (pStartDate != null) {
      lRequestBuilder.setHeader("startDate", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartDate));
    }
    else {
      lRequestBuilder.setHeader("startDate", (String) null);
    }
    if (pTimestamps != null) {
      List<String> lValues = new ArrayList<String>();
      for (OffsetDateTime lNext : pTimestamps) {
        lValues.add(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lNext));
      }
      lRequestBuilder.setHeader("timestamps", lValues);
    }
    else {
      lRequestBuilder.setHeader("timestamps", (String) null);
    }
    if (pTimes != null) {
      List<String> lValues = new ArrayList<String>();
      for (OffsetTime lNext : pTimes) {
        lValues.add(DateTimeFormatter.ISO_OFFSET_TIME.format(lNext));
      }
      lRequestBuilder.setHeader("times", lValues);
    }
    else {
      lRequestBuilder.setHeader("times", (String) null);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }
}
