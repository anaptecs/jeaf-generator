/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.rest.generics;

import javax.validation.Valid;

@Valid
public class GenericPageableResponse<T> extends GenericPageableResponseBase<T> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected GenericPageableResponse( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected GenericPageableResponse( GenericPageableResponse.BuilderBase<T> pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new GenericPageableResponse objects.
   */
  public static <T> Builder<T> builder( ) {
    return new Builder<T>();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new GenericPageableResponse objects. The method
   * never returns null.
   */
  public static <T> Builder<T> builder( GenericPageableResponse<T> pObject ) {
    return new Builder<T>(pObject);
  }

  /**
   * Class implements builder to create a new instance of class GenericPageableResponse. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder<T> extends GenericPageableResponse.BuilderBase<T> {
    /**
     * Use {@link GenericPageableResponse#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link GenericPageableResponse#builder(GenericPageableResponse)} instead of protected constructor to create
     * new builder.
     */
    protected Builder( GenericPageableResponse<T> pObject ) {
      super(pObject);
    }
  }
}