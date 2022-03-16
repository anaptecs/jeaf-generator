/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  private final String parentAttribute;

  /**
   * 
   */
  private Integer anotherParentAttribute;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class ImmutablePOJOParent. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends AbstractPOJO.Builder {
    /**
     * 
     */
    private String parentAttribute;

    /**
     * 
     */
    private Integer anotherParentAttribute;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(ImmutablePOJOParent)} instead of private constructor to create new builder.
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ImmutablePOJOParent pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class ImmutablePOJOParent. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ImmutablePOJOParent Created object. The method never returns null.
     */
    public ImmutablePOJOParent build( boolean pValidate ) {
      ImmutablePOJOParent lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
   * Method returns the attribute "anotherParentAttribute".
   * 
   * 
   * @return Integer Value to which the attribute "anotherParentAttribute" is set.
   */
  public Integer getAnotherParentAttribute( ) {
    return anotherParentAttribute;
  }

  /**
   * Method sets the attribute "anotherParentAttribute".
   * 
   * 
   * @param pAnotherParentAttribute Value to which the attribute "anotherParentAttribute" should be set.
   */
  public void setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
    // Assign value to attribute
    anotherParentAttribute = pAnotherParentAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "parentAttribute", "" + parentAttribute));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "anotherParentAttribute",
        "" + anotherParentAttribute));
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