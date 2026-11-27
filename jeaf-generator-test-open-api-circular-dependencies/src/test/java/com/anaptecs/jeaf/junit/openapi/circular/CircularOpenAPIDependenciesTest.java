package com.anaptecs.jeaf.junit.openapi.circular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/**
 * CircularSpecA, CircularSpecB and CircularSpecC depend on each other (A -> B -> A, B -> C -> A). CircularSpecD depends
 * on CircularSpecA without being part of the cycle.
 */
public class CircularOpenAPIDependenciesTest {
  private static final Pattern REF = Pattern.compile("\\$ref: '([^']*)'");

  @Test
  void testSchemas( ) throws IOException {
    for (String lName : List.of("A", "B", "C", "D")) {
      String lSpec = this.readSpec("circular-spec-" + lName.toLowerCase() + ".yml");
      assertTrue(lSpec.contains("\n    CircularType" + lName + ":\n"), "Schema CircularType" + lName + " missing.");
    }
  }

  @Test
  void testReferences( ) throws IOException {
    assertEquals(List.of("circular-spec-b.yml#/components/schemas/CircularTypeB"), this.getRefs("circular-spec-a.yml"));
    assertEquals(List.of("circular-spec-a.yml#/components/schemas/CircularTypeA",
        "circular-spec-c.yml#/components/schemas/CircularTypeC"), this.getRefs("circular-spec-b.yml"));
    assertEquals(List.of("circular-spec-a.yml#/components/schemas/CircularTypeA"), this.getRefs("circular-spec-c.yml"));
    assertEquals(List.of("circular-spec-a.yml#/components/schemas/CircularTypeA"), this.getRefs("circular-spec-d.yml"));
  }

  private List<String> getRefs( String pResource ) throws IOException {
    Matcher lMatcher = REF.matcher(this.readSpec(pResource));
    return lMatcher.results().map(e -> e.group(1)).toList();
  }

  private String readSpec( String pResource ) throws IOException {
    try (InputStream lStream = this.getClass().getClassLoader().getResourceAsStream(pResource)) {
      assertNotNull(lStream, "OpenAPI specification " + pResource + " was not generated.");
      return new String(lStream.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
