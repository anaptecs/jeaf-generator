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
import com.anaptecs.jeaf.junit.objectmapping.MappingChild;
import com.anaptecs.jeaf.junit.objectmapping.MappingChildDO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link MappingChild} as source and
 * {@link MappingChildDO} as target.
 */
public class MappingChildToMappingChildDOConverter implements ObjectMapper<MappingChild, MappingChildDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final MappingChildToMappingChildDOConverter INSTANCE = new MappingChildToMappingChildDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private MappingChildToMappingChildDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between MappingChild and
   * MappingChildDO. The method never returns null.
   */
  public static MappingChildToMappingChildDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new MappingChildDO object from the passed MappingChild object and applies the defined mappings of
   * type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource MappingChild object that should be used to create a new MappingChildDO object. The parameter must
   * not be null.
   * @return {@link MappingChildDO} Created MappingChildDO object. The method never returns null.
   */
  public static MappingChildDO createNewTargetObject( MappingChild pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    MappingChildDO lTarget = new MappingChildDO();
    MappingChildToMappingChildDOConverter lObjectMapper = MappingChildToMappingChildDOConverter.getConverter();
    // As class MappingChild also has a super class we have to retrieve a mapper for its super class as well. The
    // delegate is responsible for applying all mappings of the super classes.
    lObjectMapper.applyParentMappings(pSource, lTarget, MappingType.CREATE);
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new MappingChildDO objects based on the passed MappingChild objects. For every MappingChild object a
   * new MappingChildDO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All MappingChild objects that should be used to create MappingChildDO objects. The parameter
   * must not be null.
   * @return {@link List} List with all MappingChildDO objects that were created. The method never returns null.
   */
  public static List<MappingChildDO> createNewTargetObjects( Collection<MappingChild> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<MappingChildDO> lTargetObjects = new ArrayList<MappingChildDO>(pSourceObjects.size());
    for (MappingChild lNext : pSourceObjects) {
      MappingChildDO lNewTargetObject = MappingChildToMappingChildDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( MappingChild pSource, MappingChildDO pTarget, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSource, "pSource");
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Apply mapping of super classes.
    this.applyParentMappings(pSource, pTarget, pMappingType);
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
  public void applyMappings( List<MappingChild> pSources, List<MappingChildDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<MappingChild> lSourceIterator = pSources.iterator();
    Iterator<MappingChildDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new MappingChild object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   *
   * @param pTarget MappingChildDO object that should be used to create a new MappingChild object. The parameter must
   * not be null.
   * @return {@link MappingChild} Created MappingChild object. The method never returns null.
   */
  public static MappingChild createNewSourceObject( MappingChildDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    MappingChild lNewSourceObject = MappingChild.builder().build();
    MappingChildToMappingChildDOConverter lObjectMapper = MappingChildToMappingChildDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new MappingChild objects based on the passed MappingChildDO objects. For every MappingChildDO object
   * a new MappingChild object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<MappingChild> createNewSourceObjects( Collection<MappingChildDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<MappingChild> lNewObjects = new ArrayList<MappingChild>(pTargetObjects.size());
    for (MappingChildDO lNext : pTargetObjects) {
      MappingChild lNewSourceObject = MappingChildToMappingChildDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from MappingChild to MappingChildDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( MappingChild pSource, MappingChildDO pTarget ) {
    pTarget.setValue(pSource.getValue());
  }

  /**
   * Method maps all attributes from MappingChild to MappingChildDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( MappingChild pSource, MappingChildDO pTarget ) {
    // Update target object
    pTarget.setValue(pSource.getValue());
  }

  /**
   * Method maps all attributes from MappingChildDO to MappingChild. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( MappingChild pSource, MappingChildDO pTarget ) {
    pSource.setValue(pTarget.getValue());
  }

  /**
   * Method applies the object mappings for all combinations of the source's parent class with the target class and all
   * of its super classes.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  private void applyParentMappings( MappingChild pSource, MappingChildDO pTarget,
      ObjectMapper.MappingType pMappingType ) {
    MappingParentToMappingParentDOConverter.getConverter().applyMappings(pSource, pTarget, pMappingType);
  }
}