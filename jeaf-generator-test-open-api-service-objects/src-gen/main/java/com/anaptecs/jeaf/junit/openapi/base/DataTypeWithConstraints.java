/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class DataTypeWithConstraints implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @Max(value = 9999)
  private int intValue;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DataTypeWithConstraints( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeWithConstraints( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    intValue = pBuilder.intValue;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DataTypeWithConstraints objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DataTypeWithConstraints objects. The method
   * never returns null.
   */
  public static Builder builder( DataTypeWithConstraints pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class DataTypeWithConstraints. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    @Max(value = 9999)
    private int intValue;

    /**
     * Use {@link DataTypeWithConstraints#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeWithConstraints#builder(DataTypeWithConstraints)} instead of private constructor to create new
     * builder.
     */
    protected Builder( DataTypeWithConstraints pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        intValue = pObject.intValue;
      }
    }

    /**
     * Method sets the attribute "intValue".
     * 
     * @param pIntValue Value to which the attribute "intValue" should be set.
     */
    public Builder setIntValue( int pIntValue ) {
      // Assign value to attribute
      intValue = pIntValue;
      return this;
    }

    /**
     * Method creates a new instance of class DataTypeWithConstraints. The object will be initialized with the values of
     * the builder.
     * 
     * @return DataTypeWithConstraints Created object. The method never returns null.
     */
    public DataTypeWithConstraints build( ) {
      return new DataTypeWithConstraints(this);
    }

    /**
     * Method creates a new validated instance of class DataTypeWithConstraints. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return DataTypeWithConstraints Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DataTypeWithConstraints buildValidated( ) throws ConstraintViolationException {
      DataTypeWithConstraints lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #intValue}.<br/>
   * 
   * @return int Value to which {@link #intValue} is set.
   */
  public int getIntValue( ) {
    return intValue;
  }

  /**
   * Method sets attribute {@link #intValue}.<br/>
   * 
   * @param pIntValue Value to which {@link #intValue} should be set.
   */
  public void setIntValue( int pIntValue ) {
    // Assign value to attribute
    intValue = pIntValue;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(intValue);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DataTypeWithConstraints == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(intValue, ((DataTypeWithConstraints) pOtherObject).getIntValue());
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
    lBuilder.append("intValue: ");
    lBuilder.append(intValue);
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
