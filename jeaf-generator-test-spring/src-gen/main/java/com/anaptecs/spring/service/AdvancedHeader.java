/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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
   * 
   */
  private BookingID bookingID;

  /**
   * 
   */
  private BookingCode bookingCode;

  /**
   * 
   */
  private DoubleCode doubleCode;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new AdvancedHeader objects. The method never returns
   * null.
   */
  public static Builder builder( AdvancedHeader pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    Builder lBuilder = builder();
    lBuilder.setBookingID(pBookingID);
    lBuilder.setBookingCode(pBookingCode);
    lBuilder.setDoubleCode(pDoubleCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class AdvancedHeader. As the class has read only attributes or
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
    private BookingCode bookingCode;

    /**
     * 
     */
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
        bookingID = pObject.bookingID;
        bookingCode = pObject.bookingCode;
        doubleCode = pObject.doubleCode;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new AdvancedHeader objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new AdvancedHeader objects. The method never
     * returns null.
     */
    public static Builder newBuilder( AdvancedHeader pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "bookingID".
     * 
     * @param pBookingID Value to which the attribute "bookingID" should be set.
     */
    public Builder setBookingID( BookingID pBookingID ) {
      // Assign value to attribute
      bookingID = pBookingID;
      return this;
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
     * Method sets the attribute "doubleCode".
     * 
     * @param pDoubleCode Value to which the attribute "doubleCode" should be set.
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
   * Method returns the attribute "bookingID".
   * 
   * 
   * @return BookingID Value to which the attribute "bookingID" is set.
   */
  public BookingID getBookingID( ) {
    return bookingID;
  }

  /**
   * Method sets the attribute "bookingID".
   * 
   * 
   * @param pBookingID Value to which the attribute "bookingID" should be set.
   */
  public void setBookingID( BookingID pBookingID ) {
    // Assign value to attribute
    bookingID = pBookingID;
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
   * Method returns the attribute "doubleCode".
   * 
   * 
   * @return DoubleCode Value to which the attribute "doubleCode" is set.
   */
  public DoubleCode getDoubleCode( ) {
    return doubleCode;
  }

  /**
   * Method sets the attribute "doubleCode".
   * 
   * 
   * @param pDoubleCode Value to which the attribute "doubleCode" should be set.
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
}
