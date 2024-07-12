/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.junit.pojo.BChildPOJO;
import com.anaptecs.jeaf.junit.pojo.ParentPOJO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link ParentPOJO} as source and {@link BChildPOJO}
 * as target.
 */
public class ParentPOJOToBChildPOJOConverter implements ObjectMapper<ParentPOJO, BChildPOJO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final ParentPOJOToBChildPOJOConverter INSTANCE = new ParentPOJOToBChildPOJOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private ParentPOJOToBChildPOJOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between ParentPOJO and BChildPOJO.
   * The method never returns null.
   */
  public static ParentPOJOToBChildPOJOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new BChildPOJO object from the passed ParentPOJO object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource ParentPOJO object that should be used to create a new BChildPOJO object. The parameter must not be
   * null.
   * @return {@link BChildPOJO} Created BChildPOJO object. The method never returns null.
   */
  public static BChildPOJO createNewTargetObject( ParentPOJO pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    BChildPOJO lTarget = BChildPOJO.builder().build();
    ParentPOJOToBChildPOJOConverter lObjectMapper = ParentPOJOToBChildPOJOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new BChildPOJO objects based on the passed ParentPOJO objects. For every ParentPOJO object a new
   * BChildPOJO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All ParentPOJO objects that should be used to create BChildPOJO objects. The parameter must
   * not be null.
   * @return {@link List} List with all BChildPOJO objects that were created. The method never returns null.
   */
  public static List<BChildPOJO> createNewTargetObjects( Collection<ParentPOJO> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<BChildPOJO> lTargetObjects = new ArrayList<BChildPOJO>(pSourceObjects.size());
    for (ParentPOJO lNext : pSourceObjects) {
      BChildPOJO lNewTargetObject = ParentPOJOToBChildPOJOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( ParentPOJO pSource, BChildPOJO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<ParentPOJO> pSources, List<BChildPOJO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<ParentPOJO> lSourceIterator = pSources.iterator();
    Iterator<BChildPOJO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new ParentPOJO object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   *
   * @param pTarget BChildPOJO object that should be used to create a new ParentPOJO object. The parameter must not be
   * null.
   * @return {@link ParentPOJO} Created ParentPOJO object. The method never returns null.
   */
  public static ParentPOJO createNewSourceObject( BChildPOJO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    ParentPOJO lNewSourceObject = ParentPOJO.builder().build();
    ParentPOJOToBChildPOJOConverter lObjectMapper = ParentPOJOToBChildPOJOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new ParentPOJO objects based on the passed BChildPOJO objects. For every BChildPOJO object a new
   * ParentPOJO object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<ParentPOJO> createNewSourceObjects( Collection<BChildPOJO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<ParentPOJO> lNewObjects = new ArrayList<ParentPOJO>(pTargetObjects.size());
    for (BChildPOJO lNext : pTargetObjects) {
      ParentPOJO lNewSourceObject = ParentPOJOToBChildPOJOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from ParentPOJO to BChildPOJO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( ParentPOJO pSource, BChildPOJO pTarget ) {
    pTarget.setWeirdAttribute(pSource.getWeirdAttribute());
  }

  /**
   * Method maps all attributes from ParentPOJO to BChildPOJO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( ParentPOJO pSource, BChildPOJO pTarget ) {
    // Update target object
    pTarget.setWeirdAttribute(pSource.getWeirdAttribute());
  }

  /**
   * Method maps all attributes from BChildPOJO to ParentPOJO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( ParentPOJO pSource, BChildPOJO pTarget ) {
    pSource.setWeirdAttribute(pTarget.getWeirdAttribute());
  }
}