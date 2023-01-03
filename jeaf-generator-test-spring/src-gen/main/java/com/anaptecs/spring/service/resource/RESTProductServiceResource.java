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

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
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
      CompositeTypeConverter pCompositeTypeConverter ) {
    rESTProductService = pRESTProductService;
    compositeTypeConverter = pCompositeTypeConverter;
  }

  /**
   * {@link RESTProductService#getProducts()}
   */
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( @RequestParam(name = "maxResult", required = true) int pMaxResultSize ) {
    // Delegate request to service.
    return rESTProductService.getProducts(pMaxResultSize);
  }

  /**
   * {@link RESTProductService#getProduct()}
   */
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Delegate request to service.
    return rESTProductService.getProduct(pProductID);
  }

  /**
   * {@link RESTProductService#createProduct()}
   */
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Delegate request to service.
    return rESTProductService.createProduct(pProduct);
  }

  /**
   * {@link RESTProductService#getSortiment()}
   */
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
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
    }
    // Delegate request to service.
    return rESTProductService.getSortiment(pContext);
  }

  /**
   * {@link RESTProductService#createChannelCode()}
   */
  @RequestMapping(path = "ChannelCode", method = { RequestMethod.POST })
  public ChannelCode createChannelCode( @RequestBody(required = true) String pChannelCode ) {
    // Delegate request to service.
    return rESTProductService.createChannelCode(pChannelCode);
  }

  /**
   * {@link RESTProductService#ping()}
   */
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Delegate request to service.
    rESTProductService.ping();
  }

  /**
   * {@link RESTProductService#testInit()}
   */
  @RequestMapping(path = "test-init", method = { RequestMethod.GET })
  public void testInit( ) {
    // Delegate request to service.
    rESTProductService.testInit();
  }

  /**
   * {@link RESTProductService#getSupportedCurrencies()}
   */
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
  @RequestMapping(path = "test-date-query-params/{path}", method = { RequestMethod.GET })
  public void testDateQueryParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestParam(name = "startTimestamp", required = true) OffsetDateTime pStartTimestamp,
      @RequestParam(name = "startTime", required = true) OffsetTime pStartTime,
      @RequestParam(name = "localStartTimestamp", required = true) LocalDateTime pLocalStartTimestamp,
      @RequestParam(name = "localStartTime", required = true) LocalTime pLocalStartTime,
      @RequestParam(name = "localStartDate", required = true) LocalDate pLocalStartDate,
      @RequestParam(name = "calendar", required = true) Calendar pCalendar,
      @RequestParam(name = "utilDate", required = true) java.util.Date pUtilDate,
      @RequestParam(name = "sqlTimestamp", required = true) Timestamp pSQLTimestamp,
      @RequestParam(name = "sqlTime", required = true) Time pSQLTime,
      @RequestParam(name = "sqlDate", required = true) Date pSQLDate ) {
    // Delegate request to service.
    rESTProductService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link RESTProductService#testDateQueryParamsBean()}
   */
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
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pSqlTimestampAsBasicType);
        lQueryParamsBuilder.setSqlTimestamp(new Timestamp(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("HH:mm:ss.SSSXXX").parse(pSqlTimeAsBasicType);
        lQueryParamsBuilder.setSqlTime(new Time(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd").parse(pSqlDateAsBasicType);
        lQueryParamsBuilder.setSqlDate(new Date(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    DateQueryParamsBean pQueryParams = lQueryParamsBuilder.build();
    // Delegate request to service.
    rESTProductService.testDateQueryParamsBean(pPath, pQueryParams);
  }

  /**
   * {@link RESTProductService#testDateHeaderParams()}
   */
  @RequestMapping(path = "test-date-header-params/{path}", method = { RequestMethod.GET })
  public void testDateHeaderParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) OffsetDateTime pOffsetDateTime,
      @RequestHeader(name = "Offset-Time", required = true) OffsetTime pOffsetTime,
      @RequestHeader(name = "Local-Date-Time", required = true) LocalDateTime pLocalDateTime,
      @RequestHeader(name = "Local-Time", required = true) LocalTime pLocalTime,
      @RequestHeader(name = "Local-Date", required = true) LocalDate pLocalDate,
      @RequestHeader(name = "Calendar", required = true) Calendar pCalendar,
      @RequestHeader(name = "Util-Date", required = true) java.util.Date pUtilDate,
      @RequestHeader(name = "SQL-Timestamp", required = true) Timestamp pSQLTimestamp,
      @RequestHeader(name = "SQL-Time", required = true) Time pSQLTime,
      @RequestHeader(name = "SQL-Date", required = true) Date pSQLDate ) {
    // Delegate request to service.
    rESTProductService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link RESTProductService#testDateHeaderParamsBean()}
   */
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
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pSqlTimestampAsBasicType);
        lHeaderParamsBuilder.setSqlTimestamp(new Timestamp(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("HH:mm:ss.SSSXXX").parse(pSqlTimeAsBasicType);
        lHeaderParamsBuilder.setSqlTime(new Time(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      try {
        java.util.Date lDate = new SimpleDateFormat("yyyy-MM-dd").parse(pSqlDateAsBasicType);
        lHeaderParamsBuilder.setSqlDate(new Date(lDate.getTime()));
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    DateHeaderParamsBean pHeaderParams = lHeaderParamsBuilder.build();
    // Delegate request to service.
    rESTProductService.testDateHeaderParamsBean(pPath, pHeaderParams);
  }

  /**
   * {@link RESTProductService#testCookieParams()}
   */
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
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
    }
    // Delegate request to service.
    rESTProductService.testCookieParams(pChannelTypeParam, pContext);
  }

  /**
   * {@link RESTProductService#testOptionalQueryParams()}
   */
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
  @RequestMapping(path = "testPrimitiveArrayAsBody", method = { RequestMethod.POST })
  public String testPrimitiveArrays( @RequestBody(required = true) int[] pIntegerArray ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveArrays(pIntegerArray);
  }

  /**
   * {@link RESTProductService#testDataTypeAsQueryParam()}
   */
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
  @RequestMapping(path = "testPrimitiveArrayAsQueryParam", method = { RequestMethod.GET })
  public String testPrimitiveArrayAsQueryParam( @RequestParam(name = "intValues", required = true) int[] pIntValues ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveArrayAsQueryParam(pIntValues);
  }

  /**
   * {@link RESTProductService#testSimpleTypesAsQueryParams()}
   */
  @RequestMapping(path = "testSimpleTypesAsQueryParams", method = { RequestMethod.GET })
  public String testSimpleTypesAsQueryParams(
      @RequestParam(name = "strings", required = false) List<String> pStrings ) {
    // Delegate request to service.
    return rESTProductService.testSimpleTypesAsQueryParams(pStrings);
  }

  /**
   * {@link RESTProductService#testPrimitiveWrapperArrayAsQueryParam()}
   */
  @RequestMapping(path = "testPrimitiveWrapperArrayAsQueryParam", method = { RequestMethod.GET })
  public String testPrimitiveWrapperArrayAsQueryParam(
      @RequestParam(name = "integers", required = true) Set<Integer> pIntegers ) {
    // Delegate request to service.
    return rESTProductService.testPrimitiveWrapperArrayAsQueryParam(pIntegers);
  }

  /**
   * {@link RESTProductService#testMultivaluedQueryParamsBean()}
   */
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
  @RequestMapping(path = "testMulitvaluedDataTypeAsQueryParam", method = { RequestMethod.GET })
  public String testMulitvaluedDataTypeAsQueryParam(
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "longCodes", required = true) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType ) {
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
    // Delegate request to service.
    return rESTProductService.testMulitvaluedDataTypeAsQueryParam(pCodes, pLongCodes, pBookingIDs);
  }

  /**
   * {@link RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam()}
   */
  @RequestMapping(path = "testMulitvaluedDataTypeAsBeanQueryParam", method = { RequestMethod.GET })
  public String testMulitvaluedDataTypeAsBeanQueryParam(
      @RequestParam(name = "longCodes", required = false) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "doubleCodes", required = false) Double[] pDoubleCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "bookingIDsArray", required = false) String[] pBookingIDsArrayAsBasicType ) {
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
    DataTypesQueryBean pQueryBean = lQueryBeanBuilder.build();
    // Delegate request to service.
    return rESTProductService.testMulitvaluedDataTypeAsBeanQueryParam(pQueryBean);
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFieldsInBeanParam()}
   */
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
      try {
        Timestamp[] lSqlTimestamps = new Timestamp[pSqlTimestampsAsBasicType.length];
        for (int i = 0; i < pSqlTimestampsAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pSqlTimestampsAsBasicType[i]);
          lSqlTimestamps[i] = new Timestamp(lDate.getTime());
        }
        lMultiValuedBeanBuilder.setSqlTimestamps(lSqlTimestamps);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    MultiValuedHeaderBeanParam pMultiValuedBean = lMultiValuedBeanBuilder.build();
    // Delegate request to service.
    return rESTProductService.testMultiValuedHeaderFieldsInBeanParam(pMultiValuedBean);
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFields()}
   */
  @RequestMapping(path = "testMultiValuedHeaderFields", method = { RequestMethod.GET })
  public String testMultiValuedHeaderFields( @RequestHeader(name = "names", required = false) Set<String> pNames,
      @RequestHeader(name = "ints", required = true) int[] pInts,
      @RequestHeader(name = "doubles", required = false) Set<Double> pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "startDate", required = false) OffsetDateTime pStartDate,
      @RequestHeader(name = "timestamps", required = false) Set<OffsetDateTime> pTimestamps,
      @RequestHeader(name = "times", required = false) Set<OffsetTime> pTimes ) {
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
    // Delegate request to service.
    return rESTProductService.testMultiValuedHeaderFields(pNames, pInts, pDoubles, pCodes, pStartDate, pTimestamps,
        pTimes);
  }
}
