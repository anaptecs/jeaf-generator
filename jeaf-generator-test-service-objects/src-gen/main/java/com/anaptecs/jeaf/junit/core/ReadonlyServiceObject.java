/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class ReadonlyServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "readonly".
   */
  public static final String READONLY = "readonly";

  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  private final String readonly;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadonlyServiceObject( ) {
    readonly = null;
    readonlyDefault = 4711;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadonlyServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonly = pBuilder.readonly;
    readonlyDefault = pBuilder.readonlyDefault;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects. The method never
   * returns null.
   */
  public static Builder builder( ReadonlyServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>ReadonlyServiceObject</code>.
   */
  public static class Builder {
    private String readonly;

    /**
     * <br/>
     * <b>Default Value:</b> <code>4711</code>
     */
    private int readonlyDefault = 4711;

    /**
     * Use {@link ReadonlyServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReadonlyServiceObject#builder(ReadonlyServiceObject)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ReadonlyServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        readonly = pObject.readonly;
        readonlyDefault = pObject.readonlyDefault;
      }
    }

    /**
     * Method sets attribute {@link #readonly}.<br/>
     * 
     * @param pReadonly Value to which {@link #readonly} should be set.
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadonly( String pReadonly ) {
      // Assign value to attribute
      readonly = pReadonly;
      return this;
    }

    /**
     * Method sets attribute {@link #readonlyDefault}.<br/>
     * 
     * @param pReadonlyDefault Value to which {@link #readonlyDefault} should be set.
     * @return Builder Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

    /**
     * Method creates a new instance of class ReadonlyServiceObject. The object will be initialized with the values of
     * the builder.
     * 
     * @return ReadonlyServiceObject Created object. The method never returns null.
     */
    public ReadonlyServiceObject build( ) {
      return new ReadonlyServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class ReadonlyServiceObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ReadonlyServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadonlyServiceObject buildValidated( ) throws ConstraintViolationException {
      ReadonlyServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #readonly}.<br/>
   * 
   * @return {@link String} Value to which {@link #readonly} is set.
   */
  public String getReadonly( ) {
    return readonly;
  }

  /**
   * Method returns attribute {@link #readonlyDefault}.<br/>
   * 
   * @return int Value to which {@link #readonlyDefault} is set.
   */
  public int getReadonlyDefault( ) {
    return readonlyDefault;
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
    lBuilder.append("readonly: ");
    lBuilder.append(readonly);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("readonlyDefault: ");
    lBuilder.append(readonlyDefault);
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
