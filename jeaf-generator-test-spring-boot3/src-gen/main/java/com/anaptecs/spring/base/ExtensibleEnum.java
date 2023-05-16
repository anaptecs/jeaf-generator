package com.anaptecs.spring.base;

public enum ExtensibleEnum {
  RED, GREEN, BLUE,
  /**
   * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
   * interface.
   */
  UNKNOWN;
}