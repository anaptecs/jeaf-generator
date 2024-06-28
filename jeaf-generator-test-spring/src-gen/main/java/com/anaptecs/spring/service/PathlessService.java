/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

public interface PathlessService {
  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  String getSomething( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pHeaderBean
   * @param pTechContext
   */
  void processTechParam( MultiValuedHeaderBeanParam pHeaderBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pQuery
   * @return {@link String}
   */
  String testQueryBeanParam( DataTypesQueryBean pQuery );
}