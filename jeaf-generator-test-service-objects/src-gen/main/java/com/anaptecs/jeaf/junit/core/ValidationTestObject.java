/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Calendar;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class ValidationTestObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "myEMail".
   */
  public static final String MYEMAIL = "myEMail";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH = "dateOfBirth";

  @Email()
  @NotNull
  private String myEMail;

  @Past
  private Calendar dateOfBirth;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ValidationTestObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ValidationTestObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    myEMail = pBuilder.myEMail;
    dateOfBirth = pBuilder.dateOfBirth;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ValidationTestObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ValidationTestObject objects. The method never
   * returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( ValidationTestObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class ValidationTestObject.
   *
   *
   * @param pMyEMail Value to which {@link #myEMail} should be set.
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   *
   * @return {@link ValidationTestObject}
   */
  public static ValidationTestObject of( String pMyEMail, Calendar pDateOfBirth ) {
    ValidationTestObject.Builder lBuilder = ValidationTestObject.builder();
    lBuilder.setMyEMail(pMyEMail);
    lBuilder.setDateOfBirth(pDateOfBirth);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ValidationTestObject</code>.
   */
  public static class Builder {
    @Email()
    @NotNull
    private String myEMail;

    @Past
    private Calendar dateOfBirth;

    /**
     * Use {@link ValidationTestObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ValidationTestObject#builder(ValidationTestObject)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ValidationTestObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyEMail(pObject.myEMail);
        this.setDateOfBirth(pObject.dateOfBirth);
      }
    }

    /**
     * Method sets attribute {@link #myEMail}.<br/>
     *
     * @param pMyEMail Value to which {@link #myEMail} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMyEMail( String pMyEMail ) {
      // Assign value to attribute
      myEMail = pMyEMail;
      return this;
    }

    /**
     * Method sets attribute {@link #dateOfBirth}.<br/>
     *
     * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDateOfBirth( Calendar pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    /**
     * Method creates a new instance of class ValidationTestObject. The object will be initialized with the values of
     * the builder.
     *
     * @return ValidationTestObject Created object. The method never returns null.
     */
    public ValidationTestObject build( ) {
      ValidationTestObject lObject = new ValidationTestObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class ValidationTestObject. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return ValidationTestObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ValidationTestObject buildValidated( ) throws ConstraintViolationException {
      ValidationTestObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myEMail}.<br/>
   *
   * @return {@link String} Value to which {@link #myEMail} is set.
   */
  public String getMyEMail( ) {
    return myEMail;
  }

  /**
   * Method sets attribute {@link #myEMail}.<br/>
   *
   * @param pMyEMail Value to which {@link #myEMail} should be set.
   */
  public void setMyEMail( String pMyEMail ) {
    // Assign value to attribute
    myEMail = pMyEMail;
  }

  /**
   * Method returns attribute {@link #dateOfBirth}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #dateOfBirth} is set.
   */
  public Calendar getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets attribute {@link #dateOfBirth}.<br/>
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   */
  public void setDateOfBirth( Calendar pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
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
    lBuilder.append("myEMail: ");
    lBuilder.append(myEMail);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dateOfBirth: ");
    lBuilder.append(dateOfBirth);
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
   * @return {@link Builder} New builder that can be used to create new ValidationTestObject objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
