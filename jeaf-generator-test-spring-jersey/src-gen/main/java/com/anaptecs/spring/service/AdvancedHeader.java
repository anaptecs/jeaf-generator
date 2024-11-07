/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import javax.ws.rs.HeaderParam;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;

public class AdvancedHeader {
  /**
   * Constant for the name of attribute "bookingID".
   */
  public static final String BOOKINGID = "bookingID";

  /**
   * Constant for the name of attribute "bookingCode".
   */
  public static final String BOOKINGCODE = "bookingCode";

  /**
   * Constant for the name of attribute "doubleCode".
   */
  public static final String DOUBLECODE = "doubleCode";

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>BOOK-12345</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> bookingID
   */
  @HeaderParam("bookingID")
  private BookingID bookingID;

  @HeaderParam("bookingCode")
  private BookingCode bookingCode;

  @HeaderParam("DoubleCode")
  private DoubleCode doubleCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public AdvancedHeader( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AdvancedHeader( Builder pBuilder ) {
    // Read attribute values from builder.
    bookingID = pBuilder.bookingID;
    bookingCode = pBuilder.bookingCode;
    doubleCode = pBuilder.doubleCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new AdvancedHeader objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class AdvancedHeader.
   *
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   *
   * @param pDoubleCode Value to which {@link #doubleCode} should be set.
   *
   * @return {@link com.anaptecs.spring.service.AdvancedHeader}
   */
  public static AdvancedHeader of( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    AdvancedHeader.Builder lBuilder = AdvancedHeader.builder();
    lBuilder.setBookingID(pBookingID);
    lBuilder.setBookingCode(pBookingCode);
    lBuilder.setDoubleCode(pDoubleCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>AdvancedHeader</code>.
   */
  public static class Builder {
    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>BOOK-12345</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> bookingID
     */
    private BookingID bookingID;

    private BookingCode bookingCode;

    private DoubleCode doubleCode;

    /**
     * Use {@link AdvancedHeader#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link AdvancedHeader#builder(AdvancedHeader)} instead of private constructor to create new builder.
     */
    protected Builder( AdvancedHeader pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBookingID(pObject.bookingID);
        this.setBookingCode(pObject.bookingCode);
        this.setDoubleCode(pObject.doubleCode);
      }
    }

    /**
     * Method sets attribute {@link #bookingID}.<br/>
     *
     * @param pBookingID Value to which {@link #bookingID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      // Assign value to attribute
      bookingID = pBookingID;
      return this;
    }

    /**
     * Method sets attribute {@link #bookingCode}.<br/>
     *
     * @param pBookingCode Value to which {@link #bookingCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingCode( BookingCode pBookingCode ) {
      // Assign value to attribute
      bookingCode = pBookingCode;
      return this;
    }

    /**
     * Method sets attribute {@link #doubleCode}.<br/>
     *
     * @param pDoubleCode Value to which {@link #doubleCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDoubleCode( DoubleCode pDoubleCode ) {
      // Assign value to attribute
      doubleCode = pDoubleCode;
      return this;
    }

    /**
     * Method creates a new instance of class AdvancedHeader. The object will be initialized with the values of the
     * builder.
     *
     * @return AdvancedHeader Created object. The method never returns null.
     */
    public AdvancedHeader build( ) {
      return new AdvancedHeader(this);
    }
  }

  /**
   * Method returns attribute {@link #bookingID}.<br/>
   *
   * @return {@link BookingID} Value to which {@link #bookingID} is set.
   */
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets attribute {@link #bookingID}.<br/>
   *
   * @param pBookingID Value to which {@link #bookingID} should be set.
   */
  public void setBookingID( BookingID pBookingID ) {
    // Assign value to attribute
    bookingID = pBookingID;
  }

  /**
   * Method returns attribute {@link #bookingCode}.<br/>
   *
   * @return {@link BookingCode} Value to which {@link #bookingCode} is set.
   */
  public BookingCode getBookingCode( ) {
    return bookingCode;
  }

  /**
   * Method sets attribute {@link #bookingCode}.<br/>
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   */
  public void setBookingCode( BookingCode pBookingCode ) {
    // Assign value to attribute
    bookingCode = pBookingCode;
  }

  /**
   * Method returns attribute {@link #doubleCode}.<br/>
   *
   * @return {@link DoubleCode} Value to which {@link #doubleCode} is set.
   */
  public DoubleCode getDoubleCode( ) {
    return doubleCode;
  }

  /**
   * Method sets attribute {@link #doubleCode}.<br/>
   *
   * @param pDoubleCode Value to which {@link #doubleCode} should be set.
   */
  public void setDoubleCode( DoubleCode pDoubleCode ) {
    // Assign value to attribute
    doubleCode = pDoubleCode;
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
    lBuilder.append(pIndent);
    lBuilder.append("bookingCode: ");
    lBuilder.append(bookingCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCode: ");
    lBuilder.append(doubleCode);
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
   * @return {@link Builder} New builder that can be used to create new AdvancedHeader objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}