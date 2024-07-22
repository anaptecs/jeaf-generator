/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

@org.springframework.web.bind.annotation.RequestMapping(path = "/nova/prefix")
@org.springframework.web.bind.annotation.RestController
public class ProductServiceReactiveResource {
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
   * All request to this class will be delegated to {@link com.anaptecs.spring.service.ProductService}.
   */
  private final com.anaptecs.spring.service.ProductServiceReactive productService;

  /**
   * Initialize object.
   *
   * @param pProductService Dependency on concrete {@link com.anaptecs.spring.service.ProductService} implementation
   * that should be used.
   */
  public ProductServiceReactiveResource( com.anaptecs.spring.service.ProductServiceReactive pProductService,
      com.anaptecs.jeaf.validation.api.ValidationExecutor pValidationExecutor,
      com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter pCustomHeaderFilter ) {
    productService = pProductService;
    validationExecutor = pValidationExecutor;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getProducts()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  public reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.Product>> getProducts(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.getProducts();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getProduct()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/{id}",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> getProduct(
      @org.springframework.web.bind.annotation.PathVariable(
          name = "id",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pProductID,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pProductID);
      // Delegate request to service.
      return productService.getProduct(pProductID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createProduct()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  public reactor.core.publisher.Mono<Boolean> createProduct( @org.springframework.web.bind.annotation.RequestBody(
      required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> pProduct,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return productService.createProduct(pProductBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getSortiment()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/sortiment/{id}",
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
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.getSortiment(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createChannelCode()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/ChannelCode",
      consumes = { "application/json" },
      produces = { "application/json" },
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.ChannelCode> createChannelCode(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<java.lang.String> pChannelCode,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pChannelCodeBody);
      // Delegate request to service.
      return productService.createChannelCode(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#ping()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/",
      method = { org.springframework.web.bind.annotation.RequestMethod.HEAD })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> ping( org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.ping();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedOperation()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/operation",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @Deprecated
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> deprecatedOperation(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.deprecatedOperation();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedContext()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/context",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> deprecatedContext(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "token",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pAccessToken,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "lang",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.util.Locale pLanguage,
      @org.springframework.web.bind.annotation.CookieValue(name = "reseller", required = true) long pResellerID,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "q1",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pQueryParam,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.DeprecatedContext.Builder lContextBuilder =
        com.anaptecs.spring.base.DeprecatedContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setQueryParam(pQueryParam);
    com.anaptecs.spring.base.DeprecatedContext pContext = lContextBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.deprecatedContext(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedBeanParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/beanParams",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> deprecatedBeanParam(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "token",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pAccessToken,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "lang",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam java.util.Locale pLanguage,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "q2",
          required = true) @Deprecated @com.anaptecs.annotations.MyNotNullRESTParam java.lang.String pOldStyle,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.BeanParameter.Builder lBeanParamBuilder = com.anaptecs.spring.base.BeanParameter.builder();
    lBeanParamBuilder.setAccessToken(pAccessToken);
    lBeanParamBuilder.setLanguage(pLanguage);
    lBeanParamBuilder.setOldStyle(pOldStyle);
    com.anaptecs.spring.base.BeanParameter pBeanParam = lBeanParamBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return productService.deprecatedBeanParam(pBeanParam);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/params",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @Deprecated
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> deprecatedParams(
      @org.springframework.web.bind.annotation.RequestHeader(name = "param1", required = true) @Deprecated int pParam1,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pParam1);
      // Delegate request to service.
      return productService.deprecatedParams(pParam1);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedBody()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/body",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> deprecatedBody(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @Deprecated @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<java.lang.String> pBody,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pBody.flatMap(pBodyBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pBodyBody);
      // Delegate request to service.
      return productService.deprecatedBody(pBodyBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprectedComplexRequestBody()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/complexBody",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> deprectedComplexRequestBody(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @Deprecated @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> pProduct,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return productService.deprectedComplexRequestBody(pProductBody);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedComplexReturn()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/deprecated/complexReturn",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @Deprecated
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.Product> deprecatedComplexReturn(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.deprecatedComplexReturn();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#loadSpecificThings()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/specific/{id}",
      method = { org.springframework.web.bind.annotation.RequestMethod.PATCH })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> loadSpecificThings(
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
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.loadSpecificThings(pContext);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createChannelCodeFromObject()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/ChannelCodeObject",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.ChannelCode> createChannelCodeFromObject(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.ChannelCode> pChannelCode,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pChannelCodeBody);
      // Delegate request to service.
      return productService.createChannelCodeFromObject(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#addCurrencies()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/currencies",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotEmptyRESTParam
  public reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.CurrencyCode>> addCurrencies(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam reactor.core.publisher.Mono<java.util.List<com.anaptecs.spring.base.CurrencyCode>> pCurrencies,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pCurrencies.flatMap(pCurrenciesBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pCurrenciesBody);
      // Delegate request to service.
      return productService.addCurrencies(pCurrenciesBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#isCurrencySupported()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/currencies/valid",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.CurrencyCode> isCurrencySupported(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.CurrencyCode> pCurrency,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pCurrency.flatMap(pCurrencyBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pCurrencyBody);
      // Delegate request to service.
      return productService.isCurrencySupported(pCurrencyBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testCodeTypeUsage()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/codeTypeUsages",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<com.anaptecs.spring.base.IntegerCodeType> testCodeTypeUsage(
      @org.springframework.web.bind.annotation.RequestBody(
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam reactor.core.publisher.Mono<com.anaptecs.spring.base.StringCodeType> pStringCode,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return pStringCode.flatMap(pStringCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pStringCodeBody);
      // Delegate request to service.
      return productService.testCodeTypeUsage(pStringCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testLocalBeanParamType()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/LocalBeanParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testLocalBeanParamType(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "localKey",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalKey,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "localID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalID,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.LocalBeanParamType.Builder lBeanParamBuilder =
        com.anaptecs.spring.service.LocalBeanParamType.builder();
    lBeanParamBuilder.setLocalKey(pLocalKey);
    lBeanParamBuilder.setLocalID(pLocalID);
    com.anaptecs.spring.service.LocalBeanParamType pBeanParam = lBeanParamBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return productService.testLocalBeanParamType(pBeanParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testExternalBeanParameterType()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/ExternalBeanParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testExternalBeanParameterType(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "novaKey",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pNovaKey,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "tkID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pTkID,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.ParentBeanParamType.Builder lParentBuilder =
        com.anaptecs.spring.base.ParentBeanParamType.builder();
    lParentBuilder.setNovaKey(pNovaKey);
    lParentBuilder.setTkID(pTkID);
    com.anaptecs.spring.base.ParentBeanParamType pParent = lParentBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pParent);
      // Delegate request to service.
      return productService.testExternalBeanParameterType(pParent);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testChildBeanParameter()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/ChildBeanParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testChildBeanParameter(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "novaKey",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pNovaKey,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "tkID",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pTkID,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "X-Child-Property",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pChildProperty,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.ChildBeanParameterType.Builder lChildBuilder =
        com.anaptecs.spring.service.ChildBeanParameterType.builder();
    lChildBuilder.setNovaKey(pNovaKey);
    lChildBuilder.setTkID(pTkID);
    lChildBuilder.setChildProperty(pChildProperty);
    com.anaptecs.spring.service.ChildBeanParameterType pChild = lChildBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pChild);
      // Delegate request to service.
      return productService.testChildBeanParameter(pChild);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateQueryParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/test-date-query-params/{path}",
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
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pPath,
          pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate,
          pSQLTimestamp, pSQLTime, pSQLDate);
      // Delegate request to service.
      return productService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
          pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateQueryParamsBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/test-date-query-params-beans/{path}",
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
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pPath, pQueryParams);
      // Delegate request to service.
      return productService.testDateQueryParamsBean(pPath, pQueryParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateHeaderParams()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/test-date-header-params/{path}",
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
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pPath,
          pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp,
          pSQLTime, pSQLDate);
      // Delegate request to service.
      return productService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime,
          pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateHeaderParamsBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/test-date-header-params-beans/{path}",
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
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pPath,
          pHeaderParams);
      // Delegate request to service.
      return productService.testDateHeaderParamsBean(pPath, pHeaderParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/technicalHeaderParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testTechnicalHeaderParam(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Reseller",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pReseller,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pReseller);
      // Delegate request to service.
      return productService.testTechnicalHeaderParam(pReseller);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderBean()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/technicalHeaderBeanParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<java.lang.String> testTechnicalHeaderBean(
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "Reseller",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pReseller,
      @org.springframework.web.bind.annotation.RequestHeader java.util.Map<String, String> pHeaders,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.base.TechnicalHeaderContext.Builder lContextBuilder =
        com.anaptecs.spring.base.TechnicalHeaderContext.builder();
    lContextBuilder.setReseller(pReseller);
    com.anaptecs.spring.base.TechnicalHeaderContext pContext = lContextBuilder.build();
    // Add custom headers.
    for (java.util.Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.testTechnicalHeaderBean(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#processDataTypes()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/product-codes",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> processDataTypes(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "pCodes",
          required = false) String[] pCodesAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    java.util.List<com.anaptecs.spring.base.AnotherDataType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new java.util.ArrayList<com.anaptecs.spring.base.AnotherDataType>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(com.anaptecs.spring.base.AnotherDataType.builder().setData(lNext).build());
      }
    }
    else {
      pCodes = java.util.Collections.emptyList();
    }
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.ProductServiceReactive.class, pCodes);
      // Delegate request to service.
      return productService.processDataTypes(pCodes);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.monitoring.MonitoringService#getVersionInfo()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "products/info",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> getVersionInfo(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.getVersionInfo();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.ProductServiceReactive.class, lResponse));
  }
}
