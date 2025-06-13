/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface InternalStuffService extends Service {
  /**
   * @param pObjectID
   */
  @JEAFCustomAnnotationTest
  void testFlush( @JEAFCustomAnnotationTest ServiceObjectID pObjectID );
}