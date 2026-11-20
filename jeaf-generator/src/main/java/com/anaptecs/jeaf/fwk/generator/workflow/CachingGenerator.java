package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xpand2.Generator;

/**
 * Xpand generator used by the JEAF Generator workflows. If profiling is enabled, templates and functions are measured
 * by {@link GenerationProfiler}.
 */
public class CachingGenerator extends Generator {
  public CachingGenerator( ) {
    GenerationProfiler lProfiler = GenerationProfiler.getProfilerIfEnabled();
    if (lProfiler != null) {
      this.setVetoableCallback(lProfiler);
    }
  }
}
