/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class Person implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  /**
   * Constant for the name of attribute "dateOfBirth".
   */
  public static final String DATEOFBIRTH = "dateOfBirth";

  /**
   * Constant for the name of attribute "accounts".
   */
  public static final String ACCOUNTS = "accounts";

  /**
   * Constant for the name of attribute "customer".
   */
  public static final String CUSTOMER = "customer";

  /**
   * Constant for the name of attribute "age".
   */
  public static final String AGE = "age";

  /**
   * Constant for the name of attribute "displayName".
   */
  public static final String DISPLAYNAME = "displayName";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  @NotBlank
  private String name;

  @NotBlank
  private String firstName;

  @PastOrPresent
  private Calendar dateOfBirth;

  private transient Set<Account> accounts;

  @Valid
  private Individual customer;

  @PositiveOrZero
  private Integer age;

  @NotBlank
  private String displayName;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Person( ) {
    objectID = null;
    accounts = new HashSet<Account>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Person( Builder pBuilder ) {
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
    name = pBuilder.name;
    firstName = pBuilder.firstName;
    dateOfBirth = pBuilder.dateOfBirth;
    accounts = new HashSet<Account>();
    customer = pBuilder.customer;
    if (customer != null) {
      // As association is bidirectional we also have to set it in the other direction.
      customer.setPerson((Person) this);
    }
    age = pBuilder.age;
    displayName = pBuilder.displayName;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Person objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Person.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
   *
   * @param pAge Value to which {@link #age} should be set.
   *
   * @param pDisplayName Value to which {@link #displayName} should be set.
   *
   * @return {@link Person}
   */
  public static Person of( String pName, String pFirstName, Calendar pDateOfBirth, Integer pAge, String pDisplayName ) {
    Person.Builder lBuilder = Person.builder();
    lBuilder.setName(pName);
    lBuilder.setFirstName(pFirstName);
    lBuilder.setDateOfBirth(pDateOfBirth);
    lBuilder.setAge(pAge);
    lBuilder.setDisplayName(pDisplayName);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Person</code>.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @PastOrPresent
    private Calendar dateOfBirth;

    private Individual customer;

    @PositiveOrZero
    private Integer age;

    @NotBlank
    private String displayName;

    /**
     * Use {@link Person#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Person#builder(Person)} instead of private constructor to create new builder.
     */
    protected Builder( Person pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setName(pObject.name);
        this.setFirstName(pObject.firstName);
        this.setDateOfBirth(pObject.dateOfBirth);
        this.setCustomer(pObject.customer);
        this.setAge(pObject.age);
        this.setDisplayName(pObject.displayName);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method sets attribute {@link #dateOfBirth}.<br/>
     *
     * @param pDateOfBirth Value to which {@link #dateOfBirth} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDateOfBirth( Calendar pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    /**
     * Method sets association {@link #customer}.<br/>
     *
     * @param pCustomer Value to which {@link #customer} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCustomer( Individual pCustomer ) {
      customer = pCustomer;
      return this;
    }

    /**
     * Method sets attribute {@link #age}.<br/>
     *
     * @param pAge Value to which {@link #age} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAge( Integer pAge ) {
      // Assign value to attribute
      age = pAge;
      return this;
    }

    /**
     * Method sets attribute {@link #displayName}.<br/>
     *
     * @param pDisplayName Value to which {@link #displayName} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDisplayName( String pDisplayName ) {
      // Assign value to attribute
      displayName = pDisplayName;
      return this;
    }

    /**
     * Method creates a new instance of class Person. The object will be initialized with the values of the builder.
     *
     * @return Person Created object. The method never returns null.
     */
    public Person build( ) {
      Person lObject = new Person(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class Person. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Person Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Person buildValidated( ) throws ConstraintViolationException {
      Person lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
   * @return {@link Set<Account>} Value to which {@link #accounts} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Account> getAccounts( ) {
    // Return all Account objects as unmodifiable collection.
    return Collections.unmodifiableSet(accounts);
  }

  /**
   * Method adds the passed object to {@link #accounts}.
   *
   * @param pAccounts Object that should be added to {@link #accounts}. The parameter must not be null.
   */
  void addToAccounts( Account pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Add passed object to collection of associated Account objects.
    accounts.add(pAccounts);
  }

  /**
   * Method adds all passed objects to {@link #accounts}.
   *
   * @param pAccounts Collection with all objects that should be added to {@link #accounts}. The parameter must not be
   * null.
   */
  void addToAccounts( Collection<Account> pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Add all passed objects.
    for (Account lNextObject : pAccounts) {
      this.addToAccounts(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #accounts}.<br/>
   *
   * @param pAccounts Object that should be removed from {@link #accounts}. The parameter must not be null.
   */
  void removeFromAccounts( Account pAccounts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Remove passed object from collection of associated Account objects.
    accounts.remove(pAccounts);
  }

  /**
   * Method removes all objects from {@link #accounts}.
   */
  void clearAccounts( ) {
    // Remove all objects from association "accounts".
    Collection<Account> lAccounts = new HashSet<Account>(accounts);
    Iterator<Account> lIterator = lAccounts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAccounts(lIterator.next());
    }
  }

  /**
   * Method returns association {@link #customer}.<br/>
   *
   * @return {@link Individual} Value to which {@link #customer} is set.
   */
  public Individual getCustomer( ) {
    return customer;
  }

  /**
   * Method sets association {@link #customer}.<br/>
   *
   * @param pCustomer Value to which {@link #customer} should be set.
   */
  public void setCustomer( Individual pCustomer ) {
    // Release already referenced object before setting a new association.
    if (customer != null) {
      customer.unsetPerson();
    }
    customer = pCustomer;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pCustomer != null && this.equals(pCustomer.getPerson()) == false) {
      pCustomer.setPerson((Person) this);
    }
  }

  /**
   * Method unsets {@link #customer}.
   */
  public final void unsetCustomer( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    Individual lIndividual = customer;
    customer = null;
    if (lIndividual != null && this.equals(lIndividual.getPerson()) == true) {
      lIndividual.unsetPerson();
    }
  }

  /**
   * Method returns attribute {@link #age}.<br/>
   *
   * @return {@link Integer} Value to which {@link #age} is set.
   */
  public Integer getAge( ) {
    return age;
  }

  /**
   * Method sets attribute {@link #age}.<br/>
   *
   * @param pAge Value to which {@link #age} should be set.
   */
  public void setAge( Integer pAge ) {
    // Assign value to attribute
    age = pAge;
  }

  /**
   * Method returns attribute {@link #displayName}.<br/>
   *
   * @return {@link String} Value to which {@link #displayName} is set.
   */
  public String getDisplayName( ) {
    return displayName;
  }

  /**
   * Method sets attribute {@link #displayName}.<br/>
   *
   * @param pDisplayName Value to which {@link #displayName} should be set.
   */
  public void setDisplayName( String pDisplayName ) {
    // Assign value to attribute
    displayName = pDisplayName;
  }

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
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("firstName: ");
    lBuilder.append(firstName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dateOfBirth: ");
    lBuilder.append(dateOfBirth);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("age: ");
    lBuilder.append(age);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("displayName: ");
    lBuilder.append(displayName);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Person objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}