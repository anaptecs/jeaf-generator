/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.junit.rest.DeprecatedRESTService;

@Path("/do/something")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Deprecated
@JEAFCustomAnnotationTest
public class DeprecatedRESTServiceResource {
  /**
   * {@link DeprecatedRESTService#doSomething()}
   */
  @GET
  @JEAFCustomAnnotationTest
  public Response doSomething( ) {
    // Delegate request to service.
    DeprecatedRESTService lService = this.getDeprecatedRESTService();
    lService.doSomething();
    return Response.status(Response.Status.ACCEPTED).build();
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return DeprecatedRESTService Service instance to which all requests will be delegated.
   */
  private DeprecatedRESTService getDeprecatedRESTService( ) {
    return JEAF.getService(DeprecatedRESTService.class);
  }
}