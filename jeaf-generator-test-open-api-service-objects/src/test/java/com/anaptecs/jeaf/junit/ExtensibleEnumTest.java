/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

  @Test
  void testValueOf( ) {
    ExtensibleEnum lEnum = ExtensibleEnum.valueOf("BLUE");
    assertEquals(ExtensibleEnum.BLUE, lEnum);
    assertTrue(ExtensibleEnum.BLUE == lEnum);
    assertEquals(ExtensibleEnumType.BLUE, lEnum.getLiteral());
    assertFalse(lEnum.isUnknownLiteral());
    assertEquals(null, lEnum.getUnknownLiteralName());

    lEnum = ExtensibleEnum.valueOf("RED");
    assertEquals(ExtensibleEnum.RED, lEnum);
    assertTrue(ExtensibleEnum.RED == lEnum);
    assertEquals(ExtensibleEnumType.RED, lEnum.getLiteral());
    assertFalse(lEnum.isUnknownLiteral());
    assertEquals(null, lEnum.getUnknownLiteralName());

    lEnum = ExtensibleEnum.valueOf("GREEN");
    assertEquals(ExtensibleEnum.GREEN, lEnum);
    assertTrue(ExtensibleEnum.GREEN == lEnum);
    assertEquals(ExtensibleEnumType.GREEN, lEnum.getLiteral());
    assertFalse(lEnum.isUnknownLiteral());
    assertEquals(null, lEnum.getUnknownLiteralName());

    lEnum = ExtensibleEnum.valueOf("UNKNOWN");
    assertEquals(ExtensibleEnumType.UNKNOWN, lEnum.getLiteral());
    assertTrue(lEnum.isUnknownLiteral());
    assertEquals(null, lEnum.getUnknownLiteralName());

    lEnum = ExtensibleEnum.valueOf("PINK");
    assertEquals(ExtensibleEnumType.UNKNOWN, lEnum.getLiteral());
    assertEquals(true, lEnum.isUnknownLiteral());
    assertEquals("PINK", lEnum.getUnknownLiteralName());
  }

}