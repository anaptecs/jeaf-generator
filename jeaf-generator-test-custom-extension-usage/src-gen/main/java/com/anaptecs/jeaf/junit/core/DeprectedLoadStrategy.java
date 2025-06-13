/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.LoadStrategy;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@Deprecated
@JEAFCustomAnnotationTest
public final class DeprectedLoadStrategy implements LoadStrategy {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant load strategy object to load all associations.
   */
  public static final DeprectedLoadStrategy LOAD_ALL = new DeprectedLoadStrategy(true, true);

  /**
   * Constant load strategy object to load none of the associations.
   */
  public static final DeprectedLoadStrategy LOAD_NONE = new DeprectedLoadStrategy(false, false);

  @JEAFCustomAnnotationTest
  private final boolean loadObjects;

  @JEAFCustomAnnotationTest
  private final boolean loadExternalData;

  /**
   * Initialize object.
   */
  public DeprectedLoadStrategy( boolean pLoadObjects, boolean pLoadExternalData ) {
    loadObjects = pLoadObjects;
    loadExternalData = pLoadExternalData;
  }

  @JEAFCustomAnnotationTest
  public boolean loadObjects( ) {
    return loadObjects;
  }

  @JEAFCustomAnnotationTest
  public boolean loadExternalData( ) {
    return loadExternalData;
  }
}