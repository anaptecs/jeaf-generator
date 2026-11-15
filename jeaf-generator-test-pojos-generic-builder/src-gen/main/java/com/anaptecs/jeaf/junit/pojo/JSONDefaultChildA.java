/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "objectType",
    defaultImpl = JSONDefaultChildA.class,
    visible = true)
@JsonDeserialize(builder = JSONDefaultChildA.JSONDefaultChildABuilderImpl.class)
public class JSONDefaultChildA extends JSONDefaultParent {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected JSONDefaultChildA( JSONDefaultChildABuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link JSONDefaultChildABuilder} New builder that can be used to create new JSONDefaultChildA objects.
   */
  public static JSONDefaultChildABuilder<?, ?> builder( ) {
    return new JSONDefaultChildABuilderImpl();
  }

  /**
   * Convenience method to create new instance of class JSONDefaultChildA.
   *
   *
   * @return {@link JSONDefaultChildA}
   */
  public static JSONDefaultChildA of( ) {
    var lBuilder = JSONDefaultChildA.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>JSONDefaultChildA</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class JSONDefaultChildABuilder<T extends JSONDefaultChildA, B extends JSONDefaultChildABuilder<T, B>>
      extends JSONDefaultParentBuilder<T, B> {
    /**
     * Use {@link JSONDefaultChildA#builder()} instead of private constructor to create new builder.
     */
    protected JSONDefaultChildABuilder( ) {
      super();
    }

    /**
     * Use {@link JSONDefaultChildA#builder(JSONDefaultChildA)} instead of private constructor to create new builder.
     */
    protected JSONDefaultChildABuilder( JSONDefaultChildA pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class JSONDefaultChildA. The object will be initialized with the values of the
     * builder.
     *
     * @return JSONDefaultChildA Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class JSONDefaultChildA. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return JSONDefaultChildA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public JSONDefaultChildA buildValidated( ) throws ConstraintViolationException {
      JSONDefaultChildA lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class JSONDefaultChildABuilderImpl
      extends JSONDefaultChildABuilder<JSONDefaultChildA, JSONDefaultChildABuilderImpl> {
    protected JSONDefaultChildABuilderImpl( ) {
    }

    protected JSONDefaultChildABuilderImpl( JSONDefaultChildA pObject ) {
      super(pObject);
    }

    @Override
    protected JSONDefaultChildABuilderImpl self( ) {
      return this;
    }

    @Override
    public JSONDefaultChildA build( ) {
      return new JSONDefaultChildA(this);
    }
  }

  @Override
  public int hashCode( ) {
    return super.hashCode();
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      lEquals = true;
    }
    return lEquals;
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link JSONDefaultChildABuilder} New builder that can be used to create new JSONDefaultChildA objects. The
   * method never returns null.
   */
  public JSONDefaultChildABuilder<?, ?> toBuilder( ) {
    return new JSONDefaultChildABuilderImpl(this);
  }
}