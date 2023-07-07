/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class StopPlaceRef extends PlaceRef {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected StopPlaceRef( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected StopPlaceRef( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class <code>StopPlaceRef</code>.
   */
  public static abstract class Builder extends PlaceRef.Builder {
    /**
     * Use {@link StopPlaceRef#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link StopPlaceRef#builder(StopPlaceRef)} instead of private constructor to create new builder.
     */
    protected Builder( StopPlaceRef pObject ) {
      super(pObject);
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
  }
}
