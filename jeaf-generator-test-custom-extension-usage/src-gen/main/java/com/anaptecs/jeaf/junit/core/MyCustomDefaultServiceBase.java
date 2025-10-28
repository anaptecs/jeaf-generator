/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface MyCustomDefaultServiceBase extends Service {
  /**
   * @param pMessage
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String doSomething( @JEAFCustomAnnotationTest String pMessage );

  /**
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String doSomeMore( );
}