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
public class CharacterCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private char code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CharacterCodeType( CharacterCodeTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CharacterCodeType objects.
   */
  public static CharacterCodeTypeBuilder<?, ?> builder( ) {
    return new CharacterCodeTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class CharacterCodeType.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link CharacterCodeType}
   */
  public static CharacterCodeType of( char pCode ) {
    var lBuilder = CharacterCodeType.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>CharacterCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class CharacterCodeTypeBuilder<T extends CharacterCodeType, B extends CharacterCodeTypeBuilder<T, B>> {
    private char code;

    /**
     * Use {@link CharacterCodeTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected CharacterCodeTypeBuilder( ) {
    }

    /**
     * Use {@link CharacterCodeTypeBuilder#builder(CharacterCodeType)} instead of private constructor to create new
     * builder.
     */
    protected CharacterCodeTypeBuilder( CharacterCodeType pObject ) {
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
    public B setCode( char pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class CharacterCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return CharacterCodeType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class CharacterCodeTypeBuilderImpl
      extends CharacterCodeTypeBuilder<CharacterCodeType, CharacterCodeTypeBuilderImpl> {
    protected CharacterCodeTypeBuilderImpl( ) {
    }

    protected CharacterCodeTypeBuilderImpl( CharacterCodeType pObject ) {
      super(pObject);
    }

    @Override
    protected CharacterCodeTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public CharacterCodeType build( ) {
      CharacterCodeType lObject = new CharacterCodeType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return char Value to which {@link #code} is set.
   */
  public char getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( char pCode ) {
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
    else if (pOtherObject instanceof CharacterCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((CharacterCodeType) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new CharacterCodeType objects. The method never
   * returns null.
   */
  public CharacterCodeTypeBuilder<?, ?> toBuilder( ) {
    return new CharacterCodeTypeBuilderImpl(this);
  }
}