/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Deprecated
@JsonDeserialize(builder = ChildAA.Builder.class)
public class ChildAA extends ChildA {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childAAAttribute".
   */
  public static final String CHILDAAATTRIBUTE = "childAAAttribute";

  /**
   * 
   */
  private byte childAAAttribute;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildAA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAAttribute = pBuilder.childAAAttribute;
  }

  /**
   * Class implements builder to create a new instance of class ChildAA. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @Deprecated
  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
  public static class Builder extends ChildA.Builder {
    /**
     * 
     */
    private byte childAAAttribute;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(ChildAA)} instead of private constructor to create new builder.
     */
    protected Builder( ChildAA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childAAAttribute = pObject.childAAAttribute;
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
     * @return {@link Builder} New builder that can be used to create new ChildAA objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ChildAA pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "childAAttribute".
     * 
     * @param pChildAAttribute Value to which the attribute "childAAttribute" should be set.
     */
    @Override
    public Builder setChildAAttribute( int pChildAAttribute ) {
      // Call super class implementation.
      super.setChildAAttribute(pChildAAttribute);
      return this;
    }

    /**
     * Method sets the attribute "childAAAttribute".
     * 
     * @param pChildAAAttribute Value to which the attribute "childAAAttribute" should be set.
     */
    public Builder setChildAAAttribute( byte pChildAAAttribute ) {
      // Assign value to attribute
      childAAAttribute = pChildAAAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class ChildAA. The object will be initialized with the values of the builder.
     * 
     * @return ChildAA Created object. The method never returns null.
     */
    public ChildAA build( ) {
      return new ChildAA(this);
    }

    /**
     * Method creates a new instance of class ChildAA. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ChildAA Created object. The method never returns null.
     */
    public ChildAA build( boolean pValidate ) {
      ChildAA lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childAAAttribute".
   * 
   * 
   * @return byte Value to which the attribute "childAAAttribute" is set.
   */
  public byte getChildAAAttribute( ) {
    return childAAAttribute;
  }

  /**
   * Method sets the attribute "childAAAttribute".
   * 
   * 
   * @param pChildAAAttribute Value to which the attribute "childAAAttribute" should be set.
   */
  public void setChildAAAttribute( byte pChildAAAttribute ) {
    // Assign value to attribute
    childAAAttribute = pChildAAAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "childAAAttribute",
        "" + childAAAttribute));
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