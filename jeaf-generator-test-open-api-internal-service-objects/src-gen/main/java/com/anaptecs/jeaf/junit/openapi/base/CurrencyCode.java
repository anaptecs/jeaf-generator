/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
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
  private String code;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class CurrencyCode. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * ISO 4217 currency code.
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
     * Method sets the attribute "code". ISO 4217 currency code.
     * 
     * @param pCode Value to which the attribute "code" should be set.
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
   * Method returns the attribute "code". ISO 4217 currency code.
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code". ISO 4217 currency code.
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( String pCode ) {
    // Assign value to attribute
    code = pCode;
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