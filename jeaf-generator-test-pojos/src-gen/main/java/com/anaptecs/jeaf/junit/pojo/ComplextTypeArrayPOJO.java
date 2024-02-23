/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Arrays;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplextTypeArrayPOJO {
  /**
   * Constant for the name of attribute "plainPOJOs".
   */
  public static final String PLAINPOJOS = "plainPOJOs";

  private PlainPOJO[] plainPOJOs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplextTypeArrayPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplextTypeArrayPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    plainPOJOs = pBuilder.plainPOJOs;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ComplextTypeArrayPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ComplextTypeArrayPOJO.
   *
   *
   * @return {@link com.anaptecs.jeaf.junit.pojo.ComplextTypeArrayPOJO}
   */
  public static ComplextTypeArrayPOJO of( ) {
    ComplextTypeArrayPOJO.Builder lBuilder = ComplextTypeArrayPOJO.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ComplextTypeArrayPOJO</code>.
   */
  public static class Builder {
    private PlainPOJO[] plainPOJOs;

    /**
     * Use {@link ComplextTypeArrayPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplextTypeArrayPOJO#builder(ComplextTypeArrayPOJO)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ComplextTypeArrayPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setPlainPOJOs(pObject.plainPOJOs);
      }
    }

    /**
     * Method sets attribute {@link #plainPOJOs}.<br/>
     *
     * @param pPlainPOJOs Collection to which {@link #plainPOJOs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPlainPOJOs( PlainPOJO[] pPlainPOJOs ) {
      // Assign value to attribute
      if (pPlainPOJOs != null) {
        plainPOJOs = new PlainPOJO[pPlainPOJOs.length];
        System.arraycopy(pPlainPOJOs, 0, plainPOJOs, 0, pPlainPOJOs.length);
      }
      else {
        plainPOJOs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ComplextTypeArrayPOJO. The object will be initialized with the values of
     * the builder.
     *
     * @return ComplextTypeArrayPOJO Created object. The method never returns null.
     */
    public ComplextTypeArrayPOJO build( ) {
      return new ComplextTypeArrayPOJO(this);
    }

    /**
     * Method creates a new validated instance of class ComplextTypeArrayPOJO. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ComplextTypeArrayPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ComplextTypeArrayPOJO buildValidated( ) throws ConstraintViolationException {
      ComplextTypeArrayPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #plainPOJOs}.<br/>
   *
   * @return {@link PlainPOJO} Value to which {@link #plainPOJOs} is set.
   */
  public PlainPOJO[] getPlainPOJOs( ) {
    PlainPOJO[] lReturnValue;
    if (plainPOJOs != null) {
      lReturnValue = new PlainPOJO[plainPOJOs.length];
      System.arraycopy(plainPOJOs, 0, lReturnValue, 0, plainPOJOs.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #plainPOJOs}.<br/>
   *
   * @param pPlainPOJOs Value to which {@link #plainPOJOs} should be set.
   */
  public void setPlainPOJOs( PlainPOJO[] pPlainPOJOs ) {
    // Assign value to attribute
    if (pPlainPOJOs != null) {
      plainPOJOs = new PlainPOJO[pPlainPOJOs.length];
      System.arraycopy(pPlainPOJOs, 0, plainPOJOs, 0, pPlainPOJOs.length);
    }
    else {
      plainPOJOs = null;
    }
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Arrays.hashCode(plainPOJOs);
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
      ComplextTypeArrayPOJO lOther = (ComplextTypeArrayPOJO) pObject;
      lEquals = Arrays.equals(plainPOJOs, lOther.plainPOJOs);
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
   * @return {@link Builder} New builder that can be used to create new ComplextTypeArrayPOJO objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
