/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.validation.Valid;

@Valid
public class AdvancedPOJO extends AdvancedPOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AdvancedPOJO( AdvancedPOJOBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AdvancedPOJO objects.
   */
  public static AdvancedPOJOBuilder<?, ?> builder( ) {
    return new AdvancedPOJOBuilderImpl();
  }

  /**
   * @param pName
   * @return boolean
   */
  @Override
  public boolean doSomething( String pName ) {
    // TODO: Implement business logic for method.
    return false;
  }

  /**
   * @return int
   */
  @Override
  public int returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}