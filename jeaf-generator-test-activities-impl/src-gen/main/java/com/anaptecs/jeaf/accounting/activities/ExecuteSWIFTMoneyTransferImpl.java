/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;

/**
 * Implementation of activity ExecuteSWIFTMoneyTransfer.
 *
 */
@JEAFActivityImpl(activityInterface = ExecuteSWIFTMoneyTransfer.class)
public class ExecuteSWIFTMoneyTransferImpl implements ExecuteSWIFTMoneyTransfer {
  /**
   * Create new instance of activity.
   */
  ExecuteSWIFTMoneyTransferImpl( ) {
  }

  /**
   *
   *
   * @param pBooking
   * @return String
   */
  @Override
  public String execute( Booking pBooking ) {
    // TODO: Implement business logic for activity.
    return null;
  }
}