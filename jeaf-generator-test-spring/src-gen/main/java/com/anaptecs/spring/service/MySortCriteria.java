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
  protected MySortCriteria( MySortCriteriaBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  MySortCriteria( SortOrder pSortOrder, MySortProperty pSortProperty ) {
    super(pSortOrder, pSortProperty);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MySortCriteria objects.
   */
  public static MySortCriteriaBuilder<?, ?> builder( ) {
    return new MySortCriteriaBuilderImpl();
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