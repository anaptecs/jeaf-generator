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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PrimitiveArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanArray".
   */
  public static final String BOOLEANARRAY = "booleanArray";

  /**
   * 
   */
  private boolean[] booleanArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrimitiveArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrimitiveArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanArray = pBuilder.booleanArray;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PrimitiveArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrimitiveArrayServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( PrimitiveArrayServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PrimitiveArrayServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean[] booleanArray;

    /**
     * Use {@link PrimitiveArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrimitiveArrayServiceObject#builder(PrimitiveArrayServiceObject)} instead of private constructor to
     * create new builder.
     */
    protected Builder( PrimitiveArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        booleanArray = pObject.booleanArray;
      }
    }

    /**
     * Method sets the attribute "booleanArray".
     * 
     * @param pBooleanArray Value to which the attribute "booleanArray" should be set.
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
     * Method creates a new instance of class PrimitiveArrayServiceObject. The object will be initialized with the
     * values of the builder.
     * 
     * @return PrimitiveArrayServiceObject Created object. The method never returns null.
     */
    public PrimitiveArrayServiceObject build( ) {
      return new PrimitiveArrayServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class PrimitiveArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return PrimitiveArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrimitiveArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      PrimitiveArrayServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "booleanArray".
   * 
   * 
   * @return Boolean Value to which the attribute "booleanArray" is set.
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
   * Method sets the attribute "booleanArray".
   * 
   * 
   * @param pBooleanArray Value to which the attribute "booleanArray" should be set.
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
}
