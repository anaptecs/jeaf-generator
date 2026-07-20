/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotNullServiceParam;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;

public interface MultiVersioningTestService {
  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pPath
   * @param pRequest
   * @param myContext
   * @return {@link MyPOJOResponse}
   */
  @MyNotNullServiceParam
  MyPOJOResponse someRequest(
      @Size(min = 11, max = 42, groups = { V7.class }) @Size(
          min = 10,
          max = 666,
          groups = { V4.class, V5.class, V6.class }) @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam MyPojoRequest pRequest, @MyNotNullServiceParam MyContext myContext );
}