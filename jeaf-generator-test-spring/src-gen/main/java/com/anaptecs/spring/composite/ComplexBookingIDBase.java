/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ComplexBookingType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ComplexBookingIDBase {
  /**
   * Constant for the name of attribute "internalID".
   */
  public static final String INTERNALID = "internalID";

  /**
   * Constant for the name of attribute "referenceID".
   */
  public static final String REFERENCEID = "referenceID";

  /**
   * Constant for the name of attribute "bookingIDs".
   */
  public static final String BOOKINGIDS = "bookingIDs";

  /**
   * Constant for the name of attribute "complexBookingType".
   */
  public static final String COMPLEXBOOKINGTYPE = "complexBookingType";

  /**
   * Constant for the name of attribute "anotherID".
   */
  public static final String ANOTHERID = "anotherID";

  /**
   * Constant for the name of attribute "strings".
   */
  public static final String STRINGS = "strings";

  private long internalID;

  private String referenceID;

  private List<BookingID> bookingIDs;

  private ComplexBookingType complexBookingType;

  private Integer anotherID;

  private String[] strings;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexBookingIDBase( ComplexBookingIDBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    internalID = pBuilder.internalID;
    referenceID = pBuilder.referenceID;
    if (pBuilder.bookingIDs != null) {
      bookingIDs = pBuilder.bookingIDs;
    }
    else {
      bookingIDs = new ArrayList<>();
    }
    complexBookingType = pBuilder.complexBookingType;
    anotherID = pBuilder.anotherID;
    strings = pBuilder.strings;
  }

  /**
   * Constructor is intended to be used by #of() operation to efficiently created new objects by avoiding using of
   * builder.
   */
  ComplexBookingIDBase( long pInternalID, String pReferenceID, List<BookingID> pBookingIDs,
      ComplexBookingType pComplexBookingType, Integer pAnotherID ) {
    internalID = pInternalID;
    referenceID = pReferenceID;
    bookingIDs = pBookingIDs;
    complexBookingType = pComplexBookingType;
    anotherID = pAnotherID;
  }

  /**
   * Class implements builder to create a new instance of class <code>ComplexBookingID</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class ComplexBookingIDBuilder<T extends ComplexBookingID, B extends ComplexBookingIDBuilder<T, B>> {
    private long internalID;

    private String referenceID;

    private List<BookingID> bookingIDs;

    private ComplexBookingType complexBookingType;

    private Integer anotherID;

    private String[] strings;

    /**
     * Use {@link ComplexBookingIDBuilder#builder()} instead of private constructor to create new builder.
     */
    protected ComplexBookingIDBuilder( ) {
    }

    /**
     * Use {@link ComplexBookingIDBuilder#builder(ComplexBookingID)} instead of private constructor to create new
     * builder.
     */
    protected ComplexBookingIDBuilder( ComplexBookingIDBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setInternalID(pObject.internalID);
        this.setReferenceID(pObject.referenceID);
        this.setBookingIDs(pObject.bookingIDs);
        this.setComplexBookingType(pObject.complexBookingType);
        this.setAnotherID(pObject.anotherID);
        this.setStrings(pObject.strings);
      }
    }

    /**
     * Method sets attribute {@link #internalID}.<br/>
     *
     * @param pInternalID Value to which {@link #internalID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setInternalID( long pInternalID ) {
      // Assign value to attribute
      internalID = pInternalID;
      return this.self();
    }

    /**
     * Method sets attribute {@link #referenceID}.<br/>
     *
     * @param pReferenceID Value to which {@link #referenceID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setReferenceID( @MyNotNullProperty String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this.self();
    }

    /**
     * Method sets association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Collection to which {@link #bookingIDs} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setBookingIDs( @MyNotEmptyProperty List<BookingID> pBookingIDs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingIDs != null) {
        bookingIDs = new ArrayList<BookingID>(pBookingIDs);
      }
      else {
        bookingIDs = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Array of objects that should be added to {@link #bookingIDs}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToBookingIDs( @MyNotEmptyProperty BookingID... pBookingIDs ) {
      if (pBookingIDs != null) {
        if (bookingIDs == null) {
          bookingIDs = new ArrayList<BookingID>();
        }
        bookingIDs.addAll(Arrays.asList(pBookingIDs));
      }
      return this.self();
    }

    /**
     * Method sets association {@link #complexBookingType}.<br/>
     *
     * @param pComplexBookingType Value to which {@link #complexBookingType} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setComplexBookingType( @MyNotNullProperty ComplexBookingType pComplexBookingType ) {
      complexBookingType = pComplexBookingType;
      return this.self();
    }

    /**
     * Method sets attribute {@link #anotherID}.<br/>
     *
     * @param pAnotherID Value to which {@link #anotherID} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAnotherID( @MyNotNullProperty Integer pAnotherID ) {
      // Assign value to attribute
      anotherID = pAnotherID;
      return this.self();
    }

    /**
     * Method sets attribute {@link #strings}.<br/>
     *
     * @param pStrings Collection to which {@link #strings} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setStrings( String[] pStrings ) {
      // Assign value to attribute
      if (pStrings != null) {
        strings = new String[pStrings.length];
        System.arraycopy(pStrings, 0, strings, 0, pStrings.length);
      }
      else {
        strings = null;
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class ComplexBookingID. The object will be initialized with the values of the
     * builder.
     *
     * @return ComplexBookingID Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class ComplexBookingIDBuilderImpl
      extends ComplexBookingIDBuilder<ComplexBookingID, ComplexBookingIDBuilderImpl> {
    protected ComplexBookingIDBuilderImpl( ) {
    }

    protected ComplexBookingIDBuilderImpl( ComplexBookingID pObject ) {
      super(pObject);
    }

    @Override
    protected ComplexBookingIDBuilderImpl self( ) {
      return this;
    }

    @Override
    public ComplexBookingID build( ) {
      ComplexBookingID lObject = new ComplexBookingID(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #internalID}.<br/>
   *
   * @return long Value to which {@link #internalID} is set.
   */
  public long getInternalID( ) {
    return internalID;
  }

  /**
   * Method sets attribute {@link #internalID}.<br/>
   *
   * @param pInternalID Value to which {@link #internalID} should be set.
   */
  public void setInternalID( long pInternalID ) {
    // Assign value to attribute
    internalID = pInternalID;
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
   * Method sets attribute {@link #referenceID}.<br/>
   *
   * @param pReferenceID Value to which {@link #referenceID} should be set.
   */
  public void setReferenceID( @MyNotNullProperty String pReferenceID ) {
    // Assign value to attribute
    referenceID = pReferenceID;
  }

  /**
   * Method returns association {@link #bookingIDs}.<br/>
   *
   * @return {@link List<BookingID>} Value to which {@link #bookingIDs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @MyNotEmptyProperty
  public List<BookingID> getBookingIDs( ) {
    // Return all BookingID objects as unmodifiable collection.
    return Collections.unmodifiableList(bookingIDs);
  }

  /**
   * Method adds the passed object to {@link #bookingIDs}.
   *
   * @param pBookingIDs Object that should be added to {@link #bookingIDs}. The parameter must not be null.
   */
  public void addToBookingIDs( BookingID pBookingIDs ) {
    // Add passed object to collection of associated BookingID objects.
    bookingIDs.add(pBookingIDs);
  }

  /**
   * Method adds all passed objects to {@link #bookingIDs}.
   *
   * @param pBookingIDs Collection with all objects that should be added to {@link #bookingIDs}. The parameter must not
   * be null.
   */
  public void addToBookingIDs( Collection<BookingID> pBookingIDs ) {
    // Add all passed objects.
    for (BookingID lNextObject : pBookingIDs) {
      this.addToBookingIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bookingIDs}.<br/>
   *
   * @param pBookingIDs Object that should be removed from {@link #bookingIDs}. The parameter must not be null.
   */
  public void removeFromBookingIDs( BookingID pBookingIDs ) {
    // Remove passed object from collection of associated BookingID objects.
    bookingIDs.remove(pBookingIDs);
  }

  /**
   * Method removes all objects from {@link #bookingIDs}.
   */
  public void clearBookingIDs( ) {
    // Remove all objects from association "bookingIDs".
    bookingIDs.clear();
  }

  /**
   * Method returns association {@link #complexBookingType}.<br/>
   *
   * @return {@link ComplexBookingType} Value to which {@link #complexBookingType} is set.
   */
  @MyNotNullProperty
  public ComplexBookingType getComplexBookingType( ) {
    return complexBookingType;
  }

  /**
   * Method sets association {@link #complexBookingType}.<br/>
   *
   * @param pComplexBookingType Value to which {@link #complexBookingType} should be set.
   */
  public void setComplexBookingType( @MyNotNullProperty ComplexBookingType pComplexBookingType ) {
    complexBookingType = pComplexBookingType;
  }

  /**
   * Method unsets {@link #complexBookingType}.
   */
  public final void unsetComplexBookingType( ) {
    complexBookingType = null;
  }

  /**
   * Method returns attribute {@link #anotherID}.<br/>
   *
   * @return {@link Integer} Value to which {@link #anotherID} is set.
   */
  @MyNotNullProperty
  public Integer getAnotherID( ) {
    return anotherID;
  }

  /**
   * Method sets attribute {@link #anotherID}.<br/>
   *
   * @param pAnotherID Value to which {@link #anotherID} should be set.
   */
  public void setAnotherID( @MyNotNullProperty Integer pAnotherID ) {
    // Assign value to attribute
    anotherID = pAnotherID;
  }

  /**
   * Method returns attribute {@link #strings}.<br/>
   *
   * @return {@link String[]} Value to which {@link #strings} is set.
   */
  public String[] getStrings( ) {
    String[] lReturnValue;
    if (strings != null) {
      lReturnValue = new String[strings.length];
      System.arraycopy(strings, 0, lReturnValue, 0, strings.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #strings}.<br/>
   *
   * @param pStrings Value to which {@link #strings} should be set.
   */
  public void setStrings( String[] pStrings ) {
    // Assign value to attribute
    if (pStrings != null) {
      strings = new String[pStrings.length];
      System.arraycopy(pStrings, 0, strings, 0, pStrings.length);
    }
    else {
      strings = null;
    }
  }

  /**
   * Convenience method to create new instance of class ComplexBookingID.
   *
   *
   * @param pInternalID Value to which {@link #internalID} should be set.
   *
   * @param pReferenceID Value to which {@link #referenceID} should be set.
   *
   * @param pBookingIDs Value to which {@link #bookingIDs} should be set.
   *
   * @param pComplexBookingType Value to which {@link #complexBookingType} should be set.
   *
   * @param pAnotherID Value to which {@link #anotherID} should be set.
   *
   * @return {@link ComplexBookingID}
   */
  public static ComplexBookingID of( long pInternalID, String pReferenceID, List<BookingID> pBookingIDs,
      ComplexBookingType pComplexBookingType, Integer pAnotherID ) {
    return new ComplexBookingID(pInternalID, pReferenceID, pBookingIDs, pComplexBookingType, pAnotherID);
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Long.hashCode(internalID);
    lResult = lPrime * lResult + Objects.hashCode(referenceID);
    lResult = lPrime * lResult + Objects.hashCode(bookingIDs);
    lResult = lPrime * lResult + Objects.hashCode(complexBookingType);
    lResult = lPrime * lResult + Objects.hashCode(anotherID);
    lResult = lPrime * lResult + Arrays.hashCode(strings);
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
      ComplexBookingIDBase lOther = (ComplexBookingIDBase) pObject;
      lEquals = internalID == lOther.internalID && Objects.equals(referenceID, lOther.referenceID)
          && Objects.equals(bookingIDs, lOther.bookingIDs)
          && Objects.equals(complexBookingType, lOther.complexBookingType)
          && Objects.equals(anotherID, lOther.anotherID) && Arrays.equals(strings, lOther.strings);
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
    lBuilder.append("internalID: ");
    lBuilder.append(internalID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("referenceID: ");
    lBuilder.append(referenceID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bookingIDs: ");
    if (bookingIDs != null) {
      lBuilder.append(bookingIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (bookingIDs != null) {
      for (BookingID lNext : bookingIDs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("complexBookingType: ");
    lBuilder.append(complexBookingType);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("anotherID: ");
    lBuilder.append(anotherID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("strings: ");
    if (strings != null) {
      lBuilder.append(Arrays.toString(strings));
    }
    else {
      lBuilder.append(" null");
    }
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
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects. The method never
   * returns null.
   */
  public ComplexBookingIDBuilder<?, ?> toBuilder( ) {
    return new ComplexBookingIDBuilderImpl((ComplexBookingID) this);
  }
}