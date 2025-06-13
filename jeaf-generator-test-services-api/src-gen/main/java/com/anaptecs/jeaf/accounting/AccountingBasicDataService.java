/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface AccountingBasicDataService extends Service {
  /**
   * @param pType
   * @return {@link ResponsibilityType}
   */
  @JEAFCustomAnnotationTest
  ResponsibilityType createResponsibilityType( @JEAFCustomAnnotationTest ResponsibilityType pType );

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
  @JEAFCustomAnnotationTest
  Bank createBank( @JEAFCustomAnnotationTest @Valid @NotNull Bank pBank );

  /**
   * @param pPerson
   * @param pResponsibilityType
   * @param pBank
   * @return {@link ServiceObjectID}
   */
  @JEAFCustomAnnotationTest
  ServiceObjectID createEmployee( @JEAFCustomAnnotationTest Person pPerson,
      @JEAFCustomAnnotationTest ResponsibilityType pResponsibilityType, @JEAFCustomAnnotationTest Bank pBank );
}