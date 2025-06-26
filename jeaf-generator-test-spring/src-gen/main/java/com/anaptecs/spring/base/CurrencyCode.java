/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import javax.validation.constraints.Size;

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
public class CurrencyCode {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * ISO 4217 currency code. <br/>
   * <b>Default Value:</b> <code>"CHF"</code> <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>CHF</code></li>
   * </ul>
   */
  @Size(min = 3, max = 3)
  private String code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CurrencyCode( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CurrencyCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class CurrencyCode.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link CurrencyCode}
   */
  public static CurrencyCode of( String pCode ) {
    var lBuilder = CurrencyCode.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>CurrencyCode</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * ISO 4217 currency code. <br/>
     * <b>Default Value:</b> <code>"CHF"</code> <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>CHF</code></li>
     * </ul>
     */
    @Size(min = 3, max = 3)
    private String code = "CHF";

    /**
     * Use {@link CurrencyCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CurrencyCode#builder(CurrencyCode)} instead of private constructor to create new builder.
     */
    protected Builder( CurrencyCode pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new CurrencyCode objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new CurrencyCode objects. The method never returns
     * null.
     */
    public static Builder newBuilder( CurrencyCode pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( @MyNotNullProperty String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class CurrencyCode. The object will be initialized with the values of the
     * builder.
     *
     * @return CurrencyCode Created object. The method never returns null.
     */
    public CurrencyCode build( ) {
      CurrencyCode lObject = new CurrencyCode(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   * ISO 4217 currency code.
   *
   * @return {@link String} Value to which {@link #code} is set.
   */
  @MyNotNullProperty
  public String getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   * ISO 4217 currency code.
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( @MyNotNullProperty String pCode ) {
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
    else if (pOtherObject instanceof CurrencyCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((CurrencyCode) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new CurrencyCode objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}