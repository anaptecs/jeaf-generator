/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.jeaf.core.api.Service;

public interface PathlessService extends Service {
  /**
   * @return {@link String}
   */
  String getSomething( );
}