/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.LoadStrategy;

/**
	 * 
	 */
@Deprecated
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

  /**
   * Initialize object.
   */
  public DeprectedLoadStrategy( boolean pLoadObjects, boolean pLoadExternalData ) {
    loadObjects = pLoadObjects;
    loadExternalData = pLoadExternalData;
  }

  /**
   * 
   */
  private final boolean loadObjects;

  /**
   * 
   */
  private final boolean loadExternalData;

  /**
   * 
   */
  public boolean loadObjects( ) {
    return loadObjects;
  }

  /**
   * 
   */
  public boolean loadExternalData( ) {
    return loadExternalData;
  }
}