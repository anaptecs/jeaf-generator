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
import java.util.ArrayList;
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

  @Test
  void testExcludedFilesAreLogged( ) throws MojoFailureException {
    RecordingLog lLog = new RecordingLog();
    new ExcludeFileFilter(".*-nam\\.ya?ml", lLog).filter(FILES);
    assertEquals(2, lLog.infos.size());
    assertTrue(lLog.infos.get(0).endsWith("product-api-nam.yaml"));
    assertTrue(lLog.infos.get(1).endsWith("base-nam.yml"));
    assertTrue(lLog.warnings.isEmpty());
  }

  @Test
  void testWarningIfAllFilesAreExcluded( ) throws MojoFailureException {
    RecordingLog lLog = new RecordingLog();
    assertTrue(new ExcludeFileFilter(".*\\.ya?ml", lLog).filter(FILES).isEmpty());
    assertEquals(3, lLog.infos.size());
    assertEquals(1, lLog.warnings.size());
    assertTrue(lLog.warnings.get(0).contains("openAPIValidationExcludePattern"));
  }

  @Test
  void testNoWarningWithoutFiles( ) throws MojoFailureException {
    RecordingLog lLog = new RecordingLog();
    assertTrue(new ExcludeFileFilter(".*", lLog).filter(List.of()).isEmpty());
    assertTrue(lLog.infos.isEmpty());
    assertTrue(lLog.warnings.isEmpty());
  }

  /**
   * Log that records info and warning messages.
   */
  private static class RecordingLog extends SystemStreamLog {
    final List<String> infos = new ArrayList<>();

    final List<String> warnings = new ArrayList<>();

    @Override
    public void info(CharSequence pContent) {
      infos.add(pContent.toString());
    }

    @Override
    public void warn(CharSequence pContent) {
      warnings.add(pContent.toString());
    }
  }
}
