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
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Valid
@JsonDeserialize(builder = ReadonlyDefaultPOJO.Builder.class)
public abstract class ReadonlyDefaultPOJOBase {
  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  /**
   * Constant for the name of attribute "booleanDefault".
   */
  public static final String BOOLEANDEFAULT = "booleanDefault";

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * <br/>
   * <b>Default Value:</b> <code>true</code>
   */
  private final Boolean booleanDefault;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadonlyDefaultPOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonlyDefault = pBuilder.readonlyDefault;
    booleanDefault = pBuilder.booleanDefault;
  }

  /**
   * Class implements builder to create a new instance of class ReadonlyDefaultPOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
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
     * <b>Default Value:</b> <code>true</code>
     */
    private Boolean booleanDefault = true;

    /**
     * Use {@link ReadonlyDefaultPOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ReadonlyDefaultPOJO.builder(ReadonlyDefaultPOJO)} instead of protected constructor to create new
     * builder.
     */
    protected BuilderBase( ReadonlyDefaultPOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setReadonlyDefault(pObject.readonlyDefault);
        this.setBooleanDefault(pObject.booleanDefault);
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
     * Method sets attribute {@link #booleanDefault}.<br/>
     *
     * @param pBooleanDefault Value to which {@link #booleanDefault} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setBooleanDefault( Boolean pBooleanDefault ) {
      // Assign value to attribute
      booleanDefault = pBooleanDefault;
      return this;
    }

    /**
     * Method creates a new instance of class ReadonlyDefaultPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return ReadonlyDefaultPOJO Created object. The method never returns null.
     */
    public ReadonlyDefaultPOJO build( ) {
      return new ReadonlyDefaultPOJO(this);
    }

    /**
     * Method creates a new validated instance of class ReadonlyDefaultPOJO. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ReadonlyDefaultPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadonlyDefaultPOJO buildValidated( ) throws ConstraintViolationException {
      ReadonlyDefaultPOJO lPOJO = this.build();
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
   * Method returns attribute {@link #booleanDefault}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #booleanDefault} is set.
   */
  public Boolean getBooleanDefault( ) {
    return booleanDefault;
  }

  /**
   * Convenience method to create new instance of class ReadonlyDefaultPOJO.
   *
   *
   * @param pReadonlyDefault Value to which {@link #readonlyDefault} should be set.
   *
   * @param pBooleanDefault Value to which {@link #booleanDefault} should be set.
   *
   * @return {@link ReadonlyDefaultPOJO}
   */
  public static ReadonlyDefaultPOJO of( int pReadonlyDefault, Boolean pBooleanDefault ) {
    var lBuilder = ReadonlyDefaultPOJO.builder();
    lBuilder.setReadonlyDefault(pReadonlyDefault);
    lBuilder.setBooleanDefault(pBooleanDefault);
    return lBuilder.build();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + readonlyDefault;
    lResult = lPrime * lResult + Objects.hashCode(booleanDefault);
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
      ReadonlyDefaultPOJOBase lOther = (ReadonlyDefaultPOJOBase) pObject;
      lEquals = readonlyDefault == lOther.readonlyDefault && Objects.equals(booleanDefault, lOther.booleanDefault);
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
    lBuilder.append("booleanDefault: ");
    lBuilder.append(booleanDefault);
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
   * @return {@link Builder} New builder that can be used to create new ReadonlyDefaultPOJO objects. The method never
   * returns null.
   */
  public ReadonlyDefaultPOJO.Builder toBuilder( ) {
    return new ReadonlyDefaultPOJO.Builder((ReadonlyDefaultPOJO) this);
  }
}