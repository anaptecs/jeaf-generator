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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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
@JsonDeserialize(builder = MoneyAmount.Builder.class)
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BigDecimal pAmount, CurrencyCode pCurrencyCode ) {
    Builder lBuilder = builder();
    lBuilder.setAmount(pAmount);
    lBuilder.setCurrencyCode(pCurrencyCode);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class MoneyAmount.
   *
   *
   * @param pAmount Value to which {@link #amount} should be set.
   *
   * @param pCurrencyCode Value to which {@link #currencyCode} should be set.
   *
   * @return {@link MoneyAmount}
   */
  public static MoneyAmount of( BigDecimal pAmount, CurrencyCode pCurrencyCode ) {
    var lBuilder = MoneyAmount.builder();
    lBuilder.setAmount(pAmount);
    lBuilder.setCurrencyCode(pCurrencyCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MoneyAmount</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
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
     * Method sets attribute {@link #amount}.<br/>
     *
     * @param pAmount Value to which {@link #amount} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAmount( BigDecimal pAmount ) {
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
      MoneyAmount lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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