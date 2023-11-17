/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import java.util.List;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.core.TestServiceObject;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.rest.generics.BusinessServiceObject;
import com.anaptecs.jeaf.junit.rest.generics.GenericSingleValuedReponse;

public interface RESTTestService extends Service {
  /**
   * @param pID
   * @return {@link String}
   */
  String getResource( String pID );

  /**
   * @return {@link TestServiceObject}
   */
  TestServiceObject getTestServiceObject( );

  /**
   * @param pObject
   * @return {@link TestServiceObject}
   */
  TestServiceObject updateTestServiceObject( TestServiceObject pObject );

  /**
   */
  void doSomeNotRESTThing( );

  /**
   */
  void doSomethingRESTy( );

  /**
   * @param pID
   * @param pToken
   * @param pQueryParam1
   * @param pCookieParam
   * @return boolean
   */
  boolean yetAnotherRESTOperation( String pID, String pToken, String pQueryParam1, String pCookieParam );

  /**
   * @param pContext
   */
  void handleBeanParam1( Context pContext );

  /**
   * @param pBeanParam
   */
  void handleBeanParam1( BeanParameter pBeanParam );

  /**
   * @deprecated Please use something else.<br/>
   * <br/>
   * This is not the right operation any longer.<br/>
   * <br/>
   * Sorry!!! (<b>since:</b> a very long time, <b>removed with:</b> 2023-12-13)
   */
  @Deprecated
  void deprecatedOperation( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  void deprecatedParameter( int pParam1, @Deprecated int pParam2 );

  /**
   * @param pParam1
   * @return int <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  int deprectaedReturnValue( int pParam1 );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  String deprecatedAsyncParam( @Deprecated int pParam1 );

  /**
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  String deprecatedAsync( int pParam1 );

  /**
   * @return {@link List<GenericSingleValuedReponse<BusinessServiceObject>>}
   */
  List<GenericSingleValuedReponse<BusinessServiceObject>> provideGenericResponse( );
}
