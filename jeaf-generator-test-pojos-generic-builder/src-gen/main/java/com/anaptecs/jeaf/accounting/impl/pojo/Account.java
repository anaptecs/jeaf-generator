/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.math.BigDecimal;

public class Account extends AccountBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Account( AccountBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Account objects.
   */
  public static AccountBuilder<?, ?> builder( ) {
    return new AccountBuilderImpl();
  }

  /**
   * @return {@link BigDecimal}
   */
  @Override
  public BigDecimal calcuateBalance( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}