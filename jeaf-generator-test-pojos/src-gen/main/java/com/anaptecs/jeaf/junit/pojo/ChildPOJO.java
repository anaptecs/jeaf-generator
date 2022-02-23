/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ChildPOJO extends ParentPOJO {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  /**
   * 
   */
  @NotNull()
  private Integer childAttribute;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildPOJO( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
  }

  /**
   * Class implements builder to create a new instance of class ChildPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ParentPOJO.Builder {
    /**
     * 
     */
    @NotNull()
    private Integer childAttribute;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(ChildPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childAttribute = pObject.childAttribute;
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
     * @return {@link Builder} New builder that can be used to create new ChildPOJO objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ChildPOJO pObject ) {
      return new Builder(pObject);
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
    @Override
    public Builder setWeirdAttribute( byte pWeirdAttribute ) {
      // Call super class implementation.
      super.setWeirdAttribute(pWeirdAttribute);
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    @Override
    public Builder setHello( String pHello ) {
      // Call super class implementation.
      super.setHello(pHello);
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
     * Method creates a new instance of class ChildPOJO. The object will be initialized with the values of the builder.
     * 
     * @return ChildPOJO Created object. The method never returns null.
     */
    public ChildPOJO build( ) {
      return new ChildPOJO(this);
    }

    /**
     * Method creates a new instance of class ChildPOJO. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ChildPOJO Created object. The method never returns null.
     */
    public ChildPOJO build( boolean pValidate ) {
      ChildPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "childAttribute",
        "" + childAttribute));
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
