/*
 * Copyright 2004 - 2011 anaptecs GmbH Burgstr. 96, 72764 Reutlingen, Germany All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.internal;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.core.InternalStuffService;

/**
 * Implementation of InternalStuffService.
 */
abstract class InternalStuffServiceImplBase extends InternalServicePort implements InternalStuffService {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String TESTFLUSH_AUTH_TYPE = "testFlush.com.anaptecs.jeaf.junit.core.InternalStuffService";

  /**
   * Initialize object.
   */
  InternalStuffServiceImplBase( Component pComponent ) {
    super(pComponent);
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
    return InternalStuffService.class;
  }
}