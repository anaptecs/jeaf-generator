/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface ServiceWithDeprecations extends Service {
  /**
   * @deprecated Resources can no longer be explicitly be created. (<b>since:</b> 0.9, <b>removed with:</b> 1.2.3)
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  void createSomething( );

  /**
   * @param pBody
   * @param pHeader <br/>
   * <b>Deprecated. </b> <i>Please do not use this header any longer. No matter what you pass here it will be ignored.
   * (<b>since:</b> , <b>removed with:</b> )
   * @param pQueryParam <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * <p/>
   * <b>Breaking Change with PI 13:</b> Parameter will be mandatory.
   * @param pContext
   */
  @JEAFCustomAnnotationTest
  void createSomething( @JEAFCustomAnnotationTest JustAType pBody, @Deprecated @JEAFCustomAnnotationTest String pHeader,
      @Deprecated @JEAFCustomAnnotationTest String pQueryParam,
      @JEAFCustomAnnotationTest BeanParamWithDeprecations pContext );
}