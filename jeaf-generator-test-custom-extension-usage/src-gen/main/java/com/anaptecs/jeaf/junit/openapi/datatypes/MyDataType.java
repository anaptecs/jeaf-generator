/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.datatypes;

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
public class MyDataType extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "code".
   */
  @JEAFCustomAnnotationTest
  public static final String CODE = "code";

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String code;

  // "String"
  private int codeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MyDataType( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyDataType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
    // "String"
    codeXYZ = pBuilder.codeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyDataType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>MyDataType</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String code;

    // "String"
    private int codeXYZ = 0;

    /**
     * Use {@link MyDataType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyDataType#builder(MyDataType)} instead of private constructor to create new builder.
     */
    protected Builder( MyDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    public Builder setCodeXYZ( int value ) {
      // "String"
      codeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class MyDataType. The object will be initialized with the values of the builder.
     *
     * @return MyDataType Created object. The method never returns null.
     */
    public MyDataType build( ) {
      return new MyDataType(this);
    }

    /**
     * Method creates a new validated instance of class MyDataType. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return MyDataType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MyDataType buildValidated( ) throws ConstraintViolationException {
      MyDataType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link String} Value to which {@link #code} is set.
   */
  @JEAFCustomAnnotationTest
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setCode( String pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  public int getCodeXYZ( ) {
    // "String"
    return codeXYZ;
  }

  public void setCodeXYZ( int value ) {
    codeXYZ = value;
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
    lBuilder.append("code: ");
    lBuilder.append(code);
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
   * @return {@link Builder} New builder that can be used to create new MyDataType objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}