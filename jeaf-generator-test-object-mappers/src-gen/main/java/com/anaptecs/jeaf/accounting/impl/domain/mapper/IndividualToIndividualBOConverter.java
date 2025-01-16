/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.accounting.Individual;
import com.anaptecs.jeaf.accounting.impl.domain.IndividualBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class implements an bidirectional object mapper between classes {@link Individual} as source and {@link IndividualBO}
 * as target.
 */
public class IndividualToIndividualBOConverter implements ObjectMapper<Individual, IndividualBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final IndividualToIndividualBOConverter INSTANCE = new IndividualToIndividualBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private IndividualToIndividualBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Individual and IndividualBO.
   * The method never returns null.
   */
  public static IndividualToIndividualBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new IndividualBO object from the passed Individual object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource Individual object that should be used to create a new IndividualBO object. The parameter must not be
   * null.
   * @return {@link IndividualBO} Created IndividualBO object. The method never returns null.
   */
  public static IndividualBO createNewTargetObject( Individual pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    IndividualBO lTarget = lPersistenceServiceProvider.createPersistentObject(IndividualBO.class);
    IndividualToIndividualBOConverter lObjectMapper = IndividualToIndividualBOConverter.getConverter();
    // As class Individual also has a super class we have to retrieve a mapper for its super class as well. The delegate
    // is responsible for applying all mappings of the super classes.
    lObjectMapper.applyParentMappings(pSource, lTarget, MappingType.CREATE);
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new IndividualBO objects based on the passed Individual objects. For every Individual object a new
   * IndividualBO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All Individual objects that should be used to create IndividualBO objects. The parameter must
   * not be null.
   * @return {@link List} List with all IndividualBO objects that were created. The method never returns null.
   */
  public static List<IndividualBO> createNewTargetObjects( Collection<Individual> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<IndividualBO> lTargetObjects = new ArrayList<IndividualBO>(pSourceObjects.size());
    for (Individual lNext : pSourceObjects) {
      IndividualBO lNewTargetObject = IndividualToIndividualBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource Individual object that should be used to update an existing IndividualBO object. The parameter must
   * not be null.
   * @return {@link IndividualBO} Updated IndividualBO object. The method never returns null.
   */
  public static IndividualBO updatePersistentTarget( Individual pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    IndividualBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), IndividualBO.class);
    IndividualToIndividualBOConverter lObjectMapper = IndividualToIndividualBOConverter.getConverter();
    lObjectMapper.applyMappings(pSource, lTargetObject, MappingType.UPDATE);
    return lTargetObject;
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
  public void applyMappings( Individual pSource, IndividualBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<Individual> pSources, List<IndividualBO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Individual> lSourceIterator = pSources.iterator();
    Iterator<IndividualBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new Individual object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   *
   * @param pTarget IndividualBO object that should be used to create a new Individual object. The parameter must not be
   * null.
   * @return {@link Individual} Created Individual object. The method never returns null.
   */
  public static Individual createNewSourceObject( IndividualBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    Individual.Builder lBuilder = Individual.builder();
    lBuilder.setID(pTarget.getID());
    Individual lNewSourceObject = lBuilder.build();
    IndividualToIndividualBOConverter lObjectMapper = IndividualToIndividualBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new Individual objects based on the passed IndividualBO objects. For every IndividualBO object a new
   * Individual object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<Individual> createNewSourceObjects( Collection<IndividualBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<Individual> lNewObjects = new ArrayList<Individual>(pTargetObjects.size());
    for (IndividualBO lNext : pTargetObjects) {
      Individual lNewSourceObject = IndividualToIndividualBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from Individual to IndividualBO. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Individual pSource, IndividualBO pTarget ) {
  }

  /**
   * Method maps all attributes from Individual to IndividualBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Individual pSource, IndividualBO pTarget ) {
    // Implementation is empty as no object mappings are defined in UML model in case of update
    // (ObjectMapping.onUpdate).
  }

  /**
   * Method maps all attributes from IndividualBO to Individual. Mappings are applied only for case
   * {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Individual pSource, IndividualBO pTarget ) {
  }

  /**
   * Method applies the object mappings for all combinations of the source's parent class with the target class and all
   * of its super classes.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  private void applyParentMappings( Individual pSource, IndividualBO pTarget, ObjectMapper.MappingType pMappingType ) {
    CustomerToCustomerBOConverter.getConverter().applyMappings(pSource, pTarget, pMappingType);
  }
}