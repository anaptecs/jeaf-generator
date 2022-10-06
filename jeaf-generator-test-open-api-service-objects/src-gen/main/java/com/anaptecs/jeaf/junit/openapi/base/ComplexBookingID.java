/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class ComplexBookingID implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private String referenceID;

  /**
   * 
   */
  private long internalID;

  /**
   * 
   */
  @Size(min = 1)
  private Set<BookingID> bookingIDs;

  /**
   * 
   */
  @NotNull
  private ComplexBookingType complexBookingType;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexBookingID( ) {
    bookingIDs = new HashSet<BookingID>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexBookingID( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    referenceID = pBuilder.referenceID;
    internalID = pBuilder.internalID;
    if (pBuilder.bookingIDs != null) {
      bookingIDs = pBuilder.bookingIDs;
    }
    else {
      bookingIDs = new HashSet<BookingID>();
    }
    complexBookingType = pBuilder.complexBookingType;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ComplexBookingID objects. The method never
   * returns null.
   */
  public static Builder builder( ComplexBookingID pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ComplexBookingID. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String referenceID;

    /**
     * 
     */
    private long internalID;

    /**
     * 
     */
    private Set<BookingID> bookingIDs;

    /**
     * 
     */
    private ComplexBookingType complexBookingType;

    /**
     * Use {@link ComplexBookingID#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplexBookingID#builder(ComplexBookingID)} instead of private constructor to create new builder.
     */
    protected Builder( ComplexBookingID pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        referenceID = pObject.referenceID;
        internalID = pObject.internalID;
        bookingIDs = pObject.bookingIDs;
        complexBookingType = pObject.complexBookingType;
      }
    }

    /**
     * Method sets the attribute "referenceID".
     * 
     * @param pReferenceID Value to which the attribute "referenceID" should be set.
     */
    public Builder setReferenceID( String pReferenceID ) {
      // Assign value to attribute
      referenceID = pReferenceID;
      return this;
    }

    /**
     * Method sets the attribute "internalID".
     * 
     * @param pInternalID Value to which the attribute "internalID" should be set.
     */
    public Builder setInternalID( long pInternalID ) {
      // Assign value to attribute
      internalID = pInternalID;
      return this;
    }

    /**
     * Method sets the association "bookingIDs".
     * 
     * @param pBookingIDs Collection with objects to which the association should be set.
     */
    public Builder setBookingIDs( Set<BookingID> pBookingIDs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingIDs != null) {
        bookingIDs = new HashSet<BookingID>(pBookingIDs);
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
    public Builder setComplexBookingType( ComplexBookingType pComplexBookingType ) {
      complexBookingType = pComplexBookingType;
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
   * Method returns the attribute "internalID".
   * 
   * 
   * @return long Value to which the attribute "internalID" is set.
   */
  public long getInternalID( ) {
    return internalID;
  }

  /**
   * Method sets the attribute "internalID".
   * 
   * 
   * @param pInternalID Value to which the attribute "internalID" should be set.
   */
  public void setInternalID( long pInternalID ) {
    // Assign value to attribute
    internalID = pInternalID;
  }

  /**
   * Method returns the association "bookingIDs".
   * 
   *
   * @return Collection All BookingID objects that belong to the association "bookingIDs". The method never returns null
   * and the returned collection is modifiable.
   */
  public Set<BookingID> getBookingIDs( ) {
    // Return all BookingID objects directly without any protection against modification.
    return bookingIDs;
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "referenceID", "" + referenceID));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "internalID", "" + internalID));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
