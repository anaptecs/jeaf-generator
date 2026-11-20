package com.anaptecs.jeaf.fwk.generator.workflow;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.check.CheckComponent;

/**
 * Check component used by the JEAF Generator workflows. Check results are passed on as {@link CheckMessageDiagnostic},
 * so that they are logged in the same format as with openArchitectureWare. If profiling is enabled, functions are
 * measured by {@link GenerationProfiler}.
 */
public class CachingCheckComponent extends CheckComponent {
  public CachingCheckComponent( ) {
    GenerationProfiler lProfiler = GenerationProfiler.getProfilerIfEnabled();
    if (lProfiler != null) {
      this.setVetoableCallback(lProfiler);
    }
  }

  @Override
  protected void invokeInternal2( WorkflowContext pContext, ProgressMonitor pMonitor, Issues pIssues ) {
    Issues lCheckResults = new IssuesImpl();
    try {
      super.invokeInternal2(pContext, pMonitor, lCheckResults);
    }
    finally {
      for (MWEDiagnostic lNext : lCheckResults.getIssues()) {
        pIssues.add(new CheckMessageDiagnostic(lNext));
      }
    }
  }
}
