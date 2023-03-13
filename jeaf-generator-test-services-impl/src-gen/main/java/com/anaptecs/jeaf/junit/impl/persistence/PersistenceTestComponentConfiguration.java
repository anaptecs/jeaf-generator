/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.persistence;

import java.util.Calendar;
import java.util.Locale;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * Class represents the configuration for component
 * {@link com.anaptecs.jeaf.junit.impl.persistence.PersistenceTestComponent}.
 */
public final class PersistenceTestComponentConfiguration {
  /**
   * Resource access provider enables access to the properties of the component.
   */
  private final Configuration configuration;

  /**
   * In order to avoid direct instantiation of this class the constructor is set to package visibility.
   */
  PersistenceTestComponentConfiguration( ComponentID pComponentID ) {
    // Create resource access provider for properties of the component.
    configuration = XFun.getConfigurationProvider().getComponentConfiguration(pComponentID);
  }

  /**
   * Method returns the value of the property "booleanProperty".
   * 
   * @return {@link Boolean} Value of the property "booleanProperty". The method returns null if no value for the
   * property is defined.
   */
  public Boolean getBooleanProperty( ) {
    return configuration.getConfigurationValue("booleanProperty", Boolean.class);
  }

  /**
   * Method returns the value of the property "byteProperty".
   * 
   * @return {@link Byte} Value of the property "byteProperty". The method returns null if no value for the property is
   * defined.
   */
  public Byte getByteProperty( ) {
    return configuration.getConfigurationValue("byteProperty", Byte.class);
  }

  /**
   * Method returns the value of the property "shortProperty".
   * 
   * @return {@link Short} Value of the property "shortProperty". The method returns null if no value for the property
   * is defined.
   */
  public Short getShortProperty( ) {
    return configuration.getConfigurationValue("shortProperty", Short.class);
  }

  /**
   * Method returns the value of the property "integerProperty".
   * 
   * @return {@link Integer} Value of the property "integerProperty". The method returns null if no value for the
   * property is defined.
   */
  public Integer getIntegerProperty( ) {
    return configuration.getConfigurationValue("integerProperty", Integer.class);
  }

  /**
   * Method returns the value of the property "longProperty".
   * 
   * @return {@link Long} Value of the property "longProperty". The method returns null if no value for the property is
   * defined.
   */
  public Long getLongProperty( ) {
    return configuration.getConfigurationValue("longProperty", Long.class);
  }

  /**
   * Method returns the value of the property "floatProperty".
   * 
   * @return {@link Float} Value of the property "floatProperty". The method returns null if no value for the property
   * is defined.
   */
  public Float getFloatProperty( ) {
    return configuration.getConfigurationValue("floatProperty", Float.class);
  }

  /**
   * Method returns the value of the property "doubleProperty".
   * 
   * @return {@link Double} Value of the property "doubleProperty". The method returns null if no value for the property
   * is defined.
   */
  public Double getDoubleProperty( ) {
    return configuration.getConfigurationValue("doubleProperty", Double.class);
  }

  /**
   * Method returns the value of the property "stringProperty".
   * 
   * @return {@link String} Value of the property "stringProperty". The method returns null if no value for the property
   * is defined.
   */
  public String getStringProperty( ) {
    return configuration.getConfigurationValue("stringProperty", String.class);
  }

  /**
   * Method returns the value of the property "characterProperty".
   * 
   * @return {@link Character} Value of the property "characterProperty". The method returns null if no value for the
   * property is defined.
   */
  public Character getCharacterProperty( ) {
    return configuration.getConfigurationValue("characterProperty", Character.class);
  }

  /**
   * Method returns the value of the property "classProperty".
   * 
   * @return {@link Class} Value of the property "classProperty". The method returns null if no value for the property
   * is defined.
   */
  public Class<?> getClassProperty( ) {
    return configuration.getConfigurationValue("classProperty", Class.class);
  }

  /**
   * Method returns the value of the property "calendarProperty".
   * 
   * @return {@link Calendar} Value of the property "calendarProperty". The method returns null if no value for the
   * property is defined.
   */
  @Deprecated
  public Calendar getCalendarProperty( ) {
    return configuration.getConfigurationValue("calendarProperty", Calendar.class);
  }

  /**
   * Method returns the value of the property "localeProperty".
   * 
   * @return {@link Locale} Value of the property "localeProperty". The method returns null if no value for the property
   * is defined.
   */
  public Locale getLocaleProperty( ) {
    return configuration.getConfigurationValue("localeProperty", Locale.class);
  }

  /**
   * Method returns the value of the property "deprectedAttribute".
   * 
   * @return {@link String} Value of the property "deprectedAttribute". The method returns null if no value for the
   * property is defined.
   */
  @Deprecated
  public String getDeprectedAttribute( ) {
    return configuration.getConfigurationValue("deprectedAttribute", String.class);
  }
}
