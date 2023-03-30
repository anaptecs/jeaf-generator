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
import com.anaptecs.jeaf.junit.impl.domain.ClassA_BO;
import com.anaptecs.jeaf.junit.pojo.POJOWithID;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link POJOWithID} as source and {@link ClassA_BO} as
 * target.
 */
public class POJOWithIDToClassA_BOConverter implements ObjectMapper<POJOWithID, ClassA_BO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final POJOWithIDToClassA_BOConverter INSTANCE = new POJOWithIDToClassA_BOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private POJOWithIDToClassA_BOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between POJOWithID and ClassA_BO. The
   * method never returns null.
   */
  public static POJOWithIDToClassA_BOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new ClassA_BO object from the passed POJOWithID object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource POJOWithID object that should be used to create a new ClassA_BO object. The parameter must not be
   * null.
   * @return {@link ClassA_BO} Created ClassA_BO object. The method never returns null.
   */
  public static ClassA_BO createNewTargetObject( POJOWithID pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    ClassA_BO lTarget = lPersistenceServiceProvider.createPersistentObject(ClassA_BO.class);
    POJOWithIDToClassA_BOConverter lObjectMapper = POJOWithIDToClassA_BOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new ClassA_BO objects based on the passed POJOWithID objects. For every POJOWithID object a new
   * ClassA_BO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All POJOWithID objects that should be used to create ClassA_BO objects. The parameter must
   * not be null.
   * @return {@link List} List with all ClassA_BO objects that were created. The method never returns null.
   */
  public static List<ClassA_BO> createNewTargetObjects( Collection<POJOWithID> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<ClassA_BO> lTargetObjects = new ArrayList<ClassA_BO>(pSourceObjects.size());
    for (POJOWithID lNext : pSourceObjects) {
      ClassA_BO lNewTargetObject = POJOWithIDToClassA_BOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource POJOWithID object that should be used to update an existing ClassA_BO object. The parameter must not
   * be null.
   * @return {@link ClassA_BO} Updated ClassA_BO object. The method never returns null.
   */
  public static ClassA_BO updatePersistentTarget( POJOWithID pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    ClassA_BO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), ClassA_BO.class);
    POJOWithIDToClassA_BOConverter lObjectMapper = POJOWithIDToClassA_BOConverter.getConverter();
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
  public void applyMappings( POJOWithID pSource, ClassA_BO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<POJOWithID> pSources, List<ClassA_BO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<POJOWithID> lSourceIterator = pSources.iterator();
    Iterator<ClassA_BO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new POJOWithID object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   *
   * @param pTarget ClassA_BO object that should be used to create a new POJOWithID object. The parameter must not be
   * null.
   * @return {@link POJOWithID} Created POJOWithID object. The method never returns null.
   */
  public static POJOWithID createNewSourceObject( ClassA_BO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    POJOWithID.Builder lBuilder = POJOWithID.builder();
    lBuilder.setID(pTarget.getID());
    POJOWithID lNewSourceObject = lBuilder.build();
    POJOWithIDToClassA_BOConverter lObjectMapper = POJOWithIDToClassA_BOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new POJOWithID objects based on the passed ClassA_BO objects. For every ClassA_BO object a new
   * POJOWithID object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<POJOWithID> createNewSourceObjects( Collection<ClassA_BO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<POJOWithID> lNewObjects = new ArrayList<POJOWithID>(pTargetObjects.size());
    for (ClassA_BO lNext : pTargetObjects) {
      POJOWithID lNewSourceObject = POJOWithIDToClassA_BOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from POJOWithID to ClassA_BO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( POJOWithID pSource, ClassA_BO pTarget ) {
    pTarget.setName(pSource.getName());
  }

  /**
   * Method maps all attributes from POJOWithID to ClassA_BO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( POJOWithID pSource, ClassA_BO pTarget ) {
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
      pTarget.setName(pSource.getName());
    }
  }

  /**
   * Method maps all attributes from ClassA_BO to POJOWithID. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( POJOWithID pSource, ClassA_BO pTarget ) {
    pSource.setName(pTarget.getName());
  }
}
