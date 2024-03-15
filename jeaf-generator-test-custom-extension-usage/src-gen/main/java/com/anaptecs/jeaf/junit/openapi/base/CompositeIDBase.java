/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class CompositeIDBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "primaryCode".
   */
  public static final String PRIMARYCODE = "primaryCode";

  /**
   * Constant for the name of attribute "secondaryCode".
   */
  public static final String SECONDARYCODE = "secondaryCode";

  @ClassPropertyDeclaration
  private long primaryCode;

  private int primaryCodeXYZ = 0;

  @ClassPropertyDeclaration
  private long secondaryCode;

  private int secondaryCodeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CompositeIDBase( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CompositeIDBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    primaryCode = pBuilder.primaryCode;
    primaryCodeXYZ = pBuilder.primaryCodeXYZ;
    secondaryCode = pBuilder.secondaryCode;
    secondaryCodeXYZ = pBuilder.secondaryCodeXYZ;
  }

  /**
   * Class implements builder to create a new instance of class CompositeID. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    @BuilderPropertyDeclaration
    private long primaryCode;

    private int primaryCodeXYZ = 0;

    @BuilderPropertyDeclaration
    private long secondaryCode;

    private int secondaryCodeXYZ = 0;

    /**
     * Use {@link CompositeID.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link CompositeID.builder(CompositeID)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( CompositeIDBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        primaryCode = pObject.primaryCode;
        secondaryCode = pObject.secondaryCode;
      }
    }

    /**
     * Method sets attribute {@link #primaryCode}.<br/>
     *
     * @param pPrimaryCode Value to which {@link #primaryCode} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setPrimaryCode( long pPrimaryCode ) {
      // Assign value to attribute
      primaryCode = pPrimaryCode;
      return this;
    }

    public BuilderBase setPrimaryCodeXYZ( int value ) {
      primaryCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #secondaryCode}.<br/>
     *
     * @param pSecondaryCode Value to which {@link #secondaryCode} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setSecondaryCode( long pSecondaryCode ) {
      // Assign value to attribute
      secondaryCode = pSecondaryCode;
      return this;
    }

    public BuilderBase setSecondaryCodeXYZ( int value ) {
      secondaryCodeXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class CompositeID. The object will be initialized with the values of the
     * builder.
     *
     * @return CompositeID Created object. The method never returns null.
     */
    public CompositeID build( ) {
      return new CompositeID(this);
    }

    /**
     * Method creates a new validated instance of class CompositeID. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return CompositeID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public CompositeID buildValidated( ) throws ConstraintViolationException {
      CompositeID lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #primaryCode}.<br/>
   *
   * @return long Value to which {@link #primaryCode} is set.
   */
  public long getPrimaryCode( ) {
    return primaryCode;
  }

  /**
   * Method sets attribute {@link #primaryCode}.<br/>
   *
   * @param pPrimaryCode Value to which {@link #primaryCode} should be set.
   */
  public void setPrimaryCode( long pPrimaryCode ) {
    // Assign value to attribute
    primaryCode = pPrimaryCode;
  }

  public int getPrimaryCodeXYZ( ) {
    return primaryCodeXYZ;
  }

  public void setPrimaryCodeXYZ( int value ) {
    primaryCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #secondaryCode}.<br/>
   *
   * @return long Value to which {@link #secondaryCode} is set.
   */
  public long getSecondaryCode( ) {
    return secondaryCode;
  }

  /**
   * Method sets attribute {@link #secondaryCode}.<br/>
   *
   * @param pSecondaryCode Value to which {@link #secondaryCode} should be set.
   */
  public void setSecondaryCode( long pSecondaryCode ) {
    // Assign value to attribute
    secondaryCode = pSecondaryCode;
  }

  public int getSecondaryCodeXYZ( ) {
    return secondaryCodeXYZ;
  }

  public void setSecondaryCodeXYZ( int value ) {
    secondaryCodeXYZ = value;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("primaryCode: ");
    lBuilder.append(primaryCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("secondaryCode: ");
    lBuilder.append(secondaryCode);
    lBuilder.append(System.lineSeparator());
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
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new CompositeID objects. The method never returns
   * null.
   */
  public CompositeID.Builder toBuilder( ) {
    return new CompositeID.Builder((CompositeID) this);
  }
}
