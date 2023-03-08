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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Booking( ) {
    inventories = new ArrayList<InventoryType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Booking( Builder pBuilder ) {
    // Read attribute values from builder.
    bookingID = pBuilder.bookingID;
    customerName = pBuilder.customerName;
    if (pBuilder.inventories != null) {
      inventories = pBuilder.inventories;
    }
    else {
      inventories = new ArrayList<InventoryType>();
    }
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
     * 
     */
    private BookingID bookingID;

    /**
     * 
     */
    private String customerName;

    /**
     * 
     */
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
        bookingID = pObject.bookingID;
        customerName = pObject.customerName;
        inventories = pObject.inventories;
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
     * Method sets the association "bookingID".
     * 
     * @param pBookingID BookingID to which the association "bookingID" should be set.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      bookingID = pBookingID;
      return this;
    }

    /**
     * Method sets the attribute "customerName".
     * 
     * @param pCustomerName Value to which the attribute "customerName" should be set.
     */
    public Builder setCustomerName( String pCustomerName ) {
      // Assign value to attribute
      customerName = pCustomerName;
      return this;
    }

    /**
     * Method sets the association "inventories".
     * 
     * @param pInventories Collection with objects to which the association should be set.
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
     * Method sets the association "inventories".
     * 
     * @param pInventories Array with objects to which the association should be set.
     */
    public Builder setInventories( InventoryType... pInventories ) {
      // To ensure immutability we have to copy the content of the passed array.
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
  }

  /**
   * Method returns the association "bookingID".
   * 
   *
   * @return BookingID BookingID to which the association "bookingID" is set.
   */
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets the association "bookingID".
   * 
   * 
   * @param pBookingID BookingID to which the association "bookingID" should be set.
   */
  public void setBookingID( BookingID pBookingID ) {
    bookingID = pBookingID;
  }

  /**
   * Method unsets the association "bookingID".
   * 
   */
  public final void unsetBookingID( ) {
    bookingID = null;
  }

  /**
   * Method returns the attribute "customerName".
   * 
   * 
   * @return String Value to which the attribute "customerName" is set.
   */
  public String getCustomerName( ) {
    return customerName;
  }

  /**
   * Method sets the attribute "customerName".
   * 
   * 
   * @param pCustomerName Value to which the attribute "customerName" should be set.
   */
  public void setCustomerName( String pCustomerName ) {
    // Assign value to attribute
    customerName = pCustomerName;
  }

  /**
   * Method returns the association "inventories".
   * 
   *
   * @return Collection All InventoryType objects that belong to the association "inventories". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<InventoryType> getInventories( ) {
    // Return all InventoryType objects as unmodifiable collection.
    return Collections.unmodifiableList(inventories);
  }

  /**
   * Method adds the passed InventoryType object to the association "inventories".
   * 
   * 
   * @param pInventories Object that should be added to the association "inventories". The parameter must not be null.
   */
  public void addToInventories( InventoryType pInventories ) {
    // Add passed object to collection of associated InventoryType objects.
    inventories.add(pInventories);
  }

  /**
   * Method adds all passed objects to the association "inventories".
   * 
   * 
   * @param pInventories Collection with all objects that should be added to the association "inventories". The
   * parameter must not be null.
   */
  public void addToInventories( Collection<InventoryType> pInventories ) {
    // Add all passed objects.
    for (InventoryType lNextObject : pInventories) {
      this.addToInventories(lNextObject);
    }
  }

  /**
   * Method removes the passed InventoryType object from the association "inventories".
   * 
   * 
   * @param pInventories Object that should be removed from the association "inventories". The parameter must not be
   * null.
   */
  public void removeFromInventories( InventoryType pInventories ) {
    // Remove passed object from collection of associated InventoryType objects.
    inventories.remove(pInventories);
  }

  /**
   * Method removes all objects from the association "inventories".
   * 
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
}
