/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;

/**
 * Implementation of activity DoNothingActivity.
 * 
 */
@JEAFActivityImpl(activityInterface = DoNothingActivity.class)
@Deprecated
public class DoNothingActivityImpl implements DoNothingActivity {
  /**
   * Create new instance of activity.
   */
  DoNothingActivityImpl( ) {
  }

  /**
   * 
   * 
   * @return void
   */
  @Override
  public void execute( ) {
    // TODO: Implement business logic for activity.
  }
}