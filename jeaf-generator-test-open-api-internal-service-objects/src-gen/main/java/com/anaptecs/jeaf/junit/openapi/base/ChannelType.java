package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.constraints.NotNull;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public enum ChannelType {
  COUNTER("CNT"), CALL_CENTER("CC"), MOBILE("MOB"), TVM("TVM"), WEB("WEB"), @Deprecated
  LEGACY_POS("PRISMA");

  /**
   * Initialize object.
   */
  private ChannelType( String pCode ) {
    code = pCode;
  }

  /**
   * 
   */
  @NotNull
  private final String code;

  /**
   * Method returns the attribute "code".
   * 
   * 
   * @return String Value to which the attribute "code" is set.
   */
  public String getCode( ) {
    return code;
  }
}