/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;

/**
 * Enumeration defines the different types of channels that are supported.
 * <p/>
 * <b>Alternate Name:</b> <code>Kanal</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public enum ChannelType {
  /**
   * counter <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>code = "CNT"</code><br/>
   * <p/>
   * <b>Alternate Name:</b> <code>BEDIENT</code>
   */
  @JEAFCustomAnnotationTest
  COUNTER("CNT"), @JEAFCustomAnnotationTest
  CALL_CENTER("CC"), @JEAFCustomAnnotationTest
  MOBILE("MOB"), @JEAFCustomAnnotationTest
  TVM("TVM"),
  /**
   * <br/>
   * <br/>
   * <b>Attribute values:</b><br/>
   * - <code>code = "WEB"</code><br/>
   * <p/>
   * <b>Breaking Change with 1.47.11:</b> Added new literal
   */
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
  LEGACY_POS("PRISMA");

  /**
   * Initialize object.
   */
  private ChannelType( String pCode ) {
    code = pCode;
  }

  /**
   * Code of the channel.<br/>
   * <br/>
   * Please be aware that properties for enumeration literals are not supported by OpenAPI. So, they are shown here only
   * for documentation purposes.
   */
  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private final String code;

  /**
   * Method returns attribute {@link #code}.<br/>
   * Code of the channel.<br/>
   * <br/>
   * Please be aware that properties for enumeration literals are not supported by OpenAPI. So, they are shown here only
   * for documentation purposes.
   *
   * @return {@link String} Value to which {@link #code} is set.
   */
  @JEAFCustomAnnotationTest
  public String getCode( ) {
    return code;
  }
}