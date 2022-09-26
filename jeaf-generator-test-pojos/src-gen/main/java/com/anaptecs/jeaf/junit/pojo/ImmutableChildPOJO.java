/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImmutableChildPOJO extends ImmutablePOJOParent {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  /**
   * Constant for the name of attribute "anotherChildAttribute".
   */
  public static final String ANOTHERCHILDATTRIBUTE = "anotherChildAttribute";

  /**
   * 
   */
  private String childAttribute;

  /**
   * 
   */
  private final Double anotherChildAttribute;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ImmutableChildPOJO( ) {
    anotherChildAttribute = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutableChildPOJO( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
    anotherChildAttribute = pBuilder.anotherChildAttribute;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ImmutableChildPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ImmutableChildPOJO objects. The method never
   * returns null.
   */
  public static Builder builder( ImmutableChildPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ImmutableChildPOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ImmutablePOJOParent.Builder {
    /**
     * 
     */
    private String childAttribute;

    /**
     * 
     */
    private Double anotherChildAttribute;

    /**
     * Use {@link ImmutableChildPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ImmutableChildPOJO#builder(ImmutableChildPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ImmutableChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childAttribute = pObject.childAttribute;
        anotherChildAttribute = pObject.anotherChildAttribute;
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
     * Method sets the attribute "anotherParentAttribute".
     * 
     * @param pAnotherParentAttribute Value to which the attribute "anotherParentAttribute" should be set.
     */
    @Override
    public Builder setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
      // Call super class implementation.
      super.setAnotherParentAttribute(pAnotherParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "childAttribute".
     * 
     * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
     */
    public Builder setChildAttribute( String pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this;
    }

    /**
     * Method sets the attribute "anotherChildAttribute".
     * 
     * @param pAnotherChildAttribute Value to which the attribute "anotherChildAttribute" should be set.
     */
    public Builder setAnotherChildAttribute( Double pAnotherChildAttribute ) {
      // Assign value to attribute
      anotherChildAttribute = pAnotherChildAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutableChildPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return ImmutableChildPOJO Created object. The method never returns null.
     */
    public ImmutableChildPOJO build( ) {
      return new ImmutableChildPOJO(this);
    }

    /**
     * Method creates a new validated instance of class ImmutableChildPOJO. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ImmutableChildPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ImmutableChildPOJO buildValidated( ) throws ConstraintViolationException {
      ImmutableChildPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childAttribute".
   * 
   * 
   * @return String Value to which the attribute "childAttribute" is set.
   */
  public String getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method sets the attribute "childAttribute".
   * 
   * 
   * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
   */
  public void setChildAttribute( String pChildAttribute ) {
    // Assign value to attribute
    childAttribute = pChildAttribute;
  }

  /**
   * Method returns the attribute "anotherChildAttribute".
   * 
   * 
   * @return Double Value to which the attribute "anotherChildAttribute" is set.
   */
  public Double getAnotherChildAttribute( ) {
    return anotherChildAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "childAttribute", "" + childAttribute));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "anotherChildAttribute",
        "" + anotherChildAttribute));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
