/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import reactor.core.publisher.Mono;

public interface PathlessServiceReactive {
  /**
   * @return {@link String}
   */
  Mono<String> getSomething( );

  /**
   * @param pHeaderBean
   * @param pTechContext
   */
  Mono<Void> processTechParam( MultiValuedHeaderBeanParam pHeaderBean );

  /**
   * @param pQuery
   * @return {@link String}
   */
  Mono<String> testQueryBeanParam( DataTypesQueryBean pQuery );
}