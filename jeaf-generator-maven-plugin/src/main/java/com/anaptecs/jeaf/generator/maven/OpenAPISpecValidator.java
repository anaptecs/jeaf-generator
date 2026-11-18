/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import java.util.Collections;
import java.util.List;

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
      // E.g. empty files or YAML files that are no OpenAPI specification. Only a warning to not break existing builds.
      if (lResult.getOpenAPI() == null && lErrorMessages.isEmpty()) {
        lWarnings = List.of("File " + pFileName
            + " does not contain an OpenAPI specification. Please consider to exclude it using parameter 'openAPIValidationExcludePattern'.");
      }
      else {
        lWarnings = Collections.emptyList();
      }
    }
    return new Result(lErrorMessages, lWarnings);
  }
}
