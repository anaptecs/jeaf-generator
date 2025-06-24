/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.anaptecs.annotations.MyNotEmptyRESTParam;
import com.anaptecs.annotations.MyNotNullRESTParam;
import com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter;
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
import com.anaptecs.spring.service.MySortCriteria;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductServiceReactive;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

@RequestMapping(path = "/nova/prefix/rest-products")
@RestController
public class RESTProductServiceReactiveResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  private final ObjectMapper objectMapper;

  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * Filter is used to provide only those headers that are configured to be processed by this REST resource.
   */
  private final CustomHeaderFilter customHeaderFilter;

  /**
   * All request to this class will be delegated to {@link com.anaptecs.spring.service.RESTProductService}.
   */
  private final RESTProductServiceReactive rESTProductService;

  /**
   * Initialize object.
   *
   * @param pRESTProductService Dependency on concrete {@link com.anaptecs.spring.service.RESTProductService}
   * implementation that should be used.
   * @param pCompositeTypeConverter Composite type converter is used convert types from their string representation to a
   * real object that can be processed internally.
   */
  public RESTProductServiceReactiveResource( RESTProductServiceReactive pRESTProductService, ObjectMapper pObjectMapper,
      ValidationExecutor pValidationExecutor, CustomHeaderFilter pCustomHeaderFilter ) {
    rESTProductService = pRESTProductService;
    objectMapper = pObjectMapper;
    validationExecutor = pValidationExecutor;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getProducts()}
   */
  @PreAuthorize("hasAnyRole('Customer', 'Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.GET })
  public Mono<List<Product>> getProducts( @RequestParam(name = "maxResult", required = false) int pMaxResultSize,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pMaxResultSize);
      // Delegate request to service.
      return rESTProductService.getProducts(pMaxResultSize);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getProduct()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Product> getProduct( @PathVariable(name = "id", required = true) @MyNotNullRESTParam String pProductID,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pProductID);
      // Delegate request to service.
      return rESTProductService.getProduct(pProductID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#createProduct()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.POST })
  public Mono<Boolean> createProduct( @RequestBody(required = true) @MyNotNullRESTParam Mono<Product> pProduct,
      ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return rESTProductService.createProduct(pProductBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSortiment()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "sortiment/{id}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Sortiment> getSortiment(
      @RequestHeader(name = "token", required = true) @MyNotNullRESTParam String pAccessToken,
      @RequestHeader(name = "lang", required = true) @MyNotNullRESTParam Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) @MyNotNullRESTParam String pQueryParam,
      @MyNotNullRESTParam String pLang,
      @RequestHeader(name = "intCode", required = true) @MyNotNullRESTParam int pIntCodeAsBasicType,
      @RequestHeader Map<String, String> pHeaders, ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lContextBuilder = Context.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    // Handle bean parameter pContext.intCode
    lContextBuilder.setIntCode(IntegerCodeType.builder().setCode(pIntCodeAsBasicType).build());
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        lContextBuilder.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    Context pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.getSortiment(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#createChannelCode()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "ChannelCode", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<ChannelCode> createChannelCode(
      @RequestBody(required = true) @MyNotNullRESTParam Mono<String> pChannelCode,
      ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelCodeBody);
      // Delegate request to service.
      return rESTProductService.createChannelCode(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#ping()}
   */
  @PreAuthorize("hasAnyRole('Customer', 'Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(method = { RequestMethod.HEAD })
  @MyNotNullRESTParam
  public Mono<Void> ping( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return rESTProductService.ping();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testInit()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-init", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testInit( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return rESTProductService.testInit();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrencies()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "currencies/{channelCode}", method = { RequestMethod.GET })
  public Mono<List<CurrencyCode>> getSupportedCurrencies(
      @PathVariable(name = "channelCode", required = true) @MyNotNullRESTParam String pChannelCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode;
    if (pChannelCodeAsBasicType != null) {
      pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    }
    else {
      pChannelCode = null;
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelCode);
      // Delegate request to service.
      return rESTProductService.getSupportedCurrencies(pChannelCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrenciesAsync()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "async-currencies/{channelCode}", method = { RequestMethod.GET })
  public Mono<List<CurrencyCode>> getSupportedCurrenciesAsync(
      @PathVariable(name = "channelCode", required = true) @MyNotNullRESTParam String pChannelCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode;
    if (pChannelCodeAsBasicType != null) {
      pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    }
    else {
      pChannelCode = null;
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelCode);
      // Delegate request to service.
      return rESTProductService.getSupportedCurrenciesAsync(pChannelCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-params", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testParams(
      @RequestHeader(name = "Big-Header", required = true) @MyNotNullRESTParam BigDecimal pBigDecimalHeader,
      @CookieValue(name = "giveMeMoreCookies", required = true) int pIntCookieParam,
      @RequestParam(name = "locale", required = true) @MyNotNullRESTParam Locale pLocaleQueryParam,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBigDecimalHeader, pIntCookieParam,
          pLocaleQueryParam);
      // Delegate request to service.
      return rESTProductService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testEnumParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-enum-params/{channelType}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testEnumParams(
      @PathVariable(name = "channelType", required = true) @MyNotNullRESTParam ChannelType pChannelType,
      @RequestParam(name = "timeUnit", required = true) @MyNotNullRESTParam TimeUnit pTimeUnit,
      @RequestParam(name = "extensibleEnum", required = true) @MyNotNullRESTParam ExtensibleEnum pExtensibleEnum,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelType, pTimeUnit, pExtensibleEnum);
      // Delegate request to service.
      return rESTProductService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testEnumHeaderParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-enum-header-params", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testEnumHeaderParams(
      @RequestHeader(name = "Channel-Type", required = true) @MyNotNullRESTParam ChannelType pChannelType,
      @RequestHeader(name = "Time-Unit", required = true) @MyNotNullRESTParam TimeUnit pTimeUnit,
      @RequestHeader(name = "Extensible-Enum", required = true) @MyNotNullRESTParam ExtensibleEnum pExtensibleEnum,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelType, pTimeUnit, pExtensibleEnum);
      // Delegate request to service.
      return rESTProductService.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-query-params/{path}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testDateQueryParams( @PathVariable(name = "path", required = true) @MyNotNullRESTParam String pPath,
      @RequestParam(name = "startTimestamp", required = true) @MyNotNullRESTParam String pStartTimestampAsBasicType,
      @RequestParam(name = "startTime", required = true) @MyNotNullRESTParam String pStartTimeAsBasicType,
      @RequestParam(
          name = "localStartTimestamp",
          required = true) @MyNotNullRESTParam String pLocalStartTimestampAsBasicType,
      @RequestParam(name = "localStartTime", required = true) @MyNotNullRESTParam String pLocalStartTimeAsBasicType,
      @RequestParam(name = "localStartDate", required = true) @MyNotNullRESTParam String pLocalStartDateAsBasicType,
      @RequestParam(name = "calendar", required = true) @MyNotNullRESTParam String pCalendarAsBasicType,
      @RequestParam(name = "utilDate", required = true) @MyNotNullRESTParam String pUtilDateAsBasicType,
      @RequestParam(name = "sqlTimestamp", required = true) @MyNotNullRESTParam String pSQLTimestampAsBasicType,
      @RequestParam(name = "sqlTime", required = true) @MyNotNullRESTParam String pSQLTimeAsBasicType,
      @RequestParam(name = "sqlDate", required = true) @MyNotNullRESTParam String pSQLDateAsBasicType,
      @RequestParam(name = "calendars", required = false) String[] pCalendarsAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert date types into real objects.
    OffsetDateTime pStartTimestamp;
    if (pStartTimestampAsBasicType != null) {
      pStartTimestamp = OffsetDateTime.parse(pStartTimestampAsBasicType);
    }
    else {
      pStartTimestamp = null;
    }
    OffsetTime pStartTime;
    if (pStartTimeAsBasicType != null) {
      pStartTime = OffsetTime.parse(pStartTimeAsBasicType);
    }
    else {
      pStartTime = null;
    }
    LocalDateTime pLocalStartTimestamp;
    if (pLocalStartTimestampAsBasicType != null) {
      pLocalStartTimestamp = LocalDateTime.parse(pLocalStartTimestampAsBasicType);
    }
    else {
      pLocalStartTimestamp = null;
    }
    LocalTime pLocalStartTime;
    if (pLocalStartTimeAsBasicType != null) {
      pLocalStartTime = LocalTime.parse(pLocalStartTimeAsBasicType);
    }
    else {
      pLocalStartTime = null;
    }
    LocalDate pLocalStartDate;
    if (pLocalStartDateAsBasicType != null) {
      pLocalStartDate = LocalDate.parse(pLocalStartDateAsBasicType);
    }
    else {
      pLocalStartDate = null;
    }
    Calendar pCalendar;
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        pCalendar = Calendar.getInstance();
        pCalendar.setTime(lDate);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendar = null;
    }
    java.util.Date pUtilDate;
    if (pUtilDateAsBasicType != null) {
      try {
        pUtilDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDate = null;
    }
    Timestamp pSQLTimestamp;
    if (pSQLTimestampAsBasicType != null) {
      pSQLTimestamp = Timestamp.valueOf(pSQLTimestampAsBasicType);
    }
    else {
      pSQLTimestamp = null;
    }
    Time pSQLTime;
    if (pSQLTimeAsBasicType != null) {
      pSQLTime = Time.valueOf(pSQLTimeAsBasicType);
    }
    else {
      pSQLTime = null;
    }
    Date pSQLDate;
    if (pSQLDateAsBasicType != null) {
      pSQLDate = Date.valueOf(pSQLDateAsBasicType);
    }
    else {
      pSQLDate = null;
    }
    Set<Calendar> pCalendars;
    if (pCalendarsAsBasicType != null) {
      try {
        pCalendars = new HashSet<Calendar>();
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          Calendar lCalendar = Calendar.getInstance();
          lCalendar.setTime(lDate);
          pCalendars.add(lCalendar);
        }
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendars = Collections.emptySet();
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pPath, pStartTimestamp, pStartTime,
          pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime,
          pSQLDate, pCalendars);
      // Delegate request to service.
      return rESTProductService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
          pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParamsBean()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-query-params-beans/{path}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testDateQueryParamsBean(
      @PathVariable(name = "path", required = true) @MyNotNullRESTParam String pPath,
      @RequestParam(name = "offsetDateTime", required = true) @MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @RequestParam(name = "offsetTime", required = true) @MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @RequestParam(name = "localDateTime", required = true) @MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @RequestParam(name = "localTime", required = true) @MyNotNullRESTParam String pLocalTimeAsBasicType,
      @RequestParam(name = "localDate", required = true) @MyNotNullRESTParam String pLocalDateAsBasicType,
      @RequestParam(name = "utilDate", required = true) @MyNotNullRESTParam String pUtilDateAsBasicType,
      @RequestParam(name = "calendar", required = true) @MyNotNullRESTParam String pCalendarAsBasicType,
      @RequestParam(name = "sqlTimestamp", required = true) @MyNotNullRESTParam String pSqlTimestampAsBasicType,
      @RequestParam(name = "sqlTime", required = true) @MyNotNullRESTParam String pSqlTimeAsBasicType,
      @RequestParam(name = "sqlDate", required = true) @MyNotNullRESTParam String pSqlDateAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lQueryParamsBuilder = DateQueryParamsBean.builder();
    // Handle bean parameter pQueryParams.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryParamsBuilder.setOffsetDateTime(OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryParamsBuilder.setOffsetTime(OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryParamsBuilder.setLocalDateTime(LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryParamsBuilder.setLocalTime(LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localDate
    if (pLocalDateAsBasicType != null) {
      lQueryParamsBuilder.setLocalDate(LocalDate.parse(pLocalDateAsBasicType));
    }
    // Handle bean parameter pQueryParams.utilDate
    if (pUtilDateAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
        lQueryParamsBuilder.setUtilDate(lDate);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.calendar
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.setTime(lDate);
        lQueryParamsBuilder.setCalendar(lCalendar);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.sqlTimestamp
    if (pSqlTimestampAsBasicType != null) {
      lQueryParamsBuilder.setSqlTimestamp(Timestamp.valueOf(pSqlTimestampAsBasicType));
    }
    // Handle bean parameter pQueryParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      lQueryParamsBuilder.setSqlTime(Time.valueOf(pSqlTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      lQueryParamsBuilder.setSqlDate(Date.valueOf(pSqlDateAsBasicType));
    }
    DateQueryParamsBean pQueryParams = lQueryParamsBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pPath, pQueryParams);
      // Delegate request to service.
      return rESTProductService.testDateQueryParamsBean(pPath, pQueryParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-header-params/{path}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testDateHeaderParams(
      @PathVariable(name = "path", required = true) @MyNotNullRESTParam String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) @MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @RequestHeader(name = "Offset-Time", required = true) @MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @RequestHeader(name = "Local-Date-Time", required = true) @MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @RequestHeader(name = "Local-Time", required = true) @MyNotNullRESTParam String pLocalTimeAsBasicType,
      @RequestHeader(name = "Local-Date", required = true) @MyNotNullRESTParam String pLocalDateAsBasicType,
      @RequestHeader(name = "Calendar", required = true) @MyNotNullRESTParam String pCalendarAsBasicType,
      @RequestHeader(name = "Util-Date", required = true) @MyNotNullRESTParam String pUtilDateAsBasicType,
      @RequestHeader(name = "SQL-Timestamp", required = true) @MyNotNullRESTParam String pSQLTimestampAsBasicType,
      @RequestHeader(name = "SQL-Time", required = true) @MyNotNullRESTParam String pSQLTimeAsBasicType,
      @RequestHeader(name = "SQL-Date", required = true) @MyNotNullRESTParam String pSQLDateAsBasicType,
      @RequestHeader(name = "util-dates", required = false) String[] pUtilDatesAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert date types into real objects.
    OffsetDateTime pOffsetDateTime;
    if (pOffsetDateTimeAsBasicType != null) {
      pOffsetDateTime = OffsetDateTime.parse(pOffsetDateTimeAsBasicType);
    }
    else {
      pOffsetDateTime = null;
    }
    OffsetTime pOffsetTime;
    if (pOffsetTimeAsBasicType != null) {
      pOffsetTime = OffsetTime.parse(pOffsetTimeAsBasicType);
    }
    else {
      pOffsetTime = null;
    }
    LocalDateTime pLocalDateTime;
    if (pLocalDateTimeAsBasicType != null) {
      pLocalDateTime = LocalDateTime.parse(pLocalDateTimeAsBasicType);
    }
    else {
      pLocalDateTime = null;
    }
    LocalTime pLocalTime;
    if (pLocalTimeAsBasicType != null) {
      pLocalTime = LocalTime.parse(pLocalTimeAsBasicType);
    }
    else {
      pLocalTime = null;
    }
    LocalDate pLocalDate;
    if (pLocalDateAsBasicType != null) {
      pLocalDate = LocalDate.parse(pLocalDateAsBasicType);
    }
    else {
      pLocalDate = null;
    }
    Calendar pCalendar;
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        pCalendar = Calendar.getInstance();
        pCalendar.setTime(lDate);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendar = null;
    }
    java.util.Date pUtilDate;
    if (pUtilDateAsBasicType != null) {
      try {
        pUtilDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDate = null;
    }
    Timestamp pSQLTimestamp;
    if (pSQLTimestampAsBasicType != null) {
      pSQLTimestamp = Timestamp.valueOf(pSQLTimestampAsBasicType);
    }
    else {
      pSQLTimestamp = null;
    }
    Time pSQLTime;
    if (pSQLTimeAsBasicType != null) {
      pSQLTime = Time.valueOf(pSQLTimeAsBasicType);
    }
    else {
      pSQLTime = null;
    }
    Date pSQLDate;
    if (pSQLDateAsBasicType != null) {
      pSQLDate = Date.valueOf(pSQLDateAsBasicType);
    }
    else {
      pSQLDate = null;
    }
    Set<java.util.Date> pUtilDates;
    if (pUtilDatesAsBasicType != null) {
      try {
        pUtilDates = new HashSet<java.util.Date>();
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          pUtilDates.add(lDate);
        }
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDates = Collections.emptySet();
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pPath, pOffsetDateTime, pOffsetTime,
          pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
      // Delegate request to service.
      return rESTProductService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime,
          pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParamsBean()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-header-params-beans/{path}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testDateHeaderParamsBean(
      @PathVariable(name = "path", required = true) @MyNotNullRESTParam String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) @MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @RequestHeader(name = "Offset-Time", required = true) @MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @RequestHeader(name = "Local-Date-Time", required = true) @MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @RequestHeader(name = "Local-Time", required = true) @MyNotNullRESTParam String pLocalTimeAsBasicType,
      @RequestHeader(name = "Local-Date", required = true) @MyNotNullRESTParam String pLocalDateAsBasicType,
      @RequestHeader(name = "Util-Date", required = true) @MyNotNullRESTParam String pUtilDateAsBasicType,
      @RequestHeader(name = "Calendar", required = true) @MyNotNullRESTParam String pCalendarAsBasicType,
      @RequestHeader(name = "SQL-Timestamp", required = true) @MyNotNullRESTParam String pSqlTimestampAsBasicType,
      @RequestHeader(name = "SQL-Time", required = true) @MyNotNullRESTParam String pSqlTimeAsBasicType,
      @RequestHeader(name = "SQL-Date", required = true) @MyNotNullRESTParam String pSqlDateAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lHeaderParamsBuilder = DateHeaderParamsBean.builder();
    // Handle bean parameter pHeaderParams.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lHeaderParamsBuilder.setOffsetDateTime(OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lHeaderParamsBuilder.setOffsetTime(OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lHeaderParamsBuilder.setLocalDateTime(LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localTime
    if (pLocalTimeAsBasicType != null) {
      lHeaderParamsBuilder.setLocalTime(LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localDate
    if (pLocalDateAsBasicType != null) {
      lHeaderParamsBuilder.setLocalDate(LocalDate.parse(pLocalDateAsBasicType));
    }
    // Handle bean parameter pHeaderParams.utilDate
    if (pUtilDateAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
        lHeaderParamsBuilder.setUtilDate(lDate);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.calendar
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.setTime(lDate);
        lHeaderParamsBuilder.setCalendar(lCalendar);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.sqlTimestamp
    if (pSqlTimestampAsBasicType != null) {
      lHeaderParamsBuilder.setSqlTimestamp(Timestamp.valueOf(pSqlTimestampAsBasicType));
    }
    // Handle bean parameter pHeaderParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      lHeaderParamsBuilder.setSqlTime(Time.valueOf(pSqlTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      lHeaderParamsBuilder.setSqlDate(Date.valueOf(pSqlDateAsBasicType));
    }
    DateHeaderParamsBean pHeaderParams = lHeaderParamsBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pPath, pHeaderParams);
      // Delegate request to service.
      return rESTProductService.testDateHeaderParamsBean(pPath, pHeaderParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testCookieParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "cookies", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Void> testCookieParams(
      @CookieValue(name = "Channel-Type-Param", required = true) @MyNotNullRESTParam ChannelType pChannelTypeParam,
      @RequestHeader(name = "token", required = true) @MyNotNullRESTParam String pAccessToken,
      @RequestHeader(name = "lang", required = true) @MyNotNullRESTParam Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) @MyNotNullRESTParam String pQueryParam,
      @MyNotNullRESTParam String pLang,
      @RequestHeader(name = "intCode", required = true) @MyNotNullRESTParam int pIntCodeAsBasicType,
      @RequestHeader(name = "specificHeader", required = true) @MyNotNullRESTParam String pSpecificHeader,
      @CookieValue(name = "Channel-Type", required = true) @MyNotNullRESTParam ChannelType pChannelType,
      @RequestHeader Map<String, String> pHeaders, ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lContextBuilder = SpecialContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    // Handle bean parameter pContext.intCode
    lContextBuilder.setIntCode(IntegerCodeType.builder().setCode(pIntCodeAsBasicType).build());
    lContextBuilder.setSpecificHeader(pSpecificHeader);
    lContextBuilder.setChannelType(pChannelType);
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        lContextBuilder.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    SpecialContext pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pChannelTypeParam, pContext);
      // Delegate request to service.
      return rESTProductService.testCookieParams(pChannelTypeParam, pContext);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testOptionalQueryParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-optional-query-params", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testOptionalQueryParams(
      @RequestParam(name = "query1", required = false, defaultValue = "Just a default value") String query1,
      @RequestParam(name = "query2", required = false) int query2, ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, query1, query2);
      // Delegate request to service.
      return rESTProductService.testOptionalQueryParams(query1, query2);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#processComplexBookingID()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "complex/{bookingID}", method = { RequestMethod.GET })
  public Mono<Boolean> processComplexBookingID(
      @PathVariable(name = "bookingID", required = true) @MyNotNullRESTParam String pComplextBookingIDAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    ComplexBookingID pComplextBookingID =
        this.deserializeCompositeDataType(pComplextBookingIDAsBasicType, ComplexBookingID.class);
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pComplextBookingID);
      // Delegate request to service.
      return rESTProductService.processComplexBookingID(pComplextBookingID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "dataTypesInHeader", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testDataTypesAsHeaderParam(
      @RequestHeader(name = "BookingID", required = true) @MyNotNullRESTParam String pBookingIDAsBasicType,
      @RequestHeader(name = "BookingCode", required = true) @MyNotNullRESTParam String pBookingCodeAsBasicType,
      @RequestHeader(name = "DoubleCode", required = true) @MyNotNullRESTParam Double pDoubleCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    BookingCode pBookingCode;
    if (pBookingCodeAsBasicType != null) {
      pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    }
    else {
      pBookingCode = null;
    }
    DoubleCode pDoubleCode;
    if (pDoubleCodeAsBasicType != null) {
      pDoubleCode = DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build();
    }
    else {
      pDoubleCode = null;
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBookingID, pBookingCode, pDoubleCode);
      // Delegate request to service.
      return rESTProductService.testDataTypesAsHeaderParam(pBookingID, pBookingCode, pDoubleCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderBeanParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "dataTypesInBeanHeader", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testDataTypesAsHeaderBeanParam(
      @RequestHeader(name = "bookingID", required = true) @MyNotNullRESTParam String pBookingIDAsBasicType,
      @RequestHeader(name = "bookingCode", required = true) @MyNotNullRESTParam String pBookingCodeAsBasicType,
      @RequestHeader(name = "DoubleCode", required = true) @MyNotNullRESTParam Double pDoubleCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lContextBuilder = AdvancedHeader.builder();
    // Handle bean parameter pContext.bookingID
    if (pBookingIDAsBasicType != null) {
      lContextBuilder.setBookingID(this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class));
    }
    // Handle bean parameter pContext.bookingCode
    if (pBookingCodeAsBasicType != null) {
      lContextBuilder.setBookingCode(BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    }
    // Handle bean parameter pContext.doubleCode
    if (pDoubleCodeAsBasicType != null) {
      lContextBuilder.setDoubleCode(DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build());
    }
    AdvancedHeader pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.testDataTypesAsHeaderBeanParam(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrays()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveArrayAsBody", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<String> testPrimitiveArrays( @RequestBody(required = false) Mono<int[]> pIntegerArray,
      ServerWebExchange pServerWebExchange ) {
    return pIntegerArray.flatMap(pIntegerArrayBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pIntegerArrayBody);
      // Delegate request to service.
      return rESTProductService.testPrimitiveArrays(pIntegerArrayBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testDataTypeAsQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testDataTypeAsQueryParam(
      @RequestParam(name = "bookingCode", required = true) @MyNotNullRESTParam String pBookingCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    BookingCode pBookingCode;
    if (pBookingCodeAsBasicType != null) {
      pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    }
    else {
      pBookingCode = null;
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBookingCode);
      // Delegate request to service.
      return rESTProductService.testDataTypeAsQueryParam(pBookingCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsBeanQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testDataTypeAsBeanQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testDataTypeAsBeanQueryParam(
      @RequestParam(name = "bookingCode", required = true) @MyNotNullRESTParam String pBookingCodeAsBasicType,
      @RequestParam(name = "maxResults", required = true, defaultValue = "47") int pMaxResults,
      @RequestParam(name = "sortCriteria", required = false) String[] pSortCriteriaAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lBeanParamBuilder = QueryBeanParam.builder();
    // Handle bean parameter pBeanParam.bookingCode
    if (pBookingCodeAsBasicType != null) {
      lBeanParamBuilder.setBookingCode(BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    }
    lBeanParamBuilder.setMaxResults(pMaxResults);
    // Handle bean parameter pBeanParam.sortCriteria
    if (pSortCriteriaAsBasicType != null) {
      // Handle bean parameter pBeanParam.sortCriteria
      List<MySortCriteria> lSortCriteria = new ArrayList<MySortCriteria>();
      for (String lNext : pSortCriteriaAsBasicType) {
        lSortCriteria.add(this.deserializeCompositeDataType(lNext, MySortCriteria.class));
      }
      lBeanParamBuilder.setSortCriteria(lSortCriteria);
    }
    QueryBeanParam pBeanParam = lBeanParamBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return rESTProductService.testDataTypeAsBeanQueryParam(pBeanParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrayAsQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveArrayAsQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testPrimitiveArrayAsQueryParam(
      @RequestParam(name = "intValues", required = false) int[] pIntValues, ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pIntValues);
      // Delegate request to service.
      return rESTProductService.testPrimitiveArrayAsQueryParam(pIntValues);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testSimpleTypesAsQueryParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testSimpleTypesAsQueryParams", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testSimpleTypesAsQueryParams(
      @RequestParam(name = "strings", required = false) List<String> pStrings, ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pStrings);
      // Delegate request to service.
      return rESTProductService.testSimpleTypesAsQueryParams(pStrings);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveWrapperArrayAsQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveWrapperArrayAsQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testPrimitiveWrapperArrayAsQueryParam(
      @RequestParam(name = "integers", required = true) @MyNotEmptyRESTParam Set<Integer> pIntegers,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pIntegers);
      // Delegate request to service.
      return rESTProductService.testPrimitiveWrapperArrayAsQueryParam(pIntegers);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultivaluedQueryParamsBean()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultivaluedQueryParamsBean", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testMultivaluedQueryParamsBean(
      @RequestParam(name = "intArray", required = false) int[] pIntArray,
      @RequestParam(name = "strings", required = false) String[] pStrings,
      @RequestParam(name = "integers", required = false) Integer[] pIntegers,
      @RequestParam(name = "timeUnits", required = false) Set<TimeUnit> pTimeUnits,
      @RequestParam(name = "timeUnitArray", required = false) TimeUnit[] pTimeUnitArray,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lBeanBuilder = MultivaluedQueryParamsBean.builder();
    lBeanBuilder.setIntArray(pIntArray);
    lBeanBuilder.setStrings(pStrings);
    lBeanBuilder.setIntegers(pIntegers);
    lBeanBuilder.setTimeUnits(pTimeUnits);
    lBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    MultivaluedQueryParamsBean pBean = lBeanBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBean);
      // Delegate request to service.
      return rESTProductService.testMultivaluedQueryParamsBean(pBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMulitvaluedDataTypeAsQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testMulitvaluedDataTypeAsQueryParam(
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "longCodes", required = true) @MyNotEmptyRESTParam Long[] pLongCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestParam(name = "localDates", required = false) String[] pLocalDatesAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    List<IntegerCodeType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<IntegerCodeType>();
      for (int lNext : pCodesAsBasicType) {
        pCodes.add(IntegerCodeType.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    Set<LongCode> pLongCodes;
    if (pLongCodesAsBasicType != null) {
      pLongCodes = new HashSet<LongCode>();
      for (Long lNext : pLongCodesAsBasicType) {
        pLongCodes.add(LongCode.builder().setCode(lNext).build());
      }
    }
    else {
      pLongCodes = Collections.emptySet();
    }
    List<BookingID> pBookingIDs;
    if (pBookingIDsAsBasicType != null) {
      pBookingIDs = new ArrayList<BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        pBookingIDs.add(this.deserializeCompositeDataType(lNext, BookingID.class));
      }
    }
    else {
      pBookingIDs = Collections.emptyList();
    }
    // Convert date types into real objects.
    List<OffsetDateTime> pTimestamps;
    if (pTimestampsAsBasicType != null) {
      pTimestamps = new ArrayList<OffsetDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        pTimestamps.add(OffsetDateTime.parse(pTimestampsAsBasicType[i]));
      }
    }
    else {
      pTimestamps = Collections.emptyList();
    }
    SortedSet<LocalDate> pLocalDates;
    if (pLocalDatesAsBasicType != null) {
      pLocalDates = new TreeSet<LocalDate>();
      for (int i = 0; i < pLocalDatesAsBasicType.length; i++) {
        pLocalDates.add(LocalDate.parse(pLocalDatesAsBasicType[i]));
      }
    }
    else {
      pLocalDates = Collections.emptySortedSet();
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pCodes, pLongCodes, pBookingIDs, pTimestamps,
          pLocalDates);
      // Delegate request to service.
      return rESTProductService.testMulitvaluedDataTypeAsQueryParam(pCodes, pLongCodes, pBookingIDs, pTimestamps,
          pLocalDates);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMulitvaluedDataTypeAsBeanQueryParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testMulitvaluedDataTypeAsBeanQueryParam(
      @RequestParam(name = "longCodes", required = false) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "doubleCodes", required = false) Double[] pDoubleCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "bookingIDsArray", required = false) String[] pBookingIDsArrayAsBasicType,
      @RequestParam(name = "offsetDateTime", required = true) @MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @RequestParam(name = "offsetTime", required = true) @MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @RequestParam(name = "localDateTime", required = true) @MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @RequestParam(name = "localTime", required = true) @MyNotNullRESTParam String pLocalTimeAsBasicType,
      @RequestParam(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestParam(name = "times", required = false) String[] pTimesAsBasicType,
      @RequestParam(name = "startTimestamps", required = false) String[] pStartTimestampsAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lQueryBeanBuilder = DataTypesQueryBean.builder();
    // Handle bean parameter pQueryBean.longCodes
    if (pLongCodesAsBasicType != null) {
      LongCode[] lLongCodes = new LongCode[pLongCodesAsBasicType.length];
      for (int i = 0; i < pLongCodesAsBasicType.length; i++) {
        lLongCodes[i] = LongCode.builder().setCode(pLongCodesAsBasicType[i]).build();
      }
      lQueryBeanBuilder.setLongCodes(lLongCodes);
    }
    // Handle bean parameter pQueryBean.codes
    if (pCodesAsBasicType != null) {
      IntegerCodeType[] lCodes = new IntegerCodeType[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = IntegerCodeType.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lQueryBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pQueryBean.doubleCodes
    if (pDoubleCodesAsBasicType != null) {
      Set<DoubleCode> lDoubleCodes = new HashSet<DoubleCode>();
      for (Double lNext : pDoubleCodesAsBasicType) {
        lDoubleCodes.add(DoubleCode.builder().setCode(lNext).build());
      }
      lQueryBeanBuilder.setDoubleCodes(lDoubleCodes);
    }
    // Handle bean parameter pQueryBean.bookingIDs
    if (pBookingIDsAsBasicType != null) {
      // Handle bean parameter pQueryBean.bookingIDs
      Set<BookingID> lBookingIDs = new HashSet<BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        lBookingIDs.add(this.deserializeCompositeDataType(lNext, BookingID.class));
      }
      lQueryBeanBuilder.setBookingIDs(lBookingIDs);
    }
    // Handle bean parameter pQueryBean.bookingIDsArray
    if (pBookingIDsArrayAsBasicType != null) {
      // Handle bean parameter pQueryBean.bookingIDsArray
      BookingID[] lBookingIDsArray = new BookingID[pBookingIDsArrayAsBasicType.length];
      for (int i = 0; i < pBookingIDsArrayAsBasicType.length; i++) {
        lBookingIDsArray[i] = this.deserializeCompositeDataType(pBookingIDsArrayAsBasicType[i], BookingID.class);
      }
      lQueryBeanBuilder.setBookingIDsArray(lBookingIDsArray);
    }
    // Handle bean parameter pQueryBean.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryBeanBuilder.setOffsetDateTime(OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryBeanBuilder.setOffsetTime(OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryBeanBuilder.setLocalDateTime(LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryBeanBuilder.setLocalTime(LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.timestamps
    if (pTimestampsAsBasicType != null) {
      List<LocalDateTime> lTimestamps = new ArrayList<LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lQueryBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pQueryBean.times
    if (pTimesAsBasicType != null) {
      Set<OffsetTime> lTimes = new HashSet<OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        lTimes.add(OffsetTime.parse(pTimesAsBasicType[i]));
      }
      lQueryBeanBuilder.setTimes(lTimes);
    }
    // Handle bean parameter pQueryBean.startTimestamps
    if (pStartTimestampsAsBasicType != null) {
      OffsetDateTime[] lStartTimestamps = new OffsetDateTime[pStartTimestampsAsBasicType.length];
      for (int i = 0; i < pStartTimestampsAsBasicType.length; i++) {
        lStartTimestamps[i] = OffsetDateTime.parse(pStartTimestampsAsBasicType[i]);
      }
      lQueryBeanBuilder.setStartTimestamps(lStartTimestamps);
    }
    DataTypesQueryBean pQueryBean = lQueryBeanBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pQueryBean);
      // Delegate request to service.
      return rESTProductService.testMulitvaluedDataTypeAsBeanQueryParam(pQueryBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFieldsInBeanParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultiValuedHeaderFieldsInBeanParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testMultiValuedHeaderFieldsInBeanParam(
      @RequestHeader(name = "names", required = false) String[] pNames,
      @RequestHeader(name = "ints", required = true) @MyNotEmptyRESTParam int[] pInts,
      @RequestHeader(name = "doubles", required = false) Double[] pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "stringCodeList", required = false) String[] pStringCodeListAsBasicType,
      @RequestHeader(name = "startDate", required = false) String pStartDateAsBasicType,
      @RequestHeader(name = "dates", required = false) String[] pDatesAsBasicType,
      @RequestHeader(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestHeader(name = "calendars", required = false) String[] pCalendarsAsBasicType,
      @RequestHeader(name = "utilDates", required = false) String[] pUtilDatesAsBasicType,
      @RequestHeader(name = "sqlTimestamps", required = false) String[] pSqlTimestampsAsBasicType,
      @RequestHeader(name = "timeUnits", required = false) Set<TimeUnit> pTimeUnits,
      @RequestHeader(name = "timeUnitArray", required = false) TimeUnit[] pTimeUnitArray,
      @RequestHeader(name = "base64", required = false) String pBase64, ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lMultiValuedBeanBuilder = MultiValuedHeaderBeanParam.builder();
    lMultiValuedBeanBuilder.setNames(pNames);
    lMultiValuedBeanBuilder.setInts(pInts);
    lMultiValuedBeanBuilder.setDoubles(pDoubles);
    // Handle bean parameter pMultiValuedBean.codes
    if (pCodesAsBasicType != null) {
      StringCode[] lCodes = new StringCode[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = StringCode.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lMultiValuedBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pMultiValuedBean.stringCodeList
    if (pStringCodeListAsBasicType != null) {
      Set<StringCode> lStringCodeList = new HashSet<StringCode>();
      for (String lNext : pStringCodeListAsBasicType) {
        lStringCodeList.add(StringCode.builder().setCode(lNext).build());
      }
      lMultiValuedBeanBuilder.setStringCodeList(lStringCodeList);
    }
    // Handle bean parameter pMultiValuedBean.startDate
    if (pStartDateAsBasicType != null) {
      lMultiValuedBeanBuilder.setStartDate(LocalDate.parse(pStartDateAsBasicType));
    }
    // Handle bean parameter pMultiValuedBean.dates
    if (pDatesAsBasicType != null) {
      LocalDate[] lDates = new LocalDate[pDatesAsBasicType.length];
      for (int i = 0; i < pDatesAsBasicType.length; i++) {
        lDates[i] = LocalDate.parse(pDatesAsBasicType[i]);
      }
      lMultiValuedBeanBuilder.setDates(lDates);
    }
    // Handle bean parameter pMultiValuedBean.timestamps
    if (pTimestampsAsBasicType != null) {
      Set<LocalDateTime> lTimestamps = new HashSet<LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lMultiValuedBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pMultiValuedBean.calendars
    if (pCalendarsAsBasicType != null) {
      try {
        Calendar[] lCalendars = new Calendar[pCalendarsAsBasicType.length];
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          Calendar lCalendar = Calendar.getInstance();
          lCalendar.setTime(lDate);
          lCalendars[i] = lCalendar;
        }
        lMultiValuedBeanBuilder.setCalendars(lCalendars);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pMultiValuedBean.utilDates
    if (pUtilDatesAsBasicType != null) {
      try {
        java.util.Date[] lUtilDates = new java.util.Date[pUtilDatesAsBasicType.length];
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          lUtilDates[i] = lDate;
        }
        lMultiValuedBeanBuilder.setUtilDates(lUtilDates);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pMultiValuedBean.sqlTimestamps
    if (pSqlTimestampsAsBasicType != null) {
      Timestamp[] lSqlTimestamps = new Timestamp[pSqlTimestampsAsBasicType.length];
      for (int i = 0; i < pSqlTimestampsAsBasicType.length; i++) {
        lSqlTimestamps[i] = Timestamp.valueOf(pSqlTimestampsAsBasicType[i]);
      }
      lMultiValuedBeanBuilder.setSqlTimestamps(lSqlTimestamps);
    }
    lMultiValuedBeanBuilder.setTimeUnits(pTimeUnits);
    lMultiValuedBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    // Decode base64 encoded String back to byte[]
    if (pBase64 != null) {
      lMultiValuedBeanBuilder.setBase64(Base64.getDecoder().decode(pBase64));
    }
    MultiValuedHeaderBeanParam pMultiValuedBean = lMultiValuedBeanBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pMultiValuedBean);
      // Delegate request to service.
      return rESTProductService.testMultiValuedHeaderFieldsInBeanParam(pMultiValuedBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFields()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultiValuedHeaderFields", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testMultiValuedHeaderFields( @RequestHeader(name = "names", required = false) Set<String> pNames,
      @RequestHeader(name = "ints", required = true) @MyNotEmptyRESTParam int[] pInts,
      @RequestHeader(name = "doubles", required = false) Set<Double> pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "startDate", required = false) String pStartDateAsBasicType,
      @RequestHeader(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestHeader(name = "times", required = false) String[] pTimesAsBasicType,
      @RequestHeader(name = "BASE_64", required = false) String pBase64AsString,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    Set<StringCode> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new HashSet<StringCode>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(StringCode.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptySet();
    }
    // Convert date types into real objects.
    OffsetDateTime pStartDate;
    if (pStartDateAsBasicType != null) {
      pStartDate = OffsetDateTime.parse(pStartDateAsBasicType);
    }
    else {
      pStartDate = null;
    }
    Set<OffsetDateTime> pTimestamps;
    if (pTimestampsAsBasicType != null) {
      pTimestamps = new HashSet<OffsetDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        pTimestamps.add(OffsetDateTime.parse(pTimestampsAsBasicType[i]));
      }
    }
    else {
      pTimestamps = Collections.emptySet();
    }
    Set<OffsetTime> pTimes;
    if (pTimesAsBasicType != null) {
      pTimes = new HashSet<OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        pTimes.add(OffsetTime.parse(pTimesAsBasicType[i]));
      }
    }
    else {
      pTimes = Collections.emptySet();
    }
    byte[] pBase64;
    if (pBase64AsString != null) {
      pBase64 = Base64.getDecoder().decode(pBase64AsString);
    }
    else {
      pBase64 = null;
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pNames, pInts, pDoubles, pCodes, pStartDate,
          pTimestamps, pTimes, pBase64);
      // Delegate request to service.
      return rESTProductService.testMultiValuedHeaderFields(pNames, pInts, pDoubles, pCodes, pStartDate, pTimestamps,
          pTimes, pBase64);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsPathParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "booking-id-as-path-param/{bookingID}", method = { RequestMethod.PATCH })
  @MyNotNullRESTParam
  public Mono<Void> testBookingIDAsPathParam(
      @PathVariable(name = "bookingID", required = true) @MyNotNullRESTParam String pBookingIDAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBookingID);
      // Delegate request to service.
      return rESTProductService.testBookingIDAsPathParam(pBookingID);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsHeaderParam()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "booking-id-as-header-param", method = { RequestMethod.PATCH })
  @MyNotNullRESTParam
  public Mono<Void> testBookingIDAsHeaderParam(
      @RequestHeader(name = "bookingID", required = false) String pBookingIDAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pBookingID);
      // Delegate request to service.
      return rESTProductService.testBookingIDAsHeaderParam(pBookingID);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testContextWithPrimitives()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-context-with-primitives", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testContextWithPrimitives( @RequestHeader(name = "aBoolean", required = true) boolean pABoolean,
      @RequestHeader(name = "aBooleanWrapper", required = true) @MyNotNullRESTParam Boolean pABooleanWrapper,
      @RequestHeader(name = "anInt", required = true) int pAnInt,
      @RequestHeader(name = "anInteger", required = true) @MyNotNullRESTParam Integer pAnInteger,
      @RequestParam(name = "aLong", required = true) long pALong,
      @RequestParam(name = "aVeryLong", required = true) @MyNotNullRESTParam Long pAVeryLong,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lContextBuilder = ContextWithPrimitives.builder();
    lContextBuilder.setABoolean(pABoolean);
    lContextBuilder.setABooleanWrapper(pABooleanWrapper);
    lContextBuilder.setAnInt(pAnInt);
    lContextBuilder.setAnInteger(pAnInteger);
    lContextBuilder.setALong(pALong);
    lContextBuilder.setAVeryLong(pAVeryLong);
    ContextWithPrimitives pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.testContextWithPrimitives(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitivesAsParams()}
   */
  @PreAuthorize("hasAnyRole('Sales Agent')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-primitives-as-params", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testPrimitivesAsParams( @RequestHeader(name = "pAnInt", required = true) int pAnInt,
      @RequestHeader(name = "pAnInteger", required = true) @MyNotNullRESTParam Integer pAnInteger,
      @RequestHeader(name = "pABoolean", required = true) boolean pABoolean,
      @RequestHeader(name = "pBooleanWrapper", required = true) @MyNotNullRESTParam Boolean pBooleanWrapper,
      @RequestParam(name = "pALong", required = true) long pALong,
      @RequestParam(name = "pVeryLong", required = true) @MyNotNullRESTParam Long pVeryLong,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(RESTProductServiceReactive.class, pAnInt, pAnInteger, pABoolean,
          pBooleanWrapper, pALong, pVeryLong);
      // Delegate request to service.
      return rESTProductService.testPrimitivesAsParams(pAnInt, pAnInteger, pABoolean, pBooleanWrapper, pALong,
          pVeryLong);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(RESTProductServiceReactive.class, lResponse));
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
        lBuilder.append("\"");
        lBuilder.append(pCompositeDataTypeAsString);
        lBuilder.append("\"");
        lObject = objectMapper.readValue(lBuilder.toString(), pType);
      }
      else {
        lObject = null;
      }
      return lObject;
    }
    catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}