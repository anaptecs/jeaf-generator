/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public abstract class ComplexBookingIDBase implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Internal ID<br/>
   * 2nd line<br/>
   * 3rd line
   */
  private long internalID;

  @NotNull
  private String referenceID;

  @Valid
  @JsonSetter(nulls = Nulls.SKIP)
  @Size(min = 1)
  @NotNull
  private List<BookingID> bookingIDs;

  @NotNull
  private ComplexBookingType complexBookingType;

  @NotNull
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
     * Internal ID<br/>
     * 2nd line<br/>
     * 3rd line
     */
    private long internalID;

    private String referenceID;

    private List<BookingID> bookingIDs;

    private ComplexBookingType complexBookingType;

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
   * Method returns attribute {@link #internalID}.<br/>
   * Internal ID<br/>
   * 2nd line<br/>
   * 3rd line
   *
   * @return long Value to which {@link #internalID} is set.
   */
  public long getInternalID( ) {
    return internalID;
  }

  /**
   * Method sets attribute {@link #internalID}.<br/>
   * Internal ID<br/>
   * 2nd line<br/>
   * 3rd line
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
   * returned collection is modifiable.
   */
  public List<BookingID> getBookingIDs( ) {
    // Return all BookingID objects directly without any protection against modification.
    return bookingIDs;
  }

  /**
   * Method adds the passed object to {@link #bookingIDs}.
   *
   * @param pBookingIDs Object that should be added to {@link #bookingIDs}. The parameter must not be null.
   */
  public void addToBookingIDs( BookingID pBookingIDs ) {
    // Check parameter "pBookingIDs" for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
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
    // Check parameter "pBookingIDs" for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
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
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBookingIDs, "pBookingIDs");
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
