/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;

/**
 * ServiceProxy class for JEAF service DeprecatedService.
 */
@Deprecated
public final class DeprecatedServiceProxy extends ServiceProxy implements DeprecatedService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public DeprecatedServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(DeprecatedService.class, pTransactionBehavior);
  }
}