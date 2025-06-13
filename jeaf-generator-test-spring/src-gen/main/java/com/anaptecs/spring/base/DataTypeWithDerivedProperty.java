/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.annotations.MyNotNullProperty;

public class DataTypeWithDerivedProperty extends DataTypeWithDerivedPropertyBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected DataTypeWithDerivedProperty( DataTypeWithDerivedPropertyBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeWithDerivedProperty objects.
   */
  public static DataTypeWithDerivedPropertyBuilder<?, ?> builder( ) {
    return new DataTypeWithDerivedPropertyBuilderImpl();
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
}