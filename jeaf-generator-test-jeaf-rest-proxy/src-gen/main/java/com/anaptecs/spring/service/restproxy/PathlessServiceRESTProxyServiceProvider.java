/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import com.anaptecs.jeaf.core.api.ServiceProvider;

/**
 * Service Provider Interface is generated so that a proxy for a REST Resource can be provided as JEAF Service Provider.
 */
public interface PathlessServiceRESTProxyServiceProvider extends ServiceProvider {
  /**
   * 
   * @return {@link String}
   */
  String getSomething( );
}