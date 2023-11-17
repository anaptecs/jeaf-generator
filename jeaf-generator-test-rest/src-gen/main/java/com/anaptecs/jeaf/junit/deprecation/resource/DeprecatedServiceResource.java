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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated This service does not make sense any more.<br/>
 * <br/>
 * The functionality is completely wrong. (<b>since:</b> 1.0, <b>removed with:</b> 2023-12-31)
 */
@Path("/nova/prefix/deprecation")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Deprecated
public class DeprecatedServiceResource {
    /**
     * Method returns reference to service to which all REST requests will be delegated.
     *
     * @return DeprecatedService Service instance to which all requests will be delegated.
     */
    private DeprecatedService getDeprecatedService( ) {
        return JEAF.getService(DeprecatedService.class);
    }
}
