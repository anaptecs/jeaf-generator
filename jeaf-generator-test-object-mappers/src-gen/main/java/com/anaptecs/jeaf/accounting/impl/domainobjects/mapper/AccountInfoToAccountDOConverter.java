/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.domainobjects.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.accounting.AccountInfo;
import com.anaptecs.jeaf.accounting.impl.domainobjects.AccountDO;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.core.api.ObjectMapper;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.datatypeconverter.DatatypeConverter;

/**
 * Class implements an bidirectional object mapper between classes {@link AccountInfo} as source and {@link AccountDO}
 * as target.
 */
public class AccountInfoToAccountDOConverter implements ObjectMapper<AccountInfo, AccountDO> {
  /**
   * Only instance of this class. We can avoid to create multiple instances as object mapper implementations are
   * stateless and thread safe.
   */
  private static final AccountInfoToAccountDOConverter INSTANCE = new AccountInfoToAccountDOConverter();

  /**
   * Constructor is private. In order to avoid that unnecessary instances are created.
   */
  private AccountInfoToAccountDOConverter( ) {
  }

  /**
   * Method returns an instance of this object mapper.
   * 
   * @return {@link ObjectMapper} Instance an object mapper that is capable to map between AccountInfo and AccountDO.
   * The method never returns null.
   */
  public static AccountInfoToAccountDOConverter getConverter( ) {
    return INSTANCE;
  }

