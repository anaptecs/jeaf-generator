/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.openapi.service1.ProductRESTService;

/**
 * This is the base class of the test suite of service ProductRESTService.
 * 
 * @version $LastChangedRevision: 931 $
 */
public abstract class ProductRESTServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected ProductRESTService productRESTService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public ProductRESTServiceTestBase( String pName ) {
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
  public ProductRESTServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method deprecatedOperation(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedOperation( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedBody(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedBody( ) throws Exception;

  /**
   * Method test the implementation of service method getProduct(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetProduct( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedBeanParam(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedBeanParam( ) throws Exception;

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
   * Method test the implementation of service method createProduct(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateProduct( ) throws Exception;

  /**
   * Method test the implementation of service method getSortiment(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetSortiment( ) throws Exception;

  /**
   * Method test the implementation of service method deprectedComplexRequestBody(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprectedComplexRequestBody( ) throws Exception;

  /**
   * Method test the implementation of service method createChannelCode(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCreateChannelCode( ) throws Exception;

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
}