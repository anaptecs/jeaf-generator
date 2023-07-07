/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.serviceproviders;

import com.anaptecs.jeaf.core.api.ServiceProvider;

public interface MyServiceProvider extends ServiceProvider {
  /**
   * @return boolean
   */
  boolean doSomething( );

  /**
   */
  @Deprecated
  void doSomethingDeprecated( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  String doSomething( int pParam1, @Deprecated int pParam2 );
}