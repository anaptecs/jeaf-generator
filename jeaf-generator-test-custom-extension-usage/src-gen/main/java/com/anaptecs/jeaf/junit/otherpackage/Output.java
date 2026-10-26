/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.otherpackage;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Output extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "myId".
   */
  @JEAFCustomAnnotationTest
  public static final String MYID = "myId";

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String myId;

  // "String"
  private int myIdXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Output( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Output( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    myId = pBuilder.myId;
    // "String"
    myIdXYZ = pBuilder.myIdXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Output objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Output</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String myId;

    // "String"
    private int myIdXYZ = 0;

    /**
     * Use {@link Output#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Output#builder(Output)} instead of private constructor to create new builder.
     */
    protected Builder( Output pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyId(pObject.myId);
      }
    }

    /**
     * Method sets attribute {@link #myId}.<br/>
     *
     * @param pMyId Value to which {@link #myId} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setMyId( String pMyId ) {
      // Assign value to attribute
      myId = pMyId;
      return this;
    }

    public Builder setMyIdXYZ( int value ) {
      // "String"
      myIdXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class Output. The object will be initialized with the values of the builder.
     *
     * @return Output Created object. The method never returns null.
     */
    public Output build( ) {
      return new Output(this);
    }

    /**
     * Method creates a new validated instance of class Output. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Output Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Output buildValidated( ) throws ConstraintViolationException {
      Output lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myId}.<br/>
   *
   * @return {@link String} Value to which {@link #myId} is set.
   */
  @JEAFCustomAnnotationTest
  public String getMyId( ) {
    return myId;
  }

  /**
   * Method sets attribute {@link #myId}.<br/>
   *
   * @param pMyId Value to which {@link #myId} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setMyId( String pMyId ) {
    // Assign value to attribute
    myId = pMyId;
  }

  public int getMyIdXYZ( ) {
    // "String"
    return myIdXYZ;
  }

  public void setMyIdXYZ( int value ) {
    myIdXYZ = value;
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
    lBuilder.append("myId: ");
    lBuilder.append(myId);
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
   * @return {@link Builder} New builder that can be used to create new Output objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}