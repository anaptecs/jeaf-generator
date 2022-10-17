/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BookingID( ) {
    bookingID = null;
  }

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
   * Class implements builder to create a new instance of class BookingID. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
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
        bookingID = pObject.bookingID;
      }
    }

    /**
     * Method returns the String representation of this object.
     * 
     * @return String bookingID String representation of this object.
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

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(this.getClass().getName());
    lBuilder.append('\n');
    lBuilder.append("Attributes:");
    lBuilder.append('\n');
    lBuilder.append("bookingID: ");
    lBuilder.append(bookingID);
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
    return this.toStringBuilder().toString();
  }
}
