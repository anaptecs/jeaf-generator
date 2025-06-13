/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest;

import java.util.List;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.core.TestServiceObject;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.rest.generics.BusinessServiceObject;
import com.anaptecs.jeaf.junit.rest.generics.GenericSingleValuedReponse;
// @Something

@JEAFCustomAnnotationTest
public interface RESTTestService extends Service {
  /**
   * @param pID
   * @return {@link String}
   */
  @JEAFCustomAnnotationTest
  String getResource( @JEAFCustomAnnotationTest String pID );

  /**
   * @return {@link TestServiceObject}
   */
  @JEAFCustomAnnotationTest
  TestServiceObject getTestServiceObject( );

  /**
   * @param pObject
   * @return {@link TestServiceObject}
   */
  @JEAFCustomAnnotationTest
  TestServiceObject updateTestServiceObject( @JEAFCustomAnnotationTest TestServiceObject pObject );

  /**
   */
  @JEAFCustomAnnotationTest
  void doSomeNotRESTThing( );

  /**
   */
  @JEAFCustomAnnotationTest
  void doSomethingRESTy( );

  /**
   * @param pID
   * @param pToken
   * @param pQueryParam1
   * @param pCookieParam
   * @return boolean
   */
  @JEAFCustomAnnotationTest
  boolean yetAnotherRESTOperation( @JEAFCustomAnnotationTest String pID, @JEAFCustomAnnotationTest String pToken,
      @JEAFCustomAnnotationTest String pQueryParam1, @JEAFCustomAnnotationTest String pCookieParam );

  /**
   * @param pContext
   */
  @JEAFCustomAnnotationTest
  void handleBeanParam1( @JEAFCustomAnnotationTest Context pContext );

  /**
   * @param pBeanParam
   */
  @JEAFCustomAnnotationTest
  void handleBeanParam1( @JEAFCustomAnnotationTest BeanParameter pBeanParam );

  /**
   * @deprecated Please use something else.<br/>
   * <br/>
   * This is not the right operation any longer.<br/>
   * <br/>
   * Sorry!!! (<b>since:</b> a very long time, <b>removed with:</b> 2023-12-13)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  void deprecatedOperation( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  void deprecatedParameter( @JEAFCustomAnnotationTest int pParam1, @Deprecated @JEAFCustomAnnotationTest int pParam2 );

  /**
   * @param pParam1
   * @return int <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  int deprectaedReturnValue( @JEAFCustomAnnotationTest int pParam1 );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @JEAFCustomAnnotationTest
  @Deprecated
  String deprecatedAsyncParam( @Deprecated @JEAFCustomAnnotationTest int pParam1 );

  /**
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  String deprecatedAsync( @JEAFCustomAnnotationTest int pParam1 );

  /**
   * @return {@link List<GenericSingleValuedReponse<BusinessServiceObject>>}
   */
  @JEAFCustomAnnotationTest
  List<GenericSingleValuedReponse<BusinessServiceObject>> provideGenericResponse( );
}