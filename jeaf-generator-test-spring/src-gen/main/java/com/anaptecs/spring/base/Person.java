/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;

@Valid
public class Person extends PersonBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Person( PersonBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Person objects.
   */
  public static PersonBuilder<?, ?> builder( ) {
    return new PersonBuilderImpl();
  }

  /**
   * @return {@link String}
   */
  @MyNotNullProperty
  @Override
  public String getDisplayName( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}