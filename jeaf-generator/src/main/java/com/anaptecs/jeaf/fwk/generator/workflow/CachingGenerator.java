package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xpand2.Generator;

/**
 * Xpand generator used by the JEAF Generator workflows.
 * <p>
 * Xpand 2.2 caches the resolution of extensions itself, so no own execution context is needed (PoC of the migration
 * from oAW 4.3.1 to Xpand 2.2). If profiling is enabled, templates and functions are measured by
 * {@link GenerationProfiler}. The oAW properties <code>collectProfileSummary</code> and
 * <code>verboseProfileFilename</code> are not supported anymore; their setters are kept so that existing workflows
 * remain valid.
 */
public class CachingGenerator extends Generator {
  public CachingGenerator( ) {
    GenerationProfiler lProfiler = GenerationProfiler.getProfilerIfEnabled();
    if (lProfiler != null) {
      this.setVetoableCallback(lProfiler);
    }
  }

  public void setCollectProfileSummary( String pCollectProfileSummary ) {
    // Not supported by Xpand 2.2.
  }

  public void setVerboseProfileFilename( String pVerboseProfileFilename ) {
    // Not supported by Xpand 2.2.
  }
}
