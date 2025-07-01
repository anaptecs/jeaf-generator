/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

public class BookingID {
  /**
   * Constant for the name of attribute "bookingID".
   */
  public static final String BOOKINGID = "bookingID";

  /**
   * String representation of this object.
   */
  private final String bookingID;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BookingID( Builder pBuilder ) {
    // Read attribute values from builder.
    bookingID = pBuilder.bookingID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BookingID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  public static Builder builder( String pBookingID ) {
    Builder lBuilder = builder();
    lBuilder.setBookingID(pBookingID);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class <code>BookingID</code>.
   */
  public static class Builder {
    /**
     * String representation of this object.
     */
    private String bookingID;

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
        this.setBookingID(pObject.bookingID);
      }
    }

    /**
     * Method returns the String representation of this object.
     *
     * @return String String representation of this object.
     */
    public Builder setBookingID( String pBookingID ) {
      bookingID = pBookingID;
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
   * Method returns the String representation of this object.
   *
   * @return String String representation of this object.
   */
  public String getBookingID( ) {
    return bookingID;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash(bookingID);
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof BookingID == false) {
      lEquals = false;
    }
    else {
      lEquals = Objects.equals(bookingID, ((BookingID) pOtherObject).getBookingID());
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
    lBuilder.append(bookingID);
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
   * @return {@link Builder} New builder that can be used to create new BookingID objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}