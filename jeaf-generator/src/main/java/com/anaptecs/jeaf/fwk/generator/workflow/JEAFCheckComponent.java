package com.anaptecs.jeaf.fwk.generator.workflow;

import java.nio.charset.StandardCharsets;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;

/**
 * Check component used by the JEAF Generator workflows. Check results are passed on as {@link CheckMessageDiagnostic},
 * so that they are logged in the same format as with openArchitectureWare. If profiling is enabled, functions are
 * measured by {@link GenerationProfiler}. Check and extension files are read as UTF-8 like by the generator component.
 */
public class JEAFCheckComponent extends CheckComponent {
  public JEAFCheckComponent( ) {
    // Without an explicit encoding Xpand guesses it from the first bytes of each file.
    ResourceManagerDefaultImpl lResourceManager = new ResourceManagerDefaultImpl();
    lResourceManager.setFileEncoding(StandardCharsets.UTF_8.name());
    this.setResourceManager(lResourceManager);

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
