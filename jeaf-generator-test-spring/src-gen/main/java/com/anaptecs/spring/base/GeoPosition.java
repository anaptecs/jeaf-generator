/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = GeoPosition.GeoPositionBuilderImpl.class)
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
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected GeoPosition( GeoPositionBuilder<?, ?> pBuilder ) {
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
  public static GeoPositionBuilder<?, ?> builder( ) {
    return new GeoPositionBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class GeoPosition.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pType Value to which {@link #type} should be set.
   *
   * @param pLongitude Value to which {@link #longitude} should be set.
   *
   * @param pLatitude Value to which {@link #latitude} should be set.
   *
   * @return {@link GeoPosition}
   */
  public static GeoPosition of( String pName, MyType pType, int pLongitude, int pLatitude ) {
    GeoPositionBuilder<?, ?> lBuilder = GeoPosition.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    lBuilder.setLongitude(pLongitude);
    lBuilder.setLatitude(pLatitude);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>GeoPosition</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class GeoPositionBuilder<T extends GeoPosition, B extends GeoPositionBuilder<T, B>>
      extends PlaceRefBuilder<T, B> {
    private int longitude;

    private int latitude;

    /**
     * Use {@link GeoPositionBuilder#builder()} instead of private constructor to create new builder.
     */
    protected GeoPositionBuilder( ) {
      super();
    }

    /**
     * Use {@link GeoPositionBuilder#builder(GeoPosition)} instead of private constructor to create new builder.
     */
    protected GeoPositionBuilder( GeoPosition pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setLongitude(pObject.longitude);
        this.setLatitude(pObject.latitude);
      }
    }

    /**
     * Method sets attribute {@link #longitude}.<br/>
     *
     * @param pLongitude Value to which {@link #longitude} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLongitude( int pLongitude ) {
      // Assign value to attribute
      longitude = pLongitude;
      return this.self();
    }

    /**
     * Method sets attribute {@link #latitude}.<br/>
     *
     * @param pLatitude Value to which {@link #latitude} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLatitude( int pLatitude ) {
      // Assign value to attribute
      latitude = pLatitude;
      return this.self();
    }

    /**
     * Method creates a new instance of class GeoPosition. The object will be initialized with the values of the
     * builder.
     *
     * @return GeoPosition Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class GeoPositionBuilderImpl extends GeoPositionBuilder<GeoPosition, GeoPositionBuilderImpl> {
    protected GeoPositionBuilderImpl( ) {
    }

    protected GeoPositionBuilderImpl( GeoPosition pObject ) {
      super(pObject);
    }

    @Override
    protected GeoPositionBuilderImpl self( ) {
      return this;
    }

    @Override
    public GeoPosition build( ) {
      GeoPosition lObject = new GeoPosition(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + longitude;
    lResult = lPrime * lResult + latitude;
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      GeoPosition lOther = (GeoPosition) pObject;
      lEquals = longitude == lOther.longitude && latitude == lOther.latitude;
    }
    return lEquals;
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
  public GeoPositionBuilder<?, ?> toBuilder( ) {
    return new GeoPositionBuilderImpl(this);
  }
}