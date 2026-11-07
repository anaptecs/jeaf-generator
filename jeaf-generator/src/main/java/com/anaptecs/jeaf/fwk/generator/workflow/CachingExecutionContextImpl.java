package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.List;
import java.util.Map;

import org.openarchitectureware.expression.Callback;
import org.openarchitectureware.expression.ExceptionHandler;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.expression.NullEvaluationHandler;
import org.openarchitectureware.expression.Resource;
import org.openarchitectureware.expression.ResourceManager;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.type.Type;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.openarchitectureware.xtend.ast.Around;
import org.openarchitectureware.xtend.ast.Extension;

/**
 * Execution context for checks and extensions that caches the resolution of called extensions (see
 * {@link ExtensionResolutionCache}). All clones (oAW clones the context e.g. for every called extension) share the same
 * cache.
 */
public class CachingExecutionContextImpl extends ExecutionContextImpl {
  private final ExtensionResolutionCache extensionCache;

  public CachingExecutionContextImpl( ResourceManager pResourceManager, Resource pResource, TypeSystemImpl pTypeSystem,
      Map<String, Variable> pVariables, Map<String, Variable> pGlobalVars, ProgressMonitor pMonitor,
      ExceptionHandler pExceptionHandler, List<Around> pAdvices, NullEvaluationHandler pNullEvaluationHandler,
      Map<Resource, java.util.Set<Extension>> pAllExtensionsPerResource, Callback pCallback,
      ExtensionResolutionCache pExtensionCache ) {
    super(pResourceManager, pResource, pTypeSystem, pVariables, pGlobalVars, pMonitor, pExceptionHandler, pAdvices,
        pNullEvaluationHandler, pAllExtensionsPerResource, pCallback);
    extensionCache = pExtensionCache;
  }

  @Override
  public Extension getExtensionForTypes( String pFunctionName, Type[] pParameterTypes ) {
    return extensionCache.getExtension(this.currentResource(), pFunctionName, pParameterTypes,
        ( ) -> super.getExtensionForTypes(pFunctionName, pParameterTypes));
  }

  /**
   * All other <code>cloneWith...()</code> operations use this operation, so they also return a caching context.
   */
  @Override
  public ExecutionContextImpl cloneContext( ) {
    return new CachingExecutionContextImpl(resourceManager, this.currentResource(), typeSystem,
        this.getVisibleVariables(), this.getGlobalVariables(), this.getMonitor(), exceptionHandler,
        registeredExtensionAdvices, nullEvaluationHandler, allExtensionsPerResource, callback, extensionCache);
  }
}
