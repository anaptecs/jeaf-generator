/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class SoftLink implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "openID".
   */
  public static final String OPENID = "openID";

  /**
   * String representation of this object.
   */
  private final String openID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLink( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    openID = pBuilder.openID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLink objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  public static Builder builder( String pOpenID ) {
    Builder lBuilder = builder();
    lBuilder.setOpenID(pOpenID);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLink</code>.
   */
  public static class Builder {
    /**
     * String representation of this object.
     */
    private String openID;

    /**
     * Use {@link SoftLink#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SoftLink#builder(SoftLink)} instead of private constructor to create new builder.
     */
    protected Builder( SoftLink pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setOpenID(pObject.openID);
      }
    }

    /**
     * Method returns the String representation of this object.
     *
     * @return String String representation of this object.
     */
    public Builder setOpenID( String pOpenID ) {
      openID = pOpenID;
      return this;
    }

    /**
     * Method creates a new instance of class SoftLink. The object will be initialized with the values of the builder.
     *
     * @return SoftLink Created object. The method never returns null.
     */
    public SoftLink build( ) {
      return new SoftLink(this);
    }

    /**
     * Method creates a new validated instance of class SoftLink. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return SoftLink Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLink buildValidated( ) throws ConstraintViolationException {
      SoftLink lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the String representation of this object.
   *
   * @return String String representation of this object.
   */
  public String getOpenID( ) {
    return openID;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(openID);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof SoftLink == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(openID, ((SoftLink) pOtherObject).getOpenID());
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
    lBuilder.append("openID: ");
    lBuilder.append(openID);
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
   * @return {@link Builder} New builder that can be used to create new SoftLink objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}