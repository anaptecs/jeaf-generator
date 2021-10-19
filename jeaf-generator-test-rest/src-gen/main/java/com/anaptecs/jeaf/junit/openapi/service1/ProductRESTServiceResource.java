/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
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
  @Path("sortiment")
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
}
