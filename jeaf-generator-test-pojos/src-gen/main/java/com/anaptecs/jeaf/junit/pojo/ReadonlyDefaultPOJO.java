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