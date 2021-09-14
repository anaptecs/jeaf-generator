/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.messaging.impl;

import com.anaptecs.jeaf.accounting.messaging.MessagingServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * 
 */
abstract class MessagingServiceProviderImplBase implements ServiceProviderImplementation, MessagingServiceProvider {
  /**
   * Reference to the object that identifies this component. The reference is never null.
   */
  private static final ComponentID COMPONENT_ID;

  /**
   * Resource access provider enables access to the properties of the service provider.
   */
  private final Configuration configuration;
  /**
   * Static initializer is used to create the components ComponentID object and its trace object.
   */
  static {
    // Create Component ID and trace object.
    Package lBasePackage = MessagingServiceProviderImpl.class.getPackage();
    COMPONENT_ID = new ComponentID("MessagingServiceProviderImpl", lBasePackage.getName());
  }

  /**
   * Constructor has reduced visibility in order to ensure that all service provider implementations are created through
   * the factory.
   */
  MessagingServiceProviderImplBase( ) {
    // Create resource access provider for properties of the component.
    configuration = XFun.getConfigurationProvider().getComponentConfiguration(COMPONENT_ID);
  }

  /**
   * Method returns the value of the property "connectURL".
   * 
   * @return {@link String} Value of the property "connectURL". The method returns null if no value for the property is
   * defined.
   */
  public String getConnectURL( ) {
    return configuration.getConfigurationValue("connectURL", String.class);
  }
}