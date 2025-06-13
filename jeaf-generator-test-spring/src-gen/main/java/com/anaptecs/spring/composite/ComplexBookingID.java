/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite;

public class ComplexBookingID extends ComplexBookingIDBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected ComplexBookingID( ComplexBookingIDBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects.
   */
  public static ComplexBookingIDBuilder<?, ?> builder( ) {
    return new ComplexBookingIDBuilderImpl();
  }
}