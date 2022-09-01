/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.TimeUnit;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Path("/rest-products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RESTProductServiceResource {
  @Inject
  private RESTProductService rESTProductService;

  /**
   * {@link RESTProductService#getProducts()}
   */
  @GET
  public void getProducts( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest, @QueryParam("maxResult") int pMaxResultSize ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    RESTProductService lService = this.getRESTProductService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          List<Product> lResult = lService.getProducts(pMaxResultSize);
          Response lResponseObject = Response.status(Response.Status.OK).entity(lResult).build();
          // Due to the asynchronous processing of the requests, the response can not be returned as return value.
          // Therefore we make use of the defined JAX-RS mechanisms.
          pAsyncResponse.resume(lResponseObject);
        }
        // All kinds of exceptions have to be reported to the client. Due to the asynchronous processing we have to
        // catch them here and return them to the client via class AsyncResponse.
        catch (RuntimeException e) {
          pAsyncResponse.resume(e);
        }
      }
    });
  }

  /**
   * {@link RESTProductService#getProduct()}
   */
  @Path("{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    RESTProductService lService = this.getRESTProductService();
    Product lResult = lService.getProduct(pProductID);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
    RESTProductService lService = this.getRESTProductService();
    boolean lResult = lService.createProduct(pProduct);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext ) {
    RESTProductService lService = this.getRESTProductService();
    Sortiment lResult = lService.getSortiment(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  public Response createChannelCode( String pChannelCode ) {
    RESTProductService lService = this.getRESTProductService();
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#ping()}
   */
  @HEAD
  public Response ping( ) {
    RESTProductService lService = this.getRESTProductService();
    lService.ping();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTProductService#testInit()}
   */
  @Path("test-init")
  @GET
  public Response testInit( ) {
    RESTProductService lService = this.getRESTProductService();
    lService.testInit();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTProductService#getSupportedCurrencies()}
   */
  @Path("currencies/{channelCode}")
  @GET
  public Response getSupportedCurrencies( @PathParam("channelCode") String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.Builder.newBuilder().setCode(pChannelCodeAsBasicType).build();
    RESTProductService lService = this.getRESTProductService();
    List<CurrencyCode> lResult = lService.getSupportedCurrencies(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#getSupportedCurrenciesAsync()}
   */
  @Path("async-currencies/{channelCode}")
  @GET
  public void getSupportedCurrenciesAsync( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest,
      @PathParam("channelCode") String pChannelCodeAsBasicType ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    RESTProductService lService = this.getRESTProductService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          // Convert basic type parameters into "real" objects.
          ChannelCode pChannelCode = ChannelCode.Builder.newBuilder().setCode(pChannelCodeAsBasicType).build();
          List<CurrencyCode> lResult = lService.getSupportedCurrenciesAsync(pChannelCode);
          Response lResponseObject = Response.status(Response.Status.OK).entity(lResult).build();
          // Due to the asynchronous processing of the requests, the response can not be returned as return value.
          // Therefore we make use of the defined JAX-RS mechanisms.
          pAsyncResponse.resume(lResponseObject);
        }
        // All kinds of exceptions have to be reported to the client. Due to the asynchronous processing we have to
        // catch them here and return them to the client via class AsyncResponse.
        catch (RuntimeException e) {
          pAsyncResponse.resume(e);
        }
      }
    });
  }

  /**
   * {@link RESTProductService#testParams()}
   */
  @Path("test-params")
  @GET
  public Response testParams( @HeaderParam("Big-Header") BigDecimal pBigDecimalHeader,
      @CookieParam("giveMeMoreCookies") int pIntCookieParam, @QueryParam("locale") Locale pLocaleQueryParam ) {
    RESTProductService lService = this.getRESTProductService();
    String lResult = lService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testEnumParams()}
   */
  @Path("test-enum-params/{channelType}")
  @GET
  public Response testEnumParams( @PathParam("channelType") ChannelType pChannelType,
      @QueryParam("timeUnit") TimeUnit pTimeUnit, @QueryParam("extensibleEnum") ExtensibleEnum pExtensibleEnum ) {
    RESTProductService lService = this.getRESTProductService();
    lService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return RESTProductService Service instance to which all requests will be delegated.
   */
  private RESTProductService getRESTProductService( ) {
    return rESTProductService;
  }
}
