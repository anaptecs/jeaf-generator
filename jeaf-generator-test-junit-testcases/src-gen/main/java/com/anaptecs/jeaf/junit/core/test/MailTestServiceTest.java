/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service MailTestService.
 */
public class MailTestServiceTest extends MailTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   * 
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("MailTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new MailTestServiceTest("testTestExtendedSendMail"));
    lSuite.addTest(new MailTestServiceTest("testTestSendMail"));
    lSuite.addTest(new MailTestServiceTest("testTestCreateFilledMessage"));
    lSuite.addTest(new MailTestServiceTest("testTestCreateEmptyMessage"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public MailTestServiceTest( String pName ) {
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
  public MailTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method testExtendedSendMail
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestExtendedSendMail( ) throws Exception {
    // TODO Implement test for service method testExtendedSendMail(...)
  }

  /**
   * Method test the implementation of service method testSendMail
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestSendMail( ) throws Exception {
    // TODO Implement test for service method testSendMail(...)
  }

  /**
   * Method test the implementation of service method testCreateFilledMessage
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestCreateFilledMessage( ) throws Exception {
    // TODO Implement test for service method testCreateFilledMessage(...)
  }

  /**
   * Method test the implementation of service method testCreateEmptyMessage
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestCreateEmptyMessage( ) throws Exception {
    // TODO Implement test for service method testCreateEmptyMessage(...)
  }
}