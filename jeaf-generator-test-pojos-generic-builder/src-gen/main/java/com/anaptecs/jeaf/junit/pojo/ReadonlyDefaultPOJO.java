/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.validation.Valid;

@Valid
public class ReadonlyDefaultPOJO extends ReadonlyDefaultPOJOBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected ReadonlyDefaultPOJO( ReadonlyDefaultPOJOBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ReadonlyDefaultPOJO objects.
   */
  public static ReadonlyDefaultPOJOBuilder<?, ?> builder( ) {
    return new ReadonlyDefaultPOJOBuilderImpl();
  }
}