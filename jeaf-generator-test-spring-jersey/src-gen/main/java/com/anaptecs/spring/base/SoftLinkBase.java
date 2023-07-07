/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLinkBase( ) {
    objectID = 0;
    refrenceID = null;
  }

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
   * Class implements builder to create a new instance of class SoftLink. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
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
        objectID = pObject.objectID;
        dataUnit = pObject.dataUnit;
        entity = pObject.entity;
        refrenceID = pObject.refrenceID;
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
     * Method sets attribute {@link #refrenceID}.<br/>
     *
     * @param pRefrenceID Value to which {@link #refrenceID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setRefrenceID( String pRefrenceID ) {
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
      return new SoftLink(this);
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

  /**
   * Method returns attribute {@link #refrenceID}.<br/>
   *
   * @return {@link String} Value to which {@link #refrenceID} is set.
   */
  public String getRefrenceID( ) {
    return refrenceID;
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
}
