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

import com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;
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

@RequestMapping(path = "/nova/prefix/products")
@RestController
public class ProductServiceResource {
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
   * All request to this class will be delegated to {@link ProductService}.
   */
  private final ProductService productService;

  /**
   * Initialize object.
   *
   * @param pProductService Dependency on concrete {@link ProductService} implementation that should be used.
   */
  public ProductServiceResource( ProductService pProductService, ValidationExecutor pValidationExecutor,
      CustomHeaderFilter pCustomHeaderFilter ) {
    productService = pProductService;
    validationExecutor = pValidationExecutor;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link ProductService#getProducts()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( ) {
    // Delegate request to service.
    List<Product> lResponse = productService.getProducts();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProductID);
    // Delegate request to service.
    Product lResponse = productService.getProduct(pProductID);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProduct);
    // Delegate request to service.
    boolean lResponse = productService.createProduct(pProduct);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#getSortiment()}
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
    // Delegate request to service.
    Sortiment lResponse = productService.getSortiment(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(
      path = "ChannelCode",
      consumes = { "application/json" },
      produces = { "application/json" },
      method = { RequestMethod.POST })
  public ChannelCode createChannelCode( @RequestBody(required = true) String pChannelCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChannelCode);
    // Delegate request to service.
    ChannelCode lResponse = productService.createChannelCode(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#ping()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Delegate request to service.
    productService.ping();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "deprecated/operation", method = { RequestMethod.GET })
  @Deprecated
  public String deprecatedOperation( ) {
    // Delegate request to service.
    String lResponse = productService.deprecatedOperation();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @ResponseStatus(HttpStatus.OK)
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
    // Delegate request to service.
    String lResponse = productService.deprecatedContext(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBeanParam);
    // Delegate request to service.
    productService.deprecatedBeanParam(pBeanParam);
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "deprecated/params", method = { RequestMethod.POST })
  @Deprecated
  public String deprecatedParams( @RequestHeader(name = "param1", required = true) @Deprecated int pParam1 ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pParam1);
    // Delegate request to service.
    String lResponse = productService.deprecatedParams(pParam1);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "deprecated/body", method = { RequestMethod.POST })
  public String deprecatedBody( @RequestBody(required = true) @Deprecated String pBody ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBody);
    // Delegate request to service.
    String lResponse = productService.deprecatedBody(pBody);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "deprecated/complexBody", method = { RequestMethod.POST })
  public void deprectedComplexRequestBody( @RequestBody(required = true) @Deprecated Product pProduct ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProduct);
    // Delegate request to service.
    productService.deprectedComplexRequestBody(pProduct);
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "deprecated/complexReturn", method = { RequestMethod.GET })
  @Deprecated
  public Product deprecatedComplexReturn( ) {
    // Delegate request to service.
    Product lResponse = productService.deprecatedComplexReturn();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
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
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
    // Delegate request to service.
    productService.loadSpecificThings(pContext);
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "ChannelCodeObject", method = { RequestMethod.POST })
  public ChannelCode createChannelCodeFromObject( @RequestBody(required = true) ChannelCode pChannelCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChannelCode);
    // Delegate request to service.
    ChannelCode lResponse = productService.createChannelCodeFromObject(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "currencies", method = { RequestMethod.POST })
  public List<CurrencyCode> addCurrencies( @RequestBody(required = true) List<CurrencyCode> pCurrencies ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pCurrencies);
    // Delegate request to service.
    List<CurrencyCode> lResponse = productService.addCurrencies(pCurrencies);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "currencies/valid", method = { RequestMethod.POST })
  public CurrencyCode isCurrencySupported( @RequestBody(required = true) CurrencyCode pCurrency ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pCurrency);
    // Delegate request to service.
    CurrencyCode lResponse = productService.isCurrencySupported(pCurrency);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "codeTypeUsages", method = { RequestMethod.POST })
  public IntegerCodeType testCodeTypeUsage( @RequestBody(required = true) StringCodeType pStringCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pStringCode);
    // Delegate request to service.
    IntegerCodeType lResponse = productService.testCodeTypeUsage(pStringCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "LocalBeanParam", method = { RequestMethod.GET })
  public String testLocalBeanParamType( @RequestHeader(name = "localKey", required = true) String pLocalKey,
      @RequestHeader(name = "localID", required = true) String pLocalID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    LocalBeanParamType.Builder lBeanParamBuilder = LocalBeanParamType.builder();
    lBeanParamBuilder.setLocalKey(pLocalKey);
    lBeanParamBuilder.setLocalID(pLocalID);
    LocalBeanParamType pBeanParam = lBeanParamBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBeanParam);
    // Delegate request to service.
    String lResponse = productService.testLocalBeanParamType(pBeanParam);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "ExternalBeanParam", method = { RequestMethod.GET })
  public String testExternalBeanParameterType( @RequestHeader(name = "novaKey", required = true) String pNovaKey,
      @RequestHeader(name = "tkID", required = true) String pTkID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ParentBeanParamType.Builder lParentBuilder = ParentBeanParamType.builder();
    lParentBuilder.setNovaKey(pNovaKey);
    lParentBuilder.setTkID(pTkID);
    ParentBeanParamType pParent = lParentBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pParent);
    // Delegate request to service.
    String lResponse = productService.testExternalBeanParameterType(pParent);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @ResponseStatus(HttpStatus.OK)
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChild);
    // Delegate request to service.
    String lResponse = productService.testChildBeanParameter(pChild);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testDateQueryParams()}
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
      @RequestParam(name = "sqlDate", required = true) String pSQLDateAsBasicType ) {
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
        pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    // Delegate request to service.
    productService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link ProductService#testDateQueryParamsBean()}
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pQueryParams);
    // Delegate request to service.
    productService.testDateQueryParamsBean(pPath, pQueryParams);
  }

  /**
   * {@link ProductService#testDateHeaderParams()}
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
      @RequestHeader(name = "SQL-Date", required = true) String pSQLDateAsBasicType ) {
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime,
        pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    // Delegate request to service.
    productService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link ProductService#testDateHeaderParamsBean()}
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pHeaderParams);
    // Delegate request to service.
    productService.testDateHeaderParamsBean(pPath, pHeaderParams);
  }

  /**
   * {@link ProductService#testTechnicalHeaderParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "technicalHeaderParam", method = { RequestMethod.GET })
  public String testTechnicalHeaderParam( @RequestHeader(name = "Reseller", required = true) String pReseller ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pReseller);
    // Delegate request to service.
    String lResponse = productService.testTechnicalHeaderParam(pReseller);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link ProductService#testTechnicalHeaderBean()}
   */
  @ResponseStatus(HttpStatus.OK)
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
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
    // Delegate request to service.
    String lResponse = productService.testTechnicalHeaderBean(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResponse);
    return lResponse;
  }
}
