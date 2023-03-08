/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

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
   * Class implements builder to create a new instance of class BChildPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @Deprecated
  public static class Builder extends BParentPOJO.Builder {
    /**
     * 
     */
    private byte weirdAttribute;

    /**
     * 
     */
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
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "weirdAttribute".
     * 
     * @param pWeirdAttribute Value to which the attribute "weirdAttribute" should be set.
     */
    public Builder setWeirdAttribute( byte pWeirdAttribute ) {
      // Assign value to attribute
      weirdAttribute = pWeirdAttribute;
      return this;
    }

    /**
     * Method sets the attribute "childAttribute".
     * 
     * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
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
      BChildPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "weirdAttribute".
   * 
   * 
   * @return byte Value to which the attribute "weirdAttribute" is set.
   */
  public byte getWeirdAttribute( ) {
    return weirdAttribute;
  }

  /**
   * Method sets the attribute "weirdAttribute".
   * 
   * 
   * @param pWeirdAttribute Value to which the attribute "weirdAttribute" should be set.
   */
  public void setWeirdAttribute( byte pWeirdAttribute ) {
    // Assign value to attribute
    weirdAttribute = pWeirdAttribute;
  }

  /**
   * Method returns the attribute "childAttribute".
   * 
   * 
   * @return Integer Value to which the attribute "childAttribute" is set.
   */
  public Integer getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method sets the attribute "childAttribute".
   * 
   * 
   * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
   */
  public void setChildAttribute( Integer pChildAttribute ) {
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
