/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
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
@JsonDeserialize(builder = BusinessChild.BusinessChildBuilderImpl.class)
public class BusinessChild extends BusinessParent {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  private String childAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BusinessChild( BusinessChildBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link BusinessChildBuilder} New builder that can be used to create new BusinessChild objects.
   */
  public static BusinessChildBuilder<?, ?> builder( ) {
    return new BusinessChildBuilderImpl();
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
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BusinessChildBuilder<T extends BusinessChild, B extends BusinessChildBuilder<T, B>>
      extends BusinessParentBuilder<T, B> {
    private String childAttribute;

    /**
     * Use {@link BusinessChild#builder()} instead of private constructor to create new builder.
     */
    protected BusinessChildBuilder( ) {
      super();
    }

    /**
     * Use {@link BusinessChild#builder(BusinessChild)} instead of private constructor to create new builder.
     */
    protected BusinessChildBuilder( BusinessChild pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAttribute(pObject.childAttribute);
      }
    }

    /**
     * Method sets attribute {@link #childAttribute}.<br/>
     *
     * @param pChildAttribute Value to which {@link #childAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChildAttribute( @MyNotNullProperty String pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this.self();
    }

    /**
     * Method creates a new instance of class BusinessChild. The object will be initialized with the values of the
     * builder.
     *
     * @return BusinessChild Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BusinessChildBuilderImpl extends BusinessChildBuilder<BusinessChild, BusinessChildBuilderImpl> {
    protected BusinessChildBuilderImpl( ) {
    }

    protected BusinessChildBuilderImpl( BusinessChild pObject ) {
      super(pObject);
    }

    @Override
    protected BusinessChildBuilderImpl self( ) {
      return this;
    }

    @Override
    public BusinessChild build( ) {
      BusinessChild lObject = new BusinessChild(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #childAttribute} is set.
   */
  @MyNotNullProperty
  public String getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method sets attribute {@link #childAttribute}.<br/>
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   */
  public void setChildAttribute( @MyNotNullProperty String pChildAttribute ) {
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
   * @return {@link BusinessChildBuilder} New builder that can be used to create new BusinessChild objects. The method
   * never returns null.
   */
  public BusinessChildBuilder<?, ?> toBuilder( ) {
    return new BusinessChildBuilderImpl(this);
  }
}