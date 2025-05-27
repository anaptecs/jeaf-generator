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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.anaptecs.spring.base.AnotherDataType;
import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.DoubleCode;
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
import com.anaptecs.spring.service.ProductServiceReactive;
import reactor.core.publisher.Mono;

@RequestMapping(path = "/nova/prefix")
@RestController
public class ProductServiceReactiveResource {
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
   * All request to this class will be delegated to {@link com.anaptecs.spring.service.ProductService}.
   */
  private final ProductServiceReactive productService;

  /**
   * Initialize object.
   *
   * @param pProductService Dependency on concrete {@link com.anaptecs.spring.service.ProductService} implementation
   * that should be used.
   */
  public ProductServiceReactiveResource( ProductServiceReactive pProductService, ValidationExecutor pValidationExecutor,
      CustomHeaderFilter pCustomHeaderFilter ) {
    productService = pProductService;
    validationExecutor = pValidationExecutor;
    customHeaderFilter = pCustomHeaderFilter;
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getProducts()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/", method = { RequestMethod.GET })
  @MyNotEmptyRESTParam
  public Mono<List<Product>> getProducts( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.getProducts();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getProduct()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/{id}", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<Product> getProduct( @PathVariable(name = "id", required = true) @MyNotNullRESTParam String pProductID,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pProductID);
      // Delegate request to service.
      return productService.getProduct(pProductID);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createProduct()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/", method = { RequestMethod.POST })
  public Mono<Boolean> createProduct( @RequestBody(required = true) @MyNotNullRESTParam Mono<Product> pProduct,
      ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return productService.createProduct(pProductBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#getSortiment()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/sortiment/{id}", method = { RequestMethod.GET })
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
    Context.ContextBuilder<?, ?> lContextBuilder = Context.builder();
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
      validationExecutor.validateRequest(ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.getSortiment(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createChannelCode()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(
      path = "products/ChannelCode",
      consumes = { "application/json" },
      produces = { "application/json" },
      method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<ChannelCode> createChannelCode(
      @RequestBody(required = true) @MyNotNullRESTParam Mono<String> pChannelCode,
      ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pChannelCodeBody);
      // Delegate request to service.
      return productService.createChannelCode(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#ping()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/", method = { RequestMethod.HEAD })
  @MyNotNullRESTParam
  public Mono<Void> ping( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.ping();
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedOperation()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/deprecated/operation", method = { RequestMethod.GET })
  @Deprecated
  @MyNotNullRESTParam
  public Mono<String> deprecatedOperation( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.deprecatedOperation();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedContext()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/deprecated/context", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<String> deprecatedContext(
      @RequestHeader(name = "token", required = true) @MyNotNullRESTParam String pAccessToken,
      @RequestHeader(name = "lang", required = true) @MyNotNullRESTParam Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @RequestParam(name = "q1", required = true) @MyNotNullRESTParam String pQueryParam,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DeprecatedContext.DeprecatedContextBuilder<?, ?> lContextBuilder = DeprecatedContext.builder();
    lContextBuilder.setAccessToken(pAccessToken);
    lContextBuilder.setLanguage(pLanguage);
    lContextBuilder.setResellerID(pResellerID);
    lContextBuilder.setQueryParam(pQueryParam);
    DeprecatedContext pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.deprecatedContext(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedBeanParam()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/deprecated/beanParams", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<Void> deprecatedBeanParam(
      @RequestHeader(name = "token", required = true) @MyNotNullRESTParam String pAccessToken,
      @RequestHeader(name = "lang", required = true) @MyNotNullRESTParam Locale pLanguage,
      @RequestParam(name = "q2", required = true) @Deprecated @MyNotNullRESTParam String pOldStyle,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    BeanParameter.BeanParameterBuilder<?, ?> lBeanParamBuilder = BeanParameter.builder();
    lBeanParamBuilder.setAccessToken(pAccessToken);
    lBeanParamBuilder.setLanguage(pLanguage);
    lBeanParamBuilder.setOldStyle(pOldStyle);
    BeanParameter pBeanParam = lBeanParamBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return productService.deprecatedBeanParam(pBeanParam);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedParams()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/deprecated/params", method = { RequestMethod.POST })
  @Deprecated
  @MyNotNullRESTParam
  public Mono<String> deprecatedParams( @RequestHeader(name = "param1", required = true) @Deprecated int pParam1,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pParam1);
      // Delegate request to service.
      return productService.deprecatedParams(pParam1);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedBody()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/deprecated/body", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<String> deprecatedBody( @RequestBody(required = true) @Deprecated @MyNotNullRESTParam Mono<String> pBody,
      ServerWebExchange pServerWebExchange ) {
    return pBody.flatMap(pBodyBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pBodyBody);
      // Delegate request to service.
      return productService.deprecatedBody(pBodyBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprectedComplexRequestBody()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/deprecated/complexBody", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<Void> deprectedComplexRequestBody(
      @RequestBody(required = true) @Deprecated @MyNotNullRESTParam Mono<Product> pProduct,
      ServerWebExchange pServerWebExchange ) {
    return pProduct.flatMap(pProductBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pProductBody);
      // Delegate request to service.
      return productService.deprectedComplexRequestBody(pProductBody);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#deprecatedComplexReturn()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/deprecated/complexReturn", method = { RequestMethod.GET })
  @Deprecated
  @MyNotNullRESTParam
  public Mono<Product> deprecatedComplexReturn( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.deprecatedComplexReturn();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#loadSpecificThings()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/specific/{id}", method = { RequestMethod.PATCH })
  @MyNotNullRESTParam
  public Mono<Void> loadSpecificThings(
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
    SpecialContext.SpecialContextBuilder<?, ?> lContextBuilder = SpecialContext.builder();
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
      validationExecutor.validateRequest(ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.loadSpecificThings(pContext);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#createChannelCodeFromObject()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/ChannelCodeObject", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<ChannelCode> createChannelCodeFromObject(
      @RequestBody(required = true) @MyNotNullRESTParam Mono<ChannelCode> pChannelCode,
      ServerWebExchange pServerWebExchange ) {
    return pChannelCode.flatMap(pChannelCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pChannelCodeBody);
      // Delegate request to service.
      return productService.createChannelCodeFromObject(pChannelCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#addCurrencies()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/currencies", method = { RequestMethod.POST })
  @MyNotEmptyRESTParam
  public Mono<List<CurrencyCode>> addCurrencies(
      @RequestBody(required = true) @MyNotEmptyRESTParam Mono<List<CurrencyCode>> pCurrencies,
      ServerWebExchange pServerWebExchange ) {
    return pCurrencies.flatMap(pCurrenciesBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pCurrenciesBody);
      // Delegate request to service.
      return productService.addCurrencies(pCurrenciesBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#isCurrencySupported()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/currencies/valid", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<CurrencyCode> isCurrencySupported(
      @RequestBody(required = true) @MyNotNullRESTParam Mono<CurrencyCode> pCurrency,
      ServerWebExchange pServerWebExchange ) {
    return pCurrency.flatMap(pCurrencyBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pCurrencyBody);
      // Delegate request to service.
      return productService.isCurrencySupported(pCurrencyBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testCodeTypeUsage()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/codeTypeUsages", method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<IntegerCodeType> testCodeTypeUsage(
      @RequestBody(required = true) @MyNotNullRESTParam Mono<StringCodeType> pStringCode,
      ServerWebExchange pServerWebExchange ) {
    return pStringCode.flatMap(pStringCodeBody -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pStringCodeBody);
      // Delegate request to service.
      return productService.testCodeTypeUsage(pStringCodeBody);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testLocalBeanParamType()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/LocalBeanParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testLocalBeanParamType(
      @RequestHeader(name = "localKey", required = true) @MyNotNullRESTParam String pLocalKey,
      @RequestHeader(name = "localID", required = true) @MyNotNullRESTParam String pLocalID,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    LocalBeanParamType.LocalBeanParamTypeBuilder<?, ?> lBeanParamBuilder = LocalBeanParamType.builder();
    lBeanParamBuilder.setLocalKey(pLocalKey);
    lBeanParamBuilder.setLocalID(pLocalID);
    LocalBeanParamType pBeanParam = lBeanParamBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pBeanParam);
      // Delegate request to service.
      return productService.testLocalBeanParamType(pBeanParam);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testExternalBeanParameterType()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/ExternalBeanParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testExternalBeanParameterType(
      @RequestHeader(name = "novaKey", required = true) @MyNotNullRESTParam String pNovaKey,
      @RequestHeader(name = "tkID", required = true) @MyNotNullRESTParam String pTkID,
      @RequestHeader(name = "code", required = true) @MyNotNullRESTParam Double pCodeAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ParentBeanParamType.ParentBeanParamTypeBuilder<?, ?> lParentBuilder = ParentBeanParamType.builder();
    lParentBuilder.setNovaKey(pNovaKey);
    lParentBuilder.setTkID(pTkID);
    // Handle bean parameter pParent.code
    if (pCodeAsBasicType != null) {
      lParentBuilder.setCode(DoubleCode.builder().setCode(pCodeAsBasicType).build());
    }
    ParentBeanParamType pParent = lParentBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pParent);
      // Delegate request to service.
      return productService.testExternalBeanParameterType(pParent);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testChildBeanParameter()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/ChildBeanParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testChildBeanParameter(
      @RequestHeader(name = "novaKey", required = true) @MyNotNullRESTParam String pNovaKey,
      @RequestHeader(name = "tkID", required = true) @MyNotNullRESTParam String pTkID,
      @RequestHeader(name = "code", required = true) @MyNotNullRESTParam Double pCodeAsBasicType,
      @RequestHeader(name = "X-Child-Property", required = true) @MyNotNullRESTParam String pChildProperty,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ChildBeanParameterType.ChildBeanParameterTypeBuilder<?, ?> lChildBuilder = ChildBeanParameterType.builder();
    lChildBuilder.setNovaKey(pNovaKey);
    lChildBuilder.setTkID(pTkID);
    // Handle bean parameter pChild.code
    if (pCodeAsBasicType != null) {
      lChildBuilder.setCode(DoubleCode.builder().setCode(pCodeAsBasicType).build());
    }
    lChildBuilder.setChildProperty(pChildProperty);
    ChildBeanParameterType pChild = lChildBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pChild);
      // Delegate request to service.
      return productService.testChildBeanParameter(pChild);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateQueryParams()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/test-date-query-params/{path}", method = { RequestMethod.GET })
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
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pPath, pStartTimestamp, pStartTime,
          pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime,
          pSQLDate);
      // Delegate request to service.
      return productService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
          pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateQueryParamsBean()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/test-date-query-params-beans/{path}", method = { RequestMethod.GET })
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
    DateQueryParamsBean.DateQueryParamsBeanBuilder<?, ?> lQueryParamsBuilder = DateQueryParamsBean.builder();
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
      validationExecutor.validateRequest(ProductServiceReactive.class, pPath, pQueryParams);
      // Delegate request to service.
      return productService.testDateQueryParamsBean(pPath, pQueryParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateHeaderParams()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/test-date-header-params/{path}", method = { RequestMethod.GET })
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
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pPath, pOffsetDateTime, pOffsetTime,
          pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
      // Delegate request to service.
      return productService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime,
          pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testDateHeaderParamsBean()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "products/test-date-header-params-beans/{path}", method = { RequestMethod.GET })
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
    DateHeaderParamsBean.DateHeaderParamsBeanBuilder<?, ?> lHeaderParamsBuilder = DateHeaderParamsBean.builder();
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
      validationExecutor.validateRequest(ProductServiceReactive.class, pPath, pHeaderParams);
      // Delegate request to service.
      return productService.testDateHeaderParamsBean(pPath, pHeaderParams);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderParam()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/technicalHeaderParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testTechnicalHeaderParam(
      @RequestHeader(name = "Reseller", required = true) @MyNotNullRESTParam String pReseller,
      ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pReseller);
      // Delegate request to service.
      return productService.testTechnicalHeaderParam(pReseller);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#testTechnicalHeaderBean()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/technicalHeaderBeanParam", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> testTechnicalHeaderBean(
      @RequestHeader(name = "Reseller", required = true) @MyNotNullRESTParam String pReseller,
      @RequestHeader Map<String, String> pHeaders, ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    TechnicalHeaderContext.TechnicalHeaderContextBuilder<?, ?> lContextBuilder = TechnicalHeaderContext.builder();
    lContextBuilder.setReseller(pReseller);
    // Add custom headers.
    for (Map.Entry<String, String> lNextEntry : pHeaders.entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        lContextBuilder.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
    }
    TechnicalHeaderContext pContext = lContextBuilder.build();
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pContext);
      // Delegate request to service.
      return productService.testTechnicalHeaderBean(pContext);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.ProductService#processDataTypes()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/product-codes", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> processDataTypes( @RequestParam(name = "pCodes", required = false) String[] pCodesAsBasicType,
      ServerWebExchange pServerWebExchange ) {
    // Convert basic type parameters into "real" objects.
    List<AnotherDataType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<AnotherDataType>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(AnotherDataType.builder().setData(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    return Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(ProductServiceReactive.class, pCodes);
      // Delegate request to service.
      return productService.processDataTypes(pCodes);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.monitoring.MonitoringService#getVersionInfo()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "products/info", method = { RequestMethod.GET })
  @MyNotNullRESTParam
  public Mono<String> getVersionInfo( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) -> {
      // Delegate request to service.
      return productService.getVersionInfo();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(ProductServiceReactive.class, lResponse));
  }
}