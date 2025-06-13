/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;

public class GeneratorCommons {
  /**
   * Constant defines the pattern that is used to convert time stamps in string format to java objects. The string
   * representation of a time stamp has to have the following structure: "yyyy-MM-dd HH:mm:ss.SSS" (e.g. "2004-11-28
   * 13:31:17.098")
   */
  public static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * Constant defines the name of the system property which contains the package white list of the generator.
   */
  public static final String GENERATOR_WHITELIST_PROPERTY = "list.pkgs.whitelist";

  /**
   * Constant defines the name of the system property which enables the generation of public parts from the model.
   */
  public static final String CUSTOM_CONSTRAINTS_PROPERTY = "switch.gen.custom.constraints";

  /**
   * Constant defines the name of the system property which enables the generation of service interfaces from the model.
   */
  public static final String SERVICES_PROPERTY = "switch.gen.services";

  /**
   * Constant defines the name of the system property which enables the generation of service proxies from the model.
   */
  public static final String SERVICE_PROXIES_PROPERTY = "switch.gen.service.proxies";

  /**
   * Constant defines the name of the system property which enables the generation of service provider interfaces from
   * the model.
   */
  public static final String SERVICE_PROVIDER_INTERFACES_PROPERTY = "switch.gen.service.provider.interfaces";

  /**
   * Constant defines the name of the system property which enables the generation of service provider impls from the
   * model.
   */
  public static final String SERVICE_PROVIDER_IMPLS_PROPERTY = "switch.gen.service.provider.impls";

  /**
   * Constant defines the name of the system property which enables the generation of REST resources from the model.
   */
  public static final String REST_RESOURCES_PROPERTY = "switch.gen.rest.resources";

  public static final String SECURITY_ANNOTATION_PROPERTY = "switch.gen.rest.security.annotation";

  public static final String USE_DEPRECATED_SECURED_PROPERTY =
      "switch.gen.rest.security.useDeprecatedSpringSecuredAnnotation";

  public static final String REST_REQUEST_VALIDATION_PROPERTY = "switch.gen.rest.validation.request";

  public static final String REST_RESPONSE_VALIDATION_PROPERTY = "switch.gen.rest.validation.response";

  public static final String FILTER_CUSTOM_HEADERS = "switch.gen.rest.filter.custom.headers";

  /**
   * Constant defines the name of the property that defines the REST path prefix that should be used when generating
   * REST resources.
   */
  public static final String REST_PATH_PREFIX_PROPERTY = "switch.gen.rest.path.prefix";

  /**
   * Constant defines the name of the system property which enables the generation of REST service proxies from the
   * model.
   */
  public static final String REST_SERVICE_PROXY_PROPERTY = "switch.gen.rest.service.proxy";

  /**
   * Constant defines the name of the system property which enables the generation of REST service proxies from the
   * model.
   */
  public static final String REST_SERVICE_PROXY_CONFIG_FILE_PROPERTY = "switch.gen.rest.service.proxy.config.file";

  /**
   * Constant defines the name of the system property which enables the generation of service interfaces from the model.
   */
  public static final String ACTIVITY_INTERFACES_PROPERTY = "switch.gen.activity.interfaces";

  /**
   * Constant defines the name of the system property which enables the generation of service interfaces from the model.
   */
  public static final String ACTIVITY_IMPLS_PROPERTY = "switch.gen.activity.impls";

  /**
   * Constant defines the name of the system property which enables the generation of service objects from the model.
   */
  public static final String SERVICE_OBJECTS_PROPERTY = "switch.gen.service.objects";

  /**
   * Constant defines the name of the system property which enables the generation of service objects from the model.
   */
  public static final String POJO_PROPERTY = "switch.gen.pojos";

  public static final String GENERATE_EQUALS_ALL = "switch.gen.equalsAndHashCode.all";

  public static final String GENERATE_EQUALS_STANDARD = "switch.gen.equalsAndHashCode.standard";

  public static final String GENERATE_EQUALS_COMPOSITE = "switch.gen.equalsAndHashCode.composite.datatype";

  public static final String GENERATE_EQUALS_OPENAPI = "switch.gen.equalsAndHashCode.openapi.datatype";

  /**
   * Constant defines the name of the system property which enables the generation of serializable POJOs from the model.
   */
  public static final String MAKE_POJO_SERIALIZABLE_PROPERTY = "switch.gen.serializable.pojos";

  /**
   * Constant defines the name of the system property which enables the generation of immutable POJOs and ServiceObjects
   * from the model.
   */
  public static final String GENERATE_IMMUTABLE_CLASSES = "switch.gen.immutable.classes";

  /**
   * Constant defines the name of the system property which enables the generation of heavy style extensible enums.
   */
  public static final String GENERATE_HEAVY_STLYE_EXTENSBLE_ENUMS_PROPERTY = "switch.gen.heavy.extensible.enums";

  /**
   * Constant defines the name of the system property which enables the generation of exception classes from the model.
   */
  public static final String EXCEPTION_CLASSES_PROPERTY = "switch.gen.exception.classes";

  /**
   * Constant defines the name of the system property which enables the generation of service objects from the model.
   */
  public static final String DOMAIN_OBJECTS_PROPERTY = "switch.gen.domain.objects";

  /**
   * Constant defines the name of the system property which enables the generation of persistent objects from the model.
   */
  public static final String PERSISTENT_OBJECTS_PROPERTY = "switch.gen.persistent.objects";

  /**
   * Constant defines the name of the system property which enables the generation of object mappers from the model.
   */
  public static final String OBJECT_MAPPERS_PROPERTY = "switch.gen.object.mappers";

  /**
   * Constant defines the name of the system property which enables the generation of component runtime classes from the
   * model.
   */
  public static final String COMPONENT_RUNTIME_PROPERTY = "switch.gen.component.runtime.classes";

  /**
   * Constant defines the name of the system property which enables the generation of component runtime classes from the
   * model.
   */
  public static final String COMPONENT_IMPLS_PROPERTY = "switch.gen.component.impls";

  /**
   * Constant defines the name of the system property which enables the generation of global parts from the model.
   */
  public static final String GLOBAL_PARTS_PROPERTY = "switch.gen.global.parts";

  /**
   * Constant defines the name of the system property which enables the generation of public setters for to many
   * associations.
   */
  public static final String GENERATE_PUBLIC_SETTERS = "switch.gen.public.setters.for.associations";

  /**
   * Constant defines the name of the system property which enables code generation for of(...) operation
   */
  public static final String GENERATE_OF_OPERATION = "switch.gen.of.operation";

  /**
   * Constant defines the name of the system property which enables code generation for of(...) operation for OpenAPI
   * Data Types
   */
  public static final String GENERATE_OF_OPERATION_FOR_OPENAPI_DATATYPE = "switch.gen.of.operation.openapi.datatype";

  /**
   * Constant defines the name of the system property which enables the generation of valueOf method for OpenAPI Data
   * Types in Java.
   */
  public static final String GENERATE_VALUE_OF = "switch.gen.value.of.data.types";

  /**
   * Constant defines the name of the system property which enables the generation of null checks for setters of to one
   * associations of service objects.
   */
  public static final String GENERATE_NULL_CHECKS_FOR_TO_ONE_ASSOCIATIONS_OF_SERVICE_OBJECTS =
      "switch.gen.null.checks.for.to.one.associations.of.service.objects";

  /**
   * Constant defines the name of the syste property which enable generation of public object view of POJO's and
   * ServiceObjects.
   */
  public static final String GENERATE_PUBLIC_OBJECT_VIEW = "switch.gen.public.object.view";

  /**
   * Constant defines the name of the system property which disables immutability of collections.
   */
  public static final String DISABLE_COLLECTION_IMMUTABILITY = "switch.gen.disable.collection.immutability";

  /**
   * Constant defines the name of the system property which disables immutability of collections.
   */
  public static final String DISABLE_ARRAY_IMMUTABILITY = "switch.gen.disable.array.immutability";

  /**
   * Constant defines the name of the system property which disables immutability of collections.
   */
  public static final String DISABLE_BINRAY_DATA_IMMUTABILITY = "switch.gen.disable.binary.data.immutability";

  /**
   * Constant defines the name of the system property that enables generation of detailed toString() operation.
   */
  public static final String ENABLE_DETAILED_TO_STRING = "switch.gen.enable.detailed.toString";

  /**
   * Constant defines the name of the system property that enables legacy builder style.
   */
  public static final String ENABLE_LEGACY_BUILDER_STYLE = "switch.gen.enable.legacy.builder.style";

  /**
   * Constant defines then name of the system property that enables generation of an additional builder method with all
   * mandatory fields.
   */
  public static final String GENERATE_BUILDER_METHOD_WITH_ALL_MANDATORY_FIELDS =
      "switch.gen.enable.builder.for.manadatory.fields";

  /**
   * Constant defines the name of the system property which enables the generation of JUnit tests for services.
   */
  public static final String JUNIT_PROPERTY = "switch.gen.junits";

  public static final String GENERATE_TYPES_REPORT = "switch.gen.types.report";

  public static final String TYPES_REPORT_NAME = "switch.gen.types.report.name";

  public static final String TYPES_REPORT_FILE_NAME = "switch.gen.types.report.filename";

  public static final String TYPES_REPORT_FILE_SHOW_ALIAS = "switch.gen.types.report.showAlias";

  public static final String TYPES_REPORT_FILE_ALIAS_ROW_NAME = "switch.gen.types.report.aliasRowName";

  public static final String TYPES_REPORT_FILE_SHOW_PACKAGE = "switch.gen.types.report.showPackage";

  public static final String TYPES_REPORT_FILE_SHOW_PROPERTIES = "switch.gen.types.report.showProperties";

  public static final String TYPES_REPORT_FILE_GROUP_BY_PACKAGES = "switch.gen.types.report.groupByPackage";

  public static final String TYPES_REPORT_FILE_STEREOTYPES = "switch.gen.types.report.stereotypes";

  public static final String GENERATE_BREAKING_CHANGES_REPORT = "switch.gen.breaking.changes.report";

  public static final String BREAKING_CHANGES_REPORT_NAME = "switch.gen.breaking.changes.report.name";

  public static final String BREAKING_CHANGES_REPORT_FILE_NAME = "switch.gen.breaking.changes.report.filename";

  public static final String GENERATE_REST_DEPRECATION_REPORT = "switch.gen.rest.deprecation.report";

  public static final String REST_DEPRECATION_REPORT_NAME = "switch.gen.rest.deprecation.report.name";

  public static final String REST_DEPRECATION_REPORT_FILE_NAME = "switch.gen.rest.deprecation.report.filename";

  public static final String GENERATE_JAVA_DEPRECATION_REPORT = "switch.gen.java.deprecation.report";

  public static final String JAVA_DEPRECATION_REPORT_NAME = "switch.gen.java.deprecation.report.name";

  public static final String JAVA_DEPRECATION_REPORT_FILE_NAME = "switch.gen.java.deprecation.report.filename";

  public static final String DEPRECATION_REPORT_FORMAT = "switch.gen.deprecation.report.format";

  public static final String GENERATE_SECURITY_ROLES_REPORT = "switch.gen.security.roles.report";

  public static final String SECURITY_ROLES_REPORT_NAME = "switch.gen.security.roles.report.name";

  public static final String SECURITY_ROLES_REPORT_FILE_NAME = "switch.gen.security.roles.report.filename";

  public static final String SECURITY_ROLES_REPORT_FORMAT = "switch.gen.security.roles.report.format";

  /**
   * Constant defines the name of the system property which enables the generation of OpenAPI specifications.
   */
  public static final String OPEN_API_SPEC_PROPERTY = "switch.gen.openapispec";

  /**
   * Constant defines the name of the system property which enables YAML 1.1 compatibility mode for OpenAPI.
   */
  public static final String OPEN_API_YAML_11_COMPATIBILITY = "switch.gen.openapi.yaml.11.comapitibility";

  /**
   * Constant defines the name of the system property which defines the OpenAPI YAML comment style that should be used.
   */
  public static final String OPEN_API_YAML_COMMENT_STYLE = "switch.gen.openapi.openAPICommentStyle";

  /**
   * Constant defines the name of the system property which enable that technical http headers will be suppressed.
   */
  public static final String SUPPRESS_TECHNICAL_HTTP_HEADERS = "switch.gen.rest.suppress.technical.headers";

  /**
   * Constant defines the name of the property which enables that ignorable headers are added to OpenAPI spec
   */
  public static final String ADD_IGNORED_HEADER_TO_OPEN_API_SPEC = "switch.gen.openapi.addIgnoredHeadersToOpenAPISpec";

  /**
   * Constant defines the name of the system property which enables the generation of JAX-RS annotations.
   */
  public static final String JAX_RS_ANNOTATIONS_PROPERTY = "switch.gen.jaxrs.annotations";

  /**
   * Constant defines the name of the system property which enables the generation of Jackson annotations (required for
   * proper JSON serialization).
   */
  public static final String JACKSON_ANNOTATIONS_PROPERTY = "switch.gen.jackson.annotations";

  /**
   * Constant defines the name of the system property which enables SemVer support for generated JSON serialization.
   */
  public static final String ENABLE_SEMVER_FOR_JSON = "switch.gen.enable.json.semver";

  /**
   * Constant defines the name of the system property which enables code generation for JSON serializers.
   */
  public static final String JSON_SERIALIZERS = "switch.gen.json.serializers";

  public static final String NAME_CONSTANTS_FOR_ATTRIBUTES = "switch.gen.enable.name.constants";

  public static final String SUPPRESS_WARNINGS_LIST = "switch.gen.suppress.warnings";

  public static final String SUPPRESS_ALL_WARNINGS = "switch.gen.suppress.all.warnings";

  public static final String ADD_GENERATED_ANNOTATION = "switch.gen.add.generated.annotation";

  public static final String ADD_GENERATION_TIMESTAMP = "switch.gen.add.generation.timestamp";

  public static final String TARGET_RUNTIME = "switch.gen.target.runtime";

  public static final String ENTERPRISE_JAVA_TYPE = "switch.gen.enterprise.java";

  public static final String REST_LIBRARY = "switch.gen.target.rest.library";

  public static final String REST_DEFAULT_SUCCESS_STATUS_CODE = "switch.gen.target.rest.success.status.code";

  public static final String REST_DEFAULT_VOID_STATUS_CODE = "switch.gen.target.rest.void.status.code";

  public static final String GENERATION_COMMENT = "switch.gen.generation.comment";

  public static final String VALID_ANNOTATION_FOR_CLASSES = "switch.gen.enable.valid.annotation.classes";

  public static final String VALID_ANNOTATION_FOR_ASSOCIATIONS = "switch.gen.enable.valid.annotation.associations";

  public static final String VALIDATION_ANNOTATION_FOR_ATTRIBUTES =
      "switch.gen.enable.validation.annotation.attributes";

  public static final String VALIDATION_ANNOTATION_FOR_ASSOCIATIONS =
      "switch.gen.enable.validation.annotation.associations";

  public static final String GENERATE_OBJECT_VALIDATION_IN_BUILDER = "switch.gen.enable.validation.in.builder";

  public static final String SUPPRESS_CLASSNAME_IN_OPENAPI = "switch.gen.suppress.classname.openapi";

  public static final String LINE_SEPARATOR = "\n";

  public static final String CLASS_INDENTATION = "";

  public static final String INTERFACE_INDENTATION = "";

  public static final String ATTRIBUTE_INDENTATION = "  ";

  public static final String METHOD_INDENTATION = "  ";

  public static final String MAVEN_VERSION_PROPERTY = "maven.version";

  public static final String VERSION_PROPERTY = "info.version";

  public static final String COMPANY_INFO_PROPERTY = "info.company";

  public static final String COPYRIGHT_PROPERTY = "info.copyright";

  public static final String AUTHOR_PROPERTY = "info.author";

  public static final Set<String> NUMERIC_ANNOTATION_CLASSES;

  public static final Set<String> DATE_ANNOTATION_CLASSES;

  public static final Set<String> BOOLEAN_ANNOTATION_CLASSES;
  static {
    BOOLEAN_ANNOTATION_CLASSES = new HashSet<String>();
    BOOLEAN_ANNOTATION_CLASSES.add(boolean.class.getName());
    BOOLEAN_ANNOTATION_CLASSES.add(Boolean.class.getName());

    NUMERIC_ANNOTATION_CLASSES = new HashSet<String>();
    NUMERIC_ANNOTATION_CLASSES.add(BigDecimal.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(BigInteger.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(byte.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(short.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(int.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(long.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(Byte.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(Short.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(Integer.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add(Long.class.getName());
    NUMERIC_ANNOTATION_CLASSES.add("Byte");
    NUMERIC_ANNOTATION_CLASSES.add("Short");
    NUMERIC_ANNOTATION_CLASSES.add("Integer");
    NUMERIC_ANNOTATION_CLASSES.add("Long");

    DATE_ANNOTATION_CLASSES = new HashSet<String>();
    DATE_ANNOTATION_CLASSES.add(java.util.Date.class.getName());
    DATE_ANNOTATION_CLASSES.add(java.util.Calendar.class.getName());
    DATE_ANNOTATION_CLASSES.add("java.time.Instant");
    DATE_ANNOTATION_CLASSES.add("java.time.LocalDate");
    DATE_ANNOTATION_CLASSES.add("java.time.LocalDateTime");
    DATE_ANNOTATION_CLASSES.add("java.time.LocalTime");
    DATE_ANNOTATION_CLASSES.add("java.time.MonthDay");
    DATE_ANNOTATION_CLASSES.add("java.time.OffsetDateTime");
    DATE_ANNOTATION_CLASSES.add("java.time.OffsetTime");
    DATE_ANNOTATION_CLASSES.add("java.time.Year");
    DATE_ANNOTATION_CLASSES.add("java.time.YearMonth");
    DATE_ANNOTATION_CLASSES.add("java.time.ZonedDateTime");
    DATE_ANNOTATION_CLASSES.add("java.time.chrono.HijrahDate");
    DATE_ANNOTATION_CLASSES.add("java.time.chrono.JapaneseDate");
    DATE_ANNOTATION_CLASSES.add("java.time.chrono.MinguoDate");
    DATE_ANNOTATION_CLASSES.add("java.time.chrono.ThaiBuddhistDate");
  }

  /**
   * Method recursively resolves all attributes of the passed class from the whole inheritance hierarchy.
   * 
   * @param pClass UML Class object whose attributes should be resolved. The parameter must not be null.
   * @return List All attributes of the passed class. The method never returns null.
   */
  public static List<Property> getAllAttributes(
      org.eclipse.uml2.uml.Class pClass) {
    // Check parameter
    Assert.assertNotNull(pClass, "pClass");

    List<Property> lAttributeSet = new ArrayList<Property>();
    lAttributeSet.addAll(pClass.getOwnedAttributes());

    // Traverse through class hierarchy to all super classes.
    final Iterator<org.eclipse.uml2.uml.Class> lIterator = pClass
        .getSuperClasses().iterator();
    while (lIterator.hasNext()) {
      // Get super class and resolve all attributes.
      org.eclipse.uml2.uml.Class lSuperClass = lIterator.next();
      lAttributeSet
          .addAll(GeneratorCommons.getAllAttributes(lSuperClass));
    }

    // Return result.
    return lAttributeSet;
  }

  /**
   * Method checks whether the passed child class is assignable to the passed class.
   * 
   * @param pChild Child class for which the check will be performed. The parameter must not be null.
   * @param pClass Class to check against. The parameter must not be null.
   * @return boolean The method returns true if pChild is assignable to references of type pClass and false in all other
   * cases.
   */
  public static boolean isAssignable(org.eclipse.uml2.uml.Class pChild,
      org.eclipse.uml2.uml.Class pClass) {
    // Parameter are both the same class and thus are assignable
    boolean lResult;
    if (pChild.equals(pClass)) {
      lResult = true;
    }
    // Check class hierarchy of pChild and see if it contains pClass.
    else {
      lResult = false;
      final List<Class> lSuperClasses = pChild.getSuperClasses();
      final Iterator<Class> lIterator = lSuperClasses.iterator();
      while (lIterator.hasNext()) {
        Class lNextSuperClass = lIterator.next();
        lResult = GeneratorCommons
            .isAssignable(lNextSuperClass, pClass);
      }
    }
    // Return result.
    return lResult;
  }

  /**
   * Method checks whether the passed property can be used as a valid init value.
   * 
   * @param pProperty Property that should be checked if it has a real init value. The parameter must not be null.
   * @return
   */
  public static boolean isRealInitValue(Property pProperty) {
    // Check parameter
    Check.checkInvalidParameterNull(pProperty, "pProperty");

    // Get default value from UML model and check if it is really set.
    final ValueSpecification lDefaultValue = pProperty.getDefaultValue();
    final boolean lIsRealInitValue;

    // Default value is set.
    if (lDefaultValue != null) {

      // Check if it consists of at least one real character.
      final String lStringValue = lDefaultValue.stringValue().trim();
      if (lStringValue.length() > 0) {
        lIsRealInitValue = true;
      }
      else {
        lIsRealInitValue = false;
      }
    }
    // No default value is set.
    else {
      lIsRealInitValue = false;
    }
    // Return result.
    return lIsRealInitValue;
  }

  /**
   * Method checks whether the passed package is part of the package white list for generation.
   * 
   * @param pPackage Package for which should be checked if it is part of the white list. The parameter must not be
   * null.
   * @return boolean The method returns true if the passed package belongs to the package white list and false in all
   * other cases.
   */
  public static boolean isMayBeInPackageWhitelist(Package pPackage) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pPackage, "pPackage");

    // Check if system property is defined.
    String lPropertyTest = SystemProperties
        .getProperty(GENERATOR_WHITELIST_PROPERTY);
    boolean lIsInWhitelist;

    // Get white list as it is defined as system property
    if (lPropertyTest != null) {
      List<String> lPackageNames = SystemProperties
          .getPropertiesList(GENERATOR_WHITELIST_PROPERTY);

      // Check if white list is empty. This means that all packages should
      // be generated.
      if (lPackageNames.size() > 0) {
        lIsInWhitelist = false;

        // Get fully qualified name of the passed package.
        String lPackageName = ClassUtil.getPackageName(pPackage);

        for (String lNextWhitelistEntry : lPackageNames) {
          // Get next white list entry and check if it matches with
          // the passed package
          if (lPackageName.startsWith(lNextWhitelistEntry) == true
              || lNextWhitelistEntry.startsWith(lPackageName) == true) {
            // White list entry and package match.
            lIsInWhitelist = true;
            break;
          }
        }
      }
      // No entries in white list defined and thus all packages will be
      // accepted.
      else {
        lIsInWhitelist = true;
      }
    }
    // System property is not defined and thus all packages will be
    // accepted.
    else {
      lIsInWhitelist = true;
    }

    // Return result of white list check.
    return lIsInWhitelist;
  }

  /**
   * Method checks whether the passed package is part of the package white list for generation.
   * 
   * @param pNamedElement Package for which should be checked if it is part of the white list. The parameter must not be
   * null.
   * @return boolean The method returns true if the passed package belongs to the package white list and false in all
   * other cases.
   */
  public static boolean isInGeneratorWhitelist(NamedElement pNamedElement) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pNamedElement, "pNamedElement");

    // Check if element is marked to be ignored
    boolean lIsInWhitelist;
    if (ClassUtil.isStereotypeApplied(pNamedElement, "Ignore")) {
      lIsInWhitelist = false;
    }
    else {
      // Check if system property is defined.
      String lPropertyTest = System
          .getProperty(GENERATOR_WHITELIST_PROPERTY);

      // Get white list as it is defined as system property
      if (lPropertyTest != null) {
        List<String> lPackageNames = SystemProperties
            .getPropertiesList(GENERATOR_WHITELIST_PROPERTY);

        // Check if white list is empty. This means that all packages
        // should be generated.
        if (lPackageNames.size() > 0) {
          lIsInWhitelist = false;

          // Get fully qualified name of the passed package.
          String lPackageName = ClassUtil
              .getPackageName(pNamedElement.getNearestPackage());

          for (String lNextWhitelistEntry : lPackageNames) {
            // Get next white list entry and check if it matches
            // with the passed package
            if (lPackageName.startsWith(lNextWhitelistEntry) == true) {
              // Check for real package match and not only same
              // beginning.
              if (lPackageName.length() > lNextWhitelistEntry
                  .length()) {
                if ('.' == lPackageName
                    .charAt(lNextWhitelistEntry.length())) {
                  lIsInWhitelist = true;
                }
                else {
                  lIsInWhitelist = false;
                }
              }
              // White list entry and package match exactly.
              else {
                lIsInWhitelist = true;
                break;
              }
            }
          }
        }
        // No entries in white list defined and thus all packages will
        // be accepted.
        else {
          lIsInWhitelist = true;
        }
      }
      // System property is not defined and thus all packages will be
      // accepted.
      else {
        lIsInWhitelist = true;
      }
    }

    // Return result of white list check.
    return lIsInWhitelist;
  }

  /**
   * Method checks whether the custom constraint for Java validation from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if custom validations should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateCustomConstraints( ) {
    return SystemProperties.getBooleanProperty(CUSTOM_CONSTRAINTS_PROPERTY,
        true);
  }

  /**
   * Method checks whether services from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServices( ) {
    return SystemProperties.getBooleanProperty(SERVICES_PROPERTY, true);
  }

  /**
   * Method checks whether service proxies from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServiceProxies( ) {
    return SystemProperties.getBooleanProperty(SERVICE_PROXIES_PROPERTY,
        true);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateServiceProviderInterfaces( ) {
    return SystemProperties.getBooleanProperty(
        SERVICE_PROVIDER_INTERFACES_PROPERTY, true);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateServiceProviderImpls( ) {
    return SystemProperties.getBooleanProperty(
        SERVICE_PROVIDER_IMPLS_PROPERTY, true);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTResources( ) {
    return SystemProperties.getBooleanProperty(REST_RESOURCES_PROPERTY,
        true);
  }

  public static boolean generateSecurityAnnotation( ) {
    return SystemProperties.getBooleanProperty(
        SECURITY_ANNOTATION_PROPERTY, true);
  }

  public static boolean useDeprecatedSpringSecuredAnnotation( ) {
    return SystemProperties.getBooleanProperty(
        USE_DEPRECATED_SECURED_PROPERTY, false);
  }

  public static boolean generateRESTRequestValidation( ) {
    return SystemProperties.getBooleanProperty(
        REST_REQUEST_VALIDATION_PROPERTY, true);
  }

  public static boolean generateRESTResponseValidation( ) {
    return SystemProperties.getBooleanProperty(
        REST_RESPONSE_VALIDATION_PROPERTY, true);
  }

  public static boolean filterCustomHeaders( ) {
    return SystemProperties.getBooleanProperty(FILTER_CUSTOM_HEADERS, true);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static String getRESTPathPrefix( ) {
    return SystemProperties.getProperty(REST_PATH_PREFIX_PROPERTY, "");
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTServiceProxies( ) {
    return SystemProperties.getBooleanProperty(REST_SERVICE_PROXY_PROPERTY,
        true);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTServiceProxyConfigFile( ) {
    return SystemProperties.getBooleanProperty(
        REST_SERVICE_PROXY_CONFIG_FILE_PROPERTY, true);
  }

  /**
   * Method checks whether activity interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if activity interfaces should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateActivityInterfaces( ) {
    return SystemProperties.getBooleanProperty(
        ACTIVITY_INTERFACES_PROPERTY, true);
  }

  /**
   * Method checks whether activity implementations from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if activity implementations should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateActivityImpls( ) {
    return SystemProperties.getBooleanProperty(ACTIVITY_IMPLS_PROPERTY,
        true);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServiceObjects( ) {
    return SystemProperties.getBooleanProperty(SERVICE_OBJECTS_PROPERTY,
        true);
  }

  /**
   * Method checks whether POJOs from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if POJOs should be generated from the model and false in all other cases.
   */
  public static boolean generatePOJOs( ) {
    return SystemProperties.getBooleanProperty(POJO_PROPERTY, true);
  }

  public static boolean generateEqualsAndHashCode( ) {
    return SystemProperties.getBooleanProperty(GENERATE_EQUALS_ALL, true);
  }

  public static boolean generateEqualsAndHashCodeForStandardClasses( ) {
    return SystemProperties.getBooleanProperty(GENERATE_EQUALS_STANDARD,
        true);
  }

  public static boolean generateEqualsAndHashCodeForCompositeDataTypes( ) {
    return SystemProperties.getBooleanProperty(GENERATE_EQUALS_COMPOSITE,
        true);
  }

  public static boolean generateEqualsAndHashCodeForOpenAPIDataTypes( ) {
    return SystemProperties.getBooleanProperty(GENERATE_EQUALS_OPENAPI,
        true);
  }

  /**
   * Method checks whether generated POJOs should be serializable.
   * 
   * @return boolean Method returns true if POJOs should be serializable.
   */
  public static boolean makePOJOsSerializable( ) {
    return SystemProperties.getBooleanProperty(
        MAKE_POJO_SERIALIZABLE_PROPERTY, false);
  }

  public static boolean generateImmutableClasses( ) {
    return SystemProperties.getBooleanProperty(GENERATE_IMMUTABLE_CLASSES,
        false);
  }

  public static boolean generateHeavyStyleExtensibleEnums( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_HEAVY_STLYE_EXTENSBLE_ENUMS_PROPERTY, false);
  }

  /**
   * Method checks whether exception classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if exception classes should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateExceptionClasses( ) {
    return SystemProperties.getBooleanProperty(EXCEPTION_CLASSES_PROPERTY,
        true);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateDomainObjects( ) {
    return SystemProperties.getBooleanProperty(DOMAIN_OBJECTS_PROPERTY,
        true);
  }

  /**
   * Method checks whether object mappers from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if object mappers should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateObjectMappers( ) {
    return SystemProperties.getBooleanProperty(OBJECT_MAPPERS_PROPERTY,
        true);
  }

  /**
   * Method checks whether component implementation classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if component implementation classes should be generated from the model and
   * false in all other cases.
   */
  public static boolean generateComponentImplClasses( ) {
    return SystemProperties.getBooleanProperty(COMPONENT_IMPLS_PROPERTY,
        true);
  }

  /**
   * Method checks whether component runtime classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if component runtime classes should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateComponentRuntimeClasses( ) {
    return SystemProperties.getBooleanProperty(COMPONENT_RUNTIME_PROPERTY,
        true);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generatePersistentObjects( ) {
    return SystemProperties.getBooleanProperty(PERSISTENT_OBJECTS_PROPERTY,
        true);
  }

  /**
   * Method checks whether the global parts from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if global parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateGlobalParts( ) {
    return SystemProperties.getBooleanProperty(GLOBAL_PARTS_PROPERTY, true);
  }

  /**
   * Method checks whether JUnit test should be generated for every service or not.
   * 
   * @return boolean Method returns true if JUnit tests should be generated from the model and false in all other cases.
   */
  public static boolean generateJUnitTests( ) {
    return SystemProperties.getBooleanProperty(JUNIT_PROPERTY, true);
  }

  public static boolean generateTypesReport( ) {
    return SystemProperties.getBooleanProperty(GENERATE_TYPES_REPORT, true);
  }

  public static String getTypesReportName( ) {
    return SystemProperties.getProperty(TYPES_REPORT_NAME, "Types Report");
  }

  public static String getTypesReportFileName( ) {
    return SystemProperties.getProperty(TYPES_REPORT_FILE_NAME,
        "TypesReport.md");
  }

  public static boolean showAliasInTypesReport( ) {
    return SystemProperties.getBooleanProperty(
        TYPES_REPORT_FILE_SHOW_ALIAS, true);
  }

  public static String getAliasRowName( ) {
    return SystemProperties.getProperty(TYPES_REPORT_FILE_ALIAS_ROW_NAME,
        "");
  }

  public static boolean showPackageInTypesReport( ) {
    return SystemProperties.getBooleanProperty(
        TYPES_REPORT_FILE_SHOW_PACKAGE, true);
  }

  public static boolean showPropertiesInTypesReport( ) {
    return SystemProperties.getBooleanProperty(
        TYPES_REPORT_FILE_SHOW_PROPERTIES, true);
  }

  public static boolean groupTypesReportByPackage( ) {
    return SystemProperties.getBooleanProperty(
        TYPES_REPORT_FILE_GROUP_BY_PACKAGES, true);
  }

  public static List<String> getTypesReportStereotypes( ) {
    return SystemProperties
        .getPropertiesList(TYPES_REPORT_FILE_STEREOTYPES);
  }

  public static boolean generateBreakingChangesReport( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_BREAKING_CHANGES_REPORT, true);
  }

  public static String getBreakingChangesReportName( ) {
    return SystemProperties.getProperty(BREAKING_CHANGES_REPORT_NAME,
        "Breaking Changes Report");
  }

  public static String getBreakingChangesReportFileName( ) {
    return SystemProperties.getProperty(BREAKING_CHANGES_REPORT_FILE_NAME,
        "BreakingChanges.md");
  }

  public static boolean generateRESTDeprecationReport( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_REST_DEPRECATION_REPORT, true);
  }

  public static String getRESTDeprecationReportName( ) {
    return SystemProperties.getProperty(REST_DEPRECATION_REPORT_NAME,
        "REST Deprecation Report");
  }

  public static String getRESTDeprecationReportFileName( ) {
    return SystemProperties.getProperty(REST_DEPRECATION_REPORT_FILE_NAME,
        "RESTDeprecationReport.md");
  }

  public static boolean generateJavaDeprecationReport( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_JAVA_DEPRECATION_REPORT, true);
  }

  public static String getJavaDeprecationReportName( ) {
    return SystemProperties.getProperty(JAVA_DEPRECATION_REPORT_NAME,
        "Java Deprecation Report");
  }

  public static String getJavaDeprecationReportFileName( ) {
    return SystemProperties.getProperty(JAVA_DEPRECATION_REPORT_FILE_NAME,
        "JavaDeprecationReport.md");
  }

  public static ReportFormat getDeprecationReportFormat( ) {
    String lReportFormatName = SystemProperties.getProperty(
        DEPRECATION_REPORT_FORMAT, null);
    ReportFormat lReportFormat;
    if (lReportFormatName != null) {
      lReportFormat = ReportFormat.valueOf(lReportFormatName);
    }
    else {
      lReportFormat = ReportFormat.MARKDOWN;
    }
    return lReportFormat;
  }

  public static String getDeprecationReportFileExtension( ) {
    return getDeprecationReportFormat().getExtension();
  }

  public static boolean generateSecurityRolesReport( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_SECURITY_ROLES_REPORT, true);
  }

  public static String getSecurityRolesReportName( ) {
    return SystemProperties.getProperty(SECURITY_ROLES_REPORT_NAME,
        "Security Report");
  }

  public static String getSecurityRolesReportFileName( ) {
    return SystemProperties.getProperty(SECURITY_ROLES_REPORT_FILE_NAME,
        "SecurityReport.md");
  }

  public static ReportFormat getSecurityRolesReportFormat( ) {
    String lReportFormatName = SystemProperties.getProperty(
        SECURITY_ROLES_REPORT_FORMAT, null);
    ReportFormat lReportFormat;
    if (lReportFormatName != null) {
      lReportFormat = ReportFormat.valueOf(lReportFormatName);
    }
    else {
      lReportFormat = ReportFormat.MARKDOWN;
    }
    return lReportFormat;
  }

  public static String getSecurityRolesReportFileExtension( ) {
    return getSecurityRolesReportFormat().getExtension();
  }

  /**
   * Method checks whether OpenAPI specification should be generated for every service or not.
   * 
   * @return boolean Method returns true if OpenAPI spec should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateOpenAPISpec( ) {
    return SystemProperties
        .getBooleanProperty(OPEN_API_SPEC_PROPERTY, true);
  }

  /**
   * Method checks whether YAML 1.1 compatibility mode for OpenAPI should be enabled.
   * 
   * @return boolean Method returns true if YAML 1.1 compatibility mode should be enabled and false in all other cases.
   */
  public static boolean enableYAML11Compatibility( ) {
    return SystemProperties.getBooleanProperty(
        OPEN_API_YAML_11_COMPATIBILITY, true);
  }

