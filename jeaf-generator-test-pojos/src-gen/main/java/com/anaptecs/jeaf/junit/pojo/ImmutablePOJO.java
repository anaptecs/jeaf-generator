/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImmutablePOJO {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "something".
   */
  public static final String SOMETHING = "something";

  /**
   * 
   */
  private final String name;

  /**
   * 
   */
  private Integer something;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ImmutablePOJO( ) {
    name = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutablePOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    something = pBuilder.something;
  }

  /**
   * Class implements builder to create a new instance of class ImmutablePOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer something;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ImmutablePOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ImmutablePOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        something = pObject.something;
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
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJO objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ImmutablePOJO pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "something".
     * 
     * @param pSomething Value to which the attribute "something" should be set.
     */
    public Builder setSomething( Integer pSomething ) {
      // Assign value to attribute
      something = pSomething;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutablePOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return ImmutablePOJO Created object. The method never returns null.
     */
    public ImmutablePOJO build( ) {
      return new ImmutablePOJO(this);
    }

    /**
     * Method creates a new instance of class ImmutablePOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ImmutablePOJO Created object. The method never returns null.
     */
    public ImmutablePOJO build( boolean pValidate ) {
      ImmutablePOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns the attribute "something".
   * 
   * 
   * @return Integer Value to which the attribute "something" is set.
   */
  public Integer getSomething( ) {
    return something;
  }

  /**
   * Method sets the attribute "something".
   * 
   * 
   * @param pSomething Value to which the attribute "something" should be set.
   */
  public void setSomething( Integer pSomething ) {
    // Assign value to attribute
    something = pSomething;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "something", "" + something));
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