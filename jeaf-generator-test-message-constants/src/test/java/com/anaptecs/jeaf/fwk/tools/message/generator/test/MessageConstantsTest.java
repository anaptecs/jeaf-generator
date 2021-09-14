/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.generator.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.jeaf.sample.yourapp.MyMessages;

public class MessageConstantsTest {
  @SuppressWarnings("deprecation")
  @Test
  public void testMessageConstantsUsage( ) {
    ErrorCode lErrorCode = MyMessages.BANK_BALANCE_NOT_SUFFICIENT;
    XFun.getTrace().write(lErrorCode);
    lErrorCode = MyMessages.SOURCE_BANK_ACCOUNT_LOCKED;
    XFun.getTrace().write(lErrorCode);
    lErrorCode = MyMessages.INVALID_TARGET_BANK_ACCOUNT;
    XFun.getTrace().write(lErrorCode);
    XFun.getTrace().write(MyMessages.TRACE_MESSAGE);
    XFun.getTrace().write(MyMessages.DEBUG_MESSAGE);
    XFun.getTrace().write(MyMessages.INFO_MESSAGE);
    XFun.getTrace().write(MyMessages.WARN_MESSAGE);
    XFun.getTrace().write(MyMessages.ERROR_MESSAGE);
    XFun.getTrace().write(MyMessages.FATAL_MESSAGE);
    XFun.getTrace().info(MyMessages.LOCALIZED_MESSAGE.toString());
    XFun.getTrace().info(MyMessages.DEPRECATED_LOCALIZED_MESSAGE.toString());
    XFun.getTrace().info(MyMessages.WELCOME_LABEL.toString());
    XFun.getTrace().info(MyMessages.IBAN_LABEL.toString());
    XFun.getTrace().info(MyMessages.BEST_REGARDS.toString());
  }

  @Test
  public void testDeprecationMarkers( ) throws NoSuchFieldException, SecurityException {
    // Check if generated constants have expected @Deprectaed annotation.
    Field lField = MyMessages.class.getField("BANK_BALANCE_NOT_SUFFICIENT");
    assertNotNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("DEBUG_MESSAGE");
    assertNotNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("DEPRECATED_LOCALIZED_MESSAGE");
    assertNotNull(lField.getAnnotation(Deprecated.class));

    // Other constants should not have it.
    lField = MyMessages.class.getField("SOURCE_BANK_ACCOUNT_LOCKED");
    assertNull(lField.getAnnotation(Deprecated.class));

    lField = MyMessages.class.getField("INVALID_TARGET_BANK_ACCOUNT");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("SOURCE_BANK_ACCOUNT_LOCKED");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("TRACE_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("INFO_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("WARN_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("ERROR_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("FATAL_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("LOCALIZED_MESSAGE");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("WELCOME_LABEL");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("IBAN_LABEL");
    assertNull(lField.getAnnotation(Deprecated.class));
    lField = MyMessages.class.getField("BEST_REGARDS");
    assertNull(lField.getAnnotation(Deprecated.class));
  }
}
