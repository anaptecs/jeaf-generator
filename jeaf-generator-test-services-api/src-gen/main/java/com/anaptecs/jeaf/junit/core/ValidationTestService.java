/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.Service;

public interface ValidationTestService extends Service {
  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @NotNull
  String validateInNOutput( @NotNull String pString1, @NotEmpty String pString2 );

  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @NotNull
  String notValidOutput( String pString1, @NotEmpty String pString2 );

  /**
   * @param pString1
   * @param pString2
   * @return {@link String}
   */
  @NotNull
  String validateOutputOnly( String pString1, String pString2 );

  /**
   * @param pString1
   * @param pInteger
   * @return {@link String}
   */
  String validateInputOnly( String pString1, @Min(value = 4711) int pInteger );

  /**
   * @param pString1
   * @param pBool
   * @return {@link String}
   */
  String noMethodValidation( String pString1, boolean pBool );

  /**
   * @param pTestObject
   */
  void createValidationTestObject( @Valid ValidationTestObject pTestObject );
}