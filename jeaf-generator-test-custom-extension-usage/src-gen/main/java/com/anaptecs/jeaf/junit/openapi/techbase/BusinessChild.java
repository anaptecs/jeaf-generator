/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.techbase;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
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

  // "String"
  @ClassPropertyDeclaration
  private String childAttribute;

  // "String"
  private int childAttributeXYZ = 0;

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
    // "String"
    childAttributeXYZ = pBuilder.childAttributeXYZ;
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
   * Class implements builder to create a new instance of class <code>BusinessChild</code>.
   */
  public static class Builder extends BusinessParent.Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String childAttribute;

    // "String"
    private int childAttributeXYZ = 0;

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

    public Builder setChildAttributeXYZ( int value ) {
      // "String"
      childAttributeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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

  public int getChildAttributeXYZ( ) {
    // "String"
    return childAttributeXYZ;
  }

  public void setChildAttributeXYZ( int value ) {
    childAttributeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
