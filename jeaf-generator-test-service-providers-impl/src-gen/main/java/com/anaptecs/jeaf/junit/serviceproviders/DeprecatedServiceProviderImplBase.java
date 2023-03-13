/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.serviceproviders;

import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;

@Deprecated
abstract class DeprecatedServiceProviderImplBase implements ServiceProviderImplementation, DeprecatedServiceProvider {
  /**
   * Constructor has reduced visibility in order to ensure that all service provider implementations are created through
   * the factory.
   */
  DeprecatedServiceProviderImplBase( ) {
  }
}
