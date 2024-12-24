/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class ChannelCode {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * <br/>
   * <b>Default Value:</b> <code>"MY_MAGIC_CHANNEL"</code>
   */
  public static final String DEFAULT_CHANNEL_CODE = "MY_MAGIC_CHANNEL";

  /**
   * channel code <br/>
   * <b>Default Value:</b> <code>"WEBSHOP"</code> <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>MOBILE_APP</code></li>
   * </ul>
   */
  @NotNull
  private final String code;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChannelCode( ) {
    code = "WEBSHOP";
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChannelCode( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChannelCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChannelCode</code>.
   */
  public static class Builder {
    /**
     * channel code <br/>
     * <b>Default Value:</b> <code>"WEBSHOP"</code> <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>MOBILE_APP</code></li>
     * </ul>
     */
    @NotNull
    private String code = "WEBSHOP";

    /**
     * Use {@link ChannelCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ChannelCode#builder(ChannelCode)} instead of private constructor to create new builder.
     */
    protected Builder( ChannelCode pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( String pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class ChannelCode. The object will be initialized with the values of the
     * builder.
     *
     * @return ChannelCode Created object. The method never returns null.
     */
    public ChannelCode build( ) {
      return new ChannelCode(this);
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   * channel code
   *
   * @return {@link String} Value to which {@link #code} is set.
   */
  public String getCode( ) {
    return code;
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
    else if (pOtherObject instanceof ChannelCode == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(code, ((ChannelCode) pOtherObject).getCode());
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
   * @return {@link Builder} New builder that can be used to create new ChannelCode objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}