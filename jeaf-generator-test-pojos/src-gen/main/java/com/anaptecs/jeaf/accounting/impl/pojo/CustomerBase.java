/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CustomerBase extends Partner {
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

  @NotBlank
  private String name;

  @NotBlank
  private String firstName;

  @Email()
  private String email;

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<Account> accounts;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected CustomerBase( ) {
    accounts = new HashSet<Account>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CustomerBase( BuilderBase pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    name = pBuilder.name;
    firstName = pBuilder.firstName;
    email = pBuilder.email;
    if (pBuilder.accounts != null) {
      accounts = pBuilder.accounts;
      // As association is bidirectional we also have to set it in the other direction.
      for (Account lNext : accounts) {
        lNext.setOwner((Customer) this);
      }
    }
    else {
      accounts = new HashSet<Account>();
    }
  }

  /**
   * Class implements builder to create a new instance of class Customer. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase extends Partner.Builder {
    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @Email()
    private String email;

    private Set<Account> accounts;

    /**
     * Use {@link Customer.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link Customer.builder(Customer)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( CustomerBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setName(pObject.name);
        this.setFirstName(pObject.firstName);
        this.setEmail(pObject.email);
        this.setAccounts(pObject.accounts);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this;
    }

    /**
     * Method sets attribute {@link #email}.<br/>
     *
     * @param pEmail Value to which {@link #email} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setEmail( String pEmail ) {
      // Assign value to attribute
      email = pEmail;
      return this;
    }

    /**
     * Method sets association {@link #accounts}.<br/>
     *
     * @param pAccounts Collection to which {@link #accounts} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #accounts}.<br/>
     *
     * @param pAccounts Array of objects that should be added to {@link #accounts}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToAccounts( Account... pAccounts ) {
      if (pAccounts != null) {
        if (accounts == null) {
          accounts = new HashSet<Account>();
        }
        accounts.addAll(Arrays.asList(pAccounts));
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
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
   * Method returns attribute {@link #email}.<br/>
   *
   * @return {@link String} Value to which {@link #email} is set.
   */
  public String getEmail( ) {
    return email;
  }

  /**
   * Method sets attribute {@link #email}.<br/>
   *
   * @param pEmail Value to which {@link #email} should be set.
   */
  public void setEmail( String pEmail ) {
    // Assign value to attribute
    email = pEmail;
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
  public void addToAccounts( Account pAccounts ) {
    // Check parameter "pAccounts" for invalid value null.
    Check.checkInvalidParameterNull(pAccounts, "pAccounts");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to be
    // released.
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
   * Method adds all passed objects to {@link #accounts}.
   *
   * @param pAccounts Collection with all objects that should be added to {@link #accounts}. The parameter must not be
   * null.
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
   * Method removes the passed object from {@link #accounts}.<br/>
   *
   * @param pAccounts Object that should be removed from {@link #accounts}. The parameter must not be null.
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
   * Method removes all objects from {@link #accounts}.
   */
  public void clearAccounts( ) {
    // Remove all objects from association "accounts".
    Collection<Account> lAccounts = new HashSet<Account>(accounts);
    Iterator<Account> lIterator = lAccounts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAccounts(lIterator.next());
    }
  }

  /**
   * Convenience method to create new instance of class Customer.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @param pEmail Value to which {@link #email} should be set.
   *
   * @return {@link Customer}
   */
  public static Customer of( String pName, String pFirstName, String pEmail ) {
    Customer.Builder lBuilder = Customer.builder();
    lBuilder.setName(pName);
    lBuilder.setFirstName(pFirstName);
    lBuilder.setEmail(pEmail);
    return lBuilder.build();
  }

  /**
   * @return {@link String}
   */
  public abstract String getDisplayName( );

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("name: ");
    lBuilder.append(name);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("firstName: ");
    lBuilder.append(firstName);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("email: ");
    lBuilder.append(email);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("accounts: ");
    if (accounts != null) {
      lBuilder.append(accounts.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (accounts != null) {
      for (Account lNext : accounts) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new Customer objects. The method never returns null.
   */
  public Customer.Builder toBuilder( ) {
    return new Customer.Builder((Customer) this);
  }
}
