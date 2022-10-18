/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.accounting.AccountingService;
import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.accounting.SecurityToken;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;

/**
 * This interface defines the common services that are provided by the accounting component. This interface is intended
 * to be an example to demonstrate how to use JEAF.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Path("/nova/prefix/api/v1/accounting")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class AccountingServiceResource {
  /**
   * {@link AccountingService#performBooking()}
   */
  @Path("bookings")
  @PUT
  public void performBooking( @Suspended AsyncResponse pAsyncResponse, @Context HttpServletRequest pRequest,
      Booking pBooking, @HeaderParam("pSecurityToken") SecurityToken pSecurityToken ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    AccountingService lService = this.getAccountingService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          lService.performBooking(pBooking, pSecurityToken);
          Response lResponseObject = Response.ok().status(Response.Status.OK).build();
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
   * @return AccountingService Service instance to which all requests will be delegated.
   */
  private AccountingService getAccountingService( ) {
    return JEAF.getService(AccountingService.class);
  }
}
