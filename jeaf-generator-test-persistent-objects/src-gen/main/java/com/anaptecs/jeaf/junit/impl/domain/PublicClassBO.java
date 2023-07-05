package com.anaptecs.jeaf.junit.impl.domain;

@Deprecated
public class PublicClassBO extends PublicClassBOBase {
  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected PublicClassBO( ) {
    // Nothing to do.
  }
}