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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.api.executor.ContentType;
import com.anaptecs.jeaf.rest.api.executor.HttpMethod;
import com.anaptecs.jeaf.rest.api.executor.RESTRequest;
import com.anaptecs.jeaf.rest.api.executor.RESTRequest.Builder;
import com.anaptecs.jeaf.rest.api.executor.RESTRequestExecutor;
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
import com.anaptecs.spring.service.ProductService;
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
 * However, as an transactional context can not be propagated to another REST resource developers till have to take care
 * about proper transaction handling if needed.
 */
@Service
public class RESTProductServiceRESTProxy implements RESTProductService {
  @Autowired
  private RESTRequestExecutor requestExecutor;

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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Add query parameter(s) to request
    lRequestBuilder.setQueryParam("maxResult", String.valueOf(pMaxResultSize));

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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.POST, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Convert parameter pProduct into request body.
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("sortiment/");
    lPathBuilder.append(pContext.getPathParam());
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParam("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
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
    lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));

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
    // Create builder for GET request
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("ChannelCode");
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Convert parameter pChannelCode into request body.
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.HEAD, ContentType.JSON);

    // Build URI of request
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    List<CurrencyCode> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class,
        CurrencyCode.class);
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("async-currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    List<CurrencyCode> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class,
        CurrencyCode.class);
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-params");
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Add query parameter(s) to request
    if (pLocaleQueryParam != null) {
      lRequestBuilder.setQueryParam("locale", pLocaleQueryParam.toString());
    }

    // Set HTTP header(s)
    if (pBigDecimalHeader != null) {
      lRequestBuilder.setHeader("Big-Header", pBigDecimalHeader.toString());
    }
    else {
      lRequestBuilder.setHeader("Big-Header", null);
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-enum-params/");
    lPathBuilder.append(pChannelType);
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Add query parameter(s) to request
    if (pTimeUnit != null) {
      lRequestBuilder.setQueryParam("timeUnit", pTimeUnit.toString());
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setQueryParam("extensibleEnum", pExtensibleEnum.toString());
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pStartTimestamp != null) {
      lRequestBuilder.setQueryParam("startTimestamp", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.setQueryParam("startTime", DateTimeFormatter.ISO_OFFSET_TIME.format(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.setQueryParam("localStartTimestamp", DateTimeFormatter.ISO_DATE_TIME.format(
          pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.setQueryParam("localStartTime", DateTimeFormatter.ISO_TIME.format(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.setQueryParam("localStartDate", DateTimeFormatter.ISO_DATE.format(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setQueryParam("calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setQueryParam("utilDate", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setQueryParam("sqlTimestamp",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.setQueryParam("sqlTime", new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.setQueryParam("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pSQLDate));
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/rest-products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params-beans/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());

    // Add query parameter(s) to request
    if (pQueryParams != null) {
      if (pQueryParams.getOffsetDateTime() != null) {
        lRequestBuilder.setQueryParam("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.setQueryParam("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParam("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.setQueryParam("localTime", DateTimeFormatter.ISO_TIME.format(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.setQueryParam("localDate", DateTimeFormatter.ISO_DATE.format(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.setQueryParam("utilDate",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.setQueryParam("calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getCalendar().getTime()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.setQueryParam("sqlTimestamp",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTimestamp()));
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.setQueryParam("sqlTime",
            new SimpleDateFormat("HH:mm:ss.SSSXXX").format(pQueryParams.getSqlTime()));
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.setQueryParam("sqlDate", new SimpleDateFormat("yyyy-MM-dd").format(pQueryParams.getSqlDate()));
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
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
    Builder lRequestBuilder = Builder.newBuilder(ProductService.class, HttpMethod.GET, ContentType.JSON);

    // Build URI of request
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
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 200);
  }
}
