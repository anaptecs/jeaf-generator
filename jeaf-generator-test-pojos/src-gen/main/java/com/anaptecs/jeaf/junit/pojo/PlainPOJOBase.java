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
public abstract class PlainPOJOBase {
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
  protected PlainPOJOBase( BuilderBase pBuilder ) {
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
  public static abstract class BuilderBase {
    /**
     * 
     */
    private String hello;

    /**
     * 
     */
    private Integer world;

    /**
     * Use {@link PlainPOJO.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link PlainPOJO.Builder#newBuilder(PlainPOJO)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( PlainPOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        hello = pObject.hello;
        world = pObject.world;
      }
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    public BuilderBase setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method sets the attribute "world".
     * 
     * @param pWorld Value to which the attribute "world" should be set.
     */
    public BuilderBase setWorld( Integer pWorld ) {
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
  * 
  */
  @Deprecated
  public abstract void doDeprectedStuff( );

  /**
   * 
   * @param pParam1
   * @param pParam2
   * @return {@link String}
   */
  @Deprecated
  public abstract String doSomething( @Deprecated int pParam1, int pParam2 );

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