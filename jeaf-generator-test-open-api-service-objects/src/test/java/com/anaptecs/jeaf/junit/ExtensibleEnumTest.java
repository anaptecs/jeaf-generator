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

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.anaptecs.jeaf.junit.openapi.base.EnumTest;
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

    ExtensibleEnum lUnknown = new ExtensibleEnum(ExtensibleEnumType.UNKNOWN);
    assertNotEquals(lUnknown, lEnum);
    assertNotEquals(lEnum, lUnknown);
    ExtensibleEnum lUnknown2 = new ExtensibleEnum(ExtensibleEnumType.UNKNOWN);
    assertEquals(lUnknown, lUnknown2);

    // Also check hashCode()
    int lHashCode1 = lUnknown.hashCode();
    int lHashCode2 = lUnknown2.hashCode();
    assertEquals(lHashCode1, lHashCode2);

    ExtensibleEnum lPink = ExtensibleEnum.valueOf("PINK");
    ExtensibleEnum lGrey = ExtensibleEnum.valueOf("GREY");
    assertNotEquals(lPink, lGrey);

  }

  @Test
  void testSerialization( ) {
    JSONTools lTools = JSON.getJSONTools();
    String lJSON = lTools.writeObjectToString(ExtensibleEnum.BLUE);
    assertEquals("\"BLUE\"", lJSON);

    ExtensibleEnum lReadEnum = lTools.read(lJSON, ExtensibleEnum.class);
    assertEquals(ExtensibleEnum.BLUE, lReadEnum);
    assertTrue(ExtensibleEnum.BLUE == lReadEnum);

    ExtensibleEnum lPink = ExtensibleEnum.valueOf("PINK");
    lJSON = lTools.writeObjectToString(lPink);
    assertEquals("\"PINK\"", lJSON);

    lReadEnum = lTools.read(lJSON, ExtensibleEnum.class);
    assertEquals(lPink, lReadEnum);
    assertFalse(lPink == lReadEnum);

    ExtensibleEnum lUnknown = new ExtensibleEnum(ExtensibleEnumType.UNKNOWN);
    lJSON = lTools.writeObjectToString(lUnknown);
    assertEquals("\"UNKNOWN\"", lJSON);

    lReadEnum = lTools.read(lJSON, ExtensibleEnum.class);
    assertEquals(lUnknown, lReadEnum);
    assertFalse(lUnknown == lReadEnum);

    EnumTest lEnumTest = EnumTest.builder().setEnumRef(lPink).build();
    lJSON = lTools.writeObjectToString(lEnumTest);
    assertEquals("{\"property\":\"GREEN\",\"enumRef\":\"PINK\"}", lJSON);

    EnumTest lRead = lTools.read(lJSON, EnumTest.class);
    assertEquals(ExtensibleEnum.GREEN, lRead.getProperty());
    assertEquals(lPink, lRead.getEnumRef());
  }
}
