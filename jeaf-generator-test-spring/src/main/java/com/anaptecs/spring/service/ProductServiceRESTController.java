/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class ProductServiceRESTController {
  @Inject
  private ProductService productService;

  /**
   * {@link ProductService#getProducts()}
   */
  @RequestMapping(
      value = "/products",
      produces = { "application/json", "application/problem+json" },
      consumes = { "application/json" },
      method = { RequestMethod.GET })
  public List<Product> getProducts( ) {
    ProductService lService = this.getProductService();
    return lService.getProducts();
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @RequestMapping(
      value = "/products/{id}",
      produces = { "application/json", "application/problem+json" },
      consumes = { "application/json" },
      method = RequestMethod.GET)
  public Product getProduct( @PathVariable("id") String pProductID ) {
    ProductService lService = this.getProductService();
    return lService.getProduct(pProductID);
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @RequestMapping(
      value = "/products",
      produces = { "application/json", "application/problem+json" },
      consumes = { "application/json" },
      method = { RequestMethod.POST, RequestMethod.GET })
  public boolean createProduct( @RequestBody Product pProduct ) {
    ProductService lService = this.getProductService();
    return lService.createProduct(pProduct);
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Sortiment getSortiment( @RequestHeader("token") String pAccessToken, @HeaderParam("lang") Locale pLanguage,
      @CookieValue("reseller") long pResellerID, @PathVariable(name = "id") long pPathParam,
      @RequestParam("q1") String pQueryParam ) {

    // Convert parameters into object as "BeanParams" are not supported by Spring. This way we do not pollute the service interface but "only" our REST controller.
    Context.Builder lBuilder = Context.Builder.newBuilder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    Context lContext = lBuilder.build();

    // Get Spring service and delegate call.
    ProductService lService = this.getProductService();
    return lService.getSortiment(lContext);
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @RequestMapping(
      value = "/products/ChannelCode",
      produces = { "application/json", "application/problem+json" },
      consumes = { "application/json" },
      method = RequestMethod.POST)
  public ChannelCode createChannelCode( @RequestBody String pChannelCode ) {
    ProductService lService = this.getProductService();
    return lService.createChannelCode(pChannelCode);
  }

  /**
   * {@link ProductService#ping()}
   */
  @RequestMapping(
      value = "/products/ChannelCode",
      produces = { "application/json", "application/problem+json" },
      consumes = { "application/json" },
      method = RequestMethod.HEAD)
  public void ping( ) {
    ProductService lService = this.getProductService();
    lService.ping();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @Path("deprecated/operation")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedOperation();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @Path("deprecated/context")
  @POST
  public Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedContext(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @Path("deprecated/beanParams")
  @POST
  public Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    ProductService lService = this.getProductService();
    lService.deprecatedBeanParam(pBeanParam);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @Path("deprecated/params")
  @POST
  @Deprecated
  public Response deprecatedParams( @HeaderParam("param1") @Deprecated int pParam1 ) {
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedParams(pParam1);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @Path("deprecated/body")
  @POST
  public Response deprecatedBody( @DefaultValue("Hello World!") @Deprecated String pBody ) {
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedBody(pBody);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @Path("deprecated/complexBody")
  @POST
  public Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    ProductService lService = this.getProductService();
    lService.deprectedComplexRequestBody(pProduct);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @Path("deprecated/complexReturn")
  @GET
  @Deprecated
  public Response deprecatedComplexReturn( ) {
    ProductService lService = this.getProductService();
    Product lResult = lService.deprecatedComplexReturn();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @Path("specific/{id}")
  @PATCH
  public Response loadSpecificThings( @BeanParam SpecialContext pContext ) {
    ProductService lService = this.getProductService();
    lService.loadSpecificThings(pContext);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @Path("ChannelCodeObject")
  @POST
  public Response createChannelCodeFromObject( ChannelCode pChannelCode ) {
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCodeFromObject(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @Path("currencies")
  @POST
  public Response addCurrencies( List<CurrencyCode> pCurrencies ) {
    ProductService lService = this.getProductService();
    List<CurrencyCode> lResult = lService.addCurrencies(pCurrencies);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @Path("currencies/valid")
  @POST
  public Response isCurrencySupported( CurrencyCode pCurrency ) {
    ProductService lService = this.getProductService();
    CurrencyCode lResult = lService.isCurrencySupported(pCurrency);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @Path("codeTypeUsages")
  @POST
  public Response testCodeTypeUsage( StringCodeType pStringCode ) {
    ProductService lService = this.getProductService();
    IntegerCodeType lResult = lService.testCodeTypeUsage(pStringCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @Path("/LocalBeanParam")
  @GET
  public Response testLocalBeanParamType( @BeanParam LocalBeanParamType pBeanParam ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testLocalBeanParamType(pBeanParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @Path("/ExternalBeanParam")
  @GET
  public Response testExternalBeanParameterType( @BeanParam ParentBeanParamType pParent ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testExternalBeanParameterType(pParent);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @Path("/ChildBeanParam")
  @GET
  public Response testChildBeanParameter( @BeanParam ChildBeanParameterType pChild ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testChildBeanParameter(pChild);
    return Response.status(Response.Status.OK).entity(lResult).build();
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
