/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public abstract class CustomerBase {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "firstName".
   */
  public static final String FIRSTNAME = "firstName";

  /**
   * Constant for the name of attribute "email".
   */
  public static final String EMAIL = "email";

  /**
   * Constant for the name of attribute "accounts".
   */
  public static final String ACCOUNTS = "accounts";

  /**
   * 
   */
  @NotBlank()
  private String name;

  /**
   * 
   */
  @NotBlank()
  private String firstName;

  /**
   * 
   */
  @Email()
  private String email;

  /**
   * 
   */
  private Set<Account> accounts = new HashSet<Account>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected CustomerBase( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CustomerBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    firstName = pBuilder.firstName;
    email = pBuilder.email;
    if (pBuilder.accounts != null) {
      accounts.addAll(pBuilder.accounts);
    }
  }

  /**
   * Class implements builder to create a new instance of class Customer. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * 
     */
    @NotBlank()
    private String name;

    /**
     * 
     */
    @NotBlank()
    private String firstName;

    /**
     * 
     */
    @Email()
    private String email;

    /**
     * 
     */
    private Set<Account> accounts;

    /**
     * Use {@link Customer.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Customer.Builder#newBuilder(Customer)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( CustomerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        firstName = pObject.firstName;
        email = pObject.email;
        accounts = pObject.accounts;
      }
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "firstName".
     * 
     * @param pFirstName Value to which the attribute "firstName" should be set.
     */
    public BuilderBase setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method sets the attribute "email".
     * 
     * @param pEmail Value to which the attribute "email" should be set.
     */
    public BuilderBase setEmail( String pEmail ) {
      // Assign value to attribute
      email = pEmail;
      return this;
    }

    /**
     * Method sets the association "accounts".
     * 
     * @param pAccounts Collection with objects to which the association should be set.
     */
    public BuilderBase setAccounts( Set<Account> pAccounts ) {
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
     * Method creates a new instance of class Customer. The object will be initialized with the values of the builder.
     * 
     * @return Customer Created object. The method never returns null.
     */
    public Customer build( ) {
      return new Customer(this);
    }

    /**
     * Method creates a new validated instance of class Customer. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Customer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Customer buildValidated( ) throws ConstraintViolationException {
      Customer lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
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
   * Method returns the attribute "email".
   * 
   * 
   * @return String Value to which the attribute "email" is set.
   */
  public String getEmail( ) {
    return email;
  }

  /**
   * Method sets the attribute "email".
   * 
   * 
   * @param pEmail Value to which the attribute "email" should be set.
   */
  public void setEmail( String pEmail ) {
    // Assign value to attribute
    email = pEmail;
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
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pAccounts.unsetOwner();
    // Add passed object to collection of associated Account objects.
    accounts.add(pAccounts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccounts != null && this.equals(pAccounts.getOwner()) == false) {
      pAccounts.setOwner((Customer) this);
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
    if (this.equals(pAccounts.getOwner()) == true) {
      pAccounts.unsetOwner();
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
   * 
   * @return {@link String}
   */
  public abstract String getDisplayName( );

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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "email", "" + email));
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
