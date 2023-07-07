/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyBusinessObject {
  /**
   * Constant for the name of attribute "myBusinessAttribute".
   */
  public static final String MYBUSINESSATTRIBUTE = "myBusinessAttribute";

  private int myBusinessAttribute;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MyBusinessObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyBusinessObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    myBusinessAttribute = pBuilder.myBusinessAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyBusinessObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MyBusinessObject objects. The method never
   * returns null.
   */
  public static Builder builder( MyBusinessObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>MyBusinessObject</code>.
   */
  public static class Builder {
    private int myBusinessAttribute;

    /**
     * Use {@link MyBusinessObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyBusinessObject#builder(MyBusinessObject)} instead of private constructor to create new builder.
     */
    protected Builder( MyBusinessObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        myBusinessAttribute = pObject.myBusinessAttribute;
      }
    }

    /**
     * Method sets attribute {@link #myBusinessAttribute}.<br/>
     *
     * @param pMyBusinessAttribute Value to which {@link #myBusinessAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyBusinessAttribute( int pMyBusinessAttribute ) {
      // Assign value to attribute
      myBusinessAttribute = pMyBusinessAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class MyBusinessObject. The object will be initialized with the values of the
     * builder.
     *
     * @return MyBusinessObject Created object. The method never returns null.
     */
    public MyBusinessObject build( ) {
      return new MyBusinessObject(this);
    }

    /**
     * Method creates a new validated instance of class MyBusinessObject. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return MyBusinessObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MyBusinessObject buildValidated( ) throws ConstraintViolationException {
      MyBusinessObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myBusinessAttribute}.<br/>
   *
   * @return int Value to which {@link #myBusinessAttribute} is set.
   */
  public int getMyBusinessAttribute( ) {
    return myBusinessAttribute;
  }

  /**
   * Method sets attribute {@link #myBusinessAttribute}.<br/>
   *
   * @param pMyBusinessAttribute Value to which {@link #myBusinessAttribute} should be set.
   */
  public void setMyBusinessAttribute( int pMyBusinessAttribute ) {
    // Assign value to attribute
    myBusinessAttribute = pMyBusinessAttribute;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + myBusinessAttribute;
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      MyBusinessObject lOther = (MyBusinessObject) pObject;
      lEquals = myBusinessAttribute == lOther.myBusinessAttribute;
    }
    return lEquals;
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
    lBuilder.append("myBusinessAttribute: ");
    lBuilder.append(myBusinessAttribute);
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
}
