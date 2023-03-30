/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Customer;
import com.anaptecs.jeaf.core.api.Activity;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

/**
 * Interface of activity CreateCustomerActivity.
 *
 * Activity is responsible to create a new customer. Besides storing the data this also includes additional tasks like
 * address validation.
 */
public interface CreateCustomerActivity extends Activity {
  /**
   * Activity is responsible to create a new customer. Besides storing the data this also includes additional tasks like
   * address validation.
   *
   * @param pNewCustomer
   * @param pAttendingEmployee
   * @return Customer
   */
  Customer execute( Customer pNewCustomer, ServiceObjectID pAttendingEmployee );
}