package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class CustomerBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1104, CustomerBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "CUSTOMERBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "active".
   */
  public static final String ACTIVE_ROW = "ACTIVE";

  /**
   * Constant for the name of attribute "active".
   */
  public static final String ACTIVE_ATTRIBUTE = "active";

  /**
   * Constant for the name of role "accounts".
   */
  public static final String ACCOUNTS_ROLE = "accounts";

  /**
   * Constant for the name of role "attendingEmployees".
   */
  public static final String ATTENDINGEMPLOYEES_ROLE = "attendingEmployees";

  /**
   * Constant for the name of role "adress".
   */
  public static final String ADRESS_ROLE = "adress";

  private Set<AccountBO> accounts;

  private Set<EmployeeBO> attendingEmployees;

  private Boolean active;

  private MyAddressBO adress;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected CustomerBOBase( ) {
    accounts = new HashSet<AccountBO>();
    attendingEmployees = new HashSet<EmployeeBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<CustomerBO> findAllCustomerBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(CustomerBO.class);
  }

  /**
   * Method returns association {@link #accounts}.<br/>
   *
   * @return {@link Set<AccountBO>} Value to which {@link #accounts} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<AccountBO> getAccounts( ) {
    // Return all AccountBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(accounts);
  }

  /**
   * Method adds the passed object to {@link #accounts}.
   *
   * @param pAccounts Object that should be added to {@link #accounts}. The parameter must not be null.
   */
  public void addToAccounts( AccountBO pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pAccounts.unsetCustomer();
    // Add passed object to collection of associated AccountBO objects.
    accounts.add(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts != null && this.equals(pAccounts.getCustomer()) == false) {
      pAccounts.setCustomer((CustomerBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #accounts}.
   *
   * @param pAccounts Collection with all objects that should be added to {@link #accounts}. The parameter must not be
   * null.
   */
  public void addToAccounts( Collection<AccountBO> pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Add all passed objects.
    for (AccountBO lNextObject : pAccounts) {
      this.addToAccounts(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #accounts}.<br/>
   *
   * @param pAccounts Object that should be removed from {@link #accounts}. The parameter must not be null.
   */
  public void removeFromAccounts( AccountBO pAccounts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Remove passed object from collection of associated AccountBO objects.
    accounts.remove(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pAccounts.getCustomer()) == true) {
      pAccounts.unsetCustomer();
    }
  }

  /**
   * Method removes all objects from {@link #accounts}.
   */
  public void clearAccounts( ) {
    // Remove all objects from association "accounts".
    Collection<AccountBO> lAccounts = new HashSet<AccountBO>(accounts);
    Iterator<AccountBO> lIterator = lAccounts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAccounts(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #attendingEmployees}.<br/>
   *
   * @return {@link Set<EmployeeBO>} Value to which {@link #attendingEmployees} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<EmployeeBO> getAttendingEmployees( ) {
    // Return all EmployeeBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(attendingEmployees);
  }

  /**
   * Method adds the passed object to {@link #attendingEmployees}.
   *
   * @param pAttendingEmployees Object that should be added to {@link #attendingEmployees}. The parameter must not be
   * null.
   */
  public void addToAttendingEmployees( EmployeeBO pAttendingEmployees ) {
    // Check parameter "pAttendingEmployees" for invalid value null.
    Check.checkInvalidParameterNull(pAttendingEmployees, "pAttendingEmployees");
    // Add passed object to collection of associated EmployeeBO objects.
    attendingEmployees.add(pAttendingEmployees);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAttendingEmployees != null && pAttendingEmployees.getAttendedCustomers().contains(this) == false) {
      pAttendingEmployees.addToAttendedCustomers((CustomerBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #attendingEmployees}.
   *
   * @param pAttendingEmployees Collection with all objects that should be added to {@link #attendingEmployees}. The
   * parameter must not be null.
   */
  public void addToAttendingEmployees( Collection<EmployeeBO> pAttendingEmployees ) {
    // Check parameter "pAttendingEmployees" for invalid value null.
    Check.checkInvalidParameterNull(pAttendingEmployees, "pAttendingEmployees");
    // Add all passed objects.
    for (EmployeeBO lNextObject : pAttendingEmployees) {
      this.addToAttendingEmployees(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #attendingEmployees}.<br/>
   *
   * @param pAttendingEmployees Object that should be removed from {@link #attendingEmployees}. The parameter must not
   * be null.
   */
  public void removeFromAttendingEmployees( EmployeeBO pAttendingEmployees ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAttendingEmployees, "pAttendingEmployees");
    // Remove passed object from collection of associated EmployeeBO objects.
    attendingEmployees.remove(pAttendingEmployees);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAttendingEmployees.getAttendedCustomers().contains(this) == true) {
      pAttendingEmployees.removeFromAttendedCustomers((CustomerBO) this);
    }
  }

  /**
   * Method removes all objects from {@link #attendingEmployees}.
   */
  public void clearAttendingEmployees( ) {
    // Remove all objects from association "attendingEmployees".
    Collection<EmployeeBO> lAttendingEmployees = new HashSet<EmployeeBO>(attendingEmployees);
    Iterator<EmployeeBO> lIterator = lAttendingEmployees.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAttendingEmployees(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #active}.<br/>
   *
   * @return {@link Boolean} Value to which {@link #active} is set.
   */
  public Boolean getActive( ) {
    return active;
  }

  /**
   * Method sets attribute {@link #active}.<br/>
   *
   * @param pActive Value to which {@link #active} should be set.
   */
  public void setActive( Boolean pActive ) {
    // Assign value to attribute
    active = pActive;
  }

  /**
   * Method returns association {@link #adress}.<br/>
   *
   * @return {@link MyAddressBO} Value to which {@link #adress} is set.
   */
  public MyAddressBO getAdress( ) {
    adress = this.unproxy(adress);
    return adress;
  }

  /**
   * Method sets association {@link #adress}.<br/>
   *
   * @param pAdress Value to which {@link #adress} should be set.
   */
  public void setAdress( MyAddressBO pAdress ) {
    adress = pAdress;
  }

  /**
   * Method unsets {@link #adress}.
   */
  public final void unsetAdress( ) {
    adress = null;
  }

  /**
   * Method returns the class id of this business object class.
   *
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}