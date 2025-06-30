/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class SoftLink extends SoftLinkBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected SoftLink( SoftLinkBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  SoftLink( long pObjectID, DataUnit pDataUnit, Entity pEntity, String pRefrenceID ) {
    super(pObjectID, pDataUnit, pEntity, pRefrenceID);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLink objects.
   */
  public static SoftLinkBuilder<?, ?> builder( ) {
    return new SoftLinkBuilderImpl();
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
   * @return {@link SoftLink} Instance of this class as it was deserialized from the passed string. The method must not
   * return null.
   */
  public static SoftLink deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}