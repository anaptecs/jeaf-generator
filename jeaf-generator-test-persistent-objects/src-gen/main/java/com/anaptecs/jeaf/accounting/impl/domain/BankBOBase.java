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

public abstract class BankBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1103, BankBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "BANK";

  /**
   * Constant for the name of the row that is used to store the values of attribute "name".
   */
  public static final String NAME_ROW = "NAME";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME_ATTRIBUTE = "name";

  /**
   * Constant for the name of the row that is used to store the values of attribute "code".
   */
  public static final String CODE_ROW = "CODE";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE_ATTRIBUTE = "code";

  /**
   * Constant for the name of the row that is used to store the values of attribute "type".
   */
  public static final String TYPE_ROW = "TYPE";

  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE_ATTRIBUTE = "type";

  /**
   * Constant for the name of role "employees".
   */
  public static final String EMPLOYEES_ROLE = "employees";

  /**
   * Constant for the name of role "accounts".
   */
  public static final String ACCOUNTS_ROLE = "accounts";

  /**
   * <br/>
   * <b>Default Value:</b> <code>1</code>
   */
  public static short MUTUAL_SAVINGS = 1;

  /**
   * <br/>
   * <b>Default Value:</b> <code>2</code>
   */
  public static short PRIVATE_BANK = 2;

  private Set<EmployeeBO> employees;

  private Set<AccountBO> accounts;

  private String name;

  private Long code;

  private Short type;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected BankBOBase( ) {
    employees = new HashSet<EmployeeBO>();
    accounts = new HashSet<AccountBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   *
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<BankBO> findAllBankBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(BankBO.class);
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
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
    pEmployees.unsetBank();
    // Add passed object to collection of associated EmployeeBO objects.
    employees.add(pEmployees);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pEmployees != null && this.equals(pEmployees.getBank()) == false) {
      pEmployees.setBank((BankBO) this);
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
    if (this.equals(pEmployees.getBank()) == true) {
      pEmployees.unsetBank();
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
    pAccounts.unsetBank();
    // Add passed object to collection of associated AccountBO objects.
    accounts.add(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts != null && this.equals(pAccounts.getBank()) == false) {
      pAccounts.setBank((BankBO) this);
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
    if (this.equals(pAccounts.getBank()) == true) {
      pAccounts.unsetBank();
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
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link Long} Value to which {@link #code} is set.
   */
  public Long getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( Long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns attribute {@link #type}.<br/>
   *
   * @return {@link Short} Value to which {@link #type} is set.
   */
  public Short getType( ) {
    return type;
  }

  /**
   * Method sets attribute {@link #type}.<br/>
   *
   * @param pType Value to which {@link #type} should be set.
   */
  public void setType( Short pType ) {
    // Assign value to attribute
    type = pType;
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