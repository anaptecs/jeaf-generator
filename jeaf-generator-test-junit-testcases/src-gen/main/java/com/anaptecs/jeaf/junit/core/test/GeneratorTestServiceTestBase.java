/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.test;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.junit.JEAFTestCase;
import com.anaptecs.jeaf.junit.core.GeneratorTestService;

/**
 * This is the base class of the test suite of service GeneratorTestService.
 * 
 * @version $LastChangedRevision: 931 $
 */
public abstract class GeneratorTestServiceTestBase extends JEAFTestCase {
  /**
   * Service that should be tested by this test case.
   */
  @JEAFService
  protected GeneratorTestService generatorTestService;

  /**
   * Initialize test case. Therefore the name of the test that should be executed must be provided.
   * 
   * @param pName Name of the test method that should be executed by this test. The Parameter must not be null.
   */
  public GeneratorTestServiceTestBase( String pName ) {
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
  public GeneratorTestServiceTestBase( String pName, String pUserId, String pPassword ) {
    super(pName, pUserId, pPassword);
  }

  /**
   * Method test the implementation of service method testPrimitivesAsParameter(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitivesAsParameter( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveLongResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveLongResult( ) throws Exception;

  /**
   * Method test the implementation of service method doWithObjectsFromOtherPAckages(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDoWithObjectsFromOtherPAckages( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveBooleanResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveBooleanResult( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveCharResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveCharResult( ) throws Exception;

  /**
   * Method test the implementation of service method convertToSimpleDatatypes(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testConvertToSimpleDatatypes( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimiveIntResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimiveIntResult( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveShortResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveShortResult( ) throws Exception;

  /**
   * Method test the implementation of service method testGenericsAsParameter(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestGenericsAsParameter( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitveDoubleResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitveDoubleResult( ) throws Exception;

  /**
   * Method test the implementation of service method processSimpleDatatypes(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testProcessSimpleDatatypes( ) throws Exception;

  /**
   * Method test the implementation of service method testGenericsAsResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestGenericsAsResult( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitveByteResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitveByteResult( ) throws Exception;

  /**
   * Method test the implementation of service method convertToWrapperDatatypes(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testConvertToWrapperDatatypes( ) throws Exception;

  /**
   * Method test the implementation of service method testPrimitiveFloatResult(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testTestPrimitiveFloatResult( ) throws Exception;

  /**
   * Method test the implementation of service method doWhatIMean(...)
   * 
   * @throws Exception if the test fails.
   */
  public abstract void testDoWhatIMean( ) throws Exception;
}