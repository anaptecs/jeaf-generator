/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import com.anaptecs.jeaf.core.api.ServiceProvider;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;

/**
 * Service Provider Interface is generated so that a proxy for a REST Resource can be provided as JEAF Service Provider.
 */
public interface PathlessServiceRESTProxyServiceProvider extends ServiceProvider {
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