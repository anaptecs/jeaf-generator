/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTypeCustomSerialization implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "magic".
   */
  public static final String MAGIC = "magic";

  /**
   * String representation of this object.
   */
  private final String magic;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DataTypeCustomSerialization( ) {
    magic = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeCustomSerialization( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    magic = pBuilder.magic;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeCustomSerialization objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  public static Builder builder( String pMagic ) {
    Builder lBuilder = builder();
    lBuilder.setMagic(pMagic);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>DataTypeCustomSerialization</code>.
   */
  public static class Builder {
    /**
     * String representation of this object.
     */
    private String magic;

    /**
     * Use {@link DataTypeCustomSerialization#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeCustomSerialization#builder(DataTypeCustomSerialization)} instead of private constructor to
     * create new builder.
     */
    protected Builder( DataTypeCustomSerialization pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMagic(pObject.magic);
      }
    }

    /**
     * Method returns the String representation of this object.
     *
     * @return String String representation of this object.
     */
    public Builder setMagic( String pMagic ) {
      magic = pMagic;
      return this;
    }

    /**
     * Method creates a new instance of class DataTypeCustomSerialization. The object will be initialized with the
     * values of the builder.
     *
     * @return DataTypeCustomSerialization Created object. The method never returns null.
     */
    public DataTypeCustomSerialization build( ) {
      return new DataTypeCustomSerialization(this);
    }

    /**
     * Method creates a new validated instance of class DataTypeCustomSerialization. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return DataTypeCustomSerialization Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DataTypeCustomSerialization buildValidated( ) throws ConstraintViolationException {
      DataTypeCustomSerialization lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the String representation of this object.
   *
   * @return String String representation of this object.
   */
  public String getMagic( ) {
    return magic;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(magic);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DataTypeCustomSerialization == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(magic, ((DataTypeCustomSerialization) pOtherObject).getMagic());
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
    lBuilder.append("magic: ");
    lBuilder.append(magic);
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
   * @return {@link Builder} New builder that can be used to create new DataTypeCustomSerialization objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}