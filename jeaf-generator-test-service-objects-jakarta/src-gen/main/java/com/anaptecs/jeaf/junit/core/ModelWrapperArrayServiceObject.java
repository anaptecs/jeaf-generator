/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class ModelWrapperArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanArray".
   */
  public static final String BOOLEANARRAY = "booleanArray";

  private boolean[] booleanArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ModelWrapperArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ModelWrapperArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanArray = pBuilder.booleanArray;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ModelWrapperArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ModelWrapperArrayServiceObject.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.core.ModelWrapperArrayServiceObject}
   */
  public static ModelWrapperArrayServiceObject of( ) {
    ModelWrapperArrayServiceObject.Builder lBuilder = ModelWrapperArrayServiceObject.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ModelWrapperArrayServiceObject</code>.
   */
  public static class Builder {
    private boolean[] booleanArray;

    /**
     * Use {@link ModelWrapperArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ModelWrapperArrayServiceObject#builder(ModelWrapperArrayServiceObject)} instead of private constructor
     * to create new builder.
     */
    protected Builder( ModelWrapperArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBooleanArray(pObject.booleanArray);
      }
    }

    /**
     * Method sets attribute {@link #booleanArray}.<br/>
     *
     * @param pBooleanArray Value to which {@link #booleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooleanArray( boolean[] pBooleanArray ) {
      // Assign value to attribute
      if (pBooleanArray != null) {
        booleanArray = new boolean[pBooleanArray.length];
        System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
      }
      else {
        booleanArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ModelWrapperArrayServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return ModelWrapperArrayServiceObject Created object. The method never returns null.
     */
    public ModelWrapperArrayServiceObject build( ) {
      ModelWrapperArrayServiceObject lObject = new ModelWrapperArrayServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ModelWrapperArrayServiceObject. The object will be initialized
     * with the values of the builder and validated afterwards.
     *
     * @return ModelWrapperArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ModelWrapperArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      ModelWrapperArrayServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #booleanArray}.<br/>
   *
   * @return boolean Value to which {@link #booleanArray} is set.
   */
  public boolean[] getBooleanArray( ) {
    boolean[] lReturnValue;
    if (booleanArray != null) {
      lReturnValue = new boolean[booleanArray.length];
      System.arraycopy(booleanArray, 0, lReturnValue, 0, booleanArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #booleanArray}.<br/>
   *
   * @param pBooleanArray Value to which {@link #booleanArray} should be set.
   */
  public void setBooleanArray( boolean[] pBooleanArray ) {
    // Assign value to attribute
    if (pBooleanArray != null) {
      booleanArray = new boolean[pBooleanArray.length];
      System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
    }
    else {
      booleanArray = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
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
   * @return {@link Builder} New builder that can be used to create new ModelWrapperArrayServiceObject objects. The
   * method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
