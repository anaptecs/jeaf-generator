/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class SessionContextValues implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "timestamp".
   */
  public static final String TIMESTAMP = "timestamp";

  /**
   * Constant for the name of attribute "counter".
   */
  public static final String COUNTER = "counter";

  private String timestamp;

  private Integer counter;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SessionContextValues( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SessionContextValues( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    timestamp = pBuilder.timestamp;
    counter = pBuilder.counter;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SessionContextValues objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SessionContextValues objects. The method never
   * returns null.
   */
  public static Builder builder( SessionContextValues pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SessionContextValues. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String timestamp;

    /**
     * 
     */
    private Integer counter;

    /**
     * Use {@link SessionContextValues#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SessionContextValues#builder(SessionContextValues)} instead of private constructor to create new
     * builder.
     */
    protected Builder( SessionContextValues pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        timestamp = pObject.timestamp;
        counter = pObject.counter;
      }
    }

    /**
     * Method sets the attribute "timestamp".
     * 
     * @param pTimestamp Value to which the attribute "timestamp" should be set.
     */
    public Builder setTimestamp( String pTimestamp ) {
      // Assign value to attribute
      timestamp = pTimestamp;
      return this;
    }

    /**
     * Method sets the attribute "counter".
     * 
     * @param pCounter Value to which the attribute "counter" should be set.
     */
    public Builder setCounter( Integer pCounter ) {
      // Assign value to attribute
      counter = pCounter;
      return this;
    }

    /**
     * Method creates a new instance of class SessionContextValues. The object will be initialized with the values of
     * the builder.
     * 
     * @return SessionContextValues Created object. The method never returns null.
     */
    public SessionContextValues build( ) {
      return new SessionContextValues(this);
    }

    /**
     * Method creates a new validated instance of class SessionContextValues. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return SessionContextValues Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SessionContextValues buildValidated( ) throws ConstraintViolationException {
      SessionContextValues lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #timestamp}.<br/>
   * 
   * @return String Value to which the attribute "timestamp" is set.
   */
  public String getTimestamp( ) {
    return timestamp;
  }

  /**
   * Method sets the attribute "timestamp".
   * 
   * 
   * @param pTimestamp Value to which the attribute "timestamp" should be set.
   */
  public void setTimestamp( String pTimestamp ) {
    // Assign value to attribute
    timestamp = pTimestamp;
  }

  /**
   * Method returns attribute {@link #counter}.<br/>
   * 
   * @return Integer Value to which the attribute "counter" is set.
   */
  public Integer getCounter( ) {
    return counter;
  }

  /**
   * Method sets the attribute "counter".
   * 
   * 
   * @param pCounter Value to which the attribute "counter" should be set.
   */
  public void setCounter( Integer pCounter ) {
    // Assign value to attribute
    counter = pCounter;
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
    lBuilder.append("timestamp: ");
    lBuilder.append(timestamp);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("counter: ");
    lBuilder.append(counter);
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
