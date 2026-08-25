/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import com.anaptecs.jeaf.generator.annotations.DeprecationNotice;

public enum ClientType {
  CLIENT_1, CLIENT_2,
  /**
   * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
   */
  @Deprecated
  @DeprecationNotice(description = "", since = "", removedWith = "7.0", removalDate = "2026-09-13")
  CLIENT_3;
}