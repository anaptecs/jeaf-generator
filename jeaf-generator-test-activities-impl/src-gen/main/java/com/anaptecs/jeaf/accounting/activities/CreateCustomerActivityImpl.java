/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Customer;
import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

/**
 * Implementation of activity CreateCustomerActivity. Activity is responsible to create a new customer. Besides storing
 * the data this also includes additional tasks like address validation.
 */
@JEAFActivityImpl(activityInterface = CreateCustomerActivity.class)
public class CreateCustomerActivityImpl implements CreateCustomerActivity {
  /**
   * Create new instance of activity.
   */
  CreateCustomerActivityImpl( ) {
  }

  /**
   * Activity is responsible to create a new customer. Besides storing the data this also includes additional tasks like
   * address validation.
   *
   * @param pNewCustomer
   * @param pAttendingEmployee
   * @return Customer
   */
  @Override
  public Customer execute( Customer pNewCustomer, ServiceObjectID pAttendingEmployee ) {
    // TODO: Implement business logic for activity.
    return null;
  }
}