/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Path("do/something")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Deprecated
public class DeprecatedRESTServiceResource {
  /**
   * {@link DeprecatedRESTService#doSomething()}
   */
  @GET
  public Response doSomething( ) {
    DeprecatedRESTService lService = JEAF.getService(DeprecatedRESTService.class);
    lService.doSomething();
    return Response.status(Response.Status.OK).build();
  }
}