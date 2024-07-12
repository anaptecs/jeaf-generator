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
public class TopoRef extends PlaceRef {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TopoRef( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TopoRef( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TopoRef objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class TopoRef.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.TopoRef}
   */
  public static TopoRef of( String pName ) {
    TopoRef.Builder lBuilder = TopoRef.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TopoRef</code>.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * Use {@link TopoRef#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link TopoRef#builder(TopoRef)} instead of private constructor to create new builder.
     */
    protected Builder( TopoRef pObject ) {
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
     * Method creates a new instance of class TopoRef. The object will be initialized with the values of the builder.
     *
     * @return TopoRef Created object. The method never returns null.
     */
    public TopoRef build( ) {
      return new TopoRef(this);
    }

    /**
     * Method creates a new validated instance of class TopoRef. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return TopoRef Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TopoRef buildValidated( ) throws ConstraintViolationException {
      TopoRef lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
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
   * @return {@link Builder} New builder that can be used to create new TopoRef objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}