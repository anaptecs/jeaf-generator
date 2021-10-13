/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service ValidationTestService.
 */
public class ValidationTestServiceTest extends ValidationTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   * 
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("ValidationTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new ValidationTestServiceTest("testValidateInputOnly"));
    lSuite.addTest(new ValidationTestServiceTest("testValidateOutputOnly"));
    lSuite.addTest(new ValidationTestServiceTest("testValidateInNOutput"));
    lSuite.addTest(new ValidationTestServiceTest("testNotValidOutput"));
    lSuite.addTest(new ValidationTestServiceTest("testCreateValidationTestObject"));
    lSuite.addTest(new ValidationTestServiceTest("testNoMethodValidation"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public ValidationTestServiceTest( String pName ) {
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
  public ValidationTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method validateInputOnly
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testValidateInputOnly( ) throws Exception {
    // TODO Implement test for service method validateInputOnly(...)
  }

  /**
   * Method test the implementation of service method validateOutputOnly
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testValidateOutputOnly( ) throws Exception {
    // TODO Implement test for service method validateOutputOnly(...)
  }

  /**
   * Method test the implementation of service method validateInNOutput
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testValidateInNOutput( ) throws Exception {
    // TODO Implement test for service method validateInNOutput(...)
  }

  /**
   * Method test the implementation of service method notValidOutput
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testNotValidOutput( ) throws Exception {
    // TODO Implement test for service method notValidOutput(...)
  }

  /**
   * Method test the implementation of service method createValidationTestObject
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateValidationTestObject( ) throws Exception {
    // TODO Implement test for service method createValidationTestObject(...)
  }

  /**
   * Method test the implementation of service method noMethodValidation
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testNoMethodValidation( ) throws Exception {
    // TODO Implement test for service method noMethodValidation(...)
  }
}