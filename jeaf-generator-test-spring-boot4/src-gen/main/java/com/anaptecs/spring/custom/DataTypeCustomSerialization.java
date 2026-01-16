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
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  DataTypeCustomSerialization( String pProperty1 ) {
    super(pProperty1);
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

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new DataTypeCustomSerialization objects.
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
    public static Builder newBuilder( DataTypeCustomSerialization pObject ) {
      return new Builder(pObject);
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