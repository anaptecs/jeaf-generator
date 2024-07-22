/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

@org.springframework.web.bind.annotation.RequestMapping(path = "/nova/prefix/rest-products")
@org.springframework.web.bind.annotation.RestController
public class RESTProductServiceReactiveResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final com.anaptecs.jeaf.validation.api.ValidationExecutor validationExecutor;

  /**
   * Filter is used to provide only those headers that are configured to be processed by this REST resource.
   */
  private final com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter customHeaderFilter;

  /**
   * All request to this class will be delegated to {@link com.anaptecs.spring.service.RESTProductService}.
   */
  private final com.anaptecs.spring.service.RESTProductServiceReactive rESTProductService;

  /**
   * Initialize object.
   *
   * @param pRESTProductService Dependency on concrete {@link com.anaptecs.spring.service.RESTProductService}
   * implementation that should be used.
   * @param pCompositeTypeConverter Composite type converter is used convert types from their string representation to a
   * real object that can be processed internally.
   */
  public RESTProductServiceReactiveResource( com.anaptecs.spring.service.RESTProductServiceReactive pRESTProductService,
      com.fasterxml.jackson.databind.ObjectMapper pObjectMapper,
      com.anaptecs.jeaf.validation.api.ValidationExecutor pValidationExecutor,
      com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter pCustomHeaderFilter ) {
    rESTProductService = pRESTProductService;
    objectMapper = pObjectMapper;
    validationExecutor = pValidationExecutor;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getProducts()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Customer', 'Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  public reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.Product>> getProducts(
      @org.springframework.web.bind.annotation.RequestParam(name = "maxResult", required = false) int pMaxResultSize,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pMaxResultSize);
      // Delegate request to service.
      return rESTProductService.getProducts(pMaxResultSize);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getProduct()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "{id}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> getProduct(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "id",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pProductID,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pProductID);
      // Delegate request to service.
      return rESTProductService.getProduct(pProductID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#createProduct()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  public reactor.core.publisher.Mono<Boolean> createProduct( @org.springframework.web.bind.annotation.RequestBody(
      required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> pProduct,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return rESTProductService.createProduct(pProductBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSortiment()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "sortiment/{id}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.Sortiment> getSortiment(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "token",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pAccessToken,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "lang",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.util.Locale pLanguage,
      @org.springframework.web.bind.annotation.CookieValue(name = "reseller", required = true) long pResellerID,
      @org.springframework.web.bind.annotation.PathVariable(name = "id", required = true) long pPathParam,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "q1",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pQueryParam,
      @com.anaptecs.annotations.MyNotNullRESTParam String pLang,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "intCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam int pIntCodeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader java.util.Map<String, String> pHeaders,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.Context.Builder lContextBuilder = com.anaptecs.spring.base.Context.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    // Handle bean parameter pContext.intCode
    lContextBuilder.setIntCode(com.anaptecs.spring.base.IntegerCodeType.builder().setCode(pIntCodeAsBasicType).build());
    com.anaptecs.spring.base.Context pContext = lContextBuilder.build();
    // Add custom headers.
    for (java.util.Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.getSortiment(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#createChannelCode()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "ChannelCode",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.ChannelCode> createChannelCode(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<java.lang.String> pChannelCode,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pChannelCodeBody);
      // Delegate request to service.
      return rESTProductService.createChannelCode(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#ping()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Customer', 'Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      method = { org.springframework.web.bind.annotation.RequestMethod.HEAD })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> ping( org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return rESTProductService.ping();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testInit()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-init",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testInit(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return rESTProductService.testInit();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrencies()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "currencies/{channelCode}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  public reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.CurrencyCode>> getSupportedCurrencies(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "channelCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pChannelCodeAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.ChannelCode pChannelCode;
    if (pChannelCodeAsBasicType != null) {
      pChannelCode = com.anaptecs.spring.base.ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    }
    else {
      pChannelCode = null;
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pChannelCode);
      // Delegate request to service.
      return rESTProductService.getSupportedCurrencies(pChannelCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrenciesAsync()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "async-currencies/{channelCode}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  public reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.CurrencyCode>> getSupportedCurrenciesAsync(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "channelCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pChannelCodeAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.ChannelCode pChannelCode;
    if (pChannelCodeAsBasicType != null) {
      pChannelCode = com.anaptecs.spring.base.ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    }
    else {
      pChannelCode = null;
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pChannelCode);
      // Delegate request to service.
      return rESTProductService.getSupportedCurrenciesAsync(pChannelCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-params",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testParams(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Big-Header",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.math.BigDecimal pBigDecimalHeader,
      @org.springframework.web.bind.annotation.CookieValue(
          name = "giveMeMoreCookies",
          required = true) int pIntCookieParam,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "locale",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.util.Locale pLocaleQueryParam,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
      // Delegate request to service.
      return rESTProductService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testEnumParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-enum-params/{channelType}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testEnumParams( @org.springframework.web.bind.annotation.PathVariable(
      name = "channelType",
      required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ChannelType pChannelType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timeUnit",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.TimeUnit pTimeUnit,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "extensibleEnum",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ExtensibleEnum pExtensibleEnum,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pChannelType,
          pTimeUnit, pExtensibleEnum);
      // Delegate request to service.
      return rESTProductService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testEnumHeaderParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-enum-header-params",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testEnumHeaderParams( @org.springframework.web.bind.annotation.RequestHeader(
      name = "Channel-Type",
      required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ChannelType pChannelType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Time-Unit",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.TimeUnit pTimeUnit,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Extensible-Enum",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ExtensibleEnum pExtensibleEnum,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pChannelType,
          pTimeUnit, pExtensibleEnum);
      // Delegate request to service.
      return rESTProductService.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-date-query-params/{path}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testDateQueryParams(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "path",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pPath,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "startTimestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pStartTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "startTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pStartTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localStartTimestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalStartTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localStartTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalStartTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localStartDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalStartDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "calendar",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pCalendarAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "utilDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pUtilDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlTimestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "calendars",
          required = false) String[] pCalendarsAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert date types into real objects.
    java.time.OffsetDateTime pStartTimestamp;
    if (pStartTimestampAsBasicType != null) {
      pStartTimestamp = java.time.OffsetDateTime.parse(pStartTimestampAsBasicType);
    }
    else {
      pStartTimestamp = null;
    }
    java.time.OffsetTime pStartTime;
    if (pStartTimeAsBasicType != null) {
      pStartTime = java.time.OffsetTime.parse(pStartTimeAsBasicType);
    }
    else {
      pStartTime = null;
    }
    java.time.LocalDateTime pLocalStartTimestamp;
    if (pLocalStartTimestampAsBasicType != null) {
      pLocalStartTimestamp = java.time.LocalDateTime.parse(pLocalStartTimestampAsBasicType);
    }
    else {
      pLocalStartTimestamp = null;
    }
    java.time.LocalTime pLocalStartTime;
    if (pLocalStartTimeAsBasicType != null) {
      pLocalStartTime = java.time.LocalTime.parse(pLocalStartTimeAsBasicType);
    }
    else {
      pLocalStartTime = null;
    }
    java.time.LocalDate pLocalStartDate;
    if (pLocalStartDateAsBasicType != null) {
      pLocalStartDate = java.time.LocalDate.parse(pLocalStartDateAsBasicType);
    }
    else {
      pLocalStartDate = null;
    }
    java.util.Calendar pCalendar;
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        pCalendar = java.util.Calendar.getInstance();
        pCalendar.setTime(lDate);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendar = null;
    }
    java.util.Date pUtilDate;
    if (pUtilDateAsBasicType != null) {
      try {
        pUtilDate = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDate = null;
    }
    java.sql.Timestamp pSQLTimestamp;
    if (pSQLTimestampAsBasicType != null) {
      pSQLTimestamp = java.sql.Timestamp.valueOf(pSQLTimestampAsBasicType);
    }
    else {
      pSQLTimestamp = null;
    }
    java.sql.Time pSQLTime;
    if (pSQLTimeAsBasicType != null) {
      pSQLTime = java.sql.Time.valueOf(pSQLTimeAsBasicType);
    }
    else {
      pSQLTime = null;
    }
    java.sql.Date pSQLDate;
    if (pSQLDateAsBasicType != null) {
      pSQLDate = java.sql.Date.valueOf(pSQLDateAsBasicType);
    }
    else {
      pSQLDate = null;
    }
    java.util.Set<java.util.Calendar> pCalendars;
    if (pCalendarsAsBasicType != null) {
      try {
        pCalendars = new java.util.HashSet<java.util.Calendar>();
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          java.util.Calendar lCalendar = java.util.Calendar.getInstance();
          lCalendar.setTime(lDate);
          pCalendars.add(lCalendar);
        }
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendars = java.util.Collections.emptySet();
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pPath,
          pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate,
          pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
      // Delegate request to service.
      return rESTProductService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
          pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParamsBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-date-query-params-beans/{path}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testDateQueryParamsBean(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "path",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pPath,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "utilDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pUtilDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "calendar",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pCalendarAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlTimestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "sqlDate",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlDateAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.DateQueryParamsBean.Builder lQueryParamsBuilder =
        com.anaptecs.spring.service.DateQueryParamsBean.builder();
    // Handle bean parameter pQueryParams.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryParamsBuilder.setOffsetDateTime(java.time.OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryParamsBuilder.setOffsetTime(java.time.OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryParamsBuilder.setLocalDateTime(java.time.LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryParamsBuilder.setLocalTime(java.time.LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.localDate
    if (pLocalDateAsBasicType != null) {
      lQueryParamsBuilder.setLocalDate(java.time.LocalDate.parse(pLocalDateAsBasicType));
    }
    // Handle bean parameter pQueryParams.utilDate
    if (pUtilDateAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
        lQueryParamsBuilder.setUtilDate(lDate);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.calendar
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        java.util.Calendar lCalendar = java.util.Calendar.getInstance();
        lCalendar.setTime(lDate);
        lQueryParamsBuilder.setCalendar(lCalendar);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pQueryParams.sqlTimestamp
    if (pSqlTimestampAsBasicType != null) {
      lQueryParamsBuilder.setSqlTimestamp(java.sql.Timestamp.valueOf(pSqlTimestampAsBasicType));
    }
    // Handle bean parameter pQueryParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      lQueryParamsBuilder.setSqlTime(java.sql.Time.valueOf(pSqlTimeAsBasicType));
    }
    // Handle bean parameter pQueryParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      lQueryParamsBuilder.setSqlDate(java.sql.Date.valueOf(pSqlDateAsBasicType));
    }
    com.anaptecs.spring.service.DateQueryParamsBean pQueryParams = lQueryParamsBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pPath,
          pQueryParams);
      // Delegate request to service.
      return rESTProductService.testDateQueryParamsBean(pPath, pQueryParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-date-header-params/{path}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testDateHeaderParams(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "path",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pPath,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Offset-Date-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Offset-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Date-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Calendar",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pCalendarAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Util-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pUtilDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Timestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSQLDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "util-dates",
          required = false) String[] pUtilDatesAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert date types into real objects.
    java.time.OffsetDateTime pOffsetDateTime;
    if (pOffsetDateTimeAsBasicType != null) {
      pOffsetDateTime = java.time.OffsetDateTime.parse(pOffsetDateTimeAsBasicType);
    }
    else {
      pOffsetDateTime = null;
    }
    java.time.OffsetTime pOffsetTime;
    if (pOffsetTimeAsBasicType != null) {
      pOffsetTime = java.time.OffsetTime.parse(pOffsetTimeAsBasicType);
    }
    else {
      pOffsetTime = null;
    }
    java.time.LocalDateTime pLocalDateTime;
    if (pLocalDateTimeAsBasicType != null) {
      pLocalDateTime = java.time.LocalDateTime.parse(pLocalDateTimeAsBasicType);
    }
    else {
      pLocalDateTime = null;
    }
    java.time.LocalTime pLocalTime;
    if (pLocalTimeAsBasicType != null) {
      pLocalTime = java.time.LocalTime.parse(pLocalTimeAsBasicType);
    }
    else {
      pLocalTime = null;
    }
    java.time.LocalDate pLocalDate;
    if (pLocalDateAsBasicType != null) {
      pLocalDate = java.time.LocalDate.parse(pLocalDateAsBasicType);
    }
    else {
      pLocalDate = null;
    }
    java.util.Calendar pCalendar;
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        pCalendar = java.util.Calendar.getInstance();
        pCalendar.setTime(lDate);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pCalendar = null;
    }
    java.util.Date pUtilDate;
    if (pUtilDateAsBasicType != null) {
      try {
        pUtilDate = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDate = null;
    }
    java.sql.Timestamp pSQLTimestamp;
    if (pSQLTimestampAsBasicType != null) {
      pSQLTimestamp = java.sql.Timestamp.valueOf(pSQLTimestampAsBasicType);
    }
    else {
      pSQLTimestamp = null;
    }
    java.sql.Time pSQLTime;
    if (pSQLTimeAsBasicType != null) {
      pSQLTime = java.sql.Time.valueOf(pSQLTimeAsBasicType);
    }
    else {
      pSQLTime = null;
    }
    java.sql.Date pSQLDate;
    if (pSQLDateAsBasicType != null) {
      pSQLDate = java.sql.Date.valueOf(pSQLDateAsBasicType);
    }
    else {
      pSQLDate = null;
    }
    java.util.Set<java.util.Date> pUtilDates;
    if (pUtilDatesAsBasicType != null) {
      try {
        pUtilDates = new java.util.HashSet<java.util.Date>();
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          pUtilDates.add(lDate);
        }
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    else {
      pUtilDates = java.util.Collections.emptySet();
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pPath,
          pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp,
          pSQLTime, pSQLDate, pUtilDates);
      // Delegate request to service.
      return rESTProductService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime,
          pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParamsBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-date-header-params-beans/{path}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testDateHeaderParamsBean(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "path",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pPath,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Offset-Date-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Offset-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Date-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Local-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Util-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pUtilDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Calendar",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pCalendarAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Timestamp",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlTimestampAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Time",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "SQL-Date",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSqlDateAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.DateHeaderParamsBean.Builder lHeaderParamsBuilder =
        com.anaptecs.spring.service.DateHeaderParamsBean.builder();
    // Handle bean parameter pHeaderParams.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lHeaderParamsBuilder.setOffsetDateTime(java.time.OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lHeaderParamsBuilder.setOffsetTime(java.time.OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lHeaderParamsBuilder.setLocalDateTime(java.time.LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localTime
    if (pLocalTimeAsBasicType != null) {
      lHeaderParamsBuilder.setLocalTime(java.time.LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.localDate
    if (pLocalDateAsBasicType != null) {
      lHeaderParamsBuilder.setLocalDate(java.time.LocalDate.parse(pLocalDateAsBasicType));
    }
    // Handle bean parameter pHeaderParams.utilDate
    if (pUtilDateAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pUtilDateAsBasicType);
        lHeaderParamsBuilder.setUtilDate(lDate);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.calendar
    if (pCalendarAsBasicType != null) {
      try {
        java.util.Date lDate =
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(pCalendarAsBasicType);
        java.util.Calendar lCalendar = java.util.Calendar.getInstance();
        lCalendar.setTime(lDate);
        lHeaderParamsBuilder.setCalendar(lCalendar);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderParams.sqlTimestamp
    if (pSqlTimestampAsBasicType != null) {
      lHeaderParamsBuilder.setSqlTimestamp(java.sql.Timestamp.valueOf(pSqlTimestampAsBasicType));
    }
    // Handle bean parameter pHeaderParams.sqlTime
    if (pSqlTimeAsBasicType != null) {
      lHeaderParamsBuilder.setSqlTime(java.sql.Time.valueOf(pSqlTimeAsBasicType));
    }
    // Handle bean parameter pHeaderParams.sqlDate
    if (pSqlDateAsBasicType != null) {
      lHeaderParamsBuilder.setSqlDate(java.sql.Date.valueOf(pSqlDateAsBasicType));
    }
    com.anaptecs.spring.service.DateHeaderParamsBean pHeaderParams = lHeaderParamsBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pPath,
          pHeaderParams);
      // Delegate request to service.
      return rESTProductService.testDateHeaderParamsBean(pPath, pHeaderParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testCookieParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "cookies",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testCookieParams( @org.springframework.web.bind.annotation.CookieValue(
      name = "Channel-Type-Param",
      required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ChannelType pChannelTypeParam,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "token",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pAccessToken,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "lang",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.util.Locale pLanguage,
      @org.springframework.web.bind.annotation.CookieValue(name = "reseller", required = true) long pResellerID,
      @org.springframework.web.bind.annotation.PathVariable(name = "id", required = true) long pPathParam,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "q1",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pQueryParam,
      @com.anaptecs.annotations.MyNotNullRESTParam String pLang,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "intCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam int pIntCodeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "specificHeader",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pSpecificHeader,
      @org.springframework.web.bind.annotation.CookieValue(
          name = "Channel-Type",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam com.anaptecs.spring.base.ChannelType pChannelType,
      @org.springframework.web.bind.annotation.RequestHeader java.util.Map<String, String> pHeaders,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.SpecialContext.Builder lContextBuilder = com.anaptecs.spring.base.SpecialContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setPathParam(pPathParam);
    lContextBuilder.setQueryParam(pQueryParam);
    lContextBuilder.setLang(pLang);
    // Handle bean parameter pContext.intCode
    lContextBuilder.setIntCode(com.anaptecs.spring.base.IntegerCodeType.builder().setCode(pIntCodeAsBasicType).build());
    lContextBuilder.setSpecificHeader(pSpecificHeader);
    lContextBuilder.setChannelType(pChannelType);
    com.anaptecs.spring.base.SpecialContext pContext = lContextBuilder.build();
    // Add custom headers.
    for (java.util.Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pChannelTypeParam, pContext);
      // Delegate request to service.
      return rESTProductService.testCookieParams(pChannelTypeParam, pContext);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testOptionalQueryParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-optional-query-params",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testOptionalQueryParams(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "query1",
          required = false,
          defaultValue = "Just a default value") String query1,
      @org.springframework.web.bind.annotation.RequestParam(name = "query2", required = false) int query2,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, query1, query2);
      // Delegate request to service.
      return rESTProductService.testOptionalQueryParams(query1, query2);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#processComplexBookingID()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "complex/{bookingID}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  public reactor.core.publisher.Mono<Boolean> processComplexBookingID(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "bookingID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pComplextBookingIDAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.composite.ComplexBookingID pComplextBookingID = this.deserializeCompositeDataType(
        pComplextBookingIDAsBasicType, com.anaptecs.spring.composite.ComplexBookingID.class);
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pComplextBookingID);
      // Delegate request to service.
      return rESTProductService.processComplexBookingID(pComplextBookingID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "dataTypesInHeader",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testDataTypesAsHeaderParam(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "BookingID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingIDAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "BookingCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingCodeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "DoubleCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Double pDoubleCodeAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.BookingID pBookingID =
        this.deserializeCompositeDataType(pBookingIDAsBasicType, com.anaptecs.spring.base.BookingID.class);
    com.anaptecs.spring.base.BookingCode pBookingCode;
    if (pBookingCodeAsBasicType != null) {
      pBookingCode = com.anaptecs.spring.base.BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    }
    else {
      pBookingCode = null;
    }
    com.anaptecs.spring.base.DoubleCode pDoubleCode;
    if (pDoubleCodeAsBasicType != null) {
      pDoubleCode = com.anaptecs.spring.base.DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build();
    }
    else {
      pDoubleCode = null;
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBookingID,
          pBookingCode, pDoubleCode);
      // Delegate request to service.
      return rESTProductService.testDataTypesAsHeaderParam(pBookingID, pBookingCode, pDoubleCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderBeanParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "dataTypesInBeanHeader",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testDataTypesAsHeaderBeanParam(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "bookingID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingIDAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "bookingCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingCodeAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "DoubleCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Double pDoubleCodeAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.AdvancedHeader.Builder lContextBuilder =
        com.anaptecs.spring.service.AdvancedHeader.builder();
    // Handle bean parameter pContext.bookingID
    if (pBookingIDAsBasicType != null) {
      lContextBuilder.setBookingID(
          this.deserializeCompositeDataType(pBookingIDAsBasicType, com.anaptecs.spring.base.BookingID.class));
    }
    // Handle bean parameter pContext.bookingCode
    if (pBookingCodeAsBasicType != null) {
      lContextBuilder
          .setBookingCode(com.anaptecs.spring.base.BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    }
    // Handle bean parameter pContext.doubleCode
    if (pDoubleCodeAsBasicType != null) {
      lContextBuilder
          .setDoubleCode(com.anaptecs.spring.base.DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build());
    }
    com.anaptecs.spring.service.AdvancedHeader pContext = lContextBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.testDataTypesAsHeaderBeanParam(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrays()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testPrimitiveArrayAsBody",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testPrimitiveArrays(
      @org.springframework.web.bind.annotation.RequestBody(
          required = false) reactor.core.publisher.Mono<int[]> pIntegerArray,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pIntegerArray.flatMap(pIntegerArrayBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pIntegerArrayBody);
      // Delegate request to service.
      return rESTProductService.testPrimitiveArrays(pIntegerArrayBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testDataTypeAsQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testDataTypeAsQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingCodeAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.BookingCode pBookingCode;
    if (pBookingCodeAsBasicType != null) {
      pBookingCode = com.anaptecs.spring.base.BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    }
    else {
      pBookingCode = null;
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBookingCode);
      // Delegate request to service.
      return rESTProductService.testDataTypeAsQueryParam(pBookingCode);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsBeanQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testDataTypeAsBeanQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testDataTypeAsBeanQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingCode",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingCodeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "maxResults",
          required = true,
          defaultValue = "47") int pMaxResults,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.QueryBeanParam.Builder lBeanParamBuilder =
        com.anaptecs.spring.service.QueryBeanParam.builder();
    // Handle bean parameter pBeanParam.bookingCode
    if (pBookingCodeAsBasicType != null) {
      lBeanParamBuilder
          .setBookingCode(com.anaptecs.spring.base.BookingCode.builder().setCode(pBookingCodeAsBasicType).build());
    }
    lBeanParamBuilder.setMaxResults(pMaxResults);
    com.anaptecs.spring.service.QueryBeanParam pBeanParam = lBeanParamBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return rESTProductService.testDataTypeAsBeanQueryParam(pBeanParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrayAsQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testPrimitiveArrayAsQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testPrimitiveArrayAsQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(name = "intValues", required = false) int[] pIntValues,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pIntValues);
      // Delegate request to service.
      return rESTProductService.testPrimitiveArrayAsQueryParam(pIntValues);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testSimpleTypesAsQueryParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testSimpleTypesAsQueryParams",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testSimpleTypesAsQueryParams(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "strings",
          required = false) java.util.List<String> pStrings,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pStrings);
      // Delegate request to service.
      return rESTProductService.testSimpleTypesAsQueryParams(pStrings);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveWrapperArrayAsQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testPrimitiveWrapperArrayAsQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testPrimitiveWrapperArrayAsQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "integers",
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam java.util.Set<Integer> pIntegers,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pIntegers);
      // Delegate request to service.
      return rESTProductService.testPrimitiveWrapperArrayAsQueryParam(pIntegers);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultivaluedQueryParamsBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testMultivaluedQueryParamsBean",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testMultivaluedQueryParamsBean(
      @org.springframework.web.bind.annotation.RequestParam(name = "intArray", required = false) int[] pIntArray,
      @org.springframework.web.bind.annotation.RequestParam(name = "strings", required = false) String[] pStrings,
      @org.springframework.web.bind.annotation.RequestParam(name = "integers", required = false) Integer[] pIntegers,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timeUnits",
          required = false) java.util.Set<com.anaptecs.spring.base.TimeUnit> pTimeUnits,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timeUnitArray",
          required = false) com.anaptecs.spring.base.TimeUnit[] pTimeUnitArray,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.MultivaluedQueryParamsBean.Builder lBeanBuilder =
        com.anaptecs.spring.service.MultivaluedQueryParamsBean.builder();
    lBeanBuilder.setIntArray(pIntArray);
    lBeanBuilder.setStrings(pStrings);
    lBeanBuilder.setIntegers(pIntegers);
    lBeanBuilder.setTimeUnits(pTimeUnits);
    lBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    com.anaptecs.spring.service.MultivaluedQueryParamsBean pBean = lBeanBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBean);
      // Delegate request to service.
      return rESTProductService.testMultivaluedQueryParamsBean(pBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testMulitvaluedDataTypeAsQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testMulitvaluedDataTypeAsQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "longCodes",
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam java.lang.Long[] pLongCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingIDs",
          required = false) String[] pBookingIDsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localDates",
          required = false) String[] pLocalDatesAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    java.util.List<com.anaptecs.spring.base.IntegerCodeType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new java.util.ArrayList<com.anaptecs.spring.base.IntegerCodeType>();
      for (int lNext : pCodesAsBasicType) {
        pCodes.add(com.anaptecs.spring.base.IntegerCodeType.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = java.util.Collections.emptyList();
    }
    java.util.Set<com.anaptecs.spring.base.LongCode> pLongCodes;
    if (pLongCodesAsBasicType != null) {
      pLongCodes = new java.util.HashSet<com.anaptecs.spring.base.LongCode>();
      for (java.lang.Long lNext : pLongCodesAsBasicType) {
        pLongCodes.add(com.anaptecs.spring.base.LongCode.builder().setCode(lNext).build());
      }
    }
    else {
      pLongCodes = java.util.Collections.emptySet();
    }
    java.util.List<com.anaptecs.spring.base.BookingID> pBookingIDs;
    if (pBookingIDsAsBasicType != null) {
      pBookingIDs = new java.util.ArrayList<com.anaptecs.spring.base.BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        pBookingIDs.add(this.deserializeCompositeDataType(lNext, com.anaptecs.spring.base.BookingID.class));
      }
    }
    else {
      pBookingIDs = java.util.Collections.emptyList();
    }
    // Convert date types into real objects.
    java.util.List<java.time.OffsetDateTime> pTimestamps;
    if (pTimestampsAsBasicType != null) {
      pTimestamps = new java.util.ArrayList<java.time.OffsetDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        pTimestamps.add(java.time.OffsetDateTime.parse(pTimestampsAsBasicType[i]));
      }
    }
    else {
      pTimestamps = java.util.Collections.emptyList();
    }
    java.util.SortedSet<java.time.LocalDate> pLocalDates;
    if (pLocalDatesAsBasicType != null) {
      pLocalDates = new java.util.TreeSet<java.time.LocalDate>();
      for (int i = 0; i < pLocalDatesAsBasicType.length; i++) {
        pLocalDates.add(java.time.LocalDate.parse(pLocalDatesAsBasicType[i]));
      }
    }
    else {
      pLocalDates = java.util.Collections.emptySortedSet();
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pCodes,
          pLongCodes, pBookingIDs, pTimestamps, pLocalDates);
      // Delegate request to service.
      return rESTProductService.testMulitvaluedDataTypeAsQueryParam(pCodes, pLongCodes, pBookingIDs, pTimestamps,
          pLocalDates);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testMulitvaluedDataTypeAsBeanQueryParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testMulitvaluedDataTypeAsBeanQueryParam(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "longCodes",
          required = false) java.lang.Long[] pLongCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "doubleCodes",
          required = false) java.lang.Double[] pDoubleCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingIDs",
          required = false) String[] pBookingIDsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingIDsArray",
          required = false) String[] pBookingIDsArrayAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "times",
          required = false) String[] pTimesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "startTimestamps",
          required = false) String[] pStartTimestampsAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.DataTypesQueryBean.Builder lQueryBeanBuilder =
        com.anaptecs.spring.service.DataTypesQueryBean.builder();
    // Handle bean parameter pQueryBean.longCodes
    if (pLongCodesAsBasicType != null) {
      com.anaptecs.spring.base.LongCode[] lLongCodes =
          new com.anaptecs.spring.base.LongCode[pLongCodesAsBasicType.length];
      for (int i = 0; i < pLongCodesAsBasicType.length; i++) {
        lLongCodes[i] = com.anaptecs.spring.base.LongCode.builder().setCode(pLongCodesAsBasicType[i]).build();
      }
      lQueryBeanBuilder.setLongCodes(lLongCodes);
    }
    // Handle bean parameter pQueryBean.codes
    if (pCodesAsBasicType != null) {
      com.anaptecs.spring.base.IntegerCodeType[] lCodes =
          new com.anaptecs.spring.base.IntegerCodeType[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = com.anaptecs.spring.base.IntegerCodeType.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lQueryBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pQueryBean.doubleCodes
    if (pDoubleCodesAsBasicType != null) {
      java.util.Set<com.anaptecs.spring.base.DoubleCode> lDoubleCodes =
          new java.util.HashSet<com.anaptecs.spring.base.DoubleCode>();
      for (java.lang.Double lNext : pDoubleCodesAsBasicType) {
        lDoubleCodes.add(com.anaptecs.spring.base.DoubleCode.builder().setCode(lNext).build());
      }
      lQueryBeanBuilder.setDoubleCodes(lDoubleCodes);
    }
    // Handle bean parameter pQueryBean.bookingIDs
    if (pBookingIDsAsBasicType != null) {
      // Handle bean parameter pQueryBean.bookingIDs
      java.util.Set<com.anaptecs.spring.base.BookingID> lBookingIDs =
          new java.util.HashSet<com.anaptecs.spring.base.BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        lBookingIDs.add(this.deserializeCompositeDataType(lNext, com.anaptecs.spring.base.BookingID.class));
      }
      lQueryBeanBuilder.setBookingIDs(lBookingIDs);
    }
    // Handle bean parameter pQueryBean.bookingIDsArray
    if (pBookingIDsArrayAsBasicType != null) {
      // Handle bean parameter pQueryBean.bookingIDsArray
      com.anaptecs.spring.base.BookingID[] lBookingIDsArray =
          new com.anaptecs.spring.base.BookingID[pBookingIDsArrayAsBasicType.length];
      for (int i = 0; i < pBookingIDsArrayAsBasicType.length; i++) {
        lBookingIDsArray[i] =
            this.deserializeCompositeDataType(pBookingIDsArrayAsBasicType[i], com.anaptecs.spring.base.BookingID.class);
      }
      lQueryBeanBuilder.setBookingIDsArray(lBookingIDsArray);
    }
    // Handle bean parameter pQueryBean.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryBeanBuilder.setOffsetDateTime(java.time.OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryBeanBuilder.setOffsetTime(java.time.OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryBeanBuilder.setLocalDateTime(java.time.LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryBeanBuilder.setLocalTime(java.time.LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQueryBean.timestamps
    if (pTimestampsAsBasicType != null) {
      java.util.List<java.time.LocalDateTime> lTimestamps = new java.util.ArrayList<java.time.LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(java.time.LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lQueryBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pQueryBean.times
    if (pTimesAsBasicType != null) {
      java.util.Set<java.time.OffsetTime> lTimes = new java.util.HashSet<java.time.OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        lTimes.add(java.time.OffsetTime.parse(pTimesAsBasicType[i]));
      }
      lQueryBeanBuilder.setTimes(lTimes);
    }
    // Handle bean parameter pQueryBean.startTimestamps
    if (pStartTimestampsAsBasicType != null) {
      java.time.OffsetDateTime[] lStartTimestamps = new java.time.OffsetDateTime[pStartTimestampsAsBasicType.length];
      for (int i = 0; i < pStartTimestampsAsBasicType.length; i++) {
        lStartTimestamps[i] = java.time.OffsetDateTime.parse(pStartTimestampsAsBasicType[i]);
      }
      lQueryBeanBuilder.setStartTimestamps(lStartTimestamps);
    }
    com.anaptecs.spring.service.DataTypesQueryBean pQueryBean = lQueryBeanBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pQueryBean);
      // Delegate request to service.
      return rESTProductService.testMulitvaluedDataTypeAsBeanQueryParam(pQueryBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFieldsInBeanParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testMultiValuedHeaderFieldsInBeanParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testMultiValuedHeaderFieldsInBeanParam(
      @org.springframework.web.bind.annotation.RequestHeader(name = "names", required = false) String[] pNames,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "ints",
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam int[] pInts,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "doubles",
          required = false) java.lang.Double[] pDoubles,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "codes",
          required = false) String[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "stringCodeList",
          required = false) String[] pStringCodeListAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "startDate",
          required = false) String pStartDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "dates",
          required = false) String[] pDatesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "calendars",
          required = false) String[] pCalendarsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "utilDates",
          required = false) String[] pUtilDatesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "sqlTimestamps",
          required = false) String[] pSqlTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timeUnits",
          required = false) java.util.Set<com.anaptecs.spring.base.TimeUnit> pTimeUnits,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timeUnitArray",
          required = false) com.anaptecs.spring.base.TimeUnit[] pTimeUnitArray,
      @org.springframework.web.bind.annotation.RequestHeader(name = "base64", required = false) String pBase64,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.MultiValuedHeaderBeanParam.Builder lMultiValuedBeanBuilder =
        com.anaptecs.spring.service.MultiValuedHeaderBeanParam.builder();
    lMultiValuedBeanBuilder.setNames(pNames);
    lMultiValuedBeanBuilder.setInts(pInts);
    lMultiValuedBeanBuilder.setDoubles(pDoubles);
    // Handle bean parameter pMultiValuedBean.codes
    if (pCodesAsBasicType != null) {
      com.anaptecs.spring.base.StringCode[] lCodes = new com.anaptecs.spring.base.StringCode[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = com.anaptecs.spring.base.StringCode.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lMultiValuedBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pMultiValuedBean.stringCodeList
    if (pStringCodeListAsBasicType != null) {
      java.util.Set<com.anaptecs.spring.base.StringCode> lStringCodeList =
          new java.util.HashSet<com.anaptecs.spring.base.StringCode>();
      for (String lNext : pStringCodeListAsBasicType) {
        lStringCodeList.add(com.anaptecs.spring.base.StringCode.builder().setCode(lNext).build());
      }
      lMultiValuedBeanBuilder.setStringCodeList(lStringCodeList);
    }
    // Handle bean parameter pMultiValuedBean.startDate
    if (pStartDateAsBasicType != null) {
      lMultiValuedBeanBuilder.setStartDate(java.time.LocalDate.parse(pStartDateAsBasicType));
    }
    // Handle bean parameter pMultiValuedBean.dates
    if (pDatesAsBasicType != null) {
      java.time.LocalDate[] lDates = new java.time.LocalDate[pDatesAsBasicType.length];
      for (int i = 0; i < pDatesAsBasicType.length; i++) {
        lDates[i] = java.time.LocalDate.parse(pDatesAsBasicType[i]);
      }
      lMultiValuedBeanBuilder.setDates(lDates);
    }
    // Handle bean parameter pMultiValuedBean.timestamps
    if (pTimestampsAsBasicType != null) {
      java.util.Set<java.time.LocalDateTime> lTimestamps = new java.util.HashSet<java.time.LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(java.time.LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lMultiValuedBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pMultiValuedBean.calendars
    if (pCalendarsAsBasicType != null) {
      try {
        java.util.Calendar[] lCalendars = new java.util.Calendar[pCalendarsAsBasicType.length];
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          java.util.Calendar lCalendar = java.util.Calendar.getInstance();
          lCalendar.setTime(lDate);
          lCalendars[i] = lCalendar;
        }
        lMultiValuedBeanBuilder.setCalendars(lCalendars);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pMultiValuedBean.utilDates
    if (pUtilDatesAsBasicType != null) {
      try {
        java.util.Date[] lUtilDates = new java.util.Date[pUtilDatesAsBasicType.length];
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          lUtilDates[i] = lDate;
        }
        lMultiValuedBeanBuilder.setUtilDates(lUtilDates);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pMultiValuedBean.sqlTimestamps
    if (pSqlTimestampsAsBasicType != null) {
      java.sql.Timestamp[] lSqlTimestamps = new java.sql.Timestamp[pSqlTimestampsAsBasicType.length];
      for (int i = 0; i < pSqlTimestampsAsBasicType.length; i++) {
        lSqlTimestamps[i] = java.sql.Timestamp.valueOf(pSqlTimestampsAsBasicType[i]);
      }
      lMultiValuedBeanBuilder.setSqlTimestamps(lSqlTimestamps);
    }
    lMultiValuedBeanBuilder.setTimeUnits(pTimeUnits);
    lMultiValuedBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    // Decode base64 encoded String back to byte[]
    if (pBase64 != null) {
      lMultiValuedBeanBuilder.setBase64(java.util.Base64.getDecoder().decode(pBase64));
    }
    com.anaptecs.spring.service.MultiValuedHeaderBeanParam pMultiValuedBean = lMultiValuedBeanBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class,
          pMultiValuedBean);
      // Delegate request to service.
      return rESTProductService.testMultiValuedHeaderFieldsInBeanParam(pMultiValuedBean);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFields()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "testMultiValuedHeaderFields",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testMultiValuedHeaderFields(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "names",
          required = false) java.util.Set<String> pNames,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "ints",
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam int[] pInts,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "doubles",
          required = false) java.util.Set<java.lang.Double> pDoubles,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "codes",
          required = false) String[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "startDate",
          required = false) String pStartDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "times",
          required = false) String[] pTimesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(name = "BASE_64", required = false) String pBase64AsString,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    java.util.Set<com.anaptecs.spring.base.StringCode> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new java.util.HashSet<com.anaptecs.spring.base.StringCode>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(com.anaptecs.spring.base.StringCode.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = java.util.Collections.emptySet();
    }
    // Convert date types into real objects.
    java.time.OffsetDateTime pStartDate;
    if (pStartDateAsBasicType != null) {
      pStartDate = java.time.OffsetDateTime.parse(pStartDateAsBasicType);
    }
    else {
      pStartDate = null;
    }
    java.util.Set<java.time.OffsetDateTime> pTimestamps;
    if (pTimestampsAsBasicType != null) {
      pTimestamps = new java.util.HashSet<java.time.OffsetDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        pTimestamps.add(java.time.OffsetDateTime.parse(pTimestampsAsBasicType[i]));
      }
    }
    else {
      pTimestamps = java.util.Collections.emptySet();
    }
    java.util.Set<java.time.OffsetTime> pTimes;
    if (pTimesAsBasicType != null) {
      pTimes = new java.util.HashSet<java.time.OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        pTimes.add(java.time.OffsetTime.parse(pTimesAsBasicType[i]));
      }
    }
    else {
      pTimes = java.util.Collections.emptySet();
    }
    byte[] pBase64;
    if (pBase64AsString != null) {
      pBase64 = java.util.Base64.getDecoder().decode(pBase64AsString);
    }
    else {
      pBase64 = null;
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pNames, pInts,
          pDoubles, pCodes, pStartDate, pTimestamps, pTimes, pBase64);
      // Delegate request to service.
      return rESTProductService.testMultiValuedHeaderFields(pNames, pInts, pDoubles, pCodes, pStartDate, pTimestamps,
          pTimes, pBase64);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsPathParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "booking-id-as-path-param/{bookingID}",
      method = { org.springframework.web.bind.annotation.RequestMethod.PATCH })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testBookingIDAsPathParam(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "bookingID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pBookingIDAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.BookingID pBookingID =
        this.deserializeCompositeDataType(pBookingIDAsBasicType, com.anaptecs.spring.base.BookingID.class);
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBookingID);
      // Delegate request to service.
      return rESTProductService.testBookingIDAsPathParam(pBookingID);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsHeaderParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "booking-id-as-header-param",
      method = { org.springframework.web.bind.annotation.RequestMethod.PATCH })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> testBookingIDAsHeaderParam(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "bookingID",
          required = false) String pBookingIDAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    com.anaptecs.spring.base.BookingID pBookingID =
        this.deserializeCompositeDataType(pBookingIDAsBasicType, com.anaptecs.spring.base.BookingID.class);
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pBookingID);
      // Delegate request to service.
      return rESTProductService.testBookingIDAsHeaderParam(pBookingID);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testContextWithPrimitives()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-context-with-primitives",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> testContextWithPrimitives(
      @org.springframework.web.bind.annotation.RequestHeader(name = "aBoolean", required = true) boolean pABoolean,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "aBooleanWrapper",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Boolean pABooleanWrapper,
      @org.springframework.web.bind.annotation.RequestHeader(name = "anInt", required = true) int pAnInt,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "anInteger",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam Integer pAnInteger,
      @org.springframework.web.bind.annotation.RequestParam(name = "aLong", required = true) long pALong,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "aVeryLong",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Long pAVeryLong,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.ContextWithPrimitives.Builder lContextBuilder =
        com.anaptecs.spring.service.ContextWithPrimitives.builder();
    lContextBuilder.setABoolean(pABoolean);
    lContextBuilder.setABooleanWrapper(pABooleanWrapper);
    lContextBuilder.setAnInt(pAnInt);
    lContextBuilder.setAnInteger(pAnInteger);
    lContextBuilder.setALong(pALong);
    lContextBuilder.setAVeryLong(pAVeryLong);
    com.anaptecs.spring.service.ContextWithPrimitives pContext = lContextBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pContext);
      // Delegate request to service.
      return rESTProductService.testContextWithPrimitives(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitivesAsParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('Sales Agent')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-primitives-as-params",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> testPrimitivesAsParams(
      @org.springframework.web.bind.annotation.RequestHeader(name = "pAnInt", required = true) int pAnInt,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "pAnInteger",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Integer pAnInteger,
      @org.springframework.web.bind.annotation.RequestHeader(name = "pABoolean", required = true) boolean pABoolean,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "pBooleanWrapper",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Boolean pBooleanWrapper,
      @org.springframework.web.bind.annotation.RequestParam(name = "pALong", required = true) long pALong,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "pVeryLong",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.Long pVeryLong,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.RESTProductServiceReactive.class, pAnInt,
          pAnInteger, pABoolean, pBooleanWrapper, pALong, pVeryLong);
      // Delegate request to service.
      return rESTProductService.testPrimitivesAsParams(pAnInt, pAnInteger, pABoolean, pBooleanWrapper, pALong,
          pVeryLong);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.RESTProductServiceReactive.class, lResponse));
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, java.lang.Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        java.lang.StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
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
    catch (com.fasterxml.jackson.core.JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}
