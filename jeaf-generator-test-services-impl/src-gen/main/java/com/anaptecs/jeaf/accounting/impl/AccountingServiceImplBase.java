/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl;

import com.anaptecs.jeaf.accounting.AccountingService;
import com.anaptecs.jeaf.accounting.impl.schufa.SchufaService;
import com.anaptecs.jeaf.accounting.impl.swift.SwiftAccountingService;
import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of AccountingService.
 */
abstract class AccountingServiceImplBase implements AccountingService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String CREATEACCOUNT_AUTH_TYPE = "createAccount.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String CREATECUSTOMER_AUTH_TYPE = "createCustomer.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String CREATEPERSON_AUTH_TYPE = "createPerson.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String GETACCOUNT_AUTH_TYPE = "getAccount.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String GETCUSTOMER_AUTH_TYPE = "getCustomer.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String LOCKACCOUNT_AUTH_TYPE = "lockAccount.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String PERFORMBOOKING_AUTH_TYPE = "performBooking.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String SEARCHCUSTOMERS_AUTH_TYPE =
      "searchCustomers.com.anaptecs.jeaf.accounting.AccountingService";

  public static final String UNLOCK_AUTH_TYPE = "unlock.com.anaptecs.jeaf.accounting.AccountingService";

  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to configuration of the component.
   */
  private final AccountingComponentConfiguration configuration;

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
  AccountingServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
    configuration = new AccountingComponentConfiguration(component.getComponentID());
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
   * The used service SchufaService.
   */
  @JEAFService
  private SchufaService schufaService;

  /**
   * Method returns the SchufaService from which this service depends.
   *
   * @return SchufaService Reference to the SchufaService. The method never returns null after the service has been
   * initialized.
   *
   */
  protected final SchufaService getSchufaService( ) {
    return this.schufaService;
  }

  /**
   * The used service SwiftAccountingService.
   */
  @JEAFService
  private SwiftAccountingService swiftAccountingService;

  /**
   * Method returns the SwiftAccountingService from which this service depends.
   *
   * @return SwiftAccountingService Reference to the SwiftAccountingService. The method never returns null after the
   * service has been initialized.
   *
   */
  protected final SwiftAccountingService getSwiftAccountingService( ) {
    return this.swiftAccountingService;
  }

  /**
   * Method returns the class object of the service that is implemented by this service instance.
   *
   * @return Class Class object of the service interface that is implemented by the service instance. The method never
   * returns null.
   *
   * @see ServiceImplementation#getServiceType()
   */
  public final Class<? extends Service> getServiceType( ) {
    return AccountingService.class;
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
   * Method returns the value of the property "defaultInterrestRate".
   *
   * @return {@link Float} Value of the property "defaultInterrestRate". The method returns null if no value for the
   * property is defined.
   */
  public Float getDefaultInterrestRate( ) {
    return configuration.getDefaultInterrestRate();
  }
}