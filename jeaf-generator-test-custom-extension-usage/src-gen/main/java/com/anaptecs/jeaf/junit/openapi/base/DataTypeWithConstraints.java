/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class DataTypeWithConstraints extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "intValue".
   */
  @JEAFCustomAnnotationTest
  public static final String INTVALUE = "intValue";

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Max(value = 9999)
  private int intValue;

  // "int"
  private int intValueXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DataTypeWithConstraints( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeWithConstraints( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    intValue = pBuilder.intValue;
    // "int"
    intValueXYZ = pBuilder.intValueXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeWithConstraints objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>DataTypeWithConstraints</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Max(value = 9999)
    private int intValue;

    // "int"
    private int intValueXYZ = 0;

    /**
     * Use {@link DataTypeWithConstraints#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeWithConstraints#builder(DataTypeWithConstraints)} instead of private constructor to create new
     * builder.
     */
    protected Builder( DataTypeWithConstraints pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setIntValue(pObject.intValue);
      }
    }

    /**
     * Method sets attribute {@link #intValue}.<br/>
     *
     * @param pIntValue Value to which {@link #intValue} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setIntValue( int pIntValue ) {
      // Assign value to attribute
      intValue = pIntValue;
      return this;
    }

    public Builder setIntValueXYZ( int value ) {
      // "int"
      intValueXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class DataTypeWithConstraints. The object will be initialized with the values of
     * the builder.
     *
     * @return DataTypeWithConstraints Created object. The method never returns null.
     */
    public DataTypeWithConstraints build( ) {
      return new DataTypeWithConstraints(this);
    }

    /**
     * Method creates a new validated instance of class DataTypeWithConstraints. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return DataTypeWithConstraints Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DataTypeWithConstraints buildValidated( ) throws ConstraintViolationException {
      DataTypeWithConstraints lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #intValue}.<br/>
   *
   * @return int Value to which {@link #intValue} is set.
   */
  @JEAFCustomAnnotationTest
  public int getIntValue( ) {
    return intValue;
  }

  /**
   * Method sets attribute {@link #intValue}.<br/>
   *
   * @param pIntValue Value to which {@link #intValue} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setIntValue( int pIntValue ) {
    // Assign value to attribute
    intValue = pIntValue;
  }

  public int getIntValueXYZ( ) {
    // "int"
    return intValueXYZ;
  }

  public void setIntValueXYZ( int value ) {
    intValueXYZ = value;
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
    lBuilder.append(pIndent);
    lBuilder.append("intValue: ");
    lBuilder.append(intValue);
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
   * @return {@link Builder} New builder that can be used to create new DataTypeWithConstraints objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}