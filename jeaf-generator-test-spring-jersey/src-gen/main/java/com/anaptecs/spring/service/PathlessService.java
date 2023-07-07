/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

public interface PathlessService {
  /**
   * @return {@link String}
   */
  String getSomething( );

  /**
   * @param pHeaderBean
   * @param pTechContext
   */
  void processTechParam( MultiValuedHeaderBeanParam pHeaderBean );

  /**
   * @param pQuery
   * @return {@link String}
   */
  String testQueryBeanParam( DataTypesQueryBean pQuery );
}