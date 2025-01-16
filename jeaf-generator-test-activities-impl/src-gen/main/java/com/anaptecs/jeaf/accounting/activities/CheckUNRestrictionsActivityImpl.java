/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.activities;

import com.anaptecs.jeaf.accounting.Account;
import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;

/**
 * Implementation of activity CheckUNRestrictionsActivity.
 *
 */
@JEAFActivityImpl(activityInterface = CheckUNRestrictionsActivity.class)
public class CheckUNRestrictionsActivityImpl implements CheckUNRestrictionsActivity {
  /**
   * Create new instance of activity.
   */
  CheckUNRestrictionsActivityImpl( ) {
  }

  /**
   *
   *
   * @param account
   * @return boolean
   */
  @Override
  public boolean execute( Account account ) {
    // TODO: Implement business logic for activity.
    return false;
  }
}