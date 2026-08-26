/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullServiceParam;
import reactor.core.publisher.Mono;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
 */
@Deprecated
public interface AnotherDeprecatedRESTServiceReactive {
  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @deprecated (<b>since:</b> TBD, <b>removed with:</b> 7.0, <b>removal date:</b> 2026-09-13)
   */
  @Deprecated
  @NotNull
  @MyNotNullServiceParam
  Mono<Void> operationOfADeprecatedService( );
}