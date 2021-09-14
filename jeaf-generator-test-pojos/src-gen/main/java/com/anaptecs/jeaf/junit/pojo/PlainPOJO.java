/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PlainPOJO {
  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  /**
   * Constant for the name of attribute "world".
   */
  public static final String WORLD = "world";

  /**
   * 
   */
  private String hello;

  /**
   * 
   */
  private Integer world;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PlainPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    hello = pBuilder.hello;
    world = pBuilder.world;
  }

  /**
   * Class implements builder to create a new instance of class PlainPOJO. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String hello;

    /**
     * 
     */
    private Integer world;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PlainPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( PlainPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        hello = pObject.hello;
        world = pObject.world;
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
     * @return {@link Builder} New builder that can be used to create new PlainPOJO objects. The method never returns
     * null.
     */
    public static Builder newBuilder( PlainPOJO pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    public Builder setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method sets the attribute "world".
     * 
     * @param pWorld Value to which the attribute "world" should be set.
     */
    public Builder setWorld( Integer pWorld ) {
      // Assign value to attribute
      world = pWorld;
      return this;
    }

    /**
     * Method creates a new instance of class PlainPOJO. The object will be initialized with the values of the builder.
     * 
     * @return PlainPOJO Created object. The method never returns null.
     */
    public PlainPOJO build( ) {
      return new PlainPOJO(this);
    }

    /**
     * Method creates a new instance of class PlainPOJO. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return PlainPOJO Created object. The method never returns null.
     */
    public PlainPOJO build( boolean pValidate ) {
      PlainPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "hello".
   * 
   * 
   * @return String Value to which the attribute "hello" is set.
   */
  public String getHello( ) {
    return hello;
  }

  /**
   * Method sets the attribute "hello".
   * 
   * 
   * @param pHello Value to which the attribute "hello" should be set.
   */
  public void setHello( String pHello ) {
    // Assign value to attribute
    hello = pHello;
  }

  /**
   * Method returns the attribute "world".
   * 
   * 
   * @return Integer Value to which the attribute "world" is set.
   */
  public Integer getWorld( ) {
    return world;
  }

  /**
   * Method sets the attribute "world".
   * 
   * 
   * @param pWorld Value to which the attribute "world" should be set.
   */
  public void setWorld( Integer pWorld ) {
    // Assign value to attribute
    world = pWorld;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "hello", "" + hello));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "world", "" + world));
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