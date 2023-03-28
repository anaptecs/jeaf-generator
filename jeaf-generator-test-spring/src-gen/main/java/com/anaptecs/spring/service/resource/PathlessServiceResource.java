/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.spring.service.PathlessService;

@RequestMapping(path = "/nova/prefix")
@RestController
public class PathlessServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link PathlessService}.
   */
  private final PathlessService pathlessService;

  /**
   * Initialize object.
   * 
   * @param pPathlessService Dependency on concrete {@link PathlessService} implementation that should be used.
   */
  public PathlessServiceResource( PathlessService pPathlessService, ValidationExecutor pValidationExecutor ) {
    pathlessService = pPathlessService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link PathlessService#getSomething()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "doSomething", method = { RequestMethod.GET })
  public String getSomething( ) {
    // Delegate request to service.
    String lResponse = pathlessService.getSomething();
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResponse);
    return lResponse;
  }
}
