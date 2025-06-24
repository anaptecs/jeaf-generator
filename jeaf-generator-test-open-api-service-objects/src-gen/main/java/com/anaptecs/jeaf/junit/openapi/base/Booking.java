/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

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
   * <br/>
   * <b>Default Value:</b> <code>42</code>
   */
  private static final int MAGIC_NUMER = 42;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Convenience method to create new instance of class Booking.
   *
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.Booking}
   */
  public static Booking of( BookingID pBookingID ) {
    var lBuilder = Booking.builder();
    lBuilder.setBookingID(pBookingID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Booking</code>.
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
        this.setBookingID(pObject.bookingID);
      }
    }

    /**
     * Method sets association {@link #bookingID}.<br/>
     *
     * @param pBookingID Value to which {@link #bookingID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingID( @MyNotNullProperty BookingID pBookingID ) {
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
      Booking lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #bookingID}.<br/>
   * ID of the booking
   *
   * @return {@link BookingID} Value to which {@link #bookingID} is set.
   */
  @MyNotNullProperty
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets association {@link #bookingID}.<br/>
   * ID of the booking
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   */
  public void setBookingID( @MyNotNullProperty BookingID pBookingID ) {
    bookingID = pBookingID;
  }

  /**
   * Method unsets {@link #bookingID}.
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}