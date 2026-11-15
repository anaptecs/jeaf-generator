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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "objectType",
    defaultImpl = JSONDefaultParent.class,
    visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = JSONDefaultChildA.class, name = "JSONDefaultChildA"),
  @JsonSubTypes.Type(value = JSONDefaultChildB.class, name = "JSONDefaultChildB") })
@JsonDeserialize(builder = JSONDefaultParent.JSONDefaultParentBuilderImpl.class)
public class JSONDefaultParent {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected JSONDefaultParent( JSONDefaultParentBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link JSONDefaultParentBuilder} New builder that can be used to create new JSONDefaultParent objects.
   */
  public static JSONDefaultParentBuilder<?, ?> builder( ) {
    return new JSONDefaultParentBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class JSONDefaultParent.
   *
   *
   * @return {@link JSONDefaultParent}
   */
  public static JSONDefaultParent of( ) {
    var lBuilder = JSONDefaultParent.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>JSONDefaultParent</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class JSONDefaultParentBuilder<T extends JSONDefaultParent, B extends JSONDefaultParentBuilder<T, B>> {
    /**
     * Use {@link JSONDefaultParent#builder()} instead of private constructor to create new builder.
     */
    protected JSONDefaultParentBuilder( ) {
    }

    /**
     * Use {@link JSONDefaultParent#builder(JSONDefaultParent)} instead of private constructor to create new builder.
     */
    protected JSONDefaultParentBuilder( JSONDefaultParent pObject ) {
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class JSONDefaultParent. The object will be initialized with the values of the
     * builder.
     *
     * @return JSONDefaultParent Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class JSONDefaultParent. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return JSONDefaultParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public JSONDefaultParent buildValidated( ) throws ConstraintViolationException {
      JSONDefaultParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class JSONDefaultParentBuilderImpl
      extends JSONDefaultParentBuilder<JSONDefaultParent, JSONDefaultParentBuilderImpl> {
    protected JSONDefaultParentBuilderImpl( ) {
    }

    protected JSONDefaultParentBuilderImpl( JSONDefaultParent pObject ) {
      super(pObject);
    }

    @Override
    protected JSONDefaultParentBuilderImpl self( ) {
      return this;
    }

    @Override
    public JSONDefaultParent build( ) {
      return new JSONDefaultParent(this);
    }
  }

  @Override
  public int hashCode( ) {
    return 1;
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
      lEquals = true;
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
   * @return {@link JSONDefaultParentBuilder} New builder that can be used to create new JSONDefaultParent objects. The
   * method never returns null.
   */
  public JSONDefaultParentBuilder<?, ?> toBuilder( ) {
    return new JSONDefaultParentBuilderImpl(this);
  }
}