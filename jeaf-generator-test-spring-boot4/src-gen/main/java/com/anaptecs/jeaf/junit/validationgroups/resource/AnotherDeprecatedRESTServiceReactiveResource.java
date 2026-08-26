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
import org.springframework.web.server.ServerWebExchange;

import com.anaptecs.annotations.MyNotNullRESTParam;
import com.anaptecs.jeaf.junit.validationgroups.AnotherDeprecatedRESTServiceReactive;
import com.anaptecs.jeaf.validation.api.ValidationExecutorReactive;
import reactor.core.publisher.Mono;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
 */
@RequestMapping(path = "/nova/prefix")
@RestController
@Deprecated
public class AnotherDeprecatedRESTServiceReactiveResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutorReactive validationExecutor;

  /**
   * All request to this class will be delegated to
   * {@link com.anaptecs.jeaf.junit.validationgroups.AnotherDeprecatedRESTService}.
   */
  private final AnotherDeprecatedRESTServiceReactive anotherDeprecatedRESTService;

  /**
   * Initialize object.
   *
   * @param pAnotherDeprecatedRESTService Dependency on concrete
   * {@link com.anaptecs.jeaf.junit.validationgroups.AnotherDeprecatedRESTService} implementation that should be used.
   * @param pValidationExecutor Validation executor for request / response validation.
   */
  public AnotherDeprecatedRESTServiceReactiveResource(
      AnotherDeprecatedRESTServiceReactive pAnotherDeprecatedRESTService,
      ValidationExecutorReactive pValidationExecutor ) {
    anotherDeprecatedRESTService = pAnotherDeprecatedRESTService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link com.anaptecs.jeaf.junit.validationgroups.AnotherDeprecatedRESTService#operationOfADeprecatedService()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(
      path = "multi-versioning/deprecated-service",
      produces = { "application/json" },
      method = { RequestMethod.POST })
  @Deprecated
  @MyNotNullRESTParam
  public Mono<Void> operationOfADeprecatedService( ServerWebExchange pServerWebExchange ) {
    return Mono.defer(( ) ->
    // Delegate request to service.
    anotherDeprecatedRESTService.operationOfADeprecatedService());
  }
}