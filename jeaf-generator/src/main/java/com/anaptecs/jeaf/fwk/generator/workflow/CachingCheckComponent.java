package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.HashMap;

import org.openarchitectureware.check.CheckComponent;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.type.MetaModel;
import org.openarchitectureware.workflow.WorkflowContext;

/**
 * Check component that uses {@link CachingExecutionContextImpl}, so that the resolution of called extensions is cached
 * (see {@link ExtensionResolutionCache}). Apart from that it behaves exactly like oAW's {@link CheckComponent}.
 */
public class CachingCheckComponent extends CheckComponent {
  /**
   * Same as {@link org.openarchitectureware.expression.AbstractExpressionsUsingWorkflowComponent#getExecutionContext}
   * (oAW 4.3.1) but creates a caching context.
   */
  @Override
  protected ExecutionContextImpl getExecutionContext( WorkflowContext pContext ) {
    ExecutionContextImpl lExecutionContext = new CachingExecutionContextImpl(this.getResourceManager(), null,
        new TypeSystemImpl(), new HashMap<>(), this.getGlobalVars(pContext), null, exceptionHandler, null,
        this.getNullEvaluationHandler(), null, callback, new ExtensionResolutionCache());
    for (MetaModel lMetaModel : metaModels) {
      lExecutionContext.registerMetaModel(lMetaModel);
    }
    return lExecutionContext;
  }
}
