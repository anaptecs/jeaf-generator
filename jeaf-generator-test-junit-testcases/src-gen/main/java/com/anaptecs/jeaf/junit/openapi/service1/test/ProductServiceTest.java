/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.test;

import junit.framework.TestSuite;

/**
 * This class implements the test suite for service ProductService.
 */
public class ProductServiceTest extends ProductServiceTestBase {
  /**
   * Method creates a test suite contain all tests of this class.
   *
   * @return {@link TestSuite} Test suite with all tests of this class.
   */
  public static TestSuite suite( ) {
    // Create new test suite.
    TestSuite lSuite = new TestSuite("ProductServiceTest");
    // Add all test of this class.
    lSuite.addTest(new ProductServiceTest("testDeprecatedBody"));
    lSuite.addTest(new ProductServiceTest("testDeprecatedBeanParam"));
    lSuite.addTest(new ProductServiceTest("testTestPrimitiveArrayAsQueryParam"));
    lSuite.addTest(new ProductServiceTest("testPing"));
    lSuite.addTest(new ProductServiceTest("testDeprecatedParams"));
    lSuite.addTest(new ProductServiceTest("testGetSupportedCurrenciesAsync"));
    lSuite.addTest(new ProductServiceTest("testTestTechnicalHeaderParam"));
    lSuite.addTest(new ProductServiceTest("testTestNotInlinedBeanParam"));
    lSuite.addTest(new ProductServiceTest("testGenericSingleValueResponse"));
    lSuite.addTest(new ProductServiceTest("testTestMultivaluedHeader"));
    lSuite.addTest(new ProductServiceTest("testDeprectedComplexRequestBody"));
    lSuite.addTest(new ProductServiceTest("testTestPrimitiveArray"));
    lSuite.addTest(new ProductServiceTest("testTestChildBeanParameter"));
    lSuite.addTest(new ProductServiceTest("testCreateChannelCode"));
    lSuite.addTest(new ProductServiceTest("testGetSupportedCurrencies"));
    lSuite.addTest(new ProductServiceTest("testTestSpecialHeaderParams"));
    lSuite.addTest(new ProductServiceTest("testGetProducts"));
    lSuite.addTest(new ProductServiceTest("testDeprecatedContext"));
    lSuite.addTest(new ProductServiceTest("testDeprecatedComplexReturn"));
    lSuite.addTest(new ProductServiceTest("testDeprecatedOperation"));
    lSuite.addTest(new ProductServiceTest("testTestExternalBeanParameterType"));
    lSuite.addTest(new ProductServiceTest("testGetProduct"));
    lSuite.addTest(new ProductServiceTest("testTestDateQueryParamsBean"));
    lSuite.addTest(new ProductServiceTest("testLoadSpecificThings"));
    lSuite.addTest(new ProductServiceTest("testTestMultivaluedQueryParams"));
    lSuite.addTest(new ProductServiceTest("testIsCurrencySupported"));
    lSuite.addTest(new ProductServiceTest("testTestTechnicalHeaderBean"));
    lSuite.addTest(new ProductServiceTest("testCreateProduct"));
    lSuite.addTest(new ProductServiceTest("testCreateChannelCodeFromObject"));
    lSuite.addTest(new ProductServiceTest("testTestCodeTypeUsage"));
    lSuite.addTest(new ProductServiceTest("testTestDateQueryParams"));
    lSuite.addTest(new ProductServiceTest("testTestOptionalQueryParams"));
    lSuite.addTest(new ProductServiceTest("testTestMulitValuedBeanParams"));
    lSuite.addTest(new ProductServiceTest("testGetDefaultChannel"));
    lSuite.addTest(new ProductServiceTest("testNoReturnType"));
    lSuite.addTest(new ProductServiceTest("testAddCurrencies"));
    lSuite.addTest(new ProductServiceTest("testGetSortiment"));
    lSuite.addTest(new ProductServiceTest("testCheckIBAN"));
    lSuite.addTest(new ProductServiceTest("testGenericMultiValueResponse"));
    lSuite.addTest(new ProductServiceTest("testTestLocalBeanParamType"));
    lSuite.addTest(new ProductServiceTest("testGetChannels"));
    lSuite.addTest(new ProductServiceTest("testDeleteSomething"));
    // Return created test suite.
    return lSuite;
  }

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public ProductServiceTest( String pName ) {
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
  public ProductServiceTest( String pName, String pUserId, String pPassword ) {
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
   * Method test the implementation of service method deprecatedBody
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedBody( ) throws Exception {
    // TODO Implement test for service method deprecatedBody(...)
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
   * Method test the implementation of service method testPrimitiveArrayAsQueryParam
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveArrayAsQueryParam( ) throws Exception {
    // TODO Implement test for service method testPrimitiveArrayAsQueryParam(...)
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
   * Method test the implementation of service method getSupportedCurrenciesAsync
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetSupportedCurrenciesAsync( ) throws Exception {
    // TODO Implement test for service method getSupportedCurrenciesAsync(...)
  }

  /**
   * Method test the implementation of service method testTechnicalHeaderParam
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestTechnicalHeaderParam( ) throws Exception {
    // TODO Implement test for service method testTechnicalHeaderParam(...)
  }

  /**
   * Method test the implementation of service method testNotInlinedBeanParam
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestNotInlinedBeanParam( ) throws Exception {
    // TODO Implement test for service method testNotInlinedBeanParam(...)
  }

  /**
   * Method test the implementation of service method genericSingleValueResponse
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGenericSingleValueResponse( ) throws Exception {
    // TODO Implement test for service method genericSingleValueResponse(...)
  }

  /**
   * Method test the implementation of service method testMultivaluedHeader
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestMultivaluedHeader( ) throws Exception {
    // TODO Implement test for service method testMultivaluedHeader(...)
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
   * Method test the implementation of service method testPrimitiveArray
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestPrimitiveArray( ) throws Exception {
    // TODO Implement test for service method testPrimitiveArray(...)
  }

  /**
   * Method test the implementation of service method testChildBeanParameter
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestChildBeanParameter( ) throws Exception {
    // TODO Implement test for service method testChildBeanParameter(...)
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
   * Method test the implementation of service method getSupportedCurrencies
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetSupportedCurrencies( ) throws Exception {
    // TODO Implement test for service method getSupportedCurrencies(...)
  }

  /**
   * Method test the implementation of service method testSpecialHeaderParams
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestSpecialHeaderParams( ) throws Exception {
    // TODO Implement test for service method testSpecialHeaderParams(...)
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

  /**
   * Method test the implementation of service method deprecatedComplexReturn
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeprecatedComplexReturn( ) throws Exception {
    // TODO Implement test for service method deprecatedComplexReturn(...)
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
   * Method test the implementation of service method testExternalBeanParameterType
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestExternalBeanParameterType( ) throws Exception {
    // TODO Implement test for service method testExternalBeanParameterType(...)
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
   * Method test the implementation of service method testDateQueryParamsBean
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestDateQueryParamsBean( ) throws Exception {
    // TODO Implement test for service method testDateQueryParamsBean(...)
  }

  /**
   * Method test the implementation of service method loadSpecificThings
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testLoadSpecificThings( ) throws Exception {
    // TODO Implement test for service method loadSpecificThings(...)
  }

  /**
   * Method test the implementation of service method testMultivaluedQueryParams
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestMultivaluedQueryParams( ) throws Exception {
    // TODO Implement test for service method testMultivaluedQueryParams(...)
  }

  /**
   * Method test the implementation of service method isCurrencySupported
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testIsCurrencySupported( ) throws Exception {
    // TODO Implement test for service method isCurrencySupported(...)
  }

  /**
   * Method test the implementation of service method testTechnicalHeaderBean
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestTechnicalHeaderBean( ) throws Exception {
    // TODO Implement test for service method testTechnicalHeaderBean(...)
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
   * Method test the implementation of service method createChannelCodeFromObject
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCreateChannelCodeFromObject( ) throws Exception {
    // TODO Implement test for service method createChannelCodeFromObject(...)
  }

  /**
   * Method test the implementation of service method testCodeTypeUsage
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestCodeTypeUsage( ) throws Exception {
    // TODO Implement test for service method testCodeTypeUsage(...)
  }

  /**
   * Method test the implementation of service method testDateQueryParams
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestDateQueryParams( ) throws Exception {
    // TODO Implement test for service method testDateQueryParams(...)
  }

  /**
   * Method test the implementation of service method testOptionalQueryParams
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestOptionalQueryParams( ) throws Exception {
    // TODO Implement test for service method testOptionalQueryParams(...)
  }

  /**
   * Method test the implementation of service method testMulitValuedBeanParams
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestMulitValuedBeanParams( ) throws Exception {
    // TODO Implement test for service method testMulitValuedBeanParams(...)
  }

  /**
   * Method test the implementation of service method getDefaultChannel
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetDefaultChannel( ) throws Exception {
    // TODO Implement test for service method getDefaultChannel(...)
  }

  /**
   * Method test the implementation of service method noReturnType
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testNoReturnType( ) throws Exception {
    // TODO Implement test for service method noReturnType(...)
  }

  /**
   * Method test the implementation of service method addCurrencies
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testAddCurrencies( ) throws Exception {
    // TODO Implement test for service method addCurrencies(...)
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
   * Method test the implementation of service method checkIBAN
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testCheckIBAN( ) throws Exception {
    // TODO Implement test for service method checkIBAN(...)
  }

  /**
   * Method test the implementation of service method genericMultiValueResponse
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGenericMultiValueResponse( ) throws Exception {
    // TODO Implement test for service method genericMultiValueResponse(...)
  }

  /**
   * Method test the implementation of service method testLocalBeanParamType
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testTestLocalBeanParamType( ) throws Exception {
    // TODO Implement test for service method testLocalBeanParamType(...)
  }

  /**
   * Method test the implementation of service method getChannels
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testGetChannels( ) throws Exception {
    // TODO Implement test for service method getChannels(...)
  }

  /**
   * Method test the implementation of service method deleteSomething
   *
   * @throws Exception if a test fails.
   */
  @Override
  public void testDeleteSomething( ) throws Exception {
    // TODO Implement test for service method deleteSomething(...)
  }
}