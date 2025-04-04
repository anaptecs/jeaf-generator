/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.restproxy;

import com.anaptecs.jeaf.core.api.ServiceProvider;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProviderFactory;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;

/**
 * This class is the factory class the service provider implementation
 * {@link ProductServiceRESTProxyServiceProviderImpl}.
 */
@com.anaptecs.jeaf.core.annotations.ServiceProviderFactory
public final class ProductServiceRESTProxyServiceProviderFactory extends ServiceProviderFactory {
  /**
   * Initialize object. No actions have to be performed.
   */
  public ProductServiceRESTProxyServiceProviderFactory( ) {
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
    return new ProductServiceRESTProxyServiceProviderImpl();
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
    return ProductServiceRESTProxyServiceProvider.class;
  }
}