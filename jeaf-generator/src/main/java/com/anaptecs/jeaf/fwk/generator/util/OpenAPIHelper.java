package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
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
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;

public class OpenAPIHelper {
  public static final java.util.regex.Pattern PATH_PARAM_PATTERN =
      java.util.regex.Pattern.compile("\\{[a-zA-Z0-9_-]+}*");

  public static final Map<String, String> basicTypes = new HashMap<String, String>();

  public static final Map<String, String> formatMapping = new HashMap<String, String>();

  public static final Map<String, String> contentTypeMapping = new HashMap<String, String>();

  public static final Map<String, OpenAPIType> complexTypes = new HashMap<String, OpenAPIType>();

  public static final Map<String, OpenAPIType> parameterTypes = new HashMap<String, OpenAPIType>();

  public static final Map<String, String> httpStatusCodeMapping = new HashMap<String, String>();

  public static final Map<Integer, String> httpStatusCodeValues = new HashMap<Integer, String>();

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
    basicTypes.put(java.sql.Time.class.getName(), "string");
    basicTypes.put(java.sql.Timestamp.class.getName(), "string");

    basicTypes.put(java.util.Date.class.getName(), "string");
    basicTypes.put(Calendar.class.getName(), "string");
    basicTypes.put("java.time.LocalTime", "string");
    basicTypes.put("java.time.LocalDate", "string");
    basicTypes.put("java.time.LocalDateTime", "string");
    basicTypes.put("java.time.OffsetDateTime", "string");
    basicTypes.put("java.time.OffsetTime", "string");
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

    // Format mappings for java.sql dates
    formatMapping.put(java.sql.Date.class.getName(), "date");
    formatMapping.put(java.sql.Time.class.getName(), "time");
    formatMapping.put(java.sql.Timestamp.class.getName(), "date-time");

    // Format mapping for java.util date classes
    formatMapping.put(java.util.Date.class.getName(), "date-time");
    formatMapping.put(Calendar.class.getName(), "date-time");

    // Format mapping for java.time classes
    formatMapping.put("java.time.LocalTime", "time");
    formatMapping.put("java.time.OffsetTime", "time");
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

    // HTTP Status Code values
    httpStatusCodeValues.put(100, "100_CONTINUE");
    httpStatusCodeValues.put(101, "101_SWITCHING_PROTOCOLS");
    httpStatusCodeValues.put(102, "102_PROCESSING");
    httpStatusCodeValues.put(103, "103_EARLY_HINTS");

    httpStatusCodeValues.put(200, "200_OK");
    httpStatusCodeValues.put(201, "201_CREATED");
    httpStatusCodeValues.put(202, "202_ACCEPTED");
    httpStatusCodeValues.put(203, "203_NON_AUTHORITATIVE_INFORMATION");
    httpStatusCodeValues.put(204, "204_NO_CONTENT");
    httpStatusCodeValues.put(205, "205_RESET_CONTENT");
    httpStatusCodeValues.put(206, "206_PARTIAL_CONTENT");
    httpStatusCodeValues.put(208, "208_ALREADY_REPORTED");
    httpStatusCodeValues.put(226, "226_IM_USED");

    httpStatusCodeValues.put(300, "300_MULTIPLE_CHOICES");
    httpStatusCodeValues.put(301, "301_MOVED_PERMANENTLY");
    httpStatusCodeValues.put(302, "302_FOUND");
    httpStatusCodeValues.put(303, "303_SEE_OTHER");
    httpStatusCodeValues.put(304, "304_NOT_MODIFIED");
    httpStatusCodeValues.put(305, "305_USE_PROXY");
    httpStatusCodeValues.put(306, "306_RESERVED");
    httpStatusCodeValues.put(307, "307_TEMPORARY_REDIRECT");
    httpStatusCodeValues.put(308, "308_PERMANENT_REDIRECT");

