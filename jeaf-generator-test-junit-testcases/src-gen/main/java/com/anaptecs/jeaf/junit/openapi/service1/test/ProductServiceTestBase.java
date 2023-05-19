/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.openapi.service1.ProductService;

/**
 * This is the base class of the test suite of service ProductService.
 *
 * @version $LastChangedRevision: 931 $
 */
public abstract class ProductServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected ProductService productService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   *
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public ProductServiceTestBase( String pName ) {
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
  public ProductServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method deprecatedBody(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedBody( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedBeanParam(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedBeanParam( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveArrayAsQueryParam(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveArrayAsQueryParam( ) throws Exception;

  /**
   * Method test the implementation of service method ping(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testPing( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedParams( ) throws Exception;

  /**
   * Method test the implementation of service method getSupportedCurrenciesAsync(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetSupportedCurrenciesAsync( ) throws Exception;

  /**
   * Method test the implementation of service method testTechnicalHeaderParam(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestTechnicalHeaderParam( ) throws Exception;

  /**
   * Method test the implementation of service method testNotInlinedBeanParam(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestNotInlinedBeanParam( ) throws Exception;

  /**
   * Method test the implementation of service method genericSingleValueResponse(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGenericSingleValueResponse( ) throws Exception;

  /**
   * Method test the implementation of service method testMultivaluedHeader(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestMultivaluedHeader( ) throws Exception;

  /**
   * Method test the implementation of service method deprectedComplexRequestBody(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprectedComplexRequestBody( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveArray(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveArray( ) throws Exception;

  /**
   * Method test the implementation of service method testChildBeanParameter(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestChildBeanParameter( ) throws Exception;

  /**
   * Method test the implementation of service method createChannelCode(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreateChannelCode( ) throws Exception;

  /**
   * Method test the implementation of service method getSupportedCurrencies(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetSupportedCurrencies( ) throws Exception;

  /**
   * Method test the implementation of service method testSpecialHeaderParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestSpecialHeaderParams( ) throws Exception;

  /**
   * Method test the implementation of service method getProducts(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetProducts( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedContext(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedContext( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedComplexReturn(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedComplexReturn( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedOperation(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedOperation( ) throws Exception;

  /**
   * Method test the implementation of service method testExternalBeanParameterType(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestExternalBeanParameterType( ) throws Exception;

  /**
   * Method test the implementation of service method getProduct(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetProduct( ) throws Exception;

  /**
   * Method test the implementation of service method testDateQueryParamsBean(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestDateQueryParamsBean( ) throws Exception;

  /**
   * Method test the implementation of service method loadSpecificThings(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testLoadSpecificThings( ) throws Exception;

  /**
   * Method test the implementation of service method testMultivaluedQueryParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestMultivaluedQueryParams( ) throws Exception;

  /**
   * Method test the implementation of service method isCurrencySupported(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testIsCurrencySupported( ) throws Exception;

  /**
   * Method test the implementation of service method testTechnicalHeaderBean(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestTechnicalHeaderBean( ) throws Exception;

  /**
   * Method test the implementation of service method createProduct(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreateProduct( ) throws Exception;

  /**
   * Method test the implementation of service method createChannelCodeFromObject(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCreateChannelCodeFromObject( ) throws Exception;

  /**
   * Method test the implementation of service method testCodeTypeUsage(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestCodeTypeUsage( ) throws Exception;

  /**
   * Method test the implementation of service method testDateQueryParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestDateQueryParams( ) throws Exception;

  /**
   * Method test the implementation of service method testOptionalQueryParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestOptionalQueryParams( ) throws Exception;

  /**
   * Method test the implementation of service method testMulitValuedBeanParams(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestMulitValuedBeanParams( ) throws Exception;

  /**
   * Method test the implementation of service method getDefaultChannel(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetDefaultChannel( ) throws Exception;

  /**
   * Method test the implementation of service method noReturnType(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testNoReturnType( ) throws Exception;

  /**
   * Method test the implementation of service method addCurrencies(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testAddCurrencies( ) throws Exception;

  /**
   * Method test the implementation of service method getSortiment(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetSortiment( ) throws Exception;

  /**
   * Method test the implementation of service method checkIBAN(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testCheckIBAN( ) throws Exception;

  /**
   * Method test the implementation of service method genericMultiValueResponse(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGenericMultiValueResponse( ) throws Exception;

  /**
   * Method test the implementation of service method testLocalBeanParamType(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testTestLocalBeanParamType( ) throws Exception;

  /**
   * Method test the implementation of service method getChannels(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testGetChannels( ) throws Exception;

  /**
   * Method test the implementation of service method deleteSomething(...)
   *
   * @throws Exception if the test fails.
   */
  public abstract void testDeleteSomething( ) throws Exception;
}