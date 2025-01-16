package com.anaptecs.jeaf.accounting.impl.domain;

import java.math.BigDecimal;

public class AccountBO extends AccountBOBase {
  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected AccountBO( ) {
    // Nothing to do.
  }

  /**
   * Method calculates the current balance of the account. Therefore the the amount of every booking is accumulated.
   *
   * @return {@link BigDecimal}
   */
  @Override
  public BigDecimal calculateBalance( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}