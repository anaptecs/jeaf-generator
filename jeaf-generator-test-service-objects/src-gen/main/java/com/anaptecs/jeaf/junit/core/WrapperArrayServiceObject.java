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
public class WrapperArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booleanArray".
   */
  public static final String BOOLEANARRAY = "booleanArray";

  /**
   * 
   */
  private Boolean[] booleanArray;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected WrapperArrayServiceObject( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WrapperArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booleanArray = pBuilder.booleanArray;
  }

  /**
   * Class implements builder to create a new instance of class WrapperArrayServiceObject. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Boolean[] booleanArray;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(WrapperArrayServiceObject)} instead of private constructor to create new builder.
     */
    protected Builder( WrapperArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        booleanArray = pObject.booleanArray;
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
     * @return {@link Builder} New builder that can be used to create new WrapperArrayServiceObject objects. The method
     * never returns null.
     */
    public static Builder newBuilder( WrapperArrayServiceObject pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "booleanArray".
     * 
     * @param pBooleanArray Value to which the attribute "booleanArray" should be set.
     */
    public Builder setBooleanArray( Boolean[] pBooleanArray ) {
      // Assign value to attribute
      if (pBooleanArray != null) {
        booleanArray = new Boolean[pBooleanArray.length];
        System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
      }
      else {
        booleanArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class WrapperArrayServiceObject. The object will be initialized with the values
     * of the builder.
     * 
     * @return WrapperArrayServiceObject Created object. The method never returns null.
     */
    public WrapperArrayServiceObject build( ) {
      return new WrapperArrayServiceObject(this);
    }

    /**
     * Method creates a new instance of class WrapperArrayServiceObject. The object will be initialized with the values
     * of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return WrapperArrayServiceObject Created object. The method never returns null.
     */
    public WrapperArrayServiceObject build( boolean pValidate ) {
      WrapperArrayServiceObject lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "booleanArray".
   * 
   * 
   * @return Boolean Value to which the attribute "booleanArray" is set.
   */
  public Boolean[] getBooleanArray( ) {
    Boolean[] lReturnValue;
    if (booleanArray != null) {
      lReturnValue = new Boolean[booleanArray.length];
      System.arraycopy(booleanArray, 0, lReturnValue, 0, booleanArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "booleanArray".
   * 
   * 
   * @param pBooleanArray Value to which the attribute "booleanArray" should be set.
   */
  public void setBooleanArray( Boolean[] pBooleanArray ) {
    // Assign value to attribute
    if (pBooleanArray != null) {
      booleanArray = new Boolean[pBooleanArray.length];
      System.arraycopy(pBooleanArray, 0, booleanArray, 0, pBooleanArray.length);
    }
    else {
      booleanArray = null;
    }
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