/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.PathlessService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PathlessServiceResource {
  /**
   * {@link PathlessService#getSomething()}
   */
  @Path("doSomething")
  @GET
  public Response getSomething( ) {
    // Delegate request to service.
    PathlessService lService = this.getPathlessService();
    String lResult = lService.getSomething();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link PathlessService#processTechParam()}
   */
  @Path("processTechParam")
  @POST
  public Response processTechParam( @BeanParam MultiValuedHeaderBeanParam pHeaderBean ) {
    // Delegate request to service.
    PathlessService lService = this.getPathlessService();
    lService.processTechParam(pHeaderBean);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link PathlessService#testQueryBeanParam()}
   */
  @Path("test-query-bean-param")
  @GET
  public Response testQueryBeanParam( @BeanParam DataTypesQueryBean pQuery ) {
    // Delegate request to service.
    PathlessService lService = this.getPathlessService();
    String lResult = lService.testQueryBeanParam(pQuery);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return PathlessService Service instance to which all requests will be delegated.
   */
  private PathlessService getPathlessService( ) {
    return JEAF.getService(PathlessService.class);
  }
}