/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl;

import com.anaptecs.jeaf.accounting.Bank;
import com.anaptecs.jeaf.accounting.Person;
import com.anaptecs.jeaf.accounting.ResponsibilityType;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of AccountingBasicDataService.
 */
final class AccountingBasicDataServiceImpl extends AccountingBasicDataServiceImplBase {
  /**
   * Initialize object.
   */
  AccountingBasicDataServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * @param pType
   * @return {@link ResponsibilityType}
   */
  @Override
  public ResponsibilityType createResponsibilityType( ResponsibilityType pType ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Method creates a new persistent Bank object in the database.<br/>
   * <br/>
   * @param pBank Service object containing all the attributes to create a new persistent Bank object. The parameter
   * must not be null<br/>
   * @return Bank Service object describing the created bank object. The returned object contains besides the attributes
   * also the object id of the created persistent bank object. The method never returns null.
   * 
   * @param pBank
   * @return {@link Bank}
   */
  @Override
  public Bank createBank( Bank pBank ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * @param pPerson
   * @param pResponsibilityType
   * @param pBank
   * @return {@link ServiceObjectID}
   */
  @Override
  public ServiceObjectID createEmployee( Person pPerson, ResponsibilityType pResponsibilityType, Bank pBank ) {
    // TODO Implement method and return real result
    return null;
  }
}