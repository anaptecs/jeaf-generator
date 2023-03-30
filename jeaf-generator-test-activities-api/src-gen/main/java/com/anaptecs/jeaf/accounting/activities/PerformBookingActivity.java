/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.accounting.SecurityToken;
import com.anaptecs.jeaf.core.api.Activity;

/**
 * Interface of activity PerformBookingActivity.
 *
 * Activity is responsible to perform a booking from one account to another.
 */
public interface PerformBookingActivity extends Activity {
  /**
   * Activity is responsible to perform a booking from one account to another.
   *
   * @param pBooking
   * @param pSecurityToken
   * @return void
   */
  void execute( Booking pBooking, SecurityToken pSecurityToken );
}