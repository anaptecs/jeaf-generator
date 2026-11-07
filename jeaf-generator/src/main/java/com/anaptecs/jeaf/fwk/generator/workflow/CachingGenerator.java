package com.anaptecs.jeaf.fwk.generator.workflow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.type.MetaModel;
import org.openarchitectureware.util.ProfileCollector;
import org.openarchitectureware.workflow.ConfigurationException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.openarchitectureware.xpand2.Generator;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.ast.ExpandStatement;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.Output;
import org.openarchitectureware.xpand2.pr.ProtectedRegionResolverImpl;

/**
 * Xpand generator with cached extension resolution (see {@link ExtensionResolutionCache}). oAW creates the execution
 * context inside {@link Generator#invokeInternal2}, so it's re-implemented here (oAW 4.3.1); private helpers are called
 * via reflection. With <code>verboseProfileFilename</code> oAW's implementation is used.
 */
public class CachingGenerator extends Generator {
  private static final Method GET_OUTPUT = CachingGenerator.getGeneratorMethod("getOutput");

  private static final Method GET_INITIALIZED_OUTLETS = CachingGenerator.getGeneratorMethod("getInitializedOutlets");

  private static final Method GET_STATEMENT = CachingGenerator.getGeneratorMethod("getStatement");

  private String prSrcPaths;

  private String prExcludes;

  private boolean prDefaultExcludes = true;

  private final List<String> advices = new ArrayList<>();

  private final List<String> extensionAdvices = new ArrayList<>();

  private String collectProfileSummary;

  private String verboseProfileFilename;

  private static Method getGeneratorMethod( String pName ) {
    try {
      Method lMethod = Generator.class.getDeclaredMethod(pName);
      lMethod.setAccessible(true);
      return lMethod;
    }
    catch (NoSuchMethodException e) {
      throw new IllegalStateException("Unsupported oAW version. Operation Generator." + pName + "() not found.", e);
    }
  }

  @Override
  public void setPrSrcPaths( String pPrSrcPaths ) {
    super.setPrSrcPaths(pPrSrcPaths);
    prSrcPaths = pPrSrcPaths;
  }

  @Override
  public void setPrExcludes( String pPrExcludes ) {
    super.setPrExcludes(pPrExcludes);
    prExcludes = pPrExcludes;
  }

  @Override
  public void setPrDefaultExcludes( boolean pPrDefaultExcludes ) {
    super.setPrDefaultExcludes(pPrDefaultExcludes);
    prDefaultExcludes = pPrDefaultExcludes;
  }

  @Override
  public void addAdvice( String pAdvice ) {
    super.addAdvice(pAdvice);
    if (advices.contains(pAdvice) == false) {
      advices.add(pAdvice);
    }
  }

  @Override
  public void addExtensionAdvice( String pAdvice ) {
    super.addExtensionAdvice(pAdvice);
    if (extensionAdvices.contains(pAdvice) == false) {
      extensionAdvices.add(pAdvice);
    }
  }

  @Override
  public void setCollectProfileSummary( String pCollectProfileSummary ) {
    super.setCollectProfileSummary(pCollectProfileSummary);
    collectProfileSummary = pCollectProfileSummary;
  }

  @Override
  public void setVerboseProfileFilename( String pVerboseProfileFilename ) {
    super.setVerboseProfileFilename(pVerboseProfileFilename);
    verboseProfileFilename = pVerboseProfileFilename;
  }

  @Override
  protected void invokeInternal2( WorkflowContext pContext, ProgressMonitor pMonitor, Issues pIssues ) {
    if (verboseProfileFilename != null) {
      super.invokeInternal2(pContext, pMonitor, pIssues);
      return;
    }

    Output lOutput = (Output) this.invokeGeneratorMethod(GET_OUTPUT);
    List<Outlet> lOutlets = this.getInitializedOutlets();
    for (Outlet lOutlet : lOutlets) {
      lOutput.addOutlet(lOutlet);
    }

    ProtectedRegionResolverImpl lProtectedRegionResolver = null;
    if (prSrcPaths != null) {
      lProtectedRegionResolver = new ProtectedRegionResolverImpl();
      lProtectedRegionResolver.setDefaultExcludes(prDefaultExcludes);
      lProtectedRegionResolver.setIgnoreList(prExcludes);
      lProtectedRegionResolver.setSrcPathes(prSrcPaths);
      lProtectedRegionResolver.setFileEncoding(this.getFileEncoding());
    }

    XpandExecutionContextImpl lExecutionContext = new CachingXpandExecutionContextImpl(lOutput,
        lProtectedRegionResolver, this.getGlobalVars(pContext), exceptionHandler, this.getNullEvaluationHandler());
    if (pMonitor != null) {
      lExecutionContext.setMonitor(pMonitor);
    }
    lExecutionContext.setResourceManager(this.getResourceManager());
    if (callback != null) {
      lExecutionContext.setCallBack(callback);
    }
    if (this.getFileEncoding() != null) {
      lExecutionContext.setFileEncoding(this.getFileEncoding());
    }
    for (MetaModel lMetaModel : metaModels) {
      lExecutionContext.registerMetaModel(lMetaModel);
    }

    ExpandStatement lStatement = (ExpandStatement) this.invokeGeneratorMethod(GET_STATEMENT);
    if (lStatement == null) {
      throw new ConfigurationException("property 'expand' has wrong syntax!");
    }

    for (String lSlotName : pContext.getSlotNames()) {
      lExecutionContext = (XpandExecutionContextImpl) lExecutionContext
          .cloneWithVariable(new Variable(lSlotName, pContext.get(lSlotName)));
    }
    for (String lAdvice : advices) {
      for (String lName : lAdvice.split(",")) {
        lExecutionContext.registerAdvices(lName.trim());
      }
    }
    for (String lAdvice : extensionAdvices) {
      for (String lName : lAdvice.split(",")) {
        lExecutionContext.registerExtensionAdvices(lName.trim());
      }
    }

    lStatement.evaluate(lExecutionContext);

    for (Outlet lOutlet : lOutlets) {
      String lOutletName = (lOutlet.getName() == null ? "[default]" : lOutlet.getName()) + "(" + lOutlet.getPath() + ")";
      if (lOutlet.getFilesWrittenAndClosed() > 0) {
        log.info("Written " + lOutlet.getFilesWrittenAndClosed() + " files to outlet " + lOutletName);
      }
      if (lOutlet.getFilesCreated() > lOutlet.getFilesWrittenAndClosed()) {
        log.info("Skipped writing of " + (lOutlet.getFilesCreated() - lOutlet.getFilesWrittenAndClosed())
            + " files to outlet " + lOutletName);
      }
    }

    ProfileCollector.getInstance().finish();
    if ("true".equalsIgnoreCase(collectProfileSummary)) {
      log.info("profiling info: \n" + ProfileCollector.getInstance().toString());
    }
  }

  @SuppressWarnings("unchecked")
  private List<Outlet> getInitializedOutlets( ) {
    return (List<Outlet>) this.invokeGeneratorMethod(GET_INITIALIZED_OUTLETS);
  }

  private Object invokeGeneratorMethod( Method pMethod ) {
    try {
      return pMethod.invoke(this);
    }
    catch (InvocationTargetException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      throw new IllegalStateException("Generator." + pMethod.getName() + "() failed.", e.getCause());
    }
    catch (IllegalAccessException e) {
      throw new IllegalStateException("Unable to call Generator." + pMethod.getName() + "().", e);
    }
  }
}
