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
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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

  /**
   * 
   */
  @NotBlank
  private String name;

  /**
   * 
   */
  @NotBlank
  private String firstName;

  /**
   * 
   */
  @PastOrPresent
  private Calendar dateOfBirth;

  /**
   * 
   */
  private transient Set<Account> accounts = new HashSet<Account>();

  /**
   * 
   */
  @Valid
  private Individual customer;

  /**
   * 
   */
  @PositiveOrZero
  private Integer age;

  /**
   * 
   */
  @NotBlank
  private String displayName;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Person( ) {
    objectID = null;
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
    if (pBuilder.accounts != null) {
      accounts.addAll(pBuilder.accounts);
    }
    customer = pBuilder.customer;
    age = pBuilder.age;
    displayName = pBuilder.displayName;
  }

  /**
   * Class implements builder to create a new instance of class Person. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    /**
     * 
     */
    @NotBlank
    private String name;

    /**
     * 
     */
    @NotBlank
    private String firstName;

    /**
     * 
     */
    @PastOrPresent
    private Calendar dateOfBirth;

    /**
     * 
     */
    private Set<Account> accounts;

    /**
     * 
     */
    private Individual customer;

    /**
     * 
     */
    @PositiveOrZero
    private Integer age;

    /**
     * 
     */
    @NotBlank
    private String displayName;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Person)} instead of private constructor to create new builder.
     */
    protected Builder( Person pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        name = pObject.name;
        firstName = pObject.firstName;
        dateOfBirth = pObject.dateOfBirth;
        accounts = pObject.accounts;
        customer = pObject.customer;
        age = pObject.age;
        displayName = pObject.displayName;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Person objects. The method never returns null.
     */
    public static Builder newBuilder( Person pObject ) {
      return new Builder(pObject);
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
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "firstName".
     * 
     * @param pFirstName Value to which the attribute "firstName" should be set.
     */
    public Builder setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method sets the attribute "dateOfBirth".
     * 
     * @param pDateOfBirth Value to which the attribute "dateOfBirth" should be set.
     */
    public Builder setDateOfBirth( Calendar pDateOfBirth ) {
      // Assign value to attribute
      dateOfBirth = pDateOfBirth;
      return this;
    }

    /**
     * Method sets the association "accounts".
     * 
     * @param pAccounts Collection with objects to which the association should be set.
     */
    public Builder setAccounts( Set<Account> pAccounts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAccounts != null) {
        accounts = new HashSet<Account>(pAccounts);
      }
      else {
        accounts = null;
      }
      return this;
    }

    /**
     * Method sets the association "customer".
     * 
     * @param pCustomer Individual to which the association "customer" should be set.
     */
    public Builder setCustomer( Individual pCustomer ) {
      customer = pCustomer;
      return this;
    }

    /**
     * Method sets the attribute "age".
     * 
     * @param pAge Value to which the attribute "age" should be set.
     */
    public Builder setAge( Integer pAge ) {
      // Assign value to attribute
      age = pAge;
      return this;
    }

    /**
     * Method sets the attribute "displayName".
     * 
     * @param pDisplayName Value to which the attribute "displayName" should be set.
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
      return new Person(this);
    }

    /**
     * Method creates a new validated instance of class Person. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Person Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Person buildValidated( ) throws ConstraintViolationException {
      Person lPOJO = this.build();
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
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "firstName".
   * 
   * 
   * @return String Value to which the attribute "firstName" is set.
   */
  public String getFirstName( ) {
    return firstName;
  }

  /**
   * Method sets the attribute "firstName".
   * 
   * 
   * @param pFirstName Value to which the attribute "firstName" should be set.
   */
  public void setFirstName( String pFirstName ) {
    // Assign value to attribute
    firstName = pFirstName;
  }

  /**
   * Method returns the attribute "dateOfBirth".
   * 
   * 
   * @return Calendar Value to which the attribute "dateOfBirth" is set.
   */
  public Calendar getDateOfBirth( ) {
    return dateOfBirth;
  }

  /**
   * Method sets the attribute "dateOfBirth".
   * 
   * 
   * @param pDateOfBirth Value to which the attribute "dateOfBirth" should be set.
   */
  public void setDateOfBirth( Calendar pDateOfBirth ) {
    // Assign value to attribute
    dateOfBirth = pDateOfBirth;
  }

  /**
   * Method returns the association "accounts".
   * 
   *
   * @return Collection All Account objects that belong to the association "accounts". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Account> getAccounts( ) {
    // Return all Account objects as unmodifiable collection.
    return Collections.unmodifiableSet(accounts);
  }

  /**
   * Method sets the association "accounts" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pAccounts Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setAccounts( Set<Account> pAccounts ) {
    // Check of parameter is not required.
    // Remove all objects from association "accounts".
    this.clearAccounts();
    // If the association is null, removing all entries is sufficient.
    if (pAccounts != null) {
      accounts = new HashSet<Account>(pAccounts);
    }
  }

  /**
   * Method adds the passed Account object to the association "accounts".
   * 
   * 
   * @param pAccounts Object that should be added to the association "accounts". The parameter must not be null.
   */
  public void addToAccounts( Account pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Add passed object to collection of associated Account objects.
    accounts.add(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts != null && pAccounts.getAuthorizedPersons().contains(this) == false) {
      pAccounts.addToAuthorizedPersons((Person) this);
    }
  }

  /**
   * Method adds all passed objects to the association "accounts".
   * 
   * 
   * @param pAccounts Collection with all objects that should be added to the association "accounts". The parameter must
   * not be null.
   */
  public void addToAccounts( Collection<Account> pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Add all passed objects.
    for (Account lNextObject : pAccounts) {
      this.addToAccounts(lNextObject);
    }
  }

  /**
   * Method removes the passed Account object from the association "accounts".
   * 
   * 
   * @param pAccounts Object that should be removed from the association "accounts". The parameter must not be null.
   */
  public void removeFromAccounts( Account pAccounts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Remove passed object from collection of associated Account objects.
    accounts.remove(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts.getAuthorizedPersons().contains(this) == true) {
      pAccounts.removeFromAuthorizedPersons((Person) this);
    }
  }

  /**
   * Method removes all objects from the association "accounts".
   * 
   */
  public void clearAccounts( ) {
    // Remove all objects from association "accounts".
    Collection<Account> lAccounts = new HashSet<Account>(accounts);
    Iterator<Account> lIterator = lAccounts.iterator();
    while (lIterator.hasNext()) {
      this.removeFromAccounts(lIterator.next());
    }
  }

  /**
   * Method returns the association "customer".
   * 
   *
   * @return Individual Individual to which the association "customer" is set.
   */
  public Individual getCustomer( ) {
    return customer;
  }

  /**
   * Method sets the association "customer".
   * 
   * 
   * @param pCustomer Individual to which the association "customer" should be set.
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
   * Method unsets the association "customer".
   * 
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
   * Method returns the attribute "age".
   * 
   * 
   * @return Integer Value to which the attribute "age" is set.
   */
  public Integer getAge( ) {
    return age;
  }

  /**
   * Method sets the attribute "age".
   * 
   * 
   * @param pAge Value to which the attribute "age" should be set.
   */
  public void setAge( Integer pAge ) {
    // Assign value to attribute
    age = pAge;
  }

  /**
   * Method returns the attribute "displayName".
   * 
   * 
   * @return String Value to which the attribute "displayName" is set.
   */
  public String getDisplayName( ) {
    return displayName;
  }

  /**
   * Method sets the attribute "displayName".
   * 
   * 
   * @param pDisplayName Value to which the attribute "displayName" should be set.
   */
  public void setDisplayName( String pDisplayName ) {
    // Assign value to attribute
    displayName = pDisplayName;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "firstName", "" + firstName));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "dateOfBirth", "" + dateOfBirth));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "age", "" + age));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "displayName", "" + displayName));
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
