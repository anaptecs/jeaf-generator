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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRESTServiceResource {
  /**
   * {@link ProductRESTService#getProducts()}
   */
  @GET
  public Response getProducts( ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    List<Product> lResult = lService.getProducts();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#getProduct()}
   */
  @Path("{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    Product lResult = lService.getProduct(pProductID);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    boolean lResult = lService.createProduct(pProduct);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    Sortiment lResult = lService.getSortiment(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public Response createChannelCode( String pChannelCode ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#ping()}
   */
  @HEAD
  public Response ping( ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    lService.ping();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductRESTService#deprecatedOperation()}
   */
  @Path("deprecated/operation")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    String lResult = lService.deprecatedOperation();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#deprecatedContext()}
   */
  @Path("deprecated/context")
  @POST
  public Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    String lResult = lService.deprecatedContext(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#deprecatedBeanParam()}
   */
  @Path("deprecated/beanParams")
  @POST
  public Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    lService.deprecatedBeanParam(pBeanParam);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductRESTService#deprecatedParams()}
   */
  @Path("deprecated/params")
  @POST
  @Deprecated
  public Response deprecatedParams( @HeaderParam("param1") @Deprecated int pParam1 ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    String lResult = lService.deprecatedParams(pParam1);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#deprecatedBody()}
   */
  @Path("deprecated/body")
  @POST
  public Response deprecatedBody( @Deprecated String pBody ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    String lResult = lService.deprecatedBody(pBody);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductRESTService#deprectedComplexRequestBody()}
   */
  @Path("deprecated/complexBody")
  @POST
  public Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    lService.deprectedComplexRequestBody(pProduct);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductRESTService#deprecatedComplexReturn()}
   */
  @Path("deprecated/complexReturn")
  @GET
  @Deprecated
  public Response deprecatedComplexReturn( ) {
    ProductRESTService lService = JEAF.getService(ProductRESTService.class);
    Product lResult = lService.deprecatedComplexReturn();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }
}
