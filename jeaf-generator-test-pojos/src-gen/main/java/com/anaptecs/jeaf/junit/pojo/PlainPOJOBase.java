/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.PositiveOrZero;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = PlainPOJO.Builder.class)
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
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>Hello</code></li>
   * <li><code>World!</code></li>
   * </ul>
   */
  private String hello;

  @PositiveOrZero
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
   * Class implements builder to create a new instance of class PlainPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>Hello</code></li>
     * <li><code>World!</code></li>
     * </ul>
     */
    private String hello;

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
        this.setHello(pObject.hello);
        this.setWorld(pObject.world);
      }
    }

    /**
     * Method sets attribute {@link #hello}.<br/>
     *
     * @param pHello Value to which {@link #hello} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public BuilderBase setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method sets attribute {@link #world}.<br/>
     *
     * @param pWorld Value to which {@link #world} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
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
      PlainPOJO lObject = new PlainPOJO(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * @return {@link String} Value to which {@link #hello} is set.
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
   * @return {@link Integer} Value to which {@link #world} is set.
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
   * Convenience method to create new instance of class PlainPOJO.
   *
   *
   * @param pHello Value to which {@link #hello} should be set.
   *
   * @param pWorld Value to which {@link #world} should be set.
   *
   * @return {@link PlainPOJO}
   */
  public static PlainPOJO of( String pHello, Integer pWorld ) {
    var lBuilder = PlainPOJO.builder();
    lBuilder.setHello(pHello);
    lBuilder.setWorld(pWorld);
    return lBuilder.build();
  }

  /**
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(hello);
    lResult = lPrime * lResult + Objects.hashCode(world);
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
      PlainPOJOBase lOther = (PlainPOJOBase) pObject;
      lEquals = Objects.equals(hello, lOther.hello) && Objects.equals(world, lOther.world);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new PlainPOJO objects. The method never returns
   * null.
   */
  public PlainPOJO.Builder toBuilder( ) {
    return new PlainPOJO.Builder((PlainPOJO) this);
  }
}