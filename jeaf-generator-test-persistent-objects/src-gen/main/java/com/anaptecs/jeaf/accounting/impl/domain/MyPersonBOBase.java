package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class MyPersonBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1107, MyPersonBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "SAMPLE_PERSON";

  /**
   * Constant for the name of the row that is used to store the values of attribute "name".
   */
  public static final String NAME_ROW = "NAME";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME_ATTRIBUTE = "name";

  /**
   * Constant for the name of the row that is used to store the values of attribute "firstName".
   */
  public static final String FIRSTNAME_ROW = "FIRSTNAME";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME_ATTRIBUTE = "firstName";

  /**
   * Constant for the name of the row that is used to store the values of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH_ROW = "DATEOFBIRTH";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH_ATTRIBUTE = "dateOfBirth";

  /**
   * Constant for the name of role "accounts".
   */
  public static final String ACCOUNTS_ROLE = "accounts";

  /**
   * Constant for the name of role "employee".
   */
  public static final String EMPLOYEE_ROLE = "employee";

  /**
   * Constant for the name of role "customer".
   */
  public static final String CUSTOMER_ROLE = "customer";

  private String name;

  private String firstName;

  private Calendar dateOfBirth;

  private Set<AccountBO> accounts;

  private EmployeeBO employee;

  private IndividualBO customer;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected MyPersonBOBase( ) {
    accounts = new HashSet<AccountBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<MyPersonBO> findAllMyPersonBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(MyPersonBO.class);
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
   * Method sets attribute {@link #name}.<br/>
   *
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets attribute {@link #firstName}.<br/>
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   */
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * Method returns attribute {@link #dateOfBirth}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #dateOfBirth} is set.
   */
  public Calendar getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets attribute {@link #dateOfBirth}.<br/>
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   */
  public void setDateOfBirth( Calendar pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
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
    // Add passed object to collection of associated AccountBO objects.
    accounts.add(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts != null && pAccounts.getAuthorizedPersons().contains(this) == false) {
      pAccounts.addToAuthorizedPersons((MyPersonBO) this);
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
    if (pAccounts.getAuthorizedPersons().contains(this) == true) {
      pAccounts.removeFromAuthorizedPersons((MyPersonBO) this);
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
   * Method returns association {@link #employee}.<br/>
   *
   * @return {@link EmployeeBO} Value to which {@link #employee} is set.
   */
  public EmployeeBO getEmployee( ) {
    employee = this.unproxy(employee);
    return employee;
  }

  /**
   * Method sets association {@link #employee}.<br/>
   *
   * @param pEmployee Value to which {@link #employee} should be set.
   */
  public void setEmployee( EmployeeBO pEmployee ) {
    // Release already referenced object before setting a new association.
    if (employee != null) {
      employee.unsetPerson();
    }
    employee = pEmployee;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pEmployee != null && this.equals(pEmployee.getPerson()) == false) {
      pEmployee.setPerson((MyPersonBO) this);
    }
  }

  /**
   * Method unsets {@link #employee}.
   */
  public final void unsetEmployee( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    EmployeeBO lEmployeeBO = employee;
    employee = null;
    if (lEmployeeBO != null && this.equals(lEmployeeBO.getPerson()) == true) {
      lEmployeeBO.unsetPerson();
    }
  }

  /**
   * Method returns association {@link #customer}.<br/>
   *
   * @return {@link IndividualBO} Value to which {@link #customer} is set.
   */
  public IndividualBO getCustomer( ) {
    customer = this.unproxy(customer);
    return customer;
  }

  /**
   * Method sets association {@link #customer}.<br/>
   *
   * @param pCustomer Value to which {@link #customer} should be set.
   */
  public void setCustomer( IndividualBO pCustomer ) {
    // Release already referenced object before setting a new association.
    if (customer != null) {
      customer.unsetPerson();
    }
    customer = pCustomer;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCustomer != null && this.equals(pCustomer.getPerson()) == false) {
      pCustomer.setPerson((MyPersonBO) this);
    }
  }

  /**
   * Method unsets {@link #customer}.
   */
  public final void unsetCustomer( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    IndividualBO lIndividualBO = customer;
    customer = null;
    if (lIndividualBO != null && this.equals(lIndividualBO.getPerson()) == true) {
      lIndividualBO.unsetPerson();
    }
  }

  /**
   * @return {@link Integer}
   */
  public abstract Integer calculateAge( );

  /**
   * @return {@link String}
   */
  @NotNull
  public abstract String getFullName( );

  /**
   * Method returns the class id of this business object class.
   *
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}