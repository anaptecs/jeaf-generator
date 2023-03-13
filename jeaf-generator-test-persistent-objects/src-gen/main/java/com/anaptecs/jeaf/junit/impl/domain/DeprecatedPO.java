package com.anaptecs.jeaf.junit.impl.domain;

public class DeprecatedPO extends DeprecatedPOBase {
  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected DeprecatedPO( ) {
    // Nothing to do.
  }

  /**
   */
  @Deprecated
  @Override
  public void doSomethingDeprecated( ) {
    // TODO: Implement business logic for method.
  }

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String doSomething( int pParam1, @Deprecated int pParam2 ) {
    // TODO: Implement business logic for method.
    return null;
  }
}