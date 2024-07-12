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
import com.anaptecs.jeaf.junit.objectmapping.MappingParentDO;
import com.anaptecs.jeaf.junit.objectmapping.OtherMappingObject;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link OtherMappingObject} as source and
 * {@link MappingParentDO} as target.
 */
public class OtherMappingObjectToMappingParentDOConverter implements ObjectMapper<OtherMappingObject, MappingParentDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final OtherMappingObjectToMappingParentDOConverter INSTANCE =
      new OtherMappingObjectToMappingParentDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private OtherMappingObjectToMappingParentDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between OtherMappingObject and
   * MappingParentDO. The method never returns null.
   */
  public static OtherMappingObjectToMappingParentDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new MappingParentDO object from the passed OtherMappingObject object and applies the defined
   * mappings of type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource OtherMappingObject object that should be used to create a new MappingParentDO object. The parameter
   * must not be null.
   * @return {@link MappingParentDO} Created MappingParentDO object. The method never returns null.
   */
  public static MappingParentDO createNewTargetObject( OtherMappingObject pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    MappingParentDO lTarget = new MappingParentDO();
    OtherMappingObjectToMappingParentDOConverter lObjectMapper =
        OtherMappingObjectToMappingParentDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new MappingParentDO objects based on the passed OtherMappingObject objects. For every
   * OtherMappingObject object a new MappingParentDO object will be returned. The mappings for case
   * {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All OtherMappingObject objects that should be used to create MappingParentDO objects. The
   * parameter must not be null.
   * @return {@link List} List with all MappingParentDO objects that were created. The method never returns null.
   */
  public static List<MappingParentDO> createNewTargetObjects( Collection<OtherMappingObject> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<MappingParentDO> lTargetObjects = new ArrayList<MappingParentDO>(pSourceObjects.size());
    for (OtherMappingObject lNext : pSourceObjects) {
      MappingParentDO lNewTargetObject = OtherMappingObjectToMappingParentDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( OtherMappingObject pSource, MappingParentDO pTarget,
      ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<OtherMappingObject> pSources, List<MappingParentDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<OtherMappingObject> lSourceIterator = pSources.iterator();
    Iterator<MappingParentDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new OtherMappingObject object and applies the defined mappings of type {@link MappingType#READ}
   * from the UML model.
   *
   * @param pTarget MappingParentDO object that should be used to create a new OtherMappingObject object. The parameter
   * must not be null.
   * @return {@link OtherMappingObject} Created OtherMappingObject object. The method never returns null.
   */
  public static OtherMappingObject createNewSourceObject( MappingParentDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    OtherMappingObject lNewSourceObject = OtherMappingObject.builder().build();
    OtherMappingObjectToMappingParentDOConverter lObjectMapper =
        OtherMappingObjectToMappingParentDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new OtherMappingObject objects based on the passed MappingParentDO objects. For every
   * MappingParentDO object a new OtherMappingObject object will be returned. The mappings for case
   * {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<OtherMappingObject> createNewSourceObjects( Collection<MappingParentDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<OtherMappingObject> lNewObjects = new ArrayList<OtherMappingObject>(pTargetObjects.size());
    for (MappingParentDO lNext : pTargetObjects) {
      OtherMappingObject lNewSourceObject = OtherMappingObjectToMappingParentDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from OtherMappingObject to MappingParentDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( OtherMappingObject pSource, MappingParentDO pTarget ) {
    pTarget.setName(pSource.getName());
  }

  /**
   * Method maps all attributes from OtherMappingObject to MappingParentDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( OtherMappingObject pSource, MappingParentDO pTarget ) {
    // Update target object
    pTarget.setName(pSource.getName());
  }

  /**
   * Method maps all attributes from MappingParentDO to OtherMappingObject. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( OtherMappingObject pSource, MappingParentDO pTarget ) {
    pSource.setName(pTarget.getName());
  }
}