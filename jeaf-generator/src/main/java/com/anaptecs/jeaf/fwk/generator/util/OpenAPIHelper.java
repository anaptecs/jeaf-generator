package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;

public class OpenAPIHelper {
  public static final Map<String, String> basicTypes = new HashMap<String, String>();

  public static final Map<String, String> formatMapping = new HashMap<String, String>();

  public static final Map<String, String> contentTypeMapping = new HashMap<String, String>();

  public static final Map<String, OpenAPIType> complexTypes = new HashMap<String, OpenAPIType>();

  public static final Map<String, OpenAPIType> parameterTypes = new HashMap<String, OpenAPIType>();

  public static final Map<String, String> httpStatusCodeMapping = new HashMap<String, String>();

  public static final Map<String, String> specDependencies = new HashMap<String, String>();

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

    // We also also treat many JDK standard types as simple types in OpenAPI as they can be mapped to a single type
    // mostly string.
    basicTypes.put(URL.class.getName(), "string");
    basicTypes.put(UUID.class.getName(), "string");
    basicTypes.put(Locale.class.getName(), "string");
    basicTypes.put(java.sql.Date.class.getName(), "string");
    basicTypes.put(java.util.Date.class.getName(), "string");
    basicTypes.put(Calendar.class.getName(), "string");
    basicTypes.put("java.time.LocalTime", "string");
    basicTypes.put("java.time.LocalDate", "string");
    basicTypes.put("java.time.LocalDateTime", "string");
    basicTypes.put("java.time.OffsetDateTime", "string");
    basicTypes.put("java.time.Duration", "string");
    basicTypes.put(URI.class.getName(), "string");

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
    formatMapping.put("java.time.OffsetDateTime", "date-time");
    formatMapping.put("java.time.Duration", "duration");
    formatMapping.put(URI.class.getName(), "uri");

    // Content type mapping
    contentTypeMapping.put("APPLICATION_XML", "application/xml");
    contentTypeMapping.put("APPLICATION_JSON", "application/json");
    contentTypeMapping.put("APPLICATION_OCTET_STREAM", "application/octet-stream");
    contentTypeMapping.put("APPLICATION_PROBLEM_JSON", "application/problem+json");
    contentTypeMapping.put("TEXT_PLAIN", "text/plain");

    // HTTP Status Code Mapping

    httpStatusCodeMapping.put("100_CONTINUE", null);
    httpStatusCodeMapping.put("101_SWITCHING_PROTOCOLS", null);
    httpStatusCodeMapping.put("102_PROCESSING", null);
    httpStatusCodeMapping.put("103_EARLY_HINTS", null);

    httpStatusCodeMapping.put("200_OK", "OK");
    httpStatusCodeMapping.put("201_CREATED", "CREATED");
    httpStatusCodeMapping.put("202_ACCEPTED", "ACCEPTED");
    httpStatusCodeMapping.put("203_NON_AUTHORITATIVE_INFORMATION", null);
    httpStatusCodeMapping.put("204_NO_CONTENT", "NO_CONTENT");
    httpStatusCodeMapping.put("205_RESET_CONTENT", "RESET_CONTENT");
    httpStatusCodeMapping.put("206_PARTIAL_CONTENT", "PARTIAL_CONTENT");
    httpStatusCodeMapping.put("208_ALREADY_REPORTED", null);
    httpStatusCodeMapping.put("226_IM_USED", null);

    httpStatusCodeMapping.put("300_MULTIPLE_CHOICES", null);
    httpStatusCodeMapping.put("301_MOVED_PERMANENTLY", "MOVED_PERMANENTLY");
    httpStatusCodeMapping.put("302_FOUND", "FOUND");
    httpStatusCodeMapping.put("303_SEE_OTHER", "SEE_OTHER");
    httpStatusCodeMapping.put("304_NOT_MODIFIED", "NOT_MODIFIED");
    httpStatusCodeMapping.put("305_USE_PROXY", "USE_PROXY");
    httpStatusCodeMapping.put("306_RESERVED", null);
    httpStatusCodeMapping.put("307_TEMPORARY_REDIRECT", "TEMPORARY_REDIRECT");
    httpStatusCodeMapping.put("308_PERMANENT_REDIRECT", null);

