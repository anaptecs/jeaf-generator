/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service ProductRESTService.
 */
public class ProductRESTServiceTest extends ProductRESTServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   * 
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("ProductRESTServiceTest");
    // Add all test of this class.
    lSuite.addTest(new ProductRESTServiceTest("testDeprecatedOperation"));
    lSuite.addTest(new ProductRESTServiceTest("testDeprecatedBody"));
    lSuite.addTest(new ProductRESTServiceTest("testGetProduct"));
    lSuite.addTest(new ProductRESTServiceTest("testGetSortiment"));
    lSuite.addTest(new ProductRESTServiceTest("testDeprectedComplexRequestBody"));
    lSuite.addTest(new ProductRESTServiceTest("testDeprecatedBeanParam"));
    lSuite.addTest(new ProductRESTServiceTest("testPing"));
    lSuite.addTest(new ProductRESTServiceTest("testDeprecatedParams"));
    lSuite.addTest(new ProductRESTServiceTest("testCreateProduct"));
    lSuite.addTest(new ProductRESTServiceTest("testCreateChannelCode"));
    lSuite.addTest(new ProductRESTServiceTest("testGetProducts"));
    lSuite.addTest(new ProductRESTServiceTest("testDeprecatedContext"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public ProductRESTServiceTest( String pName ) {
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
  public ProductRESTServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method deprecatedBody
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedBody( ) throws Exception {
    // TODO Implement test for service method deprecatedBody(...)
  }

  /**
   * Method test the implementation of service method getProduct
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetProduct( ) throws Exception {
    // TODO Implement test for service method getProduct(...)
  }

  /**
   * Method test the implementation of service method getSortiment
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetSortiment( ) throws Exception {
    // TODO Implement test for service method getSortiment(...)
  }

  /**
   * Method test the implementation of service method deprectedComplexRequestBody
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprectedComplexRequestBody( ) throws Exception {
    // TODO Implement test for service method deprectedComplexRequestBody(...)
  }

  /**
   * Method test the implementation of service method deprecatedBeanParam
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedBeanParam( ) throws Exception {
    // TODO Implement test for service method deprecatedBeanParam(...)
  }

  /**
   * Method test the implementation of service method ping
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testPing( ) throws Exception {
    // TODO Implement test for service method ping(...)
  }

  /**
   * Method test the implementation of service method deprecatedParams
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedParams( ) throws Exception {
    // TODO Implement test for service method deprecatedParams(...)
  }

  /**
   * Method test the implementation of service method createProduct
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateProduct( ) throws Exception {
    // TODO Implement test for service method createProduct(...)
  }

  /**
   * Method test the implementation of service method createChannelCode
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateChannelCode( ) throws Exception {
    // TODO Implement test for service method createChannelCode(...)
  }

  /**
   * Method test the implementation of service method getProducts
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetProducts( ) throws Exception {
    // TODO Implement test for service method getProducts(...)
  }

  /**
   * Method test the implementation of service method deprecatedContext
   * 
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedContext( ) throws Exception {
    // TODO Implement test for service method deprecatedContext(...)
  }
}