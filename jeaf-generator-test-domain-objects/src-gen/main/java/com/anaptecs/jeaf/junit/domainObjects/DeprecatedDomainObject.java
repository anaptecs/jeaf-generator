/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.domainObjects;

import com.anaptecs.jeaf.core.api.DomainObjectID;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> , <b>removed with:</b> )
 */
@Deprecated
public class DeprecatedDomainObject extends DeprecatedDomainObjectBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  public DeprecatedDomainObject( ) {
    // Nothing to do.
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public DeprecatedDomainObject( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
  * 
  */
  @Override
  public void doSomething( ) {
    // TODO: Implement business logic for method.
  }

  /**
   * 
   * @return {@link byte}
   */
  @Override
  public byte returnPrimitive( ) {
    // TODO: Implement business logic for method.
    return 0;
  }
}