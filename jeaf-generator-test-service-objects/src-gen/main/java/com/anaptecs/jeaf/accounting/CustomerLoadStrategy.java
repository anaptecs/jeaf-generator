/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import com.anaptecs.jeaf.core.api.LoadStrategy;

/**
	 * 
	 */
public final class CustomerLoadStrategy implements LoadStrategy {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant load strategy object to load all associations.
   */
  public static final CustomerLoadStrategy LOAD_ALL = new CustomerLoadStrategy(true, true);

  /**
   * Constant load strategy object to load none of the associations.
   */
  public static final CustomerLoadStrategy LOAD_NONE = new CustomerLoadStrategy(false, false);

  /**
   * Initialize object.
   */
  public CustomerLoadStrategy( boolean pLoadAccount, boolean pLoadBookings ) {
    loadAccount = pLoadAccount;
    loadBookings = pLoadBookings;
  }

  /**
   * 
   */
  private final boolean loadAccount;

  /**
   * 
   */
  private final boolean loadBookings;

  /**
   * 
   */
  public boolean loadAccount( ) {
    return loadAccount;
  }

  /**
   * 
   */
  public boolean loadBookings( ) {
    return loadBookings;
  }
}