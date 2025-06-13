/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface ValidationTestService extends Service {
  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  @NotNull
  String validateInNOutput( @JEAFCustomAnnotationTest @NotNull String pString1,
      @JEAFCustomAnnotationTest @NotEmpty String pString2 );

  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  @NotNull
  String notValidOutput( @JEAFCustomAnnotationTest String pString1,
      @JEAFCustomAnnotationTest @NotEmpty String pString2 );

  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  @NotNull
  String validateOutputOnly( @JEAFCustomAnnotationTest String pString1, @JEAFCustomAnnotationTest String pString2 );

  /**
   * @param pString1
   * @param pInteger
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String validateInputOnly( @JEAFCustomAnnotationTest String pString1,
      @JEAFCustomAnnotationTest @Min(value = 4711) int pInteger );

  /**
   * @param pString1
   * @param pBool
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String noMethodValidation( @JEAFCustomAnnotationTest String pString1, @JEAFCustomAnnotationTest boolean pBool );

  /**
   * @param pTestObject
   */
  @JEAFCustomAnnotationTest
  void createValidationTestObject( @JEAFCustomAnnotationTest @Valid ValidationTestObject pTestObject );
}