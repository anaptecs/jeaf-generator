/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Booking.Builder.class)
public class Booking {
  /**
   * Constant for the name of attribute "bookingID".
   */
  public static final String BOOKINGID = "bookingID";

  /**
   * Constant for the name of attribute "customerName".
   */
  public static final String CUSTOMERNAME = "customerName";

  /**
   * Constant for the name of attribute "inventories".
   */
  public static final String INVENTORIES = "inventories";

  private BookingID bookingID;

  private String customerName;

  private List<InventoryType> inventories;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Booking( Builder pBuilder ) {
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
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new Booking objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Booking pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets association {@link #bookingID}.<br/>
     *
     * @param pBookingID Value to which {@link #bookingID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
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
    @JsonSetter(nulls = Nulls.SKIP)
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
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
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
      Booking lObject = new Booking(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
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
   * the returned collection is unmodifiable.
   */
  public List<InventoryType> getInventories( ) {
    // Return all InventoryType objects as unmodifiable collection.
    return Collections.unmodifiableList(inventories);
  }

  /**
   * Method adds the passed object to {@link #inventories}.
   *
   * @param pInventories Object that should be added to {@link #inventories}. The parameter must not be null.
   */
  public void addToInventories( InventoryType pInventories ) {
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(bookingID);
    lResult = lPrime * lResult + Objects.hashCode(customerName);
    lResult = lPrime * lResult + Objects.hashCode(inventories);
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
      Booking lOther = (Booking) pObject;
      lEquals = Objects.equals(bookingID, lOther.bookingID) && Objects.equals(customerName, lOther.customerName)
          && Objects.equals(inventories, lOther.inventories);
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