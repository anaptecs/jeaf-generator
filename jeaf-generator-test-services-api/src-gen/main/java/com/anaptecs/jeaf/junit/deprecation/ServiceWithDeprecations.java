/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import com.anaptecs.jeaf.core.api.Service;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface ServiceWithDeprecations extends Service {
  /**
  * 
  */
  @Deprecated
  void createSomething( );

  /**
   * 
   * @param pBody
   * @param pHeader
   * @param pQueryParam
   * @param pContext
   */
  void createSomething( JustAType pBody, @Deprecated String pHeader, @Deprecated String pQueryParam,
      BeanParamWithDeprecations pContext );
}