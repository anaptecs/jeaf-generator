/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = BusinessA.BusinessABuilderImpl.class)
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
  protected BusinessA( BusinessABuilder<?, ?> pBuilder ) {
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
  public static BusinessABuilder<?, ?> builder( ) {
    return new BusinessABuilderImpl();
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
  public static abstract class BusinessABuilder<T extends BusinessA, S extends BusinessABuilder<T, S>>
      extends TechParentBuilder<T, S> {
    private int businessAttribute;

    /**
     * Use {@link BusinessABuilder#builder()} instead of private constructor to create new builder.
     */
    protected BusinessABuilder( ) {
      super();
    }

    /**
     * Use {@link BusinessABuilder#builder(BusinessA)} instead of private constructor to create new builder.
     */
    protected BusinessABuilder( BusinessA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBusinessAttribute(pObject.businessAttribute);
      }
    }

    /**
     * Method sets attribute {@link #businessAttribute}.<br/>
     *
     * @param pBusinessAttribute Value to which {@link #businessAttribute} should be set.
     * @return {@link S} Instance of this builder to support chaining setters. Method never returns null.
     */
    public S setBusinessAttribute( int pBusinessAttribute ) {
      // Assign value to attribute
      businessAttribute = pBusinessAttribute;
      return this.self();
    }

    /**
     * Method creates a new instance of class BusinessA. The object will be initialized with the values of the builder.
     *
     * @return BusinessA Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BusinessABuilderImpl extends BusinessABuilder<BusinessA, BusinessABuilderImpl> {
    protected BusinessABuilderImpl( ) {
    }

    protected BusinessABuilderImpl( BusinessA pObject ) {
      super(pObject);
    }

    @Override
    protected BusinessABuilderImpl self( ) {
      return this;
    }

    @Override
    public BusinessA build( ) {
      BusinessA lObject = new BusinessA(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + businessAttribute;
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
      BusinessA lOther = (BusinessA) pObject;
      lEquals = businessAttribute == lOther.businessAttribute;
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
  public BusinessABuilder<?, ?> toBuilder( ) {
    return new BusinessABuilderImpl(this);
  }
}