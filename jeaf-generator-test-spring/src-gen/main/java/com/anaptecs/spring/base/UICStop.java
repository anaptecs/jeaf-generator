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
@JsonDeserialize(builder = UICStop.UICStopBuilderImpl.class)
public class UICStop extends Stop {
  /**
   * Constant for the name of attribute "uicCode".
   */
  public static final String UICCODE = "uicCode";

  private String uicCode;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICStop( UICStopBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    uicCode = pBuilder.uicCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link UICStopBuilder} New builder that can be used to create new UICStop objects.
   */
  public static UICStopBuilder<?, ?> builder( ) {
    return new UICStopBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class UICStop.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   *
   * @return {@link UICStop}
   */
  public static UICStop of( String pName, String pUicCode ) {
    var lBuilder = UICStop.builder();
    lBuilder.setName(pName);
    lBuilder.setUicCode(pUicCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>UICStop</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class UICStopBuilder<T extends UICStop, B extends UICStopBuilder<T, B>>
      extends StopBuilder<T, B> {
    private String uicCode;

    /**
     * Use {@link UICStop#builder()} instead of private constructor to create new builder.
     */
    protected UICStopBuilder( ) {
      super();
    }

    /**
     * Use {@link UICStop#builder(UICStop)} instead of private constructor to create new builder.
     */
    protected UICStopBuilder( UICStop pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setUicCode(pObject.uicCode);
      }
    }

    /**
     * Method sets attribute {@link #uicCode}.<br/>
     *
     * @param pUicCode Value to which {@link #uicCode} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setUicCode( @MyNotNullProperty String pUicCode ) {
      // Assign value to attribute
      uicCode = pUicCode;
      return this.self();
    }

    /**
     * Method creates a new instance of class UICStop. The object will be initialized with the values of the builder.
     *
     * @return UICStop Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class UICStopBuilderImpl extends UICStopBuilder<UICStop, UICStopBuilderImpl> {
    protected UICStopBuilderImpl( ) {
    }

    protected UICStopBuilderImpl( UICStop pObject ) {
      super(pObject);
    }

    @Override
    protected UICStopBuilderImpl self( ) {
      return this;
    }

    @Override
    public UICStop build( ) {
      UICStop lObject = new UICStop(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #uicCode}.<br/>
   *
   * @return {@link String} Value to which {@link #uicCode} is set.
   */
  @MyNotNullProperty
  public String getUicCode( ) {
    return uicCode;
  }

  /**
   * Method sets attribute {@link #uicCode}.<br/>
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   */
  public void setUicCode( @MyNotNullProperty String pUicCode ) {
    // Assign value to attribute
    uicCode = pUicCode;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(uicCode);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      UICStop lOther = (UICStop) pObject;
      lEquals = Objects.equals(uicCode, lOther.uicCode);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("uicCode: ");
    lBuilder.append(uicCode);
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
   * @return {@link UICStopBuilder} New builder that can be used to create new UICStop objects. The method never returns
   * null.
   */
  public UICStopBuilder<?, ?> toBuilder( ) {
    return new UICStopBuilderImpl(this);
  }
}