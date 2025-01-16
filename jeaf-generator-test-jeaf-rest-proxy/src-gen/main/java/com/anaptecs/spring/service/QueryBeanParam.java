/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.spring.base.BookingCode;

public class QueryBeanParam implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "bookingCode".
   */
  public static final String BOOKINGCODE = "bookingCode";

  /**
   * Constant for the name of attribute "maxResults".
   */
  public static final String MAXRESULTS = "maxResults";

  @QueryParam("bookingCode")
  private BookingCode bookingCode;

  /**
   * <br/>
   * <b>Default Value:</b> <code>47</code>
   */
  @QueryParam("maxResults")
  private int maxResults;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public QueryBeanParam( ) {
    maxResults = 47;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected QueryBeanParam( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    bookingCode = pBuilder.bookingCode;
    maxResults = pBuilder.maxResults;
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BookingCode pBookingCode, int pMaxResults ) {
    Builder lBuilder = builder();
    lBuilder.setBookingCode(pBookingCode);
    lBuilder.setMaxResults(pMaxResults);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class QueryBeanParam.
   *
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   *
   * @param pMaxResults Value to which {@link #maxResults} should be set.
   *
   * @return {@link com.anaptecs.spring.service.QueryBeanParam}
   */
  public static QueryBeanParam of( BookingCode pBookingCode, int pMaxResults ) {
    QueryBeanParam.Builder lBuilder = QueryBeanParam.builder();
    lBuilder.setBookingCode(pBookingCode);
    lBuilder.setMaxResults(pMaxResults);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>QueryBeanParam</code>.
   */
  public static class Builder {
    private BookingCode bookingCode;

    /**
     * <br/>
     * <b>Default Value:</b> <code>47</code>
     */
    private int maxResults = 47;

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
        this.setBookingCode(pObject.bookingCode);
        this.setMaxResults(pObject.maxResults);
      }
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
     * Method sets attribute {@link #maxResults}.<br/>
     *
     * @param pMaxResults Value to which {@link #maxResults} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setMaxResults( int pMaxResults ) {
      // Assign value to attribute
      maxResults = pMaxResults;
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

    /**
     * Method creates a new validated instance of class QueryBeanParam. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return QueryBeanParam Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public QueryBeanParam buildValidated( ) throws ConstraintViolationException {
      QueryBeanParam lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
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
   * Method returns attribute {@link #maxResults}.<br/>
   *
   * @return int Value to which {@link #maxResults} is set.
   */
  public int getMaxResults( ) {
    return maxResults;
  }

  /**
   * Method sets attribute {@link #maxResults}.<br/>
   *
   * @param pMaxResults Value to which {@link #maxResults} should be set.
   */
  public void setMaxResults( int pMaxResults ) {
    // Assign value to attribute
    maxResults = pMaxResults;
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
    lBuilder.append(pIndent);
    lBuilder.append("maxResults: ");
    lBuilder.append(maxResults);
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
   * @return {@link Builder} New builder that can be used to create new QueryBeanParam objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}