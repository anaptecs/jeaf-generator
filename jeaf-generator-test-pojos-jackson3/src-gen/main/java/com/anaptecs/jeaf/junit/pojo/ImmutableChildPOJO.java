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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = ImmutableChildPOJO.ImmutableChildPOJOBuilderImpl.class)
public class ImmutableChildPOJO extends ImmutablePOJOParent {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  /**
   * Constant for the name of attribute "anotherChildAttribute".
   */
  public static final String ANOTHERCHILDATTRIBUTE = "anotherChildAttribute";

  private final String childAttribute;

  private final Double anotherChildAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutableChildPOJO( ImmutableChildPOJOBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
    anotherChildAttribute = pBuilder.anotherChildAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link ImmutableChildPOJOBuilder} New builder that can be used to create new ImmutableChildPOJO objects.
   */
  public static ImmutableChildPOJOBuilder<?, ?> builder( ) {
    return new ImmutableChildPOJOBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class ImmutableChildPOJO.
   *
   *
   * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   *
   * @param pAnotherChildAttribute Value to which {@link #anotherChildAttribute} should be set.
   *
   * @return {@link ImmutableChildPOJO}
   */
  public static ImmutableChildPOJO of( String pAbtractAttr, String pParentAttribute, Integer pAnotherParentAttribute,
      String pChildAttribute, Double pAnotherChildAttribute ) {
    var lBuilder = ImmutableChildPOJO.builder();
    lBuilder.setAbtractAttr(pAbtractAttr);
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setAnotherParentAttribute(pAnotherParentAttribute);
    lBuilder.setChildAttribute(pChildAttribute);
    lBuilder.setAnotherChildAttribute(pAnotherChildAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ImmutableChildPOJO</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ImmutableChildPOJOBuilder<T extends ImmutableChildPOJO, B extends ImmutableChildPOJOBuilder<T, B>>
      extends ImmutablePOJOParentBuilder<T, B> {
    private String childAttribute;

    private Double anotherChildAttribute;

    /**
     * Use {@link ImmutableChildPOJO#builder()} instead of private constructor to create new builder.
     */
    protected ImmutableChildPOJOBuilder( ) {
      super();
    }

    /**
     * Use {@link ImmutableChildPOJO#builder(ImmutableChildPOJO)} instead of private constructor to create new builder.
     */
    protected ImmutableChildPOJOBuilder( ImmutableChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAttribute(pObject.childAttribute);
        this.setAnotherChildAttribute(pObject.anotherChildAttribute);
      }
    }

    /**
     * Method sets attribute {@link #childAttribute}.<br/>
     *
     * @param pChildAttribute Value to which {@link #childAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChildAttribute( String pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this.self();
    }

    /**
     * Method sets attribute {@link #anotherChildAttribute}.<br/>
     *
     * @param pAnotherChildAttribute Value to which {@link #anotherChildAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAnotherChildAttribute( Double pAnotherChildAttribute ) {
      // Assign value to attribute
      anotherChildAttribute = pAnotherChildAttribute;
      return this.self();
    }

    /**
     * Method creates a new instance of class ImmutableChildPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return ImmutableChildPOJO Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class ImmutableChildPOJO. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ImmutableChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutableChildPOJO buildValidated( ) throws ConstraintViolationException {
      ImmutableChildPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class ImmutableChildPOJOBuilderImpl
      extends ImmutableChildPOJOBuilder<ImmutableChildPOJO, ImmutableChildPOJOBuilderImpl> {
    protected ImmutableChildPOJOBuilderImpl( ) {
    }

    protected ImmutableChildPOJOBuilderImpl( ImmutableChildPOJO pObject ) {
      super(pObject);
    }

    @Override
    protected ImmutableChildPOJOBuilderImpl self( ) {
      return this;
    }

    @Override
    public ImmutableChildPOJO build( ) {
      return new ImmutableChildPOJO(this);
    }
  }

  /**
   * Method returns attribute {@link #childAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #childAttribute} is set.
   */
  public String getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method returns attribute {@link #anotherChildAttribute}.<br/>
   *
   * @return {@link Double} Value to which {@link #anotherChildAttribute} is set.
   */
  public Double getAnotherChildAttribute( ) {
    return anotherChildAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(childAttribute);
    lResult = lPrime * lResult + Objects.hashCode(anotherChildAttribute);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      ImmutableChildPOJO lOther = (ImmutableChildPOJO) pObject;
      lEquals = Objects.equals(childAttribute, lOther.childAttribute)
          && Objects.equals(anotherChildAttribute, lOther.anotherChildAttribute);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childAttribute: ");
    lBuilder.append(childAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anotherChildAttribute: ");
    lBuilder.append(anotherChildAttribute);
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
   * @return {@link ImmutableChildPOJOBuilder} New builder that can be used to create new ImmutableChildPOJO objects.
   * The method never returns null.
   */
  public ImmutableChildPOJOBuilder<?, ?> toBuilder( ) {
    return new ImmutableChildPOJOBuilderImpl(this);
  }
}