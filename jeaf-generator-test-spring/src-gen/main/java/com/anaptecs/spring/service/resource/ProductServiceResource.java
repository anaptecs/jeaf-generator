/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

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
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;
import com.anaptecs.spring.base.TechnicalHeaderContext;
import com.anaptecs.spring.service.ChildBeanParameterType;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.LocalBeanParamType;
import com.anaptecs.spring.service.ProductService;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@RequestMapping(path = "/nova/prefix/products", consumes = { "application/json" }, produces = { "application/json" })
@RestController
public class ProductServiceResource {
  /**
   * All request to this class will be delegated to {@link ProductService}.
   */
  private final ProductService productService;

  /**
   * Initialize object.
   * 
   * @param pProductService Dependency on concrete {@link ProductService} implementation that should be used.
   */
  public ProductServiceResource( ProductService pProductService ) {
    productService = pProductService;
  }

  /**
   * {@link ProductService#getProducts()}
   */
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( ) {
    // Delegate request to service.
    return productService.getProducts();
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Delegate request to service.
    return productService.getProduct(pProductID);
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Delegate request to service.
    return productService.createProduct(pProduct);
  }

  /**
   * {@link ProductService#getSortiment()}
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
    return productService.getSortiment(pContext);
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @RequestMapping(
      path = "ChannelCode",
      consumes = { "application/json" },
      produces = { "application/json" },
      method = { RequestMethod.POST })
  public ChannelCode createChannelCode( @RequestBody(required = true) String pChannelCode ) {
    // Delegate request to service.
    return productService.createChannelCode(pChannelCode);
  }

  /**
   * {@link ProductService#ping()}
   */
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Delegate request to service.
    productService.ping();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @RequestMapping(path = "deprecated/operation", method = { RequestMethod.GET })
  @Deprecated
  public String deprecatedOperation( ) {
    // Delegate request to service.
    return productService.deprecatedOperation();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @RequestMapping(path = "deprecated/context", method = { RequestMethod.POST })
  public String deprecatedContext( @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @RequestParam(name = "q1", required = true) String pQueryParam ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DeprecatedContext.Builder lContextBuilder = DeprecatedContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setQueryParam(pQueryParam);
    DeprecatedContext pContext = lContextBuilder.build();
    // Delegate request to service.
    return productService.deprecatedContext(pContext);
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @RequestMapping(path = "deprecated/beanParams", method = { RequestMethod.POST })
  public void deprecatedBeanParam( @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @RequestParam(name = "q2", required = true) @Deprecated String pOldStyle ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    BeanParameter.Builder lBeanParamBuilder = BeanParameter.builder();
    lBeanParamBuilder.setAccessToken(pAccessToken);
    lBeanParamBuilder.setLanguage(pLanguage);
    lBeanParamBuilder.setOldStyle(pOldStyle);
    BeanParameter pBeanParam = lBeanParamBuilder.build();
    // Delegate request to service.
    productService.deprecatedBeanParam(pBeanParam);
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @RequestMapping(path = "deprecated/params", method = { RequestMethod.POST })
  @Deprecated
  public String deprecatedParams( @RequestHeader(name = "param1", required = true) @Deprecated int pParam1 ) {
    // Delegate request to service.
    return productService.deprecatedParams(pParam1);
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @RequestMapping(path = "deprecated/body", method = { RequestMethod.POST })
  public String deprecatedBody( @RequestBody(required = true) @Deprecated String pBody ) {
    // Delegate request to service.
    return productService.deprecatedBody(pBody);
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @RequestMapping(path = "deprecated/complexBody", method = { RequestMethod.POST })
  public void deprectedComplexRequestBody( @RequestBody(required = true) @Deprecated Product pProduct ) {
    // Delegate request to service.
    productService.deprectedComplexRequestBody(pProduct);
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @RequestMapping(path = "deprecated/complexReturn", method = { RequestMethod.GET })
  @Deprecated
  public Product deprecatedComplexReturn( ) {
    // Delegate request to service.
    return productService.deprecatedComplexReturn();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @RequestMapping(path = "specific/{id}", method = { RequestMethod.PATCH })
  public void loadSpecificThings( @RequestHeader(name = "token", required = true) String pAccessToken,
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
    productService.loadSpecificThings(pContext);
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @RequestMapping(path = "ChannelCodeObject", method = { RequestMethod.POST })
  public ChannelCode createChannelCodeFromObject( @RequestBody(required = true) ChannelCode pChannelCode ) {
    // Delegate request to service.
    return productService.createChannelCodeFromObject(pChannelCode);
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @RequestMapping(path = "currencies", method = { RequestMethod.POST })
  public List<CurrencyCode> addCurrencies( @RequestBody(required = true) List<CurrencyCode> pCurrencies ) {
    // Delegate request to service.
    return productService.addCurrencies(pCurrencies);
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @RequestMapping(path = "currencies/valid", method = { RequestMethod.POST })
  public CurrencyCode isCurrencySupported( @RequestBody(required = true) CurrencyCode pCurrency ) {
    // Delegate request to service.
    return productService.isCurrencySupported(pCurrency);
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @RequestMapping(path = "codeTypeUsages", method = { RequestMethod.POST })
  public IntegerCodeType testCodeTypeUsage( @RequestBody(required = true) StringCodeType pStringCode ) {
    // Delegate request to service.
    return productService.testCodeTypeUsage(pStringCode);
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @RequestMapping(path = "LocalBeanParam", method = { RequestMethod.GET })
  public String testLocalBeanParamType( @RequestHeader(name = "localKey", required = true) String pLocalKey,
      @RequestHeader(name = "localID", required = true) String pLocalID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    LocalBeanParamType.Builder lBeanParamBuilder = LocalBeanParamType.builder();
    lBeanParamBuilder.setLocalKey(pLocalKey);
    lBeanParamBuilder.setLocalID(pLocalID);
    LocalBeanParamType pBeanParam = lBeanParamBuilder.build();
    // Delegate request to service.
    return productService.testLocalBeanParamType(pBeanParam);
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @RequestMapping(path = "ExternalBeanParam", method = { RequestMethod.GET })
  public String testExternalBeanParameterType( @RequestHeader(name = "novaKey", required = true) String pNovaKey,
      @RequestHeader(name = "tkID", required = true) String pTkID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ParentBeanParamType.Builder lParentBuilder = ParentBeanParamType.builder();
    lParentBuilder.setNovaKey(pNovaKey);
    lParentBuilder.setTkID(pTkID);
    ParentBeanParamType pParent = lParentBuilder.build();
    // Delegate request to service.
    return productService.testExternalBeanParameterType(pParent);
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @RequestMapping(path = "ChildBeanParam", method = { RequestMethod.GET })
  public String testChildBeanParameter( @RequestHeader(name = "novaKey", required = true) String pNovaKey,
      @RequestHeader(name = "tkID", required = true) String pTkID,
      @RequestHeader(name = "X-Child-Property", required = true) String pChildProperty ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ChildBeanParameterType.Builder lChildBuilder = ChildBeanParameterType.builder();
    lChildBuilder.setNovaKey(pNovaKey);
    lChildBuilder.setTkID(pTkID);
    lChildBuilder.setChildProperty(pChildProperty);
    ChildBeanParameterType pChild = lChildBuilder.build();
    // Delegate request to service.
    return productService.testChildBeanParameter(pChild);
  }

  /**
   * {@link ProductService#testDateQueryParams()}
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
    productService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link ProductService#testDateQueryParamsBean()}
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
    productService.testDateQueryParamsBean(pPath, pQueryParams);
  }

  /**
   * {@link ProductService#testDateHeaderParams()}
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
    productService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link ProductService#testDateHeaderParamsBean()}
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
    productService.testDateHeaderParamsBean(pPath, pHeaderParams);
  }

  /**
   * {@link ProductService#testTechnicalHeaderParam()}
   */
  @RequestMapping(path = "technicalHeaderParam", method = { RequestMethod.GET })
  public String testTechnicalHeaderParam( @RequestHeader(name = "Reseller", required = true) String pReseller ) {
    // Delegate request to service.
    return productService.testTechnicalHeaderParam(pReseller);
  }

  /**
   * {@link ProductService#testTechnicalHeaderBean()}
   */
  @RequestMapping(path = "technicalHeaderBeanParam", method = { RequestMethod.GET })
  public String testTechnicalHeaderBean( @RequestHeader(name = "Reseller", required = true) String pReseller,
      @RequestHeader Map<String, String> pHeaders ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    TechnicalHeaderContext.Builder lContextBuilder = TechnicalHeaderContext.builder();
    lContextBuilder.setReseller(pReseller);
    TechnicalHeaderContext pContext = lContextBuilder.build();
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
    }
    // Delegate request to service.
    return productService.testTechnicalHeaderBean(pContext);
  }
}
