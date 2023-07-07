/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

public class CustomPrimitiveArraysObjectWithRestrictions extends CustomPrimitiveArraysObjectWithRestrictionsBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CustomPrimitiveArraysObjectWithRestrictions( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected CustomPrimitiveArraysObjectWithRestrictions(
      CustomPrimitiveArraysObjectWithRestrictions.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new CustomPrimitiveArraysObjectWithRestrictions
   * objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new CustomPrimitiveArraysObjectWithRestrictions
   * objects. The method never returns null.
   */
  public static Builder builder( CustomPrimitiveArraysObjectWithRestrictions pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class CustomPrimitiveArraysObjectWithRestrictions. As the
   * class has readonly attributes or associations instances can not be created directly. Instead this builder class has
   * to be used.
   */
  public static class Builder extends CustomPrimitiveArraysObjectWithRestrictions.BuilderBase {
    /**
     * Use {@link CustomPrimitiveArraysObjectWithRestrictions#builder()} instead of protected constructor to create new
     * builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link CustomPrimitiveArraysObjectWithRestrictions#builder(CustomPrimitiveArraysObjectWithRestrictions)}
     * instead of protected constructor to create new builder.
     */
    protected Builder( CustomPrimitiveArraysObjectWithRestrictions pObject ) {
      super(pObject);
    }
  }
}