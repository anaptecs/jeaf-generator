/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite;

import java.util.List;

import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingType;

public class ComplexBookingID extends ComplexBookingIDBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected ComplexBookingID( ComplexBookingIDBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  ComplexBookingID( long pInternalID, String pReferenceID, List<BookingID> pBookingIDs,
      ComplexBookingType pComplexBookingType, Integer pAnotherID ) {
    super(pInternalID, pReferenceID, pBookingIDs, pComplexBookingType, pAnotherID);
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