    httpStatusCodeMapping.put("400_BAD_REQUEST", "BAD_REQUEST");
    httpStatusCodeMapping.put("401_UNAUTHORIZED", "UNAUTHORIZED");
    httpStatusCodeMapping.put("402_PAYMENT_REQUIRED", "PAYMENT_REQUIRED");
    httpStatusCodeMapping.put("403_FORBIDDEN", "FORBIDDEN");
    httpStatusCodeMapping.put("404_NOT_FOUND", "NOT_FOUND");
    httpStatusCodeMapping.put("405_METHOD_NOT_ALLOWED", "METHOD_NOT_ALLOWED");
    httpStatusCodeMapping.put("406_NOT_ACCEPTABLE", "NOT_ACCEPTABLE");
    httpStatusCodeMapping.put("407_PROXY_AUTHENTICATION_REQUIRED", "PROXY_AUTHENTICATION_REQUIRED");
    httpStatusCodeMapping.put("408_REQUEST_TIMEOUT", "REQUEST_TIMEOUT");
    httpStatusCodeMapping.put("409_CONFLICT", "CONFLICT");
    httpStatusCodeMapping.put("410_GONE", "GONE");
    httpStatusCodeMapping.put("411_LENGTH_REQUIRED", "LENGTH_REQUIRED");
    httpStatusCodeMapping.put("412_PRECONDITION_FAILED", "PRECONDITION_FAILED");
    httpStatusCodeMapping.put("413_PAYLOAD_TOO_LARGE", "REQUEST_ENTITY_TOO_LARGE");
    httpStatusCodeMapping.put("414_URI_TOO_LONG", "REQUEST_URI_TOO_LONG");
    httpStatusCodeMapping.put("415_UNSUPPORTED_MEDIA_TYPE", "UNSUPPORTED_MEDIA_TYPE");
    httpStatusCodeMapping.put("416_RANGE_NOT_SATISFIABLE", "REQUESTED_RANGE_NOT_SATISFIABLE");
    httpStatusCodeMapping.put("417_EXPECTATION_FAILED", "EXPECTATION_FAILED");
    httpStatusCodeMapping.put("418_TEAPOT", null);
    httpStatusCodeMapping.put("421_MISDIRECTED_REQUEST", null);
    httpStatusCodeMapping.put("422_UNPROCESSABLE_ENTITY", null);
    httpStatusCodeMapping.put("423_LOCKED", null);
    httpStatusCodeMapping.put("424_FAILED_DEPENDENCY", null);
    httpStatusCodeMapping.put("425_TOO_EARLY", null);
    httpStatusCodeMapping.put("426_UPGRADE_REQUIRED", null);
    httpStatusCodeMapping.put("428_PRECONDITION_REQUIRED", "PRECONDITION_REQUIRED");
    httpStatusCodeMapping.put("429_TOO_MANY_REQUESTS", "TOO_MANY_REQUESTS");
    httpStatusCodeMapping.put("431_REQUEST_HEADER_FIELDS_TOO_LARGE", "REQUEST_HEADER_FIELDS_TOO_LARGE");
    httpStatusCodeMapping.put("451_UNAVAILABLE_FOR_LEGAL_REASONS", null);

    httpStatusCodeMapping.put("500_INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
    httpStatusCodeMapping.put("501_NOT_IMPLEMENTED", "NOT_IMPLEMENTED");
    httpStatusCodeMapping.put("502_BAD_GATEWAY", "BAD_GATEWAY");
    httpStatusCodeMapping.put("503_SERVICE_UNAVAILABLE", "SERVICE_UNAVAILABLE");
    httpStatusCodeMapping.put("504_GATEWAY_TIMEOUT", "GATEWAY_TIMEOUT");
    httpStatusCodeMapping.put("505_HTTP_VERSION_NOT_SUPPORTED", "HTTP_VERSION_NOT_SUPPORTED");
    httpStatusCodeMapping.put("506_VARIANT_ALSO_NEGOTIATES", null);
    httpStatusCodeMapping.put("507_INSUFFICIENT_STORAGE", null);
    httpStatusCodeMapping.put("508_LOOP_DETECTED", null);
    httpStatusCodeMapping.put("510_NOT_EXTENDED", null);
    httpStatusCodeMapping.put("511_NETWORK_AUTHENTICATION_REQUIRED", "NETWORK_AUTHENTICATION_REQUIRED");
  }

