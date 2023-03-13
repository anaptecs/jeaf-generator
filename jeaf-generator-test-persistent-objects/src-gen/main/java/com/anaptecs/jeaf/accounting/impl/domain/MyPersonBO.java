package com.anaptecs.jeaf.accounting.impl.domain;

public class MyPersonBO extends MyPersonBOBase {
  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected MyPersonBO( ) {
    // Nothing to do.
  }

  /**
   * @return {@link Integer}
   */
  @Override
  public Integer calculateAge( ) {
    // TODO: Implement business logic for method.
    return null;
  }

  /**
   * @return {@link String}
   */
  @Override
  public String getFullName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}