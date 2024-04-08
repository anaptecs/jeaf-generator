package com.anaptecs.jeaf.generator.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

public class OpenAPIValidationTest {
  @Test
  void testOpenAPI30Validation( ) throws IOException {
    File lFile = new File("./src/test/resources/openapi30/datatype-usage_3_0.yml");
    String lCanonicalPath = lFile.getCanonicalPath();
    lCanonicalPath = lCanonicalPath.replaceAll("\\\\", "/");
    ParseOptions lOptions = new ParseOptions();
    lOptions.setResolve(true);
    SwaggerParseResult lResult =
        new OpenAPIParser().readLocation(lCanonicalPath, (List<AuthorizationValue>) null, lOptions);

    System.out.println(lResult.getMessages());
    assertTrue(lResult.getMessages().isEmpty());
  }

  @Test
  void testOpenAPI31Validation( ) throws IOException {
    File lFile = new File("./src/test/resources/openapi31/datatype-usage_3_1.yml");
    String lCanonicalPath = lFile.getCanonicalPath();
    lCanonicalPath = lCanonicalPath.replaceAll("\\\\", "/");

    ParseOptions lOptions = new ParseOptions();
    lOptions.setResolve(true);
    SwaggerParseResult lResult =
        new OpenAPIParser().readLocation(lCanonicalPath, (List<AuthorizationValue>) null, lOptions);

    System.out.println(lResult.getMessages());
    assertTrue(lResult.getMessages().isEmpty());
  }
}
