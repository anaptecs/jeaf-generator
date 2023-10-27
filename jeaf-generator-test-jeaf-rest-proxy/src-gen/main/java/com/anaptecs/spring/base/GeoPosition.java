/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition extends PlaceRef {
  /**
   * Default serial version UID.
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

  private int longitude;

  private int latitude;

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
    latitude = pBuilder.latitude;
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
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( GeoPosition pObject ) {
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
   * Convenience method to create new instance of class GeoPosition.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pLongitude Value to which {@link #longitude} should be set.
   *
   * @param pLatitude Value to which {@link #latitude} should be set.
   *
   * @return {@link GeoPosition}
   */
  public static GeoPosition of( String pName, int pLongitude, int pLatitude ) {
    GeoPosition.Builder lBuilder = GeoPosition.builder();
    lBuilder.setName(pName);
    lBuilder.setLongitude(pLongitude);
    lBuilder.setLatitude(pLatitude);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>GeoPosition</code>.
   */
  public static class Builder extends PlaceRef.Builder {
    private int longitude;

    private int latitude;

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
