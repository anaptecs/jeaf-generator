/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.jsondefaultimpl;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

/**
 * Second subclass of ChkVehicle.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ChkTruck extends ChkVehicle {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChkTruck( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChkTruck( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChkTruck objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ChkTruck.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link ChkTruck}
   */
  public static ChkTruck of( String pName ) {
    var lBuilder = ChkTruck.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChkTruck</code>.
   */
  public static class Builder extends ChkVehicle.Builder {
    /**
     * Use {@link ChkTruck#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChkTruck#builder(ChkTruck)} instead of private constructor to create new builder.
     */
    protected Builder( ChkTruck pObject ) {
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
     * Method creates a new instance of class ChkTruck. The object will be initialized with the values of the builder.
     *
     * @return ChkTruck Created object. The method never returns null.
     */
    public ChkTruck build( ) {
      ChkTruck lObject = new ChkTruck(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ChkTruck. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return ChkTruck Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChkTruck buildValidated( ) throws ConstraintViolationException {
      ChkTruck lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new ChkTruck objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}