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
import com.anaptecs.jeaf.junit.core.IdentifiableServiceObject;
import com.anaptecs.jeaf.junit.domainObjects.UICCodeDO;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link IdentifiableServiceObject} as source and
 * {@link UICCodeDO} as target.
 */
public class IdentifiableServiceObjectToUICCodeDOConverter
    implements ObjectMapper<IdentifiableServiceObject, UICCodeDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final IdentifiableServiceObjectToUICCodeDOConverter INSTANCE =
      new IdentifiableServiceObjectToUICCodeDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private IdentifiableServiceObjectToUICCodeDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between IdentifiableServiceObject and
   * UICCodeDO. The method never returns null.
   */
  public static IdentifiableServiceObjectToUICCodeDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new UICCodeDO object from the passed IdentifiableServiceObject object and applies the defined
   * mappings of type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource IdentifiableServiceObject object that should be used to create a new UICCodeDO object. The parameter
   * must not be null.
   * @return {@link UICCodeDO} Created UICCodeDO object. The method never returns null.
   */
  public static UICCodeDO createNewTargetObject( IdentifiableServiceObject pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    UICCodeDO lTarget = new UICCodeDO();
    IdentifiableServiceObjectToUICCodeDOConverter lObjectMapper =
        IdentifiableServiceObjectToUICCodeDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new UICCodeDO objects based on the passed IdentifiableServiceObject objects. For every
   * IdentifiableServiceObject object a new UICCodeDO object will be returned. The mappings for case
   * {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All IdentifiableServiceObject objects that should be used to create UICCodeDO objects. The
   * parameter must not be null.
   * @return {@link List} List with all UICCodeDO objects that were created. The method never returns null.
   */
  public static List<UICCodeDO> createNewTargetObjects( Collection<IdentifiableServiceObject> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<UICCodeDO> lTargetObjects = new ArrayList<UICCodeDO>(pSourceObjects.size());
    for (IdentifiableServiceObject lNext : pSourceObjects) {
      UICCodeDO lNewTargetObject = IdentifiableServiceObjectToUICCodeDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( IdentifiableServiceObject pSource, UICCodeDO pTarget,
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
  public void applyMappings( List<IdentifiableServiceObject> pSources, List<UICCodeDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<IdentifiableServiceObject> lSourceIterator = pSources.iterator();
    Iterator<UICCodeDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new IdentifiableServiceObject object and applies the defined mappings of type
   * {@link MappingType#READ} from the UML model.
   *
   * @param pTarget UICCodeDO object that should be used to create a new IdentifiableServiceObject object. The parameter
   * must not be null.
   * @return {@link IdentifiableServiceObject} Created IdentifiableServiceObject object. The method never returns null.
   */
  public static IdentifiableServiceObject createNewSourceObject( UICCodeDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    IdentifiableServiceObject lNewSourceObject;
    DomainObjectID lDomainObjectID = pTarget.getDomainObjectID();
    if (lDomainObjectID != null) {
      IdentifiableServiceObject.Builder lBuilder = IdentifiableServiceObject.builder();
      lBuilder.setID(lDomainObjectID);
      lNewSourceObject = lBuilder.build();
    }
    else {
      lNewSourceObject = IdentifiableServiceObject.builder().build();
    }
    IdentifiableServiceObjectToUICCodeDOConverter lObjectMapper =
        IdentifiableServiceObjectToUICCodeDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new IdentifiableServiceObject objects based on the passed UICCodeDO objects. For every UICCodeDO
   * object a new IdentifiableServiceObject object will be returned. The mappings for case {@link MappingType#READ} will
   * be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<IdentifiableServiceObject> createNewSourceObjects( Collection<UICCodeDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<IdentifiableServiceObject> lNewObjects = new ArrayList<IdentifiableServiceObject>(pTargetObjects.size());
    for (UICCodeDO lNext : pTargetObjects) {
      IdentifiableServiceObject lNewSourceObject =
          IdentifiableServiceObjectToUICCodeDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from IdentifiableServiceObject to UICCodeDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( IdentifiableServiceObject pSource, UICCodeDO pTarget ) {
    pTarget.setCode(pSource.getHello());
  }

  /**
   * Method maps all attributes from IdentifiableServiceObject to UICCodeDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( IdentifiableServiceObject pSource, UICCodeDO pTarget ) {
    // Update target object
    pTarget.setCode(pSource.getHello());
  }

  /**
   * Method maps all attributes from UICCodeDO to IdentifiableServiceObject. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( IdentifiableServiceObject pSource, UICCodeDO pTarget ) {
    pSource.setHello(pTarget.getCode());
    pSource.setCountry(pTarget.getCountry());
  }
}
