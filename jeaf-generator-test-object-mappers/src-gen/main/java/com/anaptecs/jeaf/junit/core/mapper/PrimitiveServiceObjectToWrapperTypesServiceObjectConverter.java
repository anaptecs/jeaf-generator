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
import com.anaptecs.jeaf.junit.core.PrimitiveServiceObject;
import com.anaptecs.jeaf.junit.core.WrapperTypesServiceObject;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link PrimitiveServiceObject} as source and
 * {@link WrapperTypesServiceObject} as target.
 */
public class PrimitiveServiceObjectToWrapperTypesServiceObjectConverter
    implements ObjectMapper<PrimitiveServiceObject, WrapperTypesServiceObject> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final PrimitiveServiceObjectToWrapperTypesServiceObjectConverter INSTANCE =
      new PrimitiveServiceObjectToWrapperTypesServiceObjectConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private PrimitiveServiceObjectToWrapperTypesServiceObjectConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between PrimitiveServiceObject and
   * WrapperTypesServiceObject. The method never returns null.
   */
  public static PrimitiveServiceObjectToWrapperTypesServiceObjectConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new WrapperTypesServiceObject object from the passed PrimitiveServiceObject object and applies the
   * defined mappings of type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource PrimitiveServiceObject object that should be used to create a new WrapperTypesServiceObject object.
   * The parameter must not be null.
   * @return {@link WrapperTypesServiceObject} Created WrapperTypesServiceObject object. The method never returns null.
   */
  public static WrapperTypesServiceObject createNewTargetObject( PrimitiveServiceObject pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    WrapperTypesServiceObject lTarget = WrapperTypesServiceObject.builder().build();
    PrimitiveServiceObjectToWrapperTypesServiceObjectConverter lObjectMapper =
        PrimitiveServiceObjectToWrapperTypesServiceObjectConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new WrapperTypesServiceObject objects based on the passed PrimitiveServiceObject objects. For every
   * PrimitiveServiceObject object a new WrapperTypesServiceObject object will be returned. The mappings for case
   * {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All PrimitiveServiceObject objects that should be used to create WrapperTypesServiceObject
   * objects. The parameter must not be null.
   * @return {@link List} List with all WrapperTypesServiceObject objects that were created. The method never returns
   * null.
   */
  public static List<WrapperTypesServiceObject> createNewTargetObjects(
      Collection<PrimitiveServiceObject> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<WrapperTypesServiceObject> lTargetObjects = new ArrayList<WrapperTypesServiceObject>(pSourceObjects.size());
    for (PrimitiveServiceObject lNext : pSourceObjects) {
      WrapperTypesServiceObject lNewTargetObject =
          PrimitiveServiceObjectToWrapperTypesServiceObjectConverter.createNewTargetObject(lNext);
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
  public void applyMappings( PrimitiveServiceObject pSource, WrapperTypesServiceObject pTarget,
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
  public void applyMappings( List<PrimitiveServiceObject> pSources, List<WrapperTypesServiceObject> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<PrimitiveServiceObject> lSourceIterator = pSources.iterator();
    Iterator<WrapperTypesServiceObject> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new PrimitiveServiceObject object and applies the defined mappings of type
   * {@link MappingType#READ} from the UML model.
   *
   * @param pTarget WrapperTypesServiceObject object that should be used to create a new PrimitiveServiceObject object.
   * The parameter must not be null.
   * @return {@link PrimitiveServiceObject} Created PrimitiveServiceObject object. The method never returns null.
   */
  public static PrimitiveServiceObject createNewSourceObject( WrapperTypesServiceObject pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    PrimitiveServiceObject lNewSourceObject = PrimitiveServiceObject.builder().build();
    PrimitiveServiceObjectToWrapperTypesServiceObjectConverter lObjectMapper =
        PrimitiveServiceObjectToWrapperTypesServiceObjectConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new PrimitiveServiceObject objects based on the passed WrapperTypesServiceObject objects. For every
   * WrapperTypesServiceObject object a new PrimitiveServiceObject object will be returned. The mappings for case
   * {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<PrimitiveServiceObject> createNewSourceObjects(
      Collection<WrapperTypesServiceObject> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<PrimitiveServiceObject> lNewObjects = new ArrayList<PrimitiveServiceObject>(pTargetObjects.size());
    for (WrapperTypesServiceObject lNext : pTargetObjects) {
      PrimitiveServiceObject lNewSourceObject =
          PrimitiveServiceObjectToWrapperTypesServiceObjectConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from PrimitiveServiceObject to WrapperTypesServiceObject. Mappings are applied only for
   * case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( PrimitiveServiceObject pSource, WrapperTypesServiceObject pTarget ) {
    pTarget.setABoolean(pSource.getABoolean());
    pTarget.setAByte(pSource.getAByte());
    pTarget.setAShort(pSource.getAShort());
    pTarget.setAInt(pSource.getAInt());
    pTarget.setALong(pSource.getALong());
    pTarget.setAFloat(pSource.getAFloat());
    pTarget.setADouble(pSource.getADouble());
    pTarget.setAChar(pSource.getAChar());
  }

  /**
   * Method maps all attributes from PrimitiveServiceObject to WrapperTypesServiceObject. Mappings are applied only for
   * case {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( PrimitiveServiceObject pSource, WrapperTypesServiceObject pTarget ) {
    // Update target object
    pTarget.setABoolean(pSource.getABoolean());
    pTarget.setAByte(pSource.getAByte());
    pTarget.setAShort(pSource.getAShort());
    pTarget.setAInt(pSource.getAInt());
    pTarget.setALong(pSource.getALong());
    pTarget.setAFloat(pSource.getAFloat());
    pTarget.setADouble(pSource.getADouble());
    pTarget.setAChar(pSource.getAChar());
  }

  /**
   * Method maps all attributes from WrapperTypesServiceObject to PrimitiveServiceObject. Mappings are applied only for
   * case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( PrimitiveServiceObject pSource, WrapperTypesServiceObject pTarget ) {
    pSource.setABoolean(pTarget.getABoolean());
    pSource.setAByte(pTarget.getAByte());
    pSource.setAShort(pTarget.getAShort());
    pSource.setAInt(pTarget.getAInt());
    pSource.setALong(pTarget.getALong());
    pSource.setAFloat(pTarget.getAFloat());
    pSource.setADouble(pTarget.getADouble());
    pSource.setAChar(pTarget.getAChar());
  }
}