/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

public interface DefaultService extends com.anaptecs.jeaf.core.api.Service {
  /**
   */
  default void doNothing( ) {
    // Nothing to do.
  }

  /**
   */
  default void throwNYI( ) {
    throw new NotYetImplementedException("throwNYI('...') is not yet implemented.");
  }

  /**
   * @return int
   */
  default int customImpl( ) {
    return 4711;
  }

  /**
   */
  default void customTemplate( ) {
    System.out.println("Hey Guys, no AI, I'm only generated ;-)");
  }

  /**
   * @return {@link java.lang.Double}
   */
  default java.lang.Double customImplNoDefault( ) {
    return java.lang.Double.valueOf(0);
  }

  /**
   * @return {@link com.anaptecs.jeaf.junit.core.Color}
   */
  default com.anaptecs.jeaf.junit.core.Color getColor( ) {
    return com.anaptecs.jeaf.junit.core.Color.BLACK;
  }

  /**
   * @return {@link java.lang.Float}
   */
  default java.lang.Float getFloatWithDefault( ) {
    return java.lang.Float.valueOf(47.11f);
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
