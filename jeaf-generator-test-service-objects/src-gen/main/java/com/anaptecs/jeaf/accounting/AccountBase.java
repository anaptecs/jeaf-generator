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

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.validation.Severity.Error;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.AbstractObjectID;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Valid()
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

  /**
   * 
   */
  @Min(value = 123)
  private Long iban;

  /**
   * 
   */
  @DecimalMax(value = "1.2345", inclusive = false, message = "12345", payload = Error.class)
  @Digits(integer = 9, fraction = 5, message = "12345", payload = Error.class)
  private BigDecimal balance;

  /**
   * 
   */
  private Set<Person> authorizedPersons = new HashSet<Person>();

  /**
   * 
   */
  @Valid()
  @Size(min = 0, max = 100)
  private Set<Booking> bookings = new HashSet<Booking>();

  /**
   * 
   */
  private ServiceObjectID bankID;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected AccountBase( ) {
    objectID = null;
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
    AbstractObjectID<?> lObjectID = pBuilder.objectID;
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
      authorizedPersons.addAll(pBuilder.authorizedPersons);
    }
    if (pBuilder.bookings != null) {
      bookings.addAll(pBuilder.bookings);
    }
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
    private AbstractObjectID<?> objectID;

    /**
     * 
     */
    @Min(value = 123)
    private Long iban;

    /**
     * 
     */
    @DecimalMax(value = "1.2345", inclusive = false, message = "12345", payload = Error.class)
    @Digits(integer = 9, fraction = 5, message = "12345", payload = Error.class)
    private BigDecimal balance;

    /**
     * 
     */
    private Set<Person> authorizedPersons;

    /**
     * 
     */
    private Set<Booking> bookings;

    /**
     * 
     */
    private ServiceObjectID bankID;

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
    public BuilderBase setID( AbstractObjectID<?> pObjectID ) {
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
   * Method returns the attribute "iban".
   * 
   * 
   * @return Long Value to which the attribute "iban" is set.
   */
  public Long getIban( ) {
    return iban;
  }

  /**
   * Method sets the attribute "iban".
   * 
   * 
   * @param pIban Value to which the attribute "iban" should be set.
   */
  public void setIban( Long pIban ) {
    // Assign value to attribute
    iban = pIban;
  }

  /**
   * Method returns the attribute "balance".
   * 
   * 
   * @return BigDecimal Value to which the attribute "balance" is set.
   */
  public BigDecimal getBalance( ) {
    return balance;
  }

  /**
   * Method sets the attribute "balance".
   * 
   * 
   * @param pBalance Value to which the attribute "balance" should be set.
   */
  public void setBalance( BigDecimal pBalance ) {
    // Assign value to attribute
    balance = pBalance;
  }

  /**
   * Method returns the association "authorizedPersons".
   * 
   *
   * @return Collection All Person objects that belong to the association "authorizedPersons". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<Person> getAuthorizedPersons( ) {
    // Return all Person objects as unmodifiable collection.
    return Collections.unmodifiableSet(authorizedPersons);
  }

  /**
   * Method sets the association "authorizedPersons" to the passed collection. All objects that formerly were part of
   * the association will be removed from it.
   * 
   * 
   * @param pAuthorizedPersons Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setAuthorizedPersons( Set<Person> pAuthorizedPersons ) {
    // Check of parameter is not required.
    // Remove all objects from association "authorizedPersons".
    this.clearAuthorizedPersons();
    // If the association is null, removing all entries is sufficient.
    if (pAuthorizedPersons != null) {
      authorizedPersons = new HashSet<Person>(pAuthorizedPersons);
    }
  }

  /**
   * Method adds the passed Person object to the association "authorizedPersons".
   * 
   * 
   * @param pAuthorizedPersons Object that should be added to the association "authorizedPersons". The parameter must
   * not be null.
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
   * Method adds all passed objects to the association "authorizedPersons".
   * 
   * 
   * @param pAuthorizedPersons Collection with all objects that should be added to the association "authorizedPersons".
   * The parameter must not be null.
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
   * Method removes the passed Person object from the association "authorizedPersons".
   * 
   * 
   * @param pAuthorizedPersons Object that should be removed from the association "authorizedPersons". The parameter
   * must not be null.
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
   * Method removes all objects from the association "authorizedPersons".
   * 
   */
  public void clearAuthorizedPersons( ) {
    // Remove all objects from association "authorizedPersons".
    Collection<Person> lAuthorizedPersons = new HashSet<Person>(authorizedPersons);
    Iterator<Person> lIterator = lAuthorizedPersons.iterator();
    while (lIterator.hasNext()) {
      this.removeFromAuthorizedPersons(lIterator.next());
    }
  }

  /**
   * Method returns the association "bookings".
   * 
   *
   * @return Collection All Booking objects that belong to the association "bookings". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Booking> getBookings( ) {
    // Return all Booking objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookings);
  }

  /**
   * Method sets the association "bookings" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pBookings Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setBookings( Set<Booking> pBookings ) {
    // Check of parameter is not required.
    // Remove all objects from association "bookings".
    this.clearBookings();
    // If the association is null, removing all entries is sufficient.
    if (pBookings != null) {
      bookings = new HashSet<Booking>(pBookings);
    }
  }

  /**
   * Method adds the passed Booking object to the association "bookings".
   * 
   * 
   * @param pBookings Object that should be added to the association "bookings". The parameter must not be null.
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
   * Method adds all passed objects to the association "bookings".
   * 
   * 
   * @param pBookings Collection with all objects that should be added to the association "bookings". The parameter must
   * not be null.
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
   * Method removes the passed Booking object from the association "bookings".
   * 
   * 
   * @param pBookings Object that should be removed from the association "bookings". The parameter must not be null.
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
   * Method removes all objects from the association "bookings".
   * 
   */
  public void clearBookings( ) {
    // Remove all objects from association "bookings".
    Collection<Booking> lBookings = new HashSet<Booking>(bookings);
    Iterator<Booking> lIterator = lBookings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromBookings(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "bankID".
   * 
   * 
   * @return ServiceObjectID Value to which the attribute "bankID" is set.
   */
  public ServiceObjectID getBankID( ) {
    return bankID;
  }

  /**
   * Method sets the attribute "bankID".
   * 
   * 
   * @param pBankID Value to which the attribute "bankID" should be set.
   */
  public void setBankID( ServiceObjectID pBankID ) {
    // Assign value to attribute
    bankID = pBankID;
  }

  /**
   * 
   * @return {@link Double}
   */
  @NotNull()
  public abstract Double calclulateBalance( );

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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "balance", "" + balance));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bankID", "" + bankID));
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
