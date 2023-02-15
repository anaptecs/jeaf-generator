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

import com.anaptecs.spring.service.PathlessService;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@RequestMapping(path = "/nova/prefix")
@RestController
public class PathlessServiceResource {
  /**
   * All request to this class will be delegated to {@link PathlessService}.
   */
  private final PathlessService pathlessService;

  /**
   * Initialize object.
   * 
   * @param pPathlessService Dependency on concrete {@link PathlessService} implementation that should be used.
   */
  public PathlessServiceResource( PathlessService pPathlessService ) {
    pathlessService = pPathlessService;
  }

  /**
   * {@link PathlessService#getSomething()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "doSomething", method = { RequestMethod.GET })
  public String getSomething( ) {
    // Delegate request to service.
    return pathlessService.getSomething();
  }
}
