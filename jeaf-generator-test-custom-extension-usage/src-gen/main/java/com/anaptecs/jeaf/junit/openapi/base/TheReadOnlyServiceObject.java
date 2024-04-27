/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class TheReadOnlyServiceObject extends Object implements ServiceObject {
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
  @Deprecated
  public static final String INVENTORYTYPE = "inventoryType";

  // "String"
  @ClassPropertyDeclaration
  private final String name;

  // "String"
  private int nameXYZ = 0;

  // "Boolean"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with PI 16:</b> At least one bit will be expected.
   */
  private final boolean[] bits;

  // "Boolean"
  private int bitsXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
  @ClassPropertyDeclaration
  private final Set<BookingCode> bookingCodes;

  // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
  private int bookingCodesXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
  @ClassPropertyDeclaration
  /**
   * @deprecated Let's reproduce #65 (<b>since:</b> not too long, <b>removed with:</b> 99.9)
   */
  @Deprecated
  private final InventoryType inventoryType;

  // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
  private int inventoryTypeXYZ = 0;

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
    // "String"
    nameXYZ = pBuilder.nameXYZ;
    bits = pBuilder.bits;
    // "Boolean"
    bitsXYZ = pBuilder.bitsXYZ;
    if (pBuilder.bookingCodes != null) {
      bookingCodes = pBuilder.bookingCodes;
    }
    else {
      bookingCodes = new HashSet<BookingCode>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    bookingCodesXYZ = pBuilder.bookingCodesXYZ;
    inventoryType = pBuilder.inventoryType;
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    inventoryTypeXYZ = pBuilder.inventoryTypeXYZ;
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
   * Class implements builder to create a new instance of class <code>TheReadOnlyServiceObject</code>.
   */
  public static class Builder {
    // "String"
    @BuilderPropertyDeclaration
    private String name;

    // "String"
    private int nameXYZ = 0;

    /**
     * <p/>
     * <b>Breaking Change with PI 16:</b> At least one bit will be expected.
     */
    // "Boolean"
    @BuilderPropertyDeclaration
    private boolean[] bits;

    // "Boolean"
    private int bitsXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    @BuilderPropertyDeclaration
    private Set<BookingCode> bookingCodes;

    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    private int bookingCodesXYZ = 0;

    /**
     * @deprecated Let's reproduce #65 (<b>since:</b> not too long, <b>removed with:</b> 99.9)
     */
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    @BuilderPropertyDeclaration
    @Deprecated
    private InventoryType inventoryType;

    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    private int inventoryTypeXYZ = 0;

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
        this.setName(pObject.name);
        this.setBits(pObject.bits);
        this.setBookingCodes(pObject.bookingCodes);
        this.setInventoryType(pObject.inventoryType);
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

    public Builder setNameXYZ( int value ) {
      // "String"
      nameXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #bits}.<br/>
     * <p/>
     * <b>Breaking Change with PI 16:</b> At least one bit will be expected.
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

    public Builder setBitsXYZ( int value ) {
      // "Boolean"
      bitsXYZ = value;
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

    public Builder setBookingCodesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
      bookingCodesXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #inventoryType}.<br/>
     *
     * @param pInventoryType Value to which {@link #inventoryType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated Let's reproduce #65 (<b>since:</b> not too long, <b>removed with:</b> 99.9)
     */
    @Deprecated
    public Builder setInventoryType( InventoryType pInventoryType ) {
      inventoryType = pInventoryType;
      return this;
    }

    public Builder setInventoryTypeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
      inventoryTypeXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class TheReadOnlyServiceObject. The object will be initialized with the values
     * of the builder.
     *
     * @return TheReadOnlyServiceObject Created object. The method never returns null.
     */
    public TheReadOnlyServiceObject build( ) {
      return new TheReadOnlyServiceObject(this);
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

  public int getNameXYZ( ) {
    // "String"
    return nameXYZ;
  }

  public void setNameXYZ( int value ) {
    nameXYZ = value;
  }

  /**
   * Method returns attribute {@link #bits}.<br/>
   * <p/>
   * <b>Breaking Change with PI 16:</b> At least one bit will be expected.
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

  public int getBitsXYZ( ) {
    // "Boolean"
    return bitsXYZ;
  }

  public void setBitsXYZ( int value ) {
    bitsXYZ = value;
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

  public int getBookingCodesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.BookingCode"
    return bookingCodesXYZ;
  }

  public void setBookingCodesXYZ( int value ) {
    bookingCodesXYZ = value;
  }

  /**
   * Method returns association {@link #inventoryType}.<br/>
   *
   * @return {@link InventoryType} Value to which {@link #inventoryType} is set.
   * @deprecated Let's reproduce #65 (<b>since:</b> not too long, <b>removed with:</b> 99.9)
   */
  @Deprecated
  public InventoryType getInventoryType( ) {
    return inventoryType;
  }

  public int getInventoryTypeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InventoryType"
    return inventoryTypeXYZ;
  }

  public void setInventoryTypeXYZ( int value ) {
    inventoryTypeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new TheReadOnlyServiceObject objects. The method
   * never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
