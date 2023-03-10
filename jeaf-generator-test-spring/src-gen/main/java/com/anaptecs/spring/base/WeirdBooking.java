/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeirdBooking {
  /**
   * Constant for the name of attribute "booking".
   */
  public static final String BOOKING = "booking";

  /**
   * Constant for the name of attribute "additionalBookings".
   */
  public static final String ADDITIONALBOOKINGS = "additionalBookings";

  private ComplexBookingID booking;

  private List<ComplexBookingID> additionalBookings;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WeirdBooking( ) {
    additionalBookings = new ArrayList<ComplexBookingID>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WeirdBooking( Builder pBuilder ) {
    // Read attribute values from builder.
    booking = pBuilder.booking;
    if (pBuilder.additionalBookings != null) {
      additionalBookings = pBuilder.additionalBookings;
    }
    else {
      additionalBookings = new ArrayList<ComplexBookingID>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects. The method never returns
   * null.
   */
  public static Builder builder( WeirdBooking pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class WeirdBooking. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    private ComplexBookingID booking;

    private List<ComplexBookingID> additionalBookings;

    /**
     * Use {@link WeirdBooking#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WeirdBooking#builder(WeirdBooking)} instead of private constructor to create new builder.
     */
    protected Builder( WeirdBooking pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        booking = pObject.booking;
        additionalBookings = pObject.additionalBookings;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new WeirdBooking objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new WeirdBooking objects. The method never returns
     * null.
     */
    public static Builder newBuilder( WeirdBooking pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "booking".
     * 
     * @param pBooking ComplexBookingID to which the association "booking" should be set.
     */
    public Builder setBooking( ComplexBookingID pBooking ) {
      booking = pBooking;
      return this;
    }

    /**
     * Method sets the association "additionalBookings".
     * 
     * @param pAdditionalBookings Collection with objects to which the association should be set.
     */
    public Builder setAdditionalBookings( List<ComplexBookingID> pAdditionalBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAdditionalBookings != null) {
        additionalBookings = new ArrayList<ComplexBookingID>(pAdditionalBookings);
      }
      else {
        additionalBookings = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class WeirdBooking. The object will be initialized with the values of the
     * builder.
     * 
     * @return WeirdBooking Created object. The method never returns null.
     */
    public WeirdBooking build( ) {
      return new WeirdBooking(this);
    }
  }

  /**
   * Method returns association {@link #booking}.<br/>
   * 
   * @return {@link ComplexBookingID} Value to which {@link #booking} is set.
   */
  public ComplexBookingID getBooking( ) {
    return booking;
  }

  /**
   * Method sets association {@link #booking}.<br/>
   * 
   * @param pBooking Value to which {@link #booking} should be set.
   */
  public void setBooking( ComplexBookingID pBooking ) {
    booking = pBooking;
  }

  /**
   * Method unsets {@link #booking}.
   */
  public final void unsetBooking( ) {
    booking = null;
  }

  /**
   * Method returns association {@link #additionalBookings}.<br/>
   * 
   * @return {@link List<ComplexBookingID>} Value to which {@link #additionalBookings} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<ComplexBookingID> getAdditionalBookings( ) {
    // Return all ComplexBookingID objects as unmodifiable collection.
    return Collections.unmodifiableList(additionalBookings);
  }

  /**
   * Method adds the passed object to {@link #additionalBookings}.
   * 
   * @param pAdditionalBookings Object that should be added to {@link #additionalBookings}. The parameter must not be
   * null.
   */
  public void addToAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Add passed object to collection of associated ComplexBookingID objects.
    additionalBookings.add(pAdditionalBookings);
  }

  /**
   * Method adds all passed objects to {@link #additionalBookings}.
   * 
   * @param pAdditionalBookings Collection with all objects that should be added to {@link #additionalBookings}. The
   * parameter must not be null.
   */
  public void addToAdditionalBookings( Collection<ComplexBookingID> pAdditionalBookings ) {
    // Add all passed objects.
    for (ComplexBookingID lNextObject : pAdditionalBookings) {
      this.addToAdditionalBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #additionalBookings}.<br/>
   * 
   * @param pAdditionalBookings Object that should be removed from {@link #additionalBookings}. The parameter must not
   * be null.
   */
  public void removeFromAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Remove passed object from collection of associated ComplexBookingID objects.
    additionalBookings.remove(pAdditionalBookings);
  }

  /**
   * Method removes all objects from {@link #additionalBookings}.
   */
  public void clearAdditionalBookings( ) {
    // Remove all objects from association "additionalBookings".
    additionalBookings.clear();
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
    lBuilder.append("booking: ");
    if (booking != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(booking.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("additionalBookings: ");
    if (additionalBookings != null) {
      lBuilder.append(additionalBookings.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (additionalBookings != null) {
      for (ComplexBookingID lNext : additionalBookings) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
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
