/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class ByteCodeType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  private byte code;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ByteCodeType( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ByteCodeType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ByteCodeType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ByteCodeType objects. The method never returns
   * null.
   */
  public static Builder builder( ByteCodeType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( byte pCode ) {
    Builder lBuilder = builder();
    lBuilder.setCode(pCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>ByteCodeType</code>.
   */
  public static class Builder {
    private byte code;

    /**
     * Use {@link ByteCodeType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ByteCodeType#builder(ByteCodeType)} instead of private constructor to create new builder.
     */
    protected Builder( ByteCodeType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        code = pObject.code;
      }
    }

    /**
     * Method sets the attribute "code".
     * 
     * @param pCode Value to which the attribute "code" should be set.
     */
    public Builder setCode( byte pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class ByteCodeType. The object will be initialized with the values of the
     * builder.
     * 
     * @return ByteCodeType Created object. The method never returns null.
     */
    public ByteCodeType build( ) {
      return new ByteCodeType(this);
    }

    /**
     * Method creates a new validated instance of class ByteCodeType. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ByteCodeType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ByteCodeType buildValidated( ) throws ConstraintViolationException {
      ByteCodeType lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   * 
   * @return byte Value to which {@link #code} is set.
   */
  public byte getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   * 
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( byte pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(code);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof ByteCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((ByteCodeType) pOtherObject).getCode());
    }
    return lEquals;
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
}
