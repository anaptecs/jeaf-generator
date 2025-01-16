/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.objectmapping.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.objectmapping.MappingParent;
import com.anaptecs.jeaf.junit.objectmapping.MappingParentDO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link MappingParent} as source and
 * {@link MappingParentDO} as target.
 */
public class MappingParentToMappingParentDOConverter implements ObjectMapper<MappingParent, MappingParentDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final MappingParentToMappingParentDOConverter INSTANCE = new MappingParentToMappingParentDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private MappingParentToMappingParentDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between MappingParent and
   * MappingParentDO. The method never returns null.
   */
  public static MappingParentToMappingParentDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new MappingParentDO object from the passed MappingParent object and applies the defined mappings
   * of type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource MappingParent object that should be used to create a new MappingParentDO object. The parameter must
   * not be null.
   * @return {@link MappingParentDO} Created MappingParentDO object. The method never returns null.
   */
  public static MappingParentDO createNewTargetObject( MappingParent pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    MappingParentDO lTarget = new MappingParentDO();
    MappingParentToMappingParentDOConverter lObjectMapper = MappingParentToMappingParentDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new MappingParentDO objects based on the passed MappingParent objects. For every MappingParent
   * object a new MappingParentDO object will be returned. The mappings for case {@link MappingType#CREATE} will be
   * applied.
   *
   * @param pSourceObjects All MappingParent objects that should be used to create MappingParentDO objects. The
   * parameter must not be null.
   * @return {@link List} List with all MappingParentDO objects that were created. The method never returns null.
   */
  public static List<MappingParentDO> createNewTargetObjects( Collection<MappingParent> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<MappingParentDO> lTargetObjects = new ArrayList<MappingParentDO>(pSourceObjects.size());
    for (MappingParent lNext : pSourceObjects) {
      MappingParentDO lNewTargetObject = MappingParentToMappingParentDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( MappingParent pSource, MappingParentDO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<MappingParent> pSources, List<MappingParentDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<MappingParent> lSourceIterator = pSources.iterator();
    Iterator<MappingParentDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new MappingParent object and applies the defined mappings of type {@link MappingType#READ} from
   * the UML model.
   *
   * @param pTarget MappingParentDO object that should be used to create a new MappingParent object. The parameter must
   * not be null.
   * @return {@link MappingParent} Created MappingParent object. The method never returns null.
   */
  public static MappingParent createNewSourceObject( MappingParentDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    MappingParent lNewSourceObject = MappingParent.builder().build();
    MappingParentToMappingParentDOConverter lObjectMapper = MappingParentToMappingParentDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new MappingParent objects based on the passed MappingParentDO objects. For every MappingParentDO
   * object a new MappingParent object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<MappingParent> createNewSourceObjects( Collection<MappingParentDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<MappingParent> lNewObjects = new ArrayList<MappingParent>(pTargetObjects.size());
    for (MappingParentDO lNext : pTargetObjects) {
      MappingParent lNewSourceObject = MappingParentToMappingParentDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from MappingParent to MappingParentDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( MappingParent pSource, MappingParentDO pTarget ) {
    pTarget.setName(pSource.getName());
  }

  /**
   * Method maps all attributes from MappingParent to MappingParentDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( MappingParent pSource, MappingParentDO pTarget ) {
    // Update target object
    pTarget.setName(pSource.getName());
  }

  /**
   * Method maps all attributes from MappingParentDO to MappingParent. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( MappingParent pSource, MappingParentDO pTarget ) {
    pSource.setName(pTarget.getName());
  }
}