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
  protected DataTypeWithDerivedProperty( DataTypeWithDerivedProperty.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  DataTypeWithDerivedProperty( int pProperty ) {
    super(pProperty);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeWithDerivedProperty objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class DataTypeWithDerivedProperty. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends DataTypeWithDerivedProperty.BuilderBase {
    /**
     * Use {@link DataTypeWithDerivedProperty#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeWithDerivedProperty#builder(DataTypeWithDerivedProperty)} instead of protected constructor to
     * create new builder.
     */
    protected Builder( DataTypeWithDerivedProperty pObject ) {
      super(pObject);
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new DataTypeWithDerivedProperty objects.
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
    public static Builder newBuilder( DataTypeWithDerivedProperty pObject ) {
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
}