/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;

/**
 * Implementation of activity ActivityWithDeprecation.
 * 
 */
@JEAFActivityImpl(activityInterface = ActivityWithDeprecation.class)
public class ActivityWithDeprecationImpl implements ActivityWithDeprecation {
  /**
   * Create new instance of activity.
   */
  ActivityWithDeprecationImpl( ) {
  }

  /**
   * 
   * 
   * @param pParam1
   * @param pParam2
   * @return String
   */
  @Deprecated
  @Override
  public String execute( int pParam1, @Deprecated int pParam2 ) {
    // TODO: Implement business logic
    return null;
  }
}