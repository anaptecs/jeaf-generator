/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.domainobjects;

import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

public class AccountDO extends AccountDOBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  public AccountDO( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public AccountDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * @return {@link ServiceObjectID}
   */
  @Override
  public ServiceObjectID getBankID( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}