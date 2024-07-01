/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public abstract class AbstractWithCustomImpl extends AbstractWithCustomImplBase {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AbstractWithCustomImpl( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected AbstractWithCustomImpl( AbstractWithCustomImpl.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class AbstractWithCustomImpl. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class Builder extends AbstractWithCustomImpl.BuilderBase {
    /**
     * Use {@link AbstractWithCustomImpl#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AbstractWithCustomImpl#builder(AbstractWithCustomImpl)} instead of protected constructor to create new
     * builder.
     */
    protected Builder( AbstractWithCustomImpl pObject ) {
      super(pObject);
    }
  }
}