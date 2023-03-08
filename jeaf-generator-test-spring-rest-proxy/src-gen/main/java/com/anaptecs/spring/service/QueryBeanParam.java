/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.spring.base.BookingCode;

public class QueryBeanParam {
  /**
   * Constant for the name of attribute "bookingCode".
   */
  public static final String BOOKINGCODE = "bookingCode";

  private BookingCode bookingCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public QueryBeanParam( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected QueryBeanParam( Builder pBuilder ) {
    // Read attribute values from builder.
    bookingCode = pBuilder.bookingCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new QueryBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new QueryBeanParam objects. The method never returns
   * null.
   */
  public static Builder builder( QueryBeanParam pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class QueryBeanParam. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BookingCode bookingCode;

    /**
     * Use {@link QueryBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link QueryBeanParam#builder(QueryBeanParam)} instead of private constructor to create new builder.
     */
    protected Builder( QueryBeanParam pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        bookingCode = pObject.bookingCode;
      }
    }

    /**
     * Method sets the attribute "bookingCode".
     * 
     * @param pBookingCode Value to which the attribute "bookingCode" should be set.
     */
    public Builder setBookingCode( BookingCode pBookingCode ) {
      // Assign value to attribute
      bookingCode = pBookingCode;
      return this;
    }

    /**
     * Method creates a new instance of class QueryBeanParam. The object will be initialized with the values of the
     * builder.
     * 
     * @return QueryBeanParam Created object. The method never returns null.
     */
    public QueryBeanParam build( ) {
      return new QueryBeanParam(this);
    }
  }

  /**
   * Method returns the attribute "bookingCode".
   * 
   * 
   * @return BookingCode Value to which the attribute "bookingCode" is set.
   */
  public BookingCode getBookingCode( ) {
    return bookingCode;
  }

  /**
   * Method sets the attribute "bookingCode".
   * 
   * 
   * @param pBookingCode Value to which the attribute "bookingCode" should be set.
   */
  public void setBookingCode( BookingCode pBookingCode ) {
    // Assign value to attribute
    bookingCode = pBookingCode;
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
    lBuilder.append("bookingCode: ");
    lBuilder.append(bookingCode);
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
}
