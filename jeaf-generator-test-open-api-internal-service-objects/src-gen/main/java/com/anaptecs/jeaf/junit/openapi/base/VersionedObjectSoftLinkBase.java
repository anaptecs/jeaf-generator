/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
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
   * 
   */
  private final long objectID;

  /**
   * 
   */
  @NotNull
  private DataUnit dataUnit;

  /**
   * 
   */
  @NotNull
  private Entity entity;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected VersionedObjectSoftLinkBase( ) {
    objectID = 0;
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
    dataUnit = pBuilder.dataUnit;
    entity = pBuilder.entity;
  }

  /**
   * Class implements builder to create a new instance of class VersionedObjectSoftLink. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private long objectID;

    /**
     * 
     */
    private DataUnit dataUnit;

    /**
     * 
     */
    private Entity entity;

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
        dataUnit = pObject.dataUnit;
        entity = pObject.entity;
      }
    }

    /**
     * Method sets the attribute "objectID".
     * 
     * @param pObjectID Value to which the attribute "objectID" should be set.
     */
    public BuilderBase setObjectID( long pObjectID ) {
      // Assign value to attribute
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the association "dataUnit".
     * 
     * @param pDataUnit DataUnit to which the association "dataUnit" should be set.
     */
    public BuilderBase setDataUnit( DataUnit pDataUnit ) {
      dataUnit = pDataUnit;
      return this;
    }

    /**
     * Method sets the association "entity".
     * 
     * @param pEntity Entity to which the association "entity" should be set.
     */
    public BuilderBase setEntity( Entity pEntity ) {
      entity = pEntity;
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
   * Method returns the attribute "objectID".
   * 
   * 
   * @return long Value to which the attribute "objectID" is set.
   */
  public long getObjectID( ) {
    return objectID;
  }

  /**
   * Method returns the association "dataUnit".
   * 
   *
   * @return DataUnit DataUnit to which the association "dataUnit" is set.
   */
  public DataUnit getDataUnit( ) {
    return dataUnit;
  }

  /**
   * Method sets the association "dataUnit".
   * 
   * 
   * @param pDataUnit DataUnit to which the association "dataUnit" should be set.
   */
  public void setDataUnit( DataUnit pDataUnit ) {
    dataUnit = pDataUnit;
  }

  /**
   * Method unsets the association "dataUnit".
   * 
   */
  public final void unsetDataUnit( ) {
    dataUnit = null;
  }

  /**
   * Method returns the association "entity".
   * 
   *
   * @return Entity Entity to which the association "entity" is set.
   */
  public Entity getEntity( ) {
    return entity;
  }

  /**
   * Method sets the association "entity".
   * 
   * 
   * @param pEntity Entity to which the association "entity" should be set.
   */
  public void setEntity( Entity pEntity ) {
    entity = pEntity;
  }

  /**
   * Method unsets the association "entity".
   * 
   */
  public final void unsetEntity( ) {
    entity = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("objectID: ");
    lBuilder.append(objectID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dataUnit: ");
    lBuilder.append(dataUnit);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("entity: ");
    lBuilder.append(entity);
    lBuilder.append(System.lineSeparator());
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
    return this.toStringBuilder("").toString();
  }
}
