/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.rest.RESTTestService;

/**
 * This is the base class of the test suite of service RESTTestService.
 * 
 * @version $LastChangedRevision: 931 $
 */
public abstract class RESTTestServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected RESTTestService rESTTestService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public RESTTestServiceTestBase( String pName ) {
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
  public RESTTestServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method deprecatedOperation(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedOperation( ) throws Exception;

  /**
   * Method test the implementation of service method getTestServiceObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetTestServiceObject( ) throws Exception;

  /**
   * Method test the implementation of service method getResource(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testGetResource( ) throws Exception;

  /**
   * Method test the implementation of service method updateTestServiceObject(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testUpdateTestServiceObject( ) throws Exception;

  /**
   * Method test the implementation of service method handleBeanParam1(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testHandleBeanParam1( ) throws Exception;

  /**
   * Method test the implementation of service method doSomeNotRESTThing(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDoSomeNotRESTThing( ) throws Exception;

  /**
   * Method test the implementation of service method deprectaedReturnValue(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprectaedReturnValue( ) throws Exception;

  /**
   * Method test the implementation of service method doSomethingRESTy(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDoSomethingRESTy( ) throws Exception;

  /**
   * Method test the implementation of service method yetAnotherRESTOperation(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testYetAnotherRESTOperation( ) throws Exception;

  /**
   * Method test the implementation of service method deprecatedParameter(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDeprecatedParameter( ) throws Exception;
}