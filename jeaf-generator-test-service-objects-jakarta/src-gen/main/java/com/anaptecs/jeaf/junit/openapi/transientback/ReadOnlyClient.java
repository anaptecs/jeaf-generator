/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

public class ReadOnlyClient extends ReadOnlyClientBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadOnlyClient( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected ReadOnlyClient( ReadOnlyClient.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ReadOnlyClient objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class ReadOnlyClient. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ReadOnlyClient.BuilderBase {
    /**
     * Use {@link ReadOnlyClient#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ReadOnlyClient#builder(ReadOnlyClient)} instead of protected constructor to create new builder.
     */
    protected Builder( ReadOnlyClient pObject ) {
      super(pObject);
    }
  }
}