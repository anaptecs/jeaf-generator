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

import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.domainObjects.VerbindungspunktDO;
import com.anaptecs.jeaf.junit.pojo.PlainPOJO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link PlainPOJO} as source and
 * {@link VerbindungspunktDO} as target.
 */
public class PlainPOJOToVerbindungspunktDOConverter implements ObjectMapper<PlainPOJO, VerbindungspunktDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final PlainPOJOToVerbindungspunktDOConverter INSTANCE = new PlainPOJOToVerbindungspunktDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private PlainPOJOToVerbindungspunktDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between PlainPOJO and
   * VerbindungspunktDO. The method never returns null.
   */
  public static PlainPOJOToVerbindungspunktDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new VerbindungspunktDO object from the passed PlainPOJO object and applies the defined mappings of
   * type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource PlainPOJO object that should be used to create a new VerbindungspunktDO object. The parameter must
   * not be null.
   * @return {@link VerbindungspunktDO} Created VerbindungspunktDO object. The method never returns null.
   */
  public static VerbindungspunktDO createNewTargetObject( PlainPOJO pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    VerbindungspunktDO lTarget = new VerbindungspunktDO();
    PlainPOJOToVerbindungspunktDOConverter lObjectMapper = PlainPOJOToVerbindungspunktDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new VerbindungspunktDO objects based on the passed PlainPOJO objects. For every PlainPOJO object a
   * new VerbindungspunktDO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All PlainPOJO objects that should be used to create VerbindungspunktDO objects. The parameter
   * must not be null.
   * @return {@link List} List with all VerbindungspunktDO objects that were created. The method never returns null.
   */
  public static List<VerbindungspunktDO> createNewTargetObjects( Collection<PlainPOJO> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<VerbindungspunktDO> lTargetObjects = new ArrayList<VerbindungspunktDO>(pSourceObjects.size());
    for (PlainPOJO lNext : pSourceObjects) {
      VerbindungspunktDO lNewTargetObject = PlainPOJOToVerbindungspunktDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( PlainPOJO pSource, VerbindungspunktDO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<PlainPOJO> pSources, List<VerbindungspunktDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<PlainPOJO> lSourceIterator = pSources.iterator();
    Iterator<VerbindungspunktDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new PlainPOJO object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   *
   * @param pTarget VerbindungspunktDO object that should be used to create a new PlainPOJO object. The parameter must
   * not be null.
   * @return {@link PlainPOJO} Created PlainPOJO object. The method never returns null.
   */
  public static PlainPOJO createNewSourceObject( VerbindungspunktDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    PlainPOJO lNewSourceObject = PlainPOJO.builder().build();
    PlainPOJOToVerbindungspunktDOConverter lObjectMapper = PlainPOJOToVerbindungspunktDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new PlainPOJO objects based on the passed VerbindungspunktDO objects. For every VerbindungspunktDO
   * object a new PlainPOJO object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<PlainPOJO> createNewSourceObjects( Collection<VerbindungspunktDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<PlainPOJO> lNewObjects = new ArrayList<PlainPOJO>(pTargetObjects.size());
    for (VerbindungspunktDO lNext : pTargetObjects) {
      PlainPOJO lNewSourceObject = PlainPOJOToVerbindungspunktDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from PlainPOJO to VerbindungspunktDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( PlainPOJO pSource, VerbindungspunktDO pTarget ) {
    pTarget.setBavName(pSource.getHello());
  }

  /**
   * Method maps all attributes from PlainPOJO to VerbindungspunktDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( PlainPOJO pSource, VerbindungspunktDO pTarget ) {
    // Update target object
    pTarget.setBavName(pSource.getHello());
  }

  /**
   * Method maps all attributes from VerbindungspunktDO to PlainPOJO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( PlainPOJO pSource, VerbindungspunktDO pTarget ) {
    pSource.setHello(pTarget.getBavName());
  }
}