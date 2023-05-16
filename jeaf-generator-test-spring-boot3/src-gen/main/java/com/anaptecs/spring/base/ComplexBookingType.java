package com.anaptecs.spring.base;

public enum ComplexBookingType {
  COMPLEX, VERY_COMPLEX,
  /**
   * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
   * interface.
   */
  UNKNOWN;
}