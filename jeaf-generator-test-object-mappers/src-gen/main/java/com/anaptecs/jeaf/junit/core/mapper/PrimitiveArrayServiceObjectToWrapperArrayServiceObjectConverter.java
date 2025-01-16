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
import com.anaptecs.jeaf.junit.core.PrimitiveArrayServiceObject;
import com.anaptecs.jeaf.junit.core.WrapperArrayServiceObject;
import com.anaptecs.jeaf.tools.api.lang.AutoBoxingTools;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link PrimitiveArrayServiceObject} as source and
 * {@link WrapperArrayServiceObject} as target.
 */
public class PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter
    implements ObjectMapper<PrimitiveArrayServiceObject, WrapperArrayServiceObject> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter INSTANCE =
      new PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between PrimitiveArrayServiceObject
   * and WrapperArrayServiceObject. The method never returns null.
   */
  public static PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new WrapperArrayServiceObject object from the passed PrimitiveArrayServiceObject object and
   * applies the defined mappings of type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource PrimitiveArrayServiceObject object that should be used to create a new WrapperArrayServiceObject
   * object. The parameter must not be null.
   * @return {@link WrapperArrayServiceObject} Created WrapperArrayServiceObject object. The method never returns null.
   */
  public static WrapperArrayServiceObject createNewTargetObject( PrimitiveArrayServiceObject pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    WrapperArrayServiceObject lTarget = WrapperArrayServiceObject.builder().build();
    PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter lObjectMapper =
        PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new WrapperArrayServiceObject objects based on the passed PrimitiveArrayServiceObject objects. For
   * every PrimitiveArrayServiceObject object a new WrapperArrayServiceObject object will be returned. The mappings for
   * case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All PrimitiveArrayServiceObject objects that should be used to create
   * WrapperArrayServiceObject objects. The parameter must not be null.
   * @return {@link List} List with all WrapperArrayServiceObject objects that were created. The method never returns
   * null.
   */
  public static List<WrapperArrayServiceObject> createNewTargetObjects(
      Collection<PrimitiveArrayServiceObject> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<WrapperArrayServiceObject> lTargetObjects = new ArrayList<WrapperArrayServiceObject>(pSourceObjects.size());
    for (PrimitiveArrayServiceObject lNext : pSourceObjects) {
      WrapperArrayServiceObject lNewTargetObject =
          PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter.createNewTargetObject(lNext);
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
  public void applyMappings( PrimitiveArrayServiceObject pSource, WrapperArrayServiceObject pTarget,
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
  public void applyMappings( List<PrimitiveArrayServiceObject> pSources, List<WrapperArrayServiceObject> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<PrimitiveArrayServiceObject> lSourceIterator = pSources.iterator();
    Iterator<WrapperArrayServiceObject> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new PrimitiveArrayServiceObject object and applies the defined mappings of type
   * {@link MappingType#READ} from the UML model.
   *
   * @param pTarget WrapperArrayServiceObject object that should be used to create a new PrimitiveArrayServiceObject
   * object. The parameter must not be null.
   * @return {@link PrimitiveArrayServiceObject} Created PrimitiveArrayServiceObject object. The method never returns
   * null.
   */
  public static PrimitiveArrayServiceObject createNewSourceObject( WrapperArrayServiceObject pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    PrimitiveArrayServiceObject lNewSourceObject = PrimitiveArrayServiceObject.builder().build();
    PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter lObjectMapper =
        PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new PrimitiveArrayServiceObject objects based on the passed WrapperArrayServiceObject objects. For
   * every WrapperArrayServiceObject object a new PrimitiveArrayServiceObject object will be returned. The mappings for
   * case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<PrimitiveArrayServiceObject> createNewSourceObjects(
      Collection<WrapperArrayServiceObject> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<PrimitiveArrayServiceObject> lNewObjects = new ArrayList<PrimitiveArrayServiceObject>(pTargetObjects.size());
    for (WrapperArrayServiceObject lNext : pTargetObjects) {
      PrimitiveArrayServiceObject lNewSourceObject =
          PrimitiveArrayServiceObjectToWrapperArrayServiceObjectConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from PrimitiveArrayServiceObject to WrapperArrayServiceObject. Mappings are applied only
   * for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( PrimitiveArrayServiceObject pSource, WrapperArrayServiceObject pTarget ) {
    pTarget.setBooleanArray(AutoBoxingTools.getAutoBoxingTools().autoBox(pSource.getBooleanArray()));
  }

  /**
   * Method maps all attributes from PrimitiveArrayServiceObject to WrapperArrayServiceObject. Mappings are applied only
   * for case {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( PrimitiveArrayServiceObject pSource, WrapperArrayServiceObject pTarget ) {
    // Update target object
    pTarget.setBooleanArray(AutoBoxingTools.getAutoBoxingTools().autoBox(pSource.getBooleanArray()));
  }

  /**
   * Method maps all attributes from WrapperArrayServiceObject to PrimitiveArrayServiceObject. Mappings are applied only
   * for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( PrimitiveArrayServiceObject pSource, WrapperArrayServiceObject pTarget ) {
    pSource.setBooleanArray(AutoBoxingTools.getAutoBoxingTools().autoBox(pTarget.getBooleanArray()));
  }
}