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

import com.anaptecs.jeaf.accounting.Account;
import com.anaptecs.jeaf.accounting.impl.domain.AccountBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link Account} as source and {@link AccountBO} as
 * target.
 */
public class AccountToAccountBOConverter implements ObjectMapper<Account, AccountBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final AccountToAccountBOConverter INSTANCE = new AccountToAccountBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private AccountToAccountBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   * 
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Account and AccountBO. The
   * method never returns null.
   */
  public static AccountToAccountBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new AccountBO object from the passed Account object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   * 
   * @param pSource Account object that should be used to create a new AccountBO object. The parameter must not be null.
   * @return {@link AccountBO} Created AccountBO object. The method never returns null.
   */
  public static AccountBO createNewTargetObject( Account pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    AccountBO lTarget = lPersistenceServiceProvider.createPersistentObject(AccountBO.class);
    AccountToAccountBOConverter lObjectMapper = AccountToAccountBOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new AccountBO objects based on the passed Account objects. For every Account object a new AccountBO
   * object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   * 
   * @param pSourceObjects All Account objects that should be used to create AccountBO objects. The parameter must not
   * be null.
   * @return {@link List} List with all AccountBO objects that were created. The method never returns null.
   */
  public static List<AccountBO> createNewTargetObjects( Collection<Account> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<AccountBO> lTargetObjects = new ArrayList<AccountBO>(pSourceObjects.size());
    for (Account lNext : pSourceObjects) {
      AccountBO lNewTargetObject = AccountToAccountBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   * 
   * @param pSource Account object that should be used to update an existing AccountBO object. The parameter must not be
   * null.
   * @return {@link AccountBO} Updated AccountBO object. The method never returns null.
   */
  public static AccountBO updatePersistentTarget( Account pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    AccountBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), AccountBO.class);
    AccountToAccountBOConverter lObjectMapper = AccountToAccountBOConverter.getConverter();
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
  public void applyMappings( Account pSource, AccountBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<Account> pSources, List<AccountBO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Account> lSourceIterator = pSources.iterator();
    Iterator<AccountBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new Account object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   * 
   * @param pTarget AccountBO object that should be used to create a new Account object. The parameter must not be null.
   * @return {@link Account} Created Account object. The method never returns null.
   */
  public static Account createNewSourceObject( AccountBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    Account.Builder lBuilder = Account.Builder.newBuilder();
    lBuilder.setID(pTarget.getID());
    Account lNewSourceObject = lBuilder.build();
    AccountToAccountBOConverter lObjectMapper = AccountToAccountBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new Account objects based on the passed AccountBO objects. For every AccountBO object a new Account
   * object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   * 
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<Account> createNewSourceObjects( Collection<AccountBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<Account> lNewObjects = new ArrayList<Account>(pTargetObjects.size());
    for (AccountBO lNext : pTargetObjects) {
      Account lNewSourceObject = AccountToAccountBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from Account to AccountBO. Mappings are applied only for case {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Account pSource, AccountBO pTarget ) {
    pTarget.setNumber(pSource.getIban());
  }

  /**
   * Method maps all attributes from Account to AccountBO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Account pSource, AccountBO pTarget ) {
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
      pTarget.setNumber(pSource.getIban());
    }
  }

  /**
   * Method maps all attributes from AccountBO to Account. Mappings are applied only for case {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Account pSource, AccountBO pTarget ) {
    pSource.setIban(pTarget.getNumber());
    pSource.setBalance(pTarget.calculateBalance());
  }
}
