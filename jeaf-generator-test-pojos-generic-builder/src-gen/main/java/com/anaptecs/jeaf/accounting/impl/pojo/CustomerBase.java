/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = CustomerBase.CustomerBuilderImpl.class)
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
  private final String name;

  @NotBlank
  private final String firstName;

  @Email()
  private final String email;

  private final Set<Account> accounts;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected CustomerBase( CustomerBuilderBase<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    name = pBuilder.name;
    firstName = pBuilder.firstName;
    email = pBuilder.email;
    if (pBuilder.accounts != null) {
      accounts = pBuilder.accounts;
    }
    else {
      accounts = new HashSet<>();
    }
  }

  /**
   * Class implements builder to create a new instance of class <code>Customer</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class CustomerBuilderBase<T extends Customer, B extends CustomerBuilderBase<T, B>>
      extends PartnerBuilder<T, B> {
    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @Email()
    private String email;

    private Set<Account> accounts;

    /**
     * Use {@link Customer#builder()} instead of private constructor to create new builder.
     */
    protected CustomerBuilderBase( ) {
      super();
    }

    /**
     * Use {@link Customer#builder(Customer)} instead of private constructor to create new builder.
     */
    protected CustomerBuilderBase( CustomerBase pObject ) {
      super(pObject);
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this.self();
    }

    /**
     * Method sets attribute {@link #firstName}.<br/>
     *
     * @param pFirstName Value to which {@link #firstName} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setFirstName( String pFirstName ) {
      // Assign value to attribute
      firstName = pFirstName;
      return this.self();
    }

    /**
     * Method sets attribute {@link #email}.<br/>
     *
     * @param pEmail Value to which {@link #email} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setEmail( String pEmail ) {
      // Assign value to attribute
      email = pEmail;
      return this.self();
    }

    /**
     * Method sets association {@link #accounts}.<br/>
     *
     * @param pAccounts Collection to which {@link #accounts} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAccounts( Set<Account> pAccounts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAccounts != null) {
        accounts = new HashSet<Account>(pAccounts);
      }
      else {
        accounts = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #accounts}.<br/>
     *
     * @param pAccounts Array of objects that should be added to {@link #accounts}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToAccounts( Account... pAccounts ) {
      if (pAccounts != null) {
        if (accounts == null) {
          accounts = new HashSet<Account>();
        }
        accounts.addAll(Arrays.asList(pAccounts));
      }
      return this.self();
    }

    /**
     * Method creates a new instance of class Customer. The object will be initialized with the values of the builder.
     *
     * @return Customer Created object. The method never returns null.
     */
    public T build( ) {
      // Method already has an implementation as otherwise it would not be possible to overwrite it in custom builder
      // implementation. Unfortunately this is a limitation of abstract static inner classes that are used to implement
      // generic builder pattern.
      throw new UnsupportedOperationException("This operation has to be overwritten by subclasses.");
    }

    /**
     * Method creates a new validated instance of class Customer. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Customer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Customer buildValidated( ) throws ConstraintViolationException {
      Customer lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class CustomerBuilderImpl extends Customer.CustomerBuilder<Customer, CustomerBuilderImpl> {
    protected CustomerBuilderImpl( ) {
    }

    protected CustomerBuilderImpl( Customer pObject ) {
      super(pObject);
    }

    @Override
    protected CustomerBuilderImpl self( ) {
      return this;
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
   * Method returns attribute {@link #firstName}.<br/>
   *
   * @return {@link String} Value to which {@link #firstName} is set.
   */
  public String getFirstName( ) {
    return firstName;
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
   * Convenience method to create new instance of class Customer.
   *
   *
   * @param pTags Value to which {@link #tags} should be set.
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pFirstName Value to which {@link #firstName} should be set.
   *
   * @param pEmail Value to which {@link #email} should be set.
   *
   * @return {@link Customer}
   */
  public static Customer of( String pTags, String pName, String pFirstName, String pEmail ) {
    var lBuilder = Customer.builder();
    lBuilder.setTags(pTags);
    lBuilder.setName(pName);
    lBuilder.setFirstName(pFirstName);
    lBuilder.setEmail(pEmail);
    return lBuilder.build();
  }

  /**
   * @return {@link String}
   */
  public abstract String getDisplayName( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(name);
    lResult = lPrime * lResult + Objects.hashCode(firstName);
    lResult = lPrime * lResult + Objects.hashCode(email);
    lResult = lPrime * lResult + Objects.hashCode(accounts);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      CustomerBase lOther = (CustomerBase) pObject;
      lEquals = Objects.equals(name, lOther.name) && Objects.equals(firstName, lOther.firstName)
          && Objects.equals(email, lOther.email) && Objects.equals(accounts, lOther.accounts);
    }
    return lEquals;
  }

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
   * @return {@link CustomerBuilder} New builder that can be used to create new Customer objects. The method never
   * returns null.
   */
  public Customer.CustomerBuilder<?, ?> toBuilder( ) {
    return new CustomerBuilderImpl((Customer) this);
  }
}