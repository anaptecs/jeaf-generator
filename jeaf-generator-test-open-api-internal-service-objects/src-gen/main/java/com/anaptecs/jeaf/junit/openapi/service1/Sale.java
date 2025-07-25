/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Chännel<br/>
 * €<br/>
 * Ö
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Sale implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private BigDecimal transactionAmount;

  @Valid
  private Channel sale;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Sale( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Sale( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    transactionAmount = pBuilder.transactionAmount;
    sale = pBuilder.sale;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Sale objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( BigDecimal pTransactionAmount ) {
    Builder lBuilder = builder();
    lBuilder.setTransactionAmount(pTransactionAmount);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class Sale.
   *
   *
   * @param pTransactionAmount Value to which {@link #transactionAmount} should be set.
   *
   * @return {@link Sale}
   */
  public static Sale of( BigDecimal pTransactionAmount ) {
    var lBuilder = Sale.builder();
    lBuilder.setTransactionAmount(pTransactionAmount);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Sale</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private BigDecimal transactionAmount;

    private Channel sale;

    /**
     * Use {@link Sale#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Sale#builder(Sale)} instead of private constructor to create new builder.
     */
    protected Builder( Sale pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTransactionAmount(pObject.transactionAmount);
        this.setSale(pObject.sale);
      }
    }

    /**
     * Method sets attribute {@link #transactionAmount}.<br/>
     *
     * @param pTransactionAmount Value to which {@link #transactionAmount} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTransactionAmount( BigDecimal pTransactionAmount ) {
      // Assign value to attribute
      transactionAmount = pTransactionAmount;
      return this;
    }

    /**
     * Method sets association {@link #sale}.<br/>
     *
     * @param pSale Value to which {@link #sale} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSale( Channel pSale ) {
      sale = pSale;
      return this;
    }

    /**
     * Method creates a new instance of class Sale. The object will be initialized with the values of the builder.
     *
     * @return Sale Created object. The method never returns null.
     */
    public Sale build( ) {
      return new Sale(this);
    }

    /**
     * Method creates a new validated instance of class Sale. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Sale Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Sale buildValidated( ) throws ConstraintViolationException {
      Sale lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #transactionAmount}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #transactionAmount} is set.
   */
  public BigDecimal getTransactionAmount( ) {
    return transactionAmount;
  }

  /**
   * Method sets attribute {@link #transactionAmount}.<br/>
   *
   * @param pTransactionAmount Value to which {@link #transactionAmount} should be set.
   */
  public void setTransactionAmount( BigDecimal pTransactionAmount ) {
    // Assign value to attribute
    transactionAmount = pTransactionAmount;
  }

  /**
   * Method returns association {@link #sale}.<br/>
   *
   * @return {@link Channel} Value to which {@link #sale} is set.
   */
  public Channel getSale( ) {
    return sale;
  }

  /**
   * Method sets association {@link #sale}.<br/>
   *
   * @param pSale Value to which {@link #sale} should be set.
   */
  public void setSale( Channel pSale ) {
    sale = pSale;
  }

  /**
   * Method unsets {@link #sale}.
   */
  public final void unsetSale( ) {
    sale = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(transactionAmount);
    lResult = lPrime * lResult + Objects.hashCode(sale);
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
      Sale lOther = (Sale) pObject;
      lEquals = Objects.equals(transactionAmount, lOther.transactionAmount) && Objects.equals(sale, lOther.sale);
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
    lBuilder.append("transactionAmount: ");
    lBuilder.append(transactionAmount);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sale: ");
    if (sale != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(sale.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
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
   * @return {@link Builder} New builder that can be used to create new Sale objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}