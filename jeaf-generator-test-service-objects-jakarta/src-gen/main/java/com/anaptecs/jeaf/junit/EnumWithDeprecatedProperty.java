/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit;

public enum EnumWithDeprecatedProperty {
  A(1, "A"), @Deprecated
  B(2, "B"), C(3, "C");

  /**
   * Initialize object.
   */
  private EnumWithDeprecatedProperty( int pMyProperty, String pDoNotUse ) {
    myProperty = pMyProperty;
    doNotUse = pDoNotUse;
  }

  private final int myProperty;

  /**
   * @deprecated Very outdated (<b>since:</b> 08.15, <b>removed with:</b> 47.11)
   */
  @Deprecated
  private final String doNotUse;

  /**
   * Method returns attribute {@link #myProperty}.<br/>
   *
   * @return int Value to which {@link #myProperty} is set.
   */
  public int getMyProperty( ) {
    return myProperty;
  }

  /**
   * Method returns attribute {@link #doNotUse}.<br/>
   *
   * @return {@link String} Value to which {@link #doNotUse} is set.
   * @deprecated Very outdated (<b>since:</b> 08.15, <b>removed with:</b> 47.11)
   */
  @Deprecated
  public String getDoNotUse( ) {
    return doNotUse;
  }
}