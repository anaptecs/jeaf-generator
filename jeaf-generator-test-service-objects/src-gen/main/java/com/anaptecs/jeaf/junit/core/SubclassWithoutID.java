/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class SubclassWithoutID extends IdentifiableServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "attr".
   */
  public static final String ATTR = "attr";

  /**
   * 
   */
  private Boolean attr;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SubclassWithoutID( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SubclassWithoutID( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    attr = pBuilder.attr;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SubclassWithoutID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SubclassWithoutID objects. The method never
   * returns null.
   */
  public static Builder builder( SubclassWithoutID pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SubclassWithoutID. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends IdentifiableServiceObject.Builder {
    /**
     * 
     */
    private Boolean attr;

    /**
     * Use {@link SubclassWithoutID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SubclassWithoutID#builder(SubclassWithoutID)} instead of private constructor to create new builder.
     */
    protected Builder( SubclassWithoutID pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        attr = pObject.attr;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    @Override
    public Builder setHello( Integer pHello ) {
      // Call super class implementation.
      super.setHello(pHello);
      return this;
    }

    /**
     * Method sets the attribute "country".
     * 
     * @param pCountry Value to which the attribute "country" should be set.
     */
    @Override
    public Builder setCountry( String pCountry ) {
      // Call super class implementation.
      super.setCountry(pCountry);
      return this;
    }

    /**
     * Method sets the attribute "attr".
     * 
     * @param pAttr Value to which the attribute "attr" should be set.
     */
    public Builder setAttr( Boolean pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    /**
     * Method creates a new instance of class SubclassWithoutID. The object will be initialized with the values of the
     * builder.
     * 
     * @return SubclassWithoutID Created object. The method never returns null.
     */
    public SubclassWithoutID build( ) {
      return new SubclassWithoutID(this);
    }

    /**
     * Method creates a new validated instance of class SubclassWithoutID. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return SubclassWithoutID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SubclassWithoutID buildValidated( ) throws ConstraintViolationException {
      SubclassWithoutID lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "attr".
   * 
   * 
   * @return Boolean Value to which the attribute "attr" is set.
   */
  public Boolean getAttr( ) {
    return attr;
  }

  /**
   * Method sets the attribute "attr".
   * 
   * 
   * @param pAttr Value to which the attribute "attr" should be set.
   */
  public void setAttr( Boolean pAttr ) {
    // Assign value to attribute
    attr = pAttr;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "attr", "" + attr));
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
