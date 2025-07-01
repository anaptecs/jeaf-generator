/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = BusinessChild.class, name = "BusinessChild") })
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = BusinessParent.BusinessParentBuilderImpl.class)
public class BusinessParent extends TechParent {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  private long parentAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BusinessParent( BusinessParentBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link BusinessParentBuilder} New builder that can be used to create new BusinessParent objects.
   */
  public static BusinessParentBuilder<?, ?> builder( ) {
    return new BusinessParentBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class BusinessParent.
   *
   *
   * @param pTechAttribute Value to which {@link #techAttribute} should be set.
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @return {@link BusinessParent}
   */
  public static BusinessParent of( String pTechAttribute, long pParentAttribute ) {
    var lBuilder = BusinessParent.builder();
    lBuilder.setTechAttribute(pTechAttribute);
    lBuilder.setParentAttribute(pParentAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BusinessParent</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BusinessParentBuilder<T extends BusinessParent, B extends BusinessParentBuilder<T, B>>
      extends TechParentBuilder<T, B> {
    private long parentAttribute;

    /**
     * Use {@link BusinessParent#builder()} instead of private constructor to create new builder.
     */
    protected BusinessParentBuilder( ) {
      super();
    }

    /**
     * Use {@link BusinessParent#builder(BusinessParent)} instead of private constructor to create new builder.
     */
    protected BusinessParentBuilder( BusinessParent pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setParentAttribute(pObject.parentAttribute);
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setParentAttribute( long pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this.self();
    }

    /**
     * Method creates a new instance of class BusinessParent. The object will be initialized with the values of the
     * builder.
     *
     * @return BusinessParent Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BusinessParentBuilderImpl
      extends BusinessParentBuilder<BusinessParent, BusinessParentBuilderImpl> {
    protected BusinessParentBuilderImpl( ) {
    }

    protected BusinessParentBuilderImpl( BusinessParent pObject ) {
      super(pObject);
    }

    @Override
    protected BusinessParentBuilderImpl self( ) {
      return this;
    }

    @Override
    public BusinessParent build( ) {
      BusinessParent lObject = new BusinessParent(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   *
   * @return long Value to which {@link #parentAttribute} is set.
   */
  public long getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets attribute {@link #parentAttribute}.<br/>
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   */
  public void setParentAttribute( long pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Long.hashCode(parentAttribute);
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
      BusinessParent lOther = (BusinessParent) pObject;
      lEquals = parentAttribute == lOther.parentAttribute;
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
   * @return {@link BusinessParentBuilder} New builder that can be used to create new BusinessParent objects. The method
   * never returns null.
   */
  public BusinessParentBuilder<?, ?> toBuilder( ) {
    return new BusinessParentBuilderImpl(this);
  }
}