/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.product.domain;

import java.math.BigDecimal;
import java.util.Currency;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PriceDO extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT = "amount";

  /**
   * Constant for the name of attribute "currency".
   */
  public static final String CURRENCY = "currency";

  /**
   * 
   */
  private BigDecimal amount;

  /**
   * 
   */
  private Currency currency;

  /**
   * Initialize object. Nothing special to do.
   */
  public PriceDO( ) {
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public PriceDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * Method returns the attribute "amount".
   * 
   * 
   * @return BigDecimal Value to which the attribute "amount" is set.
   */
  public BigDecimal getAmount( ) {
    return amount;
  }

  /**
   * Method sets the attribute "amount".
   * 
   * 
   * @param pAmount Value to which the attribute "amount" should be set.
   */
  public void setAmount( BigDecimal pAmount ) {
    // Assign value to attribute
    amount = pAmount;
  }

  /**
   * Method returns the attribute "currency".
   * 
   * 
   * @return Currency Value to which the attribute "currency" is set.
   */
  public Currency getCurrency( ) {
    return currency;
  }

  /**
   * Method sets the attribute "currency".
   * 
   * 
   * @param pCurrency Value to which the attribute "currency" should be set.
   */
  public void setCurrency( Currency pCurrency ) {
    // Assign value to attribute
    currency = pCurrency;
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
}
