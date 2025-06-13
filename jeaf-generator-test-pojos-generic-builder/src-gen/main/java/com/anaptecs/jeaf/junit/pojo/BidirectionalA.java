/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class BidirectionalA extends BidirectionalABase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected BidirectionalA( BidirectionalABuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BidirectionalA objects.
   */
  public static BidirectionalABuilder<?, ?> builder( ) {
    return new BidirectionalABuilderImpl();
  }
}