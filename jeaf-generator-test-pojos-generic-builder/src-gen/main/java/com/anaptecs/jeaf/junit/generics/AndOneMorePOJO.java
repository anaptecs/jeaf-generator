/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

public class AndOneMorePOJO extends AndOneMorePOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AndOneMorePOJO( AndOneMorePOJOBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects.
   */
  public static AndOneMorePOJOBuilder<?, ?> builder( ) {
    return new AndOneMorePOJOBuilderImpl();
  }

  /**
   * @return {@link GenericResponsePOJO<TemplateEnumTest>}
   */
  @Override
  public GenericResponsePOJO<TemplateEnumTest> getEnumTemplate( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}