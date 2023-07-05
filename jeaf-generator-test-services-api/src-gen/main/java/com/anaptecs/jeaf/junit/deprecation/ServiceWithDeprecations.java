/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import com.anaptecs.jeaf.core.api.Service;

public interface ServiceWithDeprecations extends Service {
  /**
   * @deprecated Resources can no longer be explicitly be created. (<b>since:</b> 0.9, <b>removed with:</b> 1.2.3)
   */
  @Deprecated
  void createSomething( );

  /**
   * @param pBody
   * @param pHeader <br/>
   * <b>Deprecated. </b> <i>Please do not use this header any longer. No matter what you pass here it will be ignored.
   * (<b>since:</b> , <b>removed with:</b> )
   * @param pQueryParam <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @param pContext
   */
  void createSomething( JustAType pBody, @Deprecated String pHeader, @Deprecated String pQueryParam,
      BeanParamWithDeprecations pContext );
}