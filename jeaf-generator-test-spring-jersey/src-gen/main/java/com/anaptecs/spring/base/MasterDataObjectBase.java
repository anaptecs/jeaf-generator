/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MasterDataObjectBase {
  /**
   * Constant for the name of attribute "dataUnits".
   */
  public static final String DATAUNITS = "dataUnits";

  /**
   * Constant for the name of attribute "entity".
   */
  public static final String ENTITY = "entity";

  /**
   * Constant for the name of attribute "objectID".
   */
  public static final String OBJECTID = "objectID";

  /**
   * Constant for the name of attribute "internalProperty".
   */
  public static final String INTERNALPROPERTY = "internalProperty";

  @JsonSetter(nulls = Nulls.SKIP)
  private List<DataUnit> dataUnits;

  private Entity entity;

  private String objectID;

  private String internalProperty;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MasterDataObjectBase( ) {
    dataUnits = new ArrayList<DataUnit>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterDataObjectBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.dataUnits != null) {
      dataUnits = pBuilder.dataUnits;
    }
    else {
      dataUnits = new ArrayList<DataUnit>();
    }
    entity = pBuilder.entity;
    objectID = pBuilder.objectID;
    internalProperty = pBuilder.internalProperty;
  }

  /**
   * Class implements builder to create a new instance of class MasterDataObject. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private List<DataUnit> dataUnits;

    private Entity entity;

    private String objectID;

    private String internalProperty;

    /**
     * Use {@link MasterDataObject.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link MasterDataObject.builder(MasterDataObject)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( MasterDataObjectBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDataUnits(pObject.dataUnits);
        this.setEntity(pObject.entity);
        this.setObjectID(pObject.objectID);
        this.setInternalProperty(pObject.internalProperty);
      }
    }

    /**
     * Method sets association {@link #dataUnits}.<br/>
     *
     * @param pDataUnits Collection to which {@link #dataUnits} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDataUnits( List<DataUnit> pDataUnits ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDataUnits != null) {
        dataUnits = new ArrayList<DataUnit>(pDataUnits);
      }
      else {
        dataUnits = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #dataUnits}.<br/>
     *
     * @param pDataUnits Array of objects that should be added to {@link #dataUnits}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToDataUnits( DataUnit... pDataUnits ) {
      if (pDataUnits != null) {
        if (dataUnits == null) {
          dataUnits = new ArrayList<DataUnit>();
        }
        dataUnits.addAll(Arrays.asList(pDataUnits));
      }
      return this;
    }

    /**
     * Method sets association {@link #dataUnits}.<br/>
     *
     * @param pDataUnits Array with objects to which {@link #dataUnits} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setDataUnits( DataUnit... pDataUnits ) {
      // To ensure immutability we have to copy the content of the passed array.
      if (pDataUnits != null) {
        dataUnits = new ArrayList<DataUnit>(Arrays.asList(pDataUnits));
      }
      else {
        dataUnits = null;
      }
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
     * Method sets attribute {@link #objectID}.<br/>
     *
     * @param pObjectID Value to which {@link #objectID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setObjectID( String pObjectID ) {
      // Assign value to attribute
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets attribute {@link #internalProperty}.<br/>
     *
     * @param pInternalProperty Value to which {@link #internalProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setInternalProperty( String pInternalProperty ) {
      // Assign value to attribute
      internalProperty = pInternalProperty;
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
   * Method returns association {@link #dataUnits}.<br/>
   *
   * @return {@link List<DataUnit>} Value to which {@link #dataUnits} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  List<DataUnit> getDataUnits( ) {
    // Return all DataUnit objects as unmodifiable collection.
    return Collections.unmodifiableList(dataUnits);
  }

  /**
   * Method adds the passed object to {@link #dataUnits}.
   *
   * @param pDataUnits Object that should be added to {@link #dataUnits}. The parameter must not be null.
   */
  void addToDataUnits( DataUnit pDataUnits ) {
    // Add passed object to collection of associated DataUnit objects.
    dataUnits.add(pDataUnits);
  }

  /**
   * Method adds all passed objects to {@link #dataUnits}.
   *
   * @param pDataUnits Collection with all objects that should be added to {@link #dataUnits}. The parameter must not be
   * null.
   */
  void addToDataUnits( Collection<DataUnit> pDataUnits ) {
    // Add all passed objects.
    for (DataUnit lNextObject : pDataUnits) {
      this.addToDataUnits(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #dataUnits}.<br/>
   *
   * @param pDataUnits Object that should be removed from {@link #dataUnits}. The parameter must not be null.
   */
  void removeFromDataUnits( DataUnit pDataUnits ) {
    // Remove passed object from collection of associated DataUnit objects.
    dataUnits.remove(pDataUnits);
  }

  /**
   * Method removes all objects from {@link #dataUnits}.
   */
  void clearDataUnits( ) {
    // Remove all objects from association "dataUnits".
    dataUnits.clear();
  }

  /**
   * Method returns association {@link #entity}.<br/>
   *
   * @return {@link Entity} Value to which {@link #entity} is set.
   */
  Entity getEntity( ) {
    return entity;
  }

  /**
   * Method sets association {@link #entity}.<br/>
   *
   * @param pEntity Value to which {@link #entity} should be set.
   */
  void setEntity( Entity pEntity ) {
    entity = pEntity;
  }

  /**
   * Method unsets {@link #entity}.
   */
  final void unsetEntity( ) {
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
   * Method returns attribute {@link #internalProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #internalProperty} is set.
   */
  String getInternalProperty( ) {
    return internalProperty;
  }

  /**
   * Method sets attribute {@link #internalProperty}.<br/>
   *
   * @param pInternalProperty Value to which {@link #internalProperty} should be set.
   */
  void setInternalProperty( String pInternalProperty ) {
    // Assign value to attribute
    internalProperty = pInternalProperty;
  }

  /**
   * Convenience method to create new instance of class MasterDataObject.
   *
   *
   * @param pEntity Value to which {@link #entity} should be set.
   *
   * @param pObjectID Value to which {@link #objectID} should be set.
   *
   * @param pInternalProperty Value to which {@link #internalProperty} should be set.
   *
   * @return {@link com.anaptecs.spring.base.MasterDataObject}
   */
  public static MasterDataObject of( Entity pEntity, String pObjectID, String pInternalProperty ) {
    MasterDataObject.Builder lBuilder = MasterDataObject.builder();
    lBuilder.setEntity(pEntity);
    lBuilder.setObjectID(pObjectID);
    lBuilder.setInternalProperty(pInternalProperty);
    return lBuilder.build();
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  public abstract String getDerivedProperty( );

  /**
   * Method returns association {@link #derivedDataUnits}.<br/>
   *
   * @return {@link List<DataUnit>} Value to which {@link #derivedDataUnits} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public abstract List<DataUnit> getDerivedDataUnits( );

  /**
   * Method returns association {@link #derivedEntity}.<br/>
   *
   * @return {@link Entity} Value to which {@link #derivedEntity} is set.
   */
  public abstract Entity getDerivedEntity( );

  /**
   * Method returns attribute {@link #derivedArray}.<br/>
   *
   * @return int[] Value to which {@link #derivedArray} is set.
   */
  public abstract int[] getDerivedArray( );

  /**
   * Method returns attribute {@link #derivedBoolean}.<br/>
   *
   * @return boolean Value to which {@link #derivedBoolean} is set.
   */
  public abstract boolean getDerivedBoolean( );

  /**
   * Method returns attribute {@link #derivedInt}.<br/>
   *
   * @return int Value to which {@link #derivedInt} is set.
   */
  public abstract int getDerivedInt( );

  /**
   * Method returns attribute {@link #derivedString}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedString} is set.
   */
  public abstract String getDerivedString( );

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
    lBuilder.append("dataUnits: ");
    if (dataUnits != null) {
      lBuilder.append(dataUnits.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (dataUnits != null) {
      for (DataUnit lNext : dataUnits) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("entity: ");
    lBuilder.append(entity);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("objectID: ");
    lBuilder.append(objectID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("internalProperty: ");
    lBuilder.append(internalProperty);
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
   * @return {@link Builder} New builder that can be used to create new MasterDataObject objects. The method never
   * returns null.
   */
  public MasterDataObject.Builder toBuilder( ) {
    return new MasterDataObject.Builder((MasterDataObject) this);
  }
}
