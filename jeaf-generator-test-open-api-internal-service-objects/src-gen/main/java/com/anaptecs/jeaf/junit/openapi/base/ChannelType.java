package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.constraints.NotNull;

public enum ChannelType {
  COUNTER("CNT"), CALL_CENTER("CC"), MOBILE("MOB"), TVM("TVM"), WEB("WEB"), @Deprecated
  LEGACY_POS("PRISMA");

  /**
   * Initialize object.
   */
  private ChannelType( String pCode ) {
    code = pCode;
  }

  @NotNull
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