/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.techbase;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Valid
public class BusinessChild extends BusinessParent {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String childAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BusinessChild( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BusinessChild( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BusinessChild objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pTechAttribute, long pParentAttribute, String pChildAttribute ) {
    Builder lBuilder = builder();
    lBuilder.setTechAttribute(pTechAttribute);
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setChildAttribute(pChildAttribute);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class BusinessChild.
   *
   *
   * @param pTechAttribute Value to which {@link #techAttribute} should be set.
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   *
   * @return {@link BusinessChild}
   */
  public static BusinessChild of( String pTechAttribute, long pParentAttribute, String pChildAttribute ) {
    var lBuilder = BusinessChild.builder();
    lBuilder.setTechAttribute(pTechAttribute);
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setChildAttribute(pChildAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BusinessChild</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder extends BusinessParent.Builder {
    private String childAttribute;

    /**
     * Use {@link BusinessChild#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link BusinessChild#builder(BusinessChild)} instead of private constructor to create new builder.
     */
    protected Builder( BusinessChild pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAttribute(pObject.childAttribute);
      }
    }

    /**
     * Method sets attribute {@link #techAttribute}.<br/>
     *
     * @param pTechAttribute Value to which {@link #techAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setTechAttribute( String pTechAttribute ) {
      // Call super class implementation.
      super.setTechAttribute(pTechAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setParentAttribute( long pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #childAttribute}.<br/>
     *
     * @param pChildAttribute Value to which {@link #childAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildAttribute( String pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class BusinessChild. The object will be initialized with the values of the
     * builder.
     *
     * @return BusinessChild Created object. The method never returns null.
     */
    public BusinessChild build( ) {
      return new BusinessChild(this);
    }

    /**
     * Method creates a new validated instance of class BusinessChild. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return BusinessChild Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BusinessChild buildValidated( ) throws ConstraintViolationException {
      BusinessChild lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * Method sets attribute {@link #childAttribute}.<br/>
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   */
  public void setChildAttribute( String pChildAttribute ) {
    // Assign value to attribute
    childAttribute = pChildAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(childAttribute);
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
      BusinessChild lOther = (BusinessChild) pObject;
      lEquals = Objects.equals(childAttribute, lOther.childAttribute);
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
   * @return {@link Builder} New builder that can be used to create new BusinessChild objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}