package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;

import com.anaptecs.jeaf.fwk.generator.util.LineEnding;

/**
 * Xpand generator used by the JEAF Generator workflows. If profiling is enabled, templates and functions are measured
 * by {@link GenerationProfiler}. All generated files get the configured line ending ({@link LineEndingPostProcessor}).
 */
public class JEAFGenerator extends Generator {
  private final LineEndingPostProcessor lineEndingPostProcessor =
      new LineEndingPostProcessor(LineEnding.current());

  public JEAFGenerator( ) {
    GenerationProfiler lProfiler = GenerationProfiler.getProfilerIfEnabled();
    if (lProfiler != null) {
      this.setVetoableCallback(lProfiler);
    }
  }

  /**
   * Called for every outlet of the workflow.
   */
  @Override
  public void addOutlet( Outlet pOutlet ) {
    super.addOutlet(pOutlet);
    pOutlet.addPostprocessor(lineEndingPostProcessor);
  }
}
