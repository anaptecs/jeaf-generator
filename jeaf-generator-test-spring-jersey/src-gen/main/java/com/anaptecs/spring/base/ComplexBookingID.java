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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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

  /**
   * Method converts the passed {@link String} into an instance of this object.
   *
   * Please be aware that this method is only intended to be used for deserialization frameworks like JAX-RS. For
   * "normal" object creation builder should be used instead.
   * 
   * @param pInternalID String that should be used to create an instance of this class. The parameter must not be null.
   * @return {@link ComplexBookingID} Instance of the class that matches to the passed string. The method never returns
   * null.
   */
  public static ComplexBookingID valueOf( String pInternalID ) {
    return builder().setInternalID(Long.parseLong(pInternalID)).build();
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