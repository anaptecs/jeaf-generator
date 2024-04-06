/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public abstract class VersionedObjectSoftLinkBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Internal ID of a versioned object
   */
  private final long objectID;

  @NotNull
  private DataUnit dataUnit;

  @NotNull
  private Entity entity;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
     * Internal ID of a versioned object
     */
    private long objectID;

    private DataUnit dataUnit;

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
        this.setObjectID(pObject.objectID);
        this.setDataUnit(pObject.dataUnit);
        this.setEntity(pObject.entity);
      }
    }

    /**
     * Method sets attribute {@link #objectID}.<br/>
     *
     * @param pObjectID Value to which {@link #objectID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setObjectID( long pObjectID ) {
      // Assign value to attribute
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets association {@link #dataUnit}.<br/>
     *
     * @param pDataUnit Value to which {@link #dataUnit} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDataUnit( DataUnit pDataUnit ) {
      dataUnit = pDataUnit;
      return this;
    }

    /**
     * Method sets association {@link #entity}.<br/>
     *
     * @param pEntity Value to which {@link #entity} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
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
   * Method returns attribute {@link #objectID}.<br/>
   * Internal ID of a versioned object
   *
   * @return long Value to which {@link #objectID} is set.
   */
  public long getObjectID( ) {
    return objectID;
  }

  /**
   * Method returns association {@link #dataUnit}.<br/>
   *
   * @return {@link DataUnit} Value to which {@link #dataUnit} is set.
   */
  public DataUnit getDataUnit( ) {
    return dataUnit;
  }

  /**
   * Method sets association {@link #dataUnit}.<br/>
   *
   * @param pDataUnit Value to which {@link #dataUnit} should be set.
   */
  public void setDataUnit( DataUnit pDataUnit ) {
    dataUnit = pDataUnit;
  }

  /**
   * Method unsets {@link #dataUnit}.
   */
  public final void unsetDataUnit( ) {
    dataUnit = null;
  }

  /**
   * Method returns association {@link #entity}.<br/>
   *
   * @return {@link Entity} Value to which {@link #entity} is set.
   */
  public Entity getEntity( ) {
    return entity;
  }

  /**
   * Method sets association {@link #entity}.<br/>
   *
   * @param pEntity Value to which {@link #entity} should be set.
   */
  public void setEntity( Entity pEntity ) {
    entity = pEntity;
  }

  /**
   * Method unsets {@link #entity}.
   */
  public final void unsetEntity( ) {
    entity = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Long.hashCode(objectID);
    lResult = lPrime * lResult + Objects.hashCode(dataUnit);
    lResult = lPrime * lResult + Objects.hashCode(entity);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      VersionedObjectSoftLinkBase lOther = (VersionedObjectSoftLinkBase) pObject;
      lEquals = objectID == lOther.objectID && Objects.equals(dataUnit, lOther.dataUnit)
          && Objects.equals(entity, lOther.entity);
    }
    return lEquals;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new VersionedObjectSoftLink objects. The method
   * never returns null.
   */
  public VersionedObjectSoftLink.Builder toBuilder( ) {
    return new VersionedObjectSoftLink.Builder((VersionedObjectSoftLink) this);
  }
}
