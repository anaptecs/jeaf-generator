/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class PlainPOJO extends PlainPOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected PlainPOJO( PlainPOJOBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PlainPOJO objects.
   */
  public static PlainPOJOBuilder<?, ?> builder( ) {
    return new PlainPOJOBuilderImpl();
  }

  /**
   */
  @Deprecated
  @Override
  public void doDeprectedStuff( ) {
    // TODO: Implement business logic for method.
  }

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @param pParam2
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String doSomething( @Deprecated int pParam1, int pParam2 ) {
    // TODO: Implement business logic for method.
    return null;
  }
}