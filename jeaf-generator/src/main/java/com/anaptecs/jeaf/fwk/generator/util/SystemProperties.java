package com.anaptecs.jeaf.fwk.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SystemProperties {
  static String LIST_SEPERATOR = ";";

  public static String getProperty( String pName ) {
    return System.getProperty(pName);
  }

  public static String getProperty( String pName, String pDefaultValue ) {
    return System.getProperty(pName, pDefaultValue);
  }

  public static boolean getBooleanProperty( String pName, boolean pDefault ) {
    String lProperty = getProperty(pName);
    boolean lValue;
    if (lProperty != null) {
      lValue = Boolean.valueOf(lProperty);
    }
    else {
      lValue = pDefault;
    }
    return lValue;
  }

  public static List<String> getPropertiesList( String pName ) {
    String lValue = getProperty(pName);

    List<String> lValueList;
    if (lValue != null) {
      StringTokenizer lTokenizer = new StringTokenizer(lValue, LIST_SEPERATOR);
      lValueList = new ArrayList<String>(lTokenizer.countTokens());

      // Add all parts to the created collection.
      while (lTokenizer.hasMoreTokens()) {
        lValueList.add(lTokenizer.nextToken().trim());
      }
    }
    // Configuration entry is not set.
    else {
      lValueList = Collections.emptyList();
    }
    return lValueList;

  }
}
