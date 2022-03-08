/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.tools.api.Tools;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildPOJO.class, name = "ChildPOJO") })
public class ParentPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "weirdAttribute".
   */
  @Deprecated
  public static final String WEIRDATTRIBUTE = "weirdAttribute";

  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  /**
   * 
   */
  private String parentAttribute;

  /**
   * 
   */
  @Deprecated
  private byte weirdAttribute;

  /**
   * 
   */
  private String hello;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    weirdAttribute = pBuilder.weirdAttribute;
    hello = pBuilder.hello;
  }

  /**
   * Class implements builder to create a new instance of class ParentPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String parentAttribute;

    /**
     * 
     */
    @Deprecated
    private byte weirdAttribute;

    /**
     * 
     */
    private String hello;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ParentPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ParentPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        parentAttribute = pObject.parentAttribute;
        weirdAttribute = pObject.weirdAttribute;
        hello = pObject.hello;
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
     * @return {@link Builder} New builder that can be used to create new ParentPOJO objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ParentPOJO pObject ) {
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
     * Method sets the attribute "weirdAttribute".
     * 
     * @param pWeirdAttribute Value to which the attribute "weirdAttribute" should be set.
     */
    @Deprecated
    public Builder setWeirdAttribute( byte pWeirdAttribute ) {
      // Assign value to attribute
      weirdAttribute = pWeirdAttribute;
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    public Builder setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method creates a new instance of class ParentPOJO. The object will be initialized with the values of the builder.
     * 
     * @return ParentPOJO Created object. The method never returns null.
     */
    public ParentPOJO build( ) {
      return new ParentPOJO(this);
    }

    /**
     * Method creates a new instance of class ParentPOJO. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ParentPOJO Created object. The method never returns null.
     */
    public ParentPOJO build( boolean pValidate ) {
      ParentPOJO lPOJO = this.build();
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
   * Method returns the attribute "weirdAttribute".
   * 
   * 
   * @return byte Value to which the attribute "weirdAttribute" is set.
   */
  @Deprecated
  public byte getWeirdAttribute( ) {
    return weirdAttribute;
  }

  /**
   * Method sets the attribute "weirdAttribute".
   * 
   * 
   * @param pWeirdAttribute Value to which the attribute "weirdAttribute" should be set.
   */
  @Deprecated
  public void setWeirdAttribute( byte pWeirdAttribute ) {
    // Assign value to attribute
    weirdAttribute = pWeirdAttribute;
  }

  /**
   * Method returns the attribute "hello".
   * 
   * 
   * @return String Value to which the attribute "hello" is set.
   */
  public String getHello( ) {
    return hello;
  }

  /**
   * Method sets the attribute "hello".
   * 
   * 
   * @param pHello Value to which the attribute "hello" should be set.
   */
  public void setHello( String pHello ) {
    // Assign value to attribute
    hello = pHello;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "parentAttribute", "" + parentAttribute));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "weirdAttribute", "" + weirdAttribute));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "hello", "" + hello));
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