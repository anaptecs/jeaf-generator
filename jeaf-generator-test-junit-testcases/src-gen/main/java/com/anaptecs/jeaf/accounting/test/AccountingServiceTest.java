/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service AccountingService.
 */
public class AccountingServiceTest extends AccountingServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("AccountingServiceTest");
    // Add all test of this class.
    lSuite.addTest(new AccountingServiceTest("testPerformBooking"));
    lSuite.addTest(new AccountingServiceTest("testUnlock"));
    lSuite.addTest(new AccountingServiceTest("testCreateCustomer"));
    lSuite.addTest(new AccountingServiceTest("testLockAccount"));
    lSuite.addTest(new AccountingServiceTest("testGetAccount"));
    lSuite.addTest(new AccountingServiceTest("testSearchCustomers"));
    lSuite.addTest(new AccountingServiceTest("testCreatePerson"));
    lSuite.addTest(new AccountingServiceTest("testCreateAccount"));
    lSuite.addTest(new AccountingServiceTest("testGetCustomer"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public AccountingServiceTest( String pName ) {
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
  public AccountingServiceTest( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method performs test case specific initialization routines. If a test case implementation requires some special
   * operations at startup this method can be overridden.
   *
   * @throws Exception if an error occurs during initialization.
   */
  @Override
  protected void init( ) throws Exception {
    super.init();
    // TODO Add additional initializations if required.
  }

  /**
   * Method test the implementation of service method performBooking
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testPerformBooking( ) throws Exception {
    // TODO Implement test for service method performBooking(...)
  }

  /**
   * Method test the implementation of service method unlock
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testUnlock( ) throws Exception {
    // TODO Implement test for service method unlock(...)
  }

  /**
   * Method test the implementation of service method createCustomer
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateCustomer( ) throws Exception {
    // TODO Implement test for service method createCustomer(...)
  }

  /**
   * Method test the implementation of service method lockAccount
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testLockAccount( ) throws Exception {
    // TODO Implement test for service method lockAccount(...)
  }

  /**
   * Method test the implementation of service method getAccount
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetAccount( ) throws Exception {
    // TODO Implement test for service method getAccount(...)
  }

  /**
   * Method test the implementation of service method searchCustomers
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testSearchCustomers( ) throws Exception {
    // TODO Implement test for service method searchCustomers(...)
  }

  /**
   * Method test the implementation of service method createPerson
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreatePerson( ) throws Exception {
    // TODO Implement test for service method createPerson(...)
  }

  /**
   * Method test the implementation of service method createAccount
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateAccount( ) throws Exception {
    // TODO Implement test for service method createAccount(...)
  }

  /**
   * Method test the implementation of service method getCustomer
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetCustomer( ) throws Exception {
    // TODO Implement test for service method getCustomer(...)
  }
}