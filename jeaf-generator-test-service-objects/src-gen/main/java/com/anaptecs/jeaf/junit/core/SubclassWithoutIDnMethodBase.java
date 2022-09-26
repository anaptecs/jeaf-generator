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
public abstract class SubclassWithoutIDnMethodBase extends IdentifiableServiceObjectWithMethod {
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
  protected SubclassWithoutIDnMethodBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SubclassWithoutIDnMethodBase( BuilderBase pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    attr = pBuilder.attr;
  }

  /**
   * Class implements builder to create a new instance of class SubclassWithoutIDnMethod. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase extends IdentifiableServiceObjectWithMethod.Builder {
    /**
     * 
     */
    private Boolean attr;

    /**
     * Use {@link SubclassWithoutIDnMethod.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
      super();
    }

    /**
     * Use {@link SubclassWithoutIDnMethod.builder(SubclassWithoutIDnMethod)} instead of protected constructor to create
     * new builder.
     */
    protected BuilderBase( SubclassWithoutIDnMethodBase pObject ) {
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
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    @Override
    public BuilderBase setHello( Integer pHello ) {
      // Call super class implementation.
      super.setHello(pHello);
      return this;
    }

    /**
     * Method sets the attribute "attr".
     * 
     * @param pAttr Value to which the attribute "attr" should be set.
     */
    public BuilderBase setAttr( Boolean pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    /**
     * Method creates a new instance of class SubclassWithoutIDnMethod. The object will be initialized with the values
     * of the builder.
     * 
     * @return SubclassWithoutIDnMethod Created object. The method never returns null.
     */
    public SubclassWithoutIDnMethod build( ) {
      return new SubclassWithoutIDnMethod(this);
    }

    /**
     * Method creates a new validated instance of class SubclassWithoutIDnMethod. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return SubclassWithoutIDnMethod Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SubclassWithoutIDnMethod buildValidated( ) throws ConstraintViolationException {
      SubclassWithoutIDnMethod lPOJO = this.build();
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
  * 
  */
  public abstract void doLess( );

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
