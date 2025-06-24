/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.anaptecs.spring.base.BookingCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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

  private BookingCode bookingCode;

  /**
   * <br/>
   * <b>Default Value:</b> <code>47</code>
   */
  private int maxResults;

  private List<MySortCriteria> sortCriteria;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected QueryBeanParam( QueryBeanParamBuilder<?, ?> pBuilder ) {
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
  public static QueryBeanParamBuilder<?, ?> builder( ) {
    return new QueryBeanParamBuilderImpl();
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
    var lBuilder = QueryBeanParam.builder();
    lBuilder.setBookingCode(pBookingCode);
    lBuilder.setMaxResults(pMaxResults);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>QueryBeanParam</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class QueryBeanParamBuilder<T extends QueryBeanParam, B extends QueryBeanParamBuilder<T, B>> {
    private BookingCode bookingCode;

    /**
     * <br/>
     * <b>Default Value:</b> <code>47</code>
     */
    private int maxResults = 47;

    private List<MySortCriteria> sortCriteria;

    /**
     * Use {@link QueryBeanParamBuilder#builder()} instead of private constructor to create new builder.
     */
    protected QueryBeanParamBuilder( ) {
    }

    /**
     * Use {@link QueryBeanParamBuilder#builder(QueryBeanParam)} instead of private constructor to create new builder.
     */
    protected QueryBeanParamBuilder( QueryBeanParam pObject ) {
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setBookingCode( @MyNotNullProperty BookingCode pBookingCode ) {
      // Assign value to attribute
      bookingCode = pBookingCode;
      return this.self();
    }

    /**
     * Method sets attribute {@link #maxResults}.<br/>
     *
     * @param pMaxResults Value to which {@link #maxResults} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setMaxResults( int pMaxResults ) {
      // Assign value to attribute
      maxResults = pMaxResults;
      return this.self();
    }

    /**
     * Method sets association {@link #sortCriteria}.<br/>
     *
     * @param pSortCriteria Collection to which {@link #sortCriteria} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSortCriteria( List<MySortCriteria> pSortCriteria ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSortCriteria != null) {
        sortCriteria = new ArrayList<MySortCriteria>(pSortCriteria);
      }
      else {
        sortCriteria = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #sortCriteria}.<br/>
     *
     * @param pSortCriteria Array of objects that should be added to {@link #sortCriteria}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToSortCriteria( MySortCriteria... pSortCriteria ) {
      if (pSortCriteria != null) {
        if (sortCriteria == null) {
          sortCriteria = new ArrayList<MySortCriteria>();
        }
        sortCriteria.addAll(Arrays.asList(pSortCriteria));
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class QueryBeanParam. The object will be initialized with the values of the
     * builder.
     *
     * @return QueryBeanParam Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class QueryBeanParamBuilderImpl
      extends QueryBeanParamBuilder<QueryBeanParam, QueryBeanParamBuilderImpl> {
    protected QueryBeanParamBuilderImpl( ) {
    }

    protected QueryBeanParamBuilderImpl( QueryBeanParam pObject ) {
      super(pObject);
    }

    @Override
    protected QueryBeanParamBuilderImpl self( ) {
      return this;
    }

    @Override
    public QueryBeanParam build( ) {
      QueryBeanParam lObject = new QueryBeanParam(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #bookingCode}.<br/>
   *
   * @return {@link BookingCode} Value to which {@link #bookingCode} is set.
   */
  @MyNotNullProperty
  public BookingCode getBookingCode( ) {
    return bookingCode;
  }

  /**
   * Method sets attribute {@link #bookingCode}.<br/>
   *
   * @param pBookingCode Value to which {@link #bookingCode} should be set.
   */
  public void setBookingCode( @MyNotNullProperty BookingCode pBookingCode ) {
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
   * Method returns association {@link #sortCriteria}.<br/>
   *
   * @return {@link List<MySortCriteria>} Value to which {@link #sortCriteria} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<MySortCriteria> getSortCriteria( ) {
    // Return all MySortCriteria objects as unmodifiable collection.
    return Collections.unmodifiableList(sortCriteria);
  }

  /**
   * Method adds the passed object to {@link #sortCriteria}.
   *
   * @param pSortCriteria Object that should be added to {@link #sortCriteria}. The parameter must not be null.
   */
  public void addToSortCriteria( MySortCriteria pSortCriteria ) {
    // Add passed object to collection of associated MySortCriteria objects.
    sortCriteria.add(pSortCriteria);
  }

  /**
   * Method adds all passed objects to {@link #sortCriteria}.
   *
   * @param pSortCriteria Collection with all objects that should be added to {@link #sortCriteria}. The parameter must
   * not be null.
   */
  public void addToSortCriteria( Collection<MySortCriteria> pSortCriteria ) {
    // Add all passed objects.
    for (MySortCriteria lNextObject : pSortCriteria) {
      this.addToSortCriteria(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #sortCriteria}.<br/>
   *
   * @param pSortCriteria Object that should be removed from {@link #sortCriteria}. The parameter must not be null.
   */
  public void removeFromSortCriteria( MySortCriteria pSortCriteria ) {
    // Remove passed object from collection of associated MySortCriteria objects.
    sortCriteria.remove(pSortCriteria);
  }

  /**
   * Method removes all objects from {@link #sortCriteria}.
   */
  public void clearSortCriteria( ) {
    // Remove all objects from association "sortCriteria".
    sortCriteria.clear();
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
  public QueryBeanParamBuilder<?, ?> toBuilder( ) {
    return new QueryBeanParamBuilderImpl(this);
  }
}