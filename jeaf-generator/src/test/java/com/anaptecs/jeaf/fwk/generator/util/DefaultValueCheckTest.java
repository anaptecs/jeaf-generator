package com.anaptecs.jeaf.fwk.generator.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DefaultValueCheckTest {
  @Test
  void testIntegerTypes( ) {
    assertTrue(DefaultValueCheck.isValidValue("int", "4711"));
    assertTrue(DefaultValueCheck.isValidValue("java.lang.Long", " -42L "));
    assertTrue(DefaultValueCheck.isValidValue("short", "1"));
    assertFalse(DefaultValueCheck.isValidValue("int", "abc"));
    assertFalse(DefaultValueCheck.isValidValue("Integer", "4.5"));
    assertFalse(DefaultValueCheck.isValidValue("int", "\"42\""));
    assertFalse(DefaultValueCheck.isValidValue("int", null));
  }

  @Test
  void testDecimalTypes( ) {
    assertTrue(DefaultValueCheck.isValidValue("double", "42.0"));
    assertTrue(DefaultValueCheck.isValidValue("java.math.BigDecimal", "47.11"));
    assertTrue(DefaultValueCheck.isValidValue("float", "1.5f"));
    assertTrue(DefaultValueCheck.isValidValue("java.lang.Double", "1e-3"));
    assertTrue(DefaultValueCheck.isValidValue("double", "42"));
    assertFalse(DefaultValueCheck.isValidValue("double", "4,2"));
    assertFalse(DefaultValueCheck.isValidValue("float", ""));
  }

  @Test
  void testBooleanTypes( ) {
    assertTrue(DefaultValueCheck.isValidValue("boolean", "true"));
    assertTrue(DefaultValueCheck.isValidValue("java.lang.Boolean", "false"));
    assertFalse(DefaultValueCheck.isValidValue("boolean", "maybe"));
    assertFalse(DefaultValueCheck.isValidValue("boolean", "TRUE"));
  }

  @Test
  void testOtherTypesAreNotChecked( ) {
    assertTrue(DefaultValueCheck.isValidValue("java.lang.String", "anything"));
    assertTrue(DefaultValueCheck.isValidValue("com.anaptecs.CurrencyCode", "\"CHF\""));
  }
}
