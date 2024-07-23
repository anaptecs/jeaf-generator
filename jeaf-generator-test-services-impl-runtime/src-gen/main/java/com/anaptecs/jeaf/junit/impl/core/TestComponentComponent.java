/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.spi.CommunicationProtocol;
import com.anaptecs.jeaf.core.spi.ComponentImplementation;
import com.anaptecs.jeaf.core.spi.Layer;
import com.anaptecs.jeaf.core.spi.ServiceChannelInterceptor;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.junit.core.JEAFTestService;
import com.anaptecs.jeaf.junit.core.RequiredService_1;
import com.anaptecs.jeaf.junit.core.RequiredService_2;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.common.ComponentID;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Class represents the component TestComponent
 *
 */
public final class TestComponentComponent implements ComponentImplementation {
  /**
   * Constant for the name of the component.
   */
  private static final String COMPONENT_NAME = "TestComponent";

  /**
   * Constant for the description of the component.
   */
  public static final String COMPONENT_DESCRIPTION = "";

  /**
   * Constant defines the name of the JPA persistence unit that is used by the component implementation.
   */
  public static final String PERSISTENCE_UNIT_NAME = "";

  /**
   * Constant defines the JNDI name to which the entity manager of the component implementation is bound.
   */
  public static final String ENTITY_MANAGER_JNDI = "";

  /**
   * Reference to the object that identifies this component. The reference is never null.
   */
  static final ComponentID COMPONENT_ID;

  /**
   * Attribute defines the name of the component.
   */
  private final String name;

  /**
   * Description of the component as it is documented within the UML model.
   */
  private final String description;

  /**
   * Reference to trace object that is used for all traces of this component and its provided services. The reference is
   * never null.
   */
  public static final Trace TRACE;

  /**
   * Attribute defines whether this component uses JPA to store data or not.
   */
  private final boolean usesPersistenceUnit;

  /**
   * Attribute contains the name of the persistence unit that is used by this component.
   */
  private final String persistenceUnitName;

  /**
   * Reference to the class object of all services that are provided by this component. This also includes services that
   * are provided by ports of the component.
   */
  private final Collection<Class<? extends Service>> providedServices;

  /**
   * Reference to the class object of all services that are required by this component. This also includes services that
   * are required by ports of the component.
   */
  private final Collection<Class<? extends Service>> requiredServices;

  /**
   * Transactional behavior of all services of the component.
   */
  private final TransactionBehavior transactionBehavior;

  /**
   * Attribute defines if JEAF Security will be used for this component and all its services.
   */
  private final boolean usesJEAFSecurity;

  /**
   * Layer to which this component belongs to.
   */
  private final Layer layer;

  /**
   * Communication protocol through which services of the component can be used.
   */
  private final CommunicationProtocol communicationProtocol;

  /**
   * Set contains all service channel interceptors that are specific to this component. The reference is never null.
   */
  private final Set<ServiceChannelInterceptor> interceptors;

  /**
   * Reference to configuration of this component.
   */
  private final TestComponentComponentConfiguration configuration;
  /**
   * Static initializer is used to create the components ComponentID object and its trace object.
   */
  static {
    // Create Component ID and trace object.
    Package lBasePackage = TestComponentComponent.class.getPackage();
    COMPONENT_ID = new ComponentID(COMPONENT_NAME, lBasePackage.getName());
    TRACE = XFun.getTraceProvider().getTrace(COMPONENT_ID);
  }

  /**
   * In order to avoid direct instantiation of this class the constructor is set to package visibility.
   */
  TestComponentComponent( ) {
    // Set component information.
    name = COMPONENT_NAME;
    description = COMPONENT_DESCRIPTION;
    TRACE.write(MessageConstants.INITIALIZED_TRACING, new String[] { name });
    // Define persistence settings.
    usesPersistenceUnit = false;
    persistenceUnitName = null;
    // Define transactional behavior and communication protocol.
    transactionBehavior = TransactionBehavior.REQUIRED;
    layer = Layer.INTEGRATION_LAYER;
    communicationProtocol = CommunicationProtocol.LOCAL_EJB;
    // Define security mechanism.
    usesJEAFSecurity = false;
    // Create new collection with the class objects of all provided services.
    Collection<Class<? extends Service>> lProvidedServices = new ArrayList<Class<? extends Service>>();
    lProvidedServices.add(JEAFTestService.class);
    providedServices = Collections.unmodifiableCollection(lProvidedServices);
    // Create new collection with the class objects of all required services.
    Collection<Class<? extends Service>> lRequiredServices = new ArrayList<Class<? extends Service>>();
    lRequiredServices.add(RequiredService_1.class);
    lRequiredServices.add(RequiredService_2.class);
    requiredServices = Collections.unmodifiableCollection(lRequiredServices);
    // Create interceptors.
    Set<ServiceChannelInterceptor> lInterceptors = new HashSet<ServiceChannelInterceptor>();
    // Create all service channel interceptors that are specific to this component.
    interceptors = Collections.unmodifiableSet(lInterceptors);
    // Create object to access configuration of this component.
    configuration = new TestComponentComponentConfiguration(COMPONENT_ID);
  }

