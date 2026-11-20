package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.List;

import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

public class CustomChecksWorkflow extends AbstractWorkflowComponent2 {
  CheckComponent checkComponent = new JEAFCheckComponent();

  @Override
  protected void checkConfigurationInternal( Issues pIssues ) {
  }

  @Override
  protected void invokeInternal( WorkflowContext pContext, ProgressMonitor pProgressMonitor, Issues pIssues ) {
    // Load custom check files.
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    List<String> lCheckFiles = lConfiguration.getConfigurationValueList("list.custom.checkfiles", false, String.class);

    for (String lNext : lCheckFiles) {
      checkComponent.addCheckFile(lNext);
    }
    checkComponent.invoke(pContext, pProgressMonitor, pIssues);
  }

  public void addMetaModel( MetaModel pMetaModel ) {
    checkComponent.addMetaModel(pMetaModel);
  }

  public void addCheckFile( String pFile ) {
    checkComponent.addCheckFile(pFile);
  }

  public void setExpression( String pExpression ) {
    checkComponent.setExpression(pExpression);
  }
}
