/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum;
import com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum.ExtensibleEnumType;

public class ExtensibleEnumTest {
  @Test
  void testExtensibleEnum( ) {
    ExtensibleEnum lBlue = ExtensibleEnum.BLUE;
    assertEquals(ExtensibleEnumType.BLUE, lBlue.getLiteral());
    assertEquals(false, lBlue.isUnknownLiteral());
    assertEquals(null, lBlue.getUnknownLiteralName());

    ExtensibleEnum lPink = new ExtensibleEnum("PINK");
    assertEquals(ExtensibleEnumType.UNKNOWN, lPink.getLiteral());
    assertEquals(true, lPink.isUnknownLiteral());
    assertEquals("PINK", lPink.getUnknownLiteralName());

    // Test generated equals() and hashCode()
    assertEquals(true, lBlue.equals(lBlue));
    assertEquals(true, lBlue.equals(new ExtensibleEnum("BLUE")));
    assertEquals(lBlue.hashCode(), new ExtensibleEnum("BLUE").hashCode());
    assertNotEquals(lBlue.hashCode(), lPink.hashCode());
    assertNotEquals(lBlue, lPink);
    assertNotEquals(lPink, lBlue);
    assertNotEquals(lPink, new Object());

    ExtensibleEnum lPink2 = new ExtensibleEnum("PINK");
    ExtensibleEnum lGrey = new ExtensibleEnum("GREY");
    assertEquals(lPink, lPink2);
    assertNotEquals(lPink2, lGrey);
    assertNotEquals(lPink, null);

  }

}
