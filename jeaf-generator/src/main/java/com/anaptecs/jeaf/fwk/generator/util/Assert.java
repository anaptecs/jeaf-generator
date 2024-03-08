package com.anaptecs.jeaf.fwk.generator.util;

public class Assert {
  public static void assertNotNull( Object pObject, String pName ) {
    if (pObject == null) {
      throw new IllegalArgumentException("Object " + pName + " must not be null.");
    }
  }

  public static void internalError( String pMessage ) {
    throw new RuntimeException("Internal Error: " + pMessage);
  }
}
