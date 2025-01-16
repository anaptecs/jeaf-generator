/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service InterceptorTestService.
 */
public class InterceptorTestServiceTest extends InterceptorTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("InterceptorTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new InterceptorTestServiceTest("testCallServiceSYE"));
    lSuite.addTest(new InterceptorTestServiceTest("testCallServiceAPE"));
    lSuite.addTest(new InterceptorTestServiceTest("testCallServiceERR"));
    lSuite.addTest(new InterceptorTestServiceTest("testCallServiceRTE"));
    lSuite.addTest(new InterceptorTestServiceTest("testCallService"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public InterceptorTestServiceTest( String pName ) {
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
  public InterceptorTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method callServiceSYE
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCallServiceSYE( ) throws Exception {
    // TODO Implement test for service method callServiceSYE(...)
  }

  /**
   * Method test the implementation of service method callServiceAPE
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCallServiceAPE( ) throws Exception {
    // TODO Implement test for service method callServiceAPE(...)
  }

  /**
   * Method test the implementation of service method callServiceERR
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCallServiceERR( ) throws Exception {
    // TODO Implement test for service method callServiceERR(...)
  }

  /**
   * Method test the implementation of service method callServiceRTE
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCallServiceRTE( ) throws Exception {
    // TODO Implement test for service method callServiceRTE(...)
  }

  /**
   * Method test the implementation of service method callService
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCallService( ) throws Exception {
    // TODO Implement test for service method callService(...)
  }
}