package com.anaptecs.jeaf.fwk.generator.workflow;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openarchitectureware.expression.Callback;
import org.openarchitectureware.expression.ExceptionHandler;
import org.openarchitectureware.expression.NullEvaluationHandler;
import org.openarchitectureware.expression.Resource;
import org.openarchitectureware.expression.ResourceManager;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.type.Type;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.model.XpandAdvice;
import org.openarchitectureware.xpand2.output.Output;
import org.openarchitectureware.xpand2.pr.ProtectedRegionResolver;
import org.openarchitectureware.xtend.ast.Around;
import org.openarchitectureware.xtend.ast.Extension;

/**
 * Execution context for Xpand templates that caches the resolution of called extensions (see
 * {@link ExtensionResolutionCache}). All clones (oAW clones the context e.g. for every called extension or template
 * definition) share the same cache.
 */
public class CachingXpandExecutionContextImpl extends XpandExecutionContextImpl {
  /**
   * Field <code>XpandExecutionContextImpl.registeredAdvices</code> is private, but has to be copied when the context is
   * cloned (as done by {@link XpandExecutionContextImpl#cloneContext()}).
   */
  private static final Field REGISTERED_ADVICES_FIELD;

  static {
    try {
      REGISTERED_ADVICES_FIELD = XpandExecutionContextImpl.class.getDeclaredField("registeredAdvices");
      REGISTERED_ADVICES_FIELD.setAccessible(true);
    }
    catch (NoSuchFieldException e) {
      throw new IllegalStateException("Unsupported oAW version. Field 'registeredAdvices' not found.", e);
    }
  }

  private final ExtensionResolutionCache extensionCache;

  public CachingXpandExecutionContextImpl( Output pOutput, ProtectedRegionResolver pProtectedRegionResolver,
      Map<String, Variable> pGlobalVars, ExceptionHandler pExceptionHandler,
      NullEvaluationHandler pNullEvaluationHandler ) {
    super(pOutput, pProtectedRegionResolver, pGlobalVars, pExceptionHandler, pNullEvaluationHandler);
    extensionCache = new ExtensionResolutionCache();
  }

  protected CachingXpandExecutionContextImpl( ResourceManager pResourceManager, Resource pResource,
      TypeSystemImpl pTypeSystem, Map<String, Variable> pVariables, Map<String, Variable> pGlobalVars, Output pOutput,
      ProtectedRegionResolver pProtectedRegionResolver, ProgressMonitor pMonitor, ExceptionHandler pExceptionHandler,
      List<Around> pAdvices, NullEvaluationHandler pNullEvaluationHandler,
      Map<Resource, Set<Extension>> pAllExtensionsPerResource, Callback pCallback,
      ExtensionResolutionCache pExtensionCache ) {
    super(pResourceManager, pResource, pTypeSystem, pVariables, pGlobalVars, pOutput, pProtectedRegionResolver,
        pMonitor, pExceptionHandler, pAdvices, pNullEvaluationHandler, pAllExtensionsPerResource, pCallback);
    extensionCache = pExtensionCache;
  }

  @Override
  public Extension getExtensionForTypes( String pFunctionName, Type[] pParameterTypes ) {
    return extensionCache.getExtension(this.currentResource(), pFunctionName, pParameterTypes,
        ( ) -> super.getExtensionForTypes(pFunctionName, pParameterTypes));
  }

  /**
   * Same as {@link XpandExecutionContextImpl#cloneContext()} but creates a caching context. All other
   * <code>cloneWith...()</code> operations use this operation, so they also return a caching context.
   */
  @Override
  public XpandExecutionContextImpl cloneContext( ) {
    CachingXpandExecutionContextImpl lClone = new CachingXpandExecutionContextImpl(resourceManager,
        this.currentResource(), typeSystem, this.getVisibleVariables(), this.getGlobalVariables(), output,
        protectedRegionResolver, this.getMonitor(), exceptionHandler, registeredExtensionAdvices, nullEvaluationHandler,
        allExtensionsPerResource, callback, extensionCache);
    lClone.getRegisteredAdvices().addAll(this.getRegisteredAdvices());
    return lClone;
  }

  @SuppressWarnings("unchecked")
  private List<XpandAdvice> getRegisteredAdvices( ) {
    try {
      return (List<XpandAdvice>) REGISTERED_ADVICES_FIELD.get(this);
    }
    catch (IllegalAccessException e) {
      throw new IllegalStateException("Unable to access field 'registeredAdvices'.", e);
    }
  }
}
