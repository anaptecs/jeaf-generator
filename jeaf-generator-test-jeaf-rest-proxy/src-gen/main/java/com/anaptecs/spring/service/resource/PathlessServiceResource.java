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

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.api.jeaf.CompositeTypeConverterServiceProvider;
import com.anaptecs.spring.service.PathlessService;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return PathlessService Service instance to which all requests will be delegated.
   */
  private PathlessService getPathlessService( ) {
    return JEAF.getService(PathlessService.class);
  }

  /**
   * Method returns the composite type converter that should be used in this environment. This REST interface makes
   * usage of so called composite data types. As Spring itself is not able to do conversions from a String
   * representation into a real object this is done in the generated REST Controller.
   * 
   * @return {@link CompositeTypeConverter} CompositeTypeConverter implementation that is configured to be used here.
   * The method never returns null.
   */
  private CompositeTypeConverter getCompositeTypeConverter( ) {
    return JEAF.getServiceProvider(CompositeTypeConverterServiceProvider.class);
  }
}