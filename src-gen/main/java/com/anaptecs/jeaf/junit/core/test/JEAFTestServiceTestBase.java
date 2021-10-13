/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.core.JEAFTestService;

/**
 * This is the base class of the test suite of service JEAFTestService.
 * 
 * @version $LastChangedRevision: 931 $
 */
public abstract class JEAFTestServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected JEAFTestService jEAFTestService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public JEAFTestServiceTestBase( String pName ) {
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
  public JEAFTestServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method checkRequiredService_2(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCheckRequiredService_2( ) throws Exception;

  /**
   * Method test the implementation of service method checkRequiredService_1(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testCheckRequiredService_1( ) throws Exception;

  /**
   * Method test the implementation of service method testContextHandling(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestContextHandling( ) throws Exception;

  /**
   * Method test the implementation of service method testContextIsolation(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestContextIsolation( ) throws Exception;

  /**
   * Method test the implementation of service method testSessionContextHandling(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestSessionContextHandling( ) throws Exception;

  /**
   * Method test the implementation of service method testIllgealContextAccess(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestIllgealContextAccess( ) throws Exception;

  /**
   * Method test the implementation of service method testContextAccess(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestContextAccess( ) throws Exception;
}