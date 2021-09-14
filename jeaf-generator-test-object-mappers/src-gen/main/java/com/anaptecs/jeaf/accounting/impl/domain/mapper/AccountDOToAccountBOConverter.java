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

import com.anaptecs.jeaf.accounting.impl.domain.AccountBO;
import com.anaptecs.jeaf.accounting.impl.domainobjects.AccountDO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link AccountDO} as source and {@link AccountBO} as
 * target.
 */
public class AccountDOToAccountBOConverter implements ObjectMapper<AccountDO, AccountBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final AccountDOToAccountBOConverter INSTANCE = new AccountDOToAccountBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private AccountDOToAccountBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   * 
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between AccountDO and AccountBO. The
   * method never returns null.
   */
  public static AccountDOToAccountBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new AccountBO object from the passed AccountDO object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   * 
   * @param pSource AccountDO object that should be used to create a new AccountBO object. The parameter must not be
   * null.
   * @return {@link AccountBO} Created AccountBO object. The method never returns null.
   */
  public static AccountBO createNewTargetObject( AccountDO pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    AccountBO lTarget = lPersistenceServiceProvider.createPersistentObject(AccountBO.class);
    AccountDOToAccountBOConverter lObjectMapper = AccountDOToAccountBOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new AccountBO objects based on the passed AccountDO objects. For every AccountDO object a new
   * AccountBO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   * 
   * @param pSourceObjects All AccountDO objects that should be used to create AccountBO objects. The parameter must not
   * be null.
   * @return {@link List} List with all AccountBO objects that were created. The method never returns null.
   */
  public static List<AccountBO> createNewTargetObjects( Collection<AccountDO> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<AccountBO> lTargetObjects = new ArrayList<AccountBO>(pSourceObjects.size());
    for (AccountDO lNext : pSourceObjects) {
      AccountBO lNewTargetObject = AccountDOToAccountBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   * 
   * @param pSource AccountDO object that should be used to update an existing AccountBO object. The parameter must not
   * be null.
   * @return {@link AccountBO} Updated AccountBO object. The method never returns null.
   */
  public static AccountBO updatePersistentTarget( AccountDO pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    AccountBO lTargetObject =
        lPersistenceServiceProvider.getPersistentObject(pSource.getDomainObjectID(), AccountBO.class);
    AccountDOToAccountBOConverter lObjectMapper = AccountDOToAccountBOConverter.getConverter();
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
  public void applyMappings( AccountDO pSource, AccountBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<AccountDO> pSources, List<AccountBO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<AccountDO> lSourceIterator = pSources.iterator();
    Iterator<AccountBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new AccountDO object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   * 
   * @param pTarget AccountBO object that should be used to create a new AccountDO object. The parameter must not be
   * null.
   * @return {@link AccountDO} Created AccountDO object. The method never returns null.
   */
  public static AccountDO createNewSourceObject( AccountBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    AccountDO lNewSourceObject = new AccountDO(pTarget.getID().transformToDomainObjectID());
    AccountDOToAccountBOConverter lObjectMapper = AccountDOToAccountBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new AccountDO objects based on the passed AccountBO objects. For every AccountBO object a new
   * AccountDO object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   * 
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<AccountDO> createNewSourceObjects( Collection<AccountBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<AccountDO> lNewObjects = new ArrayList<AccountDO>(pTargetObjects.size());
    for (AccountBO lNext : pTargetObjects) {
      AccountDO lNewSourceObject = AccountDOToAccountBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from AccountDO to AccountBO. Mappings are applied only for case
   * {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( AccountDO pSource, AccountBO pTarget ) {
    pTarget.setNumber(pSource.getNumber());
    pTarget.setInterestRate(pSource.getInterestRate());
  }

  /**
   * Method maps all attributes from AccountDO to AccountBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( AccountDO pSource, AccountBO pTarget ) {
    // In order to avoid dirty writes on persistent objects, we first check for optimistic lock conflicts. Therefore we
    // have to compare version labels of source and target.
    Integer lSourceVersionLabel = pSource.getDomainObjectID().getVersionLabel();
    int lTargetVersionLabel = pTarget.getVersionLabel();
    // Optimistic lock conflict detected
    if (lSourceVersionLabel != null && lSourceVersionLabel.intValue() != lTargetVersionLabel) {
      String[] lParams = new String[] { pTarget.getClass().getName(), pTarget.getID().getObjectID(),
        lSourceVersionLabel.toString(), Integer.toString(pTarget.getVersionLabel()) };
      throw new JEAFSystemException(PersistenceServiceProviderMessages.OPTIMISTIC_LOCK_CONFLICT, lParams);
    }
    else {
      // Update target object
      pTarget.setNumber(pSource.getNumber());
      pTarget.setInterestRate(pSource.getInterestRate());
    }
  }

  /**
   * Method maps all attributes from AccountBO to AccountDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( AccountDO pSource, AccountBO pTarget ) {
    pSource.setNumber(pTarget.getNumber());
    pSource.setInterestRate(pTarget.getInterestRate());
    pSource.setBalance(pTarget.calculateBalance());
  }
}
