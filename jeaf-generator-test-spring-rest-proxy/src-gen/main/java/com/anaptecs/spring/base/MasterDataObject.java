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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MasterDataObject {
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

  /**
   * Constant for the name of attribute "derivedProperty".
   */
  public static final String DERIVEDPROPERTY = "derivedProperty";

  /**
   * Constant for the name of attribute "derivedDataUnits".
   */
  public static final String DERIVEDDATAUNITS = "derivedDataUnits";

  /**
   * Constant for the name of attribute "derivedEntity".
   */
  public static final String DERIVEDENTITY = "derivedEntity";

  private List<DataUnit> dataUnits;

  private Entity entity;

  private String objectID;

  private String internalProperty;

  private String derivedProperty;

  private List<DataUnit> derivedDataUnits;

  private Set<Entity> derivedEntity;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MasterDataObject( ) {
    dataUnits = new ArrayList<DataUnit>();
    derivedDataUnits = new ArrayList<DataUnit>();
    derivedEntity = new HashSet<Entity>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MasterDataObject( Builder pBuilder ) {
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
    derivedProperty = pBuilder.derivedProperty;
    if (pBuilder.derivedDataUnits != null) {
      derivedDataUnits = pBuilder.derivedDataUnits;
    }
    else {
      derivedDataUnits = new ArrayList<DataUnit>();
    }
    if (pBuilder.derivedEntity != null) {
      derivedEntity = pBuilder.derivedEntity;
    }
    else {
      derivedEntity = new HashSet<Entity>();
    }
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
    private List<DataUnit> dataUnits;

    private Entity entity;

    private String objectID;

    private String internalProperty;

    private String derivedProperty;

    private List<DataUnit> derivedDataUnits;

    private Set<Entity> derivedEntity;

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
        dataUnits = pObject.dataUnits;
        entity = pObject.entity;
        objectID = pObject.objectID;
        internalProperty = pObject.internalProperty;
        derivedProperty = pObject.derivedProperty;
        derivedDataUnits = pObject.derivedDataUnits;
        derivedEntity = pObject.derivedEntity;
      }
    }

    /**
     * Method sets association {@link #dataUnits}.<br/>
     * 
     * @param pDataUnits Collection to which {@link #dataUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDataUnits( List<DataUnit> pDataUnits ) {
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
     * Method sets association {@link #dataUnits}.<br/>
     * 
     * @param pDataUnits Array with objects to which {@link #dataUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDataUnits( DataUnit... pDataUnits ) {
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
     * Method sets attribute {@link #internalProperty}.<br/>
     * 
     * @param pInternalProperty Value to which {@link #internalProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInternalProperty( String pInternalProperty ) {
      // Assign value to attribute
      internalProperty = pInternalProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #derivedProperty}.<br/>
     * 
     * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedProperty( String pDerivedProperty ) {
      // Assign value to attribute
      derivedProperty = pDerivedProperty;
      return this;
    }

    /**
     * Method sets association {@link #derivedDataUnits}.<br/>
     * 
     * @param pDerivedDataUnits Collection to which {@link #derivedDataUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedDataUnits( List<DataUnit> pDerivedDataUnits ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDerivedDataUnits != null) {
        derivedDataUnits = new ArrayList<DataUnit>(pDerivedDataUnits);
      }
      else {
        derivedDataUnits = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #derivedDataUnits}.<br/>
     * 
     * @param pDerivedDataUnits Array with objects to which {@link #derivedDataUnits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedDataUnits( DataUnit... pDerivedDataUnits ) {
      // To ensure immutability we have to copy the content of the passed array.
      if (pDerivedDataUnits != null) {
        derivedDataUnits = new ArrayList<DataUnit>(Arrays.asList(pDerivedDataUnits));
      }
      else {
        derivedDataUnits = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #derivedEntity}.<br/>
     * 
     * @param pDerivedEntity Collection to which {@link #derivedEntity} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedEntity( Set<Entity> pDerivedEntity ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDerivedEntity != null) {
        derivedEntity = new HashSet<Entity>(pDerivedEntity);
      }
      else {
        derivedEntity = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #derivedEntity}.<br/>
     * 
     * @param pDerivedEntity Array with objects to which {@link #derivedEntity} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDerivedEntity( Entity... pDerivedEntity ) {
      // To ensure immutability we have to copy the content of the passed array.
      if (pDerivedEntity != null) {
        derivedEntity = new HashSet<Entity>(Arrays.asList(pDerivedEntity));
      }
      else {
        derivedEntity = null;
      }
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
   * Method returns attribute {@link #derivedProperty}.<br/>
   * 
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  public String getDerivedProperty( ) {
    return derivedProperty;
  }

  /**
   * Method sets attribute {@link #derivedProperty}.<br/>
   * 
   * @param pDerivedProperty Value to which {@link #derivedProperty} should be set.
   */
  public void setDerivedProperty( String pDerivedProperty ) {
    // Assign value to attribute
    derivedProperty = pDerivedProperty;
  }

  /**
   * Method returns association {@link #derivedDataUnits}.<br/>
   * 
   * @return {@link List<DataUnit>} Value to which {@link #derivedDataUnits} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<DataUnit> getDerivedDataUnits( ) {
    // Return all DataUnit objects as unmodifiable collection.
    return Collections.unmodifiableList(derivedDataUnits);
  }

  /**
   * Method adds the passed object to {@link #derivedDataUnits}.
   * 
   * @param pDerivedDataUnits Object that should be added to {@link #derivedDataUnits}. The parameter must not be null.
   */
  public void addToDerivedDataUnits( DataUnit pDerivedDataUnits ) {
    // Add passed object to collection of associated DataUnit objects.
    derivedDataUnits.add(pDerivedDataUnits);
  }

  /**
   * Method adds all passed objects to {@link #derivedDataUnits}.
   * 
   * @param pDerivedDataUnits Collection with all objects that should be added to {@link #derivedDataUnits}. The
   * parameter must not be null.
   */
  public void addToDerivedDataUnits( Collection<DataUnit> pDerivedDataUnits ) {
    // Add all passed objects.
    for (DataUnit lNextObject : pDerivedDataUnits) {
      this.addToDerivedDataUnits(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #derivedDataUnits}.<br/>
   * 
   * @param pDerivedDataUnits Object that should be removed from {@link #derivedDataUnits}. The parameter must not be
   * null.
   */
  public void removeFromDerivedDataUnits( DataUnit pDerivedDataUnits ) {
    // Remove passed object from collection of associated DataUnit objects.
    derivedDataUnits.remove(pDerivedDataUnits);
  }

  /**
   * Method removes all objects from {@link #derivedDataUnits}.
   */
  public void clearDerivedDataUnits( ) {
    // Remove all objects from association "derivedDataUnits".
    derivedDataUnits.clear();
  }

  /**
   * Method returns association {@link #derivedEntity}.<br/>
   * 
   * @return {@link Set<Entity>} Value to which {@link #derivedEntity} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Entity> getDerivedEntity( ) {
    // Return all Entity objects as unmodifiable collection.
    return Collections.unmodifiableSet(derivedEntity);
  }

  /**
   * Method adds the passed object to {@link #derivedEntity}.
   * 
   * @param pDerivedEntity Object that should be added to {@link #derivedEntity}. The parameter must not be null.
   */
  public void addToDerivedEntity( Entity pDerivedEntity ) {
    // Add passed object to collection of associated Entity objects.
    derivedEntity.add(pDerivedEntity);
  }

  /**
   * Method adds all passed objects to {@link #derivedEntity}.
   * 
   * @param pDerivedEntity Collection with all objects that should be added to {@link #derivedEntity}. The parameter
   * must not be null.
   */
  public void addToDerivedEntity( Collection<Entity> pDerivedEntity ) {
    // Add all passed objects.
    for (Entity lNextObject : pDerivedEntity) {
      this.addToDerivedEntity(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #derivedEntity}.<br/>
   * 
   * @param pDerivedEntity Object that should be removed from {@link #derivedEntity}. The parameter must not be null.
   */
  public void removeFromDerivedEntity( Entity pDerivedEntity ) {
    // Remove passed object from collection of associated Entity objects.
    derivedEntity.remove(pDerivedEntity);
  }

  /**
   * Method removes all objects from {@link #derivedEntity}.
   */
  public void clearDerivedEntity( ) {
    // Remove all objects from association "derivedEntity".
    derivedEntity.clear();
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
    lBuilder.append(pIndent);
    lBuilder.append("derivedProperty: ");
    lBuilder.append(derivedProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("derivedDataUnits: ");
    if (derivedDataUnits != null) {
      lBuilder.append(derivedDataUnits.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (derivedDataUnits != null) {
      for (DataUnit lNext : derivedDataUnits) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("derivedEntity: ");
    if (derivedEntity != null) {
      lBuilder.append(derivedEntity.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (derivedEntity != null) {
      for (Entity lNext : derivedEntity) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
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
