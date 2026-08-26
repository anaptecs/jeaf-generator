/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.generator.annotations.DeprecationNotice;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Deprecated
@DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
@JsonDeserialize(builder = DeprecatedClass.Builder.class)
public class DeprecatedClass {
  /**
   * Constant for the name of attribute "justAProperty".
   */
  public static final String JUSTAPROPERTY = "justAProperty";

  private int justAProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DeprecatedClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    justAProperty = pBuilder.justAProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DeprecatedClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DeprecatedClass.
   *
   *
   * @param pJustAProperty Value to which {@link #justAProperty} should be set.
   *
   * @return {@link DeprecatedClass}
   */
  public static DeprecatedClass of( int pJustAProperty ) {
    var lBuilder = DeprecatedClass.builder();
    lBuilder.setJustAProperty(pJustAProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DeprecatedClass</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  public static class Builder {
    private int justAProperty;

    /**
     * Use {@link DeprecatedClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DeprecatedClass#builder(DeprecatedClass)} instead of private constructor to create new builder.
     */
    protected Builder( DeprecatedClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setJustAProperty(pObject.justAProperty);
      }
    }

    /**
     * Method sets attribute {@link #justAProperty}.<br/>
     *
     * @param pJustAProperty Value to which {@link #justAProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setJustAProperty( int pJustAProperty ) {
      // Assign value to attribute
      justAProperty = pJustAProperty;
      return this;
    }

    /**
     * Method creates a new instance of class DeprecatedClass. The object will be initialized with the values of the
     * builder.
     *
     * @return DeprecatedClass Created object. The method never returns null.
     */
    public DeprecatedClass build( ) {
      return new DeprecatedClass(this);
    }

    /**
     * Method creates a new validated instance of class DeprecatedClass. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return DeprecatedClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DeprecatedClass buildValidated( ) throws ConstraintViolationException {
      DeprecatedClass lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #justAProperty}.<br/>
   *
   * @return int Value to which {@link #justAProperty} is set.
   */
  public int getJustAProperty( ) {
    return justAProperty;
  }

  /**
   * Method sets attribute {@link #justAProperty}.<br/>
   *
   * @param pJustAProperty Value to which {@link #justAProperty} should be set.
   */
  public void setJustAProperty( int pJustAProperty ) {
    // Assign value to attribute
    justAProperty = pJustAProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + justAProperty;
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      DeprecatedClass lOther = (DeprecatedClass) pObject;
      lEquals = justAProperty == lOther.justAProperty;
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
    lBuilder.append("justAProperty: ");
    lBuilder.append(justAProperty);
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
   * @return {@link Builder} New builder that can be used to create new DeprecatedClass objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}