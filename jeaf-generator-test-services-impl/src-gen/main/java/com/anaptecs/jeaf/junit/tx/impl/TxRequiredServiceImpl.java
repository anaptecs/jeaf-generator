/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.tx.impl;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.health.CheckLevel;
import com.anaptecs.jeaf.core.api.health.HealthCheckResult;

/**
 * Implementation of TxRequiredService.
 */
final class TxRequiredServiceImpl extends TxRequiredServiceImplBase {
  /**
   * Initialize object.
   */
  TxRequiredServiceImpl( Component pComponent ) {
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
  * 
  */
  @Override
  public void testTransactionBehavior( ) {
  }
}