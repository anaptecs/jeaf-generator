/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.messaging;

import com.anaptecs.jeaf.core.api.ServiceProvider;

public interface MessagingServiceProvider extends ServiceProvider {
  /**
   * @param pMessage
   * @return boolean
   */
  boolean sendMessage( String pMessage );
}