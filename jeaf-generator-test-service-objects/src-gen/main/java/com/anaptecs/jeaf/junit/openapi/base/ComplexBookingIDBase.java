/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class ComplexBookingIDBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

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
   * Internal ID 2nd line 3rd line
   */
  private long internalID;

  /**
   * 
   */
  private String referenceID;

  /**
   * 
   */
  private List<BookingID> bookingIDs;

  /**
   * 
   */
  private ComplexBookingType complexBookingType;

  /**
   * 
   */
  private Integer anotherID;

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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
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
  }

  /**
   * Class implements builder to create a new instance of class ComplexBookingID. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Internal ID 2nd line 3rd line
     */
    private long internalID;

    /**
     * 
     */
    private String referenceID;

    /**
     * 
     */
    private List<BookingID> bookingIDs;

    /**
     * 
     */
    private ComplexBookingType complexBookingType;

    /**
     * 
     */
    private Integer anotherID;

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
      }
    }

    /**
     * Method sets the attribute "internalID". Internal ID 2nd line 3rd line
     * 
     * @param pInternalID Value to which the attribute "internalID" should be set.
     */
    public BuilderBase setInternalID( long pInternalID ) {
      // Assign value to attribute
      internalID = pInternalID;
      return this;
    }

    /**
     * Method sets the attribute "referenceID".
     * 
     * @param pReferenceID Value to which the attribute "referenceID" should be set.
     */
    public BuilderBase setReferenceID( String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this;
    }

    /**
     * Method sets the association "bookingIDs".
     * 
     * @param pBookingIDs Collection with objects to which the association should be set.
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
     * Method sets the association "complexBookingType".
     * 
     * @param pComplexBookingType ComplexBookingType to which the association "complexBookingType" should be set.
     */
    public BuilderBase setComplexBookingType( ComplexBookingType pComplexBookingType ) {
      complexBookingType = pComplexBookingType;
      return this;
    }

    /**
     * Method sets the attribute "anotherID".
     * 
     * @param pAnotherID Value to which the attribute "anotherID" should be set.
     */
    public BuilderBase setAnotherID( Integer pAnotherID ) {
      // Assign value to attribute
      anotherID = pAnotherID;
      return this;
    }

    /**
     * Method creates a new instance of class ComplexBookingID. The object will be initialized with the values of the
     * builder.
     * 
     * @return ComplexBookingID Created object. The method never returns null.
     */
    public ComplexBookingID build( ) {
      return new ComplexBookingID(this);
    }

    /**
     * Method creates a new validated instance of class ComplexBookingID. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return ComplexBookingID Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ComplexBookingID buildValidated( ) throws ConstraintViolationException {
      ComplexBookingID lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "internalID". Internal ID 2nd line 3rd line
   * 
   * @return long Value to which the attribute "internalID" is set.
   */
  public long getInternalID( ) {
    return internalID;
  }

  /**
   * Method sets the attribute "internalID". Internal ID 2nd line 3rd line
   * 
   * @param pInternalID Value to which the attribute "internalID" should be set.
   */
  public void setInternalID( long pInternalID ) {
    // Assign value to attribute
    internalID = pInternalID;
  }

  /**
   * Method returns the attribute "referenceID".
   * 
   * 
   * @return String Value to which the attribute "referenceID" is set.
   */
  public String getReferenceID( ) {
    return referenceID;
  }

  /**
   * Method sets the attribute "referenceID".
   * 
   * 
   * @param pReferenceID Value to which the attribute "referenceID" should be set.
   */
  public void setReferenceID( String pReferenceID ) {
    // Assign value to attribute
    referenceID = pReferenceID;
  }

  /**
   * Method returns the association "bookingIDs".
   * 
   *
   * @return Collection All BookingID objects that belong to the association "bookingIDs". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<BookingID> getBookingIDs( ) {
    // Return all BookingID objects as unmodifiable collection.
    return Collections.unmodifiableList(bookingIDs);
  }

  /**
   * Method adds the passed BookingID object to the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Object that should be added to the association "bookingIDs". The parameter must not be null.
   */
  public void addToBookingIDs( BookingID pBookingIDs ) {
    // Check parameter "pBookingIDs" for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
    // Add passed object to collection of associated BookingID objects.
    bookingIDs.add(pBookingIDs);
  }

  /**
   * Method adds all passed objects to the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Collection with all objects that should be added to the association "bookingIDs". The parameter
   * must not be null.
   */
  public void addToBookingIDs( Collection<BookingID> pBookingIDs ) {
    // Check parameter "pBookingIDs" for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
    // Add all passed objects.
    for (BookingID lNextObject : pBookingIDs) {
      this.addToBookingIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed BookingID object from the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Object that should be removed from the association "bookingIDs". The parameter must not be null.
   */
  public void removeFromBookingIDs( BookingID pBookingIDs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
    // Remove passed object from collection of associated BookingID objects.
    bookingIDs.remove(pBookingIDs);
  }

  /**
   * Method removes all objects from the association "bookingIDs".
   * 
   */
  public void clearBookingIDs( ) {
    // Remove all objects from association "bookingIDs".
    bookingIDs.clear();
  }

  /**
   * Method returns the association "complexBookingType".
   * 
   *
   * @return ComplexBookingType ComplexBookingType to which the association "complexBookingType" is set.
   */
  public ComplexBookingType getComplexBookingType( ) {
    return complexBookingType;
  }

  /**
   * Method sets the association "complexBookingType".
   * 
   * 
   * @param pComplexBookingType ComplexBookingType to which the association "complexBookingType" should be set.
   */
  public void setComplexBookingType( ComplexBookingType pComplexBookingType ) {
    complexBookingType = pComplexBookingType;
  }

  /**
   * Method unsets the association "complexBookingType".
   * 
   */
  public final void unsetComplexBookingType( ) {
    complexBookingType = null;
  }

  /**
   * Method returns the attribute "anotherID".
   * 
   * 
   * @return Integer Value to which the attribute "anotherID" is set.
   */
  public Integer getAnotherID( ) {
    return anotherID;
  }

  /**
   * Method sets the attribute "anotherID".
   * 
   * 
   * @param pAnotherID Value to which the attribute "anotherID" should be set.
   */
  public void setAnotherID( Integer pAnotherID ) {
    // Assign value to attribute
    anotherID = pAnotherID;
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
    lBuilder.append("anotherID: ");
    lBuilder.append(anotherID);
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
