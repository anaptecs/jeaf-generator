/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class SwissGeoPosition extends GeoPosition {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SwissGeoPosition( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SwissGeoPosition( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class SwissGeoPosition. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends GeoPosition.Builder {
    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(SwissGeoPosition)} instead of private constructor to create new builder.
     */
    protected Builder( SwissGeoPosition pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new SwissGeoPosition objects. The method never
     * returns null.
     */
    public static Builder newBuilder( SwissGeoPosition pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "longitude".
     * 
     * @param pLongitude Value to which the attribute "longitude" should be set.
     */
    @Override
    public Builder setLongitude( int pLongitude ) {
      // Call super class implementation.
      super.setLongitude(pLongitude);
      return this;
    }

    /**
     * Method sets the attribute "latitude".
     * 
     * @param pLatitude Value to which the attribute "latitude" should be set.
     */
    @Override
    public Builder setLatitude( int pLatitude ) {
      // Call super class implementation.
      super.setLatitude(pLatitude);
      return this;
    }

    /**
     * Method creates a new instance of class SwissGeoPosition. The object will be initialized with the values of the
     * builder.
     * 
     * @return SwissGeoPosition Created object. The method never returns null.
     */
    public SwissGeoPosition build( ) {
      return new SwissGeoPosition(this);
    }

    /**
     * Method creates a new validated instance of class SwissGeoPosition. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return SwissGeoPosition Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SwissGeoPosition buildValidated( ) throws ConstraintViolationException {
      SwissGeoPosition lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   * 
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder().toString();
  }
}
