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

public abstract class EmployeeBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1108, EmployeeBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "EMPLOYEEBO";

  /**
   * Constant for the name of role "bank".
   */
  public static final String BANK_ROLE = "bank";

  /**
   * Constant for the name of role "person".
   */
  public static final String PERSON_ROLE = "person";

  /**
   * Constant for the name of role "attendedCustomers".
   */
  public static final String ATTENDEDCUSTOMERS_ROLE = "attendedCustomers";

  /**
   * Constant for the name of role "superior".
   */
  public static final String SUPERIOR_ROLE = "superior";

  /**
   * Constant for the name of role "employees".
   */
  public static final String EMPLOYEES_ROLE = "employees";

  /**
   * Constant for the name of role "responsibility".
   */
  public static final String RESPONSIBILITY_ROLE = "responsibility";

  private BankBO bank;

  private MyPersonBO person;

  private Set<CustomerBO> attendedCustomers;

  private EmployeeBO superior;

  private Set<EmployeeBO> employees;

  private ResponsibilityTypeBO responsibility;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected EmployeeBOBase( ) {
    attendedCustomers = new HashSet<CustomerBO>();
    employees = new HashSet<EmployeeBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<EmployeeBO> findAllEmployeeBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(EmployeeBO.class);
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
      bank.removeFromEmployees((EmployeeBO) this);
    }
    bank = pBank;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBank != null && pBank.getEmployees().contains(this) == false) {
      pBank.addToEmployees((EmployeeBO) this);
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
    if (lBankBO != null && lBankBO.getEmployees().contains(this) == true) {
      lBankBO.removeFromEmployees((EmployeeBO) this);
    }
  }

  /**
   * Method returns association {@link #person}.<br/>
   *
   * @return {@link MyPersonBO} Value to which {@link #person} is set.
   */
  public MyPersonBO getPerson( ) {
    person = this.unproxy(person);
    return person;
  }

  /**
   * Method sets association {@link #person}.<br/>
   *
   * @param pPerson Value to which {@link #person} should be set.
   */
  public void setPerson( MyPersonBO pPerson ) {
    // Release already referenced object before setting a new association.
    if (person != null) {
      person.unsetEmployee();
    }
    person = pPerson;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pPerson != null && this.equals(pPerson.getEmployee()) == false) {
      pPerson.setEmployee((EmployeeBO) this);
    }
  }

  /**
   * Method unsets {@link #person}.
   */
  public final void unsetPerson( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    MyPersonBO lMyPersonBO = person;
    person = null;
    if (lMyPersonBO != null && this.equals(lMyPersonBO.getEmployee()) == true) {
      lMyPersonBO.unsetEmployee();
    }
  }

  /**
   * Method returns association {@link #attendedCustomers}.<br/>
   *
   * @return {@link Set<CustomerBO>} Value to which {@link #attendedCustomers} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<CustomerBO> getAttendedCustomers( ) {
    // Return all CustomerBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(attendedCustomers);
  }

  /**
   * Method adds the passed object to {@link #attendedCustomers}.
   *
   * @param pAttendedCustomers Object that should be added to {@link #attendedCustomers}. The parameter must not be
   * null.
   */
  public void addToAttendedCustomers( CustomerBO pAttendedCustomers ) {
    // Check parameter "pAttendedCustomers" for invalid value null.
    Check.checkInvalidParameterNull(pAttendedCustomers, "pAttendedCustomers");
    // Add passed object to collection of associated CustomerBO objects.
    attendedCustomers.add(pAttendedCustomers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAttendedCustomers != null && pAttendedCustomers.getAttendingEmployees().contains(this) == false) {
      pAttendedCustomers.addToAttendingEmployees((EmployeeBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #attendedCustomers}.
   *
   * @param pAttendedCustomers Collection with all objects that should be added to {@link #attendedCustomers}. The
   * parameter must not be null.
   */
  public void addToAttendedCustomers( Collection<CustomerBO> pAttendedCustomers ) {
    // Check parameter "pAttendedCustomers" for invalid value null.
    Check.checkInvalidParameterNull(pAttendedCustomers, "pAttendedCustomers");
    // Add all passed objects.
    for (CustomerBO lNextObject : pAttendedCustomers) {
      this.addToAttendedCustomers(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #attendedCustomers}.<br/>
   *
   * @param pAttendedCustomers Object that should be removed from {@link #attendedCustomers}. The parameter must not be
   * null.
   */
  public void removeFromAttendedCustomers( CustomerBO pAttendedCustomers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAttendedCustomers, "pAttendedCustomers");
    // Remove passed object from collection of associated CustomerBO objects.
    attendedCustomers.remove(pAttendedCustomers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAttendedCustomers.getAttendingEmployees().contains(this) == true) {
      pAttendedCustomers.removeFromAttendingEmployees((EmployeeBO) this);
    }
  }

  /**
   * Method removes all objects from {@link #attendedCustomers}.
   */
  public void clearAttendedCustomers( ) {
    // Remove all objects from association "attendedCustomers".
    Collection<CustomerBO> lAttendedCustomers = new HashSet<CustomerBO>(attendedCustomers);
    Iterator<CustomerBO> lIterator = lAttendedCustomers.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAttendedCustomers(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #superior}.<br/>
   *
   * @return {@link EmployeeBO} Value to which {@link #superior} is set.
   */
  public EmployeeBO getSuperior( ) {
    superior = this.unproxy(superior);
    return superior;
  }

  /**
   * Method sets association {@link #superior}.<br/>
   *
   * @param pSuperior Value to which {@link #superior} should be set.
   */
  public void setSuperior( EmployeeBO pSuperior ) {
    // Release already referenced object before setting a new association.
    if (superior != null) {
      superior.removeFromEmployees((EmployeeBO) this);
    }
    superior = pSuperior;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pSuperior != null && pSuperior.getEmployees().contains(this) == false) {
      pSuperior.addToEmployees((EmployeeBO) this);
    }
  }

  /**
   * Method unsets {@link #superior}.
   */
  public final void unsetSuperior( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    EmployeeBO lEmployeeBO = superior;
    superior = null;
    if (lEmployeeBO != null && lEmployeeBO.getEmployees().contains(this) == true) {
      lEmployeeBO.removeFromEmployees((EmployeeBO) this);
    }
  }

  /**
   * Method returns association {@link #employees}.<br/>
   *
   * @return {@link Set<EmployeeBO>} Value to which {@link #employees} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<EmployeeBO> getEmployees( ) {
    // Return all EmployeeBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(employees);
  }

  /**
   * Method adds the passed object to {@link #employees}.
   *
   * @param pEmployees Object that should be added to {@link #employees}. The parameter must not be null.
   */
  public void addToEmployees( EmployeeBO pEmployees ) {
    // Check parameter "pEmployees" for invalid value null.
    Check.checkInvalidParameterNull(pEmployees, "pEmployees");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pEmployees.unsetSuperior();
    // Add passed object to collection of associated EmployeeBO objects.
    employees.add(pEmployees);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pEmployees != null && this.equals(pEmployees.getSuperior()) == false) {
      pEmployees.setSuperior((EmployeeBO) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #employees}.
   *
   * @param pEmployees Collection with all objects that should be added to {@link #employees}. The parameter must not be
   * null.
   */
  public void addToEmployees( Collection<EmployeeBO> pEmployees ) {
    // Check parameter "pEmployees" for invalid value null.
    Check.checkInvalidParameterNull(pEmployees, "pEmployees");
    // Add all passed objects.
    for (EmployeeBO lNextObject : pEmployees) {
      this.addToEmployees(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #employees}.<br/>
   *
   * @param pEmployees Object that should be removed from {@link #employees}. The parameter must not be null.
   */
  public void removeFromEmployees( EmployeeBO pEmployees ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pEmployees, "pEmployees");
    // Remove passed object from collection of associated EmployeeBO objects.
    employees.remove(pEmployees);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pEmployees.getSuperior()) == true) {
      pEmployees.unsetSuperior();
    }
  }

  /**
   * Method removes all objects from {@link #employees}.
   */
  public void clearEmployees( ) {
    // Remove all objects from association "employees".
    Collection<EmployeeBO> lEmployees = new HashSet<EmployeeBO>(employees);
    Iterator<EmployeeBO> lIterator = lEmployees.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromEmployees(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #responsibility}.<br/>
   *
   * @return {@link ResponsibilityTypeBO} Value to which {@link #responsibility} is set.
   */
  public ResponsibilityTypeBO getResponsibility( ) {
    responsibility = this.unproxy(responsibility);
    return responsibility;
  }

  /**
   * Method sets association {@link #responsibility}.<br/>
   *
   * @param pResponsibility Value to which {@link #responsibility} should be set.
   */
  public void setResponsibility( ResponsibilityTypeBO pResponsibility ) {
    responsibility = pResponsibility;
  }

  /**
   * Method unsets {@link #responsibility}.
   */
  public final void unsetResponsibility( ) {
    responsibility = null;
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
