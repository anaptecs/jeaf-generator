/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Booking implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * ID of the booking
   */
  @NotNull
  private BookingID bookingID;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Booking( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Booking( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    bookingID = pBuilder.bookingID;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Booking objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns null.
   */
  public static Builder builder( Booking pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Booking. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * ID of the booking
     */
    private BookingID bookingID;

    /**
     * Use {@link Booking#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Booking#builder(Booking)} instead of private constructor to create new builder.
     */
    protected Builder( Booking pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        bookingID = pObject.bookingID;
      }
    }

    /**
     * Method sets the association "bookingID". ID of the booking
     * 
     * @param pBookingID BookingID to which the association "bookingID" should be set.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      bookingID = pBookingID;
      return this;
    }

    /**
     * Method creates a new instance of class Booking. The object will be initialized with the values of the builder.
     * 
     * @return Booking Created object. The method never returns null.
     */
    public Booking build( ) {
      return new Booking(this);
    }

    /**
     * Method creates a new validated instance of class Booking. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Booking Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Booking buildValidated( ) throws ConstraintViolationException {
      Booking lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "bookingID". ID of the booking
   *
   * @return BookingID BookingID to which the association "bookingID" is set.
   */
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets the association "bookingID". ID of the booking
   * 
   * @param pBookingID BookingID to which the association "bookingID" should be set.
   */
  public void setBookingID( BookingID pBookingID ) {
    bookingID = pBookingID;
  }

  /**
   * Method unsets the association "bookingID". ID of the booking
   */
  public final void unsetBookingID( ) {
    bookingID = null;
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
    lBuilder.append("bookingID: ");
    if (bookingID != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(bookingID.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
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
