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

import com.anaptecs.jeaf.accounting.Person;
import com.anaptecs.jeaf.accounting.impl.domain.MyPersonBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link Person} as source and {@link MyPersonBO} as
 * target.
 */
public class PersonToMyPersonBOConverter implements ObjectMapper<Person, MyPersonBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final PersonToMyPersonBOConverter INSTANCE = new PersonToMyPersonBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private PersonToMyPersonBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Person and MyPersonBO. The
   * method never returns null.
   */
  public static PersonToMyPersonBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new MyPersonBO object from the passed Person object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource Person object that should be used to create a new MyPersonBO object. The parameter must not be null.
   * @return {@link MyPersonBO} Created MyPersonBO object. The method never returns null.
   */
  public static MyPersonBO createNewTargetObject( Person pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    MyPersonBO lTarget = lPersistenceServiceProvider.createPersistentObject(MyPersonBO.class);
    PersonToMyPersonBOConverter lObjectMapper = PersonToMyPersonBOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new MyPersonBO objects based on the passed Person objects. For every Person object a new MyPersonBO
   * object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All Person objects that should be used to create MyPersonBO objects. The parameter must not
   * be null.
   * @return {@link List} List with all MyPersonBO objects that were created. The method never returns null.
   */
  public static List<MyPersonBO> createNewTargetObjects( Collection<Person> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<MyPersonBO> lTargetObjects = new ArrayList<MyPersonBO>(pSourceObjects.size());
    for (Person lNext : pSourceObjects) {
      MyPersonBO lNewTargetObject = PersonToMyPersonBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource Person object that should be used to update an existing MyPersonBO object. The parameter must not be
   * null.
   * @return {@link MyPersonBO} Updated MyPersonBO object. The method never returns null.
   */
  public static MyPersonBO updatePersistentTarget( Person pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    MyPersonBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), MyPersonBO.class);
    PersonToMyPersonBOConverter lObjectMapper = PersonToMyPersonBOConverter.getConverter();
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
  public void applyMappings( Person pSource, MyPersonBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<Person> pSources, List<MyPersonBO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Person> lSourceIterator = pSources.iterator();
    Iterator<MyPersonBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new Person object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget MyPersonBO object that should be used to create a new Person object. The parameter must not be null.
   * @return {@link Person} Created Person object. The method never returns null.
   */
  public static Person createNewSourceObject( MyPersonBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    Person.Builder lBuilder = Person.builder();
    lBuilder.setID(pTarget.getID());
    Person lNewSourceObject = lBuilder.build();
    PersonToMyPersonBOConverter lObjectMapper = PersonToMyPersonBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new Person objects based on the passed MyPersonBO objects. For every MyPersonBO object a new Person
   * object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<Person> createNewSourceObjects( Collection<MyPersonBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<Person> lNewObjects = new ArrayList<Person>(pTargetObjects.size());
    for (MyPersonBO lNext : pTargetObjects) {
      Person lNewSourceObject = PersonToMyPersonBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from Person to MyPersonBO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Person pSource, MyPersonBO pTarget ) {
    pTarget.setName(pSource.getName());
    pTarget.setFirstName(pSource.getFirstName());
    pTarget.setDateOfBirth(pSource.getDateOfBirth());
  }

  /**
   * Method maps all attributes from Person to MyPersonBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Person pSource, MyPersonBO pTarget ) {
    // In order to avoid dirty writes on persistent objects, we first check for optimistic lock conflicts. Therefore we
    // have to compare version labels of source and target.
    Integer lSourceVersionLabel = pSource.getID().getVersionLabel();
    int lTargetVersionLabel = pTarget.getVersionLabel();
    // Optimistic lock conflict detected
    if (lSourceVersionLabel != null && lSourceVersionLabel.intValue() != lTargetVersionLabel) {
      String[] lParams = new String[] { pTarget.getClass().getName(), pTarget.getID().getObjectID(),
        lSourceVersionLabel.toString(), Integer.toString(pTarget.getVersionLabel()) };
      throw new JEAFSystemException(PersistenceServiceProviderMessages.OPTIMISTIC_LOCK_CONFLICT, lParams);
    }
    else {
      // Update target object
      pTarget.setName(pSource.getName());
      pTarget.setFirstName(pSource.getFirstName());
      pTarget.setDateOfBirth(pSource.getDateOfBirth());
    }
  }

  /**
   * Method maps all attributes from MyPersonBO to Person. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Person pSource, MyPersonBO pTarget ) {
    pSource.setName(pTarget.getName());
    pSource.setFirstName(pTarget.getFirstName());
    pSource.setDateOfBirth(pTarget.getDateOfBirth());
    pSource.setAge(pTarget.calculateAge());
    pSource.setDisplayName(pTarget.getFullName());
  }
}