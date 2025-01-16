package com.anaptecs.jeaf.accounting.impl.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class AccountBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1111, AccountBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "ACCOUNT";

  /**
   * Constant for the name of the row that is used to store the values of attribute "number".
   */
  public static final String NUMBER_ROW = "NUMBER";

  /**
   * Constant for the name of attribute "number".
   */
  public static final String NUMBER_ATTRIBUTE = "number";

  /**
   * Constant for the name of the row that is used to store the values of attribute "interestRate".
   */
  public static final String INTERESTRATE_ROW = "INTERESTRATE";

  /**
   * Constant for the name of attribute "interestRate".
   */
  public static final String INTERESTRATE_ATTRIBUTE = "interestRate";

  /**
   * Constant for the name of role "bank".
   */
  public static final String BANK_ROLE = "bank";

  /**
   * Constant for the name of role "customer".
   */
  public static final String CUSTOMER_ROLE = "customer";

  /**
   * Constant for the name of role "bookings".
   */
  public static final String BOOKINGS_ROLE = "bookings";

  /**
   * Constant for the name of role "authorizedPersons".
   */
  public static final String AUTHORIZEDPERSONS_ROLE = "authorizedPersons";

  private Long number;

  private BankBO bank;

  private CustomerBO customer;

  private Set<BookingBO> bookings;

  private Set<MyPersonBO> authorizedPersons;

  private Float interestRate;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected AccountBOBase( ) {
    bookings = new HashSet<BookingBO>();
    authorizedPersons = new HashSet<MyPersonBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<AccountBO> findAllAccountBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(AccountBO.class);
  }

  /**
   * Method returns attribute {@link #number}.<br/>
   *
   * @return {@link Long} Value to which {@link #number} is set.
   */
  public Long getNumber( ) {
    return number;
  }

  /**
   * Method sets attribute {@link #number}.<br/>
   *
   * @param pNumber Value to which {@link #number} should be set.
   */
  public void setNumber( Long pNumber ) {
    // Assign value to attribute
    number = pNumber;
  }

  /**
   * Method returns association {@link #bank}.<br/>
   *
   * @return {@link BankBO} Value to which {@link #bank} is set.
   */
  public BankBO getBank( ) {
    bank = this.unproxy(bank);
    return bank;
  }

  /**
   * Method sets association {@link #bank}.<br/>
   *
   * @param pBank Value to which {@link #bank} should be set.
   */
  public void setBank( BankBO pBank ) {
    // Release already referenced object before setting a new association.
    if (bank != null) {
      bank.removeFromAccounts((AccountBO) this);
    }
    bank = pBank;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBank != null && pBank.getAccounts().contains(this) == false) {
      pBank.addToAccounts((AccountBO) this);
    }
  }

  /**
   * Method unsets {@link #bank}.
   */
  public final void unsetBank( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BankBO lBankBO = bank;
    bank = null;
    if (lBankBO != null && lBankBO.getAccounts().contains(this) == true) {
      lBankBO.removeFromAccounts((AccountBO) this);
    }
  }

  /**
   * Method returns association {@link #customer}.<br/>
   *
   * @return {@link CustomerBO} Value to which {@link #customer} is set.
   */
  public CustomerBO getCustomer( ) {
    customer = this.unproxy(customer);
    return customer;
  }

  /**
   * Method sets association {@link #customer}.<br/>
   *
   * @param pCustomer Value to which {@link #customer} should be set.
   */
  public void setCustomer( CustomerBO pCustomer ) {
    // Release already referenced object before setting a new association.
    if (customer != null) {
      customer.removeFromAccounts((AccountBO) this);
    }
    customer = pCustomer;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCustomer != null && pCustomer.getAccounts().contains(this) == false) {
      pCustomer.addToAccounts((AccountBO) this);
    }
  }

  /**
   * Method unsets {@link #customer}.
   */
  public final void unsetCustomer( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    CustomerBO lCustomerBO = customer;
    customer = null;
    if (lCustomerBO != null && lCustomerBO.getAccounts().contains(this) == true) {
      lCustomerBO.removeFromAccounts((AccountBO) this);
    }
  }

  /**
   * Method returns association {@link #bookings}.<br/>
   *
   * @return {@link Set<BookingBO>} Value to which {@link #bookings} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<BookingBO> getBookings( ) {
    // Return all BookingBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookings);
  }

  /**
   * Method adds the passed object to {@link #bookings}.
   *
   * @param pBookings Object that should be added to {@link #bookings}. The parameter must not be null.
   */
  public void addToBookings( BookingBO pBookings ) {
    // Check parameter "pBookings" for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pBookings.unsetAccount();
    // Add passed object to collection of associated BookingBO objects.
    bookings.add(pBookings);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBookings != null && this.equals(pBookings.getAccount()) == false) {
      pBookings.setAccount((AccountBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #bookings}.
   *
   * @param pBookings Collection with all objects that should be added to {@link #bookings}. The parameter must not be
   * null.
   */
  public void addToBookings( Collection<BookingBO> pBookings ) {
    // Check parameter "pBookings" for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Add all passed objects.
    for (BookingBO lNextObject : pBookings) {
      this.addToBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bookings}.<br/>
   *
   * @param pBookings Object that should be removed from {@link #bookings}. The parameter must not be null.
   */
  public void removeFromBookings( BookingBO pBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBookings, "pBookings");
    // Remove passed object from collection of associated BookingBO objects.
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
    Collection<BookingBO> lBookings = new HashSet<BookingBO>(bookings);
    Iterator<BookingBO> lIterator = lBookings.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromBookings(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #authorizedPersons}.<br/>
   *
   * @return {@link Set<MyPersonBO>} Value to which {@link #authorizedPersons} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<MyPersonBO> getAuthorizedPersons( ) {
    // Return all MyPersonBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(authorizedPersons);
  }

  /**
   * Method adds the passed object to {@link #authorizedPersons}.
   *
   * @param pAuthorizedPersons Object that should be added to {@link #authorizedPersons}. The parameter must not be
   * null.
   */
  public void addToAuthorizedPersons( MyPersonBO pAuthorizedPersons ) {
    // Check parameter "pAuthorizedPersons" for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Add passed object to collection of associated MyPersonBO objects.
    authorizedPersons.add(pAuthorizedPersons);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAuthorizedPersons != null && pAuthorizedPersons.getAccounts().contains(this) == false) {
      pAuthorizedPersons.addToAccounts((AccountBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #authorizedPersons}.
   *
   * @param pAuthorizedPersons Collection with all objects that should be added to {@link #authorizedPersons}. The
   * parameter must not be null.
   */
  public void addToAuthorizedPersons( Collection<MyPersonBO> pAuthorizedPersons ) {
    // Check parameter "pAuthorizedPersons" for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Add all passed objects.
    for (MyPersonBO lNextObject : pAuthorizedPersons) {
      this.addToAuthorizedPersons(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #authorizedPersons}.<br/>
   *
   * @param pAuthorizedPersons Object that should be removed from {@link #authorizedPersons}. The parameter must not be
   * null.
   */
  public void removeFromAuthorizedPersons( MyPersonBO pAuthorizedPersons ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAuthorizedPersons, "pAuthorizedPersons");
    // Remove passed object from collection of associated MyPersonBO objects.
    authorizedPersons.remove(pAuthorizedPersons);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAuthorizedPersons.getAccounts().contains(this) == true) {
      pAuthorizedPersons.removeFromAccounts((AccountBO) this);
    }
  }

  /**
   * Method removes all objects from {@link #authorizedPersons}.
   */
  public void clearAuthorizedPersons( ) {
    // Remove all objects from association "authorizedPersons".
    Collection<MyPersonBO> lAuthorizedPersons = new HashSet<MyPersonBO>(authorizedPersons);
    Iterator<MyPersonBO> lIterator = lAuthorizedPersons.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAuthorizedPersons(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #interestRate}.<br/>
   *
   * @return {@link Float} Value to which {@link #interestRate} is set.
   */
  public Float getInterestRate( ) {
    return interestRate;
  }

  /**
   * Method sets attribute {@link #interestRate}.<br/>
   *
   * @param pInterestRate Value to which {@link #interestRate} should be set.
   */
  public void setInterestRate( Float pInterestRate ) {
    // Assign value to attribute
    interestRate = pInterestRate;
  }

  /**
   * Method calculates the current balance of the account. Therefore the the amount of every booking is accumulated.
   *
   * @return {@link BigDecimal}
   */
  public abstract BigDecimal calculateBalance( );

  /**
   * Method returns the class id of this business object class.
   *
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}