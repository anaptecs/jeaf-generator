/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit;

/* PROTECTED REGION ID(Import:com.anaptecs.jeaf.junit.MyEnumWithInterface) ENABLED START */

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.junit.openapi.base.TimeUnit;
/* PROTECTED REGION END */

public enum MyEnumWithInterface implements MyEnumInfo {
  ONE("one", TimeUnit.MINUTE), TWO("two", TimeUnit.HOUR), MANY("three", TimeUnit.YEAR);

  /**
   * Initialize object.
   */
  private MyEnumWithInterface( String pName, TimeUnit pTimeUnit ) {
    name = pName;
    timeUnit = pTimeUnit;
  }

  @NotNull
  private final String name;

  private TimeUnit timeUnit;

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns association {@link #timeUnit}.<br/>
   *
   * @return {@link TimeUnit} Value to which {@link #timeUnit} is set.
   */
  public TimeUnit getTimeUnit( ) {
    return timeUnit;
  }

  /* PROTECTED REGION ID(com.anaptecs.jeaf.junit.MyEnumWithInterface) ENABLED START */
  // Hello World
  public void doSomething( ) {
  }

  public Map<String, String> getMap( ) {
    return new HashMap<>();
  }
  /* PROTECTED REGION END */
}