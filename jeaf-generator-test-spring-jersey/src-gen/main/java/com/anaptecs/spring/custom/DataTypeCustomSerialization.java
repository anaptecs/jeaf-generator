/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.custom;

public class DataTypeCustomSerialization extends DataTypeCustomSerializationBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected DataTypeCustomSerialization( DataTypeCustomSerialization.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeCustomSerialization objects.
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
   * @param pProperty1 String that should be used to create an instance of this class. The parameter must not be null.
   * @return {@link DataTypeCustomSerialization} Instance of the class that matches to the passed string. The method
   * never returns null.
   */
  public static DataTypeCustomSerialization valueOf( String pProperty1 ) {
    return builder().setProperty1(String.valueOf(pProperty1)).build();
  }

  /**
   * Class implements builder to create a new instance of class DataTypeCustomSerialization. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends DataTypeCustomSerialization.BuilderBase {
    /**
     * Use {@link DataTypeCustomSerialization#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeCustomSerialization#builder(DataTypeCustomSerialization)} instead of protected constructor to
     * create new builder.
     */
    protected Builder( DataTypeCustomSerialization pObject ) {
      super(pObject);
    }
  }

  /**
   * Method serializes this object into its custom string representation.
   *
   * @return {@link String} Serialized String representation of this object. The method must not return null.
   */
  public String serialize( ) {
    // TODO Implementation required
    return null;
  }

  /**
   * Method deserialized the passed String representation of this object into a new instance of this class.
   *
   * @param pSerialized Serialized representation that should be used to create a new instance. The parameter is never
   * null.
   * @return {@link DataTypeCustomSerialization} Instance of this class as it was deserialized from the passed string.
   * The method must not return null.
   */
  public static DataTypeCustomSerialization deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}