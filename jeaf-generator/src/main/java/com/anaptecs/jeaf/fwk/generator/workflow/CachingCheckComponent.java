package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.HashMap;

import org.openarchitectureware.check.CheckComponent;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.type.MetaModel;
import org.openarchitectureware.workflow.WorkflowContext;

/**
 * Check component with cached extension resolution (see {@link ExtensionResolutionCache}) and type lookup (see
 * {@link CachingTypeSystemImpl}).
 */
public class CachingCheckComponent extends CheckComponent {
  /**
   * Same as in oAW 4.3.1, but creates a caching context.
   */
  @Override
  protected ExecutionContextImpl getExecutionContext( WorkflowContext pContext ) {
    ExecutionContextImpl lExecutionContext = new CachingExecutionContextImpl(this.getResourceManager(), null,
        new CachingTypeSystemImpl(), new HashMap<>(), this.getGlobalVars(pContext), null, exceptionHandler, null,
        this.getNullEvaluationHandler(), null, callback, new ExtensionResolutionCache());
    for (MetaModel lMetaModel : metaModels) {
      lExecutionContext.registerMetaModel(lMetaModel);
    }
    return lExecutionContext;
  }
}
