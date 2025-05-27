/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public abstract class AbstractWithCustomImpl extends AbstractWithCustomImplBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected AbstractWithCustomImpl( AbstractWithCustomImplBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }
}