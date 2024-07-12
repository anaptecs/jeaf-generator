/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
public class NotInlinedBeanParam extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "header".
   */
  public static final String HEADER = "header";

  /**
   * Constant for the name of attribute "doubleCode".
   */
  public static final String DOUBLECODE = "doubleCode";

  /**
   * Constant for the name of attribute "extensibleEnum".
   */
  public static final String EXTENSIBLEENUM = "extensibleEnum";

  /**
   * Constant for the name of attribute "bookingID".
   */
  public static final String BOOKINGID = "bookingID";

  // "String"
  @ClassPropertyDeclaration
  private String header;

  // "String"
  private int headerXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
  @ClassPropertyDeclaration
  private DoubleCode doubleCode;

  // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
  private int doubleCodeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  @ClassPropertyDeclaration
  private ExtensibleEnum extensibleEnum;

  // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
  private int extensibleEnumXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
  @ClassPropertyDeclaration
  private BookingID bookingID;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
  private int bookingIDXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected NotInlinedBeanParam( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected NotInlinedBeanParam( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    header = pBuilder.header;
    // "String"
    headerXYZ = pBuilder.headerXYZ;
    doubleCode = pBuilder.doubleCode;
    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    doubleCodeXYZ = pBuilder.doubleCodeXYZ;
    extensibleEnum = pBuilder.extensibleEnum;
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    extensibleEnumXYZ = pBuilder.extensibleEnumXYZ;
    bookingID = pBuilder.bookingID;
    // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
    bookingIDXYZ = pBuilder.bookingIDXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new NotInlinedBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>NotInlinedBeanParam</code>.
   */
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String header;

    // "String"
    private int headerXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    @BuilderPropertyDeclaration
    private DoubleCode doubleCode;

    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    private int doubleCodeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    @BuilderPropertyDeclaration
    private ExtensibleEnum extensibleEnum;

    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    private int extensibleEnumXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
    @BuilderPropertyDeclaration
    private BookingID bookingID;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
    private int bookingIDXYZ = 0;

    /**
     * Use {@link NotInlinedBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link NotInlinedBeanParam#builder(NotInlinedBeanParam)} instead of private constructor to create new
     * builder.
     */
    protected Builder( NotInlinedBeanParam pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setHeader(pObject.header);
        this.setDoubleCode(pObject.doubleCode);
        this.setExtensibleEnum(pObject.extensibleEnum);
        this.setBookingID(pObject.bookingID);
      }
    }

    /**
     * Method sets attribute {@link #header}.<br/>
     *
     * @param pHeader Value to which {@link #header} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHeader( String pHeader ) {
      // Assign value to attribute
      header = pHeader;
      return this;
    }

    public Builder setHeaderXYZ( int value ) {
      // "String"
      headerXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #doubleCode}.<br/>
     *
     * @param pDoubleCode Value to which {@link #doubleCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDoubleCode( DoubleCode pDoubleCode ) {
      // Assign value to attribute
      doubleCode = pDoubleCode;
      return this;
    }

    public Builder setDoubleCodeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
      doubleCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #extensibleEnum}.<br/>
     *
     * @param pExtensibleEnum Value to which {@link #extensibleEnum} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setExtensibleEnum( ExtensibleEnum pExtensibleEnum ) {
      // Assign value to attribute
      extensibleEnum = pExtensibleEnum;
      return this;
    }

    public Builder setExtensibleEnumXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
      extensibleEnumXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bookingID}.<br/>
     *
     * @param pBookingID Value to which {@link #bookingID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      // Assign value to attribute
      bookingID = pBookingID;
      return this;
    }

    public Builder setBookingIDXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
      bookingIDXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class NotInlinedBeanParam. The object will be initialized with the values of the
     * builder.
     *
     * @return NotInlinedBeanParam Created object. The method never returns null.
     */
    public NotInlinedBeanParam build( ) {
      return new NotInlinedBeanParam(this);
    }

    /**
     * Method creates a new validated instance of class NotInlinedBeanParam. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return NotInlinedBeanParam Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public NotInlinedBeanParam buildValidated( ) throws ConstraintViolationException {
      NotInlinedBeanParam lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #header}.<br/>
   *
   * @return {@link String} Value to which {@link #header} is set.
   */
  public String getHeader( ) {
    return header;
  }

  /**
   * Method sets attribute {@link #header}.<br/>
   *
   * @param pHeader Value to which {@link #header} should be set.
   */
  public void setHeader( String pHeader ) {
    // Assign value to attribute
    header = pHeader;
  }

  public int getHeaderXYZ( ) {
    // "String"
    return headerXYZ;
  }

  public void setHeaderXYZ( int value ) {
    headerXYZ = value;
  }

  /**
   * Method returns attribute {@link #doubleCode}.<br/>
   *
   * @return {@link DoubleCode} Value to which {@link #doubleCode} is set.
   */
  public DoubleCode getDoubleCode( ) {
    return doubleCode;
  }

  /**
   * Method sets attribute {@link #doubleCode}.<br/>
   *
   * @param pDoubleCode Value to which {@link #doubleCode} should be set.
   */
  public void setDoubleCode( DoubleCode pDoubleCode ) {
    // Assign value to attribute
    doubleCode = pDoubleCode;
  }

  public int getDoubleCodeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.DoubleCode"
    return doubleCodeXYZ;
  }

  public void setDoubleCodeXYZ( int value ) {
    doubleCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #extensibleEnum}.<br/>
   *
   * @return {@link ExtensibleEnum} Value to which {@link #extensibleEnum} is set.
   */
  public ExtensibleEnum getExtensibleEnum( ) {
    return extensibleEnum;
  }

  /**
   * Method sets attribute {@link #extensibleEnum}.<br/>
   *
   * @param pExtensibleEnum Value to which {@link #extensibleEnum} should be set.
   */
  public void setExtensibleEnum( ExtensibleEnum pExtensibleEnum ) {
    // Assign value to attribute
    extensibleEnum = pExtensibleEnum;
  }

  public int getExtensibleEnumXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum"
    return extensibleEnumXYZ;
  }

  public void setExtensibleEnumXYZ( int value ) {
    extensibleEnumXYZ = value;
  }

  /**
   * Method returns attribute {@link #bookingID}.<br/>
   *
   * @return {@link BookingID} Value to which {@link #bookingID} is set.
   */
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets attribute {@link #bookingID}.<br/>
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   */
  public void setBookingID( BookingID pBookingID ) {
    // Assign value to attribute
    bookingID = pBookingID;
  }

  public int getBookingIDXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BookingID"
    return bookingIDXYZ;
  }

  public void setBookingIDXYZ( int value ) {
    bookingIDXYZ = value;
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
    lBuilder.append("header: ");
    lBuilder.append(header);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCode: ");
    lBuilder.append(doubleCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("extensibleEnum: ");
    lBuilder.append(extensibleEnum);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bookingID: ");
    lBuilder.append(bookingID);
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
   * @return {@link Builder} New builder that can be used to create new NotInlinedBeanParam objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}