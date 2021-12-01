/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.swift.impl;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of SwiftAccountingService.
 */
final class SwiftAccountingServiceImpl extends SwiftAccountingServiceImplBase {
  /**
   * Initialize object.
   */
  SwiftAccountingServiceImpl( Component pComponent ) {
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
   * Method performs a booking of the passed amount. Therefore besides the booking also the source and target account
   * have to be passed.
   * 
   * @param pBooking Booking that should be performed. The parameter must not be null and both, the source and target
   * account have to be set.
   * 
   * 
   * @param pBooking
   */
  @Override
  public void performBooking( Booking pBooking ) {
  }
}