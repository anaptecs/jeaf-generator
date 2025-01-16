/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import java.util.Set;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.junit.core.SimpleDatatypeServiceObject;
import com.anaptecs.jeaf.junit.core.WrapperDatatypeServiceObject;
import com.anaptecs.jeaf.junit.otherpackage.Input;
import com.anaptecs.jeaf.junit.otherpackage.Output;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of GeneratorTestService.
 */
final class GeneratorTestServiceImpl extends GeneratorTestServiceImplBase {
  /**
   * Initialize object.
   */
  GeneratorTestServiceImpl( Component pComponent ) {
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
   * @param pDatatypes
   */
  @Override
  public void processSimpleDatatypes( SimpleDatatypeServiceObject pDatatypes ) {
  }

  /**
   * @param pSimpleTypes
   * @return {@link WrapperDatatypeServiceObject}
   */
  @Override
  public WrapperDatatypeServiceObject convertToWrapperDatatypes( SimpleDatatypeServiceObject pSimpleTypes ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pWrapperTypes
   * @return {@link SimpleDatatypeServiceObject}
   */
  @Override
  public SimpleDatatypeServiceObject convertToSimpleDatatypes( WrapperDatatypeServiceObject pWrapperTypes ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pInteger
   * @param pByteArray
   * @param pDoubleValue
   * @return boolean
   */
  @Override
  public boolean testPrimitivesAsParameter( int pInteger, byte[] pByteArray, double pDoubleValue ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * @param pSimpleObjects
   */
  @Override
  public void testGenericsAsParameter( Set<SimpleDatatypeServiceObject> pSimpleObjects ) {
  }

  /**
   * @return {@link Set<SimpleDatatypeServiceObject>}
   */
  @Override
  public Set<SimpleDatatypeServiceObject> testGenericsAsResult( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pParam1
   */
  @Override
  public void doWhatIMean( int pParam1 ) {
  }

  /**
   */
  @Override
  public void doWhatIMean( ) {
  }

  /**
   * @param pParam1
   */
  @Override
  public void doWhatIMean( Double pParam1 ) {
  }

  /**
   * @param pInput
   * @return {@link Set<Output>}
   */
  @Override
  public Set<Output> doWithObjectsFromOtherPAckages( Input pInput ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @return int
   */
  @Override
  public int testPrimiveIntResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return boolean
   */
  @Override
  public boolean testPrimitiveBooleanResult( ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * @return short
   */
  @Override
  public short testPrimitiveShortResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return byte
   */
  @Override
  public byte testPrimitveByteResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return char
   */
  @Override
  public char testPrimitiveCharResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return long
   */
  @Override
  public long testPrimitiveLongResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return float
   */
  @Override
  public float testPrimitiveFloatResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   * @return double
   */
  @Override
  public double testPrimitveDoubleResult( ) {
    // TODO Implement method and return real result
    return 0;
  }

  /**
   */
  @Override
  public void parentServiceMethod( ) {
  }
}