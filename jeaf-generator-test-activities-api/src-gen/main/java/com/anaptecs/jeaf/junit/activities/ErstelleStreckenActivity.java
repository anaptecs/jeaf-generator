/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.activities;

import java.util.List;

import com.anaptecs.jeaf.core.api.Activity;
import com.anaptecs.jeaf.junit.domainObjects.InfoPLUSConnection;
import com.anaptecs.jeaf.junit.domainObjects.Strecke;

/**
 * Interface of activity ErstelleStreckenActivity.
 *
 * Intention of thius activity is to transform the results from HAFAS to out internal representation as Strecke.
 */
public interface ErstelleStreckenActivity extends Activity {
  /**
   * Intention of thius activity is to transform the results from HAFAS to out internal representation as Strecke.
   * 
   * @param pConnections
   * @param pValue This is an integer value as input for an activity.
   * @return List<Strecke>
   */
  List<Strecke> execute( List<InfoPLUSConnection> pConnections, Integer pValue );
}
