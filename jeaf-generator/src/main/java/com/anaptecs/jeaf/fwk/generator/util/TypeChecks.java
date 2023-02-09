package com.anaptecs.jeaf.fwk.generator.util;

import org.eclipse.uml2.uml.Element;

public class TypeChecks {
  public static boolean isInstanceOf( Element pElement, String pUMLType ) {
    Class<?> lUMLType;
    try {
      lUMLType = Class.forName(pUMLType);
      return lUMLType.isAssignableFrom(pElement.getClass());
    }
    catch (ClassNotFoundException e) {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }
}
