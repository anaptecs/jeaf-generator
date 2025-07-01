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
@JsonDeserialize(builder = SwissGeoPosition.SwissGeoPositionBuilderImpl.class)
public class SwissGeoPosition extends GeoPosition {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SwissGeoPosition( SwissGeoPositionBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link SwissGeoPositionBuilder} New builder that can be used to create new SwissGeoPosition objects.
   */
  public static SwissGeoPositionBuilder<?, ?> builder( ) {
    return new SwissGeoPositionBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class SwissGeoPosition.
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
   * @return {@link SwissGeoPosition}
   */
  public static SwissGeoPosition of( String pName, MyType pType, int pLongitude, int pLatitude ) {
    var lBuilder = SwissGeoPosition.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    lBuilder.setLongitude(pLongitude);
    lBuilder.setLatitude(pLatitude);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SwissGeoPosition</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SwissGeoPositionBuilder<T extends SwissGeoPosition, B extends SwissGeoPositionBuilder<T, B>>
      extends GeoPositionBuilder<T, B> {
    /**
     * Use {@link SwissGeoPosition#builder()} instead of private constructor to create new builder.
     */
    protected SwissGeoPositionBuilder( ) {
      super();
    }

    /**
     * Use {@link SwissGeoPosition#builder(SwissGeoPosition)} instead of private constructor to create new builder.
     */
    protected SwissGeoPositionBuilder( SwissGeoPosition pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class SwissGeoPosition. The object will be initialized with the values of the
     * builder.
     *
     * @return SwissGeoPosition Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class SwissGeoPositionBuilderImpl
      extends SwissGeoPositionBuilder<SwissGeoPosition, SwissGeoPositionBuilderImpl> {
    protected SwissGeoPositionBuilderImpl( ) {
    }

    protected SwissGeoPositionBuilderImpl( SwissGeoPosition pObject ) {
      super(pObject);
    }

    @Override
    protected SwissGeoPositionBuilderImpl self( ) {
      return this;
    }

    @Override
    public SwissGeoPosition build( ) {
      SwissGeoPosition lObject = new SwissGeoPosition(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return super.hashCode();
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
      lEquals = true;
    }
    return lEquals;
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link SwissGeoPositionBuilder} New builder that can be used to create new SwissGeoPosition objects. The
   * method never returns null.
   */
  public SwissGeoPositionBuilder<?, ?> toBuilder( ) {
    return new SwissGeoPositionBuilderImpl(this);
  }
}