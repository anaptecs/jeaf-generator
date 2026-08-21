/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@JEAFCustomAnnotationTest
public enum InventoryType {
  @JEAFCustomAnnotationTest
  SBB, @JEAFCustomAnnotationTest
  SNCF,
  /**
   * <p/>
   * <b>Breaking Change</b> (<b>since:</b> TBD, <b>active with:</b> 3.x, <b>activation date:</b> TBD): New literal will
   * occur
   */
  @JEAFCustomAnnotationTest
  DB;
}