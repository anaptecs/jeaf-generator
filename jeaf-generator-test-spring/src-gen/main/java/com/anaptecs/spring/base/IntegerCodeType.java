/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class IntegerCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private int code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IntegerCodeType( IntegerCodeTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new IntegerCodeType objects.
   */
  public static IntegerCodeTypeBuilder<?, ?> builder( ) {
    return new IntegerCodeTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class IntegerCodeType.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link IntegerCodeType}
   */
  public static IntegerCodeType of( int pCode ) {
    var lBuilder = IntegerCodeType.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>IntegerCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class IntegerCodeTypeBuilder<T extends IntegerCodeType, S extends IntegerCodeTypeBuilder<T, S>> {
    private int code;

    /**
     * Use {@link IntegerCodeTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected IntegerCodeTypeBuilder( ) {
    }

    /**
     * Use {@link IntegerCodeTypeBuilder#builder(IntegerCodeType)} instead of private constructor to create new builder.
     */
    protected IntegerCodeTypeBuilder( IntegerCodeType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setCode( int pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract S self( );

    /**
     * Method creates a new instance of class IntegerCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return IntegerCodeType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class IntegerCodeTypeBuilderImpl
      extends IntegerCodeTypeBuilder<IntegerCodeType, IntegerCodeTypeBuilderImpl> {
    protected IntegerCodeTypeBuilderImpl( ) {
    }

    protected IntegerCodeTypeBuilderImpl( IntegerCodeType pObject ) {
      super(pObject);
    }

    @Override
    protected IntegerCodeTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public IntegerCodeType build( ) {
      IntegerCodeType lObject = new IntegerCodeType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return int Value to which {@link #code} is set.
   */
  public int getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( int pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return code;
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof IntegerCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((IntegerCodeType) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new IntegerCodeType objects. The method never
   * returns null.
   */
  public IntegerCodeTypeBuilder<?, ?> toBuilder( ) {
    return new IntegerCodeTypeBuilderImpl(this);
  }
}