  /**
   * Method returns an object that can be used to identify this component.
   *
   * @return {@link ComponentID} ID of this component. The method never returns null.
   *
   * @see com.anaptecs.jeaf.core.api.Component#getComponentID()
   */
  @Override
  public ComponentID getComponentID( ) {
    return COMPONENT_ID;
  }

  /**
   * Method returns the name of the component.
   *
   * @return String Name of the component. The method never returns null.
   *
   * @see Component#getName()
   */
  @Override
  public String getName( ) {
    return name;
  }

  /**
   * Method returns the description of the component.
   *
   * @return {@link String} Description of the component. The method returns null if no description was defined.
   *
   * @see com.anaptecs.jeaf.core.api.Component#getDescription()
   */
  @Override
  public String getDescription( ) {
    return description;
  }

  /**
   * Method returns the tracing object of this component.
   *
   * @return {@link Trace} Tracing object of this component. The method never returns null.
   */
  @Override
  public Trace getTrace( ) {
    return TRACE;
  }

  /**
   * Method returns the class objects of all services that are provided by this component. This also includes services
   * that are provided by ports of the component.
   *
   * @return {@link Collection} Class objects of all service interfaces that are provided by this component. The method
   * never returns null.
   */
  @Override
  public final Collection<Class<? extends Service>> getProvidedServices( ) {
    return providedServices;
  }

  /**
   * Method returns the class objects of all services that are required by this component. This also includes services
   * that are required by ports of the component.
   *
   * @return {@link Collection} Class objects of all service interfaces that are required by this component. The method
   * never returns null.
   */
  @Override
  public Collection<Class<? extends Service>> getRequiredServices( ) {
    return requiredServices;
  }

  /**
   * Method returns the transactional behavior of the component.
   *
   * @return {@link TransactionBehavior} Transactional behavior of all services of the component. The method never
   * returns null.
   *
   * @see ComponentImplementation#getTransactionBehavior()
   */
  @Override
  public TransactionBehavior getTransactionBehavior( ) {
    return transactionBehavior;
  }

  /**
   * Method returns the layer to which this component belongs to.
   *
   * @return {@link Layer} Layer to which this component belongs to. The method never returns null.
   *
   * @see com.anaptecs.jeaf.core.api.Component#getLayer()
   */
  @Override
  public Layer getLayer( ) {
    return layer;
  }

  /**
   * Method returns the communication protocol through which services of the component can be used.
   *
   * @return {@link CommunicationProtocol} Communication protocol required to use services of this component.
   *
   * @see com.anaptecs.jeaf.core.spi.Component#getCommunicationProtocol()
   */
  @Override
  public CommunicationProtocol getCommunicationProtocol( ) {
    return communicationProtocol;
  }

  /**
   * Method returns whether the component implementation uses a JPA persistence unit to store data or not.
   *
   * @return boolean The method returns true if the component implementation uses a JPA persistence unit and false in
   * all other cases.
   *
   * @see #getPersistenceUnitName()
   */
  @Override
  public boolean hasPersistenceUnit( ) {
    return usesPersistenceUnit;
  }

  /**
   * Method returns the name of the JPA persistence unit that is used by the component implementation.
   *
   * @return String Name of the persistence unit. The method never returns null. The method will throw an exception if
   * the component implementation does not use a JPA persistence unit.
   *
   * @see #hasPersistenceUnit()
   */
  @Override
  public String getPersistenceUnitName( ) {
    if (usesPersistenceUnit == true) {
      return persistenceUnitName;
    }
    else {
      ErrorCode lErrorCode = MessageConstants.COMPONENT_DOES_NOT_USE_PERSISTENCE_UNIT;
      String[] lParams = new String[] { name, "getPersistenceUnitName()" };
      throw new JEAFSystemException(lErrorCode, lParams);
    }
  }

  /**
   * Method returns whether the component uses JEAFs security mechanism for its services or not. If JEAF security is
   * used then a security check will be performed before each service call.
   *
   * @return boolean Method returns true if this component uses JEAFs security mechanism and false in all other cases.
   */
  @Override
  public boolean isJEAFSecurityUsed( ) {
    return usesJEAFSecurity;
  }

  /**
   * Method returns a set of service channel interceptors that are specific for the implementation of this component.
   *
   * @return {@link Set} Set of component specific interceptors. The method never returns null.
   */
  @Override
  public Set<ServiceChannelInterceptor> getServiceChannelInterceptors( ) {
    return interceptors;
  }

  /**
   * Method returns the configuration of this component.
   *
   * @return {@link TestComponentComponentConfiguration} Object providing access to the configuration of this component.
   * The method never returns null.
   */
  public TestComponentComponentConfiguration getConfiguration( ) {
    return configuration;
  }
}