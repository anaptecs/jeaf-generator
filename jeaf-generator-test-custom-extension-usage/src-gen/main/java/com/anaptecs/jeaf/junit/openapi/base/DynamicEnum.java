/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

/**
 * Test for enums with dynamic literals.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public enum DynamicEnum {
  @JEAFCustomAnnotationTest
  STATIC_LITERAL,
  /**
   * This is a fake dynamic literal.
   */
  FAKE;
}