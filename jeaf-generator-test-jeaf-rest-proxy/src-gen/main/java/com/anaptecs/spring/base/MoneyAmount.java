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

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    amount = pBuilder.amount;
    currencyCode = pBuilder.currencyCode;
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(MoneyAmount)} instead of private constructor to create new builder.
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
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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

    /**
     * Method creates a new validated instance of class MoneyAmount. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return MoneyAmount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MoneyAmount buildValidated( ) throws ConstraintViolationException {
      MoneyAmount lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "amount", "" + amount));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "currencyCode", "" + currencyCode));
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