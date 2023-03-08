/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;

public interface JEAFTestService extends Service {
  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   * 
   * 
   */
  void checkRequiredService_1( );

  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   * 
   * 
   */
  @Deprecated
  void checkRequiredService_2( );

  /**
   * Method tests JEAFs context handling and the passing of context information to listeners.
   * 
   * 
   */
  void testContextHandling( );

  /**
   * Method checks the access to the service invocation context from within a service implementation.
   * 
   * 
   */
  void testContextAccess( );

  /**
   * Method checks invalid accesses to a service invocation context.
   * 
   * 
   */
  void testIllgealContextAccess( );

  /**
  * 
  */
  void testContextIsolation( );

  /**
   * 
   * @return {@link SessionContextValues}
   */
  SessionContextValues testSessionContextHandling( );
}