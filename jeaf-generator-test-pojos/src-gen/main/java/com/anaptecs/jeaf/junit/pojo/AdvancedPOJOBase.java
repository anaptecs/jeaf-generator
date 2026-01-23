/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Valid
@JsonDeserialize(builder = AdvancedPOJO.Builder.class)
public abstract class AdvancedPOJOBase {
  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  /**
   * Constant for the name of attribute "intWithDefault".
   */
  public static final String INTWITHDEFAULT = "intWithDefault";

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * <br/>
   * <b>Default Value:</b> <code>42</code>
   */
  private Integer intWithDefault;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AdvancedPOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonlyDefault = pBuilder.readonlyDefault;
    intWithDefault = pBuilder.intWithDefault;
  }

  /**
   * Class implements builder to create a new instance of class AdvancedPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    /**
     * <br/>
     * <b>Default Value:</b> <code>4711</code>
     */
    private int readonlyDefault = 4711;

    /**
     * <br/>
     * <b>Default Value:</b> <code>42</code>
     */
    private Integer intWithDefault = 42;

    /**
     * Use {@link AdvancedPOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AdvancedPOJO.builder(AdvancedPOJO)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( AdvancedPOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setReadonlyDefault(pObject.readonlyDefault);
        this.setIntWithDefault(pObject.intWithDefault);
      }
    }

    /**
     * Method sets attribute {@link #readonlyDefault}.<br/>
     *
     * @param pReadonlyDefault Value to which {@link #readonlyDefault} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

    /**
     * Method sets attribute {@link #intWithDefault}.<br/>
     *
     * @param pIntWithDefault Value to which {@link #intWithDefault} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setIntWithDefault( Integer pIntWithDefault ) {
      // Assign value to attribute
      intWithDefault = pIntWithDefault;
      return this;
    }

    /**
     * Method creates a new instance of class AdvancedPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return AdvancedPOJO Created object. The method never returns null.
     */
    public AdvancedPOJO build( ) {
      return new AdvancedPOJO(this);
    }

    /**
     * Method creates a new validated instance of class AdvancedPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return AdvancedPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public AdvancedPOJO buildValidated( ) throws ConstraintViolationException {
      AdvancedPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
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
   * Method returns attribute {@link #intWithDefault}.<br/>
   *
   * @return {@link Integer} Value to which {@link #intWithDefault} is set.
   */
  public Integer getIntWithDefault( ) {
    return intWithDefault;
  }

  /**
   * Method sets attribute {@link #intWithDefault}.<br/>
   *
   * @param pIntWithDefault Value to which {@link #intWithDefault} should be set.
   */
  public void setIntWithDefault( Integer pIntWithDefault ) {
    // Assign value to attribute
    intWithDefault = pIntWithDefault;
  }

  /**
   * Convenience method to create new instance of class AdvancedPOJO.
   *
   *
   * @param pReadonlyDefault Value to which {@link #readonlyDefault} should be set.
   *
   * @param pIntWithDefault Value to which {@link #intWithDefault} should be set.
   *
   * @return {@link AdvancedPOJO}
   */
  public static AdvancedPOJO of( int pReadonlyDefault, Integer pIntWithDefault ) {
    var lBuilder = AdvancedPOJO.builder();
    lBuilder.setReadonlyDefault(pReadonlyDefault);
    lBuilder.setIntWithDefault(pIntWithDefault);
    return lBuilder.build();
  }

  /**
   * @param pName
   * @return boolean
   */
  public abstract boolean doSomething( String pName );

  /**
   * @return int
   */
  public abstract int returnPrimitive( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + readonlyDefault;
    lResult = lPrime * lResult + Objects.hashCode(intWithDefault);
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
      AdvancedPOJOBase lOther = (AdvancedPOJOBase) pObject;
      lEquals = readonlyDefault == lOther.readonlyDefault && Objects.equals(intWithDefault, lOther.intWithDefault);
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
    lBuilder.append("readonlyDefault: ");
    lBuilder.append(readonlyDefault);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("intWithDefault: ");
    lBuilder.append(intWithDefault);
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
   * @return {@link Builder} New builder that can be used to create new AdvancedPOJO objects. The method never returns
   * null.
   */
  public AdvancedPOJO.Builder toBuilder( ) {
    return new AdvancedPOJO.Builder((AdvancedPOJO) this);
  }
}