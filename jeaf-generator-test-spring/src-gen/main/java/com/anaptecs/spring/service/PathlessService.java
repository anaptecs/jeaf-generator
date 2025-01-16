/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.annotations.MyNotNullServiceParam;

public interface PathlessService {
  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String getSomething( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pHeaderBean
   * @param pTechContext
   */
  @MyNotNullServiceParam
  void processTechParam( @MyNotNullServiceParam MultiValuedHeaderBeanParam pHeaderBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pQuery
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testQueryBeanParam( @MyNotNullServiceParam DataTypesQueryBean pQuery );
}