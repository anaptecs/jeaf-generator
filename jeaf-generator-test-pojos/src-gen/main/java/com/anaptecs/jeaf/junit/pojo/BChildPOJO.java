/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
public class BChildPOJO extends BParentPOJO {
  /**
   * Constant for the name of attribute "weirdAttribute".
   */
  public static final String WEIRDATTRIBUTE = "weirdAttribute";

  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  private byte weirdAttribute;

  private Integer childAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BChildPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BChildPOJO( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    weirdAttribute = pBuilder.weirdAttribute;
    childAttribute = pBuilder.childAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BChildPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BChildPOJO objects. The method never returns
   * null.
   */
  public static Builder builder( BChildPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>BChildPOJO</code>.
   */
  @Deprecated
  public static class Builder extends BParentPOJO.Builder {
    private byte weirdAttribute;

    private Integer childAttribute;

    /**
     * Use {@link BChildPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link BChildPOJO#builder(BChildPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( BChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        weirdAttribute = pObject.weirdAttribute;
        childAttribute = pObject.childAttribute;
      }
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #weirdAttribute}.<br/>
     *
     * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setWeirdAttribute( byte pWeirdAttribute ) {
      // Assign value to attribute
      weirdAttribute = pWeirdAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #childAttribute}.<br/>
     *
     * @param pChildAttribute Value to which {@link #childAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildAttribute( Integer pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class BChildPOJO. The object will be initialized with the values of the builder.
     *
     * @return BChildPOJO Created object. The method never returns null.
     */
    public BChildPOJO build( ) {
      return new BChildPOJO(this);
    }

    /**
     * Method creates a new validated instance of class BChildPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return BChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BChildPOJO buildValidated( ) throws ConstraintViolationException {
      BChildPOJO lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #weirdAttribute}.<br/>
   *
   * @return byte Value to which {@link #weirdAttribute} is set.
   */
  public byte getWeirdAttribute( ) {
    return weirdAttribute;
  }

  /**
   * Method sets attribute {@link #weirdAttribute}.<br/>
   *
   * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
   */
  public void setWeirdAttribute( byte pWeirdAttribute ) {
    // Assign value to attribute
    weirdAttribute = pWeirdAttribute;
  }

  /**
   * Method returns attribute {@link #childAttribute}.<br/>
   *
   * @return {@link Integer} Value to which {@link #childAttribute} is set.
   */
  public Integer getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method sets attribute {@link #childAttribute}.<br/>
   *
   * @param pChildAttribute Value to which {@link #childAttribute} should be set.
   */
  public void setChildAttribute( Integer pChildAttribute ) {
    // Assign value to attribute
    childAttribute = pChildAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + weirdAttribute;
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
      BChildPOJO lOther = (BChildPOJO) pObject;
      lEquals = weirdAttribute == lOther.weirdAttribute && Objects.equals(childAttribute, lOther.childAttribute);
    }
    return lEquals;
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
    lBuilder.append("weirdAttribute: ");
    lBuilder.append(weirdAttribute);
    lBuilder.append(System.lineSeparator());
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
