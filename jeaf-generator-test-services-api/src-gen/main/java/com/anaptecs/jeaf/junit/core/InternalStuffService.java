/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface InternalStuffService extends Service {
  /**
   * 
   * @param pObjectID
   */
  void testFlush( ServiceObjectID pObjectID );
}