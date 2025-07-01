/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

public class MySortCriteria extends MySortCriteriaBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected MySortCriteria( MySortCriteria.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MySortCriteria objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class MySortCriteria. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends MySortCriteria.BuilderBase {
    /**
     * Use {@link MySortCriteria#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MySortCriteria#builder(MySortCriteria)} instead of protected constructor to create new builder.
     */
    protected Builder( MySortCriteria pObject ) {
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
   * @return {@link MySortCriteria} Instance of this class as it was deserialized from the passed string. The method
   * must not return null.
   */
  public static MySortCriteria deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}