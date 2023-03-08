/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

public class IntegerCode {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private Integer code;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected IntegerCode( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IntegerCode( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new IntegerCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new IntegerCode objects. The method never returns
   * null.
   */
  public static Builder builder( IntegerCode pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class IntegerCode. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Integer code;

    /**
     * Use {@link IntegerCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link IntegerCode#builder(IntegerCode)} instead of private constructor to create new builder.
     */
    protected Builder( IntegerCode pObject ) {
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
    public Builder setCode( Integer pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class IntegerCode. The object will be initialized with the values of the
     * builder.
     * 
     * @return IntegerCode Created object. The method never returns null.
     */
    public IntegerCode build( ) {
      return new IntegerCode(this);
    }
  }

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return Integer Value to which the attribute "code" is set.
   */
  public Integer getCode( ) {
    return code;
  }

  /**
   * Method sets the attribute "code".
   * 
   * 
   * @param pCode Value to which the attribute "code" should be set.
   */
  public void setCode( Integer pCode ) {
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
    else if (pOtherObject instanceof IntegerCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((IntegerCode) pOtherObject).getCode());
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
