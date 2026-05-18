/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
public class AnotherDataType implements Comparable<AnotherDataType> {
  @NotNull
  public String data;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AnotherDataType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    data = pBuilder.data;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AnotherDataType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>AnotherDataType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String data;

    /**
     * Use {@link AnotherDataType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AnotherDataType#builder(AnotherDataType)} instead of private constructor to create new builder.
     */
    protected Builder( AnotherDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setData(pObject.data);
      }
    }

    /**
     * Method sets attribute {@link #data}.<br/>
     *
     * @param pData Value to which {@link #data} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setData( @MyNotNullProperty String pData ) {
      // Assign value to attribute
      data = pData;
      return this;
    }

    /**
     * Method creates a new instance of class AnotherDataType. The object will be initialized with the values of the
     * builder.
     *
     * @return AnotherDataType Created object. The method never returns null.
     */
    public AnotherDataType build( ) {
      return new AnotherDataType(this);
    }

    /**
     * Method creates a new validated instance of class AnotherDataType. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return AnotherDataType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public AnotherDataType buildValidated( ) throws ConstraintViolationException {
      AnotherDataType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #data}.<br/>
   *
   * @return {@link String} Value to which {@link #data} is set.
   */
  @MyNotNullProperty
  public String getData( ) {
    return data;
  }

  /**
   * Method sets attribute {@link #data}.<br/>
   *
   * @param pData Value to which {@link #data} should be set.
   */
  public void setData( @MyNotNullProperty String pData ) {
    // Assign value to attribute
    data = pData;
  }

  @Override
  public int hashCode( ) {
    return Objects.hashCode(data);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof AnotherDataType == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(data, ((AnotherDataType) pOtherObject).getData());
    }
    return lEquals;
  }

  @Override
  public int compareTo( AnotherDataType pOther ) {
    return this.getData().compareTo(pOther.getData());
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
    lBuilder.append("data: ");
    lBuilder.append(data);
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
   * @return {@link Builder} New builder that can be used to create new AnotherDataType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}