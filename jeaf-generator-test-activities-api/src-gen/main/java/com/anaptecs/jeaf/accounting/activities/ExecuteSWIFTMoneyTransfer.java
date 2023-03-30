/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.core.api.Activity;

/**
 * Interface of activity ExecuteSWIFTMoneyTransfer.
 *
 *
 */
public interface ExecuteSWIFTMoneyTransfer extends Activity {
  /**
   *
   *
   * @param pBooking
   * @return String
   */
  String execute( Booking pBooking );
}