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
import com.anaptecs.jeaf.junit.core.ClassB;
import com.anaptecs.jeaf.junit.pojo.POJOWithIDnMethod;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.datatypeconverter.DatatypeConverter;

/**
 * Class implements an bidirectional object mapper between classes {@link POJOWithIDnMethod} as source and
 * {@link ClassB} as target.
 */
public class POJOWithIDnMethodToClassBConverter implements ObjectMapper<POJOWithIDnMethod, ClassB> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final POJOWithIDnMethodToClassBConverter INSTANCE = new POJOWithIDnMethodToClassBConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private POJOWithIDnMethodToClassBConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between POJOWithIDnMethod and ClassB.
   * The method never returns null.
   */
  public static POJOWithIDnMethodToClassBConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new ClassB object from the passed POJOWithIDnMethod object and applies the defined mappings of
   * type {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource POJOWithIDnMethod object that should be used to create a new ClassB object. The parameter must not
   * be null.
   * @return {@link ClassB} Created ClassB object. The method never returns null.
   */
  public static ClassB createNewTargetObject( POJOWithIDnMethod pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    ClassB lTarget = ClassB.builder().build();
    POJOWithIDnMethodToClassBConverter lObjectMapper = POJOWithIDnMethodToClassBConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new ClassB objects based on the passed POJOWithIDnMethod objects. For every POJOWithIDnMethod object
   * a new ClassB object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All POJOWithIDnMethod objects that should be used to create ClassB objects. The parameter
   * must not be null.
   * @return {@link List} List with all ClassB objects that were created. The method never returns null.
   */
  public static List<ClassB> createNewTargetObjects( Collection<POJOWithIDnMethod> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<ClassB> lTargetObjects = new ArrayList<ClassB>(pSourceObjects.size());
    for (POJOWithIDnMethod lNext : pSourceObjects) {
      ClassB lNewTargetObject = POJOWithIDnMethodToClassBConverter.createNewTargetObject(lNext);
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
  public void applyMappings( POJOWithIDnMethod pSource, ClassB pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<POJOWithIDnMethod> pSources, List<ClassB> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<POJOWithIDnMethod> lSourceIterator = pSources.iterator();
    Iterator<ClassB> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new POJOWithIDnMethod object and applies the defined mappings of type {@link MappingType#READ}
   * from the UML model.
   *
   * @param pTarget ClassB object that should be used to create a new POJOWithIDnMethod object. The parameter must not
   * be null.
   * @return {@link POJOWithIDnMethod} Created POJOWithIDnMethod object. The method never returns null.
   */
  public static POJOWithIDnMethod createNewSourceObject( ClassB pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    POJOWithIDnMethod.Builder lBuilder = POJOWithIDnMethod.builder();
    lBuilder.setID(pTarget.getID());
    POJOWithIDnMethod lNewSourceObject = lBuilder.build();
    POJOWithIDnMethodToClassBConverter lObjectMapper = POJOWithIDnMethodToClassBConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new POJOWithIDnMethod objects based on the passed ClassB objects. For every ClassB object a new
   * POJOWithIDnMethod object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<POJOWithIDnMethod> createNewSourceObjects( Collection<ClassB> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<POJOWithIDnMethod> lNewObjects = new ArrayList<POJOWithIDnMethod>(pTargetObjects.size());
    for (ClassB lNext : pTargetObjects) {
      POJOWithIDnMethod lNewSourceObject = POJOWithIDnMethodToClassBConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from POJOWithIDnMethod to ClassB. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( POJOWithIDnMethod pSource, ClassB pTarget ) {
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Double, Integer> lIntValueConverter;
    lIntValueConverter = XFun.getDatatypeConverterRegistry().getConverter(Double.class, Integer.class);
    pTarget.setIntValue(lIntValueConverter.convert(pSource.getAttr()));
  }

  /**
   * Method maps all attributes from POJOWithIDnMethod to ClassB. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( POJOWithIDnMethod pSource, ClassB pTarget ) {
    // Update target object
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Double, Integer> lIntValueConverter;
    lIntValueConverter = XFun.getDatatypeConverterRegistry().getConverter(Double.class, Integer.class);
    pTarget.setIntValue(lIntValueConverter.convert(pSource.getAttr()));
  }

  /**
   * Method maps all attributes from ClassB to POJOWithIDnMethod. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( POJOWithIDnMethod pSource, ClassB pTarget ) {
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Integer, Double> lIntValueConverter;
    lIntValueConverter = XFun.getDatatypeConverterRegistry().getConverter(Integer.class, Double.class);
    pSource.setAttr(lIntValueConverter.convert(pTarget.getIntValue()));
  }
}
