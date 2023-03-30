/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.GeneratorTestService;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of GeneratorTestService.
 */
abstract class GeneratorTestServiceImplBase implements GeneratorTestService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String CONVERTTOSIMPLEDATATYPES_AUTH_TYPE =
      "convertToSimpleDatatypes.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String CONVERTTOWRAPPERDATATYPES_AUTH_TYPE =
      "convertToWrapperDatatypes.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String DOWHATIMEAN_AUTH_TYPE = "doWhatIMean.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String DOWITHOBJECTSFROMOTHERPACKAGES_AUTH_TYPE =
      "doWithObjectsFromOtherPAckages.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String PROCESSSIMPLEDATATYPES_AUTH_TYPE =
      "processSimpleDatatypes.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTGENERICSASPARAMETER_AUTH_TYPE =
      "testGenericsAsParameter.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTGENERICSASRESULT_AUTH_TYPE =
      "testGenericsAsResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVEBOOLEANRESULT_AUTH_TYPE =
      "testPrimitiveBooleanResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVECHARRESULT_AUTH_TYPE =
      "testPrimitiveCharResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVEFLOATRESULT_AUTH_TYPE =
      "testPrimitiveFloatResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVELONGRESULT_AUTH_TYPE =
      "testPrimitiveLongResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVESASPARAMETER_AUTH_TYPE =
      "testPrimitivesAsParameter.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITIVESHORTRESULT_AUTH_TYPE =
      "testPrimitiveShortResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITVEBYTERESULT_AUTH_TYPE =
      "testPrimitveByteResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMITVEDOUBLERESULT_AUTH_TYPE =
      "testPrimitveDoubleResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  public static final String TESTPRIMIVEINTRESULT_AUTH_TYPE =
      "testPrimiveIntResult.com.anaptecs.jeaf.junit.core.GeneratorTestService";

  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to configuration of the component.
   */
  private final GeneratorTestComponentConfiguration configuration;

  /**
   * Reference to to trace object of the component to which this service instance belongs to. The reference is never
   * null since the trace object is set in the constructor. The reference is visible to sub classes in order to make
   * tracing as easy as possible.
   */
  final Trace trace;

  /**
   * Initialize object.
   */
  GeneratorTestServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
    configuration = new GeneratorTestComponentConfiguration(component.getComponentID());
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
    return GeneratorTestService.class;
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

  /**
   * Method returns the value of the property "testProperty".
   *
   * @return {@link Integer} Value of the property "testProperty". The method returns null if no value for the property
   * is defined.
   */
  public Integer getTestProperty( ) {
    return configuration.getTestProperty();
  }

  /**
   * Method returns the value of the property "deprecatedAttribute".
   *
   * @return {@link Double} Value of the property "deprecatedAttribute". The method returns null if no value for the
   * property is defined.
   */
  @Deprecated
  public Double getDeprecatedAttribute( ) {
    return configuration.getDeprecatedAttribute();
  }
}