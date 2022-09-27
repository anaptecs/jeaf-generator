/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.config.Configuration;

/**
 * Class for string manipulation operations. Methods with a well known signature are able to be accessed from
 * openarchitectureware extend files. Methods are accessed through *.ext files. Example: Method: public static String
 * getPackageName (Class pCls) { ... } is accessed through: String packageName (Class cls) : JAVA
 * oaw.extend.ClassUtil.getPackageName(org.openarchitectureware.meta.uml.classifier.Class); in the NamingConventions.ext
 * file from the directory template/java NamingConventions.ext can delegate requests to this class. Mehotds in *.ext
 * files can be accessed from expand templates.
 * 
 * @author JEAF Development Team
 * @version 1.0 $LastChangedBy: $ $LastChangedDate: $ $LastChangedRevision: $
 */
public class ClassUtil {
  public static final String STEREOTYPE_JEAF_SERVICE = "JEAFService";

  public static final String STEREOTYPE_SERVICE_OBJECT = "JMM::ServiceObject";

  public static final String STEREOTYPE_QUERY_OBJECT = "QueryObject";

  public static final String STEREOTYPE_JEAF_ENUMERATION = "JEAFEnumeration";

  public static final String STEREOTYPE_DOMAIN_OBJECT = "JMM::DomainObject";

  public static final String STEREOTYPE_PERSISTENT_OBJECT = "JMM::PersistentObject";

  public static final String STEREOTYPE_PERSISTENCE_UNIT = "JMM::PersistenceUnit";

  public static final String STEREOTYPE_POJO = "JMM::POJO";

  public static final String STEREOTYPE_COMPONENT = "JEAFComponent";

  public static final String STEREOTYPE_APPLICATION_EXCEPTION = "ApplicationException";

  public static final String STEREOTYPE_SYSTEM_EXCEPTION = "SystemException";

  public static final String STEREOTYPE_SERVICE_PROVIDER = "JEAFServiceProvider";

  public static final String STEREOTYPE_SERVICE_PROVIDER_IMPL = "JEAFServiceProviderImpl";

  public static final String STEREOTYPE_LOAD_STRATEGY = "LoadStrategy";

  public static final String STEREOTYPE_ACTIVITY = "JEAFActivity";

  private static final String APPLICATION_EXCEPTION_SUFFIX = "ApplicationException";

  public static final String STEREOTYPE_IDENTIFIABLE = "JMM::Identifiable";

  public static final String STEREOTYPE_OBJECT_MAPPING = "ObjectMapping";

  private static final String THROWS = "throws ";

  private static final String PARAMETER_SEPERATOR = ", ";

  public static final String OID_ROW_NAME = "OIDRowName";

  public static final String VERSION_LABEL_ROW_NAME = "VersionLabelRowName";

  private static final Map<String, java.lang.Class<?>> BASIC_TYPES;

  static {
    BASIC_TYPES = new HashMap<String, java.lang.Class<?>>();
    BASIC_TYPES.put(Boolean.class.getName(), Boolean.class);
    BASIC_TYPES.put(Boolean.class.getSimpleName(), Boolean.class);
    BASIC_TYPES.put(Byte.class.getName(), Byte.class);
    BASIC_TYPES.put(Byte.class.getSimpleName(), Byte.class);
    BASIC_TYPES.put(Short.class.getName(), Short.class);
    BASIC_TYPES.put(Short.class.getSimpleName(), Short.class);
    BASIC_TYPES.put(Integer.class.getName(), Integer.class);
    BASIC_TYPES.put(Integer.class.getSimpleName(), Integer.class);
    BASIC_TYPES.put(Long.class.getName(), Long.class);
    BASIC_TYPES.put(Long.class.getSimpleName(), Long.class);
    BASIC_TYPES.put(Float.class.getName(), Float.class);
    BASIC_TYPES.put(Float.class.getSimpleName(), Float.class);
    BASIC_TYPES.put(Double.class.getName(), Double.class);
    BASIC_TYPES.put(Double.class.getSimpleName(), Double.class);
    BASIC_TYPES.put(Character.class.getName(), Character.class);
    BASIC_TYPES.put(Character.class.getSimpleName(), Character.class);
    BASIC_TYPES.put(String.class.getName(), String.class);
    BASIC_TYPES.put(String.class.getSimpleName(), String.class);
    BASIC_TYPES.put(BigDecimal.class.getName(), BigDecimal.class);
    BASIC_TYPES.put(BigDecimal.class.getSimpleName(), BigDecimal.class);
    BASIC_TYPES.put(BigInteger.class.getName(), BigInteger.class);
    BASIC_TYPES.put(BigInteger.class.getSimpleName(), BigInteger.class);
  }

  public static String shortenParamList( String pParamList ) {
    String lShortenedParamList = pParamList.trim();
    if (lShortenedParamList.endsWith(",") == true) {
      lShortenedParamList =
          ClassUtil.shortenParamList(lShortenedParamList.substring(0, lShortenedParamList.length() - 1));
    }
    return lShortenedParamList;
  }

