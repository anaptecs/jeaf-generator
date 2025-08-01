/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = BusinessA.Builder.class)
public class BusinessA extends TechParent {
  /**
   * Constant for the name of attribute "businessAttribute".
   */
  public static final String BUSINESSATTRIBUTE = "businessAttribute";

  private int businessAttribute;

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
   * Convenience method to create new instance of class BusinessA.
   *
   *
   * @param pTechAttribute Value to which {@link #techAttribute} should be set.
   *
   * @param pBusinessAttribute Value to which {@link #businessAttribute} should be set.
   *
   * @return {@link BusinessA}
   */
  public static BusinessA of( String pTechAttribute, int pBusinessAttribute ) {
    var lBuilder = BusinessA.builder();
    lBuilder.setTechAttribute(pTechAttribute);
    lBuilder.setBusinessAttribute(pBusinessAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BusinessA</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
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
        this.setBusinessAttribute(pObject.businessAttribute);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new BusinessA objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}