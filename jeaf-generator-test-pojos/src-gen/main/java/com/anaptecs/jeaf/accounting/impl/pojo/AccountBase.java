/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AccountBase {
  /**
   * Constant for the name of attribute "iban".
   */
  public static final String IBAN = "iban";

  /**
   * Constant for the name of attribute "owner".
   */
  public static final String OWNER = "owner";

  /**
   * Constant for the name of attribute "currency".
   */
  public static final String CURRENCY = "currency";

  /**
   * Constant for the name of attribute "allBookings".
   */
  public static final String ALLBOOKINGS = "allBookings";

  /**
   * 
   */
  private int iban;

  /**
   * 
   */
  private Customer owner;

  /**
   * 
   */
  private Currency currency;

  /**
   * 
   */
  private Set<Booking> allBookings;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AccountBase( ) {
    allBookings = new HashSet<Booking>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AccountBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    iban = pBuilder.iban;
    owner = pBuilder.owner;
    currency = pBuilder.currency;
    if (pBuilder.allBookings != null) {
      allBookings = pBuilder.allBookings;
    }
    else {
      allBookings = new HashSet<Booking>();
    }
  }

  /**
   * Class implements builder to create a new instance of class Account. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    private int iban;

    /**
     * 
     */
    private Customer owner;

    /**
     * 
     */
    private Currency currency;

    /**
     * 
     */
    private Set<Booking> allBookings;

    /**
     * Use {@link Account.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Account.builder(Account)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( AccountBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        iban = pObject.iban;
        owner = pObject.owner;
        currency = pObject.currency;
        allBookings = pObject.allBookings;
      }
    }

    /**
     * Method sets the attribute "iban".
     * 
     * @param pIban Value to which the attribute "iban" should be set.
     */
    public BuilderBase setIban( int pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method sets the association "owner".
     * 
     * @param pOwner Customer to which the association "owner" should be set.
     */
    public BuilderBase setOwner( Customer pOwner ) {
      owner = pOwner;
      return this;
    }

    /**
     * Method sets the attribute "currency".
     * 
     * @param pCurrency Value to which the attribute "currency" should be set.
     */
    public BuilderBase setCurrency( Currency pCurrency ) {
      // Assign value to attribute
      currency = pCurrency;
      return this;
    }

    /**
     * Method sets the association "allBookings".
     * 
     * @param pAllBookings Collection with objects to which the association should be set.
     */
    public BuilderBase setAllBookings( Set<Booking> pAllBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAllBookings != null) {
        allBookings = new HashSet<Booking>(pAllBookings);
      }
      else {
        allBookings = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Account. The object will be initialized with the values of the builder.
     * 
     * @return Account Created object. The method never returns null.
     */
    public Account build( ) {
      return new Account(this);
    }

    /**
     * Method creates a new validated instance of class Account. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Account Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Account buildValidated( ) throws ConstraintViolationException {
      Account lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "iban".
   * 
   * 
   * @return int Value to which the attribute "iban" is set.
   */
  public int getIban( ) {
    return iban;
  }

  /**
   * Method sets the attribute "iban".
   * 
   * 
   * @param pIban Value to which the attribute "iban" should be set.
   */
  public void setIban( int pIban ) {
    // Assign value to attribute
    iban = pIban;
  }

  /**
   * Method returns the association "owner".
   * 
   *
   * @return Customer Customer to which the association "owner" is set.
   */
  public Customer getOwner( ) {
    return owner;
  }

  /**
   * Method sets the association "owner".
   * 
   * 
   * @param pOwner Customer to which the association "owner" should be set.
   */
  public void setOwner( Customer pOwner ) {
    // Release already referenced object before setting a new association.
    if (owner != null) {
      owner.removeFromAccounts((Account) this);
    }
    owner = pOwner;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pOwner != null && pOwner.getAccounts().contains(this) == false) {
      pOwner.addToAccounts((Account) this);
    }
  }

  /**
   * Method unsets the association "owner".
   * 
   */
  public final void unsetOwner( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    Customer lCustomer = owner;
    owner = null;
    if (lCustomer != null && lCustomer.getAccounts().contains(this) == true) {
      lCustomer.removeFromAccounts((Account) this);
    }
  }

  /**
   * Method returns the attribute "currency".
   * 
   * 
   * @return Currency Value to which the attribute "currency" is set.
   */
  public Currency getCurrency( ) {
    return currency;
  }

  /**
   * Method sets the attribute "currency".
   * 
   * 
   * @param pCurrency Value to which the attribute "currency" should be set.
   */
  public void setCurrency( Currency pCurrency ) {
    // Assign value to attribute
    currency = pCurrency;
  }

  /**
   * Method returns the association "allBookings".
   * 
   *
   * @return Collection All Booking objects that belong to the association "allBookings". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<Booking> getAllBookings( ) {
    // Return all Booking objects as unmodifiable collection.
    return Collections.unmodifiableSet(allBookings);
  }

  /**
   * Method adds the passed Booking object to the association "allBookings".
   * 
   * 
   * @param pAllBookings Object that should be added to the association "allBookings". The parameter must not be null.
   */
  public void addToAllBookings( Booking pAllBookings ) {
    // Check parameter "pAllBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAllBookings, "pAllBookings");
    // Add passed object to collection of associated Booking objects.
    allBookings.add(pAllBookings);
  }

  /**
   * Method adds all passed objects to the association "allBookings".
   * 
   * 
   * @param pAllBookings Collection with all objects that should be added to the association "allBookings". The
   * parameter must not be null.
   */
  public void addToAllBookings( Collection<Booking> pAllBookings ) {
    // Check parameter "pAllBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAllBookings, "pAllBookings");
    // Add all passed objects.
    for (Booking lNextObject : pAllBookings) {
      this.addToAllBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed Booking object from the association "allBookings".
   * 
   * 
   * @param pAllBookings Object that should be removed from the association "allBookings". The parameter must not be
   * null.
   */
  public void removeFromAllBookings( Booking pAllBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAllBookings, "pAllBookings");
    // Remove passed object from collection of associated Booking objects.
    allBookings.remove(pAllBookings);
  }

  /**
   * Method removes all objects from the association "allBookings".
   * 
   */
  public void clearAllBookings( ) {
    // Remove all objects from association "allBookings".
    allBookings.clear();
  }

  /**
   * 
   * @return {@link BigDecimal}
   */
  public abstract BigDecimal calcuateBalance( );

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
    lBuilder.append("iban: ");
    lBuilder.append(iban);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("currency: ");
    lBuilder.append(currency);
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
