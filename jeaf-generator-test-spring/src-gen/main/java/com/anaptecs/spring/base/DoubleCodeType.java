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
public class DoubleCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  public double code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DoubleCodeType( DoubleCodeTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  private DoubleCodeType( double pCode ) {
    code = pCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DoubleCodeType objects.
   */
  public static DoubleCodeTypeBuilder<?, ?> builder( ) {
    return new DoubleCodeTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class DoubleCodeType.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link DoubleCodeType}
   */
  public static DoubleCodeType of( double pCode ) {
    return new DoubleCodeType(pCode);
  }

  /**
   * Class implements builder to create a new instance of class <code>DoubleCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DoubleCodeTypeBuilder<T extends DoubleCodeType, B extends DoubleCodeTypeBuilder<T, B>> {
    private double code;

    /**
     * Use {@link DoubleCodeTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected DoubleCodeTypeBuilder( ) {
    }

    /**
     * Use {@link DoubleCodeTypeBuilder#builder(DoubleCodeType)} instead of private constructor to create new builder.
     */
    protected DoubleCodeTypeBuilder( DoubleCodeType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setCode( double pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class DoubleCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return DoubleCodeType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DoubleCodeTypeBuilderImpl
      extends DoubleCodeTypeBuilder<DoubleCodeType, DoubleCodeTypeBuilderImpl> {
    protected DoubleCodeTypeBuilderImpl( ) {
    }

    protected DoubleCodeTypeBuilderImpl( DoubleCodeType pObject ) {
      super(pObject);
    }

    @Override
    protected DoubleCodeTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public DoubleCodeType build( ) {
      DoubleCodeType lObject = new DoubleCodeType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return double Value to which {@link #code} is set.
   */
  public double getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( double pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return Double.hashCode(code);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof DoubleCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((DoubleCodeType) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new DoubleCodeType objects. The method never returns
   * null.
   */
  public DoubleCodeTypeBuilder<?, ?> toBuilder( ) {
    return new DoubleCodeTypeBuilderImpl(this);
  }
}