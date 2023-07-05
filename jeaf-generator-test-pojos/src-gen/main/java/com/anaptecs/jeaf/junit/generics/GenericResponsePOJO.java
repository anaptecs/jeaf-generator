/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

public class GenericResponsePOJO<T> extends GenericResponsePOJOBase<T> {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GenericResponsePOJO( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected GenericResponsePOJO( GenericResponsePOJO.BuilderBase<T> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new GenericResponsePOJO objects.
   */
  public static <T> Builder<T> builder( ) {
    return new Builder<T>();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new GenericResponsePOJO objects. The method never
   * returns null.
   */
  public static <T> Builder<T> builder( GenericResponsePOJO<T> pObject ) {
    return new Builder<T>(pObject);
  }

  /**
   * Class implements builder to create a new instance of class GenericResponsePOJO. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder<T> extends GenericResponsePOJO.BuilderBase<T> {
    /**
     * Use {@link GenericResponsePOJO#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link GenericResponsePOJO#builder(GenericResponsePOJO)} instead of protected constructor to create new
     * builder.
     */
    protected Builder( GenericResponsePOJO<T> pObject ) {
      super(pObject);
    }
  }
}