/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.scheduling;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.services.scheduling.SchedulingInfo;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of SchedulingTestService.
 */
final class SchedulingTestServiceImpl extends SchedulingTestServiceImplBase {
  /**
   * Initialize object.
   */
  SchedulingTestServiceImpl( Component pComponent ) {
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
   * Method is intended to be implemented by subclasses. Within the method the functionality that should be scheduled
   * has to be called. The method must not throw any ApplicationExceptions. They have to be handled by this method. In
   * case of technical problems a SystemException may be thrown.
   * 
   * @param pInfo pInfo Additional information that have been associated with the scheduled task when it was created.
   * The parameter is intended to be used to pass objects to the ScheduleableService implementation. Thus the
   * implementation has to decide if it expects a special subclass. The parameter is null if no additional information
   * were provided when the task was created.
   */
  @Override
  public void executeScheduledTask( SchedulingInfo pInfo ) {
  }
}