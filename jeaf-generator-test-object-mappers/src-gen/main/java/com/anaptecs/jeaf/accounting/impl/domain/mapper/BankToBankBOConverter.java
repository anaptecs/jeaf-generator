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

import com.anaptecs.jeaf.accounting.Bank;
import com.anaptecs.jeaf.accounting.BankType;
import com.anaptecs.jeaf.accounting.impl.domain.BankBO;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProvider;
import com.anaptecs.jeaf.spi.persistence.PersistenceServiceProviderMessages;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.datatypeconverter.DatatypeConverter;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;

/**
 * Class implements an bidirectional object mapper between classes {@link Bank} as source and {@link BankBO} as target.
 */
public class BankToBankBOConverter implements ObjectMapper<Bank, BankBO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final BankToBankBOConverter INSTANCE = new BankToBankBOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private BankToBankBOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   *
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between Bank and BankBO. The method
   * never returns null.
   */
  public static BankToBankBOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new BankBO object from the passed Bank object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   *
   * @param pSource Bank object that should be used to create a new BankBO object. The parameter must not be null.
   * @return {@link BankBO} Created BankBO object. The method never returns null.
   */
  public static BankBO createNewTargetObject( Bank pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    BankBO lTarget = lPersistenceServiceProvider.createPersistentObject(BankBO.class);
    BankToBankBOConverter lObjectMapper = BankToBankBOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new BankBO objects based on the passed Bank objects. For every Bank object a new BankBO object will
   * be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   *
   * @param pSourceObjects All Bank objects that should be used to create BankBO objects. The parameter must not be
   * null.
   * @return {@link List} List with all BankBO objects that were created. The method never returns null.
   */
  public static List<BankBO> createNewTargetObjects( Collection<Bank> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<BankBO> lTargetObjects = new ArrayList<BankBO>(pSourceObjects.size());
    for (Bank lNext : pSourceObjects) {
      BankBO lNewTargetObject = BankToBankBOConverter.createNewTargetObject(lNext);
      lTargetObjects.add(lNewTargetObject);
    }
    // Return all created target objects.
    return lTargetObjects;
  }

  /**
   * Method updates an already existing persistent target object with the data of the passed source object according to
   * the mapping defined in the UML model.
   *
   * @param pSource Bank object that should be used to update an existing BankBO object. The parameter must not be null.
   * @return {@link BankBO} Updated BankBO object. The method never returns null.
   */
  public static BankBO updatePersistentTarget( Bank pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Load persistent object by ID of source object.
    PersistenceServiceProvider lPersistenceServiceProvider = JEAF.getServiceProvider(PersistenceServiceProvider.class);
    BankBO lTargetObject = lPersistenceServiceProvider.getPersistentObject(pSource.getID(), BankBO.class);
    BankToBankBOConverter lObjectMapper = BankToBankBOConverter.getConverter();
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
  public void applyMappings( Bank pSource, BankBO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<Bank> pSources, List<BankBO> pTargets, ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<Bank> lSourceIterator = pSources.iterator();
    Iterator<BankBO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new Bank object and applies the defined mappings of type {@link MappingType#READ} from the UML
   * model.
   *
   * @param pTarget BankBO object that should be used to create a new Bank object. The parameter must not be null.
   * @return {@link Bank} Created Bank object. The method never returns null.
   */
  public static Bank createNewSourceObject( BankBO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    Bank.Builder lBuilder = Bank.builder();
    lBuilder.setID(pTarget.getID());
    Bank lNewSourceObject = lBuilder.build();
    BankToBankBOConverter lObjectMapper = BankToBankBOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new Bank objects based on the passed BankBO objects. For every BankBO object a new Bank object will
   * be returned. The mappings for case {@link MappingType#READ} will be applied.
   *
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<Bank> createNewSourceObjects( Collection<BankBO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<Bank> lNewObjects = new ArrayList<Bank>(pTargetObjects.size());
    for (BankBO lNext : pTargetObjects) {
      Bank lNewSourceObject = BankToBankBOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from Bank to BankBO. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( Bank pSource, BankBO pTarget ) {
    pTarget.setName(pSource.getName());
    pTarget.setCode(pSource.getCode());
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<BankType, Short> lTypeConverter;
    lTypeConverter = XFun.getDatatypeConverterRegistry().getConverter(BankType.class, Short.class);
    pTarget.setType(lTypeConverter.convert(pSource.getType()));
  }

  /**
   * Method maps all attributes from Bank to BankBO. Mappings are applied only for case {@link MappingType#UPDATE}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( Bank pSource, BankBO pTarget ) {
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
      pTarget.setCode(pSource.getCode());
      // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
      DatatypeConverter<BankType, Short> lTypeConverter;
      lTypeConverter = XFun.getDatatypeConverterRegistry().getConverter(BankType.class, Short.class);
      pTarget.setType(lTypeConverter.convert(pSource.getType()));
    }
  }

  /**
   * Method maps all attributes from BankBO to Bank. Mappings are applied only for case {@link MappingType#READ}.
   *
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( Bank pSource, BankBO pTarget ) {
    pSource.setName(pTarget.getName());
    pSource.setCode(pTarget.getCode());
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Short, BankType> lTypeConverter;
    lTypeConverter = XFun.getDatatypeConverterRegistry().getConverter(Short.class, BankType.class);
    pSource.setType(lTypeConverter.convert(pTarget.getType()));
  }
}