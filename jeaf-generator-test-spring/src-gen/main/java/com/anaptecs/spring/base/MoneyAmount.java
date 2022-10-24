/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type represents an amount of money.
 * 
 * NOVA 14 Mapping * nova-base.xsd.GeldBetrag
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyAmount {
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

  /**
   * 
   */
  @NotNull
  private final CurrencyCode currencyCode;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
   * Class implements builder to create a new instance of class MoneyAmount. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * The amount of money. Attribute is always set.
     */
    @NotNull
    private BigDecimal amount;

    /**
     * 
     */
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
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new MoneyAmount objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new MoneyAmount objects. The method never returns
     * null.
     */
    public static Builder newBuilder( MoneyAmount pObject ) {
      return new Builder(pObject);
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
  }

  /**
   * Method returns the attribute "amount". The amount of money. Attribute is always set.
   * 
   * @return BigDecimal Value to which the attribute "amount" is set.
   */
  public BigDecimal getAmount( ) {
    return amount;
  }

  /**
   * Method returns the attribute "currencyCode".
   * 
   * 
   * @return CurrencyCode Value to which the attribute "currencyCode" is set.
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
