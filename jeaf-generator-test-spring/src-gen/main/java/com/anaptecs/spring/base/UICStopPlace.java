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
@JsonDeserialize(builder = UICStopPlace.UICStopPlaceBuilderImpl.class)
public class UICStopPlace extends StopPlaceRef {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICStopPlace( UICStopPlaceBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new UICStopPlace objects.
   */
  public static UICStopPlaceBuilder<?, ?> builder( ) {
    return new UICStopPlaceBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class UICStopPlace.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pType Value to which {@link #type} should be set.
   *
   * @return {@link UICStopPlace}
   */
  public static UICStopPlace of( String pName, MyType pType ) {
    UICStopPlaceBuilder<?, ?> lBuilder = UICStopPlace.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>UICStopPlace</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class UICStopPlaceBuilder<T extends UICStopPlace, S extends UICStopPlaceBuilder<T, S>>
      extends StopPlaceRefBuilder<T, S> {
    /**
     * Use {@link UICStopPlaceBuilder#builder()} instead of private constructor to create new builder.
     */
    protected UICStopPlaceBuilder( ) {
      super();
    }

    /**
     * Use {@link UICStopPlaceBuilder#builder(UICStopPlace)} instead of private constructor to create new builder.
     */
    protected UICStopPlaceBuilder( UICStopPlace pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class UICStopPlace. The object will be initialized with the values of the
     * builder.
     *
     * @return UICStopPlace Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class UICStopPlaceBuilderImpl extends UICStopPlaceBuilder<UICStopPlace, UICStopPlaceBuilderImpl> {
    protected UICStopPlaceBuilderImpl( ) {
    }

    protected UICStopPlaceBuilderImpl( UICStopPlace pObject ) {
      super(pObject);
    }

    @Override
    protected UICStopPlaceBuilderImpl self( ) {
      return this;
    }

    @Override
    public UICStopPlace build( ) {
      UICStopPlace lObject = new UICStopPlace(this);
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
   * @return {@link Builder} New builder that can be used to create new UICStopPlace objects. The method never returns
   * null.
   */
  public UICStopPlaceBuilder<?, ?> toBuilder( ) {
    return new UICStopPlaceBuilderImpl(this);
  }
}