/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.core.TestServiceObject;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RESTTestServiceResource {
  /**
   * {@link RESTTestService#getResource()}
   */
  @GET
  public Response getResource( @PathParam("{ID}") String pID ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    String lResult = lService.getResource(pID);
    return Response.status(Response.Status.ACCEPTED).entity(lResult).build();
  }

  /**
   * {@link RESTTestService#updateTestServiceObject()}
   */
  @POST
  public void updateTestServiceObject( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest, TestServiceObject pObject ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    RESTTestService lService = this.getRESTTestService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          TestServiceObject lResult = lService.updateTestServiceObject(pObject);
          Response lResponseObject = Response.status(Response.Status.RESET_CONTENT).entity(lResult).build();
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
   * {@link RESTTestService#doSomethingRESTy()}
   */
  @Path("very/special/path")
  @PUT
  @Consumes(MediaType.APPLICATION_OCTET_STREAM)
  public Response doSomethingRESTy( ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    lService.doSomethingRESTy();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTTestService#yetAnotherRESTOperation()}
   */
  @Path("something/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response yetAnotherRESTOperation( @PathParam("id") String pID, @HeaderParam("token") String pToken,
      @QueryParam("filter") String pQueryParam1, @CookieParam("cookieEntry") String pCookieParam ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    boolean lResult = lService.yetAnotherRESTOperation(pID, pToken, pQueryParam1, pCookieParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTTestService#handleBeanParam1()}
   */
  @Path("beanParam1")
  @GET
  public Response handleBeanParam1( @BeanParam Context pContext ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    lService.handleBeanParam1(pContext);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTTestService#handleBeanParam1()}
   */
  @Path("beanParam2")
  @POST
  public Response handleBeanParam1( @BeanParam BeanParameter pBeanParam ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    lService.handleBeanParam1(pBeanParam);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTTestService#deprecatedOperation()}
   */
  @Path("deprcation/dep1")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    lService.deprecatedOperation();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTTestService#deprecatedParameter()}
   */
  @Path("deprecation/dep2")
  @GET
  public Response deprecatedParameter( @HeaderParam("pParam1") int pParam1,
      @HeaderParam("pParam2") @Deprecated int pParam2 ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    lService.deprecatedParameter(pParam1, pParam2);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link RESTTestService#deprectaedReturnValue()}
   */
  @Path("deprecation/dep3")
  @GET
  @Deprecated
  public Response deprectaedReturnValue( @HeaderParam("pParam1") int pParam1 ) {
    // Delegate request to service.
    RESTTestService lService = this.getRESTTestService();
    int lResult = lService.deprectaedReturnValue(pParam1);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTTestService#deprecatedAsyncParam()}
   */
  @Path("dep/async")
  @POST
  @Deprecated
  public void deprecatedAsyncParam( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest, @Deprecated int pParam1 ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    RESTTestService lService = this.getRESTTestService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          String lResult = lService.deprecatedAsyncParam(pParam1);
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
   * {@link RESTTestService#deprecatedAsync()}
   */
  @Path("dep/async")
  @POST
  @Deprecated
  public void deprecatedAsync( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest, int pParam1 ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    RESTTestService lService = this.getRESTTestService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          String lResult = lService.deprecatedAsync(pParam1);
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
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return RESTTestService Service instance to which all requests will be delegated.
   */
  private RESTTestService getRESTTestService( ) {
    return JEAF.getService(RESTTestService.class);
  }
}
