/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * Class represents the configuration for component {@link com.anaptecs.jeaf.accounting.impl.AccountingComponent}.
 */
public final class AccountingComponentConfiguration {
  /**
   * Resource access provider enables access to the properties of the component.
   */
  private final Configuration configuration;

  /**
   * In order to avoid direct instantiation of this class the constructor is set to package visibility.
   */
  AccountingComponentConfiguration( ComponentID pComponentID ) {
    // Create resource access provider for properties of the component.
    configuration = XFun.getConfigurationProvider().getComponentConfiguration(pComponentID);
  }

  /**
   * Method returns the value of the property "defaultInterrestRate".
   * 
   * @return {@link Float} Value of the property "defaultInterrestRate". The method returns null if no value for the
   * property is defined.
   */
  public Float getDefaultInterrestRate( ) {
    return configuration.getConfigurationValue("defaultInterrestRate", Float.class);
  }
}