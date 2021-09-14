/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.persistence;

import java.util.Calendar;
import java.util.Locale;

import com.anaptecs.jeaf.accounting.AccountingBasicDataService;
import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.InternalStuffService;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of port BusinessObjectTestPort.
 */
abstract class BusinessObjectTestPortBase implements ServiceImplementation {
  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to configuration of the component.
   */
  private final PersistenceTestComponentConfiguration configuration;

  /**
   * Reference to to trace object of the component to which this service instance belongs to. The reference is never
   * null since the trace object is set in the constructor. The reference is visible to sub classes in order to make
   * tracing as easy as possible.
   */
  final Trace trace;

  /**
   * Reference to persistence service provider. The class contains this dependency due to the fact that its components
   * defines a dependency to a persistence unit.
   */
  @JEAFServiceProvider
  private PersistenceServiceProvider persistenceServiceProvider;

  /**
   * Initialize object.
   */
  BusinessObjectTestPortBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
    configuration = new PersistenceTestComponentConfiguration(component.getComponentID());
  }

  /**
   * Method returns reference to the persistence service provider that can be used to access the database.
   * 
   * @return {@link PersistenceServiceProvider} Reference to persistence service provider. The method never returns
   * null.
   */
  protected final PersistenceServiceProvider getPersistenceServiceProvider( ) {
    return persistenceServiceProvider;
  }

  /**
   * The used service AccountingBasicDataService.
   */
  @JEAFService
  private AccountingBasicDataService accountingBasicDataService;

  /**
   * Method returns the AccountingBasicDataService from which this service depends.
   * 
   * @return AccountingBasicDataService Reference to the AccountingBasicDataService. The method never returns null after
   * the service has been initialized.
   * 
   */
  protected final AccountingBasicDataService getAccountingBasicDataService( ) {
    return this.accountingBasicDataService;
  }

  /**
   * The used service InternalStuffService.
   */
  @JEAFService
  private InternalStuffService internalStuffService;

  /**
   * Method returns the InternalStuffService from which this service depends.
   * 
   * @return InternalStuffService Reference to the InternalStuffService. The method never returns null after the service
   * has been initialized.
   * 
   */
  protected final InternalStuffService getInternalStuffService( ) {
    return this.internalStuffService;
  }

  /**
   * Method returns the service invocation context for the current service call.
   * 
   * @return ServiceInvocationContext Service invocation context for the current call. The method never returns null as
   * long as it is called from within a service call.
   */
  protected final ServiceInvocationContext getCurrentServiceInvocationContext( ) {
    return JEAF.getContext().getServiceInvocationContext();
  }

  /**
   * Method returns the value of the property "booleanProperty".
   * 
   * @return {@link Boolean} Value of the property "booleanProperty". The method returns null if no value for the
   * property is defined.
   */
  public Boolean getBooleanProperty( ) {
    return configuration.getBooleanProperty();
  }

  /**
   * Method returns the value of the property "byteProperty".
   * 
   * @return {@link Byte} Value of the property "byteProperty". The method returns null if no value for the property is
   * defined.
   */
  public Byte getByteProperty( ) {
    return configuration.getByteProperty();
  }

  /**
   * Method returns the value of the property "shortProperty".
   * 
   * @return {@link Short} Value of the property "shortProperty". The method returns null if no value for the property
   * is defined.
   */
  public Short getShortProperty( ) {
    return configuration.getShortProperty();
  }

  /**
   * Method returns the value of the property "integerProperty".
   * 
   * @return {@link Integer} Value of the property "integerProperty". The method returns null if no value for the
   * property is defined.
   */
  public Integer getIntegerProperty( ) {
    return configuration.getIntegerProperty();
  }

  /**
   * Method returns the value of the property "longProperty".
   * 
   * @return {@link Long} Value of the property "longProperty". The method returns null if no value for the property is
   * defined.
   */
  public Long getLongProperty( ) {
    return configuration.getLongProperty();
  }

  /**
   * Method returns the value of the property "floatProperty".
   * 
   * @return {@link Float} Value of the property "floatProperty". The method returns null if no value for the property
   * is defined.
   */
  public Float getFloatProperty( ) {
    return configuration.getFloatProperty();
  }

  /**
   * Method returns the value of the property "doubleProperty".
   * 
   * @return {@link Double} Value of the property "doubleProperty". The method returns null if no value for the property
   * is defined.
   */
  public Double getDoubleProperty( ) {
    return configuration.getDoubleProperty();
  }

  /**
   * Method returns the value of the property "stringProperty".
   * 
   * @return {@link String} Value of the property "stringProperty". The method returns null if no value for the property
   * is defined.
   */
  public String getStringProperty( ) {
    return configuration.getStringProperty();
  }

  /**
   * Method returns the value of the property "characterProperty".
   * 
   * @return {@link Character} Value of the property "characterProperty". The method returns null if no value for the
   * property is defined.
   */
  public Character getCharacterProperty( ) {
    return configuration.getCharacterProperty();
  }

  /**
   * Method returns the value of the property "classProperty".
   * 
   * @return {@link Class} Value of the property "classProperty". The method returns null if no value for the property
   * is defined.
   */
  public Class<?> getClassProperty( ) {
    return configuration.getClassProperty();
  }

  /**
   * Method returns the value of the property "calendarProperty".
   * 
   * @return {@link Calendar} Value of the property "calendarProperty". The method returns null if no value for the
   * property is defined.
   */
  public Calendar getCalendarProperty( ) {
    return configuration.getCalendarProperty();
  }

  /**
   * Method returns the value of the property "localeProperty".
   * 
   * @return {@link Locale} Value of the property "localeProperty". The method returns null if no value for the property
   * is defined.
   */
  public Locale getLocaleProperty( ) {
    return configuration.getLocaleProperty();
  }
}
