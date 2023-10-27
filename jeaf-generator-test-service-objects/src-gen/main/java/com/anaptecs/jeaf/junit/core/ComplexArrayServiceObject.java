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

public class ComplexArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "classBs".
   */
  public static final String CLASSBS = "classBs";

  private ClassB[] classBs;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    classBs = pBuilder.classBs;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects. The method
   * never returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( ComplexArrayServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class ComplexArrayServiceObject.
   *
   *
   * @return {@link ComplexArrayServiceObject}
   */
  public static ComplexArrayServiceObject of( ) {
    ComplexArrayServiceObject.Builder lBuilder = ComplexArrayServiceObject.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ComplexArrayServiceObject</code>.
   */
  public static class Builder {
    private ClassB[] classBs;

    /**
     * Use {@link ComplexArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplexArrayServiceObject#builder(ComplexArrayServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( ComplexArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setClassBs(pObject.classBs);
      }
    }

    /**
     * Method sets attribute {@link #classBs}.<br/>
     *
     * @param pClassBs Collection to which {@link #classBs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setClassBs( ClassB[] pClassBs ) {
      // Assign value to attribute
      if (pClassBs != null) {
        classBs = new ClassB[pClassBs.length];
        System.arraycopy(pClassBs, 0, classBs, 0, pClassBs.length);
      }
      else {
        classBs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ComplexArrayServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return ComplexArrayServiceObject Created object. The method never returns null.
     */
    public ComplexArrayServiceObject build( ) {
      ComplexArrayServiceObject lObject = new ComplexArrayServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ComplexArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return ComplexArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ComplexArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      ComplexArrayServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #classBs}.<br/>
   *
   * @return {@link ClassB} Value to which {@link #classBs} is set.
   */
  public ClassB[] getClassBs( ) {
    ClassB[] lReturnValue;
    if (classBs != null) {
      lReturnValue = new ClassB[classBs.length];
      System.arraycopy(classBs, 0, lReturnValue, 0, classBs.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #classBs}.<br/>
   *
   * @param pClassBs Value to which {@link #classBs} should be set.
   */
  public void setClassBs( ClassB[] pClassBs ) {
    // Assign value to attribute
    if (pClassBs != null) {
      classBs = new ClassB[pClassBs.length];
      System.arraycopy(pClassBs, 0, classBs, 0, pClassBs.length);
    }
    else {
      classBs = null;
    }
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
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
