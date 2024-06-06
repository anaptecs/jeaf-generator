/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public enum ExtensibleEnum {
  RED, GREEN, BLUE,
  /**
   * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
   * interface.
   */
  UNKNOWN;
}