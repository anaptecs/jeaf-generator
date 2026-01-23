/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
public class OptionalDataType {
  /**
   * Constant for the name of attribute "optionalCode".
   */
  public static final String OPTIONALCODE = "optionalCode";

  private final String optionalCode;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected OptionalDataType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    optionalCode = pBuilder.optionalCode;
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  private OptionalDataType( String pOptionalCode ) {
    optionalCode = pOptionalCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new OptionalDataType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class OptionalDataType.
   *
   *
   * @param pOptionalCode Value to which {@link #optionalCode} should be set.
   *
   * @return {@link OptionalDataType}
   */
  public static OptionalDataType of( String pOptionalCode ) {
    return new OptionalDataType(pOptionalCode);
  }

  /**
   * Class implements builder to create a new instance of class <code>OptionalDataType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String optionalCode;

    /**
     * Use {@link OptionalDataType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link OptionalDataType#builder(OptionalDataType)} instead of private constructor to create new builder.
     */
    protected Builder( OptionalDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setOptionalCode(pObject.optionalCode);
      }
    }

    /**
     * Method sets attribute {@link #optionalCode}.<br/>
     *
     * @param pOptionalCode Value to which {@link #optionalCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setOptionalCode( String pOptionalCode ) {
      // Assign value to attribute
      optionalCode = pOptionalCode;
      return this;
    }

    /**
     * Method creates a new instance of class OptionalDataType. The object will be initialized with the values of the
     * builder.
     *
     * @return OptionalDataType Created object. The method never returns null.
     */
    public OptionalDataType build( ) {
      return new OptionalDataType(this);
    }

    /**
     * Method creates a new validated instance of class OptionalDataType. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return OptionalDataType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public OptionalDataType buildValidated( ) throws ConstraintViolationException {
      OptionalDataType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #optionalCode}.<br/>
   *
   * @return {@link String} Value to which {@link #optionalCode} is set.
   */
  public String getOptionalCode( ) {
    return optionalCode;
  }

  @Override
  public int hashCode( ) {
    return Objects.hashCode(optionalCode);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof OptionalDataType == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(optionalCode, ((OptionalDataType) pOtherObject).getOptionalCode());
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
    lBuilder.append("optionalCode: ");
    lBuilder.append(optionalCode);
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
   * @return {@link Builder} New builder that can be used to create new OptionalDataType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}