/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.PositiveOrZero;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PlainPOJOBase {
  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  /**
   * Constant for the name of attribute "world".
   */
  public static final String WORLD = "world";

  private String hello;

  @PositiveOrZero
  private Integer world;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PlainPOJOBase( ) {
  }

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
   * Class implements builder to create a new instance of class PlainPOJO. As the class has read only attributes or
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
    @PositiveOrZero
    private Integer world;

    /**
     * Use {@link PlainPOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link PlainPOJO.builder(PlainPOJO)} instead of protected constructor to create new builder.
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
     * Method creates a new validated instance of class PlainPOJO. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return PlainPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PlainPOJO buildValidated( ) throws ConstraintViolationException {
      PlainPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #hello}.<br/>
   * 
   * @return String Value to which {@link #hello} is set.
   */
  public String getHello( ) {
    return hello;
  }

  /**
   * Method sets attribute {@link #hello}.<br/>
   * 
   * @param pHello Value to which {@link #hello} should be set.
   */
  public void setHello( String pHello ) {
    // Assign value to attribute
    hello = pHello;
  }

  /**
   * Method returns attribute {@link #world}.<br/>
   * 
   * @return Integer Value to which {@link #world} is set.
   */
  public Integer getWorld( ) {
    return world;
  }

  /**
   * Method sets attribute {@link #world}.<br/>
   * 
   * @param pWorld Value to which {@link #world} should be set.
   */
  public void setWorld( Integer pWorld ) {
    // Assign value to attribute
    world = pWorld;
  }

  /**
   * @deprecated (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  public abstract void doDeprectedStuff( );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @param pParam2
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  public abstract String doSomething( @Deprecated int pParam1, int pParam2 );

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
    lBuilder.append("hello: ");
    lBuilder.append(hello);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("world: ");
    lBuilder.append(world);
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
