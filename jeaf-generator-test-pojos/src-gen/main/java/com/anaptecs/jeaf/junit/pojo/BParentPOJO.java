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
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = BChildPOJO.class, name = "BChildPOJO") })
public class BParentPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * 
   */
  private String parentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BParentPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BParentPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
  }

  /**
   * Class implements builder to create a new instance of class BParentPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String parentAttribute;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BParentPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( BParentPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        parentAttribute = pObject.parentAttribute;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new BParentPOJO objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new BParentPOJO objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BParentPOJO pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class BParentPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return BParentPOJO Created object. The method never returns null.
     */
    public BParentPOJO build( ) {
      return new BParentPOJO(this);
    }

    /**
     * Method creates a new validated instance of class BParentPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return BParentPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BParentPOJO buildValidated( ) throws ConstraintViolationException {
      BParentPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "parentAttribute".
   * 
   * 
   * @return String Value to which the attribute "parentAttribute" is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets the attribute "parentAttribute".
   * 
   * 
   * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
   */
  public void setParentAttribute( String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "parentAttribute", "" + parentAttribute));
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
