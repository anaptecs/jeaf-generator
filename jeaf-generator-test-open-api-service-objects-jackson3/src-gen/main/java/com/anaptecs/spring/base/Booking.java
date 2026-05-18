/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonDeserialize(builder = Booking.Builder.class)
public class Booking {
  @NotNull
  private BookingID bookingID;

  @NotNull
  private String customerName;

  private List<InventoryType> inventories;

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
    customerName = pBuilder.customerName;
    inventories = (pBuilder.inventories == null) ? new ArrayList<>() : pBuilder.inventories;
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
   * @param pCustomerName Value to which {@link #customerName} should be set.
   *
   * @param pInventories Value to which {@link #inventories} should be set.
   *
   * @return {@link Booking}
   */
  public static Booking of( BookingID pBookingID, String pCustomerName, List<InventoryType> pInventories ) {
    var lBuilder = Booking.builder();
    lBuilder.setBookingID(pBookingID);
    lBuilder.setCustomerName(pCustomerName);
    lBuilder.setInventories(pInventories);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Booking</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private BookingID bookingID;

    private String customerName;

    private List<InventoryType> inventories;

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
        this.setCustomerName(pObject.customerName);
        this.setInventories(pObject.inventories);
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
     * Method sets attribute {@link #customerName}.<br/>
     *
     * @param pCustomerName Value to which {@link #customerName} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCustomerName( @MyNotNullProperty String pCustomerName ) {
      // Assign value to attribute
      customerName = pCustomerName;
      return this;
    }

    /**
     * Method sets association {@link #inventories}.<br/>
     *
     * @param pInventories Collection to which {@link #inventories} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventories( List<InventoryType> pInventories ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pInventories != null) {
        inventories = new ArrayList<InventoryType>(pInventories);
      }
      else {
        inventories = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #inventories}.<br/>
     *
     * @param pInventories Array of objects that should be added to {@link #inventories}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToInventories( InventoryType... pInventories ) {
      if (pInventories != null) {
        if (inventories == null) {
          inventories = new ArrayList<InventoryType>();
        }
        inventories.addAll(Arrays.asList(pInventories));
      }
      return this;
    }

    /**
     * Method sets association {@link #inventories}.<br/>
     *
     * @param pInventories Array with objects to which {@link #inventories} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventories( InventoryType... pInventories ) {
      // Copy the content of the passed array.
      if (pInventories != null) {
        inventories = new ArrayList<InventoryType>(Arrays.asList(pInventories));
      }
      else {
        inventories = null;
      }
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
   *
   * @return {@link BookingID} Value to which {@link #bookingID} is set.
   */
  @MyNotNullProperty
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets association {@link #bookingID}.<br/>
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
   * Method returns attribute {@link #customerName}.<br/>
   *
   * @return {@link String} Value to which {@link #customerName} is set.
   */
  @MyNotNullProperty
  public String getCustomerName( ) {
    return customerName;
  }

  /**
   * Method sets attribute {@link #customerName}.<br/>
   *
   * @param pCustomerName Value to which {@link #customerName} should be set.
   */
  public void setCustomerName( @MyNotNullProperty String pCustomerName ) {
    // Assign value to attribute
    customerName = pCustomerName;
  }

  /**
   * Method returns association {@link #inventories}.<br/>
   *
   * @return {@link List<InventoryType>} Value to which {@link #inventories} is set. The method never returns null and
   * the returned collection is modifiable.
   */
  public List<InventoryType> getInventories( ) {
    // Return all InventoryType objects directly without any protection against modification.
    return inventories;
  }

  /**
   * Method adds the passed object to {@link #inventories}.
   *
   * @param pInventories Object that should be added to {@link #inventories}. The parameter must not be null.
   */
  public void addToInventories( InventoryType pInventories ) {
    // Check parameter "pInventories" for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Add passed object to collection of associated InventoryType objects.
    inventories.add(pInventories);
  }

  /**
   * Method adds all passed objects to {@link #inventories}.
   *
   * @param pInventories Collection with all objects that should be added to {@link #inventories}. The parameter must
   * not be null.
   */
  public void addToInventories( Collection<InventoryType> pInventories ) {
    // Check parameter "pInventories" for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Add all passed objects.
    for (InventoryType lNextObject : pInventories) {
      this.addToInventories(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #inventories}.<br/>
   *
   * @param pInventories Object that should be removed from {@link #inventories}. The parameter must not be null.
   */
  public void removeFromInventories( InventoryType pInventories ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Remove passed object from collection of associated InventoryType objects.
    inventories.remove(pInventories);
  }

  /**
   * Method removes all objects from {@link #inventories}.
   */
  public void clearInventories( ) {
    // Remove all objects from association "inventories".
    inventories.clear();
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
    lBuilder.append(pIndent);
    lBuilder.append("customerName: ");
    lBuilder.append(customerName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("inventories: ");
    if (inventories != null) {
      lBuilder.append(inventories.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (inventories != null) {
      for (InventoryType lNext : inventories) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}