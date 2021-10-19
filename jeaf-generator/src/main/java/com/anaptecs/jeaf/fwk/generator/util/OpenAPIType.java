package com.anaptecs.jeaf.fwk.generator.util;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;

public class OpenAPIType {
  public final NamedElement type;

  public final Component spec;

  public final String fqn;

  public OpenAPIType( NamedElement pType, Component pSpec, String pFQN ) {
    super();
    type = pType;
    spec = pSpec;
    fqn = pFQN;
  }
}
