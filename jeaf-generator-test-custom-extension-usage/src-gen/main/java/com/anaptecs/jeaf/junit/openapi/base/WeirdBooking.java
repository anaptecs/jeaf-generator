/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class WeirdBooking extends WeirdParent {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "booking".
   */
  public static final String BOOKING = "booking";

  /**
   * Constant for the name of attribute "additionalBookings".
   */
  public static final String ADDITIONALBOOKINGS = "additionalBookings";

  /**
   * Constant for the name of attribute "versionedObjectSoftLink".
   */
  public static final String VERSIONEDOBJECTSOFTLINK = "versionedObjectSoftLink";

  /**
   * Constant for the name of attribute "childProperty".
   */
  public static final String CHILDPROPERTY = "childProperty";

  /**
   * Constant for the name of attribute "realBooking".
   */
  public static final String REALBOOKING = "realBooking";

  /**
   * Constant for the name of attribute "inventories".
   */
  public static final String INVENTORIES = "inventories";

  // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
  @ClassPropertyDeclaration
  private ComplexBookingID booking;

  // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
  private int bookingXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
  @ClassPropertyDeclaration
  /**
   * additional bookings
   */
  private List<ComplexBookingID> additionalBookings;

  // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
  private int additionalBookingsXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
  @ClassPropertyDeclaration
  /**
   * soft link<br/>
   * 2nd line<br/>
   * 3rd line
   */
  private VersionedObjectSoftLink versionedObjectSoftLink;

  // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
  private int versionedObjectSoftLinkXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  private int childProperty;

  // "int"
  private int childPropertyXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.Booking"
  @ClassPropertyDeclaration
  /**
   * the real booking
   * <p/>
   * <b>Breaking Change with 2.0:</b> Association will be mandatory.
   */
  private Booking realBooking;

  // "com.anaptecs.jeaf.junit.openapi.base.Booking"
  private int realBookingXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
   */
  private Set<InventoryType> inventories;

  // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
  private int inventoriesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected WeirdBooking( ) {
    additionalBookings = new ArrayList<ComplexBookingID>();
    inventories = new HashSet<InventoryType>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WeirdBooking( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    booking = pBuilder.booking;
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    bookingXYZ = pBuilder.bookingXYZ;
    if (pBuilder.additionalBookings != null) {
      additionalBookings = pBuilder.additionalBookings;
    }
    else {
      additionalBookings = new ArrayList<ComplexBookingID>();
    }
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    additionalBookingsXYZ = pBuilder.additionalBookingsXYZ;
    versionedObjectSoftLink = pBuilder.versionedObjectSoftLink;
    // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
    versionedObjectSoftLinkXYZ = pBuilder.versionedObjectSoftLinkXYZ;
    childProperty = pBuilder.childProperty;
    // "int"
    childPropertyXYZ = pBuilder.childPropertyXYZ;
    realBooking = pBuilder.realBooking;
    // "com.anaptecs.jeaf.junit.openapi.base.Booking"
    realBookingXYZ = pBuilder.realBookingXYZ;
    if (pBuilder.inventories != null) {
      inventories = pBuilder.inventories;
    }
    else {
      inventories = new HashSet<InventoryType>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    inventoriesXYZ = pBuilder.inventoriesXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>WeirdBooking</code>.
   */
  public static class Builder extends WeirdParent.Builder {
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    @BuilderPropertyDeclaration
    private ComplexBookingID booking;

    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    private int bookingXYZ = 0;

    /**
     * additional bookings
     */
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    @BuilderPropertyDeclaration
    private List<ComplexBookingID> additionalBookings;

    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    private int additionalBookingsXYZ = 0;

    /**
     * soft link<br/>
     * 2nd line<br/>
     * 3rd line
     */
    // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
    @BuilderPropertyDeclaration
    private VersionedObjectSoftLink versionedObjectSoftLink;

    // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
    private int versionedObjectSoftLinkXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    private int childProperty;

    // "int"
    private int childPropertyXYZ = 0;

    /**
     * the real booking
     * <p/>
     * <b>Breaking Change with 2.0:</b> Association will be mandatory.
     */
    // "com.anaptecs.jeaf.junit.openapi.base.Booking"
    @BuilderPropertyDeclaration
    private Booking realBooking;

    // "com.anaptecs.jeaf.junit.openapi.base.Booking"
    private int realBookingXYZ = 0;

    /**
     * <p/>
     * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
     */
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    @BuilderPropertyDeclaration
    private Set<InventoryType> inventories;

    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    private int inventoriesXYZ = 0;

    /**
     * Use {@link WeirdBooking#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link WeirdBooking#builder(WeirdBooking)} instead of private constructor to create new builder.
     */
    protected Builder( WeirdBooking pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setBooking(pObject.booking);
        this.setAdditionalBookings(pObject.additionalBookings);
        this.setVersionedObjectSoftLink(pObject.versionedObjectSoftLink);
        this.setChildProperty(pObject.childProperty);
        this.setRealBooking(pObject.realBooking);
        this.setInventories(pObject.inventories);
      }
    }

    /**
     * Method sets attribute {@link #someProperty}.<br/>
     *
     * @param pSomeProperty Value to which {@link #someProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setSomeProperty( String pSomeProperty ) {
      // Call super class implementation.
      super.setSomeProperty(pSomeProperty);
      return this;
    }

    /**
     * Method sets association {@link #complexBooking}.<br/>
     *
     * @param pComplexBooking Value to which {@link #complexBooking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setComplexBooking( ComplexBookingID pComplexBooking ) {
      // Call super class implementation.
      super.setComplexBooking(pComplexBooking);
      return this;
    }

    /**
     * Method sets association {@link #complexBookings}.<br/>
     *
     * @param pComplexBookings Collection to which {@link #complexBookings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setComplexBookings( Set<ComplexBookingID> pComplexBookings ) {
      // Call super class implementation.
      super.setComplexBookings(pComplexBookings);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #complexBookings}.<br/>
     *
     * @param pComplexBookings Array of objects that should be added to {@link #complexBookings}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToComplexBookings( ComplexBookingID... pComplexBookings ) {
      // Call super class implementation.
      super.addToComplexBookings(pComplexBookings);
      return this;
    }

    /**
     * Method sets association {@link #booking}.<br/>
     *
     * @param pBooking Value to which {@link #booking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooking( ComplexBookingID pBooking ) {
      booking = pBooking;
      return this;
    }

    public Builder setBookingXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
      bookingXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #additionalBookings}.<br/>
     *
     * @param pAdditionalBookings Collection to which {@link #additionalBookings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAdditionalBookings( List<ComplexBookingID> pAdditionalBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAdditionalBookings != null) {
        additionalBookings = new ArrayList<ComplexBookingID>(pAdditionalBookings);
      }
      else {
        additionalBookings = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #additionalBookings}.<br/>
     *
     * @param pAdditionalBookings Array of objects that should be added to {@link #additionalBookings}. The parameter
     * may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToAdditionalBookings( ComplexBookingID... pAdditionalBookings ) {
      if (pAdditionalBookings != null) {
        if (additionalBookings == null) {
          additionalBookings = new ArrayList<ComplexBookingID>();
        }
        additionalBookings.addAll(Arrays.asList(pAdditionalBookings));
      }
      return this;
    }

    public Builder setAdditionalBookingsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
      additionalBookingsXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #versionedObjectSoftLink}.<br/>
     *
     * @param pVersionedObjectSoftLink Value to which {@link #versionedObjectSoftLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setVersionedObjectSoftLink( VersionedObjectSoftLink pVersionedObjectSoftLink ) {
      versionedObjectSoftLink = pVersionedObjectSoftLink;
      return this;
    }

    public Builder setVersionedObjectSoftLinkXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
      versionedObjectSoftLinkXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #childProperty}.<br/>
     *
     * @param pChildProperty Value to which {@link #childProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildProperty( int pChildProperty ) {
      // Assign value to attribute
      childProperty = pChildProperty;
      return this;
    }

    public Builder setChildPropertyXYZ( int value ) {
      // "int"
      childPropertyXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #realBooking}.<br/>
     * <p/>
     * <b>Breaking Change with 2.0:</b> Association will be mandatory.
     *
     * @param pRealBooking Value to which {@link #realBooking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setRealBooking( Booking pRealBooking ) {
      realBooking = pRealBooking;
      return this;
    }

    public Builder setRealBookingXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Booking"
      realBookingXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #inventories}.<br/>
     * <p/>
     * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
     *
     * @param pInventories Collection to which {@link #inventories} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventories( Set<InventoryType> pInventories ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pInventories != null) {
        inventories = new HashSet<InventoryType>(pInventories);
      }
      else {
        inventories = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #inventories}.<br/>
     * <p/>
     * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
     *
     * @param pInventories Array of objects that should be added to {@link #inventories}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToInventories( InventoryType... pInventories ) {
      if (pInventories != null) {
        if (inventories == null) {
          inventories = new HashSet<InventoryType>();
        }
        inventories.addAll(Arrays.asList(pInventories));
      }
      return this;
    }

    /**
     * Method sets association {@link #inventories}.<br/>
     * <p/>
     * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
     *
     * @param pInventories Array with objects to which {@link #inventories} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventories( InventoryType... pInventories ) {
      // To ensure immutability we have to copy the content of the passed array.
      if (pInventories != null) {
        inventories = new HashSet<InventoryType>(Arrays.asList(pInventories));
      }
      else {
        inventories = null;
      }
      return this;
    }

    public Builder setInventoriesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
      inventoriesXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class WeirdBooking. The object will be initialized with the values of the
     * builder.
     *
     * @return WeirdBooking Created object. The method never returns null.
     */
    public WeirdBooking build( ) {
      return new WeirdBooking(this);
    }

    /**
     * Method creates a new validated instance of class WeirdBooking. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return WeirdBooking Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WeirdBooking buildValidated( ) throws ConstraintViolationException {
      WeirdBooking lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #booking}.<br/>
   *
   * @return {@link ComplexBookingID} Value to which {@link #booking} is set.
   */
  public ComplexBookingID getBooking( ) {
    return booking;
  }

  /**
   * Method sets association {@link #booking}.<br/>
   *
   * @param pBooking Value to which {@link #booking} should be set.
   */
  public void setBooking( ComplexBookingID pBooking ) {
    booking = pBooking;
  }

  /**
   * Method unsets {@link #booking}.
   */
  public final void unsetBooking( ) {
    booking = null;
  }

  public int getBookingXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    return bookingXYZ;
  }

  public void setBookingXYZ( int value ) {
    bookingXYZ = value;
  }

  /**
   * Method returns association {@link #additionalBookings}.<br/>
   * additional bookings
   *
   * @return {@link List<ComplexBookingID>} Value to which {@link #additionalBookings} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<ComplexBookingID> getAdditionalBookings( ) {
    // Return all ComplexBookingID objects as unmodifiable collection.
    return Collections.unmodifiableList(additionalBookings);
  }

  /**
   * Method adds the passed object to {@link #additionalBookings}.
   *
   * @param pAdditionalBookings Object that should be added to {@link #additionalBookings}. The parameter must not be
   * null.
   */
  public void addToAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Add passed object to collection of associated ComplexBookingID objects.
    additionalBookings.add(pAdditionalBookings);
  }

  /**
   * Method adds all passed objects to {@link #additionalBookings}.
   *
   * @param pAdditionalBookings Collection with all objects that should be added to {@link #additionalBookings}. The
   * parameter must not be null.
   */
  public void addToAdditionalBookings( Collection<ComplexBookingID> pAdditionalBookings ) {
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Add all passed objects.
    for (ComplexBookingID lNextObject : pAdditionalBookings) {
      this.addToAdditionalBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #additionalBookings}.<br/>
   *
   * @param pAdditionalBookings Object that should be removed from {@link #additionalBookings}. The parameter must not
   * be null.
   */
  public void removeFromAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Remove passed object from collection of associated ComplexBookingID objects.
    additionalBookings.remove(pAdditionalBookings);
  }

  /**
   * Method removes all objects from {@link #additionalBookings}.
   */
  public void clearAdditionalBookings( ) {
    // Remove all objects from association "additionalBookings".
    additionalBookings.clear();
  }

  public int getAdditionalBookingsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.composite.ComplexBookingID"
    return additionalBookingsXYZ;
  }

  public void setAdditionalBookingsXYZ( int value ) {
    additionalBookingsXYZ = value;
  }

  /**
   * Method returns association {@link #versionedObjectSoftLink}.<br/>
   * soft link<br/>
   * 2nd line<br/>
   * 3rd line
   *
   * @return {@link VersionedObjectSoftLink} Value to which {@link #versionedObjectSoftLink} is set.
   */
  public VersionedObjectSoftLink getVersionedObjectSoftLink( ) {
    return versionedObjectSoftLink;
  }

  /**
   * Method sets association {@link #versionedObjectSoftLink}.<br/>
   * soft link<br/>
   * 2nd line<br/>
   * 3rd line
   *
   * @param pVersionedObjectSoftLink Value to which {@link #versionedObjectSoftLink} should be set.
   */
  public void setVersionedObjectSoftLink( VersionedObjectSoftLink pVersionedObjectSoftLink ) {
    versionedObjectSoftLink = pVersionedObjectSoftLink;
  }

  /**
   * Method unsets {@link #versionedObjectSoftLink}.
   */
  public final void unsetVersionedObjectSoftLink( ) {
    versionedObjectSoftLink = null;
  }

  public int getVersionedObjectSoftLinkXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.VersionedObjectSoftLink"
    return versionedObjectSoftLinkXYZ;
  }

  public void setVersionedObjectSoftLinkXYZ( int value ) {
    versionedObjectSoftLinkXYZ = value;
  }

  /**
   * Method returns attribute {@link #childProperty}.<br/>
   *
   * @return int Value to which {@link #childProperty} is set.
   */
  public int getChildProperty( ) {
    return childProperty;
  }

  /**
   * Method sets attribute {@link #childProperty}.<br/>
   *
   * @param pChildProperty Value to which {@link #childProperty} should be set.
   */
  public void setChildProperty( int pChildProperty ) {
    // Assign value to attribute
    childProperty = pChildProperty;
  }

  public int getChildPropertyXYZ( ) {
    // "int"
    return childPropertyXYZ;
  }

  public void setChildPropertyXYZ( int value ) {
    childPropertyXYZ = value;
  }

  /**
   * Method returns association {@link #realBooking}.<br/>
   * the real booking
   * <p/>
   * <b>Breaking Change with 2.0:</b> Association will be mandatory.
   *
   * @return {@link Booking} Value to which {@link #realBooking} is set.
   */
  public Booking getRealBooking( ) {
    return realBooking;
  }

  /**
   * Method sets association {@link #realBooking}.<br/>
   * the real booking
   * <p/>
   * <b>Breaking Change with 2.0:</b> Association will be mandatory.
   *
   * @param pRealBooking Value to which {@link #realBooking} should be set.
   */
  public void setRealBooking( Booking pRealBooking ) {
    realBooking = pRealBooking;
  }

  /**
   * Method unsets {@link #realBooking}.
   */
  public final void unsetRealBooking( ) {
    realBooking = null;
  }

  public int getRealBookingXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Booking"
    return realBookingXYZ;
  }

  public void setRealBookingXYZ( int value ) {
    realBookingXYZ = value;
  }

  /**
   * Method returns association {@link #inventories}.<br/>
   * <p/>
   * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
   *
   * @return {@link Set<InventoryType>} Value to which {@link #inventories} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<InventoryType> getInventories( ) {
    // Return all InventoryType objects as unmodifiable collection.
    return Collections.unmodifiableSet(inventories);
  }

  /**
   * Method adds the passed object to {@link #inventories}.
   * <p/>
   * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
   *
   * @param pInventories Object that should be added to {@link #inventories}. The parameter must not be null.
   */
  public void addToInventories( InventoryType pInventories ) {
    // Check parameter "pInventories" for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Add passed object to collection of associated InventoryType objects.
    inventories.add(pInventories);
  }

  /**
   * Method adds all passed objects to {@link #inventories}.
   * <p/>
   * <b>Breaking Change with 2.1:</b> Association will required at least 1 object.
   *
   * @param pInventories Collection with all objects that should be added to {@link #inventories}. The parameter must
   * not be null.
   */
  public void addToInventories( Collection<InventoryType> pInventories ) {
    // Check parameter "pInventories" for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Add all passed objects.
    for (InventoryType lNextObject : pInventories) {
      this.addToInventories(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #inventories}.<br/>
   *
   * @param pInventories Object that should be removed from {@link #inventories}. The parameter must not be null.
   */
  public void removeFromInventories( InventoryType pInventories ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pInventories, "pInventories");
    // Remove passed object from collection of associated InventoryType objects.
    inventories.remove(pInventories);
  }

  /**
   * Method removes all objects from {@link #inventories}.
   */
  public void clearInventories( ) {
    // Remove all objects from association "inventories".
    inventories.clear();
  }

  public int getInventoriesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    return inventoriesXYZ;
  }

  public void setInventoriesXYZ( int value ) {
    inventoriesXYZ = value;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childProperty: ");
    lBuilder.append(childProperty);
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
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
