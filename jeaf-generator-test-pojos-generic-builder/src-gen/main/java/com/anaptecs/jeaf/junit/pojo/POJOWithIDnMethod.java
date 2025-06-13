/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class POJOWithIDnMethod extends POJOWithIDnMethodBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected POJOWithIDnMethod( POJOWithIDnMethodBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects.
   */
  public static POJOWithIDnMethodBuilder<?, ?> builder( ) {
    return new POJOWithIDnMethodBuilderImpl();
  }

  /**
   * @return boolean
   */
  @Override
  public boolean doSomethingFunny( ) {
    // TODO: Implement business logic for method.
    return false;
  }
}