/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

/**
 * Test Service for the Security functionality. It provides Methods to check if the login function is working correctly.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
// @Something
@JEAFCustomAnnotationTest
public interface JEAFSecurityTestService extends Service {
  /**
   * Method returns the currently user who is loged in.<br/>
   * <br/>
   * @return loged in User.
   */
  @JEAFCustomAnnotationTest
  void checkCurrentUser( );

  /**
   */
  @JEAFCustomAnnotationTest
  void checkInvalidServiceAccess( );

  /**
   * checks if the attribute of the currentUser which is an anonymous user are set correctly.
   */
  @JEAFCustomAnnotationTest
  void checkCurrentAnonymousUser( );
}