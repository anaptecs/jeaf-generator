/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.Objects;

public class MySortCriteria {
  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * String representation of this object.
   */
  private final String value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MySortCriteria( ) {
    value = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MySortCriteria( Builder pBuilder ) {
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MySortCriteria objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  public static Builder builder( String pValue ) {
    Builder lBuilder = builder();
    lBuilder.setValue(pValue);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>MySortCriteria</code>.
   */
  public static class Builder {
    /**
     * String representation of this object.
     */
    private String value;

    /**
     * Use {@link MySortCriteria#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MySortCriteria#builder(MySortCriteria)} instead of private constructor to create new builder.
     */
    protected Builder( MySortCriteria pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setValue(pObject.value);
      }
    }

    /**
     * Method returns the String representation of this object.
     *
     * @return String String representation of this object.
     */
    public Builder setValue( String pValue ) {
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class MySortCriteria. The object will be initialized with the values of the
     * builder.
     *
     * @return MySortCriteria Created object. The method never returns null.
     */
    public MySortCriteria build( ) {
      return new MySortCriteria(this);
    }
  }

  /**
   * Method returns the String representation of this object.
   *
   * @return String String representation of this object.
   */
  public String getValue( ) {
    return value;
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
    else if (pOtherObject instanceof MySortCriteria == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(value, ((MySortCriteria) pOtherObject).getValue());
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new MySortCriteria objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}