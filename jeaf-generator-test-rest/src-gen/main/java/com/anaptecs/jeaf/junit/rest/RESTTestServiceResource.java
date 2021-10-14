/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import javax.servlet.http.HttpServletRequest;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.core.TestServiceObject;
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
  public Response getResource( String pID ) {
    RESTTestService lService = JEAF.getService(RESTTestService.class);
    String lResult = lService.getResource(pID);
    return Response.status(Response.Status.ACCEPTED).entity(lResult).build();
  }

  /**
   * {@link RESTTestService#updateTestServiceObject()}
   */
  @POST
  public void updateTestServiceObject( @Suspended AsyncResponse pAsyncResponse, @Context HttpServletRequest pRequest,
      TestServiceObject pObject ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          // As soon as the request is executed the service call will be performed.
          RESTTestService lService = JEAF.getService(RESTTestService.class);
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
    RESTTestService lService = JEAF.getService(RESTTestService.class);
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
    RESTTestService lService = JEAF.getService(RESTTestService.class);
    boolean lResult = lService.yetAnotherRESTOperation(pID, pToken, pQueryParam1, pCookieParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }
}
