/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
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

  /**
   * <br/>
   * <b>Default Value:</b> <code>42</code>
   */
  public static final int MAGIC = 42;

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
   * Convenience method to create new instance of class BookingID.
   *
   *
   * @param pPublicBookingID Value to which {@link #publicBookingID} should be set.
   *
   * @param pReferenceID Value to which {@link #referenceID} should be set.
   *
   * @param pExternalRefID Value to which {@link #externalRefID} should be set.
   *
   * @param pInventory Value to which {@link #inventory} should be set.
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   *
   * @return {@link com.anaptecs.spring.base.BookingID}
   */
  public static BookingID of( String pPublicBookingID, String pReferenceID, String pExternalRefID,
      InventoryType pInventory, BookingCode pBookingCode ) {
    BookingID.Builder lBuilder = BookingID.builder();
    lBuilder.setPublicBookingID(pPublicBookingID);
    lBuilder.setReferenceID(pReferenceID);
    lBuilder.setExternalRefID(pExternalRefID);
    lBuilder.setInventory(pInventory);
    lBuilder.setBookingCode(pBookingCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BookingID</code>.
   */
  public static class Builder {
    private String publicBookingID;

    private String referenceID;

    private String externalRefID;

    private InventoryType inventory;

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
        this.setPublicBookingID(pObject.publicBookingID);
        this.setReferenceID(pObject.referenceID);
        this.setExternalRefID(pObject.externalRefID);
        this.setInventory(pObject.inventory);
        this.setBookingCode(pObject.bookingCode);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new BookingID objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new BookingID objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BookingID pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #publicBookingID}.<br/>
     *
     * @param pPublicBookingID Value to which {@link #publicBookingID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPublicBookingID( @MyNotNullProperty String pPublicBookingID ) {
      // Assign value to attribute
      publicBookingID = pPublicBookingID;
      return this;
    }

    /**
     * Method sets attribute {@link #referenceID}.<br/>
     *
     * @param pReferenceID Value to which {@link #referenceID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReferenceID( @MyNotNullProperty String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this;
    }

    /**
     * Method sets attribute {@link #externalRefID}.<br/>
     *
     * @param pExternalRefID Value to which {@link #externalRefID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setExternalRefID( @MyNotNullProperty String pExternalRefID ) {
      // Assign value to attribute
      externalRefID = pExternalRefID;
      return this;
    }

    /**
     * Method sets association {@link #inventory}.<br/>
     *
     * @param pInventory Value to which {@link #inventory} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventory( @MyNotNullProperty InventoryType pInventory ) {
      inventory = pInventory;
      return this;
    }

    /**
     * Method sets association {@link #bookingCode}.<br/>
     *
     * @param pBookingCode Value to which {@link #bookingCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingCode( @MyNotNullProperty BookingCode pBookingCode ) {
      bookingCode = pBookingCode;
      return this;
    }

    /**
     * Method creates a new instance of class BookingID. The object will be initialized with the values of the builder.
     *
     * @return BookingID Created object. The method never returns null.
     */
    public BookingID build( ) {
      BookingID lObject = new BookingID(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #publicBookingID}.<br/>
   *
   * @return {@link String} Value to which {@link #publicBookingID} is set.
   */
  @MyNotNullProperty
  public String getPublicBookingID( ) {
    return publicBookingID;
  }

  /**
   * Method returns attribute {@link #referenceID}.<br/>
   *
   * @return {@link String} Value to which {@link #referenceID} is set.
   */
  @MyNotNullProperty
  public String getReferenceID( ) {
    return referenceID;
  }

  /**
   * Method returns attribute {@link #externalRefID}.<br/>
   *
   * @return {@link String} Value to which {@link #externalRefID} is set.
   */
  @MyNotNullProperty
  public String getExternalRefID( ) {
    return externalRefID;
  }

  /**
   * Method returns association {@link #inventory}.<br/>
   *
   * @return {@link InventoryType} Value to which {@link #inventory} is set.
   */
  @MyNotNullProperty
  public InventoryType getInventory( ) {
    return inventory;
  }

  /**
   * Method returns association {@link #bookingCode}.<br/>
   *
   * @return {@link BookingCode} Value to which {@link #bookingCode} is set.
   */
  @MyNotNullProperty
  public BookingCode getBookingCode( ) {
    return bookingCode;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(referenceID);
    lResult = lPrime * lResult + Objects.hashCode(externalRefID);
    lResult = lPrime * lResult + Objects.hashCode(inventory);
    lResult = lPrime * lResult + Objects.hashCode(bookingCode);
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
      BookingID lOther = (BookingID) pObject;
      lEquals = Objects.equals(referenceID, lOther.referenceID) && Objects.equals(externalRefID, lOther.externalRefID)
          && Objects.equals(inventory, lOther.inventory) && Objects.equals(bookingCode, lOther.bookingCode);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new BookingID objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}