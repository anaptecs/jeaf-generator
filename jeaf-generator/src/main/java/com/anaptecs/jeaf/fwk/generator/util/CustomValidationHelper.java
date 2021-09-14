/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.util.HashMap;
import java.util.Map;

import com.anaptecs.jeaf.xfun.api.XFun;

/**
 * Class contains all helper method for the generation of JEAF Authorization mechanism.
 * 
 * @author JEAF Development Team
 * @version 1.0
 */
public class CustomValidationHelper {
  private static Map<String, String> customValidationToJavaClassMapping = new HashMap<String, String>();

  public static void registerCustomValidation( String pCustomValidationClassname, String pJavaImplClass ) {
    XFun.getTrace().info(
        "Registering custom validation " + pCustomValidationClassname + " for java class " + pJavaImplClass);
    customValidationToJavaClassMapping.put(pCustomValidationClassname, pJavaImplClass);
  }

  public static String getJavaAnnotatinClassForCustomValidation( String pCustomValidationClassname ) {
    return customValidationToJavaClassMapping.get(pCustomValidationClassname);
  }
}
