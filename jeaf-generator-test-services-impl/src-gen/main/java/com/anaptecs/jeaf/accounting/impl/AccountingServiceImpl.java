/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl;

import java.util.Set;

import com.anaptecs.jeaf.accounting.Account;
import com.anaptecs.jeaf.accounting.Booking;
import com.anaptecs.jeaf.accounting.Customer;
import com.anaptecs.jeaf.accounting.CustomerLoadStrategy;
import com.anaptecs.jeaf.accounting.CustomerQuery;
import com.anaptecs.jeaf.accounting.Person;
import com.anaptecs.jeaf.accounting.SecurityToken;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.core.api.health.CheckLevel;
import com.anaptecs.jeaf.core.api.health.HealthCheckResult;

/**
 * Implementation of AccountingService.
 */
final class AccountingServiceImpl extends AccountingServiceImplBase {
  /**
   * Initialize object.
   */
  AccountingServiceImpl( Component pComponent ) {
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
   * Method creates a new account for the passed customer. The method uses the passed person as authorized person.
   * 
   * @param pCustomer Customer for which the account will be created. The parameter must not be null.
   * @param pAuthorizedPerson Person who will be authorized for the passed account. The parameter must not be null.
   * @return {@link Account} Created account object. The method never returns null.
   * 
   * 
   * @param pCustomer
   * @param pAuthorizedPerson
   * @return {@link Account}
   */
  @Override
  public Account createAccount( Customer pCustomer, Person pAuthorizedPerson ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Method returns the account with the passed account id.
   * 
   * @param pAccountID ID of the account that should be returned. The parameter must not be null.
   * @return {@link Account} Account service object with the passed id. The method never returns null.
   * 
   * 
   * @param pAccountID
   * @return {@link Account}
   */
  @Override
  public Account getAccount( ServiceObjectID pAccountID ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Method locks the passed account. If the account is already locked, nothing will happen.
   * 
   * @param pAccount Account that should be locked. The parameter must not be null.
   * 
   * 
   * @param pAccount
   */
  @Override
  public void lockAccount( Account pAccount ) {
  }

  /**
   * Method unlocks the passed account. If the account is already unlocked, nothing will happen.
   * 
   * @param pAccount Account that should be unlocked. The parameter must not be null.
   * 
   * 
   * @param pAccount
   */
  @Override
  public void unlock( Account pAccount ) {
  }

  /**
   * Method performs a booking of the passed amount. Therefore besides the booking also the source and target account
   * have to be passed.
   * 
   * @param pBooking Booking that should be performed. The parameter must not be null and both, the source and target
   * account have to be set.
   * @param pSecurityToken Current security token of the caller. The parameter must not be null.
   * 
   * 
   * @param pBooking
   * @param pSecurityToken
   */
  @Override
  public void performBooking( Booking pBooking, SecurityToken pSecurityToken ) {
  }

  /**
   * Method creates a new customer object from the data of the passed service object.
   * 
   * @param pNewCustomer Customer service object describing the data of the customer that should be created. The
   * parameter must not be null.
   * @param pAttendingEmployeeID ID of the employee that will be the attendant for the created customer. The parameter
   * must not be null.
   * @return {@link Customer} Customer object describing the created customer. The method never returns null and the
   * returned object is not same instance as the passed one.
   * 
   * 
   * @param pNewCustomer
   * @param pAttendingEmployeeID
   * @return {@link Customer}
   */
  @Override
  public Customer createCustomer( Customer pNewCustomer, ServiceObjectID pAttendingEmployeeID ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Method returns the customer with the passed service object id.
   * 
   * @param pCustomerID ID of the customer that should be returned. The parameter must not be null.
   * @return {@link Customer} Customer object with the passed id or null if the object does not exist.
   * 
   * 
   * @param pCustomerID
   * @param pLoadStrategy
   * @return {@link Customer}
   */
  @Override
  public Customer getCustomer( ServiceObjectID pCustomerID, CustomerLoadStrategy pLoadStrategy ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Method creates a new Person object with the data of the passed service object.
   * 
   * @param pPerson Person service object whose data should be used to create a new persistent Person object. The
   * parameter must not be null.
   * @return {@link Person} Person service object describing the created person. The object is not the same instance as
   * the passed one. The method never returns null.
   * 
   * 
   * @param pPerson
   * @return {@link Person}
   */
  @Override
  public Person createPerson( Person pPerson ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pQuery
   * @return {@link Customer}
   */
  @Override
  public Set<Customer> searchCustomers( CustomerQuery pQuery ) {
    // TODO Implement method and return real result
    return null;
  }
}
