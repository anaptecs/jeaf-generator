/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class CurrencyCode implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * ISO 4217 currency code. <br/>
   * <b>Default Value:</b> <code>"CHF"</code> <br/>
   * <b>Example:</b> <code>CHF</code>
   */
  @Size(min = 3, max = 3)
  @NotNull
  private String code;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CurrencyCode( ) {
    code = "CHF";
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CurrencyCode( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new CurrencyCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new CurrencyCode objects. The method never returns
   * null.
   */
  public static Builder builder( CurrencyCode pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pCode ) {
    Builder lBuilder = builder();
    lBuilder.setCode(pCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>CurrencyCode</code>.
   */
  public static class Builder {
    /**
     * ISO 4217 currency code. <br/>
     * <b>Default Value:</b> <code>"CHF"</code> <br/>
     * <b>Example:</b> <code>CHF</code>
     */
    @Size(min = 3, max = 3)
    private String code = "CHF";

    /**
     * Use {@link CurrencyCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CurrencyCode#builder(CurrencyCode)} instead of private constructor to create new builder.
     */
    protected Builder( CurrencyCode pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        code = pObject.code;
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     * ISO 4217 currency code.
     * 
     * @param pCode Value to which {@link #code} should be set.
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class CurrencyCode. The object will be initialized with the values of the
     * builder.
     * 
     * @return CurrencyCode Created object. The method never returns null.
     */
    public CurrencyCode build( ) {
      return new CurrencyCode(this);
    }

    /**
     * Method creates a new validated instance of class CurrencyCode. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return CurrencyCode Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CurrencyCode buildValidated( ) throws ConstraintViolationException {
      CurrencyCode lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   * ISO 4217 currency code.
   * 
   * @return {@link String} Value to which {@link #code} is set.
   */
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   * ISO 4217 currency code.
   * 
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( String pCode ) {
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
    else if (pOtherObject instanceof CurrencyCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((CurrencyCode) pOtherObject).getCode());
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
