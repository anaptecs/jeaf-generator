/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

/**
 * Class validates a single OpenAPI specification file.
 */
final class OpenAPISpecValidator {
  /**
   * Warnings and error messages of the validation of one OpenAPI specification.
   */
  record Result(List<String> errors, List<String> warnings) {
  }

  private OpenAPISpecValidator( ) {
    // Only static methods.
  }

  /**
   * Method validates the passed OpenAPI specification.
   *
   * @param pFileName Path of the OpenAPI specification. The parameter must not be null.
   * @param pValidateReferencedOpenAPISpecs If <code>true</code> referenced specifications are resolved and validated
   * as well.
   * @return {@link Result} Errors and warnings of the validation. The method never returns null.
   */
  static Result validate(String pFileName, boolean pValidateReferencedOpenAPISpecs) {
    ParseOptions lOptions = new ParseOptions();
    lOptions.setResolve(pValidateReferencedOpenAPISpecs);

    // Workaround for https://github.com/OpenAPITools/openapi-generator/issues/14648
    SwaggerParseResult lResult =
        new OpenAPIParser().readLocation(pFileName.replaceAll("\\\\", "/"), (List<AuthorizationValue>) null, lOptions);

    List<String> lErrorMessages;
    List<String> lWarnings;
    if (lResult == null) {
      lErrorMessages = List.of("Parsing of OpenAPI Specification in file " + pFileName + " failed for unknown reason.");
      lWarnings = Collections.emptyList();
    }
    else {
      lErrorMessages = lResult.getMessages() != null ? lResult.getMessages() : Collections.emptyList();
      lWarnings = Collections.emptyList();
      if (lResult.getOpenAPI() == null && lErrorMessages.isEmpty()) {
        // The parser also returns nothing for files that are no valid YAML at all. They have to break the build.
        String lSyntaxError = getYAMLSyntaxError(pFileName);
        if (lSyntaxError != null) {
          lErrorMessages = List.of("File " + pFileName + " is not a valid YAML file: " + lSyntaxError);
        }
        // E.g. empty files. Only a warning to not break existing builds.
        else {
          lWarnings = List.of("File " + pFileName
              + " does not contain an OpenAPI specification. Please consider to exclude it using parameter 'openAPIValidationExcludePattern'.");
        }
      }
    }
    return new Result(lErrorMessages, lWarnings);
  }

  /**
   * @return {@link String} Syntax error of the passed YAML file incl. its location or <code>null</code> if it is valid
   * YAML.
   */
  private static String getYAMLSyntaxError(String pFileName) {
    String lError;
    try {
      new ObjectMapper(new YAMLFactory()).readTree(Files.readString(Path.of(pFileName), StandardCharsets.UTF_8));
      lError = null;
    }
    catch (JsonProcessingException e) {
      lError = e.getOriginalMessage() + (e.getLocation() != null ? " (line " + e.getLocation().getLineNr()
          + ", column " + e.getLocation().getColumnNr() + ")" : "");
    }
    catch (IOException e) {
      lError = e.getMessage();
    }
    return lError;
  }
}
