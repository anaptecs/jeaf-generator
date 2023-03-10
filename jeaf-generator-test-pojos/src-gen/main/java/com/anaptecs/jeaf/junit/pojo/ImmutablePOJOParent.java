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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImmutablePOJOParent extends AbstractPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "anotherParentAttribute".
   */
  public static final String ANOTHERPARENTATTRIBUTE = "anotherParentAttribute";

  private final String parentAttribute;

  private Integer anotherParentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ImmutablePOJOParent( ) {
    parentAttribute = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutablePOJOParent( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    anotherParentAttribute = pBuilder.anotherParentAttribute;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects. The method never
   * returns null.
   */
  public static Builder builder( ImmutablePOJOParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ImmutablePOJOParent. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AbstractPOJO.Builder {
    private String parentAttribute;

    private Integer anotherParentAttribute;

    /**
     * Use {@link ImmutablePOJOParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ImmutablePOJOParent#builder(ImmutablePOJOParent)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ImmutablePOJOParent pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        parentAttribute = pObject.parentAttribute;
        anotherParentAttribute = pObject.anotherParentAttribute;
      }
    }

    /**
     * Method sets the attribute "abtractAttr".
     * 
     * @param pAbtractAttr Value to which the attribute "abtractAttr" should be set.
     */
    @Override
    public Builder setAbtractAttr( String pAbtractAttr ) {
      // Call super class implementation.
      super.setAbtractAttr(pAbtractAttr);
      return this;
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    public Builder setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    /**
     * Method sets the attribute "anotherParentAttribute".
     * 
     * @param pAnotherParentAttribute Value to which the attribute "anotherParentAttribute" should be set.
     */
    public Builder setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
      // Assign value to attribute
      anotherParentAttribute = pAnotherParentAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutablePOJOParent. The object will be initialized with the values of the
     * builder.
     * 
     * @return ImmutablePOJOParent Created object. The method never returns null.
     */
    public ImmutablePOJOParent build( ) {
      return new ImmutablePOJOParent(this);
    }

    /**
     * Method creates a new validated instance of class ImmutablePOJOParent. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ImmutablePOJOParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutablePOJOParent buildValidated( ) throws ConstraintViolationException {
      ImmutablePOJOParent lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   * 
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method returns attribute {@link #anotherParentAttribute}.<br/>
   * 
   * @return {@link Integer} Value to which {@link #anotherParentAttribute} is set.
   */
  public Integer getAnotherParentAttribute( ) {
    return anotherParentAttribute;
  }

  /**
   * Method sets attribute {@link #anotherParentAttribute}.<br/>
   * 
   * @param pAnotherParentAttribute Value to which {@link #anotherParentAttribute} should be set.
   */
  public void setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
    // Assign value to attribute
    anotherParentAttribute = pAnotherParentAttribute;
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anotherParentAttribute: ");
    lBuilder.append(anotherParentAttribute);
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
