/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Duration( ) {
    timeUnit = TimeUnit.DAY;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Duration( Builder pBuilder ) {
    // Read attribute values from builder.
    value = pBuilder.value;
    timeUnit = pBuilder.timeUnit;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Duration objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Duration.
   *
   *
   * @param pValue Value to which {@link #value} should be set.
   *
   * @param pTimeUnit Value to which {@link #timeUnit} should be set.
   *
   * @return {@link com.anaptecs.spring.base.Duration}
   */
  public static Duration of( int pValue, TimeUnit pTimeUnit ) {
    Duration.Builder lBuilder = Duration.builder();
    lBuilder.setValue(pValue);
    lBuilder.setTimeUnit(pTimeUnit);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Duration</code>.
   */
  public static class Builder {
    private int value;

    /**
     * <br/>
     * <b>Default Value:</b> <code>DAY</code>
     */
    private TimeUnit timeUnit = TimeUnit.DAY;

    /**
     * Use {@link Duration#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Duration#builder(Duration)} instead of private constructor to create new builder.
     */
    protected Builder( Duration pObject ) {
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
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setValue( int pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method sets attribute {@link #timeUnit}.<br/>
     *
     * @param pTimeUnit Value to which {@link #timeUnit} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimeUnit( TimeUnit pTimeUnit ) {
      // Assign value to attribute
      timeUnit = pTimeUnit;
      return this;
    }

    /**
     * Method creates a new instance of class Duration. The object will be initialized with the values of the builder.
     *
     * @return Duration Created object. The method never returns null.
     */
    public Duration build( ) {
      return new Duration(this);
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
  public TimeUnit getTimeUnit( ) {
    return timeUnit;
  }

  /**
   * Method sets attribute {@link #timeUnit}.<br/>
   *
   * @param pTimeUnit Value to which {@link #timeUnit} should be set.
   */
  public void setTimeUnit( TimeUnit pTimeUnit ) {
    // Assign value to attribute
    timeUnit = pTimeUnit;
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
