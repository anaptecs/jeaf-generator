package com.anaptecs.jeaf.junit.openapi.base;

public enum ChannelType {
  COUNTER("CNT"), CALL_CENTER("CC"), MOBILE("MOB"), TVM("TVM"), WEB("WEB"), @Deprecated
  LEGACY_POS("PRISMA");

  /**
   * Initialize object.
   */
  private ChannelType( String pCode ) {
    code = pCode;
  }

  private final String code;

  /**
   * Method returns attribute {@link #code}.<br/>
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }
}