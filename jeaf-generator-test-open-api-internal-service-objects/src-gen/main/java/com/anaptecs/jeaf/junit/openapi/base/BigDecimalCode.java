/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class BigDecimalCode implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private BigDecimal code;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BigDecimalCode( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BigDecimalCode( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new BigDecimalCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BigDecimalCode objects. The method never returns
   * null.
   */
  public static Builder builder( BigDecimalCode pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BigDecimal pCode ) {
    Builder lBuilder = builder();
    lBuilder.setCode(pCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class BigDecimalCode. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BigDecimal code;

    /**
     * Use {@link BigDecimalCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BigDecimalCode#builder(BigDecimalCode)} instead of private constructor to create new builder.
     */
    protected Builder( BigDecimalCode pObject ) {
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
    public Builder setCode( BigDecimal pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class BigDecimalCode. The object will be initialized with the values of the
     * builder.
     * 
     * @return BigDecimalCode Created object. The method never returns null.
     */
    public BigDecimalCode build( ) {
      return new BigDecimalCode(this);
    }

    /**
     * Method creates a new validated instance of class BigDecimalCode. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return BigDecimalCode Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BigDecimalCode buildValidated( ) throws ConstraintViolationException {
      BigDecimalCode lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return BigDecimal Value to which the attribute "code" is set.
   */
  public BigDecimal getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code".
   * 
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( BigDecimal pCode ) {
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
    else if (pOtherObject instanceof BigDecimalCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((BigDecimalCode) pOtherObject).getCode());
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
