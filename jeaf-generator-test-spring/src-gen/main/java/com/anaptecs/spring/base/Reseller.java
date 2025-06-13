/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;

@Valid
public class Reseller extends ResellerBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected Reseller( ResellerBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Reseller objects.
   */
  public static ResellerBuilder<?, ?> builder( ) {
    return new ResellerBuilderImpl();
  }

  /**
   * @return {@link Integer}
   */
  @MyNotNullProperty
  @Override
  public Integer doSomething( ) {
    // TODO: Implement business logic for method.
    return null;
  }

  /**
   * @return double
   */
  @Override
  public double returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}