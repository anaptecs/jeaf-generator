/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.transientback;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class ReadOnlyClientBase extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "transientMaster".
   */
  public static final String TRANSIENTMASTER = "transientMaster";

  // "String"
  @ClassPropertyDeclaration
  private final String name;

  // "String"
  private int nameXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyMaster"
  @ClassPropertyDeclaration
  private transient ReadOnlyMaster transientMaster;

  // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyMaster"
  private int transientMasterXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ReadOnlyClientBase( ) {
    name = null;
    transientMaster = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ReadOnlyClientBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    // "String"
    nameXYZ = pBuilder.nameXYZ;
  }

  /**
   * Class implements builder to create a new instance of class ReadOnlyClient. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    // "String"
    @BuilderPropertyDeclaration
    private String name;

    // "String"
    private int nameXYZ = 0;

    /**
     * Use {@link ReadOnlyClient.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ReadOnlyClient.builder(ReadOnlyClient)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ReadOnlyClientBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    public BuilderBase setNameXYZ( int value ) {
      // "String"
      nameXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ReadOnlyClient. The object will be initialized with the values of the
     * builder.
     *
     * @return ReadOnlyClient Created object. The method never returns null.
     */
    public ReadOnlyClient build( ) {
      return new ReadOnlyClient(this);
    }

    /**
     * Method creates a new validated instance of class ReadOnlyClient. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return ReadOnlyClient Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ReadOnlyClient buildValidated( ) throws ConstraintViolationException {
      ReadOnlyClient lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  public int getNameXYZ( ) {
    // "String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns association {@link #transientMaster}.<br/>
   *
   * @return {@link ReadOnlyMaster} Value to which {@link #transientMaster} is set.
   */
  public ReadOnlyMaster getTransientMaster( ) {
    return transientMaster;
  }

  /**
   * Method sets association {@link #transientMaster}.<br/>
   *
   * @param pTransientMaster Value to which {@link #transientMaster} should be set.
   */
  void setTransientMaster( ReadOnlyMaster pTransientMaster ) {
    transientMaster = pTransientMaster;
  }

  public int getTransientMasterXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.transientback.ReadOnlyMaster"
    return transientMasterXYZ;
  }

  public void setTransientMasterXYZ( int value ) {
    transientMasterXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
    lBuilder.append("name: ");
    lBuilder.append(name);
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
   * @return {@link Builder} New builder that can be used to create new ReadOnlyClient objects. The method never returns
   * null.
   */
  public ReadOnlyClient.Builder toBuilder( ) {
    return new ReadOnlyClient.Builder((ReadOnlyClient) this);
  }
}