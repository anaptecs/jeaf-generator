/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

  private final List<DataUnit> dataUnits;

  private final Entity entity;

  private final String objectID;

  private final String internalProperty;

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
      dataUnits = new ArrayList<>();
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
      dataUnits = pDataUnits;
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
      // Copy the content of the passed array.
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
   * Method returns association {@link #entity}.<br/>
   *
   * @return {@link Entity} Value to which {@link #entity} is set.
   */
  Entity getEntity( ) {
    return entity;
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
   * Method returns attribute {@link #internalProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #internalProperty} is set.
   */
  String getInternalProperty( ) {
    return internalProperty;
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
   * @return {@link MasterDataObject}
   */
  public static MasterDataObject of( Entity pEntity, String pObjectID, String pInternalProperty ) {
    var lBuilder = MasterDataObject.builder();
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
  public abstract boolean isDerivedBoolean( );

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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(dataUnits);
    lResult = lPrime * lResult + Objects.hashCode(entity);
    lResult = lPrime * lResult + Objects.hashCode(objectID);
    lResult = lPrime * lResult + Objects.hashCode(internalProperty);
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
      MasterDataObjectBase lOther = (MasterDataObjectBase) pObject;
      lEquals = Objects.equals(dataUnits, lOther.dataUnits) && Objects.equals(entity, lOther.entity)
          && Objects.equals(objectID, lOther.objectID) && Objects.equals(internalProperty, lOther.internalProperty);
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