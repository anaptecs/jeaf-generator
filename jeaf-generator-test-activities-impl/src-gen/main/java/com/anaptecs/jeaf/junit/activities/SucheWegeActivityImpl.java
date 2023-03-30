/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import java.util.List;

import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;
import com.anaptecs.jeaf.junit.domainObjects.Strecke;
import com.anaptecs.jeaf.junit.domainObjects.WegsucheAnfrage;

/**
 * Implementation of activity SucheWegeActivity.
 *
 */
@JEAFActivityImpl(activityInterface = SucheWegeActivity.class)
public class SucheWegeActivityImpl implements SucheWegeActivity {
  /**
   * Create new instance of activity.
   */
  SucheWegeActivityImpl( ) {
  }

  /**
   *
   *
   * @param pWegsucheAnfrage Parameter describes the Wegsuche that should be performed
   * @return List<Strecke> List with alle Strecken that were found by Wegsuche
   */
  @Override
  public List<Strecke> execute( WegsucheAnfrage pWegsucheAnfrage ) {
    // TODO: Implement business logic for activity.
    return null;
  }
}
