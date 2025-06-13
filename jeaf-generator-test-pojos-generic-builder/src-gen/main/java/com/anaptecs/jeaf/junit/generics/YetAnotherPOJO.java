/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

public class YetAnotherPOJO extends YetAnotherPOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected YetAnotherPOJO( YetAnotherPOJOBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new YetAnotherPOJO objects.
   */
  public static YetAnotherPOJOBuilder<?, ?> builder( ) {
    return new YetAnotherPOJOBuilderImpl();
  }

  /**
   * @return {@link GenericResponsePOJO<MyBusinessObject>}
   */
  @Override
  public GenericResponsePOJO<MyBusinessObject> getResponse( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}