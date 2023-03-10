/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.Severity.Error;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

@Valid
public abstract class AccountBase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "iban".
   */
  public static final String IBAN = "iban";

  /**
   * Constant for the name of attribute "balance".
   */
  public static final String BALANCE = "balance";

  /**
   * Constant for the name of attribute "authorizedPersons".
   */
  public static final String AUTHORIZEDPERSONS = "authorizedPersons";

  /**
   * Constant for the name of attribute "bookings".
   */
  public static final String BOOKINGS = "bookings";

  /**
   * Constant for the name of attribute "bankID".
   */
  public static final String BANKID = "bankID";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  @Min(value = 123)
  private Long iban;

  @DecimalMax(value = "1.2345", inclusive = false, message = "12345", payload = Error.class)
  @Digits(integer = 9, fraction = 5, message = "12345", payload = Error.class)
  private BigDecimal balance;

  private Set<Person> authorizedPersons;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean authorizedPersonsBackReferenceInitialized;

  @Valid
  @Size(min = 0, max = 100)
  private Set<Booking> bookings;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean bookingsBackReferenceInitialized;

  private ServiceObjectID bankID;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected AccountBase( ) {
    objectID = null;
    authorizedPersons = new HashSet<Person>();
    // Bidirectional back reference is not yet set up correctly
    authorizedPersonsBackReferenceInitialized = false;
    bookings = new HashSet<Booking>();
    // Bidirectional back reference is not yet set up correctly
    bookingsBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AccountBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    iban = pBuilder.iban;
    balance = pBuilder.balance;
    if (pBuilder.authorizedPersons != null) {
      authorizedPersons = pBuilder.authorizedPersons;
    }
    else {
      authorizedPersons = new HashSet<Person>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    authorizedPersonsBackReferenceInitialized = true;
    if (pBuilder.bookings != null) {
      bookings = pBuilder.bookings;
    }
    else {
      bookings = new HashSet<Booking>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    bookingsBackReferenceInitialized = true;
    bankID = pBuilder.bankID;
  }

  /**
   * Class implements builder to create a new instance of class Account. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    @Min(value = 123)
    private Long iban;

    @DecimalMax(value = "1.2345", inclusive = false, message = "12345", payload = Error.class)
    @Digits(integer = 9, fraction = 5, message = "12345", payload = Error.class)
    private BigDecimal balance;

    private Set<Person> authorizedPersons;

    private Set<Booking> bookings;

    private ServiceObjectID bankID;

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
        objectID = pObject.objectID;
        iban = pObject.iban;
        balance = pObject.balance;
        authorizedPersons = pObject.authorizedPersons;
        bookings = pObject.bookings;
        bankID = pObject.bankID;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "iban".
     * 
     * @param pIban Value to which the attribute "iban" should be set.
     */
    public BuilderBase setIban( Long pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method sets the attribute "balance".
     * 
     * @param pBalance Value to which the attribute "balance" should be set.
     */
    public BuilderBase setBalance( BigDecimal pBalance ) {
      // Assign value to attribute
      balance = pBalance;
      return this;
    }

    /**
     * Method sets the association "authorizedPersons".
     * 
     * @param pAuthorizedPersons Collection with objects to which the association should be set.
     */
    public BuilderBase setAuthorizedPersons( Set<Person> pAuthorizedPersons ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAuthorizedPersons != null) {
        authorizedPersons = new HashSet<Person>(pAuthorizedPersons);
      }
      else {
        authorizedPersons = null;
      }
      return this;
    }

    /**
     * Method sets the association "bookings".
     * 
     * @param pBookings Collection with objects to which the association should be set.
     */
    public BuilderBase setBookings( Set<Booking> pBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookings != null) {
        bookings = new HashSet<Booking>(pBookings);
      }
      else {
        bookings = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "bankID".
     * 
     * @param pBankID Value to which the attribute "bankID" should be set.
     */
    public BuilderBase setBankID( ServiceObjectID pBankID ) {
      // Assign value to attribute
      bankID = pBankID;
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
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns attribute {@link #iban}.<br/>
   * 
   * @return {@link Long} Value to which {@link #iban} is set.
   */
  public Long getIban( ) {
    return iban;
  }

  /**
   * Method sets attribute {@link #iban}.<br/>
   * 
   * @param pIban Value to which {@link #iban} should be set.
   */
  public void setIban( Long pIban ) {
    // Assign value to attribute
    iban = pIban;
  }

  /**
   * Method returns attribute {@link #balance}.<br/>
   * 
   * @return {@link BigDecimal} Value to which {@link #balance} is set.
   */
  public BigDecimal getBalance( ) {
    return balance;
  }

  /**
   * Method sets attribute {@link #balance}.<br/>
   * 
   * @param pBalance Value to which {@link #balance} should be set.
   */
  public void setBalance( BigDecimal pBalance ) {
    // Assign value to attribute
    balance = pBalance;
  }

  /**
   * Method returns association {@link #authorizedPersons}.<br/>
   * 
   * @return {@link Set<Person>} Value to which {@link #authorizedPersons} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Person> getAuthorizedPersons( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (authorizedPersonsBackReferenceInitialized == false) {
      authorizedPersonsBackReferenceInitialized = true;
      for (Person lNext : authorizedPersons) {
        lNext.addToAccounts((Account) this);
      }
    }
    // Return all Person objects as unmodifiable collection.
    return Collections.unmodifiableSet(authorizedPersons);
  }

  /**
   * Method adds the passed object to {@link #authorizedPersons}.
   * 
   * @param pAuthorizedPersons Object that should be added to {@link #authorizedPersons}. The parameter must not be
   * null.
   */
  public void addToAuthorizedPersons( Person pAuthorizedPersons ) {
    // Check parameter "pAuthorizedPersons" for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Add passed object to collection of associated Person objects.
    authorizedPersons.add(pAuthorizedPersons);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAuthorizedPersons != null && pAuthorizedPersons.getAccounts().contains(this) == false) {
      pAuthorizedPersons.addToAccounts((Account) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #authorizedPersons}.
   * 
   * @param pAuthorizedPersons Collection with all objects that should be added to {@link #authorizedPersons}. The
   * parameter must not be null.
   */
  public void addToAuthorizedPersons( Collection<Person> pAuthorizedPersons ) {
    // Check parameter "pAuthorizedPersons" for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Add all passed objects.
    for (Person lNextObject : pAuthorizedPersons) {
      this.addToAuthorizedPersons(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #authorizedPersons}.<br/>
   * 
   * @param pAuthorizedPersons Object that should be removed from {@link #authorizedPersons}. The parameter must not be
   * null.
   */
  public void removeFromAuthorizedPersons( Person pAuthorizedPersons ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Remove passed object from collection of associated Person objects.
    authorizedPersons.remove(pAuthorizedPersons);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAuthorizedPersons.getAccounts().contains(this) == true) {
      pAuthorizedPersons.removeFromAccounts((Account) this);
    }
  }

  /**
   * Method removes all objects from {@link #authorizedPersons}.
   */
  public void clearAuthorizedPersons( ) {
    // Remove all objects from association "authorizedPersons".
    Collection<Person> lAuthorizedPersons = new HashSet<Person>(authorizedPersons);
    Iterator<Person> lIterator = lAuthorizedPersons.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAuthorizedPersons(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #bookings}.<br/>
   * 
   * @return {@link Set<Booking>} Value to which {@link #bookings} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Booking> getBookings( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (bookingsBackReferenceInitialized == false) {
      bookingsBackReferenceInitialized = true;
      for (Booking lNext : bookings) {
        lNext.setAccount((Account) this);
      }
    }
    // Return all Booking objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookings);
  }

  /**
   * Method adds the passed object to {@link #bookings}.
   * 
   * @param pBookings Object that should be added to {@link #bookings}. The parameter must not be null.
   */
  public void addToBookings( Booking pBookings ) {
    // Check parameter "pBookings" for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pBookings.unsetAccount();
    // Add passed object to collection of associated Booking objects.
    bookings.add(pBookings);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBookings != null && this.equals(pBookings.getAccount()) == false) {
      pBookings.setAccount((Account) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #bookings}.
   * 
   * @param pBookings Collection with all objects that should be added to {@link #bookings}. The parameter must not be
   * null.
   */
  public void addToBookings( Collection<Booking> pBookings ) {
    // Check parameter "pBookings" for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Add all passed objects.
    for (Booking lNextObject : pBookings) {
      this.addToBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bookings}.<br/>
   * 
   * @param pBookings Object that should be removed from {@link #bookings}. The parameter must not be null.
   */
  public void removeFromBookings( Booking pBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Remove passed object from collection of associated Booking objects.
    bookings.remove(pBookings);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pBookings.getAccount()) == true) {
      pBookings.unsetAccount();
    }
  }

  /**
   * Method removes all objects from {@link #bookings}.
   */
  public void clearBookings( ) {
    // Remove all objects from association "bookings".
    Collection<Booking> lBookings = new HashSet<Booking>(bookings);
    Iterator<Booking> lIterator = lBookings.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromBookings(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #bankID}.<br/>
   * 
   * @return {@link ServiceObjectID} Value to which {@link #bankID} is set.
   */
  public ServiceObjectID getBankID( ) {
    return bankID;
  }

  /**
   * Method sets attribute {@link #bankID}.<br/>
   * 
   * @param pBankID Value to which {@link #bankID} should be set.
   */
  public void setBankID( ServiceObjectID pBankID ) {
    // Assign value to attribute
    bankID = pBankID;
  }

  /**
   * @return {@link Double}
   */
  @NotNull
  public abstract Double calclulateBalance( );

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
    lBuilder.append("balance: ");
    lBuilder.append(balance);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("bankID: ");
    lBuilder.append(bankID);
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
