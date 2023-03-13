/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.jeaf.RESTRequestExecutorServiceProvider;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.service.PathlessService;

/**
 * Class implements a service provider that acts as proxy for REST service {@link PathlessService}.
 */
public final class PathlessServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, PathlessServiceRESTProxyServiceProvider {
  /**
   * Reference to the object that identifies this component. The reference is never null.
   */
  private static final ComponentID COMPONENT_ID;
  /**
   * Static initializer is used to create the components ComponentID object and its trace object.
   */
  static {
    // Create Component ID and trace object.
    Package lBasePackage = PathlessServiceRESTProxyServiceProviderImpl.class.getPackage();
    COMPONENT_ID = new ComponentID("PathlessServiceRESTProxyServiceProviderImpl", lBasePackage.getName());
  }

  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  @JEAFServiceProvider
  private RESTRequestExecutorServiceProvider requestExecutor;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Nothing to do.
  }

  /**
   * Method checks state of this service provider implementation.
   * 
   * @return {@link HealthCheckResult} Result of the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    return null;
  }

  /**
   * @return {@link String}
   */
  @Override
  public String getSomething( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(PathlessService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("doSomething");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }
}
