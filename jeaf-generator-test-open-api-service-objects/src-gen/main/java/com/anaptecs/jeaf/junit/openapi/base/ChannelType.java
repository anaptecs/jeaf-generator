/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;

/**
 * <p/>
 * <b>Alternate Name:</b> <code>Kanal</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public enum ChannelType {
  /**
   * counter <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>code = "CNT"</code><br/>
   * <p/>
   * <b>Alternate Name:</b> <code>BEDIENT</code>
   */
  COUNTER("CNT"), CALL_CENTER("CC"), MOBILE("MOB"), TVM("TVM"),
  /**
   * <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>code = "WEB"</code><br/>
   * <p/>
   * <b>Breaking Change with 1.47.11:</b> Added new literal
   */
  WEB("WEB"),
  /**
   * <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>code = "PRISMA"</code><br/>
   *
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

  @NotNull
  private final String code;

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link String} Value to which {@link #code} is set.
   */
  @MyNotNullProperty
  public String getCode( ) {
    return code;
  }
}