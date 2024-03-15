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

public class ParentBeanParamType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "novaKey".
   */
  public static final String NOVAKEY = "novaKey";

  /**
   * Constant for the name of attribute "tkID".
   */
  public static final String TKID = "tkID";

  // "String"
  @ClassPropertyDeclaration
  private String novaKey;

  // "String"
  private int novaKeyXYZ = 0;

  // "String"
  @ClassPropertyDeclaration
  private String tkID;

  // "String"
  private int tkIDXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentBeanParamType( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentBeanParamType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    novaKey = pBuilder.novaKey;
    // "String"
    novaKeyXYZ = pBuilder.novaKeyXYZ;
    tkID = pBuilder.tkID;
    // "String"
    tkIDXYZ = pBuilder.tkIDXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentBeanParamType</code>.
   */
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String novaKey;

    // "String"
    private int novaKeyXYZ = 0;

    // "String"
    @BuilderPropertyDeclaration
    private String tkID;

    // "String"
    private int tkIDXYZ = 0;

    /**
     * Use {@link ParentBeanParamType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentBeanParamType#builder(ParentBeanParamType)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ParentBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setNovaKey(pObject.novaKey);
        this.setTkID(pObject.tkID);
      }
    }

    /**
     * Method sets attribute {@link #novaKey}.<br/>
     *
     * @param pNovaKey Value to which {@link #novaKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNovaKey( String pNovaKey ) {
      // Assign value to attribute
      novaKey = pNovaKey;
      return this;
    }

    public Builder setNovaKeyXYZ( int value ) {
      // "String"
      novaKeyXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #tkID}.<br/>
     *
     * @param pTkID Value to which {@link #tkID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTkID( String pTkID ) {
      // Assign value to attribute
      tkID = pTkID;
      return this;
    }

    public Builder setTkIDXYZ( int value ) {
      // "String"
      tkIDXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class ParentBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentBeanParamType Created object. The method never returns null.
     */
    public ParentBeanParamType build( ) {
      return new ParentBeanParamType(this);
    }

    /**
     * Method creates a new validated instance of class ParentBeanParamType. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ParentBeanParamType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentBeanParamType buildValidated( ) throws ConstraintViolationException {
      ParentBeanParamType lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #novaKey}.<br/>
   *
   * @return {@link String} Value to which {@link #novaKey} is set.
   */
  public String getNovaKey( ) {
    return novaKey;
  }

  /**
   * Method sets attribute {@link #novaKey}.<br/>
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   */
  public void setNovaKey( String pNovaKey ) {
    // Assign value to attribute
    novaKey = pNovaKey;
  }

  public int getNovaKeyXYZ( ) {
    // "String"
    return novaKeyXYZ;
  }

  public void setNovaKeyXYZ( int value ) {
    novaKeyXYZ = value;
  }

  /**
   * Method returns attribute {@link #tkID}.<br/>
   *
   * @return {@link String} Value to which {@link #tkID} is set.
   */
  public String getTkID( ) {
    return tkID;
  }

  /**
   * Method sets attribute {@link #tkID}.<br/>
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   */
  public void setTkID( String pTkID ) {
    // Assign value to attribute
    tkID = pTkID;
  }

  public int getTkIDXYZ( ) {
    // "String"
    return tkIDXYZ;
  }

  public void setTkIDXYZ( int value ) {
    tkIDXYZ = value;
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
    lBuilder.append("novaKey: ");
    lBuilder.append(novaKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("tkID: ");
    lBuilder.append(tkID);
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
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
