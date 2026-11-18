/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.junit.jupiter.api.Test;

public class FileFilterTest {
  private static final String DIR = "target" + File.separator + "res-gen" + File.separator;

  private static final List<String> FILES =
      List.of(DIR + "product-api.yaml", DIR + "product-api-nam.yaml", DIR + "base" + File.separator + "base-nam.yml");

  @Test
  void testNoPatternKeepsAllFiles( ) throws MojoExecutionException {
    assertEquals(FILES, new FileFilter(null, new SystemStreamLog()).filter(FILES));
    assertEquals(FILES, new FileFilter("", new SystemStreamLog()).filter(FILES));
  }

  @Test
  void testPatternExcludesMatchingFileNames( ) throws MojoExecutionException {
    FileFilter lFilter = new FileFilter(".*-nam\\.ya?ml", new SystemStreamLog());
    assertEquals(List.of(DIR + "product-api.yaml"), lFilter.filter(FILES));
  }

  @Test
  void testPatternIsMatchedAgainstFileNameOnly( ) throws MojoExecutionException {
    // Pattern matches the directory part of the path but not the file name itself.
    assertEquals(FILES, new FileFilter("target.*", new SystemStreamLog()).filter(FILES));
  }

  @Test
  void testInvalidPattern( ) {
    MojoExecutionException lException = assertThrows(MojoExecutionException.class,
        ( ) -> new FileFilter("([", new SystemStreamLog()));
    assertTrue(lException.getMessage().contains("openAPIValidationExcludePattern"));
  }
}
