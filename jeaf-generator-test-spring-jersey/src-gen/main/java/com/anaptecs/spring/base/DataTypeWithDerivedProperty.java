/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class DataTypeWithDerivedProperty extends DataTypeWithDerivedPropertyBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected DataTypeWithDerivedProperty( DataTypeWithDerivedProperty.BuilderBase pBuilder ) {
    super(pBuilder);
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
   * Method converts the passed {@link String} into an instance of this object.
   *
   * Please be aware that this method is only intended to be used for deserialization frameworks like JAX-RS. For
   * "normal" object creation builder should be used instead.
   *
   * @param pProperty String that should be used to create an instance of this class. The parameter must not be null.
   * @return {@link DataTypeWithDerivedProperty} Instance of the class that matches to the passed string. The method
   * never returns null.
   */
  public static DataTypeWithDerivedProperty valueOf( String pProperty ) {
    return builder().setProperty(Integer.parseInt(pProperty)).build();
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
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @Override
  public String getDerivedProperty( ) {
    // TODO Implement method for derived property "derivedProperty".
    return null;
  }
}