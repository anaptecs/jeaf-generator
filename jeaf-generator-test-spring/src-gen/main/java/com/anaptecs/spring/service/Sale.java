/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;

import com.anaptecs.spring.base.Channel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Sale objects. The method never returns null.
   */
  public static Builder builder( Sale pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Sale. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BigDecimal transactionAmount;

    /**
     * 
     */
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
        transactionAmount = pObject.transactionAmount;
        sale = pObject.sale;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Sale objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Sale objects. The method never returns null.
     */
    public static Builder newBuilder( Sale pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "transactionAmount".
     * 
     * @param pTransactionAmount Value to which the attribute "transactionAmount" should be set.
     */
    public Builder setTransactionAmount( BigDecimal pTransactionAmount ) {
      // Assign value to attribute
      transactionAmount = pTransactionAmount;
      return this;
    }

    /**
     * Method sets the association "sale".
     * 
     * @param pSale Channel to which the association "sale" should be set.
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
  }

  /**
   * Method returns attribute {@link #transactionAmount}.<br/>
   * 
   * @return BigDecimal Value to which {@link #transactionAmount} is set.
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
   * Method returns the association "sale".
   * 
   *
   * @return Channel Channel to which the association "sale" is set.
   */
  public Channel getSale( ) {
    return sale;
  }

  /**
   * Method sets the association "sale".
   * 
   * 
   * @param pSale Channel to which the association "sale" should be set.
   */
  public void setSale( Channel pSale ) {
    sale = pSale;
  }

  /**
   * Method unsets the association "sale".
   * 
   */
  public final void unsetSale( ) {
    sale = null;
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
}
