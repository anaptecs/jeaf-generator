/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class FloatCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * 
   */
  private float code;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected FloatCodeType( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected FloatCodeType( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new FloatCodeType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new FloatCodeType objects. The method never returns
   * null.
   */
  public static Builder builder( FloatCodeType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( float pCode ) {
    Builder lBuilder = builder();
    lBuilder.setCode(pCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class FloatCodeType. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private float code;

    /**
     * Use {@link FloatCodeType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link FloatCodeType#builder(FloatCodeType)} instead of private constructor to create new builder.
     */
    protected Builder( FloatCodeType pObject ) {
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
    public Builder setCode( float pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class FloatCodeType. The object will be initialized with the values of the
     * builder.
     * 
     * @return FloatCodeType Created object. The method never returns null.
     */
    public FloatCodeType build( ) {
      return new FloatCodeType(this);
    }
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return float Value to which the attribute "code" is set.
   */
  public float getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code".
   * 
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( float pCode ) {
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
    else if (pOtherObject instanceof FloatCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((FloatCodeType) pOtherObject).getCode());
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
