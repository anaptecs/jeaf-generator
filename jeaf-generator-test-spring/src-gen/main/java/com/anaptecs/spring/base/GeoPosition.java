/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition extends PlaceRef {
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
   * null.
   */
  public static Builder builder( GeoPosition pObject ) {
    return new Builder(pObject);
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
        longitude = pObject.longitude;
        latitude = pObject.latitude;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new GeoPosition objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new GeoPosition objects. The method never returns
     * null.
     */
    public static Builder newBuilder( GeoPosition pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
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
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
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
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
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
}
