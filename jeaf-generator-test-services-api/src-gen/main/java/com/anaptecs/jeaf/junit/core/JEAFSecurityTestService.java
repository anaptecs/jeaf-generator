/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;

/**
 * Test Service for the Security functionality. It provides Methods to check if the login function is working correctly.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
// @Something
public interface JEAFSecurityTestService extends Service {
  /**
   * Method returns the currently user who is loged in.<br/>
   * <br/>
   * @return loged in User.
   */
  void checkCurrentUser( );

  /**
   */
  void checkInvalidServiceAccess( );

  /**
   * checks if the attribute of the currentUser which is an anonymous user are set correctly.
   */
  void checkCurrentAnonymousUser( );
}