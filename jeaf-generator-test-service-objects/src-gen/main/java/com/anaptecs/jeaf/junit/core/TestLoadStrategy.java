/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.LoadStrategy;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * Initialize object.
   */
  public TestLoadStrategy( boolean pLoadInternalData, boolean pLoadPublicData, boolean pLoadDeprecatedData ) {
    loadInternalData = pLoadInternalData;
    loadPublicData = pLoadPublicData;
    loadDeprecatedData = pLoadDeprecatedData;
  }

  /**
   * 
   */
  private final boolean loadInternalData;

  /**
   * 
   */
  private final boolean loadPublicData;

  /**
   * 
   */
  @Deprecated
  private final boolean loadDeprecatedData;

  /**
   * 
   */
  public boolean loadInternalData( ) {
    return loadInternalData;
  }

  /**
   * 
   */
  public boolean loadPublicData( ) {
    return loadPublicData;
  }

  /**
   * 
   */
  @Deprecated
  public boolean loadDeprecatedData( ) {
    return loadDeprecatedData;
  }
}