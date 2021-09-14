/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import java.util.List;

import com.anaptecs.jeaf.core.annotations.JEAFActivityImpl;
import com.anaptecs.jeaf.junit.domainObjects.InfoPLUSConnection;
import com.anaptecs.jeaf.junit.domainObjects.WegsucheAnfrage;

/**
 * Implementation of activity WegsucheDurchfuehrenActivity.
 * 
 */
@JEAFActivityImpl(activityInterface = WegsucheDurchfuehrenActivity.class)
public class WegsucheDurchfuehrenActivityImpl implements WegsucheDurchfuehrenActivity {
  /**
   * Create new instance of activity.
   */
  WegsucheDurchfuehrenActivityImpl( ) {
  }

  /**
   * 
   * 
   * @param in
   * @return List<InfoPLUSConnection>
   */
  @Override
  public List<InfoPLUSConnection> execute( WegsucheAnfrage in ) {
    // TODO: Implement business logic
    return null;
  }
}
