/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.tx.impl;

import com.anaptecs.jeaf.core.annotations.JEAFService;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.tx.TransactionHandlingService;
import com.anaptecs.jeaf.junit.tx.TxMandatoryService;
import com.anaptecs.jeaf.junit.tx.TxNeverService;
import com.anaptecs.jeaf.junit.tx.TxNotSupportedService;
import com.anaptecs.jeaf.junit.tx.TxRequiredService;
import com.anaptecs.jeaf.junit.tx.TxRequiresNewService;
import com.anaptecs.jeaf.junit.tx.TxSupportedService;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of TransactionHandlingService.
 */
abstract class TransactionHandlingServiceImplBase implements TransactionHandlingService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String TESTINDIRECTINVOCATIONS_AUTH_TYPE =
      "testIndirectInvocations.com.anaptecs.jeaf.junit.tx.TransactionHandlingService";

  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to to trace object of the component to which this service instance belongs to. The reference is never
   * null since the trace object is set in the constructor. The reference is visible to sub classes in order to make
   * tracing as easy as possible.
   */
  final Trace trace;

  /**
   * Initialize object.
   */
  TransactionHandlingServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
  }

  /**
   * The used service TxMandatoryService.
   */
  @JEAFService
  private TxMandatoryService txMandatoryService;

  /**
   * Method returns the TxMandatoryService from which this service depends.
   *
   * @return TxMandatoryService Reference to the TxMandatoryService. The method never returns null after the service has
   * been initialized.
   *
   */
  protected final TxMandatoryService getTxMandatoryService( ) {
    return this.txMandatoryService;
  }

  /**
   * The used service TxNeverService.
   */
  @JEAFService
  private TxNeverService txNeverService;

  /**
   * Method returns the TxNeverService from which this service depends.
   *
   * @return TxNeverService Reference to the TxNeverService. The method never returns null after the service has been
   * initialized.
   *
   */
  protected final TxNeverService getTxNeverService( ) {
    return this.txNeverService;
  }

  /**
   * The used service TxNotSupportedService.
   */
  @JEAFService
  private TxNotSupportedService txNotSupportedService;

  /**
   * Method returns the TxNotSupportedService from which this service depends.
   *
   * @return TxNotSupportedService Reference to the TxNotSupportedService. The method never returns null after the
   * service has been initialized.
   *
   */
  protected final TxNotSupportedService getTxNotSupportedService( ) {
    return this.txNotSupportedService;
  }

  /**
   * The used service TxRequiredService.
   */
  @JEAFService
  private TxRequiredService txRequiredService;

  /**
   * Method returns the TxRequiredService from which this service depends.
   *
   * @return TxRequiredService Reference to the TxRequiredService. The method never returns null after the service has
   * been initialized.
   *
   */
  protected final TxRequiredService getTxRequiredService( ) {
    return this.txRequiredService;
  }

  /**
   * The used service TxRequiresNewService.
   */
  @JEAFService
  private TxRequiresNewService txRequiresNewService;

  /**
   * Method returns the TxRequiresNewService from which this service depends.
   *
   * @return TxRequiresNewService Reference to the TxRequiresNewService. The method never returns null after the service
   * has been initialized.
   *
   */
  protected final TxRequiresNewService getTxRequiresNewService( ) {
    return this.txRequiresNewService;
  }

  /**
   * The used service TxSupportedService.
   */
  @JEAFService
  private TxSupportedService txSupportedService;

  /**
   * Method returns the TxSupportedService from which this service depends.
   *
   * @return TxSupportedService Reference to the TxSupportedService. The method never returns null after the service has
   * been initialized.
   *
   */
  protected final TxSupportedService getTxSupportedService( ) {
    return this.txSupportedService;
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
    return TransactionHandlingService.class;
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
}