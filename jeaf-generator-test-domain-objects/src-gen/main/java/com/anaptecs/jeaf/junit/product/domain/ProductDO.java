/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.product.domain;

import java.util.Currency;

import com.anaptecs.jeaf.core.api.DomainObjectID;

public class ProductDO extends ProductDOBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  public ProductDO( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public ProductDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * @param pCurrency
   * @return {@link PriceDO}
   */
  @Override
  public PriceDO getPrice( Currency pCurrency ) {
    // TODO: Implement business logic for method.
    return null;
  }
}