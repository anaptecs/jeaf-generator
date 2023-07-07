/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import com.anaptecs.jeaf.core.api.Activity;

/**
 * Interface of activity ActivityWithDeprecation.
 *
 *
 */
public interface ActivityWithDeprecation extends Activity {
  /**
   *
   *
   * @param pParam1
   * @param pParam2
   * @return String
   */
  @Deprecated
  String execute( int pParam1, @Deprecated int pParam2 );
}