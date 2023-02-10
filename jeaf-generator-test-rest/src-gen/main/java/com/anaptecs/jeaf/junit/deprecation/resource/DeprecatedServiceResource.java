/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.deprecation.DeprecatedService;
import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.api.jeaf.CompositeTypeConverterServiceProvider;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Path("/nova/prefix/deprecation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeprecatedServiceResource {
  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return DeprecatedService Service instance to which all requests will be delegated.
   */
  private DeprecatedService getDeprecatedService( ) {
    return JEAF.getService(DeprecatedService.class);
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
