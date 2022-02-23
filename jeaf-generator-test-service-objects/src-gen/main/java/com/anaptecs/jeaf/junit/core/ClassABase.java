/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.AbstractObjectID;
import com.anaptecs.jeaf.core.api.Identifiable;
import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class ClassABase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "oneB".
   */
  public static final String ONEB = "oneB";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  private String name;

  /**
   * 
   */
  private ClassB oneB;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ClassABase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ClassABase( BuilderBase pBuilder ) {
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
    name = pBuilder.name;
    oneB = pBuilder.oneB;
  }

  /**
   * Class implements builder to create a new instance of class ClassA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private AbstractObjectID<?> objectID;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private ClassB oneB;

    /**
     * Use {@link ClassA.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ClassA.Builder#newBuilder(ClassA)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ClassABase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        name = pObject.name;
        oneB = pObject.oneB;
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
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the association "oneB".
     * 
     * @param pOneB ClassB to which the association "oneB" should be set.
     */
    public BuilderBase setOneB( ClassB pOneB ) {
      oneB = pOneB;
      return this;
    }

    /**
     * Method creates a new instance of class ClassA. The object will be initialized with the values of the builder.
     * 
     * @return ClassA Created object. The method never returns null.
     */
    public ClassA build( ) {
      return new ClassA(this);
    }

    /**
     * Method creates a new instance of class ClassA. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ClassA Created object. The method never returns null.
     */
    public ClassA build( boolean pValidate ) {
      ClassA lPOJO = this.build();
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
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the association "oneB".
   * 
   *
   * @return ClassB ClassB to which the association "oneB" is set.
   */
  public ClassB getOneB( ) {
    return oneB;
  }

  /**
   * Method sets the association "oneB".
   * 
   * 
   * @param pOneB ClassB to which the association "oneB" should be set.
   */
  public void setOneB( ClassB pOneB ) {
    // Release already referenced object before setting a new association.
    if (oneB != null) {
      oneB.removeFromManyAs((ClassA) this);
    }
    oneB = pOneB;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pOneB != null && pOneB.getManyAs().contains(this) == false) {
      pOneB.addToManyAs((ClassA) this);
    }
  }

  /**
   * Method unsets the association "oneB".
   * 
   */
  public final void unsetOneB( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    ClassB lClassB = oneB;
    oneB = null;
    if (lClassB != null && lClassB.getManyAs().contains(this) == true) {
      lClassB.removeFromManyAs((ClassA) this);
    }
  }

  /**
   * 
   * @return {@link Double}
   */
  public abstract Double calculate( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "name", "" + name));
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