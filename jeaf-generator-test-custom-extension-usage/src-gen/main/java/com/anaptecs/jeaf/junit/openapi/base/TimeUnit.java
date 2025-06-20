/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

/**
 * Enumeration represents time units.<br/>
 * <br/>
 * NOVA 14 Mapping
 * </p>
 * <ul>
 * <li>nova-base.xsd.ZeitEinheit</li>
 * </ul>
 * <p/>
 * <b>Alternate Name:</b> <code>Zeiteinheit</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public enum TimeUnit {
  /**
   * Literal represents time unit &quot;minutes&quot;.
   */
  @JEAFCustomAnnotationTest
  MINUTE, @JEAFCustomAnnotationTest
  HOUR, @JEAFCustomAnnotationTest
  DAY,
  /**
   * Literal represents time unit &quot;weeks&quot;.<br/>
   * This is the comments second line ;-)
   */
  @JEAFCustomAnnotationTest
  WEEK, @JEAFCustomAnnotationTest
  MONTH, @JEAFCustomAnnotationTest
  YEAR;
}