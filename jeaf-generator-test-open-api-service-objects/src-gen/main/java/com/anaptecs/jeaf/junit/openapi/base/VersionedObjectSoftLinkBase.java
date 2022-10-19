/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public abstract class VersionedObjectSoftLinkBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * String representation of this object.
   */
  private final String objectID;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected VersionedObjectSoftLinkBase( ) {
    objectID = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected VersionedObjectSoftLinkBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    objectID = pBuilder.objectID;
  }

  /**
   * Class implements builder to create a new instance of class VersionedObjectSoftLink. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * String representation of this object.
     */
    private String objectID;

    /**
     * Use {@link VersionedObjectSoftLink.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link VersionedObjectSoftLink.builder(VersionedObjectSoftLink)} instead of protected constructor to create
     * new builder.
     */
    protected BuilderBase( VersionedObjectSoftLinkBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
      }
    }

    /**
     * Method returns the String representation of this object.
     * 
     * @return String String representation of this object.
     */
    public BuilderBase setObjectID( String pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method creates a new instance of class VersionedObjectSoftLink. The object will be initialized with the values of
     * the builder.
     * 
     * @return VersionedObjectSoftLink Created object. The method never returns null.
     */
    public VersionedObjectSoftLink build( ) {
      return new VersionedObjectSoftLink(this);
    }

    /**
     * Method creates a new validated instance of class VersionedObjectSoftLink. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return VersionedObjectSoftLink Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public VersionedObjectSoftLink buildValidated( ) throws ConstraintViolationException {
      VersionedObjectSoftLink lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the String representation of this object.
   * 
   * @return String String representation of this object.
   */
  public String getObjectID( ) {
    return objectID;
  }

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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "objectID", "" + objectID));
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
