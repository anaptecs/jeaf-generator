
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite;

public class ComplexBookingID extends ComplexBookingIDBase {

  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  protected ComplexBookingID( ComplexBookingID.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  ComplexBookingID( String pBookingID ) {
    super(pBookingID);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  public static Builder builder(String pBookingID) {
    Builder lBuilder = builder();
    lBuilder.setBookingID(pBookingID);
    return lBuilder;
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
