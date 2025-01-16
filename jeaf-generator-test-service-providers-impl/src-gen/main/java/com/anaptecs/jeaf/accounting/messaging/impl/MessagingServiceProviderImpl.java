/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.messaging.impl;

import com.anaptecs.jeaf.xfun.api.errorhandling.SystemException;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

final class MessagingServiceProviderImpl extends MessagingServiceProviderImplBase {
  /**
   * Constructor has reduced visibility in order to ensure that all service provider implementations are created through
   * the factory.
   */
  MessagingServiceProviderImpl( ) {
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
   * @param pMessage
   * @return boolean
   */
  @Override
  public boolean sendMessage( String pMessage ) {
    // TODO Implement method and return real result
    return false;
  }
}