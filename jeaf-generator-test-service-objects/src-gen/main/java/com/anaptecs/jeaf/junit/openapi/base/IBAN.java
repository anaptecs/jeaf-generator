/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class IBAN implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  private String value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected IBAN( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IBAN( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new IBAN objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new IBAN objects. The method never returns null.
   */
  public static Builder builder( IBAN pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>IBAN</code>.
   */
  public static class Builder {
    private String value;

    /**
     * Use {@link IBAN#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link IBAN#builder(IBAN)} instead of private constructor to create new builder.
     */
    protected Builder( IBAN pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        value = pObject.value;
      }
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setValue( String pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class IBAN. The object will be initialized with the values of the builder.
     *
     * @return IBAN Created object. The method never returns null.
     */
    public IBAN build( ) {
      return new IBAN(this);
    }

    /**
     * Method creates a new validated instance of class IBAN. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return IBAN Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public IBAN buildValidated( ) throws ConstraintViolationException {
      IBAN lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return {@link String} Value to which {@link #value} is set.
   */
  public String getValue( ) {
    return value;
  }

  /**
   * Method sets attribute {@link #value}.<br/>
   *
   * @param pValue Value to which {@link #value} should be set.
   */
  public void setValue( String pValue ) {
    // Assign value to attribute
    value = pValue;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(value);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof IBAN == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(value, ((IBAN) pOtherObject).getValue());
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
    lBuilder.append("value: ");
    lBuilder.append(value);
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
