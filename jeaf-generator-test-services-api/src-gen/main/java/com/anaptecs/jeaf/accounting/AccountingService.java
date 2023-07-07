/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

/**
 * This interface defines the common services that are provided by the accounting component. This interface is intended
 * to be an example to demonstrate how to use JEAF.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface AccountingService extends Service {
  /**
   * Method creates a new account for the passed customer. The method uses the passed person as authorized person.<br/>
   * <br/>
   * @param pCustomer Customer for which the account will be created. The parameter must not be null.<br/>
   * @param pAuthorizedPerson Person who will be authorized for the passed account. The parameter must not be null.<br/>
   * @return {@link Account} Created account object. The method never returns null.<br/>
   *
   * @param pCustomer
   * @param pAuthorizedPerson
   * @return {@link Account}
   */
  Account createAccount( Customer pCustomer, Person pAuthorizedPerson );

  /**
   * Method returns the account with the passed account id.<br/>
   * <br/>
   * @param pAccountID ID of the account that should be returned. The parameter must not be null.<br/>
   * @return {@link Account} Account service object with the passed id. The method never returns null.<br/>
   *
   * @param pAccountID
   * @return {@link Account}
   */
  Account getAccount( ServiceObjectID pAccountID );

  /**
   * Method locks the passed account. If the account is already locked, nothing will happen.<br/>
   * <br/>
   * @param pAccount Account that should be locked. The parameter must not be null.<br/>
   *
   * @param pAccount
   */
  void lockAccount( Account pAccount );

  /**
   * Method unlocks the passed account. If the account is already unlocked, nothing will happen.<br/>
   * <br/>
   * @param pAccount Account that should be unlocked. The parameter must not be null.<br/>
   *
   * @param pAccount
   */
  void unlock( Account pAccount );

  /**
   * Method performs a booking of the passed amount. Therefore besides the booking also the source and target account
   * have to be passed.<br/>
   * <br/>
   * @param pBooking Booking that should be performed. The parameter must not be null and both, the source and target
   * account have to be set.<br/>
   * @param pSecurityToken Current security token of the caller. The parameter must not be null.<br/>
   *
   * @param pBooking
   * @param pSecurityToken
   */
  void performBooking( Booking pBooking, SecurityToken pSecurityToken );

  /**
   * Method creates a new customer object from the data of the passed service object.<br/>
   * <br/>
   * @param pNewCustomer Customer service object describing the data of the customer that should be created. The
   * parameter must not be null.<br/>
   * @param pAttendingEmployeeID ID of the employee that will be the attendant for the created customer. The parameter
   * must not be null.<br/>
   * @return {@link Customer} Customer object describing the created customer. The method never returns null and the
   * returned object is not same instance as the passed one.<br/>
   *
   * @param pNewCustomer
   * @param pAttendingEmployeeID
   * @return {@link Customer}
   */
  Customer createCustomer( Customer pNewCustomer, ServiceObjectID pAttendingEmployeeID );

  /**
   * Method returns the customer with the passed service object id.<br/>
   * <br/>
   * @param pCustomerID ID of the customer that should be returned. The parameter must not be null.<br/>
   * @return {@link Customer} Customer object with the passed id or null if the object does not exist.
   *
   * @param pCustomerID
   * @param pLoadStrategy
   * @return {@link Customer}
   */
  Customer getCustomer( ServiceObjectID pCustomerID, CustomerLoadStrategy pLoadStrategy );

  /**
   * Method creates a new Person object with the data of the passed service object.<br/>
   * <br/>
   * @param pPerson Person service object whose data should be used to create a new persistent Person object. The
   * parameter must not be null.<br/>
   * @return {@link Person} Person service object describing the created person. The object is not the same instance as
   * the passed one. The method never returns null.<br/>
   *
   * @param pPerson
   * @return {@link Person}
   */
  @NotNull
  Person createPerson( @Valid Person pPerson );

  /**
   * @param pQuery
   * @return {@link Set<Customer>}
   */
  Set<Customer> searchCustomers( CustomerQuery pQuery );
}
