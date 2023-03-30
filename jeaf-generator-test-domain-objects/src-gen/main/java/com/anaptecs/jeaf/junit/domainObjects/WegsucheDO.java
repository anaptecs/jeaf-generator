/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import java.util.List;

import com.anaptecs.jeaf.core.api.DomainObjectID;

public class WegsucheDO extends WegsucheDOBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  public WegsucheDO( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   *
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public WegsucheDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * @return {@link List<PfadDO>}
   */
  @Override
  public List<PfadDO> suchePfade( ) {
    // TODO: Implement business logic for method.
    return null;
  }
}
