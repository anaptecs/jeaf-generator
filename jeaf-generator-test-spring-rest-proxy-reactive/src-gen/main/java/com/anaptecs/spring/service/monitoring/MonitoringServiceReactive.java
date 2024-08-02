/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.monitoring;

import reactor.core.publisher.Mono;

public interface MonitoringServiceReactive {
  /**
   * @return {@link String}
   */
  Mono<String> getVersionInfo( );
}