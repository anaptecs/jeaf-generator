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

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImmutablePOJOParent extends AbstractPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "anotherParentAttribute".
   */
  public static final String ANOTHERPARENTATTRIBUTE = "anotherParentAttribute";

  private final String parentAttribute;

  private Integer anotherParentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ImmutablePOJOParent( ) {
    parentAttribute = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutablePOJOParent( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    anotherParentAttribute = pBuilder.anotherParentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ImmutablePOJOParent.
   *
   *
   * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.pojo.ImmutablePOJOParent}
   */
  public static ImmutablePOJOParent of( String pAbtractAttr, String pParentAttribute,
      Integer pAnotherParentAttribute ) {
    ImmutablePOJOParent.Builder lBuilder = ImmutablePOJOParent.builder();
    lBuilder.setAbtractAttr(pAbtractAttr);
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setAnotherParentAttribute(pAnotherParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ImmutablePOJOParent</code>.
   */
  public static class Builder extends AbstractPOJO.Builder {
    private String parentAttribute;

    private Integer anotherParentAttribute;

    /**
     * Use {@link ImmutablePOJOParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ImmutablePOJOParent#builder(ImmutablePOJOParent)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ImmutablePOJOParent pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
        this.setAnotherParentAttribute(pObject.anotherParentAttribute);
      }
    }

    /**
     * Method sets attribute {@link #abtractAttr}.<br/>
     *
     * @param pAbtractAttr Value to which {@link #abtractAttr} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setAbtractAttr( String pAbtractAttr ) {
      // Call super class implementation.
      super.setAbtractAttr(pAbtractAttr);
      return this;
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #anotherParentAttribute}.<br/>
     *
     * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
      // Assign value to attribute
      anotherParentAttribute = pAnotherParentAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutablePOJOParent. The object will be initialized with the values of the
     * builder.
     *
     * @return ImmutablePOJOParent Created object. The method never returns null.
     */
    public ImmutablePOJOParent build( ) {
      return new ImmutablePOJOParent(this);
    }

    /**
     * Method creates a new validated instance of class ImmutablePOJOParent. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ImmutablePOJOParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutablePOJOParent buildValidated( ) throws ConstraintViolationException {
      ImmutablePOJOParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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

  /**
   * Method returns attribute {@link #anotherParentAttribute}.<br/>
   *
   * @return {@link Integer} Value to which {@link #anotherParentAttribute} is set.
   */
  public Integer getAnotherParentAttribute( ) {
    return anotherParentAttribute;
  }

  /**
   * Method sets attribute {@link #anotherParentAttribute}.<br/>
   *
   * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
   */
  public void setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
    // Assign value to attribute
    anotherParentAttribute = pAnotherParentAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(parentAttribute);
    lResult = lPrime * lResult + Objects.hashCode(anotherParentAttribute);
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
      ImmutablePOJOParent lOther = (ImmutablePOJOParent) pObject;
      lEquals = Objects.equals(parentAttribute, lOther.parentAttribute)
          && Objects.equals(anotherParentAttribute, lOther.anotherParentAttribute);
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anotherParentAttribute: ");
    lBuilder.append(anotherParentAttribute);
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
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