    httpStatusCodeValues.put(400, "400_BAD_REQUEST");
    httpStatusCodeValues.put(401, "401_UNAUTHORIZED");
    httpStatusCodeValues.put(402, "402_PAYMENT_REQUIRED");
    httpStatusCodeValues.put(403, "403_FORBIDDEN");
    httpStatusCodeValues.put(404, "404_NOT_FOUND");
    httpStatusCodeValues.put(405, "405_METHOD_NOT_ALLOWED");
    httpStatusCodeValues.put(406, "406_NOT_ACCEPTABLE");
    httpStatusCodeValues.put(407, "407_PROXY_AUTHENTICATION_REQUIRED");
    httpStatusCodeValues.put(408, "408_REQUEST_TIMEOUT");
    httpStatusCodeValues.put(409, "409_CONFLICT");
    httpStatusCodeValues.put(410, "410_GONE");
    httpStatusCodeValues.put(411, "411_LENGTH_REQUIRED");
    httpStatusCodeValues.put(412, "412_PRECONDITION_FAILED");
    httpStatusCodeValues.put(413, "413_PAYLOAD_TOO_LARGE");
    httpStatusCodeValues.put(414, "414_URI_TOO_LONG");
    httpStatusCodeValues.put(415, "415_UNSUPPORTED_MEDIA_TYPE");
    httpStatusCodeValues.put(416, "416_RANGE_NOT_SATISFIABLE");
    httpStatusCodeValues.put(417, "417_EXPECTATION_FAILED");
    httpStatusCodeValues.put(418, "418_TEAPOT");
    httpStatusCodeValues.put(421, "421_MISDIRECTED_REQUEST");
    httpStatusCodeValues.put(422, "422_UNPROCESSABLE_ENTITY");
    httpStatusCodeValues.put(423, "423_LOCKED");
    httpStatusCodeValues.put(424, "424_FAILED_DEPENDENCY");
    httpStatusCodeValues.put(425, "425_TOO_EARLY");
    httpStatusCodeValues.put(426, "426_UPGRADE_REQUIRED");
    httpStatusCodeValues.put(428, "428_PRECONDITION_REQUIRED");
    httpStatusCodeValues.put(429, "429_TOO_MANY_REQUESTS");
    httpStatusCodeValues.put(431, "431_REQUEST_HEADER_FIELDS_TOO_LARGE");
    httpStatusCodeValues.put(451, "451_UNAVAILABLE_FOR_LEGAL_REASONS");

