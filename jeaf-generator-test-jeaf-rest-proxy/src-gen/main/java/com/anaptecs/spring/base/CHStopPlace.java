/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CHStopPlace.Builder.class)
public class CHStopPlace extends StopPlaceRef {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CHStopPlace( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CHStopPlace objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName, MyType pType ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    return lBuilder;
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
    var lBuilder = CHStopPlace.builder();
    lBuilder.setName(pName);
    lBuilder.setType(pType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>CHStopPlace</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder extends StopPlaceRef.Builder {
    /**
     * Use {@link CHStopPlace#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link CHStopPlace#builder(CHStopPlace)} instead of private constructor to create new builder.
     */
    protected Builder( CHStopPlace pObject ) {
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

    /**
     * Method sets association {@link #type}.<br/>
     *
     * @param pType Value to which {@link #type} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setType( MyType pType ) {
      // Call super class implementation.
      super.setType(pType);
      return this;
    }

    /**
     * Method creates a new instance of class CHStopPlace. The object will be initialized with the values of the
     * builder.
     *
     * @return CHStopPlace Created object. The method never returns null.
     */
    public CHStopPlace build( ) {
      return new CHStopPlace(this);
    }

    /**
     * Method creates a new validated instance of class CHStopPlace. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return CHStopPlace Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CHStopPlace buildValidated( ) throws ConstraintViolationException {
      CHStopPlace lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new CHStopPlace objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}