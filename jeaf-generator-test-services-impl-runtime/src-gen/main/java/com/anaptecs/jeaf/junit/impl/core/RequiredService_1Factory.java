/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceFactory;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.ComponentImplementation;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.RequiredService_1;
import com.anaptecs.jeaf.junit.core.RequiredService_1Proxy;

/**
 * Factory class for service RequiredService_1.
 */
final class RequiredService_1Factory extends ServiceFactory {
  /**
   * Initialize object. Therefore the component to which this service factory belongs has to be passed.
   *
   * @param pComponent Component to which this service factory belongs. The parameter must not be null.
   */
  public RequiredService_1Factory( ComponentImplementation pComponent ) {
    super(pComponent);
  }

  /**
   * Method returns the class object of the service interface that is defined by this service.
   *
   * @return Class Class object of the service interface defined by this service. The method never returns null.
   *
   * @see ServiceFactory#getServiceInterfaceClass()
   */
  public Class<? extends Service> getServiceInterfaceClass( ) {
    return RequiredService_1.class;
  }

  /**
   * Method creates a new instance of the service implementation to which this factory belongs to. The method will be
   * called during the initialization of JEAF.
   *
   * @return ServiceImplementation Created instance of the service implementation. The method must not return null.
   *
   * @see ServiceFactory#createServiceInstance()
   */
  public ServiceImplementation createServiceInstance( ) {
    return new RequiredService_1Impl(this.getComponent());
  }

  /**
   * Method creates a new instance of the service proxy to which this factory belongs. The method will be called during
   * the initialization of JEAF.
   *
   * @return ServiceProxy Created instance of the service proxy. The method must not return null.
   *
   * @see ServiceFactory#createServiceProxy()
   */
  public ServiceProxy createServiceProxy( ) {
    // Create new service proxy and return it.
    return new RequiredService_1Proxy(this.getComponent().getTransactionBehavior());
  }
}