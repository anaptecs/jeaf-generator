/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.spring.base.Channel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "transactionAmount".
   */
  public static final String TRANSACTIONAMOUNT = "transactionAmount";

  /**
   * Constant for the name of attribute "sale".
   */
  public static final String SALE = "sale";

  /**
   * 
   */
  private BigDecimal transactionAmount;

  /**
   * 
   */
  private Channel sale;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Sale( ) {
    // Nothing to do.
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Sale)} instead of private constructor to create new builder.
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
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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

    /**
     * Method creates a new validated instance of class Sale. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Sale Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Sale buildValidated( ) throws ConstraintViolationException {
      Sale lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "transactionAmount".
   * 
   * 
   * @return BigDecimal Value to which the attribute "transactionAmount" is set.
   */
  public BigDecimal getTransactionAmount( ) {
    return transactionAmount;
  }

  /**
   * Method sets the attribute "transactionAmount".
   * 
   * 
   * @param pTransactionAmount Value to which the attribute "transactionAmount" should be set.
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "transactionAmount",
        "" + transactionAmount));
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