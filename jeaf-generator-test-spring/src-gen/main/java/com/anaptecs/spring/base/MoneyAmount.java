/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type represents an amount of money.<br/>
 * <br/>
 * NOVA 14 Mapping
 * </p>
 * <ul>
 * <li>nova-base.xsd.GeldBetrag</li>
 * </ul>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
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
   * Convenience method to create new instance of class MoneyAmount.
   *
   *
   * @param pAmount Value to which {@link #amount} should be set.
   *
   * @param pCurrencyCode Value to which {@link #currencyCode} should be set.
   *
   * @return {@link com.anaptecs.spring.base.MoneyAmount}
   */
  public static MoneyAmount of( BigDecimal pAmount, CurrencyCode pCurrencyCode ) {
    MoneyAmount.Builder lBuilder = MoneyAmount.builder();
    lBuilder.setAmount(pAmount);
    lBuilder.setCurrencyCode(pCurrencyCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MoneyAmount</code>.
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
        this.setAmount(pObject.amount);
        this.setCurrencyCode(pObject.currencyCode);
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
     * Method sets attribute {@link #amount}.<br/>
     *
     * @param pAmount Value to which {@link #amount} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAmount( @MyNotNullProperty BigDecimal pAmount ) {
      // Assign value to attribute
      amount = pAmount;
      return this;
    }

    /**
     * Method sets attribute {@link #currencyCode}.<br/>
     *
     * @param pCurrencyCode Value to which {@link #currencyCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCurrencyCode( @MyNotNullProperty CurrencyCode pCurrencyCode ) {
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
      MoneyAmount lObject = new MoneyAmount(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #amount}.<br/>
   * The amount of money. Attribute is always set.
   *
   * @return {@link BigDecimal} Value to which {@link #amount} is set.
   */
  @MyNotNullProperty
  public BigDecimal getAmount( ) {
    return amount;
  }

  /**
   * Method returns attribute {@link #currencyCode}.<br/>
   *
   * @return {@link CurrencyCode} Value to which {@link #currencyCode} is set.
   */
  @MyNotNullProperty
  public CurrencyCode getCurrencyCode( ) {
    return currencyCode;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(amount);
    lResult = lPrime * lResult + Objects.hashCode(currencyCode);
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
      MoneyAmount lOther = (MoneyAmount) pObject;
      lEquals = Objects.equals(amount, lOther.amount) && Objects.equals(currencyCode, lOther.currencyCode);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new MoneyAmount objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
