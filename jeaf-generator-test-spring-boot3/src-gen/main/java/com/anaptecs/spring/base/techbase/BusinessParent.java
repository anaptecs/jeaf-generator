/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

public class BusinessParent extends TechParent {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  private long parentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BusinessParent( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BusinessParent( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BusinessParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BusinessParent objects. The method never returns
   * null.
   */
  public static Builder builder( BusinessParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>BusinessParent</code>.
   */
  public static class Builder extends TechParent.Builder {
    private long parentAttribute;

    /**
     * Use {@link BusinessParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link BusinessParent#builder(BusinessParent)} instead of private constructor to create new builder.
     */
    protected Builder( BusinessParent pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        parentAttribute = pObject.parentAttribute;
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
    public Builder setParentAttribute( long pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class BusinessParent. The object will be initialized with the values of the
     * builder.
     *
     * @return BusinessParent Created object. The method never returns null.
     */
    public BusinessParent build( ) {
      return new BusinessParent(this);
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
}
