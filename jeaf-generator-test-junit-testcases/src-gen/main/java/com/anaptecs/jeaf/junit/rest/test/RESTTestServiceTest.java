/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service RESTTestService.
 */
public class RESTTestServiceTest extends RESTTestServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   * 
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("RESTTestServiceTest");
    // Add all test of this class.
    lSuite.addTest(new RESTTestServiceTest("testDeprecatedOperation"));
    lSuite.addTest(new RESTTestServiceTest("testGetTestServiceObject"));
    lSuite.addTest(new RESTTestServiceTest("testGetResource"));
    lSuite.addTest(new RESTTestServiceTest("testDeprecatedAsyncParam"));
    lSuite.addTest(new RESTTestServiceTest("testUpdateTestServiceObject"));
    lSuite.addTest(new RESTTestServiceTest("testHandleBeanParam1"));
    lSuite.addTest(new RESTTestServiceTest("testDeprecatedAsync"));
    lSuite.addTest(new RESTTestServiceTest("testDoSomeNotRESTThing"));
    lSuite.addTest(new RESTTestServiceTest("testDeprectaedReturnValue"));
    lSuite.addTest(new RESTTestServiceTest("testDoSomethingRESTy"));
    lSuite.addTest(new RESTTestServiceTest("testYetAnotherRESTOperation"));
    lSuite.addTest(new RESTTestServiceTest("testDeprecatedParameter"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public RESTTestServiceTest( String pName ) {
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
  public RESTTestServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method deprecatedOperation
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedOperation( ) throws Exception {
    // TODO Implement test for service method deprecatedOperation(...)
  }

  /**
   * Method test the implementation of service method getTestServiceObject
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetTestServiceObject( ) throws Exception {
    // TODO Implement test for service method getTestServiceObject(...)
  }

  /**
   * Method test the implementation of service method getResource
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetResource( ) throws Exception {
    // TODO Implement test for service method getResource(...)
  }

  /**
   * Method test the implementation of service method deprecatedAsyncParam
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedAsyncParam( ) throws Exception {
    // TODO Implement test for service method deprecatedAsyncParam(...)
  }

  /**
   * Method test the implementation of service method updateTestServiceObject
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testUpdateTestServiceObject( ) throws Exception {
    // TODO Implement test for service method updateTestServiceObject(...)
  }

  /**
   * Method test the implementation of service method handleBeanParam1
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testHandleBeanParam1( ) throws Exception {
    // TODO Implement test for service method handleBeanParam1(...)
  }

  /**
   * Method test the implementation of service method deprecatedAsync
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedAsync( ) throws Exception {
    // TODO Implement test for service method deprecatedAsync(...)
  }

  /**
   * Method test the implementation of service method doSomeNotRESTThing
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDoSomeNotRESTThing( ) throws Exception {
    // TODO Implement test for service method doSomeNotRESTThing(...)
  }

  /**
   * Method test the implementation of service method deprectaedReturnValue
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprectaedReturnValue( ) throws Exception {
    // TODO Implement test for service method deprectaedReturnValue(...)
  }

  /**
   * Method test the implementation of service method doSomethingRESTy
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDoSomethingRESTy( ) throws Exception {
    // TODO Implement test for service method doSomethingRESTy(...)
  }

  /**
   * Method test the implementation of service method yetAnotherRESTOperation
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testYetAnotherRESTOperation( ) throws Exception {
    // TODO Implement test for service method yetAnotherRESTOperation(...)
  }

  /**
   * Method test the implementation of service method deprecatedParameter
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedParameter( ) throws Exception {
    // TODO Implement test for service method deprecatedParameter(...)
  }
}