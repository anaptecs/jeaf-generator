/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

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
@Valid()
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ReadonlyDefaultPOJOBase {
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
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadonlyDefaultPOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    readonlyDefault = pBuilder.readonlyDefault;
  }

  /**
   * Class implements builder to create a new instance of class ReadonlyDefaultPOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private int readonlyDefault = 4711;

    /**
     * Use {@link ReadonlyDefaultPOJO.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ReadonlyDefaultPOJO.Builder#newBuilder(ReadonlyDefaultPOJO)} instead of protected constructor to
     * create new builder.
     */
    protected BuilderBase( ReadonlyDefaultPOJOBase pObject ) {
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
     * Method creates a new instance of class ReadonlyDefaultPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return ReadonlyDefaultPOJO Created object. The method never returns null.
     */
    public ReadonlyDefaultPOJO build( ) {
      return new ReadonlyDefaultPOJO(this);
    }

    /**
     * Method creates a new instance of class ReadonlyDefaultPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ReadonlyDefaultPOJO Created object. The method never returns null.
     */
    public ReadonlyDefaultPOJO build( boolean pValidate ) {
      ReadonlyDefaultPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
