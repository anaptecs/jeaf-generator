/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.generator.annotations.Alias;
import com.anaptecs.jeaf.generator.annotations.BreakingChangeNotice;

/**
 * <p/>
 * <b>Alternate Name:</b> <code>MyFormerName</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Alias(alternateNames = { "MyFormerName" })
public enum MyType {
  ALPHA, BETA,
  /**
   * <p/>
   * <b>Breaking Change with 47.11:</b> X-mas present
   */
  @BreakingChangeNotice(
      description = "X-mas present",
      since = "1.0.0",
      activeWith = "47.11",
      activationDate = "2024-12-24")
  GAMMA;
}