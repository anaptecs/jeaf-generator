/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.math.BigDecimal;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
/**
 * Chännel<br/>
 * €<br/>
 * Ö
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public class Sale extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "transactionAmount".
   */
  @JEAFCustomAnnotationTest
  public static final String TRANSACTIONAMOUNT = "transactionAmount";

  /**
   * Constant for the name of attribute "sale".
   */
  @JEAFCustomAnnotationTest
  public static final String SALE = "sale";

  // "java.math.BigDecimal"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private BigDecimal transactionAmount;

  // "java.math.BigDecimal"
  private int transactionAmountXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.Channel"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Channel sale;

  // "com.anaptecs.jeaf.junit.openapi.base.Channel"
  private int saleXYZ = 0;

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
    // "java.math.BigDecimal"
    transactionAmountXYZ = pBuilder.transactionAmountXYZ;
    sale = pBuilder.sale;
    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    saleXYZ = pBuilder.saleXYZ;
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
   * Class implements builder to create a new instance of class <code>Sale</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.math.BigDecimal"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private BigDecimal transactionAmount;

    // "java.math.BigDecimal"
    private int transactionAmountXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Channel sale;

    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    private int saleXYZ = 0;

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
    @JEAFCustomAnnotationTest
    public Builder setTransactionAmount( BigDecimal pTransactionAmount ) {
      // Assign value to attribute
      transactionAmount = pTransactionAmount;
      return this;
    }

    public Builder setTransactionAmountXYZ( int value ) {
      // "java.math.BigDecimal"
      transactionAmountXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #sale}.<br/>
     *
     * @param pSale Value to which {@link #sale} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setSale( Channel pSale ) {
      sale = pSale;
      return this;
    }

    public Builder setSaleXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Channel"
      saleXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
  public BigDecimal getTransactionAmount( ) {
    return transactionAmount;
  }

  /**
   * Method sets attribute {@link #transactionAmount}.<br/>
   *
   * @param pTransactionAmount Value to which {@link #transactionAmount} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setTransactionAmount( BigDecimal pTransactionAmount ) {
    // Assign value to attribute
    transactionAmount = pTransactionAmount;
  }

  public int getTransactionAmountXYZ( ) {
    // "java.math.BigDecimal"
    return transactionAmountXYZ;
  }

  public void setTransactionAmountXYZ( int value ) {
    transactionAmountXYZ = value;
  }

  /**
   * Method returns association {@link #sale}.<br/>
   *
   * @return {@link Channel} Value to which {@link #sale} is set.
   */
  @JEAFCustomAnnotationTest
  public Channel getSale( ) {
    return sale;
  }

  /**
   * Method sets association {@link #sale}.<br/>
   *
   * @param pSale Value to which {@link #sale} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setSale( Channel pSale ) {
    sale = pSale;
  }

  /**
   * Method unsets {@link #sale}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetSale( ) {
    sale = null;
  }

  public int getSaleXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Channel"
    return saleXYZ;
  }

  public void setSaleXYZ( int value ) {
    saleXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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