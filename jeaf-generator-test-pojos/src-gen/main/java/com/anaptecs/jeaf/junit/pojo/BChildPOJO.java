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

  /**
   * 
   */
  private byte weirdAttribute;

  /**
   * 
   */
  private Integer childAttribute;

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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(BChildPOJO)} instead of private constructor to create new builder.
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
     * @return {@link Builder} New builder that can be used to create new BChildPOJO objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BChildPOJO pObject ) {
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
     * Method creates a new instance of class BChildPOJO. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return BChildPOJO Created object. The method never returns null.
     */
    public BChildPOJO build( boolean pValidate ) {
      BChildPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "weirdAttribute", "" + weirdAttribute));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "childAttribute", "" + childAttribute));
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