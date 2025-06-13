/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class WrapperArrayServiceObject extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanArray".
   */
  @JEAFCustomAnnotationTest
  public static final String BOOLEANARRAY = "booleanArray";

  // "java.lang.Boolean"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Boolean[] booleanArray;

  // "java.lang.Boolean"
  private int booleanArrayXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WrapperArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WrapperArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanArray = pBuilder.booleanArray;
    // "java.lang.Boolean"
    booleanArrayXYZ = pBuilder.booleanArrayXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WrapperArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>WrapperArrayServiceObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.Boolean"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Boolean[] booleanArray;

    // "java.lang.Boolean"
    private int booleanArrayXYZ = 0;

    /**
     * Use {@link WrapperArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WrapperArrayServiceObject#builder(WrapperArrayServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( WrapperArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBooleanArray(pObject.booleanArray);
      }
    }

    /**
     * Method sets attribute {@link #booleanArray}.<br/>
     *
     * @param pBooleanArray Collection to which {@link #booleanArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setBooleanArray( Boolean[] pBooleanArray ) {
      // Assign value to attribute
      if (pBooleanArray != null) {
        booleanArray = new Boolean[pBooleanArray.length];
        System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
      }
      else {
        booleanArray = null;
      }
      return this;
    }

    public Builder setBooleanArrayXYZ( int value ) {
      // "java.lang.Boolean"
      booleanArrayXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class WrapperArrayServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return WrapperArrayServiceObject Created object. The method never returns null.
     */
    public WrapperArrayServiceObject build( ) {
      return new WrapperArrayServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class WrapperArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return WrapperArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WrapperArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      WrapperArrayServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #booleanArray}.<br/>
   *
   * @return {@link Boolean[]} Value to which {@link #booleanArray} is set.
   */
  @JEAFCustomAnnotationTest
  public Boolean[] getBooleanArray( ) {
    Boolean[] lReturnValue;
    if (booleanArray != null) {
      lReturnValue = new Boolean[booleanArray.length];
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
  @JEAFCustomAnnotationTest
  public void setBooleanArray( Boolean[] pBooleanArray ) {
    // Assign value to attribute
    if (pBooleanArray != null) {
      booleanArray = new Boolean[pBooleanArray.length];
      System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
    }
    else {
      booleanArray = null;
    }
  }

  public int getBooleanArrayXYZ( ) {
    // "java.lang.Boolean"
    return booleanArrayXYZ;
  }

  public void setBooleanArrayXYZ( int value ) {
    booleanArrayXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
   * @return {@link Builder} New builder that can be used to create new WrapperArrayServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}