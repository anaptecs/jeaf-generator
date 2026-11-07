/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.plugin.logging.Log;
import org.openarchitectureware.util.ProfileCollector;
import org.openarchitectureware.util.ProfileCollector.ProfileEntry;

/**
 * Profile of model checks and code generation, based on oAW's {@link ProfileCollector}.
 *
 * oAW records every call of a template (EXPAND) and of an Xtend function in a thread local {@link ProfileCollector}.
 * The collected values are never reset, so they cumulate over all generator runs of a Maven build (e.g. all modules of
 * a multi-module build). That's why this class takes a snapshot when a generator run starts and reports only the
 * difference.
 */
class GenerationProfile {
  /**
   * Number of entries that are written to the log.
   */
  private static final int LOGGED_ENTRIES = 30;

  /**
   * Values per template or function at the start of the generator run.
   */
  private final Map<String, Entry> start;

  private GenerationProfile( Map<String, Entry> pStart ) {
    start = pStart;
  }

  /**
   * Method starts profiling of a generator run.
   *
   * @return {@link GenerationProfile} Profile that has to be reported after the generator run.
   */
  static GenerationProfile start( ) {
    return new GenerationProfile(capture());
  }

  /**
   * Method writes the profile of the generator run to the log (entries with the highest net time) and the complete
   * profile to the passed CSV file.
   *
   * @param pLog Log to which the summary is written.
   * @param pFile CSV file to which the complete profile is written.
   */
  void report( Log pLog, File pFile ) {
    List<Entry> lEntries = new ArrayList<>();
    long lTotalNet = 0;
    for (Entry lEnd : capture().values()) {
      Entry lStart = start.get(lEnd.name);
      Entry lDelta = lStart != null ? lEnd.minus(lStart) : lEnd;
      if (lDelta.calls > 0) {
        lEntries.add(lDelta);
        lTotalNet += lDelta.net;
      }
    }
    lEntries.sort(Comparator.comparingLong((Entry e) -> e.net).reversed().thenComparing(e -> e.name));

    pLog.info("--------------------------------------------------------------------------------------");
    pLog.info("Profile of model checks and code generation (" + lEntries.size() + " templates and functions, net time "
        + lTotalNet + "ms)");
    pLog.info("Net time is the time without nested calls. Gross time contains nested calls; for recursive templates the");
    pLog.info("time of nested calls is counted several times.");
    pLog.info(String.format("%8s %9s %9s  %s", "Net(ms)", "Gross(ms)", "Calls", "Template / function"));
    for (Entry lEntry : lEntries.subList(0, Math.min(LOGGED_ENTRIES, lEntries.size()))) {
      pLog.info(String.format("%8d %9d %9d  %s", lEntry.net, lEntry.gross, lEntry.calls, lEntry.name));
    }

    StringBuilder lCSV = new StringBuilder("Net (ms);Gross (ms);Calls;Template / function\n");
    for (Entry lEntry : lEntries) {
      lCSV.append(lEntry.net).append(';').append(lEntry.gross).append(';').append(lEntry.calls).append(";\"")
          .append(lEntry.name.replace("\"", "\"\"")).append("\"\n");
    }
    try {
      Files.createDirectories(pFile.toPath().getParent());
      Files.write(pFile.toPath(), lCSV.toString().getBytes(StandardCharsets.UTF_8));
      pLog.info("Complete profile: " + pFile.getAbsolutePath());
    }
    catch (IOException e) {
      pLog.warn("Unable to write profile to " + pFile.getAbsolutePath() + ": " + e.getMessage());
    }
    pLog.info("--------------------------------------------------------------------------------------");
  }

  private static Map<String, Entry> capture( ) {
    Map<String, Entry> lEntries = new HashMap<>();
    for (ProfileEntry lEntry : ProfileCollector.getInstance().getProfile()) {
      lEntries.put(lEntry.getContextName(), new Entry(lEntry.getContextName(), lEntry.getNumCalls(),
          lEntry.getTotalTimeGross(), lEntry.getTotalTimeNet()));
    }
    return lEntries;
  }

  /**
   * Values of a template or function.
   */
  private static final class Entry {
    private final String name;

    private final long calls;

    private final long gross;

    private final long net;

    Entry( String pName, long pCalls, long pGross, long pNet ) {
      name = pName;
      calls = pCalls;
      gross = pGross;
      net = pNet;
    }

    Entry minus( Entry pOther ) {
      return new Entry(name, calls - pOther.calls, gross - pOther.gross, net - pOther.net);
    }
  }
}