  public static String getOpenAPIType( org.eclipse.uml2.uml.Type pClass, Component pSpec ) {
    String lFQN = Naming.getFullyQualifiedName(pClass);
    String lTypeName;
    if (basicTypes.containsKey(lFQN) == true) {
      lTypeName = basicTypes.get(lFQN);
    }
    else if (complexTypes.containsKey(lFQN) == true) {
      OpenAPIType lOpenAPIType = complexTypes.get(lFQN);
      // Local reference needed.
      if (lOpenAPIType.spec == pSpec) {
        lTypeName = "'#/components/schemas/" + pClass.getName() + "'";
      }
      else {
        String lKey = createSpecDependencyKey(pSpec, lOpenAPIType.spec);
        String lLocation = specDependencies.get(lKey);
        if (lLocation != null) {
          lTypeName = "'" + lLocation + "#/components/schemas/" + pClass.getName() + "'";
        }
        else {
          XFun.getTrace().error("Dependency " + lKey + " not found.");
          lTypeName = "unknown type: " + lFQN;
        }
      }
    }
    else {
      lTypeName = "unknown type: " + lFQN;
    }
    return lTypeName;
  }

  public static String getResponseType( org.eclipse.uml2.uml.Type pClass, Component pSpec ) {
    String lFQN = Naming.getFullyQualifiedName(pClass);
    String lTypeName;
    if (basicTypes.containsKey(lFQN) == true) {
      lTypeName = basicTypes.get(lFQN);
    }
    else if (complexTypes.containsKey(lFQN) == true) {
      OpenAPIType lOpenAPIType = complexTypes.get(lFQN);
      // Local reference needed.
      if (lOpenAPIType.spec == pSpec) {
        lTypeName = "'#/components/responses/" + pClass.getName() + "'";
      }
      else {
        String lKey = createSpecDependencyKey(pSpec, lOpenAPIType.spec);
        String lLocation = specDependencies.get(lKey);
        if (lLocation != null) {
          lTypeName = "'" + lLocation + "#/components/responses/" + pClass.getName() + "'";
        }
        else {
          XFun.getTrace().error("Dependency " + lKey + " not found.");
          lTypeName = "unknown type: " + lFQN;
        }
      }
    }
    else {
      lTypeName = "unknown type: " + lFQN;
    }
    return lTypeName;
  }

  public static String getOpenAPIFormat( org.eclipse.uml2.uml.Type pClass ) {
    return formatMapping.get(Naming.getFullyQualifiedName(pClass));
  }

  public static void registerSpecDependency( Component pSource, Component pTarget, String pReference ) {
    String lKey = createSpecDependencyKey(pSource, pTarget);
    specDependencies.put(lKey, pReference);

    // Also create spec dependency in opposite direction
    // String lOppositeKey = createSpecDependencyKey(pTarget, pSource);
    // specDependencies.put(lOppositeKey, pReference);
  }

  private static String createSpecDependencyKey( Component pSource, Component pTarget ) {
    return Naming.getFullyQualifiedName(pSource) + "::" + Naming.getFullyQualifiedName(pTarget);
  }

  public static void registerLocalType( org.eclipse.uml2.uml.NamedElement pClass, Component pSpec ) {
    String lFQN = Naming.getFullyQualifiedName(pClass);
    XFun.getTrace().debug("Registering local type " + lFQN + " with " + pSpec.getName() + ":" + pClass.getName());
    complexTypes.put(lFQN, new OpenAPIType(pClass, pSpec, lFQN));
  }

  public static void registerLocalParameter( org.eclipse.uml2.uml.Property pProperty, Component pSpec ) {
    String lFQN = Naming.getFullyQualifiedName(pProperty.getClass_()) + "." + pProperty.getName();
    XFun.getTrace().debug(
        "Registering local parameter " + lFQN + " with " + pSpec.getName() + ":" + pProperty.getName());
    parameterTypes.put(lFQN, new OpenAPIType(pProperty, pSpec, lFQN));
  }

