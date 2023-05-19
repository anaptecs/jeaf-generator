/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.techbase;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@Valid
public class BusinessA extends TechParent {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  private int businessAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BusinessA( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BusinessA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    businessAttribute = pBuilder.businessAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BusinessA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BusinessA objects. The method never returns
   * null.
   */
  public static Builder builder( BusinessA pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pTechAttribute, int pBusinessAttribute ) {
    Builder lBuilder = builder();
    lBuilder.setTechAttribute(pTechAttribute);
    lBuilder.setBusinessAttribute(pBusinessAttribute);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>BusinessA</code>.
   */
  public static class Builder extends TechParent.Builder {
    private int businessAttribute;

    /**
     * Use {@link BusinessA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link BusinessA#builder(BusinessA)} instead of private constructor to create new builder.
     */
    protected Builder( BusinessA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        businessAttribute = pObject.businessAttribute;
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
     * Method sets attribute {@link #businessAttribute}.<br/>
     *
     * @param pBusinessAttribute Value to which {@link #businessAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBusinessAttribute( int pBusinessAttribute ) {
      // Assign value to attribute
      businessAttribute = pBusinessAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class BusinessA. The object will be initialized with the values of the builder.
     *
     * @return BusinessA Created object. The method never returns null.
     */
    public BusinessA build( ) {
      return new BusinessA(this);
    }

    /**
     * Method creates a new validated instance of class BusinessA. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return BusinessA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BusinessA buildValidated( ) throws ConstraintViolationException {
      BusinessA lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #businessAttribute}.<br/>
   *
   * @return int Value to which {@link #businessAttribute} is set.
   */
  public int getBusinessAttribute( ) {
    return businessAttribute;
  }

  /**
   * Method sets attribute {@link #businessAttribute}.<br/>
   *
   * @param pBusinessAttribute Value to which {@link #businessAttribute} should be set.
   */
  public void setBusinessAttribute( int pBusinessAttribute ) {
    // Assign value to attribute
    businessAttribute = pBusinessAttribute;
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
    lBuilder.append("businessAttribute: ");
    lBuilder.append(businessAttribute);
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
