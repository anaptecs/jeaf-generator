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
  protected ComplexBookingID( ComplexBookingID.BuilderBase pBuilder ) {
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
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class ComplexBookingID. As the class has readonly attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ComplexBookingID.BuilderBase {
    /**
     * Use {@link ComplexBookingID#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplexBookingID#builder(ComplexBookingID)} instead of protected constructor to create new builder.
     */
    protected Builder( ComplexBookingID pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ComplexBookingID pObject ) {
      return new Builder(pObject);
    }
  }
}