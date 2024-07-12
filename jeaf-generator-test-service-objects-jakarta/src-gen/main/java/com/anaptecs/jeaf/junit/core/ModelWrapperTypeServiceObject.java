/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class ModelWrapperTypeServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "aBoolean".
   */
  public static final String ABOOLEAN = "aBoolean";

  /**
   * Constant for the name of attribute "aInt".
   */
  public static final String AINT = "aInt";

  private boolean aBoolean;

  private Integer aInt;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ModelWrapperTypeServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ModelWrapperTypeServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    aBoolean = pBuilder.aBoolean;
    aInt = pBuilder.aInt;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ModelWrapperTypeServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ModelWrapperTypeServiceObject.
   *
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   *
   * @param pAInt Value to which {@link #aInt} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.core.ModelWrapperTypeServiceObject}
   */
  public static ModelWrapperTypeServiceObject of( boolean pABoolean, Integer pAInt ) {
    ModelWrapperTypeServiceObject.Builder lBuilder = ModelWrapperTypeServiceObject.builder();
    lBuilder.setABoolean(pABoolean);
    lBuilder.setAInt(pAInt);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ModelWrapperTypeServiceObject</code>.
   */
  public static class Builder {
    private boolean aBoolean;

    private Integer aInt;

    /**
     * Use {@link ModelWrapperTypeServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ModelWrapperTypeServiceObject#builder(ModelWrapperTypeServiceObject)} instead of private constructor
     * to create new builder.
     */
    protected Builder( ModelWrapperTypeServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setABoolean(pObject.aBoolean);
        this.setAInt(pObject.aInt);
      }
    }

    /**
     * Method sets attribute {@link #aBoolean}.<br/>
     *
     * @param pABoolean Value to which {@link #aBoolean} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setABoolean( boolean pABoolean ) {
      // Assign value to attribute
      aBoolean = pABoolean;
      return this;
    }

    /**
     * Method sets attribute {@link #aInt}.<br/>
     *
     * @param pAInt Value to which {@link #aInt} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAInt( Integer pAInt ) {
      // Assign value to attribute
      aInt = pAInt;
      return this;
    }

    /**
     * Method creates a new instance of class ModelWrapperTypeServiceObject. The object will be initialized with the
     * values of the builder.
     *
     * @return ModelWrapperTypeServiceObject Created object. The method never returns null.
     */
    public ModelWrapperTypeServiceObject build( ) {
      ModelWrapperTypeServiceObject lObject = new ModelWrapperTypeServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ModelWrapperTypeServiceObject. The object will be initialized
     * with the values of the builder and validated afterwards.
     *
     * @return ModelWrapperTypeServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ModelWrapperTypeServiceObject buildValidated( ) throws ConstraintViolationException {
      ModelWrapperTypeServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  @Deprecated
  public boolean getABoolean( ) {
    return aBoolean;
  }

  /**
   * Method returns attribute {@link #aBoolean}.<br/>
   *
   * @return boolean Value to which {@link #aBoolean} is set.
   */
  public boolean isABoolean( ) {
    return aBoolean;
  }

  /**
   * Method sets attribute {@link #aBoolean}.<br/>
   *
   * @param pABoolean Value to which {@link #aBoolean} should be set.
   */
  public void setABoolean( boolean pABoolean ) {
    // Assign value to attribute
    aBoolean = pABoolean;
  }

  /**
   * Method returns attribute {@link #aInt}.<br/>
   *
   * @return {@link Integer} Value to which {@link #aInt} is set.
   */
  public Integer getAInt( ) {
    return aInt;
  }

  /**
   * Method sets attribute {@link #aInt}.<br/>
   *
   * @param pAInt Value to which {@link #aInt} should be set.
   */
  public void setAInt( Integer pAInt ) {
    // Assign value to attribute
    aInt = pAInt;
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
    lBuilder.append("aBoolean: ");
    lBuilder.append(aBoolean);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("aInt: ");
    lBuilder.append(aInt);
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
   * @return {@link Builder} New builder that can be used to create new ModelWrapperTypeServiceObject objects. The
   * method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}