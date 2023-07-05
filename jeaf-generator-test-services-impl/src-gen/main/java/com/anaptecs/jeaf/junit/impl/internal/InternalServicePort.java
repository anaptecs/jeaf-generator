/*
 * Copyright 2004 - 2011 anaptecs GmbH Burgstr. 96, 72764 Reutlingen, Germany All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.internal;

import com.anaptecs.jeaf.core.api.Component;

/**
 * Implementation of port InternalServicePort.
 */
abstract class InternalServicePort extends InternalServicePortBase {
  /**
   * Initialize object.
   */
  InternalServicePort( Component pComponent ) {
    super(pComponent);
  }
  // ********************************************************************************************************************
  // *
  // * Add port specific implementation here. This implementation will be available for all services that are provided
  // * by this port.
  // *
  // ********************************************************************************************************************
}