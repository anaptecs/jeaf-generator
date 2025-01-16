/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.core.ClassB;
import com.anaptecs.jeaf.junit.impl.domain.ClassB_BO;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link ClassB} as source and {@link ClassB_BO} as
 * target.
 */
public class ClassBToClassB_BOConverter implements ObjectMapper<ClassB, ClassB_BO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final ClassBToClassB_BOConverter INSTANCE = new ClassBToClassB_BOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private ClassBToClassB_BOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between ClassB and ClassB_BO. The
   * method never returns null.
   */
  public static ClassBToClassB_BOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new ClassB_BO object from the passed ClassB object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource ClassB object that should be used to create a new ClassB_BO object. The parameter must not be null.
   * @return {@link ClassB_BO} Created ClassB_BO object. The method never returns null.
   */
  public static ClassB_BO createNewTargetObject( ClassB pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    ClassB_BO lTarget = lPersistenceServiceProvider.createPersistentObject(ClassB_BO.class);
    ClassBToClassB_BOConverter lObjectMapper = ClassBToClassB_BOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new ClassB_BO objects based on the passed ClassB objects. For every ClassB object a new ClassB_BO
   * object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All ClassB objects that should be used to create ClassB_BO objects. The parameter must not be
   * null.
   * @return {@link List} List with all ClassB_BO objects that were created. The method never returns null.
   */
  public static List<ClassB_BO> createNewTargetObjects( Collection<ClassB> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<ClassB_BO> lTargetObjects = new ArrayList<ClassB_BO>(pSourceObjects.size());
    for (ClassB lNext : pSourceObjects) {
      ClassB_BO lNewTargetObject = ClassBToClassB_BOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource ClassB object that should be used to update an existing ClassB_BO object. The parameter must not be
   * null.
   * @return {@link ClassB_BO} Updated ClassB_BO object. The method never returns null.
   */
  public static ClassB_BO updatePersistentTarget( ClassB pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    ClassB_BO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), ClassB_BO.class);
    ClassBToClassB_BOConverter lObjectMapper = ClassBToClassB_BOConverter.getConverter();
    lObjectMapper.applyMappings(pSource, lTargetObject, MappingType.UPDATE);
    return lTargetObject;
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
  public void applyMappings( ClassB pSource, ClassB_BO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<ClassB> pSources, List<ClassB_BO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<ClassB> lSourceIterator = pSources.iterator();
    Iterator<ClassB_BO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new ClassB object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget ClassB_BO object that should be used to create a new ClassB object. The parameter must not be null.
   * @return {@link ClassB} Created ClassB object. The method never returns null.
   */
  public static ClassB createNewSourceObject( ClassB_BO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    ClassB.Builder lBuilder = ClassB.builder();
    lBuilder.setID(pTarget.getID());
    ClassB lNewSourceObject = lBuilder.build();
    ClassBToClassB_BOConverter lObjectMapper = ClassBToClassB_BOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new ClassB objects based on the passed ClassB_BO objects. For every ClassB_BO object a new ClassB
   * object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<ClassB> createNewSourceObjects( Collection<ClassB_BO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<ClassB> lNewObjects = new ArrayList<ClassB>(pTargetObjects.size());
    for (ClassB_BO lNext : pTargetObjects) {
      ClassB lNewSourceObject = ClassBToClassB_BOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from ClassB to ClassB_BO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( ClassB pSource, ClassB_BO pTarget ) {
    pTarget.setIntValue(pSource.getIntValue());
  }

  /**
   * Method maps all attributes from ClassB to ClassB_BO. Mappings are applied only for case {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( ClassB pSource, ClassB_BO pTarget ) {
    // In order to avoid dirty writes on persistent objects, we first check for optimistic lock conflicts. Therefore we
    // have to compare version labels of source and target.
    Integer lSourceVersionLabel = pSource.getID().getVersionLabel();
    int lTargetVersionLabel = pTarget.getVersionLabel();
    // Optimistic lock conflict detected
    if (lSourceVersionLabel != null && lSourceVersionLabel.intValue() != lTargetVersionLabel) {
      String[] lParams = new String[] { pTarget.getClass().getName(), pTarget.getID().getObjectID(),
        lSourceVersionLabel.toString(), Integer.toString(pTarget.getVersionLabel()) };
      throw new JEAFSystemException(PersistenceServiceProviderMessages.OPTIMISTIC_LOCK_CONFLICT, lParams);
    }
    else {
      // Update target object
      pTarget.setIntValue(pSource.getIntValue());
    }
  }

  /**
   * Method maps all attributes from ClassB_BO to ClassB. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( ClassB pSource, ClassB_BO pTarget ) {
    pSource.setIntValue(pTarget.getIntValue());
  }
}