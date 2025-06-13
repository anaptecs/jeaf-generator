/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.LoadStrategy;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

@JEAFCustomAnnotationTest
public final class TestLoadStrategy implements LoadStrategy {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant load strategy object to load all associations.
   */
  public static final TestLoadStrategy LOAD_ALL = new TestLoadStrategy(true, true, true);

  /**
   * Constant load strategy object to load none of the associations.
   */
  public static final TestLoadStrategy LOAD_NONE = new TestLoadStrategy(false, false, false);

  @JEAFCustomAnnotationTest
  private final boolean loadInternalData;

  @JEAFCustomAnnotationTest
  private final boolean loadPublicData;

  @Deprecated
  @JEAFCustomAnnotationTest
  private final boolean loadDeprecatedData;

  /**
   * Initialize object.
   */
  public TestLoadStrategy( boolean pLoadInternalData, boolean pLoadPublicData, boolean pLoadDeprecatedData ) {
    loadInternalData = pLoadInternalData;
    loadPublicData = pLoadPublicData;
    loadDeprecatedData = pLoadDeprecatedData;
  }

  @JEAFCustomAnnotationTest
  public boolean loadInternalData( ) {
    return loadInternalData;
  }

  @JEAFCustomAnnotationTest
  public boolean loadPublicData( ) {
    return loadPublicData;
  }

  @Deprecated
  @JEAFCustomAnnotationTest
  public boolean loadDeprecatedData( ) {
    return loadDeprecatedData;
  }
}