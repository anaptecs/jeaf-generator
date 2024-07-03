/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.annotations.MyNotNull;

public interface PathlessService {
  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  @MyNotNull
  String getSomething( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pHeaderBean
   * @param pTechContext
   */
  @MyNotNull
  void processTechParam( @MyNotNull MultiValuedHeaderBeanParam pHeaderBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pQuery
   * @return {@link String}
   */
  @MyNotNull
  String testQueryBeanParam( @MyNotNull DataTypesQueryBean pQuery );
}