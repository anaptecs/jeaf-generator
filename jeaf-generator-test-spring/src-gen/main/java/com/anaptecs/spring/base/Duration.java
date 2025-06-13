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

/**
 * Type represents a duration.<br/>
 * <br/>
 * NOVA 14 Mapping
 * </p>
 * <ul>
 * <li>nova-base.xsd.Dauer</li>
 * </ul>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Duration.DurationBuilderImpl.class)
public class Duration {
  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * Constant for the name of attribute "timeUnit".
   */
  public static final String TIMEUNIT = "timeUnit";

  private int value;

  /**
   * <br/>
   * <b>Default Value:</b> <code>DAY</code>
   */
  private TimeUnit timeUnit;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Duration( DurationBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    value = pBuilder.value;
    timeUnit = pBuilder.timeUnit;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Duration objects.
   */
  public static DurationBuilder<?, ?> builder( ) {
    return new DurationBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class Duration.
   *
   *
   * @param pValue Value to which {@link #value} should be set.
   *
   * @param pTimeUnit Value to which {@link #timeUnit} should be set.
   *
   * @return {@link Duration}
   */
  public static Duration of( int pValue, TimeUnit pTimeUnit ) {
    DurationBuilder<?, ?> lBuilder = Duration.builder();
    lBuilder.setValue(pValue);
    lBuilder.setTimeUnit(pTimeUnit);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Duration</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class DurationBuilder<T extends Duration, B extends DurationBuilder<T, B>> {
    private int value;

    /**
     * <br/>
     * <b>Default Value:</b> <code>DAY</code>
     */
    private TimeUnit timeUnit = TimeUnit.DAY;

    /**
     * Use {@link DurationBuilder#builder()} instead of private constructor to create new builder.
     */
    protected DurationBuilder( ) {
    }

    /**
     * Use {@link DurationBuilder#builder(Duration)} instead of private constructor to create new builder.
     */
    protected DurationBuilder( Duration pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setValue(pObject.value);
        this.setTimeUnit(pObject.timeUnit);
      }
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setValue( int pValue ) {
      // Assign value to attribute
      value = pValue;
      return this.self();
    }

    /**
     * Method sets attribute {@link #timeUnit}.<br/>
     *
     * @param pTimeUnit Value to which {@link #timeUnit} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTimeUnit( @MyNotNullProperty TimeUnit pTimeUnit ) {
      // Assign value to attribute
      timeUnit = pTimeUnit;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Duration. The object will be initialized with the values of the builder.
     *
     * @return Duration Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class DurationBuilderImpl extends DurationBuilder<Duration, DurationBuilderImpl> {
    protected DurationBuilderImpl( ) {
    }

    protected DurationBuilderImpl( Duration pObject ) {
      super(pObject);
    }

    @Override
    protected DurationBuilderImpl self( ) {
      return this;
    }

    @Override
    public Duration build( ) {
      Duration lObject = new Duration(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return int Value to which {@link #value} is set.
   */
  public int getValue( ) {
    return value;
  }

  /**
   * Method sets attribute {@link #value}.<br/>
   *
   * @param pValue Value to which {@link #value} should be set.
   */
  public void setValue( int pValue ) {
    // Assign value to attribute
    value = pValue;
  }

  /**
   * Method returns attribute {@link #timeUnit}.<br/>
   *
   * @return {@link TimeUnit} Value to which {@link #timeUnit} is set.
   */
  @MyNotNullProperty
  public TimeUnit getTimeUnit( ) {
    return timeUnit;
  }

  /**
   * Method sets attribute {@link #timeUnit}.<br/>
   *
   * @param pTimeUnit Value to which {@link #timeUnit} should be set.
   */
  public void setTimeUnit( @MyNotNullProperty TimeUnit pTimeUnit ) {
    // Assign value to attribute
    timeUnit = pTimeUnit;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + value;
    lResult = lPrime * lResult + Objects.hashCode(timeUnit);
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
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      Duration lOther = (Duration) pObject;
      lEquals = value == lOther.value && Objects.equals(timeUnit, lOther.timeUnit);
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
    lBuilder.append("value: ");
    lBuilder.append(value);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("timeUnit: ");
    lBuilder.append(timeUnit);
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
   * @return {@link Builder} New builder that can be used to create new Duration objects. The method never returns null.
   */
  public DurationBuilder<?, ?> toBuilder( ) {
    return new DurationBuilderImpl(this);
  }
}