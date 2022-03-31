/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class LocalBeanParamType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @HeaderParam("localKey")
  @NotNull
  private String localKey;

  /**
   * 
   */
  @HeaderParam("localID")
  @NotNull
  private String localID;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected LocalBeanParamType( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LocalBeanParamType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    localKey = pBuilder.localKey;
    localID = pBuilder.localID;
  }

  /**
   * Class implements builder to create a new instance of class LocalBeanParamType. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String localKey;

    /**
     * 
     */
    private String localID;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(LocalBeanParamType)} instead of private constructor to create new builder.
     */
    protected Builder( LocalBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        localKey = pObject.localKey;
        localID = pObject.localID;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects. The method never
     * returns null.
     */
    public static Builder newBuilder( LocalBeanParamType pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "localKey".
     * 
     * @param pLocalKey Value to which the attribute "localKey" should be set.
     */
    public Builder setLocalKey( String pLocalKey ) {
      // Assign value to attribute
      localKey = pLocalKey;
      return this;
    }

    /**
     * Method sets the attribute "localID".
     * 
     * @param pLocalID Value to which the attribute "localID" should be set.
     */
    public Builder setLocalID( String pLocalID ) {
      // Assign value to attribute
      localID = pLocalID;
      return this;
    }

    /**
     * Method creates a new instance of class LocalBeanParamType. The object will be initialized with the values of the
     * builder.
     * 
     * @return LocalBeanParamType Created object. The method never returns null.
     */
    public LocalBeanParamType build( ) {
      return new LocalBeanParamType(this);
    }

    /**
     * Method creates a new validated instance of class LocalBeanParamType. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return LocalBeanParamType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public LocalBeanParamType buildValidated( ) throws ConstraintViolationException {
      LocalBeanParamType lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "localKey".
   * 
   * 
   * @return String Value to which the attribute "localKey" is set.
   */
  public String getLocalKey( ) {
    return localKey;
  }

  /**
   * Method sets the attribute "localKey".
   * 
   * 
   * @param pLocalKey Value to which the attribute "localKey" should be set.
   */
  public void setLocalKey( String pLocalKey ) {
    // Assign value to attribute
    localKey = pLocalKey;
  }

  /**
   * Method returns the attribute "localID".
   * 
   * 
   * @return String Value to which the attribute "localID" is set.
   */
  public String getLocalID( ) {
    return localID;
  }

  /**
   * Method sets the attribute "localID".
   * 
   * 
   * @param pLocalID Value to which the attribute "localID" should be set.
   */
  public void setLocalID( String pLocalID ) {
    // Assign value to attribute
    localID = pLocalID;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "localKey", "" + localKey));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "localID", "" + localID));
    lBuilder.append('\n');
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   * 
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder().toString();
  }
}
