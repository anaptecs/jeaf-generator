/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.math.BigDecimal;
import java.util.Arrays;
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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

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

  private int iban;

  private Customer owner;

  private Currency currency;

  @JsonSetter(nulls = Nulls.SKIP)
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
    if (owner != null) {
      // As association is bidirectional we also have to set it in the other direction.
      owner.addToAccounts((Account) this);
    }
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
    private int iban;

    private Customer owner;

    private Currency currency;

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
        this.setIban(pObject.iban);
        this.setOwner(pObject.owner);
        this.setCurrency(pObject.currency);
        this.setAllBookings(pObject.allBookings);
      }
    }

    /**
     * Method sets attribute {@link #iban}.<br/>
     *
     * @param pIban Value to which {@link #iban} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setIban( int pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method sets association {@link #owner}.<br/>
     *
     * @param pOwner Value to which {@link #owner} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setOwner( Customer pOwner ) {
      owner = pOwner;
      return this;
    }

    /**
     * Method sets attribute {@link #currency}.<br/>
     *
     * @param pCurrency Value to which {@link #currency} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setCurrency( Currency pCurrency ) {
      // Assign value to attribute
      currency = pCurrency;
      return this;
    }

    /**
     * Method sets association {@link #allBookings}.<br/>
     *
     * @param pAllBookings Collection to which {@link #allBookings} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #allBookings}.<br/>
     *
     * @param pAllBookings Array of objects that should be added to {@link #allBookings}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToAllBookings( Booking... pAllBookings ) {
      if (pAllBookings != null) {
        if (allBookings == null) {
          allBookings = new HashSet<Booking>();
        }
        allBookings.addAll(Arrays.asList(pAllBookings));
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
   * Method returns attribute {@link #iban}.<br/>
   *
   * @return int Value to which {@link #iban} is set.
   */
  public int getIban( ) {
    return iban;
  }

  /**
   * Method sets attribute {@link #iban}.<br/>
   *
   * @param pIban Value to which {@link #iban} should be set.
   */
  public void setIban( int pIban ) {
    // Assign value to attribute
    iban = pIban;
  }

  /**
   * Method returns association {@link #owner}.<br/>
   *
   * @return {@link Customer} Value to which {@link #owner} is set.
   */
  public Customer getOwner( ) {
    return owner;
  }

  /**
   * Method sets association {@link #owner}.<br/>
   *
   * @param pOwner Value to which {@link #owner} should be set.
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
   * Method unsets {@link #owner}.
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
   * Method returns attribute {@link #currency}.<br/>
   *
   * @return {@link Currency} Value to which {@link #currency} is set.
   */
  public Currency getCurrency( ) {
    return currency;
  }

  /**
   * Method sets attribute {@link #currency}.<br/>
   *
   * @param pCurrency Value to which {@link #currency} should be set.
   */
  public void setCurrency( Currency pCurrency ) {
    // Assign value to attribute
    currency = pCurrency;
  }

  /**
   * Method returns association {@link #allBookings}.<br/>
   *
   * @return {@link Set<Booking>} Value to which {@link #allBookings} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Booking> getAllBookings( ) {
    // Return all Booking objects as unmodifiable collection.
    return Collections.unmodifiableSet(allBookings);
  }

  /**
   * Method adds the passed object to {@link #allBookings}.
   *
   * @param pAllBookings Object that should be added to {@link #allBookings}. The parameter must not be null.
   */
  public void addToAllBookings( Booking pAllBookings ) {
    // Check parameter "pAllBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAllBookings, "pAllBookings");
    // Add passed object to collection of associated Booking objects.
    allBookings.add(pAllBookings);
  }

  /**
   * Method adds all passed objects to {@link #allBookings}.
   *
   * @param pAllBookings Collection with all objects that should be added to {@link #allBookings}. The parameter must
   * not be null.
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
   * Method removes the passed object from {@link #allBookings}.<br/>
   *
   * @param pAllBookings Object that should be removed from {@link #allBookings}. The parameter must not be null.
   */
  public void removeFromAllBookings( Booking pAllBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAllBookings, "pAllBookings");
    // Remove passed object from collection of associated Booking objects.
    allBookings.remove(pAllBookings);
  }

  /**
   * Method removes all objects from {@link #allBookings}.
   */
  public void clearAllBookings( ) {
    // Remove all objects from association "allBookings".
    allBookings.clear();
  }

  /**
   * Convenience method to create new instance of class Account.
   *
   *
   * @param pIban Value to which {@link #iban} should be set.
   *
   * @param pOwner Value to which {@link #owner} should be set.
   *
   * @param pCurrency Value to which {@link #currency} should be set.
   *
   * @return {@link Account}
   */
  public static Account of( int pIban, Customer pOwner, Currency pCurrency ) {
    Account.Builder lBuilder = Account.builder();
    lBuilder.setIban(pIban);
    lBuilder.setOwner(pOwner);
    lBuilder.setCurrency(pCurrency);
    return lBuilder.build();
  }

  /**
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
    lBuilder.append("owner: ");
    if (owner != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(owner.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("currency: ");
    lBuilder.append(currency);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("allBookings: ");
    if (allBookings != null) {
      lBuilder.append(allBookings.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (allBookings != null) {
      for (Booking lNext : allBookings) {
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
   * @return {@link Builder} New builder that can be used to create new Account objects. The method never returns null.
   */
  public Account.Builder toBuilder( ) {
    return new Account.Builder((Account) this);
  }
}