    httpStatusCodeValues.put(500, "500_INTERNAL_SERVER_ERROR");
    httpStatusCodeValues.put(501, "501_NOT_IMPLEMENTED");
    httpStatusCodeValues.put(502, "502_BAD_GATEWAY");
    httpStatusCodeValues.put(503, "503_SERVICE_UNAVAILABLE");
    httpStatusCodeValues.put(504, "504_GATEWAY_TIMEOUT");
    httpStatusCodeValues.put(505, "505_HTTP_VERSION_NOT_SUPPORTED");
    httpStatusCodeValues.put(506, "506_VARIANT_ALSO_NEGOTIATES");
    httpStatusCodeValues.put(507, "507_INSUFFICIENT_STORAGE");
    httpStatusCodeValues.put(508, "508_LOOP_DETECTED");
    httpStatusCodeValues.put(510, "510_NOT_EXTENDED");
    httpStatusCodeValues.put(511, "511_NETWORK_AUTHENTICATION_REQUIRED");
  }

  public static void clearCaches( ) {
    complexTypes.clear();
    parameterTypes.clear();
    specDependencies.clear();
  }

  public static String getOpenAPIType( org.eclipse.uml2.uml.Type pClass, Component pSpec ) {
    String lFQN = Naming.getUMLQualifiedName(pClass);
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
    String lFQN = Naming.getUMLQualifiedName(pClass);
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
    return formatMapping.get(Naming.getUMLQualifiedName(pClass));
  }

  public static void registerSpecDependency( Component pSource, Component pTarget, String pReference ) {
    String lKey = createSpecDependencyKey(pSource, pTarget);
    specDependencies.put(lKey, pReference);

    // Also create spec dependency in opposite direction
    // String lOppositeKey = createSpecDependencyKey(pTarget, pSource);
    // specDependencies.put(lOppositeKey, pReference);
  }

  private static String createSpecDependencyKey( Component pSource, Component pTarget ) {
    return Naming.getUMLQualifiedName(pSource) + "::" + Naming.getUMLQualifiedName(pTarget);
  }

  public static void registerLocalType( org.eclipse.uml2.uml.NamedElement pClass, Component pSpec ) {
    String lFQN = Naming.getUMLQualifiedName(pClass);
    XFun.getTrace().debug("Registering local type " + lFQN + " with " + pSpec.getName() + ":" + pClass.getName());
    complexTypes.put(lFQN, new OpenAPIType(pClass, pSpec, lFQN));
  }

  public static void registerLocalParameter( org.eclipse.uml2.uml.Property pProperty, Component pSpec ) {
    String lFQN = Naming.getUMLQualifiedName(pProperty.getClass_()) + "." + pProperty.getName();
    XFun.getTrace().debug(
        "Registering local parameter " + lFQN + " with " + pSpec.getName() + ":" + pProperty.getName());
    parameterTypes.put(lFQN, new OpenAPIType(pProperty, pSpec, lFQN));
  }

  public static String getOpenAPIParameter( org.eclipse.uml2.uml.Property pProperty, Component pSpec ) {
    String lFQN = Naming.getUMLQualifiedName(pProperty.getClass_()) + "." + pProperty.getName();
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

  public static boolean isBasicOpenAPIType( org.eclipse.uml2.uml.Element pType ) {
    boolean lBasicType;
    if (pType instanceof NamedElement) {
      lBasicType = basicTypes.containsKey(Naming.getUMLQualifiedName((NamedElement) pType));
    }
    else {
      lBasicType = false;
    }
    return lBasicType;
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
      if (isIgnoredHeader(pType)) {
        lOpenAPIType = null;
      }
      else {
        lOpenAPIType = "header";
      }
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

  public static boolean isIgnoredHeader( Element pElement ) {
    boolean lIgnoredHeaderName;
    if (GeneratorCommons.addIgnorableHeadersToOpenAPISpec()) {
      lIgnoredHeaderName = false;
    }
    else {
      Stereotype lAppliedStereotype = ClassUtil.getAppliedStereotype(pElement, "HeaderParam");
      if (lAppliedStereotype != null) {
        String lHeaderName = (String) pElement.getValue(lAppliedStereotype, "value");
        if (lHeaderName == null) {
          lHeaderName = ((NamedElement) pElement).getName();
        }
        if ("Accept".equalsIgnoreCase(lHeaderName) || "Content-Type".equalsIgnoreCase(lHeaderName)
            || "Authorization".equalsIgnoreCase(lHeaderName)) {
          lIgnoredHeaderName = true;
        }
        else {
          lIgnoredHeaderName = false;
        }
      }
      else {
        lIgnoredHeaderName = false;
      }
    }
    return lIgnoredHeaderName;
  }

  public static List<Element> getAllAttributesFromHierarchy( Element pElement ) {
    List<Element> lElements = new ArrayList<Element>();
    if (pElement instanceof Class) {
      Class lClass = (Class) pElement;
      if (lClass.parents().size() > 0) {
        List<Element> lParentAttributes = getAllAttributesFromHierarchy(lClass.parents().get(0));
        lElements.addAll(lParentAttributes);
      }

      EList<Property> lOwnedAttributes = lClass.getOwnedAttributes();
      for (int i = 0; i < lOwnedAttributes.size(); i++) {
        lElements.add(lOwnedAttributes.get(i));
      }
    }

    return lElements;
  }

  public static String getJAXRSStatusCodeName( String pJMMStatusCode ) {
    String lStatusCode = httpStatusCodeMapping.get(pJMMStatusCode);
    if (lStatusCode == null) {
      XFun.getTrace().error("No mapping found for status code: " + pJMMStatusCode);
    }
    return lStatusCode;
  }

  public static String getModelStatusCodeName( Integer pStatusCode ) {
    String lStatusCode = httpStatusCodeValues.get(pStatusCode);
    if (lStatusCode == null) {
      XFun.getTrace().error("Invalid REST (JAX-RS) status code: " + pStatusCode);
    }
    return lStatusCode;
  }

  public static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

  public static List<String> splitRESTPath( String pRESTPath, List<String> pPathParams, List<String> pVariableNames ) {
    Assert.assertTrue(pPathParams.size() == pVariableNames.size(),
        "Internal error amount of path params and variables names must be the same");

    List<String> lSplitResult = java.util.Arrays.asList(splitRESTPath(pRESTPath, pPathParams.toArray(new String[] {})));
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
          lBuilder.append("|");
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

  public static java.util.List<String> extractRESTParamsFromPath( String pPath ) {
    java.util.List<String> lPathParams = new ArrayList();
    if (pPath != null) {
      java.util.regex.Matcher lMatcher = PATH_PARAM_PATTERN.matcher(pPath);
      while (lMatcher.find()) {
        String lParam = lMatcher.group();
        lPathParams.add(lParam.substring(1, lParam.length() - 1));
      }
    }
    return lPathParams;
  }

  public static java.util.List<String> detectMissingRESTPathParams( String pRESTPath,
      java.util.List<String> pPathVariableNames ) {

    java.util.List<String> lMissingPathParams = new ArrayList();
    if (pRESTPath != null) {
      java.util.List<String> lPathParams = extractRESTParamsFromPath(pRESTPath);
      for (String lNextPathParam : lPathParams) {
        if (pPathVariableNames.contains(lNextPathParam) == false) {
          lMissingPathParams.add(lNextPathParam);
        }
      }
    }
    return lMissingPathParams;
  }

  public static java.util.List<String> detectDeadRESTPathParams( String pRESTPath,
      java.util.List<String> pPathVariableNames ) {
    java.util.List<String> lDeadPathParams = new ArrayList();

    if (pPathVariableNames != null) {
      java.util.List<String> lPathParams = extractRESTParamsFromPath(pRESTPath);
      for (String lNextPathParam : pPathVariableNames) {
        if (lPathParams.contains(lNextPathParam) == false) {
          lDeadPathParams.add(lNextPathParam);
        }
      }
    }
    return lDeadPathParams;
  }

  public static OpenAPIVersion getOpenAPIVersion( ) {
    String lValue = SystemProperties.getProperty("switch.gen.openapi.version", OpenAPIVersion.OPEN_API_3_1.name());
    return OpenAPIVersion.valueOf(lValue);
  }

  public static boolean isOpenAPIVersion31( ) {
    return OpenAPIVersion.OPEN_API_3_1 == getOpenAPIVersion();
  }

  public static boolean isOpenAPIVersion30( ) {
    return OpenAPIVersion.OPEN_API_3_0 == getOpenAPIVersion();
  }
}
