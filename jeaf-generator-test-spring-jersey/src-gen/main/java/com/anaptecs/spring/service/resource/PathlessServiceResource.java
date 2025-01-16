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

import org.springframework.beans.factory.annotation.Autowired;

import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.PathlessService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PathlessServiceResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  @Autowired
  private ObjectMapper objectMapper;

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

  /**
   * {@link PathlessService#processTechParam()}
   */
  @Path("processTechParam")
  @POST
  public Response processTechParam( @BeanParam MultiValuedHeaderBeanParam pHeaderBean ) {
    // Delegate request to service.
    pathlessService.processTechParam(pHeaderBean);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link PathlessService#testQueryBeanParam()}
   */
  @Path("test-query-bean-param")
  @GET
  public Response testQueryBeanParam( @BeanParam DataTypesQueryBean pQuery ) {
    // Delegate request to service.
    String lResult = pathlessService.testQueryBeanParam(pQuery);
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
        lBuilder.append("\"");
        lBuilder.append(pCompositeDataTypeAsString);
        lBuilder.append("\"");
        lObject = objectMapper.readValue(lBuilder.toString(), pType);
      }
      else {
        lObject = null;
      }
      return lObject;
    }
    catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}