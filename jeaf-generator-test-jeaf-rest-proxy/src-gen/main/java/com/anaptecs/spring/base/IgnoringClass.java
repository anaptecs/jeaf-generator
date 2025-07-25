/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = IgnoringClass.Builder.class)
public class IgnoringClass implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "age".
   */
  public static final String AGE = "age";

  private Integer age;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IgnoringClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    age = pBuilder.age;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( Integer pAge ) {
    Builder lBuilder = builder();
    lBuilder.setAge(pAge);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class IgnoringClass.
   *
   *
   * @param pAge Value to which {@link #age} should be set.
   *
   * @return {@link IgnoringClass}
   */
  public static IgnoringClass of( Integer pAge ) {
    var lBuilder = IgnoringClass.builder();
    lBuilder.setAge(pAge);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>IgnoringClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private Integer age;

    /**
     * Use {@link IgnoringClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link IgnoringClass#builder(IgnoringClass)} instead of private constructor to create new builder.
     */
    protected Builder( IgnoringClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAge(pObject.age);
      }
    }

    /**
     * Method sets attribute {@link #age}.<br/>
     *
     * @param pAge Value to which {@link #age} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAge( Integer pAge ) {
      // Assign value to attribute
      age = pAge;
      return this;
    }

    /**
     * Method creates a new instance of class IgnoringClass. The object will be initialized with the values of the
     * builder.
     *
     * @return IgnoringClass Created object. The method never returns null.
     */
    public IgnoringClass build( ) {
      return new IgnoringClass(this);
    }

    /**
     * Method creates a new validated instance of class IgnoringClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return IgnoringClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public IgnoringClass buildValidated( ) throws ConstraintViolationException {
      IgnoringClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #age}.<br/>
   *
   * @return {@link Integer} Value to which {@link #age} is set.
   */
  public Integer getAge( ) {
    return age;
  }

  /**
   * Method sets attribute {@link #age}.<br/>
   *
   * @param pAge Value to which {@link #age} should be set.
   */
  public void setAge( Integer pAge ) {
    // Assign value to attribute
    age = pAge;
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
    lBuilder.append("age: ");
    lBuilder.append(age);
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
   * @return {@link Builder} New builder that can be used to create new IgnoringClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}