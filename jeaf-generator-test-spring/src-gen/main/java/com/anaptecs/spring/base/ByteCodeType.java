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
public class ByteCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private byte code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ByteCodeType( ByteCodeTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  private ByteCodeType( byte pCode ) {
    code = pCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ByteCodeType objects.
   */
  public static ByteCodeTypeBuilder<?, ?> builder( ) {
    return new ByteCodeTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ByteCodeType.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link ByteCodeType}
   */
  public static ByteCodeType of( byte pCode ) {
    return new ByteCodeType(pCode);
  }

  /**
   * Class implements builder to create a new instance of class <code>ByteCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ByteCodeTypeBuilder<T extends ByteCodeType, B extends ByteCodeTypeBuilder<T, B>> {
    private byte code;

    /**
     * Use {@link ByteCodeTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ByteCodeTypeBuilder( ) {
    }

    /**
     * Use {@link ByteCodeTypeBuilder#builder(ByteCodeType)} instead of private constructor to create new builder.
     */
    protected ByteCodeTypeBuilder( ByteCodeType pObject ) {
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
    public B setCode( byte pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ByteCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return ByteCodeType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ByteCodeTypeBuilderImpl extends ByteCodeTypeBuilder<ByteCodeType, ByteCodeTypeBuilderImpl> {
    protected ByteCodeTypeBuilderImpl( ) {
    }

    protected ByteCodeTypeBuilderImpl( ByteCodeType pObject ) {
      super(pObject);
    }

    @Override
    protected ByteCodeTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public ByteCodeType build( ) {
      ByteCodeType lObject = new ByteCodeType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return byte Value to which {@link #code} is set.
   */
  public byte getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( byte pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return Byte.hashCode(code);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof ByteCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((ByteCodeType) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new ByteCodeType objects. The method never returns
   * null.
   */
  public ByteCodeTypeBuilder<?, ?> toBuilder( ) {
    return new ByteCodeTypeBuilderImpl(this);
  }
}