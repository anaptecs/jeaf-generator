/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.spring.composite.ComplexBookingID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WeirdBooking.Builder.class)
public class WeirdBooking implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

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
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WeirdBooking( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booking = pBuilder.booking;
    if (pBuilder.additionalBookings != null) {
      additionalBookings = pBuilder.additionalBookings;
    }
    else {
      additionalBookings = new ArrayList<>();
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( ComplexBookingID pBooking ) {
    Builder lBuilder = builder();
    lBuilder.setBooking(pBooking);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class WeirdBooking.
   *
   *
   * @param pBooking Value to which {@link #booking} should be set.
   *
   * @return {@link WeirdBooking}
   */
  public static WeirdBooking of( ComplexBookingID pBooking ) {
    var lBuilder = WeirdBooking.builder();
    lBuilder.setBooking(pBooking);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>WeirdBooking</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
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
        this.setBooking(pObject.booking);
        this.setAdditionalBookings(pObject.additionalBookings);
      }
    }

    /**
     * Method sets association {@link #booking}.<br/>
     *
     * @param pBooking Value to which {@link #booking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooking( ComplexBookingID pBooking ) {
      booking = pBooking;
      return this;
    }

    /**
     * Method sets association {@link #additionalBookings}.<br/>
     *
     * @param pAdditionalBookings Collection to which {@link #additionalBookings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #additionalBookings}.<br/>
     *
     * @param pAdditionalBookings Array of objects that should be added to {@link #additionalBookings}. The parameter
     * may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToAdditionalBookings( ComplexBookingID... pAdditionalBookings ) {
      if (pAdditionalBookings != null) {
        if (additionalBookings == null) {
          additionalBookings = new ArrayList<ComplexBookingID>();
        }
        additionalBookings.addAll(Arrays.asList(pAdditionalBookings));
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

    /**
     * Method creates a new validated instance of class WeirdBooking. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return WeirdBooking Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WeirdBooking buildValidated( ) throws ConstraintViolationException {
      WeirdBooking lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
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
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
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
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
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
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}