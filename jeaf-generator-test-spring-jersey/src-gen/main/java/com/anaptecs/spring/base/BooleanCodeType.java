/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class BooleanCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private boolean code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BooleanCodeType( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BooleanCodeType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method converts the passed {@link String} into an instance of this object.
   *
   * Please be aware that this method is only intended to be used for deserialization frameworks like JAX-RS. For
   * "normal" object creation builder should be used instead.
   *
   * @param pCode String that should be used to create an instance of this class. The parameter must not be null.
   * @return {@link BooleanCodeType} Instance of the class that matches to the passed string. The method never returns
   * null.
   */
  public static BooleanCodeType valueOf( String pCode ) {
    return builder().setCode(Boolean.parseBoolean(pCode)).build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BooleanCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private boolean code;

    /**
     * Use {@link BooleanCodeType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BooleanCodeType#builder(BooleanCodeType)} instead of private constructor to create new builder.
     */
    protected Builder( BooleanCodeType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( boolean pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class BooleanCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return BooleanCodeType Created object. The method never returns null.
     */
    public BooleanCodeType build( ) {
      return new BooleanCodeType(this);
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return boolean Value to which {@link #code} is set.
   */
  @Deprecated
  public boolean getCode( ) {
    return code;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return boolean Value to which {@link #code} is set.
   */
  public boolean isCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( boolean pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return Boolean.hashCode(code);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof BooleanCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((BooleanCodeType) pOtherObject).getCode());
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new BooleanCodeType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}