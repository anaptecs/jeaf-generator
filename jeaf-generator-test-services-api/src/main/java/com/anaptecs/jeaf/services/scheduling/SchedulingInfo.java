/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.services.scheduling;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * This class describes additional information that may be useful for the scheduled service to do the right things when
 * triggered. The information are optional and will be passed to the executed service. In order to provide a flexible
 * mechanism to pass objects the called service, all SchedulingInfo objects will be stored by the Scheduling Service as
 * serialized objects within the database. This allows that there are task specific subclasses of this class.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class SchedulingInfo implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "parameters".
   */
  public static final String PARAMETERS = "parameters";

  /**
   * List contains all key value pairs that should be passed to a service when the task will be executed.
   */
  private Set<KeyValuePair> parameters = new HashSet<KeyValuePair>();

  /**
   * Initialize object. Nothing special to do.
   */
  public SchedulingInfo( ) {
    // Nothing to do.
  }

  /**
   * Method returns the association "parameters". List contains all key value pairs that should be passed to a service
   * when the task will be executed.
   *
   * @return Collection All KeyValuePair objects that belong to the association "parameters". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<KeyValuePair> getParameters( ) {
    // Return all KeyValuePair objects as unmodifiable collection.
    return Collections.unmodifiableSet(parameters);
  }

  /**
   * Method sets the association "parameters" to the passed collection. All objects that formerly were part of the
   * association will be removed from it. List contains all key value pairs that should be passed to a service when the
   * task will be executed.
   * 
   * @param pParameters Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setParameters( Set<KeyValuePair> pParameters ) {
    // Check of parameter is not required.
    // Remove all objects from association "parameters".
    this.clearParameters();
    // If the association is null, removing all entries is sufficient.
    if (pParameters != null) {
      parameters = new HashSet<KeyValuePair>(pParameters);
    }
  }

  /**
   * Method adds the passed KeyValuePair object to the association "parameters". List contains all key value pairs that
   * should be passed to a service when the task will be executed.
   * 
   * @param pParameters Object that should be added to the association "parameters". The parameter must not be null.
   */
  public void addToParameters( KeyValuePair pParameters ) {
    // Check parameter "pParameters" for invalid value null.
    Check.checkInvalidParameterNull(pParameters, "pParameters");
    // Add passed object to collection of associated KeyValuePair objects.
    parameters.add(pParameters);
  }

  /**
   * Method adds all passed objects to the association "parameters". List contains all key value pairs that should be
   * passed to a service when the task will be executed.
   * 
   * @param pParameters Collection with all objects that should be added to the association "parameters". The parameter
   * must not be null.
   */
  public void addToParameters( Collection<KeyValuePair> pParameters ) {
    // Check parameter "pParameters" for invalid value null.
    Check.checkInvalidParameterNull(pParameters, "pParameters");
    // Add all passed objects.
    for (KeyValuePair lNextObject : pParameters) {
      this.addToParameters(lNextObject);
    }
  }

  /**
   * Method removes the passed KeyValuePair object from the association "parameters". List contains all key value pairs
   * that should be passed to a service when the task will be executed.
   * 
   * @param pParameters Object that should be removed from the association "parameters". The parameter must not be null.
   */
  public void removeFromParameters( KeyValuePair pParameters ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pParameters, "pParameters");
    // Remove passed object from collection of associated KeyValuePair objects.
    parameters.remove(pParameters);
  }

  /**
   * Method removes all objects from the association "parameters". List contains all key value pairs that should be
   * passed to a service when the task will be executed.
   */
  public void clearParameters( ) {
    // Remove all objects from association "parameters".
    Collection<KeyValuePair> lParameters = new HashSet<KeyValuePair>(parameters);
    Iterator<KeyValuePair> lIterator = lParameters.iterator();
    while (lIterator.hasNext()) {
      this.removeFromParameters(lIterator.next());
    }
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects are
   * currently ignored.
   */
  @Override
  public String toString( ) {
    StringBuffer lBuffer = new StringBuffer(256);
    MessageRepository lRepo = XFun.getMessageRepository();
    lBuffer.append(lRepo.getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuffer.append('\n');
    lBuffer.append(lRepo.getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuffer.append('\n');
    return lBuffer.toString();
  }
}
