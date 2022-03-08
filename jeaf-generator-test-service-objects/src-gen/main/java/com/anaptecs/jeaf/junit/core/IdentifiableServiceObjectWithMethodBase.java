/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.AbstractObjectID;
import com.anaptecs.jeaf.core.api.Identifiable;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class IdentifiableServiceObjectWithMethodBase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  private Integer hello;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected IdentifiableServiceObjectWithMethodBase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IdentifiableServiceObjectWithMethodBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    AbstractObjectID<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    hello = pBuilder.hello;
  }

  /**
   * Class implements builder to create a new instance of class IdentifiableServiceObjectWithMethod. As the class has
   * read only attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private AbstractObjectID<?> objectID;

    /**
     * 
     */
    private Integer hello;

    /**
     * Use {@link IdentifiableServiceObjectWithMethod.Builder#newBuilder()} instead of protected constructor to create
     * new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link IdentifiableServiceObjectWithMethod.Builder#newBuilder(IdentifiableServiceObjectWithMethod)} instead
     * of protected constructor to create new builder.
     */
    protected BuilderBase( IdentifiableServiceObjectWithMethodBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        hello = pObject.hello;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( AbstractObjectID<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    public BuilderBase setHello( Integer pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method creates a new instance of class IdentifiableServiceObjectWithMethod. The object will be initialized with
     * the values of the builder.
     * 
     * @return IdentifiableServiceObjectWithMethod Created object. The method never returns null.
     */
    public IdentifiableServiceObjectWithMethod build( ) {
      return new IdentifiableServiceObjectWithMethod(this);
    }

    /**
     * Method creates a new instance of class IdentifiableServiceObjectWithMethod. The object will be initialized with
     * the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return IdentifiableServiceObjectWithMethod Created object. The method never returns null.
     */
    public IdentifiableServiceObjectWithMethod build( boolean pValidate ) {
      IdentifiableServiceObjectWithMethod lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the attribute "hello".
   * 
   * 
   * @return Integer Value to which the attribute "hello" is set.
   */
  public Integer getHello( ) {
    return hello;
  }

  /**
   * Method sets the attribute "hello".
   * 
   * 
   * @param pHello Value to which the attribute "hello" should be set.
   */
  public void setHello( Integer pHello ) {
    // Assign value to attribute
    hello = pHello;
  }

  /**
  * 
  */
  public abstract void doSomething( );

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