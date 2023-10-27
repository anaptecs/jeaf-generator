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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadonlyDefaultPOJO( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected ReadonlyDefaultPOJO( ReadonlyDefaultPOJO.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ReadonlyDefaultPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ReadonlyDefaultPOJO objects. The method never
   * returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( ReadonlyDefaultPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ReadonlyDefaultPOJO. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ReadonlyDefaultPOJO.BuilderBase {
    /**
     * Use {@link ReadonlyDefaultPOJO#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReadonlyDefaultPOJO#builder(ReadonlyDefaultPOJO)} instead of protected constructor to create new
     * builder.
     */
    protected Builder( ReadonlyDefaultPOJO pObject ) {
      super(pObject);
    }
  }
}