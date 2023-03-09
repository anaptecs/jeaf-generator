/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.techbase;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

public class BusinessChild extends BusinessParent {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BusinessChild objects. The method never returns
   * null.
   */
  public static Builder builder( BusinessChild pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class BusinessChild. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends BusinessParent.Builder {
    /**
     * 
     */
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
        childAttribute = pObject.childAttribute;
      }
    }

    /**
     * Method sets the attribute "techAttribute".
     * 
     * @param pTechAttribute Value to which the attribute "techAttribute" should be set.
     */
    @Override
    public Builder setTechAttribute( String pTechAttribute ) {
      // Call super class implementation.
      super.setTechAttribute(pTechAttribute);
      return this;
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    @Override
    public Builder setParentAttribute( long pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "childAttribute".
     * 
     * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
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
      BusinessChild lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #childAttribute}.<br/>
   * 
   * @return String Value to which {@link #childAttribute} is set.
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

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
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
}
