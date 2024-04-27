/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

public class GeoPosition extends PlaceRef {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "longitude".
   */
  public static final String LONGITUDE = "longitude";

  /**
   * Constant for the name of attribute "latitude".
   */
  public static final String LATITUDE = "latitude";

  // "int"
  @ClassPropertyDeclaration
  private int longitude;

  // "int"
  private int longitudeXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  private int latitude;

  // "int"
  private int latitudeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GeoPosition( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GeoPosition( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    longitude = pBuilder.longitude;
    // "int"
    longitudeXYZ = pBuilder.longitudeXYZ;
    latitude = pBuilder.latitude;
    // "int"
    latitudeXYZ = pBuilder.latitudeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>GeoPosition</code>.
   */
  public static class Builder extends PlaceRef.Builder {
    // "int"
    @BuilderPropertyDeclaration
    private int longitude;

    // "int"
    private int longitudeXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    private int latitude;

    // "int"
    private int latitudeXYZ = 0;

    /**
     * Use {@link GeoPosition#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link GeoPosition#builder(GeoPosition)} instead of private constructor to create new builder.
     */
    protected Builder( GeoPosition pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setLongitude(pObject.longitude);
        this.setLatitude(pObject.latitude);
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
    public Builder setLongitude( int pLongitude ) {
      // Assign value to attribute
      longitude = pLongitude;
      return this;
    }

    public Builder setLongitudeXYZ( int value ) {
      // "int"
      longitudeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #latitude}.<br/>
     *
     * @param pLatitude Value to which {@link #latitude} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLatitude( int pLatitude ) {
      // Assign value to attribute
      latitude = pLatitude;
      return this;
    }

    public Builder setLatitudeXYZ( int value ) {
      // "int"
      latitudeXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class GeoPosition. The object will be initialized with the values of the
     * builder.
     *
     * @return GeoPosition Created object. The method never returns null.
     */
    public GeoPosition build( ) {
      return new GeoPosition(this);
    }

    /**
     * Method creates a new validated instance of class GeoPosition. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return GeoPosition Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public GeoPosition buildValidated( ) throws ConstraintViolationException {
      GeoPosition lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #longitude}.<br/>
   *
   * @return int Value to which {@link #longitude} is set.
   */
  public int getLongitude( ) {
    return longitude;
  }

  /**
   * Method sets attribute {@link #longitude}.<br/>
   *
   * @param pLongitude Value to which {@link #longitude} should be set.
   */
  public void setLongitude( int pLongitude ) {
    // Assign value to attribute
    longitude = pLongitude;
  }

  public int getLongitudeXYZ( ) {
    // "int"
    return longitudeXYZ;
  }

  public void setLongitudeXYZ( int value ) {
    longitudeXYZ = value;
  }

  /**
   * Method returns attribute {@link #latitude}.<br/>
   *
   * @return int Value to which {@link #latitude} is set.
   */
  public int getLatitude( ) {
    return latitude;
  }

  /**
   * Method sets attribute {@link #latitude}.<br/>
   *
   * @param pLatitude Value to which {@link #latitude} should be set.
   */
  public void setLatitude( int pLatitude ) {
    // Assign value to attribute
    latitude = pLatitude;
  }

  public int getLatitudeXYZ( ) {
    // "int"
    return latitudeXYZ;
  }

  public void setLatitudeXYZ( int value ) {
    latitudeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("longitude: ");
    lBuilder.append(longitude);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("latitude: ");
    lBuilder.append(latitude);
    lBuilder.append(System.lineSeparator());
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
