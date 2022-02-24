/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductServiceResource {
  /**
   * {@link ProductService#getProducts()}
   */
  @GET
  public Response getProducts( ) {
    ProductService lService = JEAF.getService(ProductService.class);
    List<Product> lResult = lService.getProducts();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @Path("{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    ProductService lService = JEAF.getService(ProductService.class);
    Product lResult = lService.getProduct(pProductID);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
    ProductService lService = JEAF.getService(ProductService.class);
    boolean lResult = lService.createProduct(pProduct);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext ) {
    ProductService lService = JEAF.getService(ProductService.class);
    Sortiment lResult = lService.getSortiment(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public Response createChannelCode( String pChannelCode ) {
    ProductService lService = JEAF.getService(ProductService.class);
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#ping()}
   */
  @HEAD
  public Response ping( ) {
    ProductService lService = JEAF.getService(ProductService.class);
    lService.ping();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @Path("deprecated/operation")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    ProductService lService = JEAF.getService(ProductService.class);
    String lResult = lService.deprecatedOperation();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @Path("deprecated/context")
  @POST
  public Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    ProductService lService = JEAF.getService(ProductService.class);
    String lResult = lService.deprecatedContext(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @Path("deprecated/beanParams")
  @POST
  public Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    ProductService lService = JEAF.getService(ProductService.class);
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
    ProductService lService = JEAF.getService(ProductService.class);
    String lResult = lService.deprecatedParams(pParam1);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @Path("deprecated/body")
  @POST
  public Response deprecatedBody( @Deprecated String pBody ) {
    ProductService lService = JEAF.getService(ProductService.class);
    String lResult = lService.deprecatedBody(pBody);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @Path("deprecated/complexBody")
  @POST
  public Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    ProductService lService = JEAF.getService(ProductService.class);
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
    ProductService lService = JEAF.getService(ProductService.class);
    Product lResult = lService.deprecatedComplexReturn();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @Path("specific/{id}")
  @PATCH
  public Response loadSpecificThings( @BeanParam SpecialContext pContext ) {
    ProductService lService = JEAF.getService(ProductService.class);
    lService.loadSpecificThings(pContext);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @Path("ChannelCodeObject")
  @POST
  public Response createChannelCodeFromObject( ChannelCode pChannelCode ) {
    ProductService lService = JEAF.getService(ProductService.class);
    ChannelCode lResult = lService.createChannelCodeFromObject(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }
}
