/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups.resource;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.anaptecs.annotations.MyNotEmptyRESTParam;
import com.anaptecs.annotations.MyNotNullRESTParam;
import com.anaptecs.jeaf.junit.validationgroups.ClientType;
import com.anaptecs.jeaf.junit.validationgroups.MultiVersioningTestServiceReactive;
import com.anaptecs.jeaf.junit.validationgroups.MyContext;
import com.anaptecs.jeaf.junit.validationgroups.MyPOJOResponse;
import com.anaptecs.jeaf.junit.validationgroups.MyPojoRequest;
import com.anaptecs.jeaf.validation.api.ValidationExecutorReactive;
import reactor.core.publisher.Mono;

@RequestMapping(path = "/nova/prefix/multi-versioning")
@RestController
public class MultiVersioningTestServiceReactiveResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutorReactive validationExecutor;

  /**
   * All request to this class will be delegated to
   * {@link com.anaptecs.jeaf.junit.validationgroups.MultiVersioningTestService}.
   */
  private final MultiVersioningTestServiceReactive multiVersioningTestService;

  /**
   * Initialize object.
   *
   * @param pMultiVersioningTestService Dependency on concrete
   * {@link com.anaptecs.jeaf.junit.validationgroups.MultiVersioningTestService} implementation that should be used.
   * @param pValidationExecutor Validation executor for request / response validation.
   */
  public MultiVersioningTestServiceReactiveResource( MultiVersioningTestServiceReactive pMultiVersioningTestService,
      ValidationExecutorReactive pValidationExecutor ) {
    multiVersioningTestService = pMultiVersioningTestService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link com.anaptecs.jeaf.junit.validationgroups.MultiVersioningTestService#someRequest()}
   */
  @PreAuthorize("hasAnyRole('NO_ACCESS')")
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(
      path = "some-request/{path-param}",
      consumes = { "application/json" },
      produces = { "application/json" },
      method = { RequestMethod.POST })
  @MyNotNullRESTParam
  public Mono<MyPOJOResponse> someRequest(
      @PathVariable(name = "path-param", required = false) @MyNotNullRESTParam String pPath,
      @RequestBody(required = false) @MyNotNullRESTParam Mono<MyPojoRequest> pRequest,
      @RequestHeader(name = "firstProperty", required = false) @MyNotNullRESTParam String pFirstProperty,
      @RequestHeader(name = "clientTypes", required = false) @MyNotEmptyRESTParam Set<ClientType> pClientTypes,
      @RequestHeader(name = "deprecatedHeader", required = false) @Deprecated String pDeprecatedHeader,
      ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lMyContextBuilder = MyContext.builder();
    lMyContextBuilder.setFirstProperty(pFirstProperty);
    lMyContextBuilder.setClientTypes(pClientTypes);
    lMyContextBuilder.setDeprecatedHeader(pDeprecatedHeader);
    MyContext myContext = lMyContextBuilder.build();
    return pRequest.flatMap(pRequestBody ->
    // Validate request parameter(s).
    validationExecutor.validateRequest(MultiVersioningTestServiceReactive.class, pPath, pRequestBody, myContext)
        // Delegate request to service.
        .then(multiVersioningTestService.someRequest(pPath, pRequestBody, myContext)))
        // Validate response.
        .delayUntil(
            response -> validationExecutor.validateResponse(MultiVersioningTestServiceReactive.class, response));
  }
}