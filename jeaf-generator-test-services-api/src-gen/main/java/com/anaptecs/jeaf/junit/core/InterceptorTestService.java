/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
// @Something

public interface InterceptorTestService extends Service {
  /**
   */
  void callService( );

  /**
   */
  void callServiceAPE( ) throws InterceptorTestApplicationException;

  /**
   */
  void callServiceSYE( );

  /**
   */
  void callServiceRTE( );

  /**
   */
  void callServiceERR( );
}