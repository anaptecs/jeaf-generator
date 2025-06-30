/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
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
public class LongCode {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private Long code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LongCode( LongCodeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  private LongCode( Long pCode ) {
    code = pCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LongCode objects.
   */
  public static LongCodeBuilder<?, ?> builder( ) {
    return new LongCodeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class LongCode.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link LongCode}
   */
  public static LongCode of( Long pCode ) {
    return new LongCode(pCode);
  }

  /**
   * Class implements builder to create a new instance of class <code>LongCode</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class LongCodeBuilder<T extends LongCode, B extends LongCodeBuilder<T, B>> {
    private Long code;

    /**
     * Use {@link LongCodeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected LongCodeBuilder( ) {
    }

    /**
     * Use {@link LongCodeBuilder#builder(LongCode)} instead of private constructor to create new builder.
     */
    protected LongCodeBuilder( LongCode pObject ) {
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
    public B setCode( @MyNotNullProperty Long pCode ) {
      // Assign value to attribute
      code = pCode;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class LongCode. The object will be initialized with the values of the builder.
     *
     * @return LongCode Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class LongCodeBuilderImpl extends LongCodeBuilder<LongCode, LongCodeBuilderImpl> {
    protected LongCodeBuilderImpl( ) {
    }

    protected LongCodeBuilderImpl( LongCode pObject ) {
      super(pObject);
    }

    @Override
    protected LongCodeBuilderImpl self( ) {
      return this;
    }

    @Override
    public LongCode build( ) {
      LongCode lObject = new LongCode(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link Long} Value to which {@link #code} is set.
   */
  @MyNotNullProperty
  public Long getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( @MyNotNullProperty Long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  @Override
  public int hashCode( ) {
    return Objects.hashCode(code);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof LongCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((LongCode) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new LongCode objects. The method never returns null.
   */
  public LongCodeBuilder<?, ?> toBuilder( ) {
    return new LongCodeBuilderImpl(this);
  }
}