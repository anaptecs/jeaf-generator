package com.anaptecs.jeaf.fwk.generator.util;

public class Check {
  public static void checkInvalidParameterNull( Object pObject, String pName ) {
    Assert.assertNotNull(pObject, pName);
  }
}
