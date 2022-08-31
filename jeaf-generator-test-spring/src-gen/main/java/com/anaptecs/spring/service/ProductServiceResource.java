/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

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
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@RequestMapping(path = "/products", consumes = { "application/json" }, produces = { "application/json" })
@RestController
public class ProductServiceResource {
  @Inject
  private ProductService productService;

  /**
   * {@link ProductService#getProducts()}
   */
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.getProducts();
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.getProduct(pProductID);
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.createProduct(pProduct);
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @RequestMapping(path = "sortiment/{id}", method = { RequestMethod.GET })
  public Sortiment getSortiment( @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) String pQueryParam ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    Context.Builder lBuilder = Context.Builder.newBuilder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    Context pContext = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.getSortiment(pContext);
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
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.createChannelCode(pChannelCode);
  }

  /**
   * {@link ProductService#ping()}
   */
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    lService.ping();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @RequestMapping(path = "deprecated/operation", method = { RequestMethod.GET })
  @Deprecated
  public String deprecatedOperation( ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.deprecatedOperation();
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
    DeprecatedContext.Builder lBuilder = DeprecatedContext.Builder.newBuilder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setQueryParam(pQueryParam);
    DeprecatedContext pContext = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.deprecatedContext(pContext);
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
    BeanParameter.Builder lBuilder = BeanParameter.Builder.newBuilder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setOldStyle(pOldStyle);
    BeanParameter pBeanParam = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    lService.deprecatedBeanParam(pBeanParam);
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @RequestMapping(path = "deprecated/params", method = { RequestMethod.POST })
  @Deprecated
  public String deprecatedParams( @RequestHeader(name = "param1", required = true) @Deprecated int pParam1 ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.deprecatedParams(pParam1);
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @RequestMapping(path = "deprecated/body", method = { RequestMethod.POST })
  public String deprecatedBody( @RequestBody(required = true) @Deprecated String pBody ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.deprecatedBody(pBody);
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @RequestMapping(path = "deprecated/complexBody", method = { RequestMethod.POST })
  public void deprectedComplexRequestBody( @RequestBody(required = true) @Deprecated Product pProduct ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    lService.deprectedComplexRequestBody(pProduct);
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @RequestMapping(path = "deprecated/complexReturn", method = { RequestMethod.GET })
  @Deprecated
  public Product deprecatedComplexReturn( ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.deprecatedComplexReturn();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @RequestMapping(path = "specific/{id}", method = { RequestMethod.PATCH })
  public void loadSpecificThings( @RequestHeader(name = "specificHeader", required = true) String pSpecificHeader,
      @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) String pQueryParam ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    SpecialContext.Builder lBuilder = SpecialContext.Builder.newBuilder();
    lBuilder.setSpecificHeader(pSpecificHeader);
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    SpecialContext pContext = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    lService.loadSpecificThings(pContext);
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @RequestMapping(path = "ChannelCodeObject", method = { RequestMethod.POST })
  public ChannelCode createChannelCodeFromObject( @RequestBody(required = true) ChannelCode pChannelCode ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.createChannelCodeFromObject(pChannelCode);
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @RequestMapping(path = "currencies", method = { RequestMethod.POST })
  public List<CurrencyCode> addCurrencies( @RequestBody(required = true) List<CurrencyCode> pCurrencies ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.addCurrencies(pCurrencies);
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @RequestMapping(path = "currencies/valid", method = { RequestMethod.POST })
  public CurrencyCode isCurrencySupported( @RequestBody(required = true) CurrencyCode pCurrency ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.isCurrencySupported(pCurrency);
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @RequestMapping(path = "codeTypeUsages", method = { RequestMethod.POST })
  public IntegerCodeType testCodeTypeUsage( @RequestBody(required = true) StringCodeType pStringCode ) {
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.testCodeTypeUsage(pStringCode);
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @RequestMapping(path = "LocalBeanParam", method = { RequestMethod.GET })
  public String testLocalBeanParamType( @RequestHeader(name = "localKey", required = true) String pLocalKey,
      @RequestHeader(name = "localID", required = true) String pLocalID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    LocalBeanParamType.Builder lBuilder = LocalBeanParamType.Builder.newBuilder();
    lBuilder.setLocalKey(pLocalKey);
    lBuilder.setLocalID(pLocalID);
    LocalBeanParamType pBeanParam = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.testLocalBeanParamType(pBeanParam);
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @RequestMapping(path = "ExternalBeanParam", method = { RequestMethod.GET })
  public String testExternalBeanParameterType( @RequestHeader(name = "novaKey", required = true) String pNovaKey,
      @RequestHeader(name = "tkID", required = true) String pTkID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ParentBeanParamType.Builder lBuilder = ParentBeanParamType.Builder.newBuilder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    ParentBeanParamType pParent = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.testExternalBeanParameterType(pParent);
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @RequestMapping(path = "ChildBeanParam", method = { RequestMethod.GET })
  public String testChildBeanParameter(
      @RequestHeader(name = "X-Child-Property", required = true) String pChildProperty,
      @RequestHeader(name = "novaKey", required = true) String pNovaKey,
      @RequestHeader(name = "tkID", required = true) String pTkID ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    ChildBeanParameterType.Builder lBuilder = ChildBeanParameterType.Builder.newBuilder();
    lBuilder.setChildProperty(pChildProperty);
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    ChildBeanParameterType pChild = lBuilder.build();
    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.testChildBeanParameter(pChild);
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return ProductService Service instance to which all requests will be delegated.
   */
  private ProductService getProductService( ) {
    return productService;
  }
}
