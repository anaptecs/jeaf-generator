/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Valid
public class NotInlinedBeanParam implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @HeaderParam("header")
  @NotNull
  private String header;

  @HeaderParam("doubleCode")
  @Valid
  @NotNull
  private DoubleCode doubleCode;

  @HeaderParam("extensibleEnum")
  @NotNull
  private ExtensibleEnum extensibleEnum;

  @HeaderParam("bookingID")
  @Valid
  @NotNull
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pHeader, DoubleCode pDoubleCode, ExtensibleEnum pExtensibleEnum,
      BookingID pBookingID ) {
    Builder lBuilder = builder();
    lBuilder.setHeader(pHeader);
    lBuilder.setDoubleCode(pDoubleCode);
    lBuilder.setExtensibleEnum(pExtensibleEnum);
    lBuilder.setBookingID(pBookingID);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class NotInlinedBeanParam.
   *
   *
   * @param pHeader Value to which {@link #header} should be set.
   *
   * @param pDoubleCode Value to which {@link #doubleCode} should be set.
   *
   * @param pExtensibleEnum Value to which {@link #extensibleEnum} should be set.
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   *
   * @return {@link NotInlinedBeanParam}
   */
  public static NotInlinedBeanParam of( String pHeader, DoubleCode pDoubleCode, ExtensibleEnum pExtensibleEnum,
      BookingID pBookingID ) {
    var lBuilder = NotInlinedBeanParam.builder();
    lBuilder.setHeader(pHeader);
    lBuilder.setDoubleCode(pDoubleCode);
    lBuilder.setExtensibleEnum(pExtensibleEnum);
    lBuilder.setBookingID(pBookingID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>NotInlinedBeanParam</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String header;

    @Valid
    private DoubleCode doubleCode;

    private ExtensibleEnum extensibleEnum;

    @Valid
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(header);
    lResult = lPrime * lResult + Objects.hashCode(doubleCode);
    lResult = lPrime * lResult + Objects.hashCode(extensibleEnum);
    lResult = lPrime * lResult + Objects.hashCode(bookingID);
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
      NotInlinedBeanParam lOther = (NotInlinedBeanParam) pObject;
      lEquals = Objects.equals(header, lOther.header) && Objects.equals(doubleCode, lOther.doubleCode)
          && Objects.equals(extensibleEnum, lOther.extensibleEnum) && Objects.equals(bookingID, lOther.bookingID);
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