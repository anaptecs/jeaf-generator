/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.swift.impl;

import com.anaptecs.jeaf.accounting.impl.swift.SwiftAccountingService;
import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of SwiftAccountingService.
 */
abstract class SwiftAccountingServiceImplBase implements SwiftAccountingService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String PERFORMBOOKING_AUTH_TYPE =
      "performBooking.com.anaptecs.jeaf.accounting.impl.swift.SwiftAccountingService";

  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to to trace object of the component to which this service instance belongs to. The reference is never
   * null since the trace object is set in the constructor. The reference is visible to sub classes in order to make
   * tracing as easy as possible.
   */
  final Trace trace;

  /**
   * Reference to persistence service provider. The class contains this dependency due to the fact that its components
   * defines a dependency to a persistence unit.
   */
  @JEAFServiceProvider
  private PersistenceServiceProvider persistenceServiceProvider;

  /**
   * Initialize object.
   */
  SwiftAccountingServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
  }

  /**
   * Method returns reference to the persistence service provider that can be used to access the database.
   *
   * @return {@link PersistenceServiceProvider} Reference to persistence service provider. The method never returns
   * null.
   */
  protected final PersistenceServiceProvider getPersistenceServiceProvider( ) {
    return persistenceServiceProvider;
  }

  /**
   * Method returns the class object of the service that is implemented by this service instance.
   *
   * @return Class Class object of the service interface that is implemented by the service instance. The method never
   * returns null.
   *
   * @see ServiceImplementation#getServiceType()
   */
  public final Class<? extends Service> getServiceType( ) {
    return SwiftAccountingService.class;
  }

  /**
   * Method returns the service invocation context for the current service call.
   *
   * @return ServiceInvocationContext Service invocation context for the current call. The method never returns null as
   * long as it is called from within a service call.
   */
  protected final ServiceInvocationContext getCurrentServiceInvocationContext( ) {
    return JEAF.getContext().getServiceInvocationContext();
  }
}