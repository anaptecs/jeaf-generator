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
   * Initialize object. Nothing special to do.
   */
  protected MasterDataObject( MasterDataObjectBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MasterDataObject objects.
   */
  public static MasterDataObjectBuilder<?, ?> builder( ) {
    return new MasterDataObjectBuilderImpl();
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
  public boolean isDerivedBoolean( ) {
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