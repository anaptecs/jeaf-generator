/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class BankAccount implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private String iban;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BankAccount( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BankAccount( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    iban = pBuilder.iban;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BankAccount objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new BankAccount objects. The method never returns
   * null.
   */
  public static Builder builder( BankAccount pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class BankAccount.
   *
   *
   * @param pIban Value to which {@link #iban} should be set.
   *
   * @return {@link BankAccount}
   */
  public static BankAccount of( String pIban ) {
    BankAccount.Builder lBuilder = BankAccount.builder();
    lBuilder.setIban(pIban);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BankAccount</code>.
   */
  public static class Builder {
    private String iban;

    /**
     * Use {@link BankAccount#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BankAccount#builder(BankAccount)} instead of private constructor to create new builder.
     */
    protected Builder( BankAccount pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        iban = pObject.iban;
      }
    }

    /**
     * Method sets attribute {@link #iban}.<br/>
     *
     * @param pIban Value to which {@link #iban} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIban( String pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method creates a new instance of class BankAccount. The object will be initialized with the values of the
     * builder.
     *
     * @return BankAccount Created object. The method never returns null.
     */
    public BankAccount build( ) {
      return new BankAccount(this);
    }

    /**
     * Method creates a new validated instance of class BankAccount. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return BankAccount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BankAccount buildValidated( ) throws ConstraintViolationException {
      BankAccount lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #iban}.<br/>
   *
   * @return {@link String} Value to which {@link #iban} is set.
   */
  public String getIban( ) {
    return iban;
  }

  /**
   * Method sets attribute {@link #iban}.<br/>
   *
   * @param pIban Value to which {@link #iban} should be set.
   */
  public void setIban( String pIban ) {
    // Assign value to attribute
    iban = pIban;
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
}
