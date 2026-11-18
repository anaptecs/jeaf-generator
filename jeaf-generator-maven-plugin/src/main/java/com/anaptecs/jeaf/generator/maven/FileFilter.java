/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

/**
 * Class filters files that should not be validated as OpenAPI specification based on a regular expression.
 */
class FileFilter {
  /**
   * Compiled exclude pattern. Null if no file should be excluded.
   */
  private final Pattern excludePattern;

  /**
   * Log to trace excluded files.
   */
  private final Log log;

  /**
   * Initialize object.
   *
   * @param pExcludePattern Regular expression that has to match the complete file name (without directory). If null or
   * empty no file will be excluded.
   * @param pLog Log to trace excluded files. The parameter must not be null.
   * @throws MojoExecutionException if the passed pattern is not a valid regular expression.
   */
  FileFilter( String pExcludePattern, Log pLog ) throws MojoExecutionException {
    log = pLog;
    if (pExcludePattern == null || pExcludePattern.isEmpty()) {
      excludePattern = null;
    }
    else {
      try {
        excludePattern = Pattern.compile(pExcludePattern);
      }
      catch (PatternSyntaxException e) {
        throw new MojoExecutionException("Invalid regular expression '" + pExcludePattern
            + "' for parameter openAPIValidationExcludePattern: " + e.getMessage(), e);
      }
    }
  }

  /**
   * Method removes all files whose name matches the exclude pattern.
   *
   * @param pFiles Files that should be filtered. The parameter must not be null.
   * @return {@link List} Files that do not match the exclude pattern.
   */
  List<String> filter(List<String> pFiles) {
    if (excludePattern == null) {
      return pFiles;
    }
    List<String> lResult = new ArrayList<>(pFiles.size());
    for (String lNextFile : pFiles) {
      if (excludePattern.matcher(new File(lNextFile).getName()).matches()) {
        log.debug("Excluding file from OpenAPI validation: " + lNextFile);
      }
      else {
        lResult.add(lNextFile);
      }
    }
    return lResult;
  }
}
