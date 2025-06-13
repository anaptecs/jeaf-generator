/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface JEAFTestService extends Service {
  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   */
  @JEAFCustomAnnotationTest
  void checkRequiredService_1( );

  /**
   * Method tests JEAF dependency injection mechanism for the dependency on RequiredService1.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  void checkRequiredService_2( );

  /**
   * Method tests JEAFs context handling and the passing of context information to listeners.
   */
  @JEAFCustomAnnotationTest
  void testContextHandling( );

  /**
   * Method checks the access to the service invocation context from within a service implementation.
   */
  @JEAFCustomAnnotationTest
  void testContextAccess( );

  /**
   * Method checks invalid accesses to a service invocation context.
   */
  @JEAFCustomAnnotationTest
  void testIllgealContextAccess( );

  /**
   */
  @JEAFCustomAnnotationTest
  void testContextIsolation( );

  /**
   * @return {@link SessionContextValues}
   */
  @JEAFCustomAnnotationTest
  SessionContextValues testSessionContextHandling( );
}