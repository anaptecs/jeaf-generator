/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.services.scheduling;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class describes a simple key value pair that can be passed to a service.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class KeyValuePair implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "key".
   */
  public static final String KEY = "key";

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * Key of the object. The attribute must not be null
   */
  private String key;

  /**
   * Value of the object. The attribute may be null.
   */
  private String value;

  /**
   * Initialize object. Nothing special to do.
   */
  public KeyValuePair( ) {
    // Nothing to do.
  }

  /**
   * Method returns the attribute "key". Key of the object. The attribute must not be null
   * 
   * @return String Value to which the attribute "key" is set.
   */
  public String getKey( ) {
    return key;
  }

  /**
   * Method sets the attribute "key". Key of the object. The attribute must not be null
   * 
   * @param pKey Value to which the attribute "key" should be set.
   */
  public void setKey( String pKey ) {
    // Assign value to attribute
    key = pKey;
  }

  /**
   * Method returns the attribute "value". Value of the object. The attribute may be null.
   * 
   * @return String Value to which the attribute "value" is set.
   */
  public String getValue( ) {
    return value;
  }

  /**
   * Method sets the attribute "value". Value of the object. The attribute may be null.
   * 
   * @param pValue Value to which the attribute "value" should be set.
   */
  public void setValue( String pValue ) {
    // Assign value to attribute
    value = pValue;
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
    lBuffer.append(lRepo.getMessage(XFunMessages.OBJECT_ATTRIBUTE, "key", "" + key));
    lBuffer.append('\n');
    lBuffer.append(lRepo.getMessage(XFunMessages.OBJECT_ATTRIBUTE, "value", "" + value));
    lBuffer.append('\n');
    return lBuffer.toString();
  }
}