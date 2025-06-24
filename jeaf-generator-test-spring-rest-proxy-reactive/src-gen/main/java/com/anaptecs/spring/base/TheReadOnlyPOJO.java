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

public class TheReadOnlyPOJO {
  /**
   * Constant for the name of attribute "dataUnit".
   */
  public static final String DATAUNIT = "dataUnit";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "ints".
   */
  public static final String INTS = "ints";

  /**
   * Constant for the name of attribute "entities".
   */
  public static final String ENTITIES = "entities";

  private final DataUnit dataUnit;

  private final String name;

  private final int[] ints;

  private final List<Entity> entities;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TheReadOnlyPOJO( ) {
    dataUnit = null;
    name = null;
    ints = null;
    entities = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TheReadOnlyPOJO( Builder pBuilder ) {
    // Read attribute values from builder.
    dataUnit = pBuilder.dataUnit;
    name = pBuilder.name;
    ints = pBuilder.ints;
    if (pBuilder.entities != null) {
      entities = pBuilder.entities;
    }
    else {
      entities = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TheReadOnlyPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class TheReadOnlyPOJO.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @return {@link com.anaptecs.spring.base.TheReadOnlyPOJO}
   */
  public static TheReadOnlyPOJO of( String pName ) {
    var lBuilder = TheReadOnlyPOJO.builder();
    lBuilder.setName(pName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TheReadOnlyPOJO</code>.
   */
  public static class Builder {
    private DataUnit dataUnit;

    private String name;

    private int[] ints;

    private List<Entity> entities;

    /**
     * Use {@link TheReadOnlyPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TheReadOnlyPOJO#builder(TheReadOnlyPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( TheReadOnlyPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDataUnit(pObject.dataUnit);
        this.setName(pObject.name);
        this.setInts(pObject.ints);
        this.setEntities(pObject.entities);
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
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #ints}.<br/>
     *
     * @param pInts Value to which {@link #ints} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInts( int[] pInts ) {
      // Assign value to attribute
      if (pInts != null) {
        ints = new int[pInts.length];
        System.arraycopy(pInts, 0, ints, 0, pInts.length);
      }
      else {
        ints = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #entities}.<br/>
     *
     * @param pEntities Collection to which {@link #entities} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setEntities( List<Entity> pEntities ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pEntities != null) {
        entities = new ArrayList<Entity>(pEntities);
      }
      else {
        entities = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #entities}.<br/>
     *
     * @param pEntities Array of objects that should be added to {@link #entities}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToEntities( Entity... pEntities ) {
      if (pEntities != null) {
        if (entities == null) {
          entities = new ArrayList<Entity>();
        }
        entities.addAll(Arrays.asList(pEntities));
      }
      return this;
    }

    /**
     * Method sets association {@link #entities}.<br/>
     *
     * @param pEntities Array with objects to which {@link #entities} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setEntities( Entity... pEntities ) {
      // Copy the content of the passed array.
      if (pEntities != null) {
        entities = new ArrayList<Entity>(Arrays.asList(pEntities));
      }
      else {
        entities = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class TheReadOnlyPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return TheReadOnlyPOJO Created object. The method never returns null.
     */
    public TheReadOnlyPOJO build( ) {
      return new TheReadOnlyPOJO(this);
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
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns attribute {@link #ints}.<br/>
   *
   * @return int[] Value to which {@link #ints} is set.
   */
  public int[] getInts( ) {
    int[] lReturnValue;
    if (ints != null) {
      lReturnValue = new int[ints.length];
      System.arraycopy(ints, 0, lReturnValue, 0, ints.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method returns association {@link #entities}.<br/>
   *
   * @return {@link List<Entity>} Value to which {@link #entities} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Entity> getEntities( ) {
    // Return all Entity objects as unmodifiable collection.
    return Collections.unmodifiableList(entities);
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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("ints: ");
    if (ints != null) {
      lBuilder.append(Arrays.toString(ints));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("entities: ");
    if (entities != null) {
      lBuilder.append(entities.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (entities != null) {
      for (Entity lNext : entities) {
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new TheReadOnlyPOJO objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}