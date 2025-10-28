/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.monitoring;

import com.anaptecs.annotations.MyNotNullServiceParam;
import reactor.core.publisher.Mono;

public interface MonitoringServiceReactive {
  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> getVersionInfo( );
}