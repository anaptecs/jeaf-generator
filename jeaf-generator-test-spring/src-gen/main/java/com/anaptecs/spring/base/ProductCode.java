/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.constraints.Positive;

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
public class ProductCode {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * the product code.
   */
  @Positive
  private int code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductCode( ProductCodeBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ProductCode objects.
   */
  public static ProductCodeBuilder<?, ?> builder( ) {
    return new ProductCodeBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ProductCode.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link ProductCode}
   */
  public static ProductCode of( int pCode ) {
    var lBuilder = ProductCode.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ProductCode</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ProductCodeBuilder<T extends ProductCode, S extends ProductCodeBuilder<T, S>> {
    /**
     * the product code.
     */
    @Positive
    private int code;

    /**
     * Use {@link ProductCodeBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ProductCodeBuilder( ) {
    }

    /**
     * Use {@link ProductCodeBuilder#builder(ProductCode)} instead of private constructor to create new builder.
     */
    protected ProductCodeBuilder( ProductCode pObject ) {
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
     * Method creates a new instance of class ProductCode. The object will be initialized with the values of the
     * builder.
     *
     * @return ProductCode Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ProductCodeBuilderImpl extends ProductCodeBuilder<ProductCode, ProductCodeBuilderImpl> {
    protected ProductCodeBuilderImpl( ) {
    }

    protected ProductCodeBuilderImpl( ProductCode pObject ) {
      super(pObject);
    }

    @Override
    protected ProductCodeBuilderImpl self( ) {
      return this;
    }

    @Override
    public ProductCode build( ) {
      ProductCode lObject = new ProductCode(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   * the product code.
   *
   * @return int Value to which {@link #code} is set.
   */
  public int getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   * the product code.
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
    else if (pOtherObject instanceof ProductCode == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((ProductCode) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new ProductCode objects. The method never returns
   * null.
   */
  public ProductCodeBuilder<?, ?> toBuilder( ) {
    return new ProductCodeBuilderImpl(this);
  }
}