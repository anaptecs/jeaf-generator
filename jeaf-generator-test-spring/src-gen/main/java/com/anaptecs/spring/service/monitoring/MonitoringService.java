/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.monitoring;

import com.anaptecs.annotations.MyNotNullServiceParam;

public interface MonitoringService {
  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String getVersionInfo( );
}