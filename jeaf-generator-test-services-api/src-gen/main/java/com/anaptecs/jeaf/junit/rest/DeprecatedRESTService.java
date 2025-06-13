/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@Deprecated
@JEAFCustomAnnotationTest
public interface DeprecatedRESTService extends Service {
  /**
   */
  @JEAFCustomAnnotationTest
  void doSomething( );
}