/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.List;

import com.anaptecs.annotations.MyNotNullProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class MasterDataObject extends MasterDataObjectBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MasterDataObject( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected MasterDataObject( MasterDataObject.BuilderBase pBuilder ) {
    super(pBuilder);
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
   * Class implements builder to create a new instance of class MasterDataObject. As the class has readonly attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends MasterDataObject.BuilderBase {
    /**
     * Use {@link MasterDataObject#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MasterDataObject#builder(MasterDataObject)} instead of protected constructor to create new builder.
     */
    protected Builder( MasterDataObject pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new MasterDataObject objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new POJOWithIDnMethod objects. The method never
     * returns null.
     */
    public static Builder newBuilder( MasterDataObject pObject ) {
      return new Builder(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  @Override
  public String getDerivedProperty( ) {
    // TODO Implement method for derived property "derivedProperty".
    return null;
  }

  /**
   * Method returns association {@link #derivedDataUnits}.<br/>
   *
   * @return {@link List<DataUnit>} Value to which {@link #derivedDataUnits} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  @JsonGetter
  @Override
  public List<DataUnit> getDerivedDataUnits( ) {
    // TODO Implement method for derived property "derivedDataUnits".
    return null;
  }

  /**
   * Method returns association {@link #derivedEntity}.<br/>
   *
   * @return {@link Entity} Value to which {@link #derivedEntity} is set.
   */
  @JsonGetter
  @Override
  public Entity getDerivedEntity( ) {
    // TODO Implement method for derived property "derivedEntity".
    return null;
  }

  /**
   * Method returns attribute {@link #derivedArray}.<br/>
   *
   * @return int[] Value to which {@link #derivedArray} is set.
   */
  @Override
  public int[] getDerivedArray( ) {
    // TODO Implement method for derived property "derivedArray".
    return null;
  }

  /**
   * Method returns attribute {@link #derivedBoolean}.<br/>
   *
   * @return boolean Value to which {@link #derivedBoolean} is set.
   */
  @Override
  public boolean getDerivedBoolean( ) {
    // TODO Implement method for derived property "derivedBoolean".
    return false;
  }

  /**
   * Method returns attribute {@link #derivedInt}.<br/>
   *
   * @return int Value to which {@link #derivedInt} is set.
   */
  @Override
  public int getDerivedInt( ) {
    // TODO Implement method for derived property "derivedInt".
    return 0;
  }

  /**
   * Method returns attribute {@link #derivedString}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedString} is set.
   */
  @MyNotNullProperty
  @Override
  public String getDerivedString( ) {
    // TODO Implement method for derived property "derivedString".
    return null;
  }
}