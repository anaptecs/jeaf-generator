/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.core.ClassA;
import com.anaptecs.jeaf.junit.core.ValidationTestObject;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link ClassA} as source and
 * {@link ValidationTestObject} as target.
 */
public class ClassAToValidationTestObjectConverter implements ObjectMapper<ClassA, ValidationTestObject> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final ClassAToValidationTestObjectConverter INSTANCE = new ClassAToValidationTestObjectConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private ClassAToValidationTestObjectConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between ClassA and
   * ValidationTestObject. The method never returns null.
   */
  public static ClassAToValidationTestObjectConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new ValidationTestObject object from the passed ClassA object and applies the defined mappings of
   * type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource ClassA object that should be used to create a new ValidationTestObject object. The parameter must
   * not be null.
   * @return {@link ValidationTestObject} Created ValidationTestObject object. The method never returns null.
   */
  public static ValidationTestObject createNewTargetObject( ClassA pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    ValidationTestObject lTarget = ValidationTestObject.builder().build();
    ClassAToValidationTestObjectConverter lObjectMapper = ClassAToValidationTestObjectConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new ValidationTestObject objects based on the passed ClassA objects. For every ClassA object a new
   * ValidationTestObject object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All ClassA objects that should be used to create ValidationTestObject objects. The parameter
   * must not be null.
   * @return {@link List} List with all ValidationTestObject objects that were created. The method never returns null.
   */
  public static List<ValidationTestObject> createNewTargetObjects( Collection<ClassA> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<ValidationTestObject> lTargetObjects = new ArrayList<ValidationTestObject>(pSourceObjects.size());
    for (ClassA lNext : pSourceObjects) {
      ValidationTestObject lNewTargetObject = ClassAToValidationTestObjectConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method applies the mappings according to the passed mapping type on the passed source and target object.
   *
   * @param pSource Source object which should be used. The parameter must not be null. The effective type and direction
   * of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pTarget Target object which should be used. The parameter must not be null. The effective type and direction
   * of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  @Override
  public void applyMappings( ClassA pSource, ValidationTestObject pTarget, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSource, "pSource");
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Select the type of mapping that should be executed.
    switch (pMappingType) {
      // Mappings for creation of target object.
      case CREATE:
        this.setTargetObject(pSource, pTarget);
        break;
      // Mapping for update of target object
      case UPDATE:
        this.updateTargetObject(pSource, pTarget);
        break;
      // Mapping for reading from target object.
      case READ:
        this.setSourceObject(pSource, pTarget);
        break;
      // Invalid mapping type. Most likely this is because of an outdated version of JEAF Generator that does not match
      // to the used version of JEAF Core.
      default:
        Assert.internalError("Unexpected object mapping type '" + pMappingType.name()
            + ". Please regenerate code with the latest version of JEAF Generator.");
    }
  }

  /**
   * Method applies the mappings according to the passed mapping type on the passed source and target objects. The
   * entries in the list of source and target objects are matched according to their index. This also means that both
   * list must have the same amount of entries.
   *
   * @param pSources Source objects which should be used. The parameter must not be null. The effective type and
   * direction of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pTargets Target objects which should be used. The parameter must not be null. The effective type and
   * direction of the object mapping depends on parameter <code>pMappingType</code>.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  @Override
  public void applyMappings( List<ClassA> pSources, List<ValidationTestObject> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<ClassA> lSourceIterator = pSources.iterator();
    Iterator<ValidationTestObject> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new ClassA object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget ValidationTestObject object that should be used to create a new ClassA object. The parameter must
   * not be null.
   * @return {@link ClassA} Created ClassA object. The method never returns null.
   */
  public static ClassA createNewSourceObject( ValidationTestObject pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    ClassA lNewSourceObject = ClassA.builder().build();
    ClassAToValidationTestObjectConverter lObjectMapper = ClassAToValidationTestObjectConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new ClassA objects based on the passed ValidationTestObject objects. For every ValidationTestObject
   * object a new ClassA object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<ClassA> createNewSourceObjects( Collection<ValidationTestObject> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<ClassA> lNewObjects = new ArrayList<ClassA>(pTargetObjects.size());
    for (ValidationTestObject lNext : pTargetObjects) {
      ClassA lNewSourceObject = ClassAToValidationTestObjectConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from ClassA to ValidationTestObject. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( ClassA pSource, ValidationTestObject pTarget ) {
    pTarget.setMyEMail(pSource.getName());
  }

  /**
   * Method maps all attributes from ClassA to ValidationTestObject. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( ClassA pSource, ValidationTestObject pTarget ) {
    // Update target object
    pTarget.setMyEMail(pSource.getName());
  }

  /**
   * Method maps all attributes from ValidationTestObject to ClassA. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( ClassA pSource, ValidationTestObject pTarget ) {
    pSource.setName(pTarget.getMyEMail());
  }
}