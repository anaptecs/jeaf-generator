/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.domainObjects.KanteDO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link KanteDO} as source and {@link KanteDO} as
 * target.
 */
public class KanteDOToKanteDOConverter implements ObjectMapper<KanteDO, KanteDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final KanteDOToKanteDOConverter INSTANCE = new KanteDOToKanteDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private KanteDOToKanteDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between KanteDO and KanteDO. The
   * method never returns null.
   */
  public static KanteDOToKanteDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new KanteDO object from the passed KanteDO object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource KanteDO object that should be used to create a new KanteDO object. The parameter must not be null.
   * @return {@link KanteDO} Created KanteDO object. The method never returns null.
   */
  public static KanteDO createNewTargetObject( KanteDO pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    KanteDO lTarget = new KanteDO();
    KanteDOToKanteDOConverter lObjectMapper = KanteDOToKanteDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new KanteDO objects based on the passed KanteDO objects. For every KanteDO object a new KanteDO
   * object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All KanteDO objects that should be used to create KanteDO objects. The parameter must not be
   * null.
   * @return {@link List} List with all KanteDO objects that were created. The method never returns null.
   */
  public static List<KanteDO> createNewTargetObjects( Collection<KanteDO> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<KanteDO> lTargetObjects = new ArrayList<KanteDO>(pSourceObjects.size());
    for (KanteDO lNext : pSourceObjects) {
      KanteDO lNewTargetObject = KanteDOToKanteDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( KanteDO pSource, KanteDO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<KanteDO> pSources, List<KanteDO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<KanteDO> lSourceIterator = pSources.iterator();
    Iterator<KanteDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new KanteDO object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget KanteDO object that should be used to create a new KanteDO object. The parameter must not be null.
   * @return {@link KanteDO} Created KanteDO object. The method never returns null.
   */
  public static KanteDO createNewSourceObject( KanteDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    KanteDO lNewSourceObject;
    DomainObjectID lDomainObjectID = pTarget.getDomainObjectID();
    if (lDomainObjectID != null) {
      lNewSourceObject = new KanteDO(lDomainObjectID);
    }
    else {
      lNewSourceObject = new KanteDO();
    }
    KanteDOToKanteDOConverter lObjectMapper = KanteDOToKanteDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new KanteDO objects based on the passed KanteDO objects. For every KanteDO object a new KanteDO
   * object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<KanteDO> createNewSourceObjects( Collection<KanteDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<KanteDO> lNewObjects = new ArrayList<KanteDO>(pTargetObjects.size());
    for (KanteDO lNext : pTargetObjects) {
      KanteDO lNewSourceObject = KanteDOToKanteDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from KanteDO to KanteDO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( KanteDO pSource, KanteDO pTarget ) {
    pTarget.setGerichtet(pSource.getGerichtet());
  }

  /**
   * Method maps all attributes from KanteDO to KanteDO. Mappings are applied only for case {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( KanteDO pSource, KanteDO pTarget ) {
    // Update target object
    pTarget.setGerichtet(pSource.getGerichtet());
  }

  /**
   * Method maps all attributes from KanteDO to KanteDO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( KanteDO pSource, KanteDO pTarget ) {
    pSource.setGerichtet(pTarget.getGerichtet());
  }
}
