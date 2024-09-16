/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.swift;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.core.api.Service;
// @Something

public interface SwiftAccountingService extends Service {
  /**
   * Method performs a booking of the passed amount. Therefore besides the booking also the source and target account
   * have to be passed.<br/>
   * <br/>
   * @param pBooking Booking that should be performed. The parameter must not be null and both, the source and target
   * account have to be set.
   *
   * @param pBooking
   */
  void performBooking( Booking pBooking );
}