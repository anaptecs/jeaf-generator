package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.internal.xpand2.ast.AbstractDefinition;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.ast.AbstractExtension;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.VetoableCallback;

/**
 * Collects how often and how long templates (Xpand definitions) and functions (Xtend extensions) are executed during
 * model checks and code generation. Replaces the profiling of openArchitectureWare 4.3 (ProfileCollector).
 * <p>
 * Values cumulate over all generator runs within the same JVM (e.g. all modules of a Maven build). The net time of an
 * entry is its time without nested calls. Gross time contains nested calls; for recursive calls the time of nested calls
 * is counted several times.
 */
public final class GenerationProfiler implements VetoableCallback {
  /**
   * Name of the system property that enables profiling.
   */
  public static final String PROFILING_ENABLED = "jeaf.generator.profileGeneration";

  private static final GenerationProfiler INSTANCE = new GenerationProfiler();

  private final Map<String, long[]> entries = new ConcurrentHashMap<>();

  private final ThreadLocal<Deque<Frame>> frames = ThreadLocal.withInitial(ArrayDeque::new);

  private GenerationProfiler( ) {
  }

  /**
   * @return {@link GenerationProfiler} Profiler if profiling is enabled, otherwise <code>null</code>.
   */
  static GenerationProfiler getProfilerIfEnabled( ) {
    return Boolean.getBoolean(PROFILING_ENABLED) ? INSTANCE : null;
  }

  /**
   * @return {@link List} Snapshot of all entries collected so far. The method never returns null.
   */
  public static List<ProfileEntry> getProfile( ) {
    List<ProfileEntry> lProfile = new ArrayList<>(INSTANCE.entries.size());
    for (Map.Entry<String, long[]> lNext : INSTANCE.entries.entrySet()) {
      long[] lValues = lNext.getValue();
      synchronized (lValues) {
        lProfile.add(new ProfileEntry(lNext.getKey(), lValues[0], lValues[1] / 1_000_000, lValues[2] / 1_000_000));
      }
    }
    return lProfile;
  }

  @Override
  public boolean pre( SyntaxElement pElement, ExecutionContext pContext ) {
    if (pElement instanceof AbstractDefinition || pElement instanceof AbstractExtension) {
      frames.get().push(new Frame(pElement, System.nanoTime()));
    }
    return true;
  }

  @Override
  public void post( SyntaxElement pElement, ExecutionContext pContext, Object pResult ) {
    if (pElement instanceof AbstractDefinition || pElement instanceof AbstractExtension) {
      // Frames of calls that were left with an exception have no post call. They are dropped.
      Deque<Frame> lFrames = frames.get();
      for (Iterator<Frame> lIterator = lFrames.iterator(); lIterator.hasNext();) {
        if (lIterator.next().element == pElement) {
          Frame lFrame;
          do {
            lFrame = lFrames.pop();
          }
          while (lFrame.element != pElement);
          long lGross = System.nanoTime() - lFrame.start;
          Frame lParent = lFrames.peek();
          if (lParent != null) {
            lParent.nestedTime += lGross;
          }
          this.record(pElement.toString(), lGross, lGross - lFrame.nestedTime);
          return;
        }
      }
    }
  }

  private void record( String pName, long pGross, long pNet ) {
    long[] lValues = entries.computeIfAbsent(pName, k -> new long[3]);
    synchronized (lValues) {
      lValues[0]++;
      lValues[1] += pGross;
      lValues[2] += pNet;
    }
  }

  /**
   * Running call of a template or function.
   */
  private static final class Frame {
    private final SyntaxElement element;

    private final long start;

    private long nestedTime;

    Frame( SyntaxElement pElement, long pStart ) {
      element = pElement;
      start = pStart;
    }
  }

  /**
   * Profile of a template or function: number of calls, gross and net time in milliseconds.
   */
  public static final class ProfileEntry {
    private final String name;

    private final long calls;

    private final long grossMillis;

    private final long netMillis;

    ProfileEntry( String pName, long pCalls, long pGrossMillis, long pNetMillis ) {
      name = pName;
      calls = pCalls;
      grossMillis = pGrossMillis;
      netMillis = pNetMillis;
    }

    public String getName( ) {
      return name;
    }

    public long getCalls( ) {
      return calls;
    }

    public long getGrossMillis( ) {
      return grossMillis;
    }

    public long getNetMillis( ) {
      return netMillis;
    }
  }
}
