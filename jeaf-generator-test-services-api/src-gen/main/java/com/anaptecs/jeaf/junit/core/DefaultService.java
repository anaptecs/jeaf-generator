/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface DefaultService extends Service {
  /**
   */
  @JEAFCustomAnnotationTest
  default void doNothing( ) {
    // Nothing to do.
  }

  /**
   */
  @JEAFCustomAnnotationTest
  default void throwNYI( ) {
    throw new NotYetImplementedException("throwNYI('...') is not yet implemented.");
  }

  /**
   * @return int
   */
  @JEAFCustomAnnotationTest
  default int customImpl( ) {
    return 4711;
  }

  /**
   */
  @JEAFCustomAnnotationTest
  default void customTemplate( ) {
    System.out.println("Hey Guys, no AI, I'm only generated ;-)");
    System.out.println("Hey Guys, I'm generated too ;-)");
  }

  /**
   * @return {@link Double}
   */
  @JEAFCustomAnnotationTest
  default Double customImplNoDefault( ) {
    return Double.valueOf(0);
  }

  /**
   * @return {@link Color}
   */
  @JEAFCustomAnnotationTest
  default Color getColor( ) {
    return Color.BLACK;
  }

  /**
   * @return {@link Float}
   */
  @JEAFCustomAnnotationTest
  default Float getFloatWithDefault( ) {
    return Float.valueOf(47.11f);
  }

  /**
   * NotYetImplementedException is generated as at least one service operation throws such an exception in its default
   * implementation.
   */
  static class NotYetImplementedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotYetImplementedException( String pMessage ) {
      super(pMessage);
    }
  }
}