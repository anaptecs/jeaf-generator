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
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectID;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(property = "objectID", generator = PropertyGenerator.class)
public abstract class POJOWithIDnMethodBase implements Identifiable<ObjectID> {
  /**
   * Constant for the name of attribute "attr".
   */
  public static final String ATTR = "attr";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ObjectID objectID;

  /**
   * 
   */
  private Double attr;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected POJOWithIDnMethodBase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POJOWithIDnMethodBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    attr = pBuilder.attr;
  }

  /**
   * Class implements builder to create a new instance of class POJOWithIDnMethod. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    /**
     * 
     */
    private Double attr;

    /**
     * Use {@link POJOWithIDnMethod.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link POJOWithIDnMethod.builder(POJOWithIDnMethod)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( POJOWithIDnMethodBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        attr = pObject.attr;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "attr".
     * 
     * @param pAttr Value to which the attribute "attr" should be set.
     */
    public BuilderBase setAttr( Double pAttr ) {
      // Assign value to attribute
      attr = pAttr;
      return this;
    }

    /**
     * Method creates a new instance of class POJOWithIDnMethod. The object will be initialized with the values of the
     * builder.
     * 
     * @return POJOWithIDnMethod Created object. The method never returns null.
     */
    public POJOWithIDnMethod build( ) {
      return new POJOWithIDnMethod(this);
    }

    /**
     * Method creates a new validated instance of class POJOWithIDnMethod. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return POJOWithIDnMethod Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public POJOWithIDnMethod buildValidated( ) throws ConstraintViolationException {
      POJOWithIDnMethod lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ObjectID} ID of this object. Since an object must not have an id the method may also return null.
   */
  @Override
  public final ObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ObjectID} ID of this object. Since an object must not have an id the method may also return null.
   */
  @Override
  public final ObjectID getUnversionedID( ) {
    ObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the attribute "attr".
   * 
   * 
   * @return Double Value to which the attribute "attr" is set.
   */
  public Double getAttr( ) {
    return attr;
  }

  /**
   * Method sets the attribute "attr".
   * 
   * 
   * @param pAttr Value to which the attribute "attr" should be set.
   */
  public void setAttr( Double pAttr ) {
    // Assign value to attribute
    attr = pAttr;
  }

  /**
   * 
   * @return {@link Boolean}
   */
  public abstract boolean doSomethingFunny( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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
