/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

public enum BankType {
  /**
   * Enumeration literal for bank of type &quot;Mutual Savings&quot;. <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>typeCode = "MS"</code><br/>
   */
  MUTUAL_SAVINGS("MS"),
  /**
   * Enumeration literal for bank of type &quot;Private Bank&quot;. <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>typeCode = "PB"</code><br/>
   */
  PRIVATE_BANK("PB");

  /**
   * Initialize object.
   */
  private BankType( String pTypeCode ) {
    typeCode = pTypeCode;
  }

  private final String typeCode;

  /**
   * Method returns attribute {@link #typeCode}.<br/>
   *
   * @return {@link String} Value to which {@link #typeCode} is set.
   */
  public String getTypeCode( ) {
    return typeCode;
  }
}