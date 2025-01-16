/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import com.anaptecs.jeaf.core.api.ServiceProvider;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProviderFactory;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;

/**
 * This class is the factory class the service provider implementation
 * {@link RESTProductServiceRESTProxyServiceProviderImpl}.
 */
@com.anaptecs.jeaf.core.annotations.ServiceProviderFactory
public final class RESTProductServiceRESTProxyServiceProviderFactory extends ServiceProviderFactory {
  /**
   * Initialize object. No actions have to be performed.
   */
  public RESTProductServiceRESTProxyServiceProviderFactory( ) {
    // Nothing to do.
  }

  /**
   * Method creates a new instance of the service provider.
   *
   * @return {@link ServiceProviderImplementation} Instance of service provider. The method never returns null.
   *
   * @see ServiceProviderFactory#createServiceProviderImplementation()
   */
  public ServiceProviderImplementation createServiceProviderImplementation( ) {
    return new RESTProductServiceRESTProxyServiceProviderImpl();
  }

  /**
   * Method returns the interface of the service provider created by this factory.
   *
   * @return Class Class object of interface that belongs to the service provider that is created by this factory. The
   * method never returns null.
   *
   * @see ServiceProviderFactory#getServiceProviderInterface()
   */
  public Class<? extends ServiceProvider> getServiceProviderInterface( ) {
    return RESTProductServiceRESTProxyServiceProvider.class;
  }
}