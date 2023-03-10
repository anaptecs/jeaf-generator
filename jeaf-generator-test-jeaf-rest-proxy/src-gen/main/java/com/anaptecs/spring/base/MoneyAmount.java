/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type represents an amount of money.<br/>
 * <br/>
 * NOVA 14 Mapping<br/>
 * * nova-base.xsd.GeldBetrag
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyAmount implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT = "amount";

  /**
   * Constant for the name of attribute "currencyCode".
   */
  public static final String CURRENCYCODE = "currencyCode";

  /**
   * The amount of money. Attribute is always set.
   */
  @NotNull
  private final BigDecimal amount;

  @NotNull
  private final CurrencyCode currencyCode;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected MoneyAmount( ) {
    amount = null;
    currencyCode = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MoneyAmount( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    amount = pBuilder.amount;
    currencyCode = pBuilder.currencyCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new MoneyAmount objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MoneyAmount objects. The method never returns
   * null.
   */
  public static Builder builder( MoneyAmount pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BigDecimal pAmount, CurrencyCode pCurrencyCode ) {
    Builder lBuilder = builder();
    lBuilder.setAmount(pAmount);
    lBuilder.setCurrencyCode(pCurrencyCode);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class MoneyAmount. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * The amount of money. Attribute is always set.
     */
    @NotNull
    private BigDecimal amount;

    @NotNull
    private CurrencyCode currencyCode;

    /**
     * Use {@link MoneyAmount#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MoneyAmount#builder(MoneyAmount)} instead of private constructor to create new builder.
     */
    protected Builder( MoneyAmount pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        amount = pObject.amount;
        currencyCode = pObject.currencyCode;
      }
    }

    /**
     * Method sets the attribute "amount". The amount of money. Attribute is always set.
     * 
     * @param pAmount Value to which the attribute "amount" should be set.
     */
    public Builder setAmount( BigDecimal pAmount ) {
      // Assign value to attribute
      amount = pAmount;
      return this;
    }

    /**
     * Method sets the attribute "currencyCode".
     * 
     * @param pCurrencyCode Value to which the attribute "currencyCode" should be set.
     */
    public Builder setCurrencyCode( CurrencyCode pCurrencyCode ) {
      // Assign value to attribute
      currencyCode = pCurrencyCode;
      return this;
    }

    /**
     * Method creates a new instance of class MoneyAmount. The object will be initialized with the values of the
     * builder.
     * 
     * @return MoneyAmount Created object. The method never returns null.
     */
    public MoneyAmount build( ) {
      return new MoneyAmount(this);
    }

    /**
     * Method creates a new validated instance of class MoneyAmount. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return MoneyAmount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MoneyAmount buildValidated( ) throws ConstraintViolationException {
      MoneyAmount lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #amount}.<br/>
   * The amount of money. Attribute is always set.
   * 
   * @return {@link BigDecimal} Value to which {@link #amount} is set.
   */
  public BigDecimal getAmount( ) {
    return amount;
  }

  /**
   * Method returns attribute {@link #currencyCode}.<br/>
   * 
   * @return {@link CurrencyCode} Value to which {@link #currencyCode} is set.
   */
  public CurrencyCode getCurrencyCode( ) {
    return currencyCode;
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
    lBuilder.append("amount: ");
    lBuilder.append(amount);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("currencyCode: ");
    lBuilder.append(currencyCode);
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
