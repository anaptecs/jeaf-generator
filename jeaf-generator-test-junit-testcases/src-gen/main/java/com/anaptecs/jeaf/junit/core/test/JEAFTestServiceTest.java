/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service JEAFTestService.
 */
public class JEAFTestServiceTest extends JEAFTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("JEAFTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new JEAFTestServiceTest("testCheckRequiredService_2"));
    lSuite.addTest(new JEAFTestServiceTest("testCheckRequiredService_1"));
    lSuite.addTest(new JEAFTestServiceTest("testTestContextHandling"));
    lSuite.addTest(new JEAFTestServiceTest("testTestContextIsolation"));
    lSuite.addTest(new JEAFTestServiceTest("testTestSessionContextHandling"));
    lSuite.addTest(new JEAFTestServiceTest("testTestIllgealContextAccess"));
    lSuite.addTest(new JEAFTestServiceTest("testTestContextAccess"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public JEAFTestServiceTest( String pName ) {
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
  public JEAFTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method checkRequiredService_2
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCheckRequiredService_2( ) throws Exception {
    // TODO Implement test for service method checkRequiredService_2(...)
  }

  /**
   * Method test the implementation of service method checkRequiredService_1
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCheckRequiredService_1( ) throws Exception {
    // TODO Implement test for service method checkRequiredService_1(...)
  }

  /**
   * Method test the implementation of service method testContextHandling
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestContextHandling( ) throws Exception {
    // TODO Implement test for service method testContextHandling(...)
  }

  /**
   * Method test the implementation of service method testContextIsolation
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestContextIsolation( ) throws Exception {
    // TODO Implement test for service method testContextIsolation(...)
  }

  /**
   * Method test the implementation of service method testSessionContextHandling
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestSessionContextHandling( ) throws Exception {
    // TODO Implement test for service method testSessionContextHandling(...)
  }

  /**
   * Method test the implementation of service method testIllgealContextAccess
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestIllgealContextAccess( ) throws Exception {
    // TODO Implement test for service method testIllgealContextAccess(...)
  }

  /**
   * Method test the implementation of service method testContextAccess
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestContextAccess( ) throws Exception {
    // TODO Implement test for service method testContextAccess(...)
  }
}