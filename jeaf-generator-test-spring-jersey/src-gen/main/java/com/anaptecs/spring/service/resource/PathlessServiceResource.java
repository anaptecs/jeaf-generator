/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.spring.service.PathlessService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PathlessServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  @Autowired
  private ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link PathlessService}.
   */
  @Autowired
  private PathlessService pathlessService;

  /**
   * {@link PathlessService#getSomething()}
   */
  @Path("doSomething")
  @GET
  public Response getSomething( ) {
    // Delegate request to service.
    String lResult = pathlessService.getSomething();
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }
}
