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
 * NOVA 14 Mapping<br/>
 * * nova-base.xsd.Dauer
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

  /**
   * 
   */
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Duration objects. The method never returns null.
   */
  public static Builder builder( Duration pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Duration. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private int value;

    /**
     * 
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
        value = pObject.value;
        timeUnit = pObject.timeUnit;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Duration objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Duration objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Duration pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "value".
     * 
     * @param pValue Value to which the attribute "value" should be set.
     */
    public Builder setValue( int pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method sets the attribute "timeUnit".
     * 
     * @param pTimeUnit Value to which the attribute "timeUnit" should be set.
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
   * Method returns the attribute "value".
   * 
   * 
   * @return int Value to which the attribute "value" is set.
   */
  public int getValue( ) {
    return value;
  }

  /**
   * Method sets the attribute "value".
   * 
   * 
   * @param pValue Value to which the attribute "value" should be set.
   */
  public void setValue( int pValue ) {
    // Assign value to attribute
    value = pValue;
  }

  /**
   * Method returns the attribute "timeUnit".
   * 
   * 
   * @return TimeUnit Value to which the attribute "timeUnit" is set.
   */
  public TimeUnit getTimeUnit( ) {
    return timeUnit;
  }

  /**
   * Method sets the attribute "timeUnit".
   * 
   * 
   * @param pTimeUnit Value to which the attribute "timeUnit" should be set.
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
}
