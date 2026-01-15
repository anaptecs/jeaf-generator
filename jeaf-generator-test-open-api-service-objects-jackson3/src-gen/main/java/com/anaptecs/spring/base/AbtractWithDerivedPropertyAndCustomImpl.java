/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import javax.validation.Valid;

import com.anaptecs.annotations.MyNotNullProperty;

@Valid
public abstract class AbtractWithDerivedPropertyAndCustomImpl extends AbtractWithDerivedPropertyAndCustomImplBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AbtractWithDerivedPropertyAndCustomImpl( AbtractWithDerivedPropertyAndCustomImpl.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Class implements builder to create a new instance of class AbtractWithDerivedPropertyAndCustomImpl. As the class
   * has readonly attributes or associations instances can not be created directly. Instead this builder class has to be
   * used.
   */
  public static abstract class Builder extends AbtractWithDerivedPropertyAndCustomImpl.BuilderBase {
    /**
     * Use {@link AbtractWithDerivedPropertyAndCustomImpl#builder()} instead of protected constructor to create new
     * builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AbtractWithDerivedPropertyAndCustomImpl#builder(AbtractWithDerivedPropertyAndCustomImpl)} instead of
     * protected constructor to create new builder.
     */
    protected Builder( AbtractWithDerivedPropertyAndCustomImpl pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @MyNotNullProperty
  @Override
  public String getDerivedProperty( ) {
    // TODO Implement method for derived property "derivedProperty".
    return null;
  }
}