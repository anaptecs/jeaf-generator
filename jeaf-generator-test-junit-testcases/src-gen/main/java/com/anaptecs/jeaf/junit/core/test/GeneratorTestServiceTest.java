/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service GeneratorTestService.
 */
public class GeneratorTestServiceTest extends GeneratorTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("GeneratorTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitivesAsParameter"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitiveLongResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testDoWithObjectsFromOtherPAckages"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitiveBooleanResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitiveCharResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testConvertToSimpleDatatypes"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimiveIntResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitiveShortResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestGenericsAsParameter"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitveDoubleResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testProcessSimpleDatatypes"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestGenericsAsResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitveByteResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testConvertToWrapperDatatypes"));
    lSuite.addTest(new GeneratorTestServiceTest("testTestPrimitiveFloatResult"));
    lSuite.addTest(new GeneratorTestServiceTest("testDoWhatIMean"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public GeneratorTestServiceTest( String pName ) {
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
  public GeneratorTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method testPrimitivesAsParameter
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitivesAsParameter( ) throws Exception {
    // TODO Implement test for service method testPrimitivesAsParameter(...)
  }

  /**
   * Method test the implementation of service method testPrimitiveLongResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveLongResult( ) throws Exception {
    // TODO Implement test for service method testPrimitiveLongResult(...)
  }

  /**
   * Method test the implementation of service method doWithObjectsFromOtherPAckages
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDoWithObjectsFromOtherPAckages( ) throws Exception {
    // TODO Implement test for service method doWithObjectsFromOtherPAckages(...)
  }

  /**
   * Method test the implementation of service method testPrimitiveBooleanResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveBooleanResult( ) throws Exception {
    // TODO Implement test for service method testPrimitiveBooleanResult(...)
  }

  /**
   * Method test the implementation of service method testPrimitiveCharResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveCharResult( ) throws Exception {
    // TODO Implement test for service method testPrimitiveCharResult(...)
  }

  /**
   * Method test the implementation of service method convertToSimpleDatatypes
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testConvertToSimpleDatatypes( ) throws Exception {
    // TODO Implement test for service method convertToSimpleDatatypes(...)
  }

  /**
   * Method test the implementation of service method testPrimiveIntResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimiveIntResult( ) throws Exception {
    // TODO Implement test for service method testPrimiveIntResult(...)
  }

  /**
   * Method test the implementation of service method testPrimitiveShortResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveShortResult( ) throws Exception {
    // TODO Implement test for service method testPrimitiveShortResult(...)
  }

  /**
   * Method test the implementation of service method testGenericsAsParameter
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestGenericsAsParameter( ) throws Exception {
    // TODO Implement test for service method testGenericsAsParameter(...)
  }

  /**
   * Method test the implementation of service method testPrimitveDoubleResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitveDoubleResult( ) throws Exception {
    // TODO Implement test for service method testPrimitveDoubleResult(...)
  }

  /**
   * Method test the implementation of service method processSimpleDatatypes
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testProcessSimpleDatatypes( ) throws Exception {
    // TODO Implement test for service method processSimpleDatatypes(...)
  }

  /**
   * Method test the implementation of service method testGenericsAsResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestGenericsAsResult( ) throws Exception {
    // TODO Implement test for service method testGenericsAsResult(...)
  }

  /**
   * Method test the implementation of service method testPrimitveByteResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitveByteResult( ) throws Exception {
    // TODO Implement test for service method testPrimitveByteResult(...)
  }

  /**
   * Method test the implementation of service method convertToWrapperDatatypes
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testConvertToWrapperDatatypes( ) throws Exception {
    // TODO Implement test for service method convertToWrapperDatatypes(...)
  }

  /**
   * Method test the implementation of service method testPrimitiveFloatResult
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveFloatResult( ) throws Exception {
    // TODO Implement test for service method testPrimitiveFloatResult(...)
  }

  /**
   * Method test the implementation of service method doWhatIMean
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDoWhatIMean( ) throws Exception {
    // TODO Implement test for service method doWhatIMean(...)
  }
}