/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.serviceproviders;

import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * 
 */
abstract class MyServiceProviderImplBase implements ServiceProviderImplementation, MyServiceProvider {
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
    Package lBasePackage = MyServiceProviderImpl.class.getPackage();
    COMPONENT_ID = new ComponentID("MyServiceProviderImpl", lBasePackage.getName());
  }

  /**
   * Constructor has reduced visibility in order to ensure that all service provider implementations are created through
   * the factory.
   */
  MyServiceProviderImplBase( ) {
    // Create resource access provider for properties of the component.
    configuration = XFun.getConfigurationProvider().getComponentConfiguration(COMPONENT_ID);
  }

  /**
   * Method returns the value of the property "myProperty".
   * 
   * @return {@link String} Value of the property "myProperty". The method returns null if no value for the property is
   * defined.
   */
  public String getMyProperty( ) {
    return configuration.getConfigurationValue("myProperty", String.class);
  }

  /**
   * Method returns the value of the property "deprecated".
   * 
   * @return {@link Boolean} Value of the property "deprecated". The method returns null if no value for the property is
   * defined.
   */
  @Deprecated
  public boolean getDeprecated( ) {
    return configuration.getConfigurationValue("deprecated", Boolean.class);
  }
}