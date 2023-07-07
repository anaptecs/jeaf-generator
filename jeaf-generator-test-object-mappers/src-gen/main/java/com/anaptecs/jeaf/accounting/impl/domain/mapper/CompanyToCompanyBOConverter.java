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

import com.anaptecs.jeaf.accounting.Company;
import com.anaptecs.jeaf.accounting.impl.domain.CompanyBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link Company} as source and {@link CompanyBO} as
 * target.
 */
public class CompanyToCompanyBOConverter implements ObjectMapper<Company, CompanyBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final CompanyToCompanyBOConverter INSTANCE = new CompanyToCompanyBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private CompanyToCompanyBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Company and CompanyBO. The
   * method never returns null.
   */
  public static CompanyToCompanyBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new CompanyBO object from the passed Company object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource Company object that should be used to create a new CompanyBO object. The parameter must not be null.
   * @return {@link CompanyBO} Created CompanyBO object. The method never returns null.
   */
  public static CompanyBO createNewTargetObject( Company pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    CompanyBO lTarget = lPersistenceServiceProvider.createPersistentObject(CompanyBO.class);
    CompanyToCompanyBOConverter lObjectMapper = CompanyToCompanyBOConverter.getConverter();
    // As class Company also has a super class we have to retrieve a mapper for its super class as well. The delegate is
    // responsible for applying all mappings of the super classes.
    lObjectMapper.applyParentMappings(pSource, lTarget, MappingType.CREATE);
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new CompanyBO objects based on the passed Company objects. For every Company object a new CompanyBO
   * object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All Company objects that should be used to create CompanyBO objects. The parameter must not
   * be null.
   * @return {@link List} List with all CompanyBO objects that were created. The method never returns null.
   */
  public static List<CompanyBO> createNewTargetObjects( Collection<Company> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<CompanyBO> lTargetObjects = new ArrayList<CompanyBO>(pSourceObjects.size());
    for (Company lNext : pSourceObjects) {
      CompanyBO lNewTargetObject = CompanyToCompanyBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource Company object that should be used to update an existing CompanyBO object. The parameter must not be
   * null.
   * @return {@link CompanyBO} Updated CompanyBO object. The method never returns null.
   */
  public static CompanyBO updatePersistentTarget( Company pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    CompanyBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), CompanyBO.class);
    CompanyToCompanyBOConverter lObjectMapper = CompanyToCompanyBOConverter.getConverter();
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
  public void applyMappings( Company pSource, CompanyBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<Company> pSources, List<CompanyBO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Company> lSourceIterator = pSources.iterator();
    Iterator<CompanyBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new Company object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget CompanyBO object that should be used to create a new Company object. The parameter must not be null.
   * @return {@link Company} Created Company object. The method never returns null.
   */
  public static Company createNewSourceObject( CompanyBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    Company.Builder lBuilder = Company.builder();
    lBuilder.setID(pTarget.getID());
    Company lNewSourceObject = lBuilder.build();
    CompanyToCompanyBOConverter lObjectMapper = CompanyToCompanyBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new Company objects based on the passed CompanyBO objects. For every CompanyBO object a new Company
   * object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<Company> createNewSourceObjects( Collection<CompanyBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<Company> lNewObjects = new ArrayList<Company>(pTargetObjects.size());
    for (CompanyBO lNext : pTargetObjects) {
      Company lNewSourceObject = CompanyToCompanyBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from Company to CompanyBO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Company pSource, CompanyBO pTarget ) {
    pTarget.setName(pSource.getName());
    pTarget.setRegistrationNumber(pSource.getRegistrationNumber());
    pTarget.setTaxNumber(pSource.getTaxNumber());
  }

  /**
   * Method maps all attributes from Company to CompanyBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Company pSource, CompanyBO pTarget ) {
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
      pTarget.setTaxNumber(pSource.getTaxNumber());
    }
  }

  /**
   * Method maps all attributes from CompanyBO to Company. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Company pSource, CompanyBO pTarget ) {
    pSource.setName(pTarget.getName());
    pSource.setRegistrationNumber(pTarget.getRegistrationNumber());
    pSource.setTaxNumber(pTarget.getTaxNumber());
  }

  /**
   * Method applies the object mappings for all combinations of the source's parent class with the target class and all
   * of its super classes.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   * @param pMappingType Parameter defines which type of mapping should be applied.
   */
  private void applyParentMappings( Company pSource, CompanyBO pTarget, ObjectMapper.MappingType pMappingType ) {
    CustomerToCustomerBOConverter.getConverter().applyMappings(pSource, pTarget, pMappingType);
  }
}
