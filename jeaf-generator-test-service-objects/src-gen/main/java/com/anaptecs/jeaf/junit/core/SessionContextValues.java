/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private String timestamp;

  /**
   * 
   */
  private Integer counter;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SessionContextValues( ) {
    // Nothing to do.
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
   * Class implements builder to create a new instance of class SessionContextValues. As the class has readonly
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(SessionContextValues)} instead of private constructor to create new builder.
     */
    protected Builder( SessionContextValues pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        timestamp = pObject.timestamp;
        counter = pObject.counter;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new SessionContextValues objects. The method never
     * returns null.
     */
    public static Builder newBuilder( SessionContextValues pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class SessionContextValues. The object will be initialized with the values of
     * the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return SessionContextValues Created object. The method never returns null.
     */
    public SessionContextValues build( boolean pValidate ) {
      SessionContextValues lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "timestamp".
   * 
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
   * Method returns the attribute "counter".
   * 
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "timestamp", "" + timestamp));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "counter", "" + counter));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}