/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.messaging.impl;

import com.anaptecs.jeaf.accounting.messaging.MessagingServiceProvider;
import com.anaptecs.jeaf.core.api.ServiceProvider;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProviderFactory;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;

/**
 * This class is the factory class the service provider implementation {@link MessagingServiceProviderImpl}.
 */
@com.anaptecs.jeaf.core.annotations.ServiceProviderFactory
public final class MessagingServiceProviderImplFactory extends ServiceProviderFactory {
  /**
   * Initialize object. No actions have to be performed.
   */
  public MessagingServiceProviderImplFactory( ) {
    // Nothing to do.
  }

  /**
   * Method creates a new instance of the service provider.
   *
   * @return {@link ServiceProviderImplementation} Instance of service provider. The method never returns null.
   *
   * @see com.anaptecs.jeaf.core.servicechannel.api.ServiceProviderFactory#createServiceProviderImplementation()
   */
  @Override
  public ServiceProviderImplementation createServiceProviderImplementation( ) {
    return new MessagingServiceProviderImpl();
  }

  /**
   * Method returns the interface of the service provider created by this factory.
   *
   * @return Class Class object of interface that belongs to the service provider that is created by this factory. The
   * method never returns null.
   *
   * @see com.anaptecs.jeaf.core.servicechannel.api.ServiceProviderFactory#getServiceProviderInterface()
   */
  @Override
  public Class<? extends ServiceProvider> getServiceProviderInterface( ) {
    return MessagingServiceProvider.class;
  }
}