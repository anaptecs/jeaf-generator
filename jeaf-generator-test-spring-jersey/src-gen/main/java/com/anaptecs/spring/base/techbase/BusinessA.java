/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessA extends TechParent {
  /**
   * Constant for the name of attribute "businessAttribute".
   */
  public static final String BUSINESSATTRIBUTE = "businessAttribute";

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
   * Class implements builder to create a new instance of class BusinessA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends TechParent.Builder {
    /**
     * 
     */
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
     * Method sets the attribute "businessAttribute".
     * 
     * @param pBusinessAttribute Value to which the attribute "businessAttribute" should be set.
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
  }

  /**
   * Method returns attribute {@link #businessAttribute}.<br/>
   * 
   * @return int Value to which the attribute "businessAttribute" is set.
   */
  public int getBusinessAttribute( ) {
    return businessAttribute;
  }

  /**
   * Method sets the attribute "businessAttribute".
   * 
   * 
   * @param pBusinessAttribute Value to which the attribute "businessAttribute" should be set.
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
