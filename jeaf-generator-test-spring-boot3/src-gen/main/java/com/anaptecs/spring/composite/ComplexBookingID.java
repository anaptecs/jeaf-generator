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
  protected ComplexBookingID( ComplexBookingID.BuilderBase pBuilder ) {
    super(pBuilder);
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
  }
}