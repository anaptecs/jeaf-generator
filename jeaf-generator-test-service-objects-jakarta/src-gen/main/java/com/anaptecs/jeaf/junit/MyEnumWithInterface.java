/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit;

/* PROTECTED REGION ID(Import:com.anaptecs.jeaf.junit.MyEnumWithInterface) ENABLED START */
import java.util.HashMap;
import java.util.Map;
/* PROTECTED REGION END */

public enum MyEnumWithInterface implements MyEnumInfo {
  ONE, TWO, MANY;

  /* PROTECTED REGION ID(com.anaptecs.jeaf.junit.MyEnumWithInterface) ENABLED START */
  // Hello World
  public void doSomething( ) {
  }

  public Map<String, String> getMap( ) {
    return new HashMap<>();
  }
  /* PROTECTED REGION END */
}
