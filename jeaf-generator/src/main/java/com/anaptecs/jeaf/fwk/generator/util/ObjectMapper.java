/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class ObjectMapper {
  enum PrimitiveType {
    BOOLEAN, BYTE, SHORT, INTEGER, LONG, FLOAT, DOUBLE, CHARACTER;
  }

  private static Map<String, PrimitiveType> PRIMITIVE_TYPES;
  static {
    PRIMITIVE_TYPES = new HashMap<String, PrimitiveType>();
    PRIMITIVE_TYPES.put("boolean", PrimitiveType.BOOLEAN);
    PRIMITIVE_TYPES.put("Boolean", PrimitiveType.BOOLEAN);
    PRIMITIVE_TYPES.put(Boolean.class.getName(), PrimitiveType.BOOLEAN);
    PRIMITIVE_TYPES.put("byte", PrimitiveType.BYTE);
    PRIMITIVE_TYPES.put("Byte", PrimitiveType.BYTE);
    PRIMITIVE_TYPES.put(Byte.class.getName(), PrimitiveType.BYTE);
    PRIMITIVE_TYPES.put("short", PrimitiveType.SHORT);
    PRIMITIVE_TYPES.put("Short", PrimitiveType.SHORT);
    PRIMITIVE_TYPES.put(Short.class.getName(), PrimitiveType.SHORT);
    PRIMITIVE_TYPES.put("int", PrimitiveType.INTEGER);
    PRIMITIVE_TYPES.put("Integer", PrimitiveType.INTEGER);
    PRIMITIVE_TYPES.put(Integer.class.getName(), PrimitiveType.INTEGER);
    PRIMITIVE_TYPES.put("long", PrimitiveType.LONG);
    PRIMITIVE_TYPES.put("Long", PrimitiveType.LONG);
    PRIMITIVE_TYPES.put(Long.class.getName(), PrimitiveType.LONG);
    PRIMITIVE_TYPES.put("float", PrimitiveType.FLOAT);
    PRIMITIVE_TYPES.put("Float", PrimitiveType.FLOAT);
    PRIMITIVE_TYPES.put(Float.class.getName(), PrimitiveType.FLOAT);
    PRIMITIVE_TYPES.put("double", PrimitiveType.DOUBLE);
    PRIMITIVE_TYPES.put("Double", PrimitiveType.DOUBLE);
    PRIMITIVE_TYPES.put(Double.class.getName(), PrimitiveType.DOUBLE);
    PRIMITIVE_TYPES.put("char", PrimitiveType.CHARACTER);
    PRIMITIVE_TYPES.put("Character", PrimitiveType.CHARACTER);
    PRIMITIVE_TYPES.put(Character.class.getName(), PrimitiveType.CHARACTER);
  }

  public static final String STEREOTYPE_SERVICE_OBJECT_MAPPING = "JMM::ObjectMapping";

  /**
   * Method returns the package path for the service object mapper that will be created basing on the dependencies of
   * the passed class.
   * 
   * @param pClass
   * @return
   */
  public static String getMapperPackagePath( Class pTargetClass ) {
    String lResult = ObjectMapper.getMapperPackage(pTargetClass);
    return lResult.replaceAll("\\.", "/");
  }

  /**
   * Method returns the package path for the service object mapper that will be created basing on the dependencies of
   * the passed class.
   * 
   * @param pClass
   * @return
   */
  public static String getMapperPackage( Class pTargetClass ) {
    // Get dependent classes and use their package as package for the
    // service object mapper.
    return ClassUtil.getPackageName(pTargetClass) + ".mapper";
  }

  public static String getMapperConstructorParamList( Class pClass ) {
    // Get all dependencies to create the right constructor
    final List<Class> lDependencies = ObjectMapper.getConstructorParams(pClass);
    return Naming.asParameterDefinitionList(lDependencies);
  }

  public static boolean hasObjectMapping( Class pClass ) {
    boolean lHasMapping = false;
    final Iterator<Dependency> lIterator = pClass.getClientDependencies().iterator();
    while (lIterator.hasNext()) {
      Dependency lNextDependency = lIterator.next();
      if (lNextDependency.getAppliedStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING) != null) {
        lHasMapping = true;
        break;
      }
    }

    lHasMapping = lHasMapping | !ObjectMapper.getDirectObjectMappingDependentClasses(pClass).isEmpty();
    return lHasMapping;
  }

  public static List<Class> getDirectObjectMappingDependentClasses( Class pClass ) {
    // Return only direct dependencies. This does not include those from
    // inherited classes.
    final List<NamedElement> lNamedElements = new ArrayList<NamedElement>();
    lNamedElements.addAll(pClass.getOwnedAttributes());
    lNamedElements.add(pClass);

    return ObjectMapper.getObjectMappingDependencies(lNamedElements);
  }

  /**
   * Method checks if the passed class has an object mapping to persistent objects.
   * 
   * @param pClass
   */
  public static boolean hasObjectMappingToPersistentObject( Class pClass ) {
    final String lStereotype = "PersistentObject";
    boolean lHasMapping = false;
    final Iterator<Dependency> lIterator = pClass.getClientDependencies().iterator();
    while (lIterator.hasNext()) {
      Dependency lNextDependency = lIterator.next();
      if (lNextDependency.getAppliedStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING) != null) {
        NamedElement lNamedElement = lNextDependency.getSuppliers().get(0);
        if (lNamedElement.getAppliedStereotype(lStereotype) != null) {
          lHasMapping = true;
        }
        break;
      }
    }

    List<Class> lDirectObjectMappingDependentClasses = ObjectMapper.getDirectObjectMappingDependentClasses(pClass);
    for (Class lNextClass : lDirectObjectMappingDependentClasses) {
      Iterator<Stereotype> lStereotypeIterator = lNextClass.getAppliedStereotypes().iterator();
      while (lStereotypeIterator.hasNext()) {
        Stereotype lNextStereotype = lStereotypeIterator.next();
        if (lStereotype.equals(lNextStereotype.getName()) == true) {
          lHasMapping = true;
          break;
        }
      }
    }
    return lHasMapping;
  }

  /**
   * Method checks if the passed class has an object mapping to domain objects.
   * 
   * @param pClass
   */
  public static boolean hasObjectMappingToDomainObject( Class pClass ) {
    final String lStereotype = "DomainObject";
    boolean lHasMapping = false;
    final Iterator<Dependency> lIterator = pClass.getClientDependencies().iterator();
    while (lIterator.hasNext()) {
      Dependency lNextDependency = lIterator.next();
      if (lNextDependency.getAppliedStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING) != null) {
        NamedElement lNamedElement = lNextDependency.getSuppliers().get(0);
        if (lNamedElement.getAppliedStereotype(lStereotype) != null) {
          lHasMapping = true;
        }
        break;
      }
    }

    List<Class> lDirectObjectMappingDependentClasses = ObjectMapper.getDirectObjectMappingDependentClasses(pClass);
    for (Class lNextClass : lDirectObjectMappingDependentClasses) {
      Iterator<Stereotype> lStereotypeIterator = lNextClass.getAppliedStereotypes().iterator();
      while (lStereotypeIterator.hasNext()) {
        Stereotype lNextStereotype = lStereotypeIterator.next();
        if (lStereotype.equals(lNextStereotype.getName()) == true) {
          lHasMapping = true;
          break;
        }
      }
    }
    return lHasMapping;
  }

  public static List<Class> getAllObjectMappingDependentClasses( Class pClass ) {
    // Return found dependencies including those from inherited classes.
    List<Property> lList = GeneratorCommons.getAllAttributes(pClass);
    return ObjectMapper.getObjectMappingDependencies(lList);
  }

  public static List<Dependency> getDirectObjectMappingDependencies( Class pClass ) {
    return ObjectMapper.getDirectObjectMappingDependencies(pClass, null);
  }

  public static boolean hasUpdateObjectMapping( Class pClass ) {
    return !ObjectMapper.getDirectObjectMappingDependencies(pClass, MappingType.ON_UPDATE).isEmpty();
  }

  public static List<Dependency> getDirectObjectMappingDependencies( Class pClass, MappingType pMappingType ) {
    final List<Property> lAttributes = pClass.getOwnedAttributes();
    List<Dependency> lDependencies = new ArrayList<Dependency>(lAttributes.size());
    // Resolve all mapping dependencies of all attributes of this class.
    // This includes the dependencies of inherited attributes.
    for (int i = 0; i < lAttributes.size(); i++) {
      Property lNextProperty = (Property) lAttributes.get(i);
      final List<Dependency> lClientDependencies = lNextProperty.getClientDependencies();
      if (lClientDependencies != null && lClientDependencies.size() > 0) {
        for (Dependency lDependency : lClientDependencies) {
          final Stereotype lStereotype = lDependency.getAppliedStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING);
          if (lStereotype != null) {
            ObjectMappingInfo lObjectMappingInfo = ObjectMapper.getObjectMappingInfo(lDependency);
            if (pMappingType == null) {
              lDependencies.add(lDependency);
            }
            // Filter by passed mapping type
            else {
              if (lObjectMappingInfo.isMappingTypeEnabled(pMappingType)) {
                lDependencies.add(lDependency);
              }
            }
          }
        }
      }
    }
    return lDependencies;
  }

  public static ObjectMappingInfo getObjectMappingInfo( Dependency pDependency ) {
    Stereotype lStereotype = pDependency.getApplicableStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING);

    ObjectMappingInfo lObjectMappingInfo;
    if (lStereotype != null) {
      Boolean lOnCreate = (Boolean) pDependency.getValue(lStereotype, "onCreate");
      Boolean lOnUpdate = (Boolean) pDependency.getValue(lStereotype, "onUpdate");
      Boolean lOnRead = (Boolean) pDependency.getValue(lStereotype, "onRead");
      lObjectMappingInfo = new ObjectMappingInfo(lOnCreate, lOnUpdate, lOnRead);
    }
    else {
      lObjectMappingInfo = null;
    }
    return lObjectMappingInfo;
  }

  /**
   * @param pNamedElements
   * @return
   */
  private static List<Class> getObjectMappingDependencies( List<? extends NamedElement> pNamedElements ) {
    List<Class> lDependentClasses = new ArrayList<Class>();

    // Resolve all mapping dependencies of all attributes of this class.
    // This includes the dependencies of inherited
    // attributes.
    for (int i = 0; i < pNamedElements.size(); i++) {
      NamedElement lNextProperty = pNamedElements.get(i);
      final List<Dependency> lClientDependencies = lNextProperty.getClientDependencies();
      if (lClientDependencies != null && lClientDependencies.size() > 0) {
        for (Dependency lNextDependency : lClientDependencies) {
          final Stereotype lStereotype = lNextDependency.getAppliedStereotype(STEREOTYPE_SERVICE_OBJECT_MAPPING);
          if (lStereotype != null) {
            // Get first (and hopefully only) supplier
            Element lElement = lNextDependency.getSuppliers().get(0);
            Class lDeclaringClass;
            if (lElement instanceof Property) {
              lDeclaringClass = ((Property) lElement).getClass_();
            }
            else if (lElement instanceof Operation) {
              lDeclaringClass = ((Operation) lElement).getClass_();
            }
            else if (lElement instanceof Class) {
              lDeclaringClass = (Class) lElement;
            }
            // All other types are ignored.
            else {
              lDeclaringClass = null;
            }

            if (lDeclaringClass != null && lDependentClasses.contains(lDeclaringClass) == false) {
              lDependentClasses.add(lDeclaringClass);
            }
          }
        }
      }
    }
    return lDependentClasses;
  }

  public static String getMapperSuperCallParameterList( Class pClass ) {
    final List<Class> lParams = new ArrayList<Class>();
    lParams.addAll(ObjectMapper.getSuperConstructorParamClasses(pClass));
    return Naming.asParameterList(lParams);
  }

  public static List<Class> getSuperConstructorParamClasses( Class pClass ) {
    final List<Class> lSuperClasses = pClass.getSuperClasses();
    List<Class> lParams;
    if (lSuperClasses.size() == 1) {
      // Get constructor params of passed class and its super class.
      List<Class> lConstructorParams = ObjectMapper.getConstructorParams(pClass);
      List<Class> lSuperConstructorParams = ObjectMapper.getConstructorParams((Class) lSuperClasses.get(0));

      // Find matching parameter from child class for every parameter of
      // super class.
      lParams = new ArrayList<Class>(lSuperConstructorParams.size());

      for (int i = 0; i < lSuperConstructorParams.size(); i++) {
        Class lSuperParamClass = lSuperConstructorParams.get(i);

        Class lParamClass = null;

        // Find assignable parameter.
        for (int k = 0; k < lConstructorParams.size(); k++) {
          Class lNextClass = lConstructorParams.get(k);
          if (GeneratorCommons.isAssignable(lNextClass, lSuperParamClass) == true) {
            lParamClass = lNextClass;
            break;
          }
        }

        // Add found parameter class to param list.
        if (lParamClass != null) {
          lParams.add(lParamClass);
        }
      }
    }
    else {
      lParams = Collections.emptyList();
    }
    return lParams;
  }

  public static String getMapperCallParameterList( Class pClass ) {
    final List<Class> lParams = new ArrayList<Class>();
    lParams.addAll(ObjectMapper.getConstructorParams(pClass));
    return Naming.asParameterList(lParams);
  }

  public static List<Class> getConstructorParams( Class pClass ) {
    final Set<Class> lParams = new HashSet<Class>();

    // Get parent dependencies
    final List<Class> lSuperClasses = pClass.getSuperClasses();

    if (lSuperClasses.size() == 1) {
      // Get all dependent classes of super class.
      final Class lSuperClass = lSuperClasses.get(0);
      final List<Class> lDependenciesFromSuper = ObjectMapper.getAllObjectMappingDependentClasses(lSuperClass);

      // Get all dependent classes of passed class.
      final List<Class> lDependencies = ObjectMapper.getDirectObjectMappingDependentClasses(pClass);

      // Compare dependencies from both classes and find out the one that
      // are the deepest within the class hierarchy.
      if (lDependencies.size() > 0 && lDependenciesFromSuper.size() > 0) {
        Set<Class> lIgnores = new HashSet<Class>();
        for (int i = 0; i < lDependencies.size(); i++) {
          Class lCurrentDependency = lDependencies.get(i);

          for (int k = 0; k < lDependenciesFromSuper.size(); k++) {
            Class lCurrentSuperDependency = lDependenciesFromSuper.get(k);

            if (GeneratorCommons.isAssignable(lCurrentDependency, lCurrentSuperDependency) == true) {
              lParams.add(lCurrentDependency);
              lIgnores.add(lCurrentSuperDependency);
            }
            else if (GeneratorCommons.isAssignable(lCurrentSuperDependency, lCurrentDependency) == true) {
              lParams.add(lCurrentSuperDependency);
              lIgnores.add(lCurrentDependency);
            }
            else {
              if (lIgnores.contains(lCurrentDependency) == false) {
                lParams.add(lCurrentDependency);
              }
              if (lIgnores.contains(lCurrentSuperDependency) == false) {
                lParams.add(lCurrentSuperDependency);
              }
            }
          }
        }
      }
      // Since at least one list of dependent class is empty we can throw
      // them all together.
      else {
        lParams.addAll(lDependencies);
        lParams.addAll(lDependenciesFromSuper);
      }
    }
    else {
      lParams.addAll(ObjectMapper.getDirectObjectMappingDependentClasses(pClass));
    }
    final ArrayList<Class> lResult = new ArrayList<Class>(lParams.size() + 1);
    final ArrayList<Class> lParamList = new ArrayList<Class>(lParams);
    Collections.sort(lParamList, new Comparator<Class>() {

      public int compare( Class pClass1, Class pClass2 ) {
        return Naming.getFullyQualifiedName(pClass1).compareTo(Naming.getFullyQualifiedName(pClass2));
      }

    });
    lResult.add(pClass);
    lResult.addAll(lParamList);
    return lResult;
  }

  public static List<Class> getParentTargetClasses( Class pSource, Class pTarget ) {
    List<Class> lDependentClasses = ObjectMapper.getDirectObjectMappingDependentClasses(pSource);
    Map<String, Class> lClassMap = new HashMap<String, Class>();
    for (Class lNextDependentClass : lDependentClasses) {
      lClassMap.put(Naming.getFullyQualifiedName(lNextDependentClass), lNextDependentClass);
    }

    // Try to find the best fitting dependent class.
    List<Class> lTargetClasses = new ArrayList<Class>();
    Class lDependentClass = pTarget;

    // Try to resolve direct mappings and parent mappings
    while (true) {
      Class lClass = lClassMap.get(Naming.getFullyQualifiedName(lDependentClass));
      // If we found the delegate then we are done.
      if (lClass != null) {
        lTargetClasses.add(lClass);
      }

      // Handle parent of current target
      if (lDependentClass.parents().isEmpty() == false) {
        lDependentClass = (Class) lDependentClass.parents().get(0);
      }
      // No more parent classes to process, so we are done.
      else {
        break;
      }
    }
    return lTargetClasses;
  }

  public static boolean isDatatypeConverterRequired( NamedElement pSupplier, NamedElement pClient ) {
    // A datatype converter is required if supplier and client are not of the same tpye and Java`s auto boxing is not
    // able to do the conversion.
    boolean lDatatypeConverterRequired;
    // Types are the same, so we need no converter.
    String lSupplierFQN = Naming.getFullyQualifiedName(pSupplier);
    String lClientFQN = Naming.getFullyQualifiedName(pClient);
    if (lSupplierFQN.equals(lClientFQN)) {
      lDatatypeConverterRequired = false;
    }
    // Types are different, may be Java`s auto boxing will solve the problem.
    else {
      // Check if supplier and client are both primitive types or wrappers of them
      boolean lSupplierIsPrimitive = PRIMITIVE_TYPES.containsKey(lSupplierFQN);
      boolean lClientIsPrimitive = PRIMITIVE_TYPES.containsKey(lClientFQN);

      // Both types are primitive, so may be auto boxing can help
      if (lSupplierIsPrimitive == true && lClientIsPrimitive == true) {
        PrimitiveType lSupplierType = PRIMITIVE_TYPES.get(lSupplierFQN);
        PrimitiveType lClientType = PRIMITIVE_TYPES.get(lClientFQN);

        // Auto boxing will do the conversion
        if (lSupplierType == lClientType) {
          lDatatypeConverterRequired = false;
        }
        // Datatype converter is required
        else {
          lDatatypeConverterRequired = true;
        }
      }
      // At least of the types is not a primitive so we need a datatype converter for sure.
      else {
        // In UML model there also is a separate type for string (not java.lang.String)
        if ((lSupplierFQN.equals(String.class.getName()) && lClientFQN.equals(String.class.getSimpleName()))
            || (lSupplierFQN.equals(String.class.getSimpleName()) && lClientFQN.equals(String.class.getName()))) {
          lDatatypeConverterRequired = false;
        }
        else {
          lDatatypeConverterRequired = true;
        }
      }
    }
    return lDatatypeConverterRequired;
  }

  public static boolean autoBoxingToolsRequired( NamedElement pSupplier, NamedElement pClient ) {
    // Types are the same, so we need no converter.
    String lSupplierFQN = Naming.getFullyQualifiedName(pSupplier);
    String lClientFQN = Naming.getFullyQualifiedName(pClient);
    boolean lAutoBoxingToolsRequired;
    if (lSupplierFQN.equals(lClientFQN)) {
      lAutoBoxingToolsRequired = false;
    }
    else {
      if (pClient instanceof Property && pSupplier instanceof Property) {
        Property lClientProperty = (Property) pClient;
        Property lSupplierProperty = (Property) pSupplier;
        if (lClientProperty.isMultivalued() == true && lSupplierProperty.isMultivalued() == true) {
          lAutoBoxingToolsRequired = true;
        }
        else {
          lAutoBoxingToolsRequired = false;
        }
      }
      else {
        lAutoBoxingToolsRequired = false;
      }
    }
    return lAutoBoxingToolsRequired;
  }

  public static String isValidObjectMapping( Dependency pDependency ) {
    String lValidObjectMapping;

    EList<NamedElement> lClients = pDependency.getClients();
    EList<NamedElement> lSuppliers = pDependency.getSuppliers();
    if (lClients.size() != 1 || lSuppliers.size() != 1) {
      lValidObjectMapping = "Multiple clients or suppliers in ObjectMapping are not supported.";
    }
    else {
      NamedElement lClient = lClients.get(0);
      NamedElement lSupplier = lSuppliers.get(0);
      if (lClient instanceof Property) {
        Property lClientProperty = (Property) lClient;

        if (lSupplier instanceof Property) {
          Property lSupplierProperty = (Property) lSupplier;

          // Client and supplier have to be multivalued or not.
          if (lClientProperty.isMultivalued() == true && lSupplierProperty.isMultivalued() == true) {
            lValidObjectMapping = null;
          }
          else if (lClientProperty.isMultivalued() == false && lSupplierProperty.isMultivalued() == false) {
            lValidObjectMapping = null;
          }
          else {
            lValidObjectMapping = "Client and supplier must have the same multiplicity.";
          }
        }
        else if (lSupplier instanceof Operation) {
          lValidObjectMapping = null;
        }
        else {
          lValidObjectMapping = "Supplier must either be Property or Operation.";
        }
      }
      else if (lClient instanceof Class && lSupplier instanceof Class) {
        lValidObjectMapping = null;
      }
      else {
        lValidObjectMapping = "Client and Supplier of an ObjectMapping must be properties";
      }
    }

    return lValidObjectMapping;
  }
}