  /**
   * Returns the signature of parameters from the operation
   * 
   * @param pOperation the operation which provide the parameters are needed must not be null
   * @return String with the signature Example: Operation: public String doSomething(String pFirst, String pSecond, int
   * pThird) Returns: "String pFirst, String pSecond, int pThird"
   */
  public static String getParameterSignature( Operation pOperation ) {
    StringBuffer lBuffSignatur = new StringBuffer();
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);
    for (Parameter lNextParameter : lInputParameters) {
      lBuffSignatur.append(ClassUtil.getTypeName(lNextParameter));
      lBuffSignatur.append(" ");
      lBuffSignatur.append(lNextParameter.getName());
      lBuffSignatur.append(ClassUtil.PARAMETER_SEPERATOR);
    }
    String resultSignature = lBuffSignatur.toString();
    return ClassUtil.shortenParamList(resultSignature);
  }

  public static String getParameterTypeNames( Operation pOperation ) {
    StringBuffer lBuffSignatur = new StringBuffer();
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);

    if (lInputParameters.size() > 0) {
      for (Parameter lNextParameter : lInputParameters) {
        lBuffSignatur.append(ClassUtil.getTypeNameForReflection(lNextParameter));
        lBuffSignatur.append(".class");
        lBuffSignatur.append(ClassUtil.PARAMETER_SEPERATOR);
      }
    }
    else {
      lBuffSignatur.append("null");
    }
    String resultSignature = lBuffSignatur.toString();
    return ClassUtil.shortenParamList(resultSignature);
  }

  /**
   * Returns the name of the return type.
   * 
   * @param pOperation Operation with a return type.
   * @return String the name of the return type.
   */
  public static String getReturnType( Operation pOperation ) {
    Parameter lParam = pOperation.getReturnResult();
    if (lParam != null) {
      return ClassUtil.getTypeName(lParam);
    }
    else {
      throw new RuntimeException("Operation '" + pOperation.getName() + "(...)' does not contain a return type");
    }
  }

  /**
   * Returns the name of the parameters type. Checks if the parameter is multiple. If it is, "[]" us added.
   * 
   * @param pTypedElement The parameter. Parameter may be null.
   * @return String the name of the parameter's type.
   */
  public static String getTypeName( TypedElement pTypedElement ) {
    // Check parameter.
    Check.checkInvalidParameterNull(pTypedElement, "pParameter");

    MultiplicityElement lMultiplicityElement = (MultiplicityElement) pTypedElement;

    // if (pParameter.getType() != null) {
    String lTypePackage = getPackageName(pTypedElement.getType());

    // Generate default type name.
    String lTypeName = pTypedElement.getType().getName();
    String lFQN;
    if (lTypePackage != null && lTypePackage.length() > 0) {
      lFQN = lTypePackage + "." + lTypeName;
    }
    else {
      lFQN = lTypeName;
    }

    // Special handling for primitive types
    if (ClassUtil.isPrimitive(pTypedElement.getType()) == true) {
      lFQN = lFQN.toLowerCase();
    }
    // Handle return type void.
    else if ("MagicDraw Profile.datatypes.void".equals(lFQN)) {
      lFQN = "void";
    }
    // Default type name is already created.
    else if ("java.lang.Class".equals(lFQN) || lFQN.equals("Class")) {
      lFQN = "Class<?>";
    }

    // Find out if passed element is modeled as association or not.
    boolean lModeledAsAssociation;
    if (pTypedElement instanceof Property) {
      Property lProperty = (Property) pTypedElement;
      if (lProperty.getAssociation() != null) {
        lModeledAsAssociation = true;
      }
      else {
        lModeledAsAssociation = false;
      }
    }
    else {
      lModeledAsAssociation = false;
    }

    // Check if collection type is required
    boolean lCollectionRequired;
    if (pTypedElement instanceof Property) {
      // If properties are not modeled as association then the will be generated as simple arrays in case they are
      // multivalued.
      if (lModeledAsAssociation && lMultiplicityElement.isMultivalued()) {
        lCollectionRequired = true;
      }
      else {
        lCollectionRequired = false;
      }
    }
    // In case of parameters, primitive types will be represented as arrays all other types as collections.
    else if (pTypedElement instanceof Parameter) {
      // Parameter is not multivalued
      if (lMultiplicityElement.isMultivalued()) {
        if (ClassUtil.isPrimitive(pTypedElement.getType())) {
          lCollectionRequired = false;
        }
        else {
          lCollectionRequired = true;
        }
      }
      // Parameter is not multivalued
      else {
        lCollectionRequired = false;
      }
    }
    // In case of all other type of model elements we will work with collections only depending on their multiplicity.
    else {
      lCollectionRequired = lMultiplicityElement.isMultivalued();
    }

    if (lCollectionRequired) {
      lFQN = ClassUtil.getCollectionType(lMultiplicityElement) + "<" + lFQN + ">";
    }

    return lFQN;
  }

  public static String getCollectionType( MultiplicityElement lMultiplicityElement ) {
    String lReturnValue;
    if (lMultiplicityElement.isMultivalued()) {
      // Type is not unique and not ordered -> Collection
      if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == false) {
        lReturnValue = Collection.class.getName();
      }
      // Type is unique but not ordered.
      else if (lMultiplicityElement.isUnique() == true && lMultiplicityElement.isOrdered() == false) {
        lReturnValue = Set.class.getName();
      }
      // Type is not unique but ordered.
      else if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == true) {
        lReturnValue = List.class.getName();
      }
      // Type is unique and ordered.
      else {
        lReturnValue = SortedSet.class.getName();
      }
    }
    // Singular type.
    else {
      lReturnValue = "";
    }
    return lReturnValue;
  }

  public static String getCollectionTypeShort( MultiplicityElement lMultiplicityElement ) {
    String lReturnValue;
    if (lMultiplicityElement.isMultivalued()) {
      // Type is not unique and not ordered -> Collection
      if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == false) {
        lReturnValue = Collection.class.getSimpleName();
      }
      // Type is unique but not ordered.
      else if (lMultiplicityElement.isUnique() == true && lMultiplicityElement.isOrdered() == false) {
        lReturnValue = Set.class.getSimpleName();
      }
      // Type is not unique but ordered.
      else if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == true) {
        lReturnValue = List.class.getSimpleName();
      }
      // Type is unique and ordered.
      else {
        lReturnValue = SortedSet.class.getSimpleName();
      }
    }
    // Singular type.
    else {
      lReturnValue = "";
    }
    return lReturnValue;
  }

  /**
   * Returns the name of the parameters type. Checks if the parameter is multiple. If it is, "[]" us added.
   * 
   * @param pTypedElement The parameter. Parameter may be null.
   * @return String the name of the parameter's type.
   */
  public static String getTypeNameForReflection( TypedElement pTypedElement ) {
    // Check parameter.
    Check.checkInvalidParameterNull(pTypedElement, "pParameter");

    MultiplicityElement lMultiplicityElement = (MultiplicityElement) pTypedElement;
    String lReturnValue;

    String lTypePackage = getPackageName(pTypedElement.getType());
    String lTypeName = pTypedElement.getType().getName();

    // Generate default type name.
    String lFQN;
    if (lTypePackage != null && lTypePackage.length() > 0) {
      lFQN = lTypePackage + "." + lTypeName;
    }
    else {
      lFQN = lTypeName;
    }

    // Filter special types from modeling tool.
    if (ClassUtil.isPrimitive(pTypedElement.getType()) == true) {
      // Array of primitive type.
      if (lMultiplicityElement.isMultivalued()) {
        lReturnValue = lTypeName.toLowerCase() + "[]";
      }
      // primitive type
      else {
        lReturnValue = lTypeName.toLowerCase();
      }
    }
    // Handle return type void.
    else if ("MagicDraw Profile.datatypes.void".equals(lFQN)) {
      lReturnValue = "void";
    }
    else {
      // Max. Multiplicity of more than one
      if (lMultiplicityElement.isMultivalued()) {
        // Type is not unique and not ordered -> Collection
        if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == false) {
          lReturnValue = Collection.class.getName();
        }
        // Type is unique but not ordered.
        else if (lMultiplicityElement.isUnique() == true && lMultiplicityElement.isOrdered() == false) {
          lReturnValue = Set.class.getName();
        }
        // Type is not unique but ordered.
        else if (lMultiplicityElement.isUnique() == false && lMultiplicityElement.isOrdered() == true) {
          lReturnValue = List.class.getName();
        }
        // Type is unique and ordered.
        else {
          lReturnValue = SortedSet.class.getName();
        }
      }
      // Singular type.
      else {
        // Default type name is already created.
        lReturnValue = lFQN;
      }
    }
    // Return determined type.
    return lReturnValue;
  }

  public static boolean isSupportedReturnType( Operation pOperation ) {
    Parameter lReturnType = pOperation.getReturnResult();
    boolean lSupportedReturnType;
    if (lReturnType != null && lReturnType.getType() != null) {
      if (ClassUtil.isPrimitive(lReturnType.getType()) == true && lReturnType.isMultivalued() == true) {
        lSupportedReturnType = false;
      }
      else {
        lSupportedReturnType = true;
      }
    }
    else {
      lSupportedReturnType = false;
    }
    return lSupportedReturnType;
  }

  /**
   * Method checks if the class itself or one of its super classes has at least one readonly attribute or association.
   * 
   * @param pClass
   * @return
   */
  public static boolean hasReadOnlyProperties( Class pClass ) {
    EList<Property> lAllAttributes = pClass.getOwnedAttributes();
    Iterator<Property> lIterator = lAllAttributes.iterator();

    // If class implements Identifiable interface then it has readonly attributes.
    boolean lHasReadonlyAttributes = ClassUtil.implementsIdentifiable(pClass);

    // Class is not marked as identifiable thus we have to check every property.
    if (lHasReadonlyAttributes == false) {
      while (lIterator.hasNext()) {
        Property lNextAttribute = lIterator.next();
        if (lNextAttribute.isReadOnly() == true) {
          lHasReadonlyAttributes = true;
          break;
        }
      }

      if (pClass.getSuperClasses().isEmpty() == false && lHasReadonlyAttributes == false) {
        lHasReadonlyAttributes = ClassUtil.hasReadOnlyProperties(pClass.getSuperClasses().get(0));
      }
    }
    return lHasReadonlyAttributes;
  }

  public static boolean isStereotypeApplied( Class pClass, String pStereotypeName ) {
    // Check if this class is identifiable
    Stereotype lStereotype = pClass.getAppliedStereotype(pStereotypeName);
    boolean lStereotypeApplied;

    // Class is marked in UML model with stereotype POJO
    if (lStereotype != null) {
      lStereotypeApplied = true;
    }
    // Class is not marked as POJO.
    else {
      lStereotypeApplied = false;
    }
    return lStereotypeApplied;
  }

  public static boolean isPOJO( Class pClass ) {
    return ClassUtil.isStereotypeApplied(pClass, STEREOTYPE_POJO);
  }

  public static boolean isServiceObject( Class pClass ) {
    return ClassUtil.isStereotypeApplied(pClass, STEREOTYPE_SERVICE_OBJECT);
  }

  public static boolean isDomainObject( Class pClass ) {
    return ClassUtil.isStereotypeApplied(pClass, STEREOTYPE_DOMAIN_OBJECT);
  }

  public static boolean isPersistentObject( Class pClass ) {
    return ClassUtil.isStereotypeApplied(pClass, STEREOTYPE_PERSISTENT_OBJECT);
  }

  public static boolean hasPersistentClasses( Package pPackage ) {
    EList<Element> lOwnedElements = pPackage.getOwnedElements();
    boolean lHasPersistentClasses = false;
    for (int i = 0; i < lOwnedElements.size(); i++) {
      Element lNextElement = lOwnedElements.get(i);
      if (lNextElement instanceof Class) {
        lHasPersistentClasses = ClassUtil.isPersistentObject((Class) lNextElement);
        if (lHasPersistentClasses == true) {
          break;
        }
      }
    }
    return lHasPersistentClasses;
  }

  public static List<String> getPersistentClassNames( Package pPackage ) {
    EList<Element> lOwnedElements = pPackage.getOwnedElements();
    List<String> lClassNames = new ArrayList<String>(lOwnedElements.size());
    for (int i = 0; i < lOwnedElements.size(); i++) {
      Element lNextElement = lOwnedElements.get(i);
      if (lNextElement instanceof Class) {
        Class lNextClass = (Class) lNextElement;
        if (ClassUtil.isPersistentObject(lNextClass)) {
          lClassNames.add(Naming.getFullyQualifiedName(lNextClass));
        }
      }
    }
    Collections.sort(lClassNames);
    return lClassNames;
  }

  public static List<String> getPersistentClassesMappingFileNames( Package pPackage ) {
    EList<Element> lOwnedElements = pPackage.getOwnedElements();
    List<String> lClassNames = new ArrayList<String>(lOwnedElements.size());
    for (int i = 0; i < lOwnedElements.size(); i++) {
      Element lNextElement = lOwnedElements.get(i);
      if (lNextElement instanceof Class) {
        Class lNextClass = (Class) lNextElement;
        if (ClassUtil.isPersistentObject(lNextClass) && lNextClass.getSuperClasses().isEmpty()) {
          lClassNames.add(Naming.getFullyQualifiedName(lNextClass).replace('.', '/') + ".hbm.xml");
        }
      }
    }
    Collections.sort(lClassNames);
    return lClassNames;
  }

  /**
   * Method checks if the passed class needs to implement the interface Identifiable.
   * 
   * @param pClass Class that should be checked. The parameter must not be null.
   * @return boolean true if Identifiable needs to be implemented and false otherwise.
   */
  public static boolean needsToImplementIdentifiable( Class pClass ) {
    // If the parent of the passed class already implements interface Identifiable then its child class does not have
    // to do it as well.
    boolean lNeedsToImplement;
    if (pClass.parents().isEmpty() == false
        && ClassUtil.needsToImplementIdentifiable((Class) pClass.parents().get(0)) == true) {
      lNeedsToImplement = false;
    }
    // Parent class either does not exist or is not Identifiable.
    else {
      Stereotype lStereotype = pClass.getAppliedStereotype(STEREOTYPE_IDENTIFIABLE);
      if (lStereotype != null) {
        lNeedsToImplement = true;
      }
      else {
        lNeedsToImplement = false;
      }
    }
    return lNeedsToImplement;
  }

  /**
   * Method checks if the passed class implements the interface Identifiable directly or indirectly due to a parent
   * class that implements it.
   * 
   * @param pClass Class that should be checked. The parameter must not be null.
   * @return boolean true if Identifiable is implemented and false otherwise.
   */
  public static boolean implementsIdentifiable( Class pClass ) {
    // Check if this class is identifiable
    Stereotype lStereotype = pClass.getAppliedStereotype(STEREOTYPE_IDENTIFIABLE);
    boolean lIdentiable;

    // Class is marked in UML model with stereotype Identifiable
    if (lStereotype != null) {
      lIdentiable = true;
    }
    // Persistent objects are always identifiable.
    else if (ClassUtil.isPersistentObject(pClass) == true) {
      lIdentiable = true;
    }
    // The class itself is not marked Identifiable but maybe one of its super classes.
    else if (pClass.parents().isEmpty() == false) {
      lIdentiable = ClassUtil.implementsIdentifiable((Class) pClass.parents().get(0));
    }
    // Class is not marked as Identifiable and does not have super classes.
    else {
      lIdentiable = false;
    }
    return lIdentiable;
  }

  public static boolean hasReturnType( Operation pOperation ) {
    boolean lHasValidReturnType;
    Parameter lParam = pOperation.getReturnResult();
    if (lParam != null) {
      lHasValidReturnType = true;
    }
    else {
      lHasValidReturnType = false;
    }
    return lHasValidReturnType;
  }

  public static boolean hasOnlySupportedParamaterTypes( Operation pOperation ) {
    final Element lOwner = pOperation.getOwner();
    boolean lHasOnlySupportedTypes = true;

    if (ClassUtil.isStereotypeApplied(lOwner, "JEAFService")
        || ClassUtil.isStereotypeApplied(lOwner, "PersistentObject")
        || ClassUtil.isStereotypeApplied(lOwner, "DomainObject")
        || ClassUtil.isStereotypeApplied(lOwner, "ServiceObject")
        || ClassUtil.isStereotypeApplied(lOwner, "QueryObject")) {
      EList<Parameter> lParameters = pOperation.getOwnedParameters();

      for (Parameter lNextParam : lParameters) {
        Type lType = lNextParam.getType();
        if (lType == null) {
          lHasOnlySupportedTypes = false;
          break;
        }
        else {
          lHasOnlySupportedTypes = true;
        }
      }

    }
    return lHasOnlySupportedTypes;
  }

  public static boolean returnsPrimitiveType( Operation pOperation ) {
    // Get return type
    Parameter lReturnType = pOperation.getReturnResult();
    String lTypeName = ClassUtil.getTypeName(lReturnType);
    return ClassUtil.isPrimitive(lReturnType.getType()) & !"void".equals(lTypeName);
  }

  public static boolean isPrimitive( Type pType ) {
    boolean lIsPrimitive;
    String lTypePackage = getPackageName(pType);

    if (lTypePackage.isEmpty()) {
      String lTypeName = pType.getName();
      if (lTypeName.equalsIgnoreCase("boolean") || lTypeName.equalsIgnoreCase("byte")
          || lTypeName.equalsIgnoreCase("short") || lTypeName.equalsIgnoreCase("int")
          || lTypeName.equalsIgnoreCase("long") || lTypeName.equalsIgnoreCase("float")
          || lTypeName.equalsIgnoreCase("double") || lTypeName.equalsIgnoreCase("char")) {
        lIsPrimitive = true;
      }
      else {
        lIsPrimitive = false;
      }
    }
    else if (lTypePackage.endsWith("JavaPrimitiveTypes") || lTypePackage.endsWith("UMLPrimitiveTypes")
        || lTypePackage.endsWith("PrimitiveTypes")) {
      lIsPrimitive = true;
    }
    else {
      lIsPrimitive = false;
    }
    return lIsPrimitive;
  }

  public static String getPrimitiveDefaultValue( Property pProperty ) {
    String lTypeName = Naming.getFullyQualifiedName(pProperty);
    String lDefaultValue;
    if ("boolean".equals(lTypeName)) {
      lDefaultValue = "false";
    }
    else {
      lDefaultValue = "0";
    }
    return lDefaultValue;
  }

  public static boolean isBasicType( Type pType ) {
    String lPackageName = getPackageName(pType);
    String lFQN;
    if (lPackageName != null && lPackageName.length() > 0) {
      lFQN = lPackageName + "." + pType.getName();
    }
    else {
      lFQN = pType.getName();
    }
    return BASIC_TYPES.containsKey(lFQN);
  }

  public static String getCollectionImplType( MultiplicityElement pMultiplicityElement ) {
    // Check parameter
    Check.checkInvalidParameterNull(pMultiplicityElement, "pMultiplicityElement");

    String lReturnValue;
    if (pMultiplicityElement.isUnique() == false && pMultiplicityElement.isOrdered() == false) {
      lReturnValue = ArrayList.class.getName();
    }
    // Type is unique but not ordered.
    else if (pMultiplicityElement.isUnique() == true && pMultiplicityElement.isOrdered() == false) {
      lReturnValue = HashSet.class.getName();
    }
    // Type is not unique but ordered.
    else if (pMultiplicityElement.isUnique() == false && pMultiplicityElement.isOrdered() == true) {
      lReturnValue = ArrayList.class.getName();
    }
    // Type is unique and ordered.
    else {
      lReturnValue = TreeSet.class.getName();
    }
    return lReturnValue;
  }

  /**
   * Returns the comma separated names of parameters from a method, without converting them
   * 
   * @param pOperation must not be null
   * @return String with the comma separated parameters Example Operation: public String doSomething(String pFirst,
   * String pSecond, int pThird) Returns: "pFirst, pSecond, pThird"
   */
  public static String getParameterListNames( Operation pOperation ) {
    StringBuffer lBuffSignatur = new StringBuffer();
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);
    for (Parameter lNextParameter : lInputParameters) {
      lBuffSignatur.append(lNextParameter.getName());
      lBuffSignatur.append(ClassUtil.PARAMETER_SEPERATOR);
    }
    String resultSignature = lBuffSignatur.toString();
    return ClassUtil.shortenParamList(resultSignature);
  }

  /**
   * Returns the parameters from the operation as JavaDoc comment
   * 
   * @param pOperation the opereation which provide the parameters are needed must not be null
   * @return String with the JavaDoc Example: Operation: public String doSomething(String pFirst, String pSecond, int
   * pThird) Returns: *
   * @param pFirst String *
   * @param pSecond String *
   * @param pThird int
   */
  public static String getParameterJavaDoc( Operation pOperation ) {
    StringBuffer lBuffSignatur = new StringBuffer();
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);
    for (Parameter lNextParameter : lInputParameters) {
      lBuffSignatur.append("* @param ");
      lBuffSignatur.append(lNextParameter.getName());
      lBuffSignatur.append(" ");
      lBuffSignatur.append(ClassUtil.getTypeName(lNextParameter));
      lBuffSignatur.append(" \n");
    }
    String resultSignature = lBuffSignatur.toString();
    return ClassUtil.shortenParamList(resultSignature);
  }

  /**
   * Returns the comma separated names of parameters from a method, converts them to instance variables
   * 
   * @param pOperation must not be null
   * @return String with the comma separated parameters Example: Operation: public String doSomething(String pFirst,
   * String pSecond, int pThird) Returns: "first, second, third"
   */
  public static String getParameterListInstanceNames( Operation pOperation ) {
    StringBuffer lBuffSignatur = new StringBuffer();
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);
    for (Parameter lNextParameter : lInputParameters) {
      lBuffSignatur.append(Naming.fromParameterToInstance(lNextParameter));
      lBuffSignatur.append(ClassUtil.PARAMETER_SEPERATOR);
    }
    String resultSignature = lBuffSignatur.toString();
    return ClassUtil.shortenParamList(resultSignature);
  }

  /**
   * Returns the package path. Since classes from the magicdraw java14 profile have a base package called "JDK1.4
   * Classes" this package will be cut of during this procedure. Parent packages are accessed recursively.
   * 
   * @param pPackage the uml representation of a package
   * @return String toString() of the uml package
   */
  public static String getPackageName( Package pPackage ) {
    String lResult = new String();
    String lName = pPackage.getName();

    Package lNestingPackage = pPackage.getNestingPackage();
    if (lNestingPackage != null && lNestingPackage instanceof Model == false) {
      String lRecursiveResult = getPackageName(lNestingPackage);
      if (!"".equals(lRecursiveResult)) {
        lResult = lRecursiveResult + "." + lName;
      }
      else {
        lResult = lName;
      }
    }
    // Package does not have any more parents.
    else {
      // Package from model libraries are ignored for the qualified name.
      if (ClassUtil.isModelLibrary(pPackage) == false) {
        lResult = lName;
      }
    }
    return lResult;
  }

  public static boolean isModelLibrary( Package pPackage ) {
    // Check parameter
    Assert.assertNotNull(pPackage, "pPackage");

    boolean lIsLibrary;
    if (ClassUtil.isStereotypeApplied(pPackage, "ModelLibrary")
        || ClassUtil.isStereotypeApplied(pPackage, "modelLibrary")) {
      lIsLibrary = true;
    }
    else {
      lIsLibrary = false;
    }

    return lIsLibrary;
  }

  /**
   * Method returns the PersistenceUnit component that belongs to this component.
   * 
   * @param pComponent
   * @return
   */
  public static Component getPersistenceUnit( Component pComponent ) {
    final Iterator<Relationship> lIterator = pComponent.getRelationships().iterator();
    while (lIterator.hasNext()) {
      Relationship lRelationship = lIterator.next();

      if (lRelationship instanceof Dependency) {
        Dependency lDependency = (Dependency) lRelationship;

        final List<Element> lRelatedElements = lDependency.getTargets();
        final Iterator<Element> lIterator2 = lRelatedElements.iterator();
        while (lIterator2.hasNext()) {
          Element lElement = lIterator2.next();
          if (lElement instanceof Component && ClassUtil.isStereotypeApplied(lElement, "PersistenceUnit")) {
            return (Component) lElement;
          }
        }
      }
    }
    return null;
  }

  /**
   * Method returns the PersistenceUnit component that belongs to this component.
   * 
   * @param pComponent
   * @return
   */
  public static List<String> getInterceptors( Component pComponent ) {
    final Iterator<Relationship> lIterator = pComponent.getRelationships().iterator();
    List<String> lInterceptorClasses = new ArrayList<String>();
    while (lIterator.hasNext()) {
      Relationship lRelationship = lIterator.next();

      if (lRelationship instanceof Dependency) {
        Dependency lDependency = (Dependency) lRelationship;

        final List<Element> lRelatedElements = lDependency.getTargets();
        final Iterator<Element> lIterator2 = lRelatedElements.iterator();
        while (lIterator2.hasNext()) {
          Element lElement = lIterator2.next();
          if (lElement instanceof Class && ClassUtil.isStereotypeApplied(lElement, "Interceptor")) {
            lInterceptorClasses.add(Naming.getFullyQualifiedName((Class) lElement));
          }
        }
      }
    }
    Collections.sort(lInterceptorClasses);
    return lInterceptorClasses;
  }

  /**
   * Method checks wether the passed component has a persistence unit.
   * 
   * @param pComponent Component for which the check should be performed. The parameter must not be null.
   * @return boolean Method returns true if the component defines a dependency to a persistence unit and false in all
   * other cases.
   */
  public static boolean hasPersistenceUnit( Component pComponent ) {
    final Component lPersistenceUnit = ClassUtil.getPersistenceUnit(pComponent);
    Boolean lHasPersistenceUnit;
    if (lPersistenceUnit != null) {
      lHasPersistenceUnit = true;
    }
    else {
      lHasPersistenceUnit = false;
    }
    return lHasPersistenceUnit;
  }

  /**
   * Returns the package name for a type.
   * 
   * @param pType Type. A type objects can be passed here.
   * @return String the package name.
   */
  public static String getPackageName( org.eclipse.uml2.uml.NamedElement pType ) {
    if (pType.getNearestPackage() != null) {
      return getPackageName(pType.getNearestPackage());
    }
    else {
      return "";
    }
  }

  /**
   * Returns thrown Exceptions of an operation as String. Returns an empty string if the operation doesn't throw any
   * exceptions.
   * 
   * @param pOperation Operation. The operation with the wanted exceptions.
   * @return String Exceptions of the given operation. The String begins with throws and follows the exceptions
   * separated by a ",". Returns an empty String if the method doesn't throw any exceptions.
   */
  public static String getThrownExceptionsAsString( Operation pOperation ) {
    List<Type> lRaisedExceptions = pOperation.getRaisedExceptions();
    if (lRaisedExceptions.size() > 0) {
      StringBuffer lBuffer = new StringBuffer();
      lBuffer.append(ClassUtil.THROWS);
      Iterator<Type> lIterator = lRaisedExceptions.iterator();
      while (lIterator.hasNext()) {
        Type lException = lIterator.next();
        lBuffer.append(Naming.getFullyQualifiedName(lException) + ClassUtil.PARAMETER_SEPERATOR);
      }
      String lResult = lBuffer.toString();
      return ClassUtil.shortenParamList(lResult);
    }
    else {
      return "";
    }
  }

  /**
   * Returns thrown Exceptions of an operation as a list of Class-Objects.
   * 
   * @param pOperation Operation. The operation with the wanted exceptions.
   * @return List of the full qualified, thrown exception names of the given operation. Returns null if the operation
   * doesn't throw any exceptions.
   */
  public static List<String> getThrownExceptionsAsList( Operation pOperation ) {
    List<Type> lRaisedExceptions = pOperation.getRaisedExceptions();
    List<String> lExceptionNames = new ArrayList<String>();
    if (lRaisedExceptions.size() > 0) {
      StringBuffer lBuffer = new StringBuffer();
      lBuffer.append(ClassUtil.THROWS);
      Iterator<Type> lIterator = lRaisedExceptions.iterator();
      while (lIterator.hasNext()) {
        Type lException = lIterator.next();
        lExceptionNames.add(Naming.getFullyQualifiedName(lException));
      }

      return lExceptionNames;
    }
    else {
      return null;
    }
  }

  /**
   * Verifies whether this operation throws a ApplicationException or a subclass of it.
   * 
   * @param pOperation The operation with the exceptions.
   * @return true if this operation contains a ApplicationException, else returns false.
   */
  public static boolean throwsApplicationException( Operation pOperation ) {
    List<Type> lRaisedExceptions = pOperation.getRaisedExceptions();
    if (lRaisedExceptions.size() > 0) {
      Iterator<Type> lRaisedExIterator = lRaisedExceptions.iterator();
      boolean result = false;
      while (lRaisedExIterator.hasNext()) {
        Type lException = lRaisedExIterator.next();
        String lExceptionName = lException.getName();
        if (lExceptionName.endsWith(ClassUtil.APPLICATION_EXCEPTION_SUFFIX)) {
          result = true;
        }
      }
      return result;
    }
    return false;
  }

  /**
   * Returns the name of the subclass of the Exception which this operation raises. Supported are ApplicationException
   * and SystemException.
   * 
   * @param pOperation The operation with the exceptions.
   * @param pType The type of the exception, only "ApplicationException" and "SystemException" are supported.
   * @return String The name of the subclass of the Exception which this operation raises. If this operation doesn't
   * throw an Exception or a subclass of it it returns null.
   */
  public static String getExceptionName( Operation pOperation, String pType ) {
    List<Type> lRaisedExceptions = pOperation.getRaisedExceptions();
    if (lRaisedExceptions.size() > 0) {
      Iterator<Type> lRaisedExIterator = lRaisedExceptions.iterator();
      while (lRaisedExIterator.hasNext()) {
        Type lException = lRaisedExIterator.next();
        String lExceptionName = lException.getName();
        if (lExceptionName.endsWith(pType)) {
          String result = ClassUtil.getPackageName(lException) + "." + lExceptionName;
          return result;
        }
      }
      return null;
    }
    return null;
  }

  /**
   * Counts the JEAFServices in a component.
   * 
   * @param pComponent The component which JEAFServices should be counted.
   * @return String the count JEAFServices as string.
   */
  public static int countJeafServices( Component pComponent ) {
    int count = 0;
    Iterator<Interface> lRealizations = pComponent.getAllImplementedInterfaces().iterator();
    while (lRealizations.hasNext()) {
      Interface lRealizer = lRealizations.next();
      if (ClassUtil.isStereotypeApplied(lRealizer, ClassUtil.STEREOTYPE_JEAF_SERVICE)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Returns only the JEAF service interfaces of a component.
   * 
   * @param pComponent The component with the wanted JEAF services.
   * @return List A list with all JeafServices. The list is empty if this component doesn't contain any Jeaf services.
   */
  public static List<Interface> getJeafServices( Component pComponent ) {
    final List<Interface> lImplementedInterfaces = pComponent.getImplementedInterfaces();
    Iterator<Interface> lRealizations = lImplementedInterfaces.iterator();
    List<Interface> lJEAFServicesList = new ArrayList<Interface>(lImplementedInterfaces.size());
    while (lRealizations.hasNext()) {
      Interface lRealizer = lRealizations.next();
      if (ClassUtil.isStereotypeApplied(lRealizer, ClassUtil.STEREOTYPE_JEAF_SERVICE)) {
        Interface lJeafInterface = lRealizer;
        lJEAFServicesList.add(lJeafInterface);
      }
    }
    Collections.sort(lJEAFServicesList, new NamedElementComparator());
    return lJEAFServicesList;
  }

  /**
   * Returns only the JEAF service interfaces of a port.
   * 
   * @param pPort The component with the wanted JEAF services.
   * @return List A list with all JEAF Services. The list is empty if this component doesn't contain any JEAF services.
   */
  public static List<Interface> getJEAFServices( Port pPort ) {
    final List<Interface> lImplementedInterfaces = pPort.getProvideds();
    Iterator<Interface> lRealizations = lImplementedInterfaces.iterator();
    List<Interface> lJEAFServicesList = new ArrayList<Interface>(lImplementedInterfaces.size());
    while (lRealizations.hasNext()) {
      Interface lRealizer = lRealizations.next();
      if (ClassUtil.isStereotypeApplied(lRealizer, ClassUtil.STEREOTYPE_JEAF_SERVICE)) {
        Interface lJeafInterface = lRealizer;
        lJEAFServicesList.add(lJeafInterface);
      }
    }
    Collections.sort(lJEAFServicesList, new NamedElementComparator());
    return lJEAFServicesList;
  }

  /**
   * Method returns all JEAF Services that are either provided the the component itself or by the ports of the
   * component.
   * 
   * @param pComponent Component whose provided JEAF Services should be returned. The parameter must not be null.
   * @return {@link List} All JEAF Services that are provided by this component. The method never returns null and the
   * list is sorted by name.
   */
  public static List<Interface> getAllProvidedJEAFServices( Component pComponent ) {
    // Get all services that are provided by the component
    final List<Interface> lServices = ClassUtil.getJeafServices(pComponent);

    // Get services of all ports.
    for (Port lPort : pComponent.getOwnedPorts()) {
      final List<Interface> lServicesOfPort = ClassUtil.getJEAFServices(lPort);
      lServices.addAll(lServicesOfPort);
    }

    // Sort list and return all JEAF Services.
    Collections.sort(lServices, new NamedElementComparator());
    return lServices;
  }

  /**
   * Method checks the applied stereotypes on this classifier.
   * 
   * @param pClassifier Classifier The classifier which should be checked wether the stereotype is applied to it.
   * @param pStereoType String The stereotype which should be checked.
   * @return true if the passed stereotype is applied to this classifier. Else return false.
   */
  public static boolean isStereotypeApplied( Element pElement, String pStereotype ) {
    boolean lResult = false;
    Iterator<Stereotype> lStereoTypes = pElement.getAppliedStereotypes().iterator();
    while (lStereoTypes.hasNext()) {
      Stereotype lStereo = lStereoTypes.next();
      if (pStereotype.equals(lStereo.getName())) {
        lResult = true;
      }
    }
    return lResult;
  }

  /**
   * Method retrieves the applied stereotypes on this classifier.
   * 
   * @param pElement Element The classifier which should be checked whether the stereotype is applied to it.
   * @param pStereoType String The stereotype which should be checked.
   * @return Stereotype. If the passed stereotype by name is applied to this classifier the Stereotype is returned. Else
   * null will be returned.
   */
  public static Stereotype getAppliedStereotype( Element pElement, String pStereotype ) {
    Stereotype lResult = null;
    Iterator<Stereotype> lStereoTypes = pElement.getAppliedStereotypes().iterator();
    while (lStereoTypes.hasNext()) {
      Stereotype lStereo = lStereoTypes.next();
      if (pStereotype.equals(lStereo.getName())) {
        lResult = lStereo;
      }
    }
    return lResult;
  }

  /**
   * Method returns the required interfaces of the passed component sorted by name.
   * 
   * @param pComponent Component whose required services should be returned as sorted list. The parameter must not be
   * null.
   * @return {@link List} List containing the required interfaces sorted by name. The method never returns null.
   */
  public static List<Interface> getRequiredServicesSorted( Component pComponent ) {
    List<Interface> lInterfaces = new ArrayList<Interface>();
    lInterfaces.addAll(pComponent.getRequireds());

    Collections.sort(lInterfaces, new NamedElementComparator());
    return lInterfaces;
  }

  /**
   * Method returns the required interfaces of the passed component sorted by name.
   * 
   * @param pComponent Port whose required services should be returned as sorted list. The parameter must not be null.
   * @return {@link List} List containing the required interfaces sorted by name. The method never returns null.
   */
  public static List<Interface> getRequiredServicesSorted( Port pPort ) {
    List<Interface> lInterfaces = new ArrayList<Interface>();
    lInterfaces.addAll(pPort.getRequireds());

    Collections.sort(lInterfaces, new NamedElementComparator());
    return lInterfaces;
  }

  /**
   * Method returns all JEAF Services that are either required the the component itself or by the ports of the
   * component.
   * 
   * @param pComponent Component whose provided JEAF Services should be returned. The parameter must not be null.
   * @return {@link List} All JEAF Services that are required by this component. The method never returns null and the
   * list is sorted by name.
   */
  public static List<Interface> getAllRequiredJEAFServices( Component pComponent ) {
    // Get all required services of the component itself.
    final List<Interface> lServices = ClassUtil.getRequiredServicesSorted(pComponent);

    // Sort all services and return them.
    Collections.sort(lServices, new NamedElementComparator());
    return lServices;
  }

  /**
   * Method returns the name of all interfaces implemented by the passed class.
   * 
   * @param pClass
   * @return
   */
  public static String getImplementedInterfaces( Class pClass ) {
    EList<Interface> lInterfaces = pClass.getAllImplementedInterfaces();
    StringBuffer lResult = new StringBuffer("");
    Iterator<Interface> lIterator = lInterfaces.iterator();
    while (lIterator.hasNext()) {
      Interface lService = (Interface) lIterator.next();
      lResult.append(Naming.getFullyQualifiedName(lService));
      if (lIterator.hasNext()) {
        lResult.append(ClassUtil.PARAMETER_SEPERATOR);
      }
    }
    return lResult.toString();
  }

  /**
   * Checks class ids of all entities and service entities. Ensures that no class id is used twice in two direfent
   * classes. Returns a list with all used class ids with their class names.
   * 
   * @param pPackage Package. The package from which all classes should be checked.
   * @return List A list containing all class names and class ids separated by a semicolon.
   */
  public static List<String> getClassIDs( Package pPackage ) {

    final EList<Element> lAllOwnedElements = pPackage.getModel().allOwnedElements();
    // A map to store the class ids and the names of the classes.
    // A map shall guarantee the uniqueness of each key.
    Map<Integer, String> lIdsNames = new HashMap<Integer, String>();
    // The result is returned in a csv list
    List<String> lResult = new ArrayList<String>();
    // Get all containing elements
    Iterator<Element> lIterator = lAllOwnedElements.iterator();
    while (lIterator.hasNext()) {
      Element lObject = lIterator.next();
      // Take only the classes
      if (lObject instanceof org.eclipse.uml2.uml.Class) {
        org.eclipse.uml2.uml.Class lClass = (org.eclipse.uml2.uml.Class) lObject;
        // Take only the entities
        Stereotype lEntity = ClassUtil.getAppliedStereotype(lClass, "PersistentObject");
        if (lEntity != null) {
          // Get the tagged value
          Integer classId = (Integer) lClass.getValue(lEntity, "classID");
          // IDs and names are put into a map, so the uniqueness of ids is guaranteed
          if (lIdsNames.put(classId, Naming.getFullyQualifiedName(lClass)) != null) {
            throw new RuntimeException("The class ID: '" + classId + "' is used twice in the model");
          }
        }
      }
    }
    if (!lIdsNames.isEmpty()) {
      Iterator<Integer> lIDIterator = lIdsNames.keySet().iterator();
      while (lIDIterator.hasNext()) {
        Integer lClassID = lIDIterator.next();
        String lNextRow = lClassID.toString() + ";" + lIdsNames.get(lClassID);
        lResult.add(lNextRow);
      }
    }
    Collections.sort(lResult);
    return lResult;
  }

  /**
   * Checks whether the passed parameter Property is valid. This method should only be called if this property is an
   * association end of a bidirectional many to many relationship. It is valid if only one association end has the name
   * of the link table between this two classes. If both link table tags are empty or both aren't empty false is
   * returned.
   * 
   * @param pProperty the association end of an many to many association.
   * @return boolean
   */
  public static boolean isTableValid( Property pProperty ) {
    Stereotype lAssEnd = ClassUtil.getAppliedStereotype(pProperty, "Role");
    // The passed property is an association end
    if (lAssEnd != null) {
      Property lOpposite = pProperty.getOpposite();
      String thisLinkTable = (String) pProperty.getValue(lAssEnd, "linkTable");
      String oppositeLinkTable = (String) lOpposite.getValue(lAssEnd, "linkTable");

      NamedElement lOwner = (NamedElement) pProperty.getOwner();
      XFun.getTrace().info(
          "Checking database table settings for class " + Naming.getFullyQualifiedName(lOwner) + "."
              + pProperty.getName());

      if (thisLinkTable != null && oppositeLinkTable != null) {
        // If both are same of empty
        if (thisLinkTable.equals(oppositeLinkTable)) {
          return false;
        }
        // If only one is set true is returned
        if ((thisLinkTable.length() > 0 && oppositeLinkTable.length() == 0)
            || (thisLinkTable.length() == 0 && oppositeLinkTable.length() > 0)) {
          return true;
        }
        // The link table tags are different
        else {
          return false;
        }
      }
      else {
        return true;
      }
    }
    // The passed property is not a association end, so it is always valid in this check.
    else {
      return true;
    }
  }

  /**
   * Checks whether the passed parameter Property is valid. This method should only be called if this property is an
   * association end of a bidirectional many to many relationship. Method gets the link table of the opposite
   * association end.
   * 
   * @param pProperty the association end of an many to many association.
   * @return boolean
   */
  public static String getLinkTable( org.eclipse.uml2.uml.Property pProperty ) {
    Stereotype lStereotype = ClassUtil.getAppliedStereotype(pProperty, "Role");
    // The passed property is an association end
    if (lStereotype != null) {
      String thisLinkTable = (String) pProperty.getValue(lStereotype, "linkTable");
      if (thisLinkTable != null && thisLinkTable.length() > 0) {
        return thisLinkTable;
      }
      else {
        org.eclipse.uml2.uml.Property lOpposite = pProperty.getOpposite();
        String oppositeLinkTable = (String) lOpposite.getValue(lStereotype, "linkTable");
        if (oppositeLinkTable != null && oppositeLinkTable.length() > 0) {
          return oppositeLinkTable;
          // The attribute link table is empty in both association ands
        }
        else {
          return ">>ERROR: The attribute link table must be specified in one "
              + "of the association ends of a many to many association<<";
        }
      }
    }
    else {
      return ">>ERROR: Its not allowed to call this method with null value! #792047273";
    }
  }

  /**
   * Method returns the name of the foreign key row for a association. The name of the foreign key can either be defined
   * through the stereotype or if not set is taken from the role name.
   * 
   * @param pNamedElement
   * @return
   */
  public static String getForeignKeyName( org.eclipse.uml2.uml.NamedElement pNamedElement ) {
    Stereotype lStereotype = ClassUtil.getAppliedStereotype(pNamedElement, "Role");
    String lForeignKeyName = null;
    if (lStereotype != null) {
      lForeignKeyName = (String) pNamedElement.getValue(lStereotype, "foreignKeyName");
    }
    if (lForeignKeyName == null || lForeignKeyName.trim().length() == 0) {
      lForeignKeyName = pNamedElement.getName().toUpperCase() + "_OID";
    }
    return lForeignKeyName;
  }

  /**
   * Method returns the names of the passed enumeration literals as lower case characters.
   * 
   * @param pEnumerationLiteral Enumeration literal object for the name of the literal should be returned. The parameter
   * must not be null.
   * @return String Name of the passed literal as all lower case characters. The method never returns null.
   */
  public static String getEnumerationLiteralsAsString( Collection<EEnumLiteral> pEnumerationLiterals ) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pEnumerationLiterals, "pEnumerationLiterals");

    // Return name in lower case.
    StringBuffer lLiterals = new StringBuffer(32);
    Iterator<EEnumLiteral> lIterator = pEnumerationLiterals.iterator();
    while (lIterator.hasNext()) {
      // Get name of next literal.
      EEnumLiteral lNextLiteral = lIterator.next();
      lLiterals.append(lNextLiteral.getName().toLowerCase());
      if (lIterator.hasNext()) {
        lLiterals.append(ClassUtil.PARAMETER_SEPERATOR);
      }
    }
    return lLiterals.toString();
  }

  /**
   * Method returns the class of the opposite association end of the passed property.
   * 
   * @param pProperty Property of which the opposite association end type should be returned. The passed parameter must
   * not be null and the property must belong top an association.
   * @return {@link Class} Class of the opposite association end. The method never returns null.
   */
  public static Class getOppositeEndType( Property pProperty ) {
    // Check passed parameter.
    Check.checkInvalidParameterNull(pProperty, "pProperty");

    //
    final Association lAssociation = pProperty.getAssociation();
    Assert.assertNotNull(lAssociation, "lAssociation");

    final List<Type> lEndTypes = lAssociation.getEndTypes();
    Class lEndType = null;
    final Iterator<Type> lIterator = lEndTypes.iterator();
    while (lIterator.hasNext()) {
      Class lNextEnd = (Class) lIterator.next();
      if (pProperty.getType().equals(lNextEnd) == false) {
        lEndType = lNextEnd;
        break;
      }
    }

    // In the case that both association ends reference the same class lEndTyp is still null.
    if (lEndType == null) {
      lEndType = (Class) pProperty.getType();
    }
    return lEndType;
  }

  /**
   * Method returns all direct subclasses of the passed class.
   * 
   * @param pBaseClass Class whose subclasses should be returned. The parameter must not be null.
   * @return {@link List} All subclasses of the passed class. The method never returns null.
   */
  public static List<NamedElement> getSubclasses( Class pBaseClass ) {
    // Check parameter
    Check.checkInvalidParameterNull(pBaseClass, "pBaseClass");

    final EList<Relationship> lRelationships = pBaseClass.getRelationships();
    final Iterator<Relationship> lIterator = lRelationships.iterator();
    List<NamedElement> lSubclasses = new ArrayList<NamedElement>(lRelationships.size());

    // Filter generalizations from all relationships and check if the base class is the base class.
    while (lIterator.hasNext()) {
      final Relationship lNextRelationship = lIterator.next();
      if (lNextRelationship instanceof Generalization) {
        Generalization lGeneralization = (Generalization) lNextRelationship;
        final Classifier lGeneral = lGeneralization.getGeneral();
        if (pBaseClass.equals(lGeneral) == true) {
          lSubclasses.add(lGeneralization.getSpecific());
        }
      }
    }
    // Sort subclasses by name
    Collections.sort(lSubclasses, new NamedElementComparator());
    // Return list of all subclasses.
    return lSubclasses;
  }

  /**
   * Method returns all direct subclasses of the passed class.
   * 
   * @param pBaseClass Class whose subclasses should be returned. The parameter must not be null.
   * @return {@link List} All subclasses of the passed class. The method never returns null.
   */
  public static List<NamedElement> getAllSubclasses( Type pBaseClass ) {
    // Check parameter
    Check.checkInvalidParameterNull(pBaseClass, "pBaseClass");

    final EList<Relationship> lRelationships = pBaseClass.getRelationships();
    final Iterator<Relationship> lIterator = lRelationships.iterator();
    List<NamedElement> lSubclasses = new ArrayList<NamedElement>(lRelationships.size());

    // Filter generalizations from all relationships and check if the base class is the base class.
    while (lIterator.hasNext()) {
      final Relationship lNextRelationship = lIterator.next();
      if (lNextRelationship instanceof Generalization) {
        Generalization lGeneralization = (Generalization) lNextRelationship;
        final Classifier lGeneral = lGeneralization.getGeneral();
        if (pBaseClass.equals(lGeneral) == true) {
          Classifier lSubclass = lGeneralization.getSpecific();
          lSubclasses.add(lSubclass);

          // Now it's time tom go one level deeper and again find all subclasses
          lSubclasses.addAll(getAllSubclasses((Class) lSubclass));
        }
      }
    }
    // Sort subclasses by name
    Collections.sort(lSubclasses, new NamedElementComparator());
    // Return list of all subclasses.
    return lSubclasses;
  }

  /**
   * @param pComponent
   * @return
   */
  public static List<Property> getAllRealProperties( Component pComponent ) {
    List<Property> lRealProperties = new ArrayList<Property>();
    for (Property lProperty : pComponent.getAllAttributes()) {
      // Filter ports and internal components
      final Type lType = lProperty.getType();
      if ((lProperty instanceof Port) == false && (lType instanceof Component) == false) {
        lRealProperties.add(lProperty);
      }
    }
    return lRealProperties;
  }

  /**
   * Method returns the OID row name for the passed class. The row name may be defined using the stereotype
   * "PersistentObject". If no specific OID row name is defined then the default value from the properties will be used.
   * 
   * @param pClass Class for which the OID row name should be returned. The parameter must not be null.
   * @return String Name of the OID row. The method never returns null.
   */
  public static String getOIDRowName( Class pClass ) {
    String lOIDRowName = null;
    // Check if a specific OID row name is defined for the passed class.
    final Stereotype lStereotype = ClassUtil.getAppliedStereotype(pClass, "PersistentObject");
    if (lStereotype != null) {
      lOIDRowName = (String) pClass.getValue(lStereotype, "OIDRowName");
    }

    // If OID row name is not set yet then we use the configured default value from the properties.
    if (lOIDRowName == null || lOIDRowName.trim().isEmpty()) {
      Configuration lResourceAccessProvider = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
      lOIDRowName = lResourceAccessProvider.getConfigurationValue(OID_ROW_NAME, "OID", String.class);
    }
    return lOIDRowName;
  }

  /**
   * Method returns the version label row name for the passed class. The row name may be defined using the stereotype
   * "PersistentObject". If no specific version label row name is defined then the default value from the properties
   * will be used.
   * 
   * @param pClass Class for which the version label row name should be returned. The parameter must not be null.
   * @return String Name of the version label row. The method never returns null.
   */
  public static String getVersionLabelRowName( Class pClass ) {
    String lVersionLabelRowName = null;
    // Check if a specific version label row name is defined for the passed class.
    final Stereotype lStereotype = ClassUtil.getAppliedStereotype(pClass, "PersistentObject");
    if (lStereotype != null) {
      lVersionLabelRowName = (String) pClass.getValue(lStereotype, "VersionLabelRowName");
    }

    // If version label row name is not set yet then we use the configured default value from the properties.
    if (lVersionLabelRowName == null || lVersionLabelRowName.trim().isEmpty()) {
      Configuration lConfiguration = XFun.getConfigurationProvider().getSystemPropertiesConfiguration();
      lVersionLabelRowName = lConfiguration.getConfigurationValue(VERSION_LABEL_ROW_NAME, "VERSION", String.class);
    }
    return lVersionLabelRowName;
  }

  /**
   * Method checks if the class has at least one multi valued association.
   * 
   * @param pClass UML class that should be checked for multi valued associations. The parameter must not be null.
   * @return boolean Method returns true if the class has at least one multi valued association and false in all other
   * cases.
   */
  public static boolean hasMultivaluedAssociation( Class pClass ) {
    // Check parameters
    Check.checkInvalidParameterNull(pClass, "pClass");

    // Check all owned attributes that belong to an association.
    boolean lHasMultiValuedAssociation = false;
    EList<Property> lOwnedAttributes = pClass.getOwnedAttributes();
    for (int i = 0; i < lOwnedAttributes.size(); i++) {
      Property lNextProperty = lOwnedAttributes.get(i);
      // If the property belongs to an association and is multi valued then we found what we were looking for.
      if (lNextProperty.getAssociation() != null && lNextProperty.isMultivalued() == true) {
        lHasMultiValuedAssociation = true;
        break;
      }
    }
    return lHasMultiValuedAssociation;
  }

  public static List<Parameter> getInputParameters( Operation pOperation ) {
    EList<Parameter> lOwnedParameters = pOperation.getOwnedParameters();
    Iterator<Parameter> lIterator = lOwnedParameters.iterator();
    List<Parameter> lInputParameters = new ArrayList<Parameter>(lOwnedParameters.size());
    while (lIterator.hasNext()) {
      Parameter lNextParameter = lIterator.next();
      if (ClassUtil.isInputParameter(lNextParameter) == true) {
        lInputParameters.add(lNextParameter);
      }
    }
    return lInputParameters;
  }

  public static boolean isInputParameter( Parameter pParameter ) {
    boolean lIsInputParameter;
    if (pParameter.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
      lIsInputParameter = true;
    }
    else {
      lIsInputParameter = false;
    }
    return lIsInputParameter;
  }
}
