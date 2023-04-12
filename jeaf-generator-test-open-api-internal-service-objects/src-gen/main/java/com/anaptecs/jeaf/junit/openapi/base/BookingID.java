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
 * Type represents a booking ID.
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class BookingID implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String referenceID;

  @NotNull
  private String externalRefID;

  @NotNull
  private InventoryType inventory;

  @Valid
  @NotNull
  private BookingCode bookingCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BookingID( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BookingID( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pReferenceID, String pExternalRefID, InventoryType pInventory,
      BookingCode pBookingCode ) {
    Builder lBuilder = builder();
    lBuilder.setReferenceID(pReferenceID);
    lBuilder.setExternalRefID(pExternalRefID);
    lBuilder.setInventory(pInventory);
    lBuilder.setBookingCode(pBookingCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>BookingID</code>.
   */
  public static class Builder {
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
        referenceID = pObject.referenceID;
        externalRefID = pObject.externalRefID;
        inventory = pObject.inventory;
        bookingCode = pObject.bookingCode;
      }
    }

    /**
     * Method sets attribute {@link #referenceID}.<br/>
     *
     * @param pReferenceID Value to which {@link #referenceID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReferenceID( String pReferenceID ) {
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
    public Builder setExternalRefID( String pExternalRefID ) {
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
    public Builder setInventory( InventoryType pInventory ) {
      inventory = pInventory;
      return this;
    }

    /**
     * Method sets association {@link #bookingCode}.<br/>
     *
     * @param pBookingCode Value to which {@link #bookingCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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

    /**
     * Method creates a new validated instance of class BookingID. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return BookingID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BookingID buildValidated( ) throws ConstraintViolationException {
      BookingID lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #referenceID}.<br/>
   *
   * @return {@link String} Value to which {@link #referenceID} is set.
   */
  public String getReferenceID( ) {
    return referenceID;
  }

  /**
   * Method sets attribute {@link #referenceID}.<br/>
   *
   * @param pReferenceID Value to which {@link #referenceID} should be set.
   */
  public void setReferenceID( String pReferenceID ) {
    // Assign value to attribute
    referenceID = pReferenceID;
  }

  /**
   * Method returns attribute {@link #externalRefID}.<br/>
   *
   * @return {@link String} Value to which {@link #externalRefID} is set.
   */
  public String getExternalRefID( ) {
    return externalRefID;
  }

  /**
   * Method sets attribute {@link #externalRefID}.<br/>
   *
   * @param pExternalRefID Value to which {@link #externalRefID} should be set.
   */
  public void setExternalRefID( String pExternalRefID ) {
    // Assign value to attribute
    externalRefID = pExternalRefID;
  }

  /**
   * Method returns association {@link #inventory}.<br/>
   *
   * @return {@link InventoryType} Value to which {@link #inventory} is set.
   */
  public InventoryType getInventory( ) {
    return inventory;
  }

  /**
   * Method sets association {@link #inventory}.<br/>
   *
   * @param pInventory Value to which {@link #inventory} should be set.
   */
  public void setInventory( InventoryType pInventory ) {
    inventory = pInventory;
  }

  /**
   * Method unsets {@link #inventory}.
   */
  public final void unsetInventory( ) {
    inventory = null;
  }

  /**
   * Method returns association {@link #bookingCode}.<br/>
   *
   * @return {@link BookingCode} Value to which {@link #bookingCode} is set.
   */
  public BookingCode getBookingCode( ) {
    return bookingCode;
  }

  /**
   * Method sets association {@link #bookingCode}.<br/>
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   */
  public void setBookingCode( BookingCode pBookingCode ) {
    bookingCode = pBookingCode;
  }

  /**
   * Method unsets {@link #bookingCode}.
   */
  public final void unsetBookingCode( ) {
    bookingCode = null;
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
