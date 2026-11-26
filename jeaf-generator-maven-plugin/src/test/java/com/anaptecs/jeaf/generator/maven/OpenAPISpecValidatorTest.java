/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class OpenAPISpecValidatorTest {
  private static OpenAPISpecValidator.Result validate(String pFile) throws IOException {
    return OpenAPISpecValidator.validate(new File("./src/test/resources/" + pFile).getCanonicalPath(), true);
  }

  @Test
  void testValidSpecs( ) throws IOException {
    for (String lFile : new String[] { "openapi30/datatype-usage_3_0.yml", "openapi31/datatype-usage_3_1.yml" }) {
      OpenAPISpecValidator.Result lResult = validate(lFile);
      assertTrue(lResult.errors().isEmpty(), lFile + ": " + lResult.errors());
      assertTrue(lResult.warnings().isEmpty(), lFile + ": " + lResult.warnings());
    }
  }

  @Test
  void testEmptyFileOnlyCausesWarning( ) throws IOException {
    OpenAPISpecValidator.Result lResult = validate("validation/empty.yaml");
    assertTrue(lResult.errors().isEmpty());
    assertEquals(1, lResult.warnings().size());
    assertTrue(lResult.warnings().get(0).contains("openAPIValidationExcludePattern"));
  }

  @Test
  void testYAMLWithoutOpenAPISpecCausesErrors( ) throws IOException {
    // The parser reports missing OpenAPI attributes, so such files have to be excluded explicitly.
    OpenAPISpecValidator.Result lResult = validate("validation/not-openapi.yaml");
    assertFalse(lResult.errors().isEmpty());
    assertTrue(lResult.warnings().isEmpty());
  }

  @Test
  void testInvalidYAMLCausesError( ) throws IOException {
    OpenAPISpecValidator.Result lResult = validate("validation/invalid-yaml.yaml");
    assertEquals(1, lResult.errors().size(), lResult.errors().toString());
    assertTrue(lResult.errors().get(0).contains("is not a valid YAML file"), lResult.errors().get(0));
    assertTrue(lResult.errors().get(0).contains("line 14"), lResult.errors().get(0));
    assertTrue(lResult.warnings().isEmpty());
  }

  @Test
  void testBrokenReferenceCausesErrors( ) throws IOException {
    OpenAPISpecValidator.Result lResult = validate("validation/broken-ref.yaml");
    assertFalse(lResult.errors().isEmpty());
    assertTrue(lResult.errors().get(0).contains("does-not-exist.yaml"));
    assertTrue(lResult.warnings().isEmpty());
  }
}
