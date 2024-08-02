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

import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.RESTRequestExecutor;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;
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
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;

/**
 * Class implements a proxy for REST Service {@link RESTProductService}. The proxy is implemented as Spring services.
 * This way to developers it looks like a plain Spring Service.
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
   * REST Service Proxy was generated with request / response validation enabled. The actual validation will be
   * delegated to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * Initialize object.
   *
   * @param pRequestExecutor Dependency on concrete {@link RESTRequestExecutor} implementation that should be used.
   */
  public RESTProductServiceRESTProxy( RESTRequestExecutor pRequestExecutor, ValidationExecutor pValidationExecutor ) {
    requestExecutor = pRequestExecutor;
    validationExecutor = pValidationExecutor;
  }

  /**
   * Operation returns all available product.
   *
   * @param pMaxResultSize
   * @return {@link List<Product>}
   */
  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pMaxResultSize);
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
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pProductID
   * @return {@link Product}
   */
  @Override
  public Product getProduct( String pProductID ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pProductID);
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
    Product lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pProduct
   * @return boolean
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pProduct);
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
    boolean lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pContext);
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
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
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
    Sortiment lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelCode);
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
    ChannelCode lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelCode);
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
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelCode);
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
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
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
      lRequestBuilder.setQueryParameter("locale", pLocaleQueryParam.toString());
    }
    // Set HTTP header(s)
    if (pBigDecimalHeader != null) {
      lRequestBuilder.setHeader("Big-Header", pBigDecimalHeader.toString());
    }
    // Handle cookie parameters
    lRequestBuilder.setCookie("giveMeMoreCookies", String.valueOf(pIntCookieParam));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelType, pTimeUnit, pExtensibleEnum);
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
      lRequestBuilder.setQueryParameter("timeUnit", pTimeUnit.toString());
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setQueryParameter("extensibleEnum", pExtensibleEnum.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelType, pTimeUnit, pExtensibleEnum);
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
    if (pTimeUnit != null) {
      lRequestBuilder.setHeader("Time-Unit", pTimeUnit.toString());
    }
    if (pExtensibleEnum != null) {
      lRequestBuilder.setHeader("Extensible-Enum", pExtensibleEnum.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pPath, pStartTimestamp, pStartTime,
        pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate,
        pCalendars);
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
      lRequestBuilder.setQueryParameter("startTimestamp",
          DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.setQueryParameter("startTime", DateTimeFormatter.ISO_OFFSET_TIME.format(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("localStartTimestamp",
          DateTimeFormatter.ISO_DATE_TIME.format(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.setQueryParameter("localStartTime", DateTimeFormatter.ISO_TIME.format(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.setQueryParameter("localStartDate", DateTimeFormatter.ISO_DATE.format(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setQueryParameter("calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setQueryParameter("utilDate",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setQueryParameter("sqlTimestamp", pSQLTimestamp.toString());
    }
    if (pSQLTime != null) {
      lRequestBuilder.setQueryParameter("sqlTime", pSQLTime.toString());
    }
    if (pSQLDate != null) {
      lRequestBuilder.setQueryParameter("sqlDate", pSQLDate.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pPath, pQueryParams);
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
        lRequestBuilder.setQueryParameter("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", DateTimeFormatter.ISO_TIME.format(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.setQueryParameter("localDate", DateTimeFormatter.ISO_DATE.format(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.setQueryParameter("utilDate",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.setQueryParameter("calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getCalendar().getTime()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.setQueryParameter("sqlTimestamp", pQueryParams.getSqlTimestamp().toString());
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.setQueryParameter("sqlTime", pQueryParams.getSqlTime().toString());
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.setQueryParameter("sqlDate", pQueryParams.getSqlDate().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime,
        pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
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
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time", DateTimeFormatter.ISO_OFFSET_TIME.format(pOffsetTime));
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time", DateTimeFormatter.ISO_DATE_TIME.format(pLocalDateTime));
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pLocalTime));
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pLocalDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp", pSQLTimestamp.toString());
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time", pSQLTime.toString());
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date", pSQLDate.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pPath, pHeaderParams);
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
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pHeaderParams.getOffsetTime()));
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time",
            DateTimeFormatter.ISO_DATE_TIME.format(pHeaderParams.getLocalDateTime()));
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pHeaderParams.getLocalTime()));
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pHeaderParams.getLocalDate()));
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getUtilDate()));
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getCalendar().getTime()));
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp", pHeaderParams.getSqlTimestamp().toString());
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time", pHeaderParams.getSqlTime().toString());
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", pHeaderParams.getSqlDate().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pChannelTypeParam, pContext);
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
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
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
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @Override
  public String testOptionalQueryParams( String query1, int query2 ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, query1, query2);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pComplextBookingID
   * @return boolean
   */
  @Override
  public boolean processComplexBookingID( ComplexBookingID pComplextBookingID ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pComplextBookingID);
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
    boolean lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @Override
  public String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBookingID, pBookingCode, pDoubleCode);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pContext);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pIntegerArray
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrays( int[] pIntegerArray ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pIntegerArray);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBookingCode
   * @return {@link String}
   */
  @Override
  public String testDataTypeAsQueryParam( BookingCode pBookingCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBookingCode);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBeanParam);
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
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pIntValues);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pStrings
   * @return {@link String}
   */
  @Override
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pStrings);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pIntegers
   * @return {@link String}
   */
  @Override
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pIntegers);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBean
   * @return {@link String}
   */
  @Override
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBean);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pCodes, pLongCodes, pBookingIDs, pTimestamps,
        pLocalDates);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pQueryBean
   * @return {@link String}
   */
  @Override
  public String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pQueryBean);
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
        lRequestBuilder.setQueryParameter("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryBean.getOffsetDateTime()));
      }
      if (pQueryBean.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryBean.getOffsetTime()));
      }
      if (pQueryBean.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryBean.getLocalDateTime()));
      }
      if (pQueryBean.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", DateTimeFormatter.ISO_TIME.format(pQueryBean.getLocalTime()));
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @Override
  public String testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pMultiValuedBean);
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
        lRequestBuilder.setHeader("startDate", DateTimeFormatter.ISO_DATE.format(pMultiValuedBean.getStartDate()));
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pNames, pInts, pDoubles, pCodes, pStartDate,
        pTimestamps, pTimes, pBase64);
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
      lRequestBuilder.setHeader("startDate", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartDate));
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBookingID
   */
  @Override
  public void testBookingIDAsPathParam( BookingID pBookingID ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBookingID);
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pBookingID);
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pContext);
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
        lRequestBuilder.setQueryParameter("aVeryLong", pContext.getAVeryLong().toString());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      lRequestBuilder.setHeader("aBoolean", pContext.isABoolean());
      if (pContext.getABooleanWrapper() != null) {
        lRequestBuilder.setHeader("aBooleanWrapper", pContext.getABooleanWrapper().toString());
      }
      lRequestBuilder.setHeader("anInt", pContext.getAnInt());
      if (pContext.getAnInteger() != null) {
        lRequestBuilder.setHeader("anInteger", pContext.getAnInteger().toString());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(RESTProductService.class, pAnInt, pAnInteger, pABoolean, pBooleanWrapper, pALong,
        pVeryLong);
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
      lRequestBuilder.setQueryParameter("pVeryLong", pVeryLong.toString());
    }
    // Set HTTP header(s)
    lRequestBuilder.setHeader("pAnInt", pAnInt);
    if (pAnInteger != null) {
      lRequestBuilder.setHeader("pAnInteger", pAnInteger.toString());
    }
    lRequestBuilder.setHeader("pABoolean", pABoolean);
    if (pBooleanWrapper != null) {
      lRequestBuilder.setHeader("pBooleanWrapper", pBooleanWrapper.toString());
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return lResult;
  }
}