package com.anaptecs.jeaf.junit.openapi.base;

public enum ChannelType {
  COUNTER("CNT"), CALL_CENTER("CC"), MOBILE("MOB"), TVM("TVM"), WEB("WEB"),
  /**
   * @deprecated I'm <code>DEPRECATED</code>. (<b>since:</b> TBD, <b>removed with:</b> TBD)
   */
  @Deprecated
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
   * @return {@link String} Value to which {@link #code} is set.
   */
  public String getCode( ) {
    return code;
  }
}