/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingID {
  /**
   * Constant for the name of attribute "publicBookingID".
   */
  public static final String PUBLICBOOKINGID = "publicBookingID";

  /**
   * Constant for the name of attribute "referenceID".
   */
  public static final String REFERENCEID = "referenceID";

  /**
   * Constant for the name of attribute "externalRefID".
   */
  public static final String EXTERNALREFID = "externalRefID";

  /**
   * Constant for the name of attribute "inventory".
   */
  public static final String INVENTORY = "inventory";

  /**
   * Constant for the name of attribute "bookingCode".
   */
  public static final String BOOKINGCODE = "bookingCode";

  private final transient String publicBookingID;

  private final String referenceID;

  private final String externalRefID;

  private final InventoryType inventory;

  private final BookingCode bookingCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BookingID( ) {
    publicBookingID = null;
    referenceID = null;
    externalRefID = null;
    inventory = null;
    bookingCode = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BookingID( Builder pBuilder ) {
    // Read attribute values from builder.
    publicBookingID = pBuilder.publicBookingID;
    referenceID = pBuilder.referenceID;
    externalRefID = pBuilder.externalRefID;
    inventory = pBuilder.inventory;
    bookingCode = pBuilder.bookingCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new BookingID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BookingID objects. The method never returns
   * null.
   */
  public static Builder builder( BookingID pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method converts the passed {@link String} into an instance of this object.
   *
   * Please be aware that this method is only intended to be used for deserialization frameworks like JAX-RS. For
   * "normal" object creation builder should be used instead.
   * 
   * @param pPublicBookingID String that should be used to create an instance of this class. The parameter must not be
   * null.
   * @return {@link BookingID} Instance of the class that matches to the passed string. The method never returns null.
   */
  public static BookingID valueOf( String pPublicBookingID ) {
    return builder().setPublicBookingID(String.valueOf(pPublicBookingID)).build();
  }

  /**
   * Class implements builder to create a new instance of class BookingID. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String publicBookingID;

    /**
     * 
     */
    private String referenceID;

    /**
     * 
     */
    private String externalRefID;

    /**
     * 
     */
    private InventoryType inventory;

    /**
     * 
     */
    private BookingCode bookingCode;

    /**
     * Use {@link BookingID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BookingID#builder(BookingID)} instead of private constructor to create new builder.
     */
    protected Builder( BookingID pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        publicBookingID = pObject.publicBookingID;
        referenceID = pObject.referenceID;
        externalRefID = pObject.externalRefID;
        inventory = pObject.inventory;
        bookingCode = pObject.bookingCode;
      }
    }

    /**
     * Method sets the attribute "publicBookingID".
     * 
     * @param pPublicBookingID Value to which the attribute "publicBookingID" should be set.
     */
    public Builder setPublicBookingID( String pPublicBookingID ) {
      // Assign value to attribute
      publicBookingID = pPublicBookingID;
      return this;
    }

    /**
     * Method sets the attribute "referenceID".
     * 
     * @param pReferenceID Value to which the attribute "referenceID" should be set.
     */
    public Builder setReferenceID( String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this;
    }

    /**
     * Method sets the attribute "externalRefID".
     * 
     * @param pExternalRefID Value to which the attribute "externalRefID" should be set.
     */
    public Builder setExternalRefID( String pExternalRefID ) {
      // Assign value to attribute
      externalRefID = pExternalRefID;
      return this;
    }

    /**
     * Method sets the association "inventory".
     * 
     * @param pInventory InventoryType to which the association "inventory" should be set.
     */
    public Builder setInventory( InventoryType pInventory ) {
      inventory = pInventory;
      return this;
    }

    /**
     * Method sets the association "bookingCode".
     * 
     * @param pBookingCode BookingCode to which the association "bookingCode" should be set.
     */
    public Builder setBookingCode( BookingCode pBookingCode ) {
      bookingCode = pBookingCode;
      return this;
    }

    /**
     * Method creates a new instance of class BookingID. The object will be initialized with the values of the builder.
     * 
     * @return BookingID Created object. The method never returns null.
     */
    public BookingID build( ) {
      return new BookingID(this);
    }
  }

  /**
   * Method returns the attribute "publicBookingID".
   * 
   * 
   * @return String Value to which the attribute "publicBookingID" is set.
   */
  public String getPublicBookingID( ) {
    return publicBookingID;
  }

  /**
   * Method returns the attribute "referenceID".
   * 
   * 
   * @return String Value to which the attribute "referenceID" is set.
   */
  public String getReferenceID( ) {
    return referenceID;
  }

  /**
   * Method returns the attribute "externalRefID".
   * 
   * 
   * @return String Value to which the attribute "externalRefID" is set.
   */
  public String getExternalRefID( ) {
    return externalRefID;
  }

  /**
   * Method returns the association "inventory".
   * 
   *
   * @return InventoryType InventoryType to which the association "inventory" is set.
   */
  public InventoryType getInventory( ) {
    return inventory;
  }

  /**
   * Method returns the association "bookingCode".
   * 
   *
   * @return BookingCode BookingCode to which the association "bookingCode" is set.
   */
  public BookingCode getBookingCode( ) {
    return bookingCode;
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
    lBuilder.append("publicBookingID: ");
    lBuilder.append(publicBookingID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("referenceID: ");
    lBuilder.append(referenceID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("externalRefID: ");
    lBuilder.append(externalRefID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("inventory: ");
    lBuilder.append(inventory);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bookingCode: ");
    if (bookingCode != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(bookingCode.toStringBuilder(pIndent + "    "));
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
