/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.util.Calendar;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class ValidationTestObject extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "myEMail".
   */
  @JEAFCustomAnnotationTest
  public static final String MYEMAIL = "myEMail";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  @JEAFCustomAnnotationTest
  public static final String DATEOFBIRTH = "dateOfBirth";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Email()
  @NotNull
  private String myEMail;

  // "java.lang.String"
  private int myEMailXYZ = 0;

  // "java.util.Calendar"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Past
  private Calendar dateOfBirth;

  // "java.util.Calendar"
  private int dateOfBirthXYZ = 0;

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
    // "java.lang.String"
    myEMailXYZ = pBuilder.myEMailXYZ;
    dateOfBirth = pBuilder.dateOfBirth;
    // "java.util.Calendar"
    dateOfBirthXYZ = pBuilder.dateOfBirthXYZ;
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
   * Class implements builder to create a new instance of class <code>ValidationTestObject</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Email()
    @NotNull
    private String myEMail;

    // "java.lang.String"
    private int myEMailXYZ = 0;

    // "java.util.Calendar"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Past
    private Calendar dateOfBirth;

    // "java.util.Calendar"
    private int dateOfBirthXYZ = 0;

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
    @JEAFCustomAnnotationTest
    public Builder setMyEMail( String pMyEMail ) {
      // Assign value to attribute
      myEMail = pMyEMail;
      return this;
    }

    public Builder setMyEMailXYZ( int value ) {
      // "java.lang.String"
      myEMailXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #dateOfBirth}.<br/>
     *
     * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setDateOfBirth( Calendar pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    public Builder setDateOfBirthXYZ( int value ) {
      // "java.util.Calendar"
      dateOfBirthXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class ValidationTestObject. The object will be initialized with the values of
     * the builder.
     *
     * @return ValidationTestObject Created object. The method never returns null.
     */
    public ValidationTestObject build( ) {
      return new ValidationTestObject(this);
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
  @JEAFCustomAnnotationTest
  public String getMyEMail( ) {
    return myEMail;
  }

  /**
   * Method sets attribute {@link #myEMail}.<br/>
   *
   * @param pMyEMail Value to which {@link #myEMail} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyEMail( String pMyEMail ) {
    // Assign value to attribute
    myEMail = pMyEMail;
  }

  public int getMyEMailXYZ( ) {
    // "java.lang.String"
    return myEMailXYZ;
  }

  public void setMyEMailXYZ( int value ) {
    myEMailXYZ = value;
  }

  /**
   * Method returns attribute {@link #dateOfBirth}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #dateOfBirth} is set.
   */
  @JEAFCustomAnnotationTest
  public Calendar getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets attribute {@link #dateOfBirth}.<br/>
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setDateOfBirth( Calendar pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
  }

  public int getDateOfBirthXYZ( ) {
    // "java.util.Calendar"
    return dateOfBirthXYZ;
  }

  public void setDateOfBirthXYZ( int value ) {
    dateOfBirthXYZ = value;
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