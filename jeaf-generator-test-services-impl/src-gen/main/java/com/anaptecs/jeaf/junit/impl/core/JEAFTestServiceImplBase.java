/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.JEAFTestService;
import com.anaptecs.jeaf.junit.core.RequiredService_1;
import com.anaptecs.jeaf.junit.core.RequiredService_2;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of JEAFTestService.
 */
abstract class JEAFTestServiceImplBase implements JEAFTestService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String CHECKREQUIREDSERVICE_1_AUTH_TYPE =
      "checkRequiredService_1.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String CHECKREQUIREDSERVICE_2_AUTH_TYPE =
      "checkRequiredService_2.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String TESTCONTEXTACCESS_AUTH_TYPE =
      "testContextAccess.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String TESTCONTEXTHANDLING_AUTH_TYPE =
      "testContextHandling.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String TESTCONTEXTISOLATION_AUTH_TYPE =
      "testContextIsolation.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String TESTILLGEALCONTEXTACCESS_AUTH_TYPE =
      "testIllgealContextAccess.com.anaptecs.jeaf.junit.core.JEAFTestService";

  public static final String TESTSESSIONCONTEXTHANDLING_AUTH_TYPE =
      "testSessionContextHandling.com.anaptecs.jeaf.junit.core.JEAFTestService";

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
   * Initialize object.
   */
  JEAFTestServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
  }

  /**
   * The used service RequiredService_1.
   */
  @JEAFService
  private RequiredService_1 requiredService_1;

  /**
   * Method returns the RequiredService_1 from which this service depends.
   *
   * @return RequiredService_1 Reference to the RequiredService_1. The method never returns null after the service has
   * been initialized.
   *
   */
  protected final RequiredService_1 getRequiredService_1( ) {
    return this.requiredService_1;
  }

  /**
   * The used service RequiredService_2.
   */
  @JEAFService
  private RequiredService_2 requiredService_2;

  /**
   * Method returns the RequiredService_2 from which this service depends.
   *
   * @return RequiredService_2 Reference to the RequiredService_2. The method never returns null after the service has
   * been initialized.
   *
   */
  protected final RequiredService_2 getRequiredService_2( ) {
    return this.requiredService_2;
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
    return JEAFTestService.class;
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