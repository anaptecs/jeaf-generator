/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Set;

import com.anaptecs.jeaf.junit.otherpackage.Input;
import com.anaptecs.jeaf.junit.otherpackage.Output;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface GeneratorTestService extends ParentService {
  /**
   * 
   * @param pDatatypes
   */
  void processSimpleDatatypes( SimpleDatatypeServiceObject pDatatypes );

  /**
   * 
   * @param pSimpleTypes
   * @return {@link WrapperDatatypeServiceObject}
   */
  WrapperDatatypeServiceObject convertToWrapperDatatypes( SimpleDatatypeServiceObject pSimpleTypes );

  /**
   * 
   * @param pWrapperTypes
   * @return {@link SimpleDatatypeServiceObject}
   */
  SimpleDatatypeServiceObject convertToSimpleDatatypes( WrapperDatatypeServiceObject pWrapperTypes );

  /**
   * 
   * @param pInteger
   * @param pByteArray
   * @param pDoubleValue
   * @return {@link Boolean}
   */
  boolean testPrimitivesAsParameter( int pInteger, byte[] pByteArray, double pDoubleValue );

  /**
   * 
   * @param pSimpleObjects
   */
  void testGenericsAsParameter( Set<SimpleDatatypeServiceObject> pSimpleObjects );

  /**
   * 
   * @return {@link SimpleDatatypeServiceObject}
   */
  Set<SimpleDatatypeServiceObject> testGenericsAsResult( );

  /**
   * 
   * @param pParam1
   */
  void doWhatIMean( int pParam1 );

  /**
  * 
  */
  void doWhatIMean( );

  /**
   * 
   * @param pParam1
   */
  void doWhatIMean( Double pParam1 );

  /**
   * 
   * @param pInput
   * @return {@link Output}
   */
  Set<Output> doWithObjectsFromOtherPAckages( Input pInput );

  /**
   * 
   * @return {@link int}
   */
  int testPrimiveIntResult( );

  /**
   * 
   * @return {@link Boolean}
   */
  boolean testPrimitiveBooleanResult( );

  /**
   * 
   * @return {@link short}
   */
  short testPrimitiveShortResult( );

  /**
   * 
   * @return {@link byte}
   */
  byte testPrimitveByteResult( );

  /**
   * 
   * @return {@link char}
   */
  char testPrimitiveCharResult( );

  /**
   * 
   * @return {@link long}
   */
  long testPrimitiveLongResult( );

  /**
   * 
   * @return {@link float}
   */
  float testPrimitiveFloatResult( );

  /**
   * 
   * @return {@link double}
   */
  double testPrimitveDoubleResult( );
}
