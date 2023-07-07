/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.accounting.SecurityToken;
import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;

/**
 * Implementation of activity PerformBookingActivity. Activity is responsible to perform a booking from one account to
 * another.
 */
@JEAFActivityImpl(activityInterface = PerformBookingActivity.class)
public class PerformBookingActivityImpl implements PerformBookingActivity {
  /**
   * Create new instance of activity.
   */
  PerformBookingActivityImpl( ) {
  }

  /**
   * Activity is responsible to perform a booking from one account to another.
   *
   * @param pBooking
   * @param pSecurityToken
   * @return void
   */
  @Override
  public void execute( Booking pBooking, SecurityToken pSecurityToken ) {
    // TODO: Implement business logic for activity.
  }
}