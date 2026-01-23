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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = BChildPOJO.class, name = "BChildPOJO") })
@JsonDeserialize(builder = BParentPOJO.BParentPOJOBuilderImpl.class)
public class BParentPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  private final String parentAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BParentPOJO( BParentPOJOBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link BParentPOJOBuilder} New builder that can be used to create new BParentPOJO objects.
   */
  public static BParentPOJOBuilder<?, ?> builder( ) {
    return new BParentPOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class BParentPOJO.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @return {@link BParentPOJO}
   */
  public static BParentPOJO of( String pParentAttribute ) {
    var lBuilder = BParentPOJO.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BParentPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BParentPOJOBuilder<T extends BParentPOJO, B extends BParentPOJOBuilder<T, B>> {
    private String parentAttribute;

    /**
     * Use {@link BParentPOJO#builder()} instead of private constructor to create new builder.
     */
    protected BParentPOJOBuilder( ) {
    }

    /**
     * Use {@link BParentPOJO#builder(BParentPOJO)} instead of private constructor to create new builder.
     */
    protected BParentPOJOBuilder( BParentPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class BParentPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return BParentPOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class BParentPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return BParentPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BParentPOJO buildValidated( ) throws ConstraintViolationException {
      BParentPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class BParentPOJOBuilderImpl extends BParentPOJOBuilder<BParentPOJO, BParentPOJOBuilderImpl> {
    protected BParentPOJOBuilderImpl( ) {
    }

    protected BParentPOJOBuilderImpl( BParentPOJO pObject ) {
      super(pObject);
    }

    @Override
    protected BParentPOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public BParentPOJO build( ) {
      return new BParentPOJO(this);
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(parentAttribute);
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
      BParentPOJO lOther = (BParentPOJO) pObject;
      lEquals = Objects.equals(parentAttribute, lOther.parentAttribute);
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
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
   * @return {@link BParentPOJOBuilder} New builder that can be used to create new BParentPOJO objects. The method never
   * returns null.
   */
  public BParentPOJOBuilder<?, ?> toBuilder( ) {
    return new BParentPOJOBuilderImpl(this);
  }
}