  /**
   * Method creates a new AccountDO object from the passed AccountInfo object and applies the defined mappings of type
   * {@link MappingType#CREATE} from the UML model.
   * 
   * @param pSource AccountInfo object that should be used to create a new AccountDO object. The parameter must not be
   * null.
   * @return {@link AccountDO} Created AccountDO object. The method never returns null.
   */
  public static AccountDO createNewTargetObject( AccountInfo pSource ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSource, "pSource");
    // Create new target object.
    AccountDO lTarget = new AccountDO();
    AccountInfoToAccountDOConverter lObjectMapper = AccountInfoToAccountDOConverter.getConverter();
    // Take value(s) from source, map them to target and return the created target object.
    lObjectMapper.applyMappings(pSource, lTarget, MappingType.CREATE);
    return lTarget;
  }

  /**
   * Method creates new AccountDO objects based on the passed AccountInfo objects. For every AccountInfo object a new
   * AccountDO object will be returned. The mappings for case {@link MappingType#CREATE} will be applied.
   * 
   * @param pSourceObjects All AccountInfo objects that should be used to create AccountDO objects. The parameter must
   * not be null.
   * @return {@link List} List with all AccountDO objects that were created. The method never returns null.
   */
  public static List<AccountDO> createNewTargetObjects( Collection<AccountInfo> pSourceObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pSourceObjects, "pSourceObjects");
    // Create new target object for every passed source object
    List<AccountDO> lTargetObjects = new ArrayList<AccountDO>(pSourceObjects.size());
    for (AccountInfo lNext : pSourceObjects) {
      AccountDO lNewTargetObject = AccountInfoToAccountDOConverter.createNewTargetObject(lNext);
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
  public void applyMappings( AccountInfo pSource, AccountDO pTarget, ObjectMapper.MappingType pMappingType ) {
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
  public void applyMappings( List<AccountInfo> pSources, List<AccountDO> pTargets,
      ObjectMapper.MappingType pMappingType ) {
    // Check parameters
    Check.checkInvalidParameterNull(pSources, "pSources");
    Check.checkInvalidParameterNull(pTargets, "pTargets");
    // Resolve iterators for sources and targets.
    Iterator<AccountInfo> lSourceIterator = pSources.iterator();
    Iterator<AccountDO> lTargetIterator = pTargets.iterator();
    // Apply mappings for each pair of source and target.
    while (lSourceIterator.hasNext()) {
      this.applyMappings(lSourceIterator.next(), lTargetIterator.next(), pMappingType);
    }
  }

  /**
   * Method creates a new AccountInfo object and applies the defined mappings of type {@link MappingType#READ} from the
   * UML model.
   * 
   * @param pTarget AccountDO object that should be used to create a new AccountInfo object. The parameter must not be
   * null.
   * @return {@link AccountInfo} Created AccountInfo object. The method never returns null.
   */
  public static AccountInfo createNewSourceObject( AccountDO pTarget ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTarget, "pTarget");
    // Create new source object, apply mappings and return created object.
    AccountInfo lNewSourceObject;
    DomainObjectID lDomainObjectID = pTarget.getDomainObjectID();
    if (lDomainObjectID != null) {
      AccountInfo.Builder lBuilder = AccountInfo.Builder.newBuilder();
      lBuilder.setID(lDomainObjectID);
      lNewSourceObject = lBuilder.build();
    }
    else {
      lNewSourceObject = AccountInfo.Builder.newBuilder().build();
    }
    AccountInfoToAccountDOConverter lObjectMapper = AccountInfoToAccountDOConverter.getConverter();
    lObjectMapper.applyMappings(lNewSourceObject, pTarget, MappingType.READ);
    return lNewSourceObject;
  }

  /**
   * Method creates new AccountInfo objects based on the passed AccountDO objects. For every AccountDO object a new
   * AccountInfo object will be returned. The mappings for case {@link MappingType#READ} will be applied.
   * 
   * @param pTargetObjects All target objects that should be used to create source objects. The parameter must not be
   * null.
   * @return {@link List} List with all source objects that were created. The method never returns null.
   */
  public static List<AccountInfo> createNewSourceObjects( Collection<AccountDO> pTargetObjects ) {
    // Check parameter
    Check.checkInvalidParameterNull(pTargetObjects, "pTargetObjects");
    // Create new source object for every passed target object.
    List<AccountInfo> lNewObjects = new ArrayList<AccountInfo>(pTargetObjects.size());
    for (AccountDO lNext : pTargetObjects) {
      AccountInfo lNewSourceObject = AccountInfoToAccountDOConverter.createNewSourceObject(lNext);
      lNewObjects.add(lNewSourceObject);
    }
    return lNewObjects;
  }

  /**
   * Method maps all attributes from AccountInfo to AccountDO. Mappings are applied only for case
   * {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setTargetObject( AccountInfo pSource, AccountDO pTarget ) {
    pTarget.setNumber(pSource.getIban());
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Double, BigDecimal> lBalanceConverter;
    lBalanceConverter = XFun.getDatatypeConverterRegistry().getConverter(Double.class, BigDecimal.class);
    pTarget.setBalance(lBalanceConverter.convert(pSource.getBalance()));
  }

  /**
   * Method maps all attributes from AccountInfo to AccountDO. Mappings are applied only for case
   * {@link MappingType#UPDATE}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void updateTargetObject( AccountInfo pSource, AccountDO pTarget ) {
    // Update target object
    pTarget.setNumber(pSource.getIban());
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<Double, BigDecimal> lBalanceConverter;
    lBalanceConverter = XFun.getDatatypeConverterRegistry().getConverter(Double.class, BigDecimal.class);
    pTarget.setBalance(lBalanceConverter.convert(pSource.getBalance()));
  }

  /**
   * Method maps all attributes from AccountDO to AccountInfo. Mappings are applied only for case
   * {@link MappingType#READ}.
   * 
   * @param pSource Source object for the mapping. The parameter must not be null.
   * @param pTarget Target object for the mapping. The parameter must not be null.
   */
  private void setSourceObject( AccountInfo pSource, AccountDO pTarget ) {
    pSource.setIban(pTarget.getNumber());
    // Datatype of source and target objects are not the same. Thus we are trying to find an appropriate converter.
    DatatypeConverter<BigDecimal, Double> lBalanceConverter;
    lBalanceConverter = XFun.getDatatypeConverterRegistry().getConverter(BigDecimal.class, Double.class);
    pSource.setBalance(lBalanceConverter.convert(pTarget.getBalance()));
    pSource.setBankID(pTarget.getBankID());
  }
}
