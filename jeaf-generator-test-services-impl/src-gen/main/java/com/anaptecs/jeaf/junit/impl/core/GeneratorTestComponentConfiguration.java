/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * Class represents the GeneratorTest component.
 *
 * 
 */
public final class GeneratorTestComponentConfiguration {
  /**
   * Resource access provider enables access to the properties of the component.
   */
  private final Configuration configuration;

  /**
   * In order to avoid direct instantiation of this class the constructor is set to package visibility.
   */
  GeneratorTestComponentConfiguration( ComponentID pComponentID ) {
    // Create resource access provider for properties of the component.
    configuration = XFun.getConfigurationProvider().getComponentConfiguration(pComponentID);
  }

  /**
   * Method returns the value of the property "testProperty".
   * 
   * @return {@link Integer} Value of the property "testProperty". The method returns null if no value for the property
   * is defined.
   */
  public Integer getTestProperty( ) {
    return configuration.getConfigurationValue("testProperty", Integer.class);
  }

  /**
   * Method returns the value of the property "deprecatedAttribute".
   * 
   * @return {@link Double} Value of the property "deprecatedAttribute". The method returns null if no value for the
   * property is defined.
   */
  @Deprecated
  public Double getDeprecatedAttribute( ) {
    return configuration.getConfigurationValue("deprecatedAttribute", Double.class);
  }
}