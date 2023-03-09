/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.junit.core.SessionContextValues;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of JEAFTestService.
 */
final class JEAFTestServiceImpl extends JEAFTestServiceImplBase {
  /**
   * Initialize object.
   */
  JEAFTestServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   */
  @Override
  public void checkRequiredService_1( ) {
  }

  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   */
  @Deprecated
  @Override
  public void checkRequiredService_2( ) {
  }

  /**
   * Method tests JEAFs context handling and the passing of context information to listeners.
   */
  @Override
  public void testContextHandling( ) {
  }

  /**
   * Method checks the access to the service invocation context from within a service implementation.
   */
  @Override
  public void testContextAccess( ) {
  }

  /**
   * Method checks invalid accesses to a service invocation context.
   */
  @Override
  public void testIllgealContextAccess( ) {
  }

  /**
   */
  @Override
  public void testContextIsolation( ) {
  }

  /**
   * @return {@link SessionContextValues}
   */
  @Override
  public SessionContextValues testSessionContextHandling( ) {
    // TODO Implement method and return real result
    return null;
  }
}