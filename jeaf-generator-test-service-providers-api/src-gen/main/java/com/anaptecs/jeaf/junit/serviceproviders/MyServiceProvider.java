/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.serviceproviders;

import com.anaptecs.jeaf.core.api.ServiceProvider;

/**
 * 
 */
public interface MyServiceProvider extends ServiceProvider {
  /**
   * 
   * @return {@link Boolean}
   */
  boolean doSomething( );

  /**
  * 
  */
  @Deprecated
  void doSomethingDeprecated( );

  /**
   * 
   * @param pParam1
   * @param pParam2
   * @return {@link String}
   */
  @Deprecated
  String doSomething( int pParam1, @Deprecated int pParam2 );
}