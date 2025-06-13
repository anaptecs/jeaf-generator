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
public class ShortCodeType {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private short code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ShortCodeType( ShortCodeTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ShortCodeType objects.
   */
  public static ShortCodeTypeBuilder<?, ?> builder( ) {
    return new ShortCodeTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ShortCodeType.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link ShortCodeType}
   */
  public static ShortCodeType of( short pCode ) {
    ShortCodeTypeBuilder<?, ?> lBuilder = ShortCodeType.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ShortCodeType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ShortCodeTypeBuilder<T extends ShortCodeType, B extends ShortCodeTypeBuilder<T, B>> {
    private short code;

    /**
     * Use {@link ShortCodeTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ShortCodeTypeBuilder( ) {
    }

    /**
     * Use {@link ShortCodeTypeBuilder#builder(ShortCodeType)} instead of private constructor to create new builder.
     */
    protected ShortCodeTypeBuilder( ShortCodeType pObject ) {
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
    public B setCode( short pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ShortCodeType. The object will be initialized with the values of the
     * builder.
     *
     * @return ShortCodeType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ShortCodeTypeBuilderImpl extends ShortCodeTypeBuilder<ShortCodeType, ShortCodeTypeBuilderImpl> {
    protected ShortCodeTypeBuilderImpl( ) {
    }

    protected ShortCodeTypeBuilderImpl( ShortCodeType pObject ) {
      super(pObject);
    }

    @Override
    protected ShortCodeTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public ShortCodeType build( ) {
      ShortCodeType lObject = new ShortCodeType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return short Value to which {@link #code} is set.
   */
  public short getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( short pCode ) {
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
    else if (pOtherObject instanceof ShortCodeType == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((ShortCodeType) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new ShortCodeType objects. The method never returns
   * null.
   */
  public ShortCodeTypeBuilder<?, ?> toBuilder( ) {
    return new ShortCodeTypeBuilderImpl(this);
  }
}