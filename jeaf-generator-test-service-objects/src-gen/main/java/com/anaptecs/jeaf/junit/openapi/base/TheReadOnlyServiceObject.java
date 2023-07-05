/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class TheReadOnlyServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "bits".
   */
  public static final String BITS = "bits";

  /**
   * Constant for the name of attribute "bookingCodes".
   */
  public static final String BOOKINGCODES = "bookingCodes";

  /**
   * Constant for the name of attribute "inventoryType".
   */
  public static final String INVENTORYTYPE = "inventoryType";

  private final String name;

  private final boolean[] bits;

  private final Set<BookingCode> bookingCodes;

  private final InventoryType inventoryType;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TheReadOnlyServiceObject( ) {
    name = null;
    bits = null;
    bookingCodes = new HashSet<BookingCode>();
    inventoryType = null;
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TheReadOnlyServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    bits = pBuilder.bits;
    if (pBuilder.bookingCodes != null) {
      bookingCodes = pBuilder.bookingCodes;
    }
    else {
      bookingCodes = new HashSet<BookingCode>();
    }
    inventoryType = pBuilder.inventoryType;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TheReadOnlyServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TheReadOnlyServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( TheReadOnlyServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>TheReadOnlyServiceObject</code>.
   */
  public static class Builder {
    private String name;

    private boolean[] bits;

    private Set<BookingCode> bookingCodes;

    private InventoryType inventoryType;

    /**
     * Use {@link TheReadOnlyServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TheReadOnlyServiceObject#builder(TheReadOnlyServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( TheReadOnlyServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        bits = pObject.bits;
        bookingCodes = pObject.bookingCodes;
        inventoryType = pObject.inventoryType;
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #bits}.<br/>
     *
     * @param pBits Value to which {@link #bits} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBits( boolean[] pBits ) {
      // Assign value to attribute
      if (pBits != null) {
        bits = new boolean[pBits.length];
        System.arraycopy(pBits, 0, bits, 0, pBits.length);
      }
      else {
        bits = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #bookingCodes}.<br/>
     *
     * @param pBookingCodes Collection to which {@link #bookingCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingCodes( Set<BookingCode> pBookingCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingCodes != null) {
        bookingCodes = new HashSet<BookingCode>(pBookingCodes);
      }
      else {
        bookingCodes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bookingCodes}.<br/>
     *
     * @param pBookingCodes Array of objects that should be added to {@link #bookingCodes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBookingCodes( BookingCode... pBookingCodes ) {
      if (pBookingCodes != null) {
        if (bookingCodes == null) {
          bookingCodes = new HashSet<BookingCode>();
        }
        bookingCodes.addAll(Arrays.asList(pBookingCodes));
      }
      return this;
    }

    /**
     * Method sets association {@link #inventoryType}.<br/>
     *
     * @param pInventoryType Value to which {@link #inventoryType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInventoryType( InventoryType pInventoryType ) {
      inventoryType = pInventoryType;
      return this;
    }

    /**
     * Method creates a new instance of class TheReadOnlyServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return TheReadOnlyServiceObject Created object. The method never returns null.
     */
    public TheReadOnlyServiceObject build( ) {
      TheReadOnlyServiceObject lObject = new TheReadOnlyServiceObject(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class TheReadOnlyServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     *
     * @return TheReadOnlyServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TheReadOnlyServiceObject buildValidated( ) throws ConstraintViolationException {
      TheReadOnlyServiceObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   *
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method returns attribute {@link #bits}.<br/>
   *
   * @return boolean Value to which {@link #bits} is set.
   */
  public boolean[] getBits( ) {
    boolean[] lReturnValue;
    if (bits != null) {
      lReturnValue = new boolean[bits.length];
      System.arraycopy(bits, 0, lReturnValue, 0, bits.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method returns association {@link #bookingCodes}.<br/>
   *
   * @return {@link Set<BookingCode>} Value to which {@link #bookingCodes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<BookingCode> getBookingCodes( ) {
    // Return all BookingCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookingCodes);
  }

  /**
   * Method returns association {@link #inventoryType}.<br/>
   *
   * @return {@link InventoryType} Value to which {@link #inventoryType} is set.
   */
  public InventoryType getInventoryType( ) {
    return inventoryType;
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
    lBuilder.append("name: ");
    lBuilder.append(name);
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
