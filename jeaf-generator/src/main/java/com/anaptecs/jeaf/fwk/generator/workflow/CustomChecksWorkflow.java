package com.anaptecs.jeaf.fwk.generator.workflow;

import org.openarchitectureware.check.CheckComponent;
import org.openarchitectureware.type.MetaModel;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class CustomChecksWorkflow extends AbstractWorkflowComponent2 {
  CheckComponent checkComponent = new CheckComponent();

  @Override
  protected void checkConfigurationInternal( Issues pIssues ) {
  }

  @Override
  protected void invokeInternal( WorkflowContext pContext, ProgressMonitor pProgressMonitor, Issues pIssues ) {
    checkComponent.addCheckFile("jeaf::CustomChecks");
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
