package com.anaptecs.jeaf.accounting;

public enum BankType {
  /**
   * Enumeration literal for bank of type &quot;Mutual Savings&quot;.
   */
  MUTUAL_SAVINGS("MS"),
  /**
   * Enumeration literal for bank of type &quot;Private Bank&quot;.
   */
  PRIVATE_BANK("PB");

  /**
   * Initialize object.
   */
  private BankType( String pTypeCode ) {
    typeCode = pTypeCode;
  }

  private String typeCode;

  /**
   * Method returns attribute {@link #typeCode}.<br/>
   *
   * @return {@link String} Value to which {@link #typeCode} is set.
   */
  public String getTypeCode( ) {
    return typeCode;
  }
}