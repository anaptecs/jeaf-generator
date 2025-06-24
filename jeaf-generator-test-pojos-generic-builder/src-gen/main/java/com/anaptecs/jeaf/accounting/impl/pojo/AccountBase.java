/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.pojo;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = AccountBase.AccountBuilderImpl.class)
public abstract class AccountBase {
  /**
   * Constant for the name of attribute "iban".
   */
  public static final String IBAN = "iban";

  /**
   * Constant for the name of attribute "currency".
   */
  public static final String CURRENCY = "currency";

  private final int iban;

  private final Currency currency;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AccountBase( AccountBuilder<?, ?> pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    iban = pBuilder.iban;
    currency = pBuilder.currency;
  }

  /**
   * Class implements builder to create a new instance of class <code>Account</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class AccountBuilder<T extends Account, B extends AccountBuilder<T, B>> {
    private int iban;

    private Currency currency;

    /**
     * Use {@link AccountBuilder#builder()} instead of private constructor to create new builder.
     */
    protected AccountBuilder( ) {
    }

    /**
     * Use {@link AccountBuilder#builder(Account)} instead of private constructor to create new builder.
     */
    protected AccountBuilder( AccountBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setIban(pObject.iban);
        this.setCurrency(pObject.currency);
      }
    }

    /**
     * Method sets attribute {@link #iban}.<br/>
     *
     * @param pIban Value to which {@link #iban} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setIban( int pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this.self();
    }

    /**
     * Method sets attribute {@link #currency}.<br/>
     *
     * @param pCurrency Value to which {@link #currency} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setCurrency( Currency pCurrency ) {
      // Assign value to attribute
      currency = pCurrency;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Account. The object will be initialized with the values of the builder.
     *
     * @return Account Created object. The method never returns null.
     */
    public abstract T build( );

    /**
     * Method creates a new validated instance of class Account. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Account Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Account buildValidated( ) throws ConstraintViolationException {
      Account lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  static final class AccountBuilderImpl extends AccountBuilder<Account, AccountBuilderImpl> {
    protected AccountBuilderImpl( ) {
    }

    protected AccountBuilderImpl( Account pObject ) {
      super(pObject);
    }

    @Override
    protected AccountBuilderImpl self( ) {
      return this;
    }

    @Override
    public Account build( ) {
      return new Account(this);
    }
  }

  /**
   * Method returns attribute {@link #iban}.<br/>
   *
   * @return int Value to which {@link #iban} is set.
   */
  public int getIban( ) {
    return iban;
  }

  /**
   * Method returns attribute {@link #currency}.<br/>
   *
   * @return {@link Currency} Value to which {@link #currency} is set.
   */
  public Currency getCurrency( ) {
    return currency;
  }

  /**
   * Convenience method to create new instance of class Account.
   *
   *
   * @param pIban Value to which {@link #iban} should be set.
   *
   * @param pCurrency Value to which {@link #currency} should be set.
   *
   * @return {@link com.anaptecs.jeaf.accounting.impl.pojo.Account}
   */
  public static Account of( int pIban, Currency pCurrency ) {
    var lBuilder = Account.builder();
    lBuilder.setIban(pIban);
    lBuilder.setCurrency(pCurrency);
    return lBuilder.build();
  }

  /**
   * @return {@link BigDecimal}
   */
  public abstract BigDecimal calcuateBalance( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + iban;
    lResult = lPrime * lResult + Objects.hashCode(currency);
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
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      AccountBase lOther = (AccountBase) pObject;
      lEquals = iban == lOther.iban && Objects.equals(currency, lOther.currency);
    }
    return lEquals;
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
    lBuilder.append("iban: ");
    lBuilder.append(iban);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("currency: ");
    lBuilder.append(currency);
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
   * @return {@link Builder} New builder that can be used to create new Account objects. The method never returns null.
   */
  public AccountBuilder<?, ?> toBuilder( ) {
    return new AccountBuilderImpl((Account) this);
  }
}