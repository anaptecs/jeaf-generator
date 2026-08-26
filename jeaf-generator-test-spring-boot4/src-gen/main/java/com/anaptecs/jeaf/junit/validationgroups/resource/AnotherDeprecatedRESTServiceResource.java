/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups.resource;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.junit.validationgroups.AnotherDeprecatedRESTService;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
 */
@RequestMapping(path = "/nova/prefix")
@RestController
@Deprecated
public class AnotherDeprecatedRESTServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link AnotherDeprecatedRESTService}.
   */
  private final AnotherDeprecatedRESTService anotherDeprecatedRESTService;

  /**
   * Initialize object.
   *
   * @param pAnotherDeprecatedRESTService Dependency on concrete {@link AnotherDeprecatedRESTService} implementation
   * that should be used.
   * @param pValidationExecutor Validation executor for request / response validation.
   */
  public AnotherDeprecatedRESTServiceResource( AnotherDeprecatedRESTService pAnotherDeprecatedRESTService,
      ValidationExecutor pValidationExecutor ) {
    anotherDeprecatedRESTService = pAnotherDeprecatedRESTService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link AnotherDeprecatedRESTService#operationOfADeprecatedService()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(
      path = "multi-versioning/deprecated-service",
      produces = { "application/json" },
      method = { RequestMethod.POST })
  @Deprecated
  public void operationOfADeprecatedService( ) {
    // Delegate request to service.
    anotherDeprecatedRESTService.operationOfADeprecatedService();
  }
}