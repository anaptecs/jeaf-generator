/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.core.TestServiceObject;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.Context;

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
   * @param pCookieParam
   * @return {@link Boolean}
   */
  boolean yetAnotherRESTOperation( String pID, String pToken, String pQueryParam1, String pCookieParam );

  /**
   * 
   * @param pContext
   */
  void handleBeanParam1( Context pContext );

  /**
   * 
   * @param pBeanParam
   */
  void handleBeanParam1( BeanParameter pBeanParam );

  /**
  * 
  */
  @Deprecated
  void deprecatedOperation( );

  /**
   * 
   * @param pParam1
   * @param pParam2
   */
  void deprecatedParameter( int pParam1, @Deprecated int pParam2 );

  /**
   * 
   * @param pParam1
   * @return {@link int}
   */
  @Deprecated
  int deprectaedReturnValue( int pParam1 );

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  String deprecatedAsyncParam( @Deprecated int pParam1 );

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  String deprecatedAsync( int pParam1 );
}