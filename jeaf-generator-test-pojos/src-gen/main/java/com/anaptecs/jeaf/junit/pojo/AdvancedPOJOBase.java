/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@Valid
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AdvancedPOJOBase {
  /**
   * Constant for the name of attribute "readonlyDefault".
   */
  public static final String READONLYDEFAULT = "readonlyDefault";

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final int readonlyDefault;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected AdvancedPOJOBase( ) {
    readonlyDefault = 4711;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AdvancedPOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonlyDefault = pBuilder.readonlyDefault;
  }

  /**
   * Class implements builder to create a new instance of class AdvancedPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private int readonlyDefault = 4711;

    /**
     * Use {@link AdvancedPOJO.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AdvancedPOJO.Builder#newBuilder(AdvancedPOJO)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( AdvancedPOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        readonlyDefault = pObject.readonlyDefault;
      }
    }

    /**
     * Method sets the attribute "readonlyDefault".
     * 
     * @param pReadonlyDefault Value to which the attribute "readonlyDefault" should be set.
     */
    public BuilderBase setReadonlyDefault( int pReadonlyDefault ) {
      // Assign value to attribute
      readonlyDefault = pReadonlyDefault;
      return this;
    }

    /**
     * Method creates a new instance of class AdvancedPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return AdvancedPOJO Created object. The method never returns null.
     */
    public AdvancedPOJO build( ) {
      return new AdvancedPOJO(this);
    }

    /**
     * Method creates a new validated instance of class AdvancedPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return AdvancedPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public AdvancedPOJO buildValidated( ) throws ConstraintViolationException {
      AdvancedPOJO lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
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
   * 
   * @param pName
   * @return {@link Boolean}
   */
  public abstract boolean doSomething( String pName );

  /**
   * 
   * @return {@link int}
   */
  public abstract int returnPrimitive( );

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
