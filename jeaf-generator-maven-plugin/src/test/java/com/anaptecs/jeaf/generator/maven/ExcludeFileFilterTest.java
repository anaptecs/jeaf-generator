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

import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.junit.jupiter.api.Test;

public class ExcludeFileFilterTest {
  private static final String DIR = "target" + File.separator + "res-gen" + File.separator;

  private static final List<String> FILES =
      List.of(DIR + "product-api.yaml", DIR + "product-api-nam.yaml", DIR + "base" + File.separator + "base-nam.yml");

  @Test
  void testNoPatternKeepsAllFiles( ) throws MojoFailureException {
    assertEquals(FILES, new ExcludeFileFilter(null, new SystemStreamLog()).filter(FILES));
    assertEquals(FILES, new ExcludeFileFilter("", new SystemStreamLog()).filter(FILES));
  }

  @Test
  void testPatternExcludesMatchingFileNames( ) throws MojoFailureException {
    ExcludeFileFilter lFilter = new ExcludeFileFilter(".*-nam\\.ya?ml", new SystemStreamLog());
    assertEquals(List.of(DIR + "product-api.yaml"), lFilter.filter(FILES));
  }

  @Test
  void testPatternIsMatchedAgainstFileNameOnly( ) throws MojoFailureException {
    // Pattern matches the directory part of the path but not the file name itself.
    assertEquals(FILES, new ExcludeFileFilter("target.*", new SystemStreamLog()).filter(FILES));
  }

  @Test
  void testInvalidPattern( ) {
    MojoFailureException lException = assertThrows(MojoFailureException.class,
        ( ) -> new ExcludeFileFilter("([", new SystemStreamLog()));
    assertTrue(lException.getMessage().contains("openAPIValidationExcludePattern"));
  }
}
