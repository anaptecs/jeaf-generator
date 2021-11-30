/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.health.CheckLevel;
import com.anaptecs.jeaf.core.api.health.HealthCheckResult;
import com.anaptecs.jeaf.junit.core.ValidationTestObject;

/**
 * Implementation of ValidationTestService.
 */
final class ValidationTestServiceImpl extends ValidationTestServiceImplBase {
  /**
   * Initialize object.
   */
  ValidationTestServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * 
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @Override
  public String validateInNOutput( String pString1, String pString2 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @Override
  public String notValidOutput( String pString1, String pString2 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @Override
  public String validateOutputOnly( String pString1, String pString2 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pString1
   * @param pInteger
   * @return {@link String}
   */
  @Override
  public String validateInputOnly( String pString1, int pInteger ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pString1
   * @param pBool
   * @return {@link String}
   */
  @Override
  public String noMethodValidation( String pString1, boolean pBool ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pTestObject
   */
  @Override
  public void createValidationTestObject( ValidationTestObject pTestObject ) {
  }
}