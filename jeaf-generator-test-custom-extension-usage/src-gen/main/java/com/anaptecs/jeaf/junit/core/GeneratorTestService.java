/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Set;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.junit.otherpackage.Input;
import com.anaptecs.jeaf.junit.otherpackage.Output;
// @Something

@JEAFCustomAnnotationTest
public interface GeneratorTestService extends ParentService {
  /**
   * @param pDatatypes
   */
  @JEAFCustomAnnotationTest
  void processSimpleDatatypes( @JEAFCustomAnnotationTest SimpleDatatypeServiceObject pDatatypes );

  /**
   * @param pSimpleTypes
   * @return {@link WrapperDatatypeServiceObject}
   */
  @JEAFCustomAnnotationTest
  WrapperDatatypeServiceObject convertToWrapperDatatypes(
      @JEAFCustomAnnotationTest SimpleDatatypeServiceObject pSimpleTypes );

  /**
   * @param pWrapperTypes
   * @return {@link SimpleDatatypeServiceObject}
   */
  @JEAFCustomAnnotationTest
  SimpleDatatypeServiceObject convertToSimpleDatatypes(
      @JEAFCustomAnnotationTest WrapperDatatypeServiceObject pWrapperTypes );

  /**
   * @param pInteger
   * @param pByteArray
   * @param pDoubleValue
   * @return boolean
   */
  @JEAFCustomAnnotationTest
  boolean testPrimitivesAsParameter( @JEAFCustomAnnotationTest int pInteger,
      @JEAFCustomAnnotationTest byte[] pByteArray, @JEAFCustomAnnotationTest double pDoubleValue );

  /**
   * @param pSimpleObjects
   */
  @JEAFCustomAnnotationTest
  void testGenericsAsParameter( @JEAFCustomAnnotationTest Set<SimpleDatatypeServiceObject> pSimpleObjects );

  /**
   * @return {@link Set<SimpleDatatypeServiceObject>}
   */
  @JEAFCustomAnnotationTest
  Set<SimpleDatatypeServiceObject> testGenericsAsResult( );

  /**
   * @param pParam1
   */
  @JEAFCustomAnnotationTest
  void doWhatIMean( @JEAFCustomAnnotationTest int pParam1 );

  /**
   */
  @JEAFCustomAnnotationTest
  void doWhatIMean( );

  /**
   * @param pParam1
   */
  @JEAFCustomAnnotationTest
  void doWhatIMean( @JEAFCustomAnnotationTest Double pParam1 );

  /**
   * @param pInput
   * @return {@link Set<Output>}
   */
  @JEAFCustomAnnotationTest
  Set<Output> doWithObjectsFromOtherPAckages( @JEAFCustomAnnotationTest Input pInput );

  /**
   * @return int
   */
  @JEAFCustomAnnotationTest
  int testPrimiveIntResult( );

  /**
   * @return boolean
   */
  @JEAFCustomAnnotationTest
  boolean testPrimitiveBooleanResult( );

  /**
   * @return short
   */
  @JEAFCustomAnnotationTest
  short testPrimitiveShortResult( );

  /**
   * @return byte
   */
  @JEAFCustomAnnotationTest
  byte testPrimitveByteResult( );

  /**
   * @return char
   */
  @JEAFCustomAnnotationTest
  char testPrimitiveCharResult( );

  /**
   * @return long
   */
  @JEAFCustomAnnotationTest
  long testPrimitiveLongResult( );

  /**
   * @return float
   */
  @JEAFCustomAnnotationTest
  float testPrimitiveFloatResult( );

  /**
   * @return double
   */
  @JEAFCustomAnnotationTest
  double testPrimitveDoubleResult( );
}