/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ComplexBookingID extends ComplexBookingIDBase {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexBookingID( ) {
  }

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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects. The method never
   * returns null.
   */
  public static Builder builder( ComplexBookingID pObject ) {
    return new Builder(pObject);
  }

  public static Builder builder( String pBookingID ) {
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