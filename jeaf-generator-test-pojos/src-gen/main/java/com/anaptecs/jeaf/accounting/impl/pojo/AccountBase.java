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
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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
  private Set<Booking> allBookings = new HashSet<Booking>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected AccountBase( ) {
    // Nothing to do.
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
      allBookings.addAll(pBuilder.allBookings);
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
     * Use {@link Account.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Account.Builder#newBuilder(Account)} instead of protected constructor to create new builder.
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
     * Method creates a new instance of class Account. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Account Created object. The method never returns null.
     */
    public Account build( boolean pValidate ) {
      Account lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
   * Method sets the association "allBookings" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pAllBookings Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setAllBookings( Set<Booking> pAllBookings ) {
    // Check of parameter is not required.
    // Remove all objects from association "allBookings".
    this.clearAllBookings();
    // If the association is null, removing all entries is sufficient.
    if (pAllBookings != null) {
      allBookings = new HashSet<Booking>(pAllBookings);
    }
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
    Collection<Booking> lAllBookings = new HashSet<Booking>(allBookings);
    Iterator<Booking> lIterator = lAllBookings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromAllBookings(lIterator.next());
    }
  }

  /**
   * 
   * @return {@link BigDecimal}
   */
  public abstract BigDecimal calcuateBalance( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "iban", "" + iban));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "currency", "" + currency));
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
