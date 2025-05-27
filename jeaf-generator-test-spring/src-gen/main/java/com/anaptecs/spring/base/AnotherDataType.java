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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = AnotherDataType.AnotherDataTypeBuilderImpl.class)
public class AnotherDataType {
  /**
   * Constant for the name of attribute "data".
   */
  public static final String DATA = "data";

  public String data;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AnotherDataType( AnotherDataTypeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    data = pBuilder.data;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AnotherDataType objects.
   */
  public static AnotherDataTypeBuilder<?, ?> builder( ) {
    return new AnotherDataTypeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class AnotherDataType.
   *
   *
   * @param pData Value to which {@link #data} should be set.
   *
   * @return {@link AnotherDataType}
   */
  public static AnotherDataType of( String pData ) {
    AnotherDataTypeBuilder<?, ?> lBuilder = AnotherDataType.builder();
    lBuilder.setData(pData);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>AnotherDataType</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class AnotherDataTypeBuilder<T extends AnotherDataType, B extends AnotherDataTypeBuilder<T, B>> {
    private String data;

    /**
     * Use {@link AnotherDataTypeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected AnotherDataTypeBuilder( ) {
    }

    /**
     * Use {@link AnotherDataTypeBuilder#builder(AnotherDataType)} instead of private constructor to create new builder.
     */
    protected AnotherDataTypeBuilder( AnotherDataType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setData(pObject.data);
      }
    }

    /**
     * Method sets attribute {@link #data}.<br/>
     *
     * @param pData Value to which {@link #data} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setData( @MyNotNullProperty String pData ) {
      // Assign value to attribute
      data = pData;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class AnotherDataType. The object will be initialized with the values of the
     * builder.
     *
     * @return AnotherDataType Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class AnotherDataTypeBuilderImpl
      extends AnotherDataTypeBuilder<AnotherDataType, AnotherDataTypeBuilderImpl> {
    protected AnotherDataTypeBuilderImpl( ) {
    }

    protected AnotherDataTypeBuilderImpl( AnotherDataType pObject ) {
      super(pObject);
    }

    @Override
    protected AnotherDataTypeBuilderImpl self( ) {
      return this;
    }

    @Override
    public AnotherDataType build( ) {
      AnotherDataType lObject = new AnotherDataType(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #data}.<br/>
   *
   * @return {@link String} Value to which {@link #data} is set.
   */
  @MyNotNullProperty
  public String getData( ) {
    return data;
  }

  /**
   * Method sets attribute {@link #data}.<br/>
   *
   * @param pData Value to which {@link #data} should be set.
   */
  public void setData( @MyNotNullProperty String pData ) {
    // Assign value to attribute
    data = pData;
  }

  @Override
  public int hashCode( ) {
    return Objects.hashCode(data);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof AnotherDataType == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(data, ((AnotherDataType) pOtherObject).getData());
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
    lBuilder.append("data: ");
    lBuilder.append(data);
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
   * @return {@link Builder} New builder that can be used to create new AnotherDataType objects. The method never
   * returns null.
   */
  public AnotherDataTypeBuilder<?, ?> toBuilder( ) {
    return new AnotherDataTypeBuilderImpl(this);
  }
}