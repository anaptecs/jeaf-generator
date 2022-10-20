/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
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

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.date.DateTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.config.Configuration;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

public class GeneratorCommons {
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

  /**
   * Constant defines the name of the system property which enables the generation of serializable POJOs from the model.
   */
  public static final String MAKE_POJO_SERIALIZABLE_PROPERTY = "switch.gen.serializable.pojos";

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
   * Constant defines the name of the system property that enables legacy builder style.
   */
  public static final String ENABLE_LEGACY_BUILDER_STYLE = "switch.gen.enable.legacy.builder.style";

  /**
   * Constant defines the name of the system property which enables the generation of JUnit tests for services.
   */
  public static final String JUNIT_PROPERTY = "switch.gen.junits";

  /**
   * Constant defines the name of the system property which enables the generation of OpenAPI specifications.
   */
  public static final String OPEN_API_SPEC_PROPERTY = "switch.gen.openapispec";

  /**
   * Constant defines the name of the system property which enables YAML 1.1 compatibility mode for OpenAPI.
   */
  public static final String OPEN_API_YAML_11_COMPATIBILITY = "switch.gen.openapi.yaml.11.comapitibility";

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

  public static final String REST_LIBRARY = "switch.gen.target.rest.library";

  public static final String GENERATION_COMMENT = "switch.gen.generation.comment";

  public static final String VALID_ANNOTATION_FOR_CLASSES = "switch.gen.enable.valid.annotation.classes";

  public static final String VALIDATION_ANNOTATION_FOR_ATTRIBUTES =
      "switch.gen.enable.validation.annotation.attributes";

  public static final String VALIDATION_ANNOTATION_FOR_ASSOCIATIONS =
      "switch.gen.enable.validation.annotation.associations";

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
  public static List<Property> getAllAttributes( org.eclipse.uml2.uml.Class pClass ) {
    // Check parameter
    Assert.assertNotNull(pClass, "pClass");

    List<Property> lAttributeSet = new ArrayList<Property>();
    lAttributeSet.addAll(pClass.getOwnedAttributes());

    // Traverse through class hierarchy to all super classes.
    final Iterator<org.eclipse.uml2.uml.Class> lIterator = pClass.getSuperClasses().iterator();
    while (lIterator.hasNext()) {
      // Get super class and resolve all attributes.
      org.eclipse.uml2.uml.Class lSuperClass = lIterator.next();
      lAttributeSet.addAll(GeneratorCommons.getAllAttributes(lSuperClass));
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
  public static boolean isAssignable( org.eclipse.uml2.uml.Class pChild, org.eclipse.uml2.uml.Class pClass ) {
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
        lResult = GeneratorCommons.isAssignable(lNextSuperClass, pClass);
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
  public static boolean isRealInitValue( Property pProperty ) {
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
  public static boolean isMayBeInPackageWhitelist( Package pPackage ) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pPackage, "pPackage");

    // Check if system property is defined.
    // TODO Move this check to class ResourceAccessProvider.
    String lPropertyTest = System.getProperty(GENERATOR_WHITELIST_PROPERTY);
    boolean lIsInWhitelist;

    // Get white list as it is defined as system property
    if (lPropertyTest != null) {
      Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
      List<String> lPackageNames =
          lConfiguration.getConfigurationValueList(GENERATOR_WHITELIST_PROPERTY, false, String.class);

      // Check if white list is empty. This means that all packages should be generated.
      if (lPackageNames.size() > 0) {
        lIsInWhitelist = false;

        // Get fully qualified name of the passed package.
        String lPackageName = ClassUtil.getPackageName(pPackage);

        for (String lNextWhitelistEntry : lPackageNames) {
          // Get next white list entry and check if it matches with the passed package
          if (lPackageName.startsWith(lNextWhitelistEntry) == true
              || lNextWhitelistEntry.startsWith(lPackageName) == true) {
            // White list entry and package match.
            lIsInWhitelist = true;
            break;
          }
        }
      }
      // No entries in white list defined and thus all packages will be accepted.
      else {
        lIsInWhitelist = true;
      }
    }
    // System property is not defined and thus all packages will be accepted.
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
  public static boolean isInGeneratorWhitelist( NamedElement pNamedElement ) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pNamedElement, "pNamedElement");

    // Check if system property is defined.
    // TODO Move this check to class ResourceAccessProvider.
    String lPropertyTest = System.getProperty(GENERATOR_WHITELIST_PROPERTY);
    boolean lIsInWhitelist;

    // Get white list as it is defined as system property
    if (lPropertyTest != null) {
      Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
      List<String> lPackageNames =
          lConfiguration.getConfigurationValueList(GENERATOR_WHITELIST_PROPERTY, false, String.class);

      // Check if white list is empty. This means that all packages should be generated.
      if (lPackageNames.size() > 0) {
        lIsInWhitelist = false;

        // Get fully qualified name of the passed package.
        String lPackageName = ClassUtil.getPackageName(pNamedElement.getNearestPackage());

        for (String lNextWhitelistEntry : lPackageNames) {
          // Get next white list entry and check if it matches with the passed package
          if (lPackageName.startsWith(lNextWhitelistEntry) == true) {
            // White list entry and package match.
            lIsInWhitelist = true;
            break;
          }
        }
      }
      // No entries in white list defined and thus all packages will be accepted.
      else {
        lIsInWhitelist = true;
      }
    }
    // System property is not defined and thus all packages will be accepted.
    else {
      lIsInWhitelist = true;
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
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(CUSTOM_CONSTRAINTS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether services from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServices( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SERVICES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service proxies from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServiceProxies( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SERVICE_PROXIES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateServiceProviderInterfaces( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SERVICE_PROVIDER_INTERFACES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateServiceProviderImpls( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SERVICE_PROVIDER_IMPLS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTResources( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(REST_RESOURCES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static String getRESTPathPrefix( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(REST_PATH_PREFIX_PROPERTY, "", String.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTServiceProxies( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(REST_SERVICE_PROXY_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service provider interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if service provider interfaces should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateRESTServiceProxyConfigFile( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(REST_SERVICE_PROXY_CONFIG_FILE_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether activity interfaces from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if activity interfaces should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateActivityInterfaces( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ACTIVITY_INTERFACES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether activity implementations from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if activity implementations should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateActivityImpls( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ACTIVITY_IMPLS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateServiceObjects( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SERVICE_OBJECTS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether POJOs from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if POJOs should be generated from the model and false in all other cases.
   */
  public static boolean generatePOJOs( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(POJO_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether generated POJOs should be serializable.
   * 
   * @return boolean Method returns true if POJOs should be serializable.
   */
  public static boolean makePOJOsSerializable( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(MAKE_POJO_SERIALIZABLE_PROPERTY, Boolean.FALSE, Boolean.class);
  }

  /**
   * Method checks whether exception classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if exception classes should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateExceptionClasses( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(EXCEPTION_CLASSES_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateDomainObjects( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(DOMAIN_OBJECTS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether object mappers from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if object mappers should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateObjectMappers( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(OBJECT_MAPPERS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether component implementation classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if component implementation classes should be generated from the model and
   * false in all other cases.
   */
  public static boolean generateComponentImplClasses( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(COMPONENT_IMPLS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether component runtime classes from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if component runtime classes should be generated from the model and false in
   * all other cases.
   */
  public static boolean generateComponentRuntimeClasses( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(COMPONENT_RUNTIME_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether service objects from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if public parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generatePersistentObjects( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(PERSISTENT_OBJECTS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether the global parts from the UML model should be generated or not.
   * 
   * @return boolean Method returns true if gloabal parts should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateGlobalParts( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(GLOBAL_PARTS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether JUnit test should be generated for every service or not.
   * 
   * @return boolean Method returns true if JUnit tests should be generated from the model and false in all other cases.
   */
  public static boolean generateJUnitTests( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(JUNIT_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether OpenAPI specification should be generated for every service or not.
   * 
   * @return boolean Method returns true if OpenAPI spec should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateOpenAPISpec( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(OPEN_API_SPEC_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether YAML 1.1 compatibility mode for OpenAPI should be enabled.
   * 
   * @return boolean Method returns true if YAML 1.1 compatibility mode should be enabled and false in all other cases.
   */
  public static boolean enableYAML11Compatibility( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(OPEN_API_YAML_11_COMPATIBILITY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether JAX-RS Annotations for should be generated.
   * 
   * @return boolean Method returns true if JAX-RS Annotations should be generated from the model and false in all other
   * cases.
   */
  public static boolean generateJAXRSAnnotations( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(JAX_RS_ANNOTATIONS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  /**
   * Method checks whether Jackson Annotations for (JSON serialization) should be generated.
   * 
   * @return boolean Method returns true if Jackson Annotations should be generated from the model and false in all
   * other cases.
   */
  public static boolean generateJacksonAnnotations( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(JACKSON_ANNOTATIONS_PROPERTY, Boolean.TRUE, Boolean.class);
  }

  public static boolean enableSemVerForJSON( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ENABLE_SEMVER_FOR_JSON, Boolean.TRUE, Boolean.class);
  }

  public static boolean generateJSONSerializers( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(JSON_SERIALIZERS, Boolean.TRUE, Boolean.class);
  }

  public static boolean generateConstantsForAttributeNames( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(NAME_CONSTANTS_FOR_ATTRIBUTES, Boolean.TRUE, Boolean.class);
  }

  public static List<String> getSuppressedWarnings( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValueList(SUPPRESS_WARNINGS_LIST, String.class);
  }

  public static boolean suppressAllWarnings( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SUPPRESS_ALL_WARNINGS, Boolean.TRUE, Boolean.class);
  }

  public static boolean addGeneratedAnnotation( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ADD_GENERATED_ANNOTATION, Boolean.TRUE, Boolean.class);
  }

  public static boolean addGenerationTimestamp( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ADD_GENERATION_TIMESTAMP, Boolean.TRUE, Boolean.class);
  }

  public static String getGenerationComment( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(GENERATION_COMMENT, "", String.class);
  }

  public static String getGeneratedAnnotation( ) {
    StringBuilder lBuilder = new StringBuilder();
    if (addGenerationTimestamp() || getGenerationComment().isEmpty() == false) {
      lBuilder.append("value = \"com.anaptecs.jeaf.generator.JEAFGenerator\", ");

      if (addGenerationTimestamp()) {
        DateTools lDateTools = Tools.getDateTools();
        Calendar lTimestamp = lDateTools.newCalendar();
        lBuilder.append("date = \"");
        lBuilder.append(lDateTools.toTimestampString(lTimestamp));
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
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(VALID_ANNOTATION_FOR_CLASSES, Boolean.TRUE, Boolean.class);
  }

  public static boolean generateValidationAnnotationsForAttributesFromMultiplicity( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(VALIDATION_ANNOTATION_FOR_ATTRIBUTES, Boolean.TRUE, Boolean.class);
  }

  public static boolean generateValidationAnnotationsForAssociationsFromMultiplicity( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(VALIDATION_ANNOTATION_FOR_ASSOCIATIONS, Boolean.TRUE, Boolean.class);
  }

  public static boolean suppressClassNameCommentInOpenAPISpec( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(SUPPRESS_CLASSNAME_IN_OPENAPI, Boolean.TRUE, Boolean.class);
  }

  public static boolean generatePublicSettersForAssociations( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(GENERATE_PUBLIC_SETTERS, Boolean.FALSE, Boolean.class);
  }

  public static boolean generateNullChecksForToOneAssociationsOfServiceObjects( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(GENERATE_NULL_CHECKS_FOR_TO_ONE_ASSOCIATIONS_OF_SERVICE_OBJECTS,
        Boolean.TRUE, Boolean.class);
  }

  public static boolean generatePublicObjectView( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(GENERATE_PUBLIC_OBJECT_VIEW, Boolean.TRUE, Boolean.class);
  }

  public static boolean disableCollectionImmutability( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(DISABLE_COLLECTION_IMMUTABILITY, Boolean.FALSE, Boolean.class);
  }

  public static boolean disableArrayImmutability( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(DISABLE_ARRAY_IMMUTABILITY, Boolean.FALSE, Boolean.class);
  }

  public static boolean disableBinaryDataImmutability( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(DISABLE_BINRAY_DATA_IMMUTABILITY, Boolean.FALSE, Boolean.class);
  }

  public static boolean enableLegacyBuilderStyle( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(ENABLE_LEGACY_BUILDER_STYLE, Boolean.FALSE, Boolean.class);
  }

  public static String getMavenVersion( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(MAVEN_VERSION_PROPERTY, true, String.class);
  }

  public static String getVersion( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(VERSION_PROPERTY, true, String.class);
  }

  public static String getCompanyInfo( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(COMPANY_INFO_PROPERTY, true, String.class);
  }

  public static String getAuthor( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(AUTHOR_PROPERTY, true, String.class);
  }

  public static String getCopyrightTag( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    return lConfiguration.getConfigurationValue(COPYRIGHT_PROPERTY, true, String.class);
  }

  public static String getFileHeader( ) {
    String lFileHeader = CLASS_INDENTATION + "/*";
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* " + GeneratorCommons.getCompanyInfo();
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* ";
    lFileHeader = lFileHeader + LINE_SEPARATOR + "* " + GeneratorCommons.getCopyrightTag();
    lFileHeader = lFileHeader + LINE_SEPARATOR + "*/";
    return lFileHeader;
  }

  public static String getJavadoc( Class pClass ) {
    String lFormattedComment = GeneratorCommons.getFormattedComment(pClass, CLASS_INDENTATION);
    String lJavadoc = CLASS_INDENTATION + "/**";
    lJavadoc = lJavadoc + lFormattedComment;
    lJavadoc = lJavadoc + LINE_SEPARATOR + CLASS_INDENTATION + " * @author " + GeneratorCommons.getAuthor();
    lJavadoc = lJavadoc + LINE_SEPARATOR + CLASS_INDENTATION + " * @version " + GeneratorCommons.getVersion();
    lJavadoc = lJavadoc + LINE_SEPARATOR + CLASS_INDENTATION + " */" + LINE_SEPARATOR;

    return lJavadoc;
  }

  public static String getJavadoc( Interface pInterface ) {
    String lFormattedComment = GeneratorCommons.getFormattedComment(pInterface, INTERFACE_INDENTATION);
    String lJavadoc = INTERFACE_INDENTATION + "/**";
    lJavadoc = lJavadoc + lFormattedComment;
    lJavadoc = lJavadoc + LINE_SEPARATOR + INTERFACE_INDENTATION + " * @author " + GeneratorCommons.getAuthor();
    lJavadoc = lJavadoc + LINE_SEPARATOR + INTERFACE_INDENTATION + " * @version " + GeneratorCommons.getVersion();
    lJavadoc = lJavadoc + LINE_SEPARATOR + INTERFACE_INDENTATION + " */" + LINE_SEPARATOR;

    return lJavadoc;
  }

  public static String getJavadoc( Operation pOperation ) {
    final String lIndentation = METHOD_INDENTATION;
    final String lNewLine = LINE_SEPARATOR + lIndentation + " * ";

    // Create Javadoc for method.
    String lJavadoc = lIndentation + "/**";

    // Get comment of method
    String lFormattedComment = GeneratorCommons.getFormattedComment(pOperation, lIndentation);
    lJavadoc = lJavadoc + lFormattedComment;
    lJavadoc = lJavadoc + lNewLine;

    final Parameter lReturnType = pOperation.getReturnResult();
    // Create comment for all parameters
    final Iterator<Parameter> lIterator = pOperation.getOwnedParameters().iterator();
    while (lIterator.hasNext()) {
      final Parameter lParameter = lIterator.next();
      if (lParameter != lReturnType) {
        String lComment = GeneratorCommons.getFormattedComment(lParameter, lIndentation);
        lJavadoc = lJavadoc + lNewLine + "@param " + lParameter.getName() + lComment;
      }
    }

    // Create comment for return type.
    if (lReturnType != null && "void".equals(lReturnType.getType().getName()) == false) {
      String lComment = GeneratorCommons.getFormattedComment(lReturnType, lIndentation);
      lJavadoc = lJavadoc + lNewLine + "@return {@link " + lReturnType.getType().getName() + "} " + lComment;
    }

    final Iterator<Type> lExceptionIterator = pOperation.getRaisedExceptions().iterator();
    while (lExceptionIterator.hasNext()) {
      final Type lNextException = lExceptionIterator.next();
      lJavadoc = lJavadoc + lNewLine + "@throws {@link " + lNextException.getName() + "}";
    }

    lJavadoc = lJavadoc + LINE_SEPARATOR + lIndentation + " */";
    return lJavadoc;
  }

  public static String getFormattedComment( Element pElement, String pIndentation ) {
    String lFormattedComment = "";
    final String lNewLine = LINE_SEPARATOR + pIndentation + " * ";
    for (Comment lNextComment : pElement.getOwnedComments()) {
      String lBody = lNextComment.getBody();
      if (lBody != null && lBody.length() > 0) {
        lFormattedComment = lFormattedComment + lNewLine + lBody.trim().replaceAll(LINE_SEPARATOR, lNewLine);
        // Add line for every comment
        lFormattedComment = lFormattedComment + lNewLine;
      }
    }
    return lFormattedComment;
  }

  public static String getAllExtendedInterfaces( Interface pInterface ) {
    final Iterator<Generalization> lIterator = pInterface.getGeneralizations().iterator();
    StringBuffer lBuffer = new StringBuffer();
    while (lIterator.hasNext()) {
      final Generalization lNextGeneralization = lIterator.next();
      lBuffer.append(Naming.getFullyQualifiedName(lNextGeneralization.getGeneral()));
      if (lIterator.hasNext()) {
        lBuffer.append(", ");
      }
    }
    return lBuffer.toString();
  }

  public static boolean isPort( Property pProperty ) {
    boolean lIsPort = pProperty instanceof Port;
    return lIsPort;
  }

  public static boolean runChecks( NamedElement pElement, String pStereotype ) {
    boolean lRunChecks = false;
    Package lPackage = pElement.getNearestPackage();

    NamedElement lOwner = (NamedElement) pElement.getOwner();

    // XFun.getTrace().info(
    // "Analyzing element " + pElement.getName() + " in package " + ClassUtil.getPackageName(lPackage));

    // Verify if checks should be run for teh passed stereotype.
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
        lFQN = pElement.toString();
      }

      // Check for stereotypes
      if (pElement instanceof Class || pElement instanceof Interface || pElement instanceof Component
          || pElement instanceof Enumeration || pElement instanceof Activity || pElement instanceof Dependency
          || pElement instanceof Operation || pElement instanceof Parameter) {
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_ACTIVITY);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_APPLICATION_EXCEPTION);
        // lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(lOwner, ClassUtil.STEREOTYPE_COMPONENT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_DOMAIN_OBJECT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_JEAF_ENUMERATION);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_JEAF_SERVICE);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_LOAD_STRATEGY);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_PERSISTENT_OBJECT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_POJO);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_QUERY_OBJECT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_SERVICE_OBJECT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_SERVICE_PROVIDER);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_SERVICE_PROVIDER_IMPL);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_SYSTEM_EXCEPTION);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_SYSTEM_EXCEPTION);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_PERSISTENCE_UNIT);
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, ClassUtil.STEREOTYPE_OBJECT_MAPPING);

        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "ServiceObject");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "POJO");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "OpenAPI3Specification");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "OpenAPIType");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "OpenAPIDataType");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "OpenAPISecurityScheme");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "OpenAPIResponse");

        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "RESTResource");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "RESTOperation");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "PathParam");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "HeaderParam");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "QueryParam");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "CookieParam");

        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Size");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "DecimalMin");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "DecimalMax");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Min");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Max");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Digits");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Negative");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "NegativeOrZero");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "PositiveOrZero");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Positive");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Pattern");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Email");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "NotEmpty");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "AssertTrue");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "AssertFalse");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "NotBlank");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Past");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "PastOrPresent");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "FutureOrPresent");
        lRunChecks = lRunChecks | ClassUtil.isStereotypeApplied(pElement, "Future");

        if (lRunChecks == false) {
          XFun.getTrace().debug("Ignoring " + lFQN);
        }
        else {
          XFun.getTrace().debug("Checking " + lFQN);
        }
      }
      else {
        XFun.getTrace().debug("Ignoring " + lFQN + " due to not supported type.");
      }
    }
    // Nothing to do as element is not included in white list.
    else {
    }
    return lRunChecks;
  }

  public static boolean shouldStereotypeBeChecked( String pStereotype ) {
    boolean lRunChecks;
    if ("POJO".equals(pStereotype)) {
      lRunChecks = generatePOJOs();
    }
    else if ("OpenAPIType".equals(pStereotype) || "OpenAPIDataType".equals(pStereotype)
        || "OpenAPI3Specification".equals(pStereotype) || "OpenAPIResponse".equals(pStereotype)) {
      lRunChecks = generateOpenAPISpec();
    }
    // JEAFEnumeration
    else if ("JEAFEnumeration".equals(pStereotype)) {
      lRunChecks = generateServiceObjects() | generatePOJOs() | generateDomainObjects();
    }
    // JEAFComponent
    else if ("JEAFComponent".equals(pStereotype)) {
      lRunChecks = generateComponentImplClasses() | generateComponentRuntimeClasses();
    }
    // DomainObject
    else if ("DomainObject".equals(pStereotype)) {
      lRunChecks = generateDomainObjects();
    }
    // PersistentObject
    else if ("PersistentObject".equals(pStereotype)) {
      lRunChecks = generatePersistentObjects();
    }
    // ServiceObject, QueryObject
    else if ("ServiceObject".equals(pStereotype) || "QueryObject".equals(pStereotype)) {
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
    else if ("RESTResource".equals(pStereotype) || "RESTOperation".equals(pStereotype)
        || "PathParam".equals(pStereotype) || "QueryParam".equals(pStereotype) || "HeaderParam".equals(pStereotype)
        || "CookieParam".equals(pStereotype)) {
      lRunChecks = generateRESTResources() | generateOpenAPISpec();
    }
    else {
      lRunChecks = true;
    }

    return lRunChecks;
  }

  public static boolean isCharSequence( Type pTypedElement ) {
    boolean lIsCharSequence;
    String lFullyQualifiedName = Naming.getFullyQualifiedName(pTypedElement);
    if ("String".equals(lFullyQualifiedName) == true) {
      lIsCharSequence = true;
    }
    else {
      try {
        java.lang.Class<?> lClass = java.lang.Class.forName(lFullyQualifiedName);
        lIsCharSequence = CharSequence.class.isAssignableFrom(lClass);
      }
      catch (ClassNotFoundException e) {
        lIsCharSequence = false;
      }
    }
    return lIsCharSequence;
  }

  public static boolean isNumericForAnnotation( Type pTypedElement ) {
    String lFullyQualifiedName = Naming.getFullyQualifiedName(pTypedElement);
    return NUMERIC_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static boolean isDateForAnnotation( Type pTypedElement ) {
    String lFullyQualifiedName = Naming.getFullyQualifiedName(pTypedElement);
    return DATE_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static boolean isBooleanForAnnotation( Type pTypedElement ) {
    String lFullyQualifiedName = Naming.getFullyQualifiedName(pTypedElement);
    return BOOLEAN_ANNOTATION_CLASSES.contains(lFullyQualifiedName);
  }

  public static TargetRuntime getTargetRuntime( ) {
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    String lValue = lConfiguration.getConfigurationValue(TARGET_RUNTIME, false, String.class);
    TargetRuntime lTargetRuntime;
    if (lValue != null) {
      lTargetRuntime = TargetRuntime.valueOf(lValue.toUpperCase());
    }
    else {
      lTargetRuntime = TargetRuntime.JEAF;
    }

    return lTargetRuntime;
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
    Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
    String lValue = lConfiguration.getConfigurationValue(REST_LIBRARY, false, String.class);
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

  public static boolean isEnumeration( Element pElement ) {
    return pElement instanceof Enumeration;
  }

  public static List<Slot> getOrderedSlots( EnumerationLiteral pLiteral ) {
    Map<Property, Slot> lSlotsByProperty = new HashMap<Property, Slot>();
    Iterator<Slot> lIterator = pLiteral.getSlots().iterator();
    while (lIterator.hasNext()) {
      Slot lNextSlot = lIterator.next();
      lSlotsByProperty.put((Property) lNextSlot.getDefiningFeature(), lNextSlot);
    }
    List<Slot> lOrderdSlots = new ArrayList<Slot>(lSlotsByProperty.size());
    Enumeration lEnumeration = (Enumeration) pLiteral.getOwner();
    Iterator<Property> lAttrIter = lEnumeration.getAttributes().iterator();
    while (lAttrIter.hasNext()) {
      Property lProperty = lAttrIter.next();
      Slot lSlot = lSlotsByProperty.get(lProperty);
      if (lSlot != null) {
        lOrderdSlots.add(lSlot);
      }
    }
    return lOrderdSlots;
  }

  public static String getMessage( NamedElement pElement, String pErrorCode, List<String> pParams, String pPrefix ) {
    MessageRepository lMessageRepository = XFun.getMessageRepository();
    ErrorCode lErrorCode = lMessageRepository.getErrorCode(Integer.valueOf(pErrorCode));
    String lMessage = lErrorCode.toString(pParams.toArray(new String[] {}));
    return pPrefix + "[" + pErrorCode + "] " + lMessage + " (Model element: " + Naming.getFullyQualifiedName(pElement)
        + ")     ";
  }
}
