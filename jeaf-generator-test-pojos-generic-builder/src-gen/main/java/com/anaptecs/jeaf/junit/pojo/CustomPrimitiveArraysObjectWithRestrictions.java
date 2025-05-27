/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class CustomPrimitiveArraysObjectWithRestrictions extends CustomPrimitiveArraysObjectWithRestrictionsBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected CustomPrimitiveArraysObjectWithRestrictions(
      CustomPrimitiveArraysObjectWithRestrictionsBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CustomPrimitiveArraysObjectWithRestrictions
   * objects.
   */
  public static CustomPrimitiveArraysObjectWithRestrictionsBuilder<?, ?> builder( ) {
    return new CustomPrimitiveArraysObjectWithRestrictionsBuilderImpl();
  }
}