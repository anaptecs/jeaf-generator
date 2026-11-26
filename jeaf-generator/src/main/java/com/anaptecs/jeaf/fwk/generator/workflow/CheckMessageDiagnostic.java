package com.anaptecs.jeaf.fwk.generator.workflow;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;

/**
 * Result of a model check that is logged in the format of openArchitectureWare 4.3 (<code>message [element]</code>)
 * instead of MWE's format (<code>[WARNING]: message (Element: ...; Reported by: ...)</code>). Tools like the JEAF
 * Modeling Assistant parse this format from the build log.
 */
class CheckMessageDiagnostic extends MWEDiagnostic {
  CheckMessageDiagnostic( MWEDiagnostic pDiagnostic ) {
    super(pDiagnostic.getSeverity(), pDiagnostic.getMessage(), pDiagnostic.getElement(), null,
        pDiagnostic.getException(), pDiagnostic.getData() != null ? new ArrayList<Object>(pDiagnostic.getData()) : null, pDiagnostic.getContext());
  }

  @Override
  public String toString( ) {
    StringBuilder lBuilder = new StringBuilder(String.valueOf(this.getMessage()));
    Object lElement = this.getElement();
    if (lElement instanceof Throwable) {
      StringWriter lStackTrace = new StringWriter();
      ((Throwable) lElement).printStackTrace(new PrintWriter(lStackTrace));
      lBuilder.append('[').append(lStackTrace).append(']');
    }
    else if (lElement != null) {
      lBuilder.append(" [").append(lElement).append(']');
    }
    return lBuilder.toString();
  }
}
