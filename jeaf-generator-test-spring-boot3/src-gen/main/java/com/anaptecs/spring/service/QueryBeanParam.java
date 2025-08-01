/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.spring.base.BookingCode;

public class QueryBeanParam {
  /**
   * Constant for the name of attribute "bookingCode".
   */
  public static final String BOOKINGCODE = "bookingCode";

  /**
   * Constant for the name of attribute "maxResults".
   */
  public static final String MAXRESULTS = "maxResults";

  /**
   * Constant for the name of attribute "sortCriteria".
   */
  public static final String SORTCRITERIA = "sortCriteria";

  private final BookingCode bookingCode;

  /**
   * <br/>
   * <b>Default Value:</b> <code>47</code>
   */
  private final int maxResults;

  private final List<MySortCriteria> sortCriteria;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected QueryBeanParam( Builder pBuilder ) {
    // Read attribute values from builder.
    bookingCode = pBuilder.bookingCode;
    maxResults = pBuilder.maxResults;
    if (pBuilder.sortCriteria != null) {
      sortCriteria = pBuilder.sortCriteria;
    }
    else {
      sortCriteria = new ArrayList<>();
    }
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
   * Convenience method to create new instance of class QueryBeanParam.
   *
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   *
   * @param pMaxResults Value to which {@link #maxResults} should be set.
   *
   * @return {@link QueryBeanParam}
   */
  public static QueryBeanParam of( BookingCode pBookingCode, int pMaxResults ) {
    var lBuilder = QueryBeanParam.builder();
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

    private List<MySortCriteria> sortCriteria;

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
        this.setSortCriteria(pObject.sortCriteria);
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
     * Method sets association {@link #sortCriteria}.<br/>
     *
     * @param pSortCriteria Collection to which {@link #sortCriteria} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSortCriteria( List<MySortCriteria> pSortCriteria ) {
      sortCriteria = pSortCriteria;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #sortCriteria}.<br/>
     *
     * @param pSortCriteria Array of objects that should be added to {@link #sortCriteria}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToSortCriteria( MySortCriteria... pSortCriteria ) {
      if (pSortCriteria != null) {
        if (sortCriteria == null) {
          sortCriteria = new ArrayList<MySortCriteria>();
        }
        sortCriteria.addAll(Arrays.asList(pSortCriteria));
      }
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
   * Method returns attribute {@link #bookingCode}.<br/>
   *
   * @return {@link BookingCode} Value to which {@link #bookingCode} is set.
   */
  public BookingCode getBookingCode( ) {
    return bookingCode;
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
   * Method returns association {@link #sortCriteria}.<br/>
   *
   * @return {@link List<MySortCriteria>} Value to which {@link #sortCriteria} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<MySortCriteria> getSortCriteria( ) {
    // Return all MySortCriteria objects as unmodifiable collection.
    return Collections.unmodifiableList(sortCriteria);
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(bookingCode);
    lResult = lPrime * lResult + maxResults;
    lResult = lPrime * lResult + Objects.hashCode(sortCriteria);
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
      QueryBeanParam lOther = (QueryBeanParam) pObject;
      lEquals = Objects.equals(bookingCode, lOther.bookingCode) && maxResults == lOther.maxResults
          && Objects.equals(sortCriteria, lOther.sortCriteria);
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
    lBuilder.append("bookingCode: ");
    lBuilder.append(bookingCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("maxResults: ");
    lBuilder.append(maxResults);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sortCriteria: ");
    if (sortCriteria != null) {
      lBuilder.append(sortCriteria.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (sortCriteria != null) {
      for (MySortCriteria lNext : sortCriteria) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
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