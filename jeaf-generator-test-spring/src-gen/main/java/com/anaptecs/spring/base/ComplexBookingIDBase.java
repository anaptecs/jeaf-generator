/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
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

  @JsonSetter(nulls = Nulls.SKIP)
  private List<BookingID> bookingIDs;

  private ComplexBookingType complexBookingType;

  private Integer anotherID;

  private String[] strings;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexBookingIDBase( ) {
    bookingIDs = new ArrayList<BookingID>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexBookingIDBase( BuilderBase pBuilder ) {
    // Read attribute values from builder.
    internalID = pBuilder.internalID;
    referenceID = pBuilder.referenceID;
    if (pBuilder.bookingIDs != null) {
      bookingIDs = pBuilder.bookingIDs;
    }
    else {
      bookingIDs = new ArrayList<BookingID>();
    }
    complexBookingType = pBuilder.complexBookingType;
    anotherID = pBuilder.anotherID;
    strings = pBuilder.strings;
  }

  /**
   * Class implements builder to create a new instance of class ComplexBookingID. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    private long internalID;

    private String referenceID;

    private List<BookingID> bookingIDs;

    private ComplexBookingType complexBookingType;

    private Integer anotherID;

    private String[] strings;

    /**
     * Use {@link ComplexBookingID.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link ComplexBookingID.builder(ComplexBookingID)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ComplexBookingIDBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        internalID = pObject.internalID;
        referenceID = pObject.referenceID;
        bookingIDs = pObject.bookingIDs;
        complexBookingType = pObject.complexBookingType;
        anotherID = pObject.anotherID;
        strings = pObject.strings;
      }
    }

    /**
     * Method sets attribute {@link #internalID}.<br/>
     *
     * @param pInternalID Value to which {@link #internalID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setInternalID( long pInternalID ) {
      // Assign value to attribute
      internalID = pInternalID;
      return this;
    }

    /**
     * Method sets attribute {@link #referenceID}.<br/>
     *
     * @param pReferenceID Value to which {@link #referenceID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setReferenceID( String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this;
    }

    /**
     * Method sets association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Collection to which {@link #bookingIDs} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setBookingIDs( List<BookingID> pBookingIDs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingIDs != null) {
        bookingIDs = new ArrayList<BookingID>(pBookingIDs);
      }
      else {
        bookingIDs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Array of objects that should be added to {@link #bookingIDs}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToBookingIDs( BookingID... pBookingIDs ) {
      if (pBookingIDs != null) {
        if (bookingIDs == null) {
          bookingIDs = new ArrayList<BookingID>();
        }
        bookingIDs.addAll(Arrays.asList(pBookingIDs));
      }
      return this;
    }

    /**
     * Method sets association {@link #complexBookingType}.<br/>
     *
     * @param pComplexBookingType Value to which {@link #complexBookingType} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setComplexBookingType( ComplexBookingType pComplexBookingType ) {
      complexBookingType = pComplexBookingType;
      return this;
    }

    /**
     * Method sets attribute {@link #anotherID}.<br/>
     *
     * @param pAnotherID Value to which {@link #anotherID} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setAnotherID( Integer pAnotherID ) {
      // Assign value to attribute
      anotherID = pAnotherID;
      return this;
    }

    /**
     * Method sets attribute {@link #strings}.<br/>
     *
     * @param pStrings Collection to which {@link #strings} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setStrings( String[] pStrings ) {
      // Assign value to attribute
      if (pStrings != null) {
        strings = new String[pStrings.length];
        System.arraycopy(pStrings, 0, strings, 0, pStrings.length);
      }
      else {
        strings = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ComplexBookingID. The object will be initialized with the values of the
     * builder.
     *
     * @return ComplexBookingID Created object. The method never returns null.
     */
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
   * Method returns association {@link #bookingIDs}.<br/>
   *
   * @return {@link List<BookingID>} Value to which {@link #bookingIDs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
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
  public ComplexBookingType getComplexBookingType( ) {
    return complexBookingType;
  }

  /**
   * Method sets association {@link #complexBookingType}.<br/>
   *
   * @param pComplexBookingType Value to which {@link #complexBookingType} should be set.
   */
  public void setComplexBookingType( ComplexBookingType pComplexBookingType ) {
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
  public Integer getAnotherID( ) {
    return anotherID;
  }

  /**
   * Method sets attribute {@link #anotherID}.<br/>
   *
   * @param pAnotherID Value to which {@link #anotherID} should be set.
   */
  public void setAnotherID( Integer pAnotherID ) {
    // Assign value to attribute
    anotherID = pAnotherID;
  }

  /**
   * Method returns attribute {@link #strings}.<br/>
   *
   * @return {@link String} Value to which {@link #strings} is set.
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
}
