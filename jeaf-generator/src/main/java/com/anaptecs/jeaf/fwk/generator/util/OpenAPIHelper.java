package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.anaptecs.jeaf.xfun.api.XFun;

public class OpenAPIHelper {
  public static final Map<String, String> basicTypes = new HashMap<String, String>();

  public static final Map<String, String> formatMapping = new HashMap<String, String>();

  public static final Set<String> localTypes = new HashSet<String>();

  static {
    basicTypes.put("boolean", "boolean");
    basicTypes.put("Boolean", "boolean");
    basicTypes.put(Boolean.class.getName(), "boolean");
    basicTypes.put("int", "integer");
    basicTypes.put(Integer.class.getName(), "integer");
    basicTypes.put("long", "integer");
    basicTypes.put(Long.class.getName(), "integer");
    basicTypes.put("float", "number");
    basicTypes.put(Float.class.getName(), "number");
    basicTypes.put("double", "number");
    basicTypes.put(Double.class.getName(), "number");
    basicTypes.put(BigDecimal.class.getName(), "number");
    basicTypes.put(String.class.getName(), "string");

    // We also also treat many JDK standard types as simple types in Open API as they can be mapped to a single type
    // mostly string.
    basicTypes.put(Currency.class.getName(), "string");
    basicTypes.put(URL.class.getName(), "string");
    basicTypes.put(UUID.class.getName(), "string");
    basicTypes.put(Locale.class.getName(), "string");
    basicTypes.put(java.sql.Date.class.getName(), "string");
    basicTypes.put(java.util.Date.class.getName(), "string");
    basicTypes.put(Calendar.class.getName(), "string");
    basicTypes.put("java.time.LocalTime", "string");
    basicTypes.put("java.time.LocalDate", "string");
    basicTypes.put("java.time.LocalDateTime", "string");

    formatMapping.put("int", "int32");
    formatMapping.put(Integer.class.getName(), "int32");
    formatMapping.put("long", "int64");
    formatMapping.put(Long.class.getName(), "int64");
    formatMapping.put("float", "float");
    formatMapping.put(Float.class.getName(), "float");
    formatMapping.put("double", "double");
    formatMapping.put(Double.class.getName(), "double");
    formatMapping.put(BigDecimal.class.getName(), "double");

    formatMapping.put(java.sql.Date.class.getName(), "date-time");
    formatMapping.put(java.util.Date.class.getName(), "date-time");
    formatMapping.put(Calendar.class.getName(), "date-time");
    formatMapping.put("java.time.LocalTime", "time");
    formatMapping.put("java.time.LocalDate", "date");
    formatMapping.put("java.time.LocalDateTime", "date-time");
  }

  public static String getOpenAPIType( org.eclipse.uml2.uml.Type pClass ) {
    String lFQN = Naming.getFullyQualifiedName(pClass);

    String lTypeName;
    if (basicTypes.containsKey(lFQN) == true) {
      lTypeName = basicTypes.get(lFQN);
    }
    else if (localTypes.contains(lFQN) == true) {
      lTypeName = "'#/components/schemas/" + pClass.getName() + "'";
    }
    else {
      lTypeName = "unknown type: " + lFQN;
    }

    return lTypeName;
  }

  public static String getOpenAPIFormat( org.eclipse.uml2.uml.Type pClass ) {
    return formatMapping.get(Naming.getFullyQualifiedName(pClass));
  }

  public static boolean registerLocalType( org.eclipse.uml2.uml.NamedElement pClass ) {
    String lFQN = Naming.getFullyQualifiedName(pClass);
    XFun.getTrace().info("Registed local Open API Type: " + lFQN);
    return localTypes.add(lFQN);
  }

  public static boolean isBasicOpenAPIType( org.eclipse.uml2.uml.Type pType ) {
    return basicTypes.containsKey(Naming.getFullyQualifiedName(pType));
  }
}
