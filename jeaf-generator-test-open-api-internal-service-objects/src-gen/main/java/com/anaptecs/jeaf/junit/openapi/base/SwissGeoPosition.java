/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@Valid
public class SwissGeoPosition extends GeoPosition {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SwissGeoPosition( ) {
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
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SwissGeoPosition objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SwissGeoPosition objects. The method never
   * returns null.
   */
  public static Builder builder( SwissGeoPosition pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName, int pLongitude, int pLatitude ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    lBuilder.setLongitude(pLongitude);
    lBuilder.setLatitude(pLatitude);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>SwissGeoPosition</code>.
   */
  public static class Builder extends GeoPosition.Builder {
    /**
     * Use {@link SwissGeoPosition#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SwissGeoPosition#builder(SwissGeoPosition)} instead of private constructor to create new builder.
     */
    protected Builder( SwissGeoPosition pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets attribute {@link #longitude}.<br/>
     *
     * @param pLongitude Value to which {@link #longitude} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setLongitude( int pLongitude ) {
      // Call super class implementation.
      super.setLongitude(pLongitude);
      return this;
    }

    /**
     * Method sets attribute {@link #latitude}.<br/>
     *
     * @param pLatitude Value to which {@link #latitude} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
      SwissGeoPosition lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
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
    return this.toStringBuilder("").toString();
  }
}
