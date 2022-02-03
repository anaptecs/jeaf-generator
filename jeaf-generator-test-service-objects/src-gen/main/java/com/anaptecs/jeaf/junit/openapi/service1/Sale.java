/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.math.BigDecimal;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Sale implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "transactionAmount".
   */
  public static final String TRANSACTIONAMOUNT = "transactionAmount";

  /**
   * 
   */
  private BigDecimal transactionAmount;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
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
  }

  /**
   * Class implements builder to create a new instance of class Sale. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BigDecimal transactionAmount;

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
     * Method creates a new instance of class Sale. The object will be initialized with the values of the builder.
     * 
     * @return Sale Created object. The method never returns null.
     */
    public Sale build( ) {
      return new Sale(this);
    }

    /**
     * Method creates a new instance of class Sale. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Sale Created object. The method never returns null.
     */
    public Sale build( boolean pValidate ) {
      Sale lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "transactionAmount",
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
