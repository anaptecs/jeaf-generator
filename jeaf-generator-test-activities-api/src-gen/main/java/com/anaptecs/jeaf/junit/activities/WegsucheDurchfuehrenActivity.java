/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import java.util.List;

import com.anaptecs.jeaf.core.api.Activity;
import com.anaptecs.jeaf.junit.domainObjects.InfoPLUSConnection;
import com.anaptecs.jeaf.junit.domainObjects.WegsucheAnfrage;

/**
 * Interface of activity WegsucheDurchfuehrenActivity.
 *
 *
 */
public interface WegsucheDurchfuehrenActivity extends Activity {
  /**
   *
   *
   * @param in
   * @return List<InfoPLUSConnection>
   */
  List<InfoPLUSConnection> execute( WegsucheAnfrage in );
}