  /**
   * Method checks whether YAML 1.1 compatibility mode for OpenAPI should be enabled.
   * 
   * @return boolean Method returns true if YAML 1.1 compatibility mode should be enabled and false in all other cases.
   */
  public static String getOpenAPICommentStyle( ) {
    return SystemProperties.getProperty(OPEN_API_YAML_COMMENT_STYLE);
  }

  /**
   * Method checks if technical http headers should be suppressed.
   */
  public static boolean suppressTechnicalHttpHeaders( ) {
    return SystemProperties.getBooleanProperty(
        SUPPRESS_TECHNICAL_HTTP_HEADERS, false);
  }

  /**
   * Method checks if ignorable http headers should anyways be added to the OpenAPI spec.
   */
  public static boolean addIgnorableHeadersToOpenAPISpec( ) {
    return SystemProperties.getBooleanProperty(
        ADD_IGNORED_HEADER_TO_OPEN_API_SPEC, true);
  }

  /**
   * Method checks whether JAX-RS Annotations for should be generated.
   * 
   * @return boolean Method returns true if JAX-RS Annotations should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateJAXRSAnnotations( ) {
    return SystemProperties.getBooleanProperty(JAX_RS_ANNOTATIONS_PROPERTY,
        true);
  }

  /**
   * Method checks whether Jackson Annotations for (JSON serialization) should be generated.
   * 
   * @return boolean Method returns true if Jackson Annotations should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateJacksonAnnotations( ) {
    return SystemProperties.getBooleanProperty(
        JACKSON_ANNOTATIONS_PROPERTY, true);
  }

  public static boolean enableSemVerForJSON( ) {
    return SystemProperties
        .getBooleanProperty(ENABLE_SEMVER_FOR_JSON, true);
  }

  public static boolean generateJSONSerializers( ) {
    return SystemProperties.getBooleanProperty(JSON_SERIALIZERS, true);
  }

  public static boolean generateConstantsForAttributeNames( ) {
    return SystemProperties.getBooleanProperty(
        NAME_CONSTANTS_FOR_ATTRIBUTES, true);
  }

  public static List<String> getSuppressedWarnings( ) {
    return SystemProperties.getPropertiesList(SUPPRESS_WARNINGS_LIST);
  }

  public static boolean suppressAllWarnings( ) {
    return SystemProperties.getBooleanProperty(SUPPRESS_ALL_WARNINGS, true);
  }

  public static boolean addGeneratedAnnotation( ) {
    return SystemProperties.getBooleanProperty(ADD_GENERATED_ANNOTATION,
        true);
  }

  public static boolean addGenerationTimestamp( ) {
    return SystemProperties.getBooleanProperty(ADD_GENERATION_TIMESTAMP,
        true);
  }

  public static String getGenerationComment( ) {
    return SystemProperties.getProperty(GENERATION_COMMENT, "");
  }

  public static String getGeneratedAnnotation( ) {
    StringBuilder lBuilder = new StringBuilder();
    if (addGenerationTimestamp()
        || getGenerationComment().isEmpty() == false) {
      lBuilder
          .append("value = \"com.anaptecs.jeaf.generator.JEAFGenerator\", ");

      if (addGenerationTimestamp()) {
        SimpleDateFormat lDateFormat = new SimpleDateFormat(
            TIMESTAMP_PATTERN);
        lBuilder.append("date = \"");
        lBuilder.append(lDateFormat.format(new Date()));
        lBuilder.append("\"");

        if (getGenerationComment().isEmpty() == false) {
          lBuilder.append(", comments = \"");
          lBuilder.append(getGenerationComment());
          lBuilder.append("\"");
        }
      }
      else {
        lBuilder.append("comments = \"");
        lBuilder.append(getGenerationComment());
        lBuilder.append("\"");
      }
    }
    else {
      lBuilder.append("\"com.anaptecs.jeaf.generator.JEAFGenerator\"");
    }
    return lBuilder.toString();
  }

  public static boolean generateValidAnnotationsForClasses( ) {
    return SystemProperties.getBooleanProperty(
        VALID_ANNOTATION_FOR_CLASSES, true);
  }

  public static boolean generateValidAnnotationsForAssociations( ) {
    return SystemProperties.getBooleanProperty(
        VALID_ANNOTATION_FOR_ASSOCIATIONS, true);
  }

  public static boolean generateValidationAnnotationsForAttributesFromMultiplicity( ) {
    return SystemProperties.getBooleanProperty(
        VALIDATION_ANNOTATION_FOR_ATTRIBUTES, true);
  }

  public static boolean generateValidationAnnotationsForAssociationsFromMultiplicity( ) {
    return SystemProperties.getBooleanProperty(
        VALIDATION_ANNOTATION_FOR_ASSOCIATIONS, true);
  }

  public static boolean generateObjectValidationInBuilder( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_OBJECT_VALIDATION_IN_BUILDER, true);
  }

  public static boolean suppressClassNameCommentInOpenAPISpec( ) {
    return SystemProperties.getBooleanProperty(
        SUPPRESS_CLASSNAME_IN_OPENAPI, true);
  }

  public static boolean generatePublicSettersForAssociations( ) {
    return SystemProperties.getBooleanProperty(GENERATE_PUBLIC_SETTERS,
        false);
  }

  public static boolean generateOfOperation( ) {
    return SystemProperties
        .getBooleanProperty(GENERATE_OF_OPERATION, false);
  }

  public static boolean generateOfOperationForOpenAPIDataType( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_OF_OPERATION_FOR_OPENAPI_DATATYPE, false);
  }

  public static boolean generateValueOfForOpenAPIDataTypes( ) {
    return SystemProperties.getBooleanProperty(GENERATE_VALUE_OF, false);
  }

  public static boolean generateNullChecksForToOneAssociationsOfServiceObjects( ) {
    return SystemProperties
        .getBooleanProperty(
            GENERATE_NULL_CHECKS_FOR_TO_ONE_ASSOCIATIONS_OF_SERVICE_OBJECTS,
            true);
  }

  public static boolean generatePublicObjectView( ) {
    return SystemProperties.getBooleanProperty(GENERATE_PUBLIC_OBJECT_VIEW,
        true);
  }

  public static boolean useArraysOnlyForPrimitives( ) {
    return SystemProperties.getBooleanProperty(
        "switch.gen.arrays.for.primitives.only", false);
  }

  public static boolean disableCollectionImmutability( ) {
    return SystemProperties.getBooleanProperty(
        DISABLE_COLLECTION_IMMUTABILITY, false);
  }

  public static boolean disableArrayImmutability( ) {
    return SystemProperties.getBooleanProperty(DISABLE_ARRAY_IMMUTABILITY,
        false);
  }

  public static boolean disableBinaryDataImmutability( ) {
    return SystemProperties.getBooleanProperty(
        DISABLE_BINRAY_DATA_IMMUTABILITY, false);
  }

  public static boolean enableDetailedToString( ) {
    return SystemProperties.getBooleanProperty(ENABLE_DETAILED_TO_STRING,
        false);
  }

  public static boolean enableLegacyBuilderStyle( ) {
    return SystemProperties.getBooleanProperty(ENABLE_LEGACY_BUILDER_STYLE,
        false);
  }

  public static boolean generateBuilderMethodWithAllManadatoryFields( ) {
    return SystemProperties.getBooleanProperty(
        GENERATE_BUILDER_METHOD_WITH_ALL_MANDATORY_FIELDS, false);
  }

  public static String getMavenVersion( ) {
    return SystemProperties.getProperty(MAVEN_VERSION_PROPERTY, "unknown");
  }

  public static String getVersion( ) {
    return SystemProperties.getProperty(VERSION_PROPERTY, "unknown");
  }

  public static String getCompanyInfo( ) {
    return SystemProperties.getProperty(COMPANY_INFO_PROPERTY, "");
  }

  public static String getAuthor( ) {
    return SystemProperties.getProperty(AUTHOR_PROPERTY, "");
  }

  public static String getCopyrightTag( ) {
    return SystemProperties.getProperty(COPYRIGHT_PROPERTY, "");
  }

  public static String getFileHeader( ) {
    String lFileHeader = CLASS_INDENTATION + "/*";
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* "
        + GeneratorCommons.getCompanyInfo();
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* ";
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* "
        + GeneratorCommons.getCopyrightTag();
    lFileHeader = lFileHeader + LINE_SEPARATOR + "*/";
    return lFileHeader;
  }

  public static String getAllExtendedInterfaces(Interface pInterface) {
    final Iterator<Generalization> lIterator = pInterface
        .getGeneralizations().iterator();
    StringBuffer lBuffer = new StringBuffer();
    while (lIterator.hasNext()) {
      final Generalization lNextGeneralization = lIterator.next();
      lBuffer.append(Naming.getFullyQualifiedName(lNextGeneralization
          .getGeneral()));
      if (lIterator.hasNext()) {
        lBuffer.append(", ");
      }
    }
    return lBuffer.toString();
  }

  public static boolean isPort(Property pProperty) {
    boolean lIsPort = pProperty instanceof Port;
    return lIsPort;
  }

  public static boolean runChecks(NamedElement pElement, String pStereotype) {
    boolean lRunChecks = false;
    Package lPackage = pElement.getNearestPackage();

    NamedElement lOwner = (NamedElement) pElement.getOwner();

    // XFun.getTrace().info(
    // "Analyzing element " + pElement.getName() + " in package " +
    // ClassUtil.getPackageName(lPackage) + " Owner: "
    // + lOwner.getName());

    // Verify if checks should be run for the passed stereotype.
    if (GeneratorCommons.shouldStereotypeBeChecked(pStereotype) == true
        && GeneratorCommons.isInGeneratorWhitelist(lPackage) == true) {
      String lOwnerName = Naming.getFullyQualifiedName(lOwner);
      String lElementName = pElement.getName();
      String lFQN;
      if (lElementName != null && lElementName.isEmpty() == false) {
        if (lOwnerName != null && lOwnerName.isEmpty() == false) {
          lFQN = lOwnerName + "." + lElementName;
        }
        else {
          lFQN = lElementName;
        }
      }
      else {
        lFQN = lOwnerName + ":" + pElement.toString();
      }

      // Check for stereotypes
      if (pStereotype.length() > 0) {
        if (pElement instanceof Class || pElement instanceof Interface
            || pElement instanceof Component
            || pElement instanceof Enumeration
            || pElement instanceof EnumerationLiteral
            || pElement instanceof Activity
            || pElement instanceof Dependency
            || pElement instanceof Operation
            || pElement instanceof Property
            || pElement instanceof Parameter) {
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_ACTIVITY);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_APPLICATION_EXCEPTION);
          // lRunChecks = lRunChecks |
          // ClassUtil.isStereotypeApplied(lOwner,
          // ClassUtil.STEREOTYPE_COMPONENT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_DOMAIN_OBJECT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_JEAF_ENUMERATION);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(
                  pElement.getOwner(),
                  ClassUtil.STEREOTYPE_JEAF_ENUMERATION);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_JEAF_SERVICE);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_LOAD_STRATEGY);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_PERSISTENT_OBJECT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_POJO);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_QUERY_OBJECT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_SERVICE_OBJECT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_SERVICE_PROVIDER);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_SERVICE_PROVIDER_IMPL);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_SYSTEM_EXCEPTION);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_SYSTEM_EXCEPTION);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_PERSISTENCE_UNIT);
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  ClassUtil.STEREOTYPE_OBJECT_MAPPING);

          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "PersistentObject");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Role");

          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "ServiceObject");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "POJO");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "OpenAPI3Specification");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "OpenAPIType");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "OpenAPIDataType");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "OpenAPISecurityScheme");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "OpenAPIResponse");

          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "RESTResource");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "RESTOperation");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "PathParam");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "HeaderParam");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "QueryParam");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "CookieParam");

          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Size");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "DecimalMin");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "DecimalMax");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Min");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Max");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Digits");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "Negative");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "NegativeOrZero");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "PositiveOrZero");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "Positive");
          lRunChecks = lRunChecks
              | ClassUtil
                  .isStereotypeApplied(pElement, "Pattern");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Email");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "NotEmpty");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "AssertTrue");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "AssertFalse");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "NotBlank");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Past");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "PastOrPresent");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement,
                  "FutureOrPresent");
          lRunChecks = lRunChecks
              | ClassUtil.isStereotypeApplied(pElement, "Future");
        }
      }
      else {
        lRunChecks = true;
      }
    }
    // Nothing to do as element is not included in white list.
    else {
    }
    return lRunChecks;
  }

  public static boolean shouldStereotypeBeChecked(String pStereotype) {
    boolean lRunChecks;
    if ("POJO".equals(pStereotype)) {
      lRunChecks = generatePOJOs();
    }
    else if ("OpenAPIType".equals(pStereotype)
        || "OpenAPIDataType".equals(pStereotype)
        || "OpenAPI3Specification".equals(pStereotype)
        || "OpenAPIResponse".equals(pStereotype)) {
      lRunChecks = generateOpenAPISpec();
    }
    // JEAFEnumeration
    else if ("JEAFEnumeration".equals(pStereotype)) {
      lRunChecks = generateServiceObjects() | generatePOJOs()
          | generateDomainObjects();
    }
    // JEAFComponent
    else if ("JEAFComponent".equals(pStereotype)) {
      lRunChecks = generateComponentImplClasses()
          | generateComponentRuntimeClasses();
    }
    // DomainObject
    else if ("DomainObject".equals(pStereotype)) {
      lRunChecks = generateDomainObjects();
    }
    // PersistentObject
    else if ("PersistentObject".equals(pStereotype)
        || "Role".equals(pStereotype)) {
      lRunChecks = generatePersistentObjects();
    }
    // ServiceObject, QueryObject
    else if ("ServiceObject".equals(pStereotype)
        || "QueryObject".equals(pStereotype)) {
      lRunChecks = generateServiceObjects();
    }
    // JEAFService
    else if ("JEAFService".equals(pStereotype)) {
      lRunChecks = generateServices() || generateServiceProxies();
    }
    // JEAFActivity
    else if ("JEAFActivity".equals(pStereotype)) {
      lRunChecks = generateActivityInterfaces() | generateActivityImpls();
    }
    // RESTOperation or REST params
    else if ("RESTResource".equals(pStereotype)
        || "RESTOperation".equals(pStereotype)
        || "PathParam".equals(pStereotype)
        || "QueryParam".equals(pStereotype)
        || "HeaderParam".equals(pStereotype)
        || "CookieParam".equals(pStereotype)) {
      lRunChecks = generateRESTResources() | generateOpenAPISpec();
    }
    // In case of reports selected here, there is no filtering based on
    // stereotype
    else if (generateRESTDeprecationReport()
        || generateJavaDeprecationReport()
        || generateBreakingChangesReport()) {
      lRunChecks = true;
    }
    else {
      lRunChecks = true;
    }

    return lRunChecks;
  }

  public static boolean isCharSequence(Type pTypedElement) {
    boolean lIsCharSequence;
    String lFullyQualifiedName = Naming
        .getFullyQualifiedName(pTypedElement);
    if ("String".equals(lFullyQualifiedName) == true) {
      lIsCharSequence = true;
    }
    else {
      try {
        java.lang.Class<?> lClass = java.lang.Class
            .forName(lFullyQualifiedName);
        lIsCharSequence = CharSequence.class.isAssignableFrom(lClass);
      }
      catch (ClassNotFoundException e) {
        lIsCharSequence = false;
      }
    }
    return lIsCharSequence;
  }

  public static boolean isNumericForAnnotation(Type pTypedElement) {
    String lFullyQualifiedName = Naming
        .getFullyQualifiedName(pTypedElement);
    return NUMERIC_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static boolean isDateForAnnotation(Type pTypedElement) {
    String lFullyQualifiedName = Naming
        .getFullyQualifiedName(pTypedElement);
    return DATE_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static boolean isBooleanForAnnotation(Type pTypedElement) {
    String lFullyQualifiedName = Naming
        .getFullyQualifiedName(pTypedElement);
    return BOOLEAN_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static TargetRuntime getTargetRuntime( ) {
    String lValue = SystemProperties.getProperty(TARGET_RUNTIME, null);
    TargetRuntime lTargetRuntime;
    if (lValue != null) {
      lTargetRuntime = TargetRuntime.valueOf(lValue.toUpperCase());
    }
    else {
      lTargetRuntime = TargetRuntime.JEAF;
    }

    return lTargetRuntime;
  }

  public static EnterpriseJavaType getEnterpriseJavaType( ) {
    String lValue = SystemProperties
        .getProperty(ENTERPRISE_JAVA_TYPE, null);
    EnterpriseJavaType lEnterpriseJavaType;
    if (lValue != null) {
      lEnterpriseJavaType = EnterpriseJavaType.valueOf(lValue
          .toUpperCase());
    }
    else {
      lEnterpriseJavaType = EnterpriseJavaType.JAVA_EE;
    }

    return lEnterpriseJavaType;
  }

  public static String getEnterpriseJavaPackage( ) {
    EnterpriseJavaType lEnterpriseJavaType = GeneratorCommons
        .getEnterpriseJavaType();
    String lPackage;
    switch (lEnterpriseJavaType) {
      case JAVA_EE:
        lPackage = "javax";
        break;

      case JAKARTA_EE:
        lPackage = "jakarta";
        break;

      default:
        Assert
            .internalError("Unexpected literal for enum EnterpriseJavaType: "
                + lEnterpriseJavaType.name());
        lPackage = "error";
    }
    return lPackage;
  }

  public static boolean isTargetRuntimeJEAF( ) {
    return getTargetRuntime() == TargetRuntime.JEAF;
  }

  public static boolean isTargetRuntimeSpring( ) {
    return getTargetRuntime() == TargetRuntime.SPRING;
  }

  public static boolean isTargetRuntimeJava( ) {
    return getTargetRuntime() == TargetRuntime.JAVA;
  }

  public static RESTLibrary getRESTLibrary( ) {
    String lValue = SystemProperties.getProperty(REST_LIBRARY, null);
    RESTLibrary lRESTLibrary;
    if (lValue != null) {
      lRESTLibrary = RESTLibrary.valueOf(lValue.toUpperCase());
    }
    else {
      if (isTargetRuntimeSpring()) {
        lRESTLibrary = RESTLibrary.SPRING_WEB_MVC;
      }
      else {
        lRESTLibrary = RESTLibrary.JAX_RS;
      }
    }

    return lRESTLibrary;
  }

  public static boolean isRESTLibraryJAXRS( ) {
    return getRESTLibrary() == RESTLibrary.JAX_RS;
  }

  public static boolean isRESTLibrarySpringWebMVC( ) {
    return getRESTLibrary() == RESTLibrary.SPRING_WEB_MVC;
  }

  public static Integer getRESTDefaultSuccessStatusCode( ) {
    return Integer.valueOf(SystemProperties.getProperty(
        REST_DEFAULT_SUCCESS_STATUS_CODE, "200"));
  }

  public static Integer getRESTDefaultVoidStatusCode( ) {
    return Integer.valueOf(SystemProperties.getProperty(
        REST_DEFAULT_VOID_STATUS_CODE, "204"));
  }

  public static boolean isEnumeration(Element pElement) {
    return pElement instanceof Enumeration;
  }

  public static List<Slot> getOrderedSlots(EnumerationLiteral pLiteral) {
    Map<Property, Slot> lSlotsByProperty = new HashMap<Property, Slot>();
    Iterator<Slot> lIterator = pLiteral.getSlots().iterator();
    while (lIterator.hasNext()) {
      Slot lNextSlot = lIterator.next();
      lSlotsByProperty.put((Property) lNextSlot.getDefiningFeature(),
          lNextSlot);
    }
    List<Slot> lOrderdSlots = new ArrayList<Slot>(lSlotsByProperty.size());
    Enumeration lEnumeration = (Enumeration) pLiteral.getOwner();
    Iterator<Property> lAttrIter = lEnumeration.getAttributes().iterator();
    while (lAttrIter.hasNext()) {
      Property lProperty = lAttrIter.next();
      Slot lSlot = lSlotsByProperty.get(lProperty);
      lOrderdSlots.add(lSlot);
    }
    return lOrderdSlots;
  }

  public static List<String> getMissingMandatorySlots(
      EnumerationLiteral pLiteral) {
    List<String> lMandatoryAttributes = new ArrayList<String>();
    Enumeration lEnumeration = (Enumeration) pLiteral.getOwner();
    Iterator<Property> lPropertyIterator = lEnumeration.getAttributes()
        .iterator();
    while (lPropertyIterator.hasNext()) {
      Property lProperty = lPropertyIterator.next();
      if (lProperty.getLower() > 0) {
        lMandatoryAttributes.add(lProperty.getName());
      }
    }

    Iterator<Slot> lSlotIterator = pLiteral.getSlots().iterator();
    while (lSlotIterator.hasNext()) {
      lMandatoryAttributes.remove(lSlotIterator.next()
          .getDefiningFeature().getName());
    }
    return lMandatoryAttributes;
  }

  public static String getMessage(NamedElement pElement, String pErrorCode,
      List<String> pParams) {
    MessageRepository lMessageRepository = MessageRepository
        .getMessageRepository();
    ErrorCode lErrorCode = lMessageRepository.getErrorCode(Integer
        .valueOf(pErrorCode));
    String lMessage = lErrorCode.toString(pParams.toArray(new String[] {}));
    String lElementName = Naming.getFullyQualifiedName(pElement);
    if (lElementName == null || lElementName.isEmpty()
        || lElementName.equals("unknown")) {
      lElementName = "unnamed "
          + pElement.getClass().getSimpleName()
          + " in package "
          + Naming
              .getFullyQualifiedName(pElement.getNearestPackage());
    }
    return "[" + pErrorCode + "] " + lMessage + " (Model element: "
        + lElementName + ")     ";
  }

  public static String getJavaDefaultValue(Property pProperty) {
    String lStringValue = pProperty.getDefaultValue().stringValue();
    String lTypeName = Naming.getFullyQualifiedName(pProperty);
    if ("java.lang.String".equals(lTypeName) || "String".equals(lTypeName)) {
      if (lStringValue.startsWith("\"") == false) {
        lStringValue = "\"" + lStringValue;
      }
      if (lStringValue.endsWith("\"") == false) {
        lStringValue = lStringValue + "\"";
      }
    }
    return lStringValue;
  }

  public static boolean isLocalDate(String pString) {
    return asLocalDate(pString) != null;
  }

  private static LocalDate asLocalDate(String pString) {
    LocalDate lDate;
    try {
      lDate = LocalDate.parse(pString, DateTimeFormatter.ISO_LOCAL_DATE);
    }
    catch (DateTimeParseException e) {
      lDate = null;
    }
    return lDate;
  }

  public static boolean isOverdue(String pReferenceDate, String pActualDate) {
    if (pReferenceDate != null && isLocalDate(pReferenceDate) && pActualDate != null && isLocalDate(pActualDate)) {
      return !asLocalDate(pReferenceDate).isAfter(asLocalDate(pActualDate));
    }
    else {
      return false;
    }
  }
}
