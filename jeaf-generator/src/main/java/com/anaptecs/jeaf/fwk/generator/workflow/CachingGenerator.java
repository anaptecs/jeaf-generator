package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xpand2.Generator;

/**
 * Xpand generator used by the JEAF Generator workflows.
 * <p>
 * Xpand 2.2 caches the resolution of extensions itself, so no own execution context is needed (PoC of the migration
 * from oAW 4.3.1 to Xpand 2.2). Profiling of oAW (properties <code>collectProfileSummary</code> and
 * <code>verboseProfileFilename</code>) is not available with Xpand; the setters are kept so that existing workflows
 * remain valid.
 */
public class CachingGenerator extends Generator {
  public void setCollectProfileSummary( String pCollectProfileSummary ) {
    // Not supported by Xpand 2.2.
  }

  public void setVerboseProfileFilename( String pVerboseProfileFilename ) {
    // Not supported by Xpand 2.2.
  }
}
