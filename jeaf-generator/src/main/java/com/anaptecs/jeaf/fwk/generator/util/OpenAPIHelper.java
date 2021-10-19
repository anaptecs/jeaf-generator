package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.eclipse.uml2.uml.Element;

public class OpenAPIHelper {
  public static final Map<String, String> basicTypes = new HashMap<String, String>();

  public static final Map<String, String> formatMapping = new HashMap<String, String>();

  public static final Map<String, String> contentTypeMapping = new HashMap<String, String>();

  public static final Set<String> localTypes = new HashSet<String>();

  static {
    // boolean
    basicTypes.put("boolean", "boolean");
    basicTypes.put("Boolean", "boolean");
    basicTypes.put(Boolean.class.getName(), "boolean");

    // byte
    basicTypes.put("byte", "integer");
    basicTypes.put(Byte.class.getName(), "integer");

    // short
    basicTypes.put("short", "integer");
    basicTypes.put(Short.class.getName(), "integer");

    // integer
    basicTypes.put("int", "integer");
    basicTypes.put(Integer.class.getName(), "integer");
    basicTypes.put("Integer", "integer");

    // long
    basicTypes.put("long", "integer");
    basicTypes.put(Long.class.getName(), "integer");

    // BigInteger
    basicTypes.put(BigInteger.class.getName(), "integer");

    // char
    basicTypes.put("char", "string");
    basicTypes.put(Character.class.getName(), "string");

    // float
    basicTypes.put("float", "number");
    basicTypes.put(Float.class.getName(), "number");

    // double
    basicTypes.put("double", "number");
    basicTypes.put(Double.class.getName(), "number");

    // BigDecimal
    basicTypes.put(BigDecimal.class.getName(), "number");

    // String
    basicTypes.put(String.class.getName(), "string");
    basicTypes.put("String", "string");

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

    // Format mappings for byte
    formatMapping.put("byte", "int32");
    formatMapping.put(Byte.class.getName(), "int32");

    // Format mappings for short
    formatMapping.put("short", "int32");
    formatMapping.put(Short.class.getName(), "int32");

    // Format mappings for integer
    formatMapping.put("int", "int32");
    formatMapping.put(Integer.class.getName(), "int32");
    formatMapping.put("Integer", "int32");

    // Format mappings for long
    formatMapping.put("long", "int64");
    formatMapping.put(Long.class.getName(), "int64");

    // Format mappings for BigInteger
    formatMapping.put(BigInteger.class.getName(), "int64");

    // Format mappings for float
    formatMapping.put("float", "float");
    formatMapping.put(Float.class.getName(), "float");

    // Format mappings for double
    formatMapping.put("double", "double");
    formatMapping.put(Double.class.getName(), "double");

    // Format mappings for BigDecimal
    formatMapping.put(BigDecimal.class.getName(), "double");

    formatMapping.put(java.sql.Date.class.getName(), "date-time");
    formatMapping.put(java.util.Date.class.getName(), "date-time");
    formatMapping.put(Calendar.class.getName(), "date-time");
    formatMapping.put("java.time.LocalTime", "time");
    formatMapping.put("java.time.LocalDate", "date");
    formatMapping.put("java.time.LocalDateTime", "date-time");

    // Content type mapping
    contentTypeMapping.put("APPLICATION_XML", "application/xml");
    contentTypeMapping.put("APPLICATION_JSON", "application/json");
    contentTypeMapping.put("APPLICATION_OCTET_STREAM", "application/octet-stream");
    contentTypeMapping.put("TEXT_PLAIN", "text/plain");
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
    return localTypes.add(lFQN);
  }

  public static boolean isBasicOpenAPIType( org.eclipse.uml2.uml.Type pType ) {
    return basicTypes.containsKey(Naming.getFullyQualifiedName(pType));
  }

  public static String toOpenAPIContentType( String pContentTypeID ) {
    return contentTypeMapping.get(pContentTypeID);
  }

  public static String getOpenAPIParameterType( Element pType ) {
    String lOpenAPIType;
    if (ClassUtil.isStereotypeApplied(pType, "PathParam")) {
      lOpenAPIType = "path";
    }
    else if (ClassUtil.isStereotypeApplied(pType, "HeaderParam")) {
      lOpenAPIType = "header";
    }
    else if (ClassUtil.isStereotypeApplied(pType, "QueryParam")) {
      lOpenAPIType = "query";
    }
    else if (ClassUtil.isStereotypeApplied(pType, "CookieParam")) {
      lOpenAPIType = "cookie";
    }
    else {
      lOpenAPIType = null;
    }
    return lOpenAPIType;
  }
}
