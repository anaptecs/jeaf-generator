/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class MasterDataObject {
  /**
   * Constant for the name of attribute "dataUnit".
   */
  public static final String DATAUNIT = "dataUnit";

  /**
   * Constant for the name of attribute "entity".
   */
  public static final String ENTITY = "entity";

  /**
   * Constant for the name of attribute "objectID".
   */
  public static final String OBJECTID = "objectID";

  private DataUnit dataUnit;

  private Entity entity;

  private String objectID;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MasterDataObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterDataObject( Builder pBuilder ) {
    // Read attribute values from builder.
    dataUnit = pBuilder.dataUnit;
    entity = pBuilder.entity;
    objectID = pBuilder.objectID;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new MasterDataObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MasterDataObject objects. The method never
   * returns null.
   */
  public static Builder builder( MasterDataObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>MasterDataObject</code>.
   */
  public static class Builder {
    private DataUnit dataUnit;

    private Entity entity;

    private String objectID;

    /**
     * Use {@link MasterDataObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MasterDataObject#builder(MasterDataObject)} instead of private constructor to create new builder.
     */
    protected Builder( MasterDataObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        dataUnit = pObject.dataUnit;
        entity = pObject.entity;
        objectID = pObject.objectID;
      }
    }

    /**
     * Method sets association {@link #dataUnit}.<br/>
     * 
     * @param pDataUnit Value to which {@link #dataUnit} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDataUnit( DataUnit pDataUnit ) {
      dataUnit = pDataUnit;
      return this;
    }

    /**
     * Method sets association {@link #entity}.<br/>
     * 
     * @param pEntity Value to which {@link #entity} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setEntity( Entity pEntity ) {
      entity = pEntity;
      return this;
    }

    /**
     * Method sets attribute {@link #objectID}.<br/>
     * 
     * @param pObjectID Value to which {@link #objectID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setObjectID( String pObjectID ) {
      // Assign value to attribute
      objectID = pObjectID;
      return this;
    }

    /**
     * Method creates a new instance of class MasterDataObject. The object will be initialized with the values of the
     * builder.
     * 
     * @return MasterDataObject Created object. The method never returns null.
     */
    public MasterDataObject build( ) {
      return new MasterDataObject(this);
    }
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
   * Method returns attribute {@link #objectID}.<br/>
   * 
   * @return {@link String} Value to which {@link #objectID} is set.
   */
  public String getObjectID( ) {
    return objectID;
  }

  /**
   * Method sets attribute {@link #objectID}.<br/>
   * 
   * @param pObjectID Value to which {@link #objectID} should be set.
   */
  public void setObjectID( String pObjectID ) {
    // Assign value to attribute
    objectID = pObjectID;
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
    lBuilder.append("dataUnit: ");
    lBuilder.append(dataUnit);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("entity: ");
    lBuilder.append(entity);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("objectID: ");
    lBuilder.append(objectID);
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
