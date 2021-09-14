/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.services.scheduling;

import com.anaptecs.jeaf.core.api.Service;

/**
 * Service defines the interface for service that should be called by the Scheduling Service when a task is ready for
 * execution. Therefore the service has to extend this interface.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface ScheduleableService extends Service {
  /**
   * Method is intended to be implemented by subclasses. Within the method the functionality that should be scheduled
   * has to be called. The method must not throw any ApplicationExceptions. They have to be handled by this method. In
   * case of technical problems a SystemException may be thrown.
   * 
   * 
   * @param pInfo pInfo Additional information that have been associated with the scheduled task when it was created.
   * The parameter is intended to be used to pass objects to the ScheduleableService implementation. Thus the
   * implementation has to decide if it expects a special subclass. The parameter is null if no additional information
   * were provided when the task was created.
   * 
   */
  void executeScheduledTask( SchedulingInfo pInfo );
}