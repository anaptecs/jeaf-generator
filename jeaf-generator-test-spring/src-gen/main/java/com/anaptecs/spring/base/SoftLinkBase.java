/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class SoftLinkBase {
  /**
   * Constant for the name of attribute "objectID".
   */
  public static final String OBJECTID = "objectID";

  /**
   * Constant for the name of attribute "dataUnit".
   */
  public static final String DATAUNIT = "dataUnit";

  /**
   * Constant for the name of attribute "entity".
   */
  public static final String ENTITY = "entity";

  /**
   * Constant for the name of attribute "refrenceID".
   */
  public static final String REFRENCEID = "refrenceID";

  private final long objectID;

  private DataUnit dataUnit;

  private Entity entity;

  private final String refrenceID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    objectID = pBuilder.objectID;
    dataUnit = pBuilder.dataUnit;
    entity = pBuilder.entity;
    refrenceID = pBuilder.refrenceID;
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  SoftLinkBase( long pObjectID, DataUnit pDataUnit, Entity pEntity, String pRefrenceID ) {
    objectID = pObjectID;
    dataUnit = pDataUnit;
    entity = pEntity;
    refrenceID = pRefrenceID;
  }

  /**
   * Class implements builder to create a new instance of class SoftLink. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private long objectID;

    private DataUnit dataUnit;

    private Entity entity;

    private String refrenceID;

    /**
     * Use {@link SoftLink.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link SoftLink.builder(SoftLink)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( SoftLinkBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setObjectID(pObject.objectID);
        this.setDataUnit(pObject.dataUnit);
        this.setEntity(pObject.entity);
        this.setRefrenceID(pObject.refrenceID);
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
    public BuilderBase setDataUnit( @MyNotNullProperty DataUnit pDataUnit ) {
      dataUnit = pDataUnit;
      return this;
    }

    /**
     * Method sets association {@link #entity}.<br/>
     *
     * @param pEntity Value to which {@link #entity} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setEntity( @MyNotNullProperty Entity pEntity ) {
      entity = pEntity;
      return this;
    }

    /**
     * Method sets attribute {@link #refrenceID}.<br/>
     *
     * @param pRefrenceID Value to which {@link #refrenceID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setRefrenceID( @MyNotNullProperty String pRefrenceID ) {
      // Assign value to attribute
      refrenceID = pRefrenceID;
      return this;
    }

    /**
     * Method creates a new instance of class SoftLink. The object will be initialized with the values of the builder.
     *
     * @return SoftLink Created object. The method never returns null.
     */
    public SoftLink build( ) {
      SoftLink lObject = new SoftLink(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #objectID}.<br/>
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
  @MyNotNullProperty
  public DataUnit getDataUnit( ) {
    return dataUnit;
  }

  /**
   * Method sets association {@link #dataUnit}.<br/>
   *
   * @param pDataUnit Value to which {@link #dataUnit} should be set.
   */
  public void setDataUnit( @MyNotNullProperty DataUnit pDataUnit ) {
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
  @MyNotNullProperty
  public Entity getEntity( ) {
    return entity;
  }

  /**
   * Method sets association {@link #entity}.<br/>
   *
   * @param pEntity Value to which {@link #entity} should be set.
   */
  public void setEntity( @MyNotNullProperty Entity pEntity ) {
    entity = pEntity;
  }

  /**
   * Method unsets {@link #entity}.
   */
  public final void unsetEntity( ) {
    entity = null;
  }

  /**
   * Method returns attribute {@link #refrenceID}.<br/>
   *
   * @return {@link String} Value to which {@link #refrenceID} is set.
   */
  @MyNotNullProperty
  public String getRefrenceID( ) {
    return refrenceID;
  }

  /**
   * Convenience method to create new instance of class SoftLink.
   *
   *
   * @param pObjectID Value to which {@link #objectID} should be set.
   *
   * @param pDataUnit Value to which {@link #dataUnit} should be set.
   *
   * @param pEntity Value to which {@link #entity} should be set.
   *
   * @param pRefrenceID Value to which {@link #refrenceID} should be set.
   *
   * @return {@link SoftLink}
   */
  public static SoftLink of( long pObjectID, DataUnit pDataUnit, Entity pEntity, String pRefrenceID ) {
    return new SoftLink(pObjectID, pDataUnit, pEntity, pRefrenceID);
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Long.hashCode(objectID);
    lResult = lPrime * lResult + Objects.hashCode(dataUnit);
    lResult = lPrime * lResult + Objects.hashCode(entity);
    lResult = lPrime * lResult + Objects.hashCode(refrenceID);
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
      SoftLinkBase lOther = (SoftLinkBase) pObject;
      lEquals = objectID == lOther.objectID && Objects.equals(dataUnit, lOther.dataUnit)
          && Objects.equals(entity, lOther.entity) && Objects.equals(refrenceID, lOther.refrenceID);
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
    lBuilder.append(pIndent);
    lBuilder.append("refrenceID: ");
    lBuilder.append(refrenceID);
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
   * @return {@link Builder} New builder that can be used to create new SoftLink objects. The method never returns null.
   */
  public SoftLink.Builder toBuilder( ) {
    return new SoftLink.Builder((SoftLink) this);
  }
}