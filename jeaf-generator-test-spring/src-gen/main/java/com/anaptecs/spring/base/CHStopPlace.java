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
@JsonDeserialize(builder = CHStopPlace.CHStopPlaceBuilderImpl.class)
public class CHStopPlace extends StopPlaceRef {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CHStopPlace( CHStopPlaceBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CHStopPlace objects.
   */
  public static CHStopPlaceBuilder<?, ?> builder( ) {
    return new CHStopPlaceBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class CHStopPlace.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pType Value to which {@link #type} should be set.
   *
   * @return {@link CHStopPlace}
   */
  public static CHStopPlace of( String pName, MyType pType ) {
    CHStopPlaceBuilder<?, ?> lBuilder = CHStopPlace.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>CHStopPlace</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class CHStopPlaceBuilder<T extends CHStopPlace, S extends CHStopPlaceBuilder<T, S>>
      extends StopPlaceRefBuilder<T, S> {
    /**
     * Use {@link CHStopPlaceBuilder#builder()} instead of private constructor to create new builder.
     */
    protected CHStopPlaceBuilder( ) {
      super();
    }

    /**
     * Use {@link CHStopPlaceBuilder#builder(CHStopPlace)} instead of private constructor to create new builder.
     */
    protected CHStopPlaceBuilder( CHStopPlace pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class CHStopPlace. The object will be initialized with the values of the
     * builder.
     *
     * @return CHStopPlace Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class CHStopPlaceBuilderImpl extends CHStopPlaceBuilder<CHStopPlace, CHStopPlaceBuilderImpl> {
    protected CHStopPlaceBuilderImpl( ) {
    }

    protected CHStopPlaceBuilderImpl( CHStopPlace pObject ) {
      super(pObject);
    }

    @Override
    protected CHStopPlaceBuilderImpl self( ) {
      return this;
    }

    @Override
    public CHStopPlace build( ) {
      CHStopPlace lObject = new CHStopPlace(this);
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
   * @return {@link Builder} New builder that can be used to create new CHStopPlace objects. The method never returns
   * null.
   */
  public CHStopPlaceBuilder<?, ?> toBuilder( ) {
    return new CHStopPlaceBuilderImpl(this);
  }
}