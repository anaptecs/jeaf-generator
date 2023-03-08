/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJO objects. The method never returns
   * null.
   */
  public static Builder builder( ImmutablePOJO pObject ) {
    return new Builder(pObject);
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
     * Use {@link ImmutablePOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ImmutablePOJO#builder(ImmutablePOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ImmutablePOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        something = pObject.something;
      }
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
     * Method creates a new validated instance of class ImmutablePOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ImmutablePOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutablePOJO buildValidated( ) throws ConstraintViolationException {
      ImmutablePOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("something: ");
    lBuilder.append(something);
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
