/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import java.util.List;

import com.anaptecs.jeaf.core.api.Activity;
import com.anaptecs.jeaf.junit.domainObjects.Strecke;
import com.anaptecs.jeaf.junit.domainObjects.WegsucheAnfrage;

/**
 * Interface of activity SucheWegeActivity.
 *
 *
 */
public interface SucheWegeActivity extends Activity {
  /**
   *
   *
   * @param pWegsucheAnfrage Parameter describes the Wegsuche that should be performed
   * @return List<Strecke> List with alle Strecken that were found by Wegsuche
   */
  List<Strecke> execute( WegsucheAnfrage pWegsucheAnfrage );
}
