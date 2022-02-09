/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
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
   * 
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
   * Class implements builder to create a new instance of class ReadonlyServiceObject. As the class has readonly
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
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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
     * Method creates a new instance of class ReadonlyServiceObject. The object will be initialized with the values of
     * the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ReadonlyServiceObject Created object. The method never returns null.
     */
    public ReadonlyServiceObject build( boolean pValidate ) {
      ReadonlyServiceObject lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "readonly", "" + readonly));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "readonlyDefault",
        "" + readonlyDefault));
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