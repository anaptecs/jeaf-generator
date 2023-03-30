/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.test;

import com.anaptecs.jeaf.accounting.AccountingService;
import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;

/**
 * This is the base class of the test suite of service AccountingService.
 *
 * @version $LastChangedRevision: 931 $
 */
public abstract class AccountingServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected AccountingService accountingService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public AccountingServiceTestBase( String pName ) {
    super(pName);
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided. The userId and the
   * password of a specific user can be given to this Constructor so this specific user can be logged in.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   * @param pUserId UserId of the User who should be logged in for this Test.
   * @param pPassword Password of the User who should be logged in for this Test.
   */
  public AccountingServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method performBooking(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testPerformBooking( ) throws Exception;

  /**
   * Method test the implementation of service method unlock(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testUnlock( ) throws Exception;

  /**
   * Method test the implementation of service method createCustomer(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreateCustomer( ) throws Exception;

  /**
   * Method test the implementation of service method lockAccount(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testLockAccount( ) throws Exception;

  /**
   * Method test the implementation of service method getAccount(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetAccount( ) throws Exception;

  /**
   * Method test the implementation of service method searchCustomers(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testSearchCustomers( ) throws Exception;

  /**
   * Method test the implementation of service method createPerson(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreatePerson( ) throws Exception;

  /**
   * Method test the implementation of service method createAccount(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreateAccount( ) throws Exception;

  /**
   * Method test the implementation of service method getCustomer(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetCustomer( ) throws Exception;
}