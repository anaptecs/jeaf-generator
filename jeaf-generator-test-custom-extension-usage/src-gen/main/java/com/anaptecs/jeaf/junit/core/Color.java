/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

/**
 * There are so many colors.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public enum Color {
  /**
   * Bright white
   */
  @JEAFCustomAnnotationTest
  WHITE, @JEAFCustomAnnotationTest
  BLACK, @JEAFCustomAnnotationTest
  GREEN,
  /**
   * @deprecated We do not like this color any more. (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  LightGreen, @JEAFCustomAnnotationTest
  LIGHT_GREEN;
}