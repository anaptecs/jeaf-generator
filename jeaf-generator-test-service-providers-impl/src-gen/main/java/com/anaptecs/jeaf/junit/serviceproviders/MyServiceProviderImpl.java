/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.serviceproviders;

import com.anaptecs.jeaf.xfun.api.errorhandling.SystemException;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * This class is the base class of the service provider implementation MyServiceProviderImpl.
 *
 * 
 */
final class MyServiceProviderImpl extends MyServiceProviderImplBase {
  /**
   * Constructor has reduced visibility in order to ensure that all service provider implementations are created through
   * the factory.
   */
  MyServiceProviderImpl( ) {
    // Nothing to do.
  }

  /**
   * This method will be called at startup by JEAF and enables the service provider to perform its specific
   * initialization routines.
   * 
   * @throws SystemException Service provider specific exception in order to show that the initialization was not
   * successful.
   */
  @Override
  public void initialize( ) throws SystemException {
  }

  /**
   * Method checks the current state of the service provider. Therefore JEAF defines three different check levels:
   * internal Checks, infrastructure checks and external checks. For further details about the check levels
   * {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service provider
    return null;
  }

  /**
   * @return boolean
   */
  @Override
  public boolean doSomething( ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   */
  @Deprecated
  @Override
  public void doSomethingDeprecated( ) {
  }

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String doSomething( int pParam1, @Deprecated int pParam2 ) {
    // TODO Implement method and return real result
    return null;
  }
}