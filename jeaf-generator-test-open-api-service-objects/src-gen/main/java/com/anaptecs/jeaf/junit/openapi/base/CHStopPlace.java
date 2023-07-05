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
public class CHStopPlace extends StopPlaceRef {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CHStopPlace( ) {
  }

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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new CHStopPlace objects. The method never returns
   * null.
   */
  public static Builder builder( CHStopPlace pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>CHStopPlace</code>.
   */
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
}
