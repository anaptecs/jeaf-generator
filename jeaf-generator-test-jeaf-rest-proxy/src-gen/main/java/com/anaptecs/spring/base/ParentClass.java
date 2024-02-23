/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildA.class, name = "ChildA"),
  @JsonSubTypes.Type(value = ChildAA.class, name = "ChildAA"),
  @JsonSubTypes.Type(value = ChildB.class, name = "ChildB"),
  @JsonSubTypes.Type(value = ChildBB.class, name = "ChildBB") })
public class ParentClass implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  private String parentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentClass( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentClass( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentClass objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pParentAttribute ) {
    Builder lBuilder = builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class ParentClass.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @return {@link com.anaptecs.spring.base.ParentClass}
   */
  public static ParentClass of( String pParentAttribute ) {
    ParentClass.Builder lBuilder = ParentClass.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentClass</code>.
   */
  public static class Builder {
    private String parentAttribute;

    /**
     * Use {@link ParentClass#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentClass#builder(ParentClass)} instead of private constructor to create new builder.
     */
    protected Builder( ParentClass pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
      }
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
     * Method creates a new instance of class ParentClass. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentClass Created object. The method never returns null.
     */
    public ParentClass build( ) {
      return new ParentClass(this);
    }

    /**
     * Method creates a new validated instance of class ParentClass. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return ParentClass Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentClass buildValidated( ) throws ConstraintViolationException {
      ParentClass lObject = this.build();
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
   * Method sets attribute {@link #parentAttribute}.<br/>
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   */
  public void setParentAttribute( String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
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
   * @return {@link Builder} New builder that can be used to create new ParentClass objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