  public static String getOpenAPIParameter( org.eclipse.uml2.uml.Property pProperty, Component pSpec ) {
    String lFQN = Naming.getFullyQualifiedName(pProperty.getClass_()) + "." + pProperty.getName();
    String lTypeName;
    if (parameterTypes.containsKey(lFQN) == true) {
      OpenAPIType lOpenAPIType = parameterTypes.get(lFQN);
      // Local reference needed.
      if (lOpenAPIType.spec == pSpec) {
        lTypeName = "'#/components/parameters/" + pProperty.getName() + "'";
      }
      else {
        String lKey = createSpecDependencyKey(pSpec, lOpenAPIType.spec);
        String lLocation = specDependencies.get(lKey);
        if (lLocation != null) {
          lTypeName = "'" + lLocation + "#/components/parameters/" + pProperty.getName() + "'";
        }
        else {
          XFun.getTrace().error("Dependency " + lKey + " not found.");
          lTypeName = "unknown parameter: " + lFQN;
        }
      }
    }
    else {
      lTypeName = "unknown parameter: " + lFQN;
    }
    return lTypeName;
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

  public static List<Element> getAllAttributesFromHierarchy( Element pElement ) {
    Class lClass = (Class) pElement;
    List<Element> lElements = new ArrayList<Element>();

    if (lClass.parents().size() > 0) {
      List<Element> lParentAttributes = getAllAttributesFromHierarchy(lClass.parents().get(0));
      lElements.addAll(lParentAttributes);
    }

    EList<Property> lOwnedAttributes = lClass.getOwnedAttributes();
    for (int i = 0; i < lOwnedAttributes.size(); i++) {
      lElements.add(lOwnedAttributes.get(i));
    }

    return lElements;
  }

  public static String getJAXRSStatusCodeName( String pJMMStatusCode ) {
    String lStatusCode = httpStatusCodeMapping.get(pJMMStatusCode);
    if (lStatusCode == null) {
      XFun.getTrace().debug("No mapping foudn for status code: " + pJMMStatusCode);
    }
    return lStatusCode;
  }

  public static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

  public static List<String> splitRESTPath( String pRESTPath, List<String> pPathParams, List<String> pVariableNames ) {
    Assert.assertTrue(pPathParams.size() == pVariableNames.size(),
        "Internal error amount of path params and variables names must be the same");

    List<String> lSplitResult = Arrays.asList(splitRESTPath(pRESTPath, pPathParams.toArray(new String[] {})));
    List<String> lParts = new ArrayList<String>(lSplitResult.size());
    if (pPathParams.isEmpty() == false) {
      for (String lNextPart : lSplitResult) {
        String lPart = lNextPart;
        for (int i = 0; i < pPathParams.size(); i++) {
          lPart = lPart.replaceAll("\\{" + pPathParams.get(i) + "\\}", pVariableNames.get(i));
        }
        // We also have distinguish between variables and path content
        if (lNextPart.equals(lPart)) {
          lParts.add("\"" + lPart + "\"");
        }
        else {
          lParts.add(lPart);
        }
      }
    }
    else {
      lParts.add("\"" + lSplitResult.get(0) + "\"");
    }
    return lParts;
  }

  public static String[] splitRESTPath( String pRESTPath, String... pPathParams ) {
    String[] lSplitResult;
    if (pPathParams != null && pPathParams.length > 0) {
      // Builder regular expression to split path into several parts
      StringBuilder lBuilder = new StringBuilder();
      for (int i = 0; i < pPathParams.length; i++) {
        lBuilder.append("\\{");
        lBuilder.append(pPathParams[i]);
        lBuilder.append("\\}");
        if (i < pPathParams.length - 1) {
          lBuilder.append('|');
        }
      }
      String lPattern = String.format(WITH_DELIMITER, lBuilder.toString());
      lSplitResult = pRESTPath.split(lPattern);
    }
    else {
      lSplitResult = new String[] { pRESTPath };
    }
    return lSplitResult;
  }
}
