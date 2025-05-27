/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.anaptecs.spring.base.Channel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Sale.SaleBuilderImpl.class)
public class Sale {
  /**
   * Constant for the name of attribute "transactionAmount".
   */
  public static final String TRANSACTIONAMOUNT = "transactionAmount";

  /**
   * Constant for the name of attribute "sale".
   */
  public static final String SALE = "sale";

  private BigDecimal transactionAmount;

  private Channel sale;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Sale( SaleBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    transactionAmount = pBuilder.transactionAmount;
    sale = pBuilder.sale;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Sale objects.
   */
  public static SaleBuilder<?, ?> builder( ) {
    return new SaleBuilderImpl();
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
    SaleBuilder<?, ?> lBuilder = Sale.builder();
    lBuilder.setTransactionAmount(pTransactionAmount);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Sale</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SaleBuilder<T extends Sale, B extends SaleBuilder<T, B>> {
    private BigDecimal transactionAmount;

    private Channel sale;

    /**
     * Use {@link SaleBuilder#builder()} instead of private constructor to create new builder.
     */
    protected SaleBuilder( ) {
    }

    /**
     * Use {@link SaleBuilder#builder(Sale)} instead of private constructor to create new builder.
     */
    protected SaleBuilder( Sale pObject ) {
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
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTransactionAmount( @MyNotNullProperty BigDecimal pTransactionAmount ) {
      // Assign value to attribute
      transactionAmount = pTransactionAmount;
      return this.self();
    }

    /**
     * Method sets association {@link #sale}.<br/>
     *
     * @param pSale Value to which {@link #sale} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSale( Channel pSale ) {
      sale = pSale;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class Sale. The object will be initialized with the values of the builder.
     *
     * @return Sale Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class SaleBuilderImpl extends SaleBuilder<Sale, SaleBuilderImpl> {
    protected SaleBuilderImpl( ) {
    }

    protected SaleBuilderImpl( Sale pObject ) {
      super(pObject);
    }

    @Override
    protected SaleBuilderImpl self( ) {
      return this;
    }

    @Override
    public Sale build( ) {
      Sale lObject = new Sale(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #transactionAmount}.<br/>
   *
   * @return {@link BigDecimal} Value to which {@link #transactionAmount} is set.
   */
  @MyNotNullProperty
  public BigDecimal getTransactionAmount( ) {
    return transactionAmount;
  }

  /**
   * Method sets attribute {@link #transactionAmount}.<br/>
   *
   * @param pTransactionAmount Value to which {@link #transactionAmount} should be set.
   */
  public void setTransactionAmount( @MyNotNullProperty BigDecimal pTransactionAmount ) {
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
  public SaleBuilder<?, ?> toBuilder( ) {
    return new SaleBuilderImpl(this);
  }
}