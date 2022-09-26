/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ReadonlyServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "readonly".
   */
  public static final String READONLY = "readonly";

  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  /**
   * 
   */
  private final String readonly;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadonlyServiceObject( ) {
    readonly = null;
    readonlyDefault = 4711;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadonlyServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonly = pBuilder.readonly;
    readonlyDefault = pBuilder.readonlyDefault;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects. The method never
   * returns null.
   */
  public static Builder builder( ReadonlyServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ReadonlyServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String readonly;

    /**
     * 
     */
    private int readonlyDefault = 4711;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ReadonlyServiceObject)} instead of private constructor to create new builder.
     */
    protected Builder( ReadonlyServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        readonly = pObject.readonly;
        readonlyDefault = pObject.readonlyDefault;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ReadonlyServiceObject objects. The method
     * never returns null.
     */
    public static Builder newBuilder( ReadonlyServiceObject pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "readonly".
     * 
     * @param pReadonly Value to which the attribute "readonly" should be set.
     */
    public Builder setReadonly( String pReadonly ) {
      // Assign value to attribute
      readonly = pReadonly;
      return this;
    }

    /**
     * Method sets the attribute "readonlyDefault".
     * 
     * @param pReadonlyDefault Value to which the attribute "readonlyDefault" should be set.
     */
    public Builder setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

    /**
     * Method creates a new instance of class ReadonlyServiceObject. The object will be initialized with the values of
     * the builder.
     * 
     * @return ReadonlyServiceObject Created object. The method never returns null.
     */
    public ReadonlyServiceObject build( ) {
      return new ReadonlyServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class ReadonlyServiceObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ReadonlyServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadonlyServiceObject buildValidated( ) throws ConstraintViolationException {
      ReadonlyServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "readonly".
   * 
   * 
   * @return String Value to which the attribute "readonly" is set.
   */
  public String getReadonly( ) {
    return readonly;
  }

  /**
   * Method returns the attribute "readonlyDefault".
   * 
   * 
   * @return int Value to which the attribute "readonlyDefault" is set.
   */
  public int getReadonlyDefault( ) {
    return readonlyDefault;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "readonly", "" + readonly));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "readonlyDefault", "" + readonlyDefault));
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
