/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = ImmutablePOJO.ImmutablePOJOBuilderImpl.class)
public class ImmutablePOJO {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "something".
   */
  public static final String SOMETHING = "something";

  private final String name;

  private final Integer something;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutablePOJO( ImmutablePOJOBuilder<?, ?> pBuilder ) {
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
  public static ImmutablePOJOBuilder<?, ?> builder( ) {
    return new ImmutablePOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ImmutablePOJO.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pSomething Value to which {@link #something} should be set.
   *
   * @return {@link ImmutablePOJO}
   */
  public static ImmutablePOJO of( String pName, Integer pSomething ) {
    ImmutablePOJOBuilder<?, ?> lBuilder = ImmutablePOJO.builder();
    lBuilder.setName(pName);
    lBuilder.setSomething(pSomething);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ImmutablePOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ImmutablePOJOBuilder<T extends ImmutablePOJO, B extends ImmutablePOJOBuilder<T, B>> {
    private String name;

    private Integer something;

    /**
     * Use {@link ImmutablePOJOBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ImmutablePOJOBuilder( ) {
    }

    /**
     * Use {@link ImmutablePOJOBuilder#builder(ImmutablePOJO)} instead of private constructor to create new builder.
     */
    protected ImmutablePOJOBuilder( ImmutablePOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setSomething(pObject.something);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this.self();
    }

    /**
     * Method sets attribute {@link #something}.<br/>
     *
     * @param pSomething Value to which {@link #something} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSomething( Integer pSomething ) {
      // Assign value to attribute
      something = pSomething;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ImmutablePOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return ImmutablePOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class ImmutablePOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ImmutablePOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutablePOJO buildValidated( ) throws ConstraintViolationException {
      ImmutablePOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class ImmutablePOJOBuilderImpl extends ImmutablePOJOBuilder<ImmutablePOJO, ImmutablePOJOBuilderImpl> {
    protected ImmutablePOJOBuilderImpl( ) {
    }

    protected ImmutablePOJOBuilderImpl( ImmutablePOJO pObject ) {
      super(pObject);
    }

    @Override
    protected ImmutablePOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public ImmutablePOJO build( ) {
      ImmutablePOJO lObject = new ImmutablePOJO(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns attribute {@link #something}.<br/>
   *
   * @return {@link Integer} Value to which {@link #something} is set.
   */
  public Integer getSomething( ) {
    return something;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(name);
    lResult = lPrime * lResult + Objects.hashCode(something);
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
      ImmutablePOJO lOther = (ImmutablePOJO) pObject;
      lEquals = Objects.equals(name, lOther.name) && Objects.equals(something, lOther.something);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJO objects. The method never returns
   * null.
   */
  public ImmutablePOJOBuilder<?, ?> toBuilder( ) {
    return new ImmutablePOJOBuilderImpl(this);
  }
}