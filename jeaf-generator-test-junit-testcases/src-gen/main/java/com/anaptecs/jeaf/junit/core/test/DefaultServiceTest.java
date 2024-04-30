/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service DefaultService.
 */
public class DefaultServiceTest extends DefaultServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("DefaultServiceTest");
    // Add all test of this class.
    lSuite.addTest(new DefaultServiceTest("testGetFloatWithDefault"));
    lSuite.addTest(new DefaultServiceTest("testDoNothing"));
    lSuite.addTest(new DefaultServiceTest("testCustomImplNoDefault"));
    lSuite.addTest(new DefaultServiceTest("testThrowNYI"));
    lSuite.addTest(new DefaultServiceTest("testCustomImpl"));
    lSuite.addTest(new DefaultServiceTest("testGetColor"));
    lSuite.addTest(new DefaultServiceTest("testCustomTemplate"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public DefaultServiceTest( String pName ) {
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
  public DefaultServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method getFloatWithDefault
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetFloatWithDefault( ) throws Exception {
    // TODO Implement test for service method getFloatWithDefault(...)
  }

  /**
   * Method test the implementation of service method doNothing
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDoNothing( ) throws Exception {
    // TODO Implement test for service method doNothing(...)
  }

  /**
   * Method test the implementation of service method customImplNoDefault
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCustomImplNoDefault( ) throws Exception {
    // TODO Implement test for service method customImplNoDefault(...)
  }

  /**
   * Method test the implementation of service method throwNYI
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testThrowNYI( ) throws Exception {
    // TODO Implement test for service method throwNYI(...)
  }

  /**
   * Method test the implementation of service method customImpl
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCustomImpl( ) throws Exception {
    // TODO Implement test for service method customImpl(...)
  }

  /**
   * Method test the implementation of service method getColor
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetColor( ) throws Exception {
    // TODO Implement test for service method getColor(...)
  }

  /**
   * Method test the implementation of service method customTemplate
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCustomTemplate( ) throws Exception {
    // TODO Implement test for service method customTemplate(...)
  }
}