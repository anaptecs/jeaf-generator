/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.core.TestServiceObject;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface RESTTestService extends Service {
  /**
   * 
   * @param pID
   * @return {@link String}
   */
  String getResource( String pID );

  /**
   * 
   * @return {@link TestServiceObject}
   */
  TestServiceObject getTestServiceObject( );

  /**
   * 
   * @param pObject
   * @return {@link TestServiceObject}
   */
  TestServiceObject updateTestServiceObject( TestServiceObject pObject );

  /**
  * 
  */
  void doSomeNotRESTThing( );

  /**
  * 
  */
  void doSomethingRESTy( );

  /**
   * 
   * @param pID
   * @param pToken
   * @param pQueryParam1
   * @return {@link Boolean}
   */
  boolean yetAnotherRESTOperation( String pID, String pToken, String pQueryParam1 );
}