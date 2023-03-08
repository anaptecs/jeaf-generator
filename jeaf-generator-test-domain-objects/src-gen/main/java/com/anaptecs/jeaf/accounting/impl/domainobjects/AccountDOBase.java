/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting.impl.domainobjects;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.core.api.ServiceObjectID;

public abstract class AccountDOBase extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "number".
   */
  public static final String NUMBER = "number";

  /**
   * Constant for the name of attribute "interestRate".
   */
  public static final String INTERESTRATE = "interestRate";

  /**
   * Constant for the name of attribute "balance".
   */
  public static final String BALANCE = "balance";

  private Long number;

  private Float interestRate;

  private BigDecimal balance;

  /**
   * Initialize object. Nothing special to do.
   */
  public AccountDOBase( ) {
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public AccountDOBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
  }

  /**
   * Method returns attribute {@link #number}.<br/>
   * 
   * @return Long Value to which the attribute "number" is set.
   */
  public Long getNumber( ) {
    return number;
  }

  /**
   * Method sets the attribute "number".
   * 
   * 
   * @param pNumber Value to which the attribute "number" should be set.
   */
  public void setNumber( Long pNumber ) {
    // Assign value to attribute
    number = pNumber;
  }

  /**
   * Method returns attribute {@link #interestRate}.<br/>
   * 
   * @return Float Value to which the attribute "interestRate" is set.
   */
  public Float getInterestRate( ) {
    return interestRate;
  }

  /**
   * Method sets the attribute "interestRate".
   * 
   * 
   * @param pInterestRate Value to which the attribute "interestRate" should be set.
   */
  public void setInterestRate( Float pInterestRate ) {
    // Assign value to attribute
    interestRate = pInterestRate;
  }

  /**
   * Method returns attribute {@link #balance}.<br/>
   * 
   * @return BigDecimal Value to which the attribute "balance" is set.
   */
  public BigDecimal getBalance( ) {
    return balance;
  }

  /**
   * Method sets the attribute "balance".
   * 
   * 
   * @param pBalance Value to which the attribute "balance" should be set.
   */
  public void setBalance( BigDecimal pBalance ) {
    // Assign value to attribute
    balance = pBalance;
  }

  /**
   * @return {@link ServiceObjectID}
   */
  @NotNull
  public abstract ServiceObjectID getBankID( );

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
    lBuilder.append("number: ");
    lBuilder.append(number);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("interestRate: ");
    lBuilder.append(interestRate);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("balance: ");
    lBuilder.append(balance);
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
