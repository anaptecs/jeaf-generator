/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.tx;

import com.anaptecs.jeaf.core.api.Service;
// @Something

public interface TxSupportedService extends Service {
  /**
   */
  void testTransactionBehavior( );
}