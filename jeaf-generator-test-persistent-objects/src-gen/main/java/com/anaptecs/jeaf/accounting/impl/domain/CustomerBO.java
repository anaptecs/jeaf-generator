package com.anaptecs.jeaf.accounting.impl.domain;

public abstract class CustomerBO extends CustomerBOBase {
  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected CustomerBO( ) {
    // Nothing to do.
  }
}