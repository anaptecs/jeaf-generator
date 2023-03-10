/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class NotInlinedBeanParam implements ServiceObject {
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

  private String header;

  private DoubleCode doubleCode;

  private ExtensibleEnum extensibleEnum;

  private BookingID bookingID;

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
    doubleCode = pBuilder.doubleCode;
    extensibleEnum = pBuilder.extensibleEnum;
    bookingID = pBuilder.bookingID;
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new NotInlinedBeanParam objects. The method never
   * returns null.
   */
  public static Builder builder( NotInlinedBeanParam pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class NotInlinedBeanParam. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    private String header;

    private DoubleCode doubleCode;

    private ExtensibleEnum extensibleEnum;

    private BookingID bookingID;

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
        header = pObject.header;
        doubleCode = pObject.doubleCode;
        extensibleEnum = pObject.extensibleEnum;
        bookingID = pObject.bookingID;
      }
    }

    /**
     * Method sets the attribute "header".
     * 
     * @param pHeader Value to which the attribute "header" should be set.
     */
    public Builder setHeader( String pHeader ) {
      // Assign value to attribute
      header = pHeader;
      return this;
    }

    /**
     * Method sets the attribute "doubleCode".
     * 
     * @param pDoubleCode Value to which the attribute "doubleCode" should be set.
     */
    public Builder setDoubleCode( DoubleCode pDoubleCode ) {
      // Assign value to attribute
      doubleCode = pDoubleCode;
      return this;
    }

    /**
     * Method sets the attribute "extensibleEnum".
     * 
     * @param pExtensibleEnum Value to which the attribute "extensibleEnum" should be set.
     */
    public Builder setExtensibleEnum( ExtensibleEnum pExtensibleEnum ) {
      // Assign value to attribute
      extensibleEnum = pExtensibleEnum;
      return this;
    }

    /**
     * Method sets the attribute "bookingID".
     * 
     * @param pBookingID Value to which the attribute "bookingID" should be set.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      // Assign value to attribute
      bookingID = pBookingID;
      return this;
    }

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
      NotInlinedBeanParam lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
}
