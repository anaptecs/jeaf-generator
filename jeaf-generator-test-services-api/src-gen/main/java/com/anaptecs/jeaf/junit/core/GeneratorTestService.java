/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Set;

import com.anaptecs.jeaf.junit.otherpackage.Input;
import com.anaptecs.jeaf.junit.otherpackage.Output;

public interface GeneratorTestService extends ParentService {
  /**
   * @param pDatatypes
   */
  void processSimpleDatatypes( SimpleDatatypeServiceObject pDatatypes );

  /**
   * @param pSimpleTypes
   * @return {@link WrapperDatatypeServiceObject}
   */
  WrapperDatatypeServiceObject convertToWrapperDatatypes( SimpleDatatypeServiceObject pSimpleTypes );

  /**
   * @param pWrapperTypes
   * @return {@link SimpleDatatypeServiceObject}
   */
  SimpleDatatypeServiceObject convertToSimpleDatatypes( WrapperDatatypeServiceObject pWrapperTypes );

  /**
   * @param pInteger
   * @param pByteArray
   * @param pDoubleValue
   * @return boolean
   */
  boolean testPrimitivesAsParameter( int pInteger, byte[] pByteArray, double pDoubleValue );

  /**
   * @param pSimpleObjects
   */
  void testGenericsAsParameter( Set<SimpleDatatypeServiceObject> pSimpleObjects );

  /**
   * @return {@link Set<SimpleDatatypeServiceObject>}
   */
  Set<SimpleDatatypeServiceObject> testGenericsAsResult( );

  /**
   * @param pParam1
   */
  void doWhatIMean( int pParam1 );

  /**
   */
  void doWhatIMean( );

  /**
   * @param pParam1
   */
  void doWhatIMean( Double pParam1 );

  /**
   * @param pInput
   * @return {@link Set<Output>}
   */
  Set<Output> doWithObjectsFromOtherPAckages( Input pInput );

  /**
   * @return int
   */
  int testPrimiveIntResult( );

  /**
   * @return boolean
   */
  boolean testPrimitiveBooleanResult( );

  /**
   * @return short
   */
  short testPrimitiveShortResult( );

  /**
   * @return byte
   */
  byte testPrimitveByteResult( );

  /**
   * @return char
   */
  char testPrimitiveCharResult( );

  /**
   * @return long
   */
  long testPrimitiveLongResult( );

  /**
   * @return float
   */
  float testPrimitiveFloatResult( );

  /**
   * @return double
   */
  double testPrimitveDoubleResult( );
}
