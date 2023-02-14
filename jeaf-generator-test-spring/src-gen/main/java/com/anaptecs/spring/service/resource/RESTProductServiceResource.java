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
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.InventoryType;
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
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@RequestMapping(
    path = "/nova/prefix/rest-products",
    consumes = { "application/json" },
    produces = { "application/json" })
@RestController
public class RESTProductServiceResource {
  /**
   * List contains all classes that are involved in the serialization process of class ComplexBookingID. This
   * information is required by some serialization mechanisms for efficiency and security reasons.
   */
  private static final List<Class<?>> COMPLEXBOOKINGID_SERIALIZED_CLASSES;
  static {
    List<Class<?>> lClasses =
        Arrays.asList(ComplexBookingID.class, ArrayList.class, BookingID.class, InventoryType.class, BookingCode.class,
            ComplexBookingType.class, ComplexBookingType.ComplexBookingTypeType.class, String[].class);
    COMPLEXBOOKINGID_SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * List contains all classes that are involved in the serialization process of class BookingID. This information is
   * required by some serialization mechanisms for efficiency and security reasons.
   */
  private static final List<Class<?>> BOOKINGID_SERIALIZED_CLASSES;
  static {
    List<Class<?>> lClasses = Arrays.asList(BookingID.class, InventoryType.class, BookingCode.class);
    BOOKINGID_SERIALIZED_CLASSES = Collections.unmodifiableList(lClasses);
  }

  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  private final CompositeTypeConverter compositeTypeConverter;

  /**
   * Filter is used to provide only those headers that are configured to be processed by this REST resource.
   */
  private final CustomHeaderFilter customHeaderFilter;

  /**
   * All request to this class will be delegated to {@link RESTProductService}.
   */
  private final RESTProductService rESTProductService;

  /**
   * Initialize object.
   * 
   * @param pRESTProductService Dependency on concrete {@link RESTProductService} implementation that should be used.
   * @param pCompositeTypeConverter Composite type converter is used convert types from their string representation to a
   * real object that can be processed internally.
   */
  public RESTProductServiceResource( RESTProductService pRESTProductService,
      CompositeTypeConverter pCompositeTypeConverter, CustomHeaderFilter pCustomHeaderFilter ) {
    rESTProductService = pRESTProductService;
    compositeTypeConverter = pCompositeTypeConverter;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link RESTProductService#getProducts()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( @RequestParam(name = "maxResult", required = true) int pMaxResultSize ) {
    // Delegate request to service.
    return rESTProductService.getProducts(pMaxResultSize);
  }

  /**
   * {@link RESTProductService#getProduct()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Delegate request to service.
    return rESTProductService.getProduct(pProductID);
  }

  /**
   * {@link RESTProductService#createProduct()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Delegate request to service.
    return rESTProductService.createProduct(pProduct);
  }

  /**
   * {@link RESTProductService#getSortiment()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "sortiment/{id}", method = { RequestMethod.GET })
  public Sortiment getSortiment( @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) String pQueryParam, String pLang,
      @RequestHeader Map<String, String> pHeaders ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    Context.Builder lContextBuilder = Context.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    Context pContext = lContextBuilder.build();
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    // Delegate request to service.
    return rESTProductService.getSortiment(pContext);
  }

  /**
   * {@link RESTProductService#createChannelCode()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "ChannelCode", method = { RequestMethod.POST })
  public ChannelCode createChannelCode( @RequestBody(required = true) String pChannelCode ) {
    // Delegate request to service.
    return rESTProductService.createChannelCode(pChannelCode);
  }

  /**
   * {@link RESTProductService#ping()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Delegate request to service.
    rESTProductService.ping();
  }

  /**
   * {@link RESTProductService#testInit()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-init", method = { RequestMethod.GET })
  public void testInit( ) {
    // Delegate request to service.
    rESTProductService.testInit();
  }

  /**
   * {@link RESTProductService#getSupportedCurrencies()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "currencies/{channelCode}", method = { RequestMethod.GET })
  public List<CurrencyCode> getSupportedCurrencies(
      @PathVariable(name = "channelCode", required = true) String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    // Delegate request to service.
    return rESTProductService.getSupportedCurrencies(pChannelCode);
  }

  /**
   * {@link RESTProductService#getSupportedCurrenciesAsync()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "async-currencies/{channelCode}", method = { RequestMethod.GET })
  public List<CurrencyCode> getSupportedCurrenciesAsync(
      @PathVariable(name = "channelCode", required = true) String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    // Delegate request to service.
    return rESTProductService.getSupportedCurrenciesAsync(pChannelCode);
  }

  /**
   * {@link RESTProductService#testParams()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-params", method = { RequestMethod.GET })
  public String testParams( @RequestHeader(name = "Big-Header", required = true) BigDecimal pBigDecimalHeader,
      @CookieValue(name = "giveMeMoreCookies", required = true) @RequestBody(required = true) int pIntCookieParam,
      @RequestParam(name = "locale", required = true) Locale pLocaleQueryParam ) {
    // Delegate request to service.
    return rESTProductService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
  }

  /**
   * {@link RESTProductService#testEnumParams()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-enum-params/{channelType}", method = { RequestMethod.GET })
  public void testEnumParams( @PathVariable(name = "channelType", required = true) ChannelType pChannelType,
      @RequestParam(name = "timeUnit", required = true) TimeUnit pTimeUnit,
      @RequestParam(name = "extensibleEnum", required = true) ExtensibleEnum pExtensibleEnum ) {
    // Delegate request to service.
    rESTProductService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  /**
   * {@link RESTProductService#testEnumHeaderParams()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-enum-header-params", method = { RequestMethod.GET })
  public void testEnumHeaderParams( @RequestHeader(name = "Channel-Type", required = true) ChannelType pChannelType,
      @RequestHeader(name = "Time-Unit", required = true) TimeUnit pTimeUnit,
      @RequestHeader(name = "Extensible-Enum", required = true) ExtensibleEnum pExtensibleEnum ) {
    // Delegate request to service.
    rESTProductService.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  /**
   * {@link RESTProductService#testDateQueryParams()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-query-params/{path}", method = { RequestMethod.GET })
  public void testDateQueryParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestParam(name = "startTimestamp", required = true) String pStartTimestampAsBasicType,
      @RequestParam(name = "startTime", required = true) String pStartTimeAsBasicType,
      @RequestParam(name = "localStartTimestamp", required = true) String pLocalStartTimestampAsBasicType,
      @RequestParam(name = "localStartTime", required = true) String pLocalStartTimeAsBasicType,
      @RequestParam(name = "localStartDate", required = true) String pLocalStartDateAsBasicType,
      @RequestParam(name = "calendar", required = true) String pCalendarAsBasicType,
      @RequestParam(name = "utilDate", required = true) String pUtilDateAsBasicType,
      @RequestParam(name = "sqlTimestamp", required = true) String pSQLTimestampAsBasicType,
      @RequestParam(name = "sqlTime", required = true) String pSQLTimeAsBasicType,
      @RequestParam(name = "sqlDate", required = true) String pSQLDateAsBasicType,
      @RequestParam(name = "calendars", required = false) String[] pCalendarsAsBasicType ) {
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
    // Delegate request to service.
    rESTProductService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
  }

  /**
   * {@link RESTProductService#testDateQueryParamsBean()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-query-params-beans/{path}", method = { RequestMethod.GET })
  public void testDateQueryParamsBean( @PathVariable(name = "path", required = true) String pPath,
      @RequestParam(name = "offsetDateTime", required = true) String pOffsetDateTimeAsBasicType,
      @RequestParam(name = "offsetTime", required = true) String pOffsetTimeAsBasicType,
      @RequestParam(name = "localDateTime", required = true) String pLocalDateTimeAsBasicType,
      @RequestParam(name = "localTime", required = true) String pLocalTimeAsBasicType,
      @RequestParam(name = "localDate", required = true) String pLocalDateAsBasicType,
      @RequestParam(name = "utilDate", required = true) String pUtilDateAsBasicType,
      @RequestParam(name = "calendar", required = true) String pCalendarAsBasicType,
      @RequestParam(name = "sqlTimestamp", required = true) String pSqlTimestampAsBasicType,
      @RequestParam(name = "sqlTime", required = true) String pSqlTimeAsBasicType,
      @RequestParam(name = "sqlDate", required = true) String pSqlDateAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DateQueryParamsBean.Builder lQueryParamsBuilder = DateQueryParamsBean.builder();
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
    // Delegate request to service.
    rESTProductService.testDateQueryParamsBean(pPath, pQueryParams);
  }

  /**
   * {@link RESTProductService#testDateHeaderParams()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-header-params/{path}", method = { RequestMethod.GET })
  public void testDateHeaderParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) String pOffsetDateTimeAsBasicType,
      @RequestHeader(name = "Offset-Time", required = true) String pOffsetTimeAsBasicType,
      @RequestHeader(name = "Local-Date-Time", required = true) String pLocalDateTimeAsBasicType,
      @RequestHeader(name = "Local-Time", required = true) String pLocalTimeAsBasicType,
      @RequestHeader(name = "Local-Date", required = true) String pLocalDateAsBasicType,
      @RequestHeader(name = "Calendar", required = true) String pCalendarAsBasicType,
      @RequestHeader(name = "Util-Date", required = true) String pUtilDateAsBasicType,
      @RequestHeader(name = "SQL-Timestamp", required = true) String pSQLTimestampAsBasicType,
      @RequestHeader(name = "SQL-Time", required = true) String pSQLTimeAsBasicType,
      @RequestHeader(name = "SQL-Date", required = true) String pSQLDateAsBasicType,
      @RequestHeader(name = "util-dates", required = false) String[] pUtilDatesAsBasicType ) {
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
    // Delegate request to service.
    rESTProductService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
  }

  /**
   * {@link RESTProductService#testDateHeaderParamsBean()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "test-date-header-params-beans/{path}", method = { RequestMethod.GET })
  public void testDateHeaderParamsBean( @PathVariable(name = "path", required = true) String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) String pOffsetDateTimeAsBasicType,
      @RequestHeader(name = "Offset-Time", required = true) String pOffsetTimeAsBasicType,
      @RequestHeader(name = "Local-Date-Time", required = true) String pLocalDateTimeAsBasicType,
      @RequestHeader(name = "Local-Time", required = true) String pLocalTimeAsBasicType,
      @RequestHeader(name = "Local-Date", required = true) String pLocalDateAsBasicType,
      @RequestHeader(name = "Util-Date", required = true) String pUtilDateAsBasicType,
      @RequestHeader(name = "Calendar", required = true) String pCalendarAsBasicType,
      @RequestHeader(name = "SQL-Timestamp", required = true) String pSqlTimestampAsBasicType,
      @RequestHeader(name = "SQL-Time", required = true) String pSqlTimeAsBasicType,
      @RequestHeader(name = "SQL-Date", required = true) String pSqlDateAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DateHeaderParamsBean.Builder lHeaderParamsBuilder = DateHeaderParamsBean.builder();
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
    // Delegate request to service.
    rESTProductService.testDateHeaderParamsBean(pPath, pHeaderParams);
  }

  /**
   * {@link RESTProductService#testCookieParams()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "cookies", method = { RequestMethod.GET })
  public void testCookieParams(
      @CookieValue(name = "Channel-Type-Param", required = true) @RequestBody(
          required = true) ChannelType pChannelTypeParam,
      @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) String pQueryParam, String pLang,
      @RequestHeader(name = "specificHeader", required = true) String pSpecificHeader,
      @CookieValue(name = "Channel-Type", required = true) ChannelType pChannelType,
      @RequestHeader Map<String, String> pHeaders ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    SpecialContext.Builder lContextBuilder = SpecialContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    lContextBuilder.setSpecificHeader(pSpecificHeader);
    lContextBuilder.setChannelType(pChannelType);
    SpecialContext pContext = lContextBuilder.build();
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    // Delegate request to service.
    rESTProductService.testCookieParams(pChannelTypeParam, pContext);
  }

  /**
   * {@link RESTProductService#testOptionalQueryParams()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-optional-query-params", method = { RequestMethod.GET })
  public String testOptionalQueryParams(
      @RequestParam(name = "query1", required = false, defaultValue = "Just a default value") String query1,
      @RequestParam(name = "query2", required = true) int query2 ) {
    // Delegate request to service.
    return rESTProductService.testOptionalQueryParams(query1, query2);
  }

  /**
   * {@link RESTProductService#processComplexBookingID()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "complex/{bookingID}", method = { RequestMethod.GET })
  public boolean processComplexBookingID(
      @PathVariable(name = "bookingID", required = true) String pComplextBookingIDAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ComplexBookingID pComplextBookingID = compositeTypeConverter.deserializeObject(pComplextBookingIDAsBasicType,
        ComplexBookingID.class, COMPLEXBOOKINGID_SERIALIZED_CLASSES);
    // Delegate request to service.
    return rESTProductService.processComplexBookingID(pComplextBookingID);
  }

  /**
   * {@link RESTProductService#testDataTypesAsHeaderParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "dataTypesInHeader", method = { RequestMethod.GET })
  public String testDataTypesAsHeaderParam(
      @RequestHeader(name = "BookingID", required = true) String pBookingIDAsBasicType,
      @RequestHeader(name = "BookingCode", required = true) String pBookingCodeAsBasicType,
      @RequestHeader(name = "DoubleCode", required = true) Double pDoubleCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID =
        compositeTypeConverter.deserializeObject(pBookingIDAsBasicType, BookingID.class, BOOKINGID_SERIALIZED_CLASSES);
    BookingCode pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    DoubleCode pDoubleCode = DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build();
    // Delegate request to service.
    return rESTProductService.testDataTypesAsHeaderParam(pBookingID, pBookingCode, pDoubleCode);
  }

  /**
   * {@link RESTProductService#testDataTypesAsHeaderBeanParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "dataTypesInBeanHeader", method = { RequestMethod.GET })
  public String testDataTypesAsHeaderBeanParam(
      @RequestHeader(name = "bookingID", required = true) String pBookingIDAsBasicType,
      @RequestHeader(name = "bookingCode", required = true) String pBookingCodeAsBasicType,
      @RequestHeader(name = "DoubleCode", required = true) Double pDoubleCodeAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    AdvancedHeader.Builder lContextBuilder = AdvancedHeader.builder();
    // Handle bean parameter pContext.bookingID
    if (pBookingIDAsBasicType != null) {
      lContextBuilder.setBookingID(compositeTypeConverter.deserializeObject(pBookingIDAsBasicType, BookingID.class,
          BOOKINGID_SERIALIZED_CLASSES));
    }
    // Handle bean parameter pContext.bookingCode
    lContextBuilder.setBookingCode(BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    // Handle bean parameter pContext.doubleCode
    lContextBuilder.setDoubleCode(DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build());
    AdvancedHeader pContext = lContextBuilder.build();
    // Delegate request to service.
    return rESTProductService.testDataTypesAsHeaderBeanParam(pContext);
  }

  /**
   * {@link RESTProductService#testPrimitiveArrays()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveArrayAsBody", method = { RequestMethod.POST })
  public String testPrimitiveArrays( @RequestBody(required = true) int[] pIntegerArray ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveArrays(pIntegerArray);
  }

  /**
   * {@link RESTProductService#testDataTypeAsQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testDataTypeAsQueryParam", method = { RequestMethod.GET })
  public String testDataTypeAsQueryParam(
      @RequestParam(name = "bookingCode", required = true) String pBookingCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingCode pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    // Delegate request to service.
    return rESTProductService.testDataTypeAsQueryParam(pBookingCode);
  }

  /**
   * {@link RESTProductService#testDataTypeAsBeanQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testDataTypeAsBeanQueryParam", method = { RequestMethod.GET })
  public String testDataTypeAsBeanQueryParam(
      @RequestParam(name = "bookingCode", required = true) String pBookingCodeAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    QueryBeanParam.Builder lBeanParamBuilder = QueryBeanParam.builder();
    // Handle bean parameter pBeanParam.bookingCode
    lBeanParamBuilder.setBookingCode(BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    QueryBeanParam pBeanParam = lBeanParamBuilder.build();
    // Delegate request to service.
    return rESTProductService.testDataTypeAsBeanQueryParam(pBeanParam);
  }

  /**
   * {@link RESTProductService#testPrimitiveArrayAsQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveArrayAsQueryParam", method = { RequestMethod.GET })
  public String testPrimitiveArrayAsQueryParam( @RequestParam(name = "intValues", required = true) int[] pIntValues ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveArrayAsQueryParam(pIntValues);
  }

  /**
   * {@link RESTProductService#testSimpleTypesAsQueryParams()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testSimpleTypesAsQueryParams", method = { RequestMethod.GET })
  public String testSimpleTypesAsQueryParams(
      @RequestParam(name = "strings", required = false) List<String> pStrings ) {
    // Delegate request to service.
    return rESTProductService.testSimpleTypesAsQueryParams(pStrings);
  }

  /**
   * {@link RESTProductService#testPrimitiveWrapperArrayAsQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testPrimitiveWrapperArrayAsQueryParam", method = { RequestMethod.GET })
  public String testPrimitiveWrapperArrayAsQueryParam(
      @RequestParam(name = "integers", required = true) Set<Integer> pIntegers ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveWrapperArrayAsQueryParam(pIntegers);
  }

  /**
   * {@link RESTProductService#testMultivaluedQueryParamsBean()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultivaluedQueryParamsBean", method = { RequestMethod.GET })
  public String testMultivaluedQueryParamsBean( @RequestParam(name = "intArray", required = false) int[] pIntArray,
      @RequestParam(name = "strings", required = false) String[] pStrings,
      @RequestParam(name = "integers", required = false) Integer[] pIntegers ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    MultivaluedQueryParamsBean.Builder lBeanBuilder = MultivaluedQueryParamsBean.builder();
    lBeanBuilder.setIntArray(pIntArray);
    lBeanBuilder.setStrings(pStrings);
    lBeanBuilder.setIntegers(pIntegers);
    MultivaluedQueryParamsBean pBean = lBeanBuilder.build();
    // Delegate request to service.
    return rESTProductService.testMultivaluedQueryParamsBean(pBean);
  }

  /**
   * {@link RESTProductService#testMulitvaluedDataTypeAsQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMulitvaluedDataTypeAsQueryParam", method = { RequestMethod.GET })
  public String testMulitvaluedDataTypeAsQueryParam(
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "longCodes", required = true) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestParam(name = "localDates", required = false) String[] pLocalDatesAsBasicType ) {
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
        pBookingIDs.add(compositeTypeConverter.deserializeObject(lNext, BookingID.class, BOOKINGID_SERIALIZED_CLASSES));
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
    // Delegate request to service.
    return rESTProductService.testMulitvaluedDataTypeAsQueryParam(pCodes, pLongCodes, pBookingIDs, pTimestamps,
        pLocalDates);
  }

  /**
   * {@link RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMulitvaluedDataTypeAsBeanQueryParam", method = { RequestMethod.GET })
  public String testMulitvaluedDataTypeAsBeanQueryParam(
      @RequestParam(name = "longCodes", required = false) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "doubleCodes", required = false) Double[] pDoubleCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "bookingIDsArray", required = false) String[] pBookingIDsArrayAsBasicType,
      @RequestParam(name = "offsetDateTime", required = true) String pOffsetDateTimeAsBasicType,
      @RequestParam(name = "offsetTime", required = true) String pOffsetTimeAsBasicType,
      @RequestParam(name = "localDateTime", required = true) String pLocalDateTimeAsBasicType,
      @RequestParam(name = "localTime", required = true) String pLocalTimeAsBasicType,
      @RequestParam(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestParam(name = "times", required = false) String[] pTimesAsBasicType,
      @RequestParam(name = "startTimestamps", required = false) String[] pStartTimestampsAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DataTypesQueryBean.Builder lQueryBeanBuilder = DataTypesQueryBean.builder();
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
        lBookingIDs.add(compositeTypeConverter.deserializeObject(lNext, BookingID.class, BOOKINGID_SERIALIZED_CLASSES));
      }
      lQueryBeanBuilder.setBookingIDs(lBookingIDs);
    }
    // Handle bean parameter pQueryBean.bookingIDsArray
    if (pBookingIDsArrayAsBasicType != null) {
      // Handle bean parameter pQueryBean.bookingIDsArray
      BookingID[] lBookingIDsArray = new BookingID[pBookingIDsArrayAsBasicType.length];
      for (int i = 0; i < pBookingIDsArrayAsBasicType.length; i++) {
        lBookingIDsArray[i] = compositeTypeConverter.deserializeObject(pBookingIDsArrayAsBasicType[i], BookingID.class,
            BOOKINGID_SERIALIZED_CLASSES);
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
    // Delegate request to service.
    return rESTProductService.testMulitvaluedDataTypeAsBeanQueryParam(pQueryBean);
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFieldsInBeanParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultiValuedHeaderFieldsInBeanParam", method = { RequestMethod.GET })
  public String testMultiValuedHeaderFieldsInBeanParam(
      @RequestHeader(name = "names", required = false) String[] pNames,
      @RequestHeader(name = "ints", required = true) int[] pInts,
      @RequestHeader(name = "doubles", required = false) Double[] pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "stringCodeList", required = false) String[] pStringCodeListAsBasicType,
      @RequestHeader(name = "startDate", required = false) String pStartDateAsBasicType,
      @RequestHeader(name = "dates", required = false) String[] pDatesAsBasicType,
      @RequestHeader(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestHeader(name = "calendars", required = false) String[] pCalendarsAsBasicType,
      @RequestHeader(name = "utilDates", required = false) String[] pUtilDatesAsBasicType,
      @RequestHeader(name = "sqlTimestamps", required = false) String[] pSqlTimestampsAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    MultiValuedHeaderBeanParam.Builder lMultiValuedBeanBuilder = MultiValuedHeaderBeanParam.builder();
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
    MultiValuedHeaderBeanParam pMultiValuedBean = lMultiValuedBeanBuilder.build();
    // Delegate request to service.
    return rESTProductService.testMultiValuedHeaderFieldsInBeanParam(pMultiValuedBean);
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFields()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "testMultiValuedHeaderFields", method = { RequestMethod.GET })
  public String testMultiValuedHeaderFields( @RequestHeader(name = "names", required = false) Set<String> pNames,
      @RequestHeader(name = "ints", required = true) int[] pInts,
      @RequestHeader(name = "doubles", required = false) Set<Double> pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "startDate", required = false) String pStartDateAsBasicType,
      @RequestHeader(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestHeader(name = "times", required = false) String[] pTimesAsBasicType ) {
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
    // Delegate request to service.
    return rESTProductService.testMultiValuedHeaderFields(pNames, pInts, pDoubles, pCodes, pStartDate, pTimestamps,
        pTimes);
  }

  /**
   * {@link RESTProductService#testBookingIDAsPathParam()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "booking-id-as-path-param/{bookingID}", method = { RequestMethod.PATCH })
  public void testBookingIDAsPathParam(
      @PathVariable(name = "bookingID", required = true) String pBookingIDAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID =
        compositeTypeConverter.deserializeObject(pBookingIDAsBasicType, BookingID.class, BOOKINGID_SERIALIZED_CLASSES);
    // Delegate request to service.
    rESTProductService.testBookingIDAsPathParam(pBookingID);
  }
}
