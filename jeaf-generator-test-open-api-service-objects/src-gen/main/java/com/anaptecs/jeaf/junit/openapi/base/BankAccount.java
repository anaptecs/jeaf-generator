/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class BankAccount implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private String iban;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BankAccount( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BankAccount( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    iban = pBuilder.iban;
  }

  /**
   * Class implements builder to create a new instance of class BankAccount. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String iban;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BankAccount)} instead of private constructor to create new builder.
     */
    protected Builder( BankAccount pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        iban = pObject.iban;
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
     * @return {@link Builder} New builder that can be used to create new BankAccount objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BankAccount pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "iban".
     * 
     * @param pIban Value to which the attribute "iban" should be set.
     */
    public Builder setIban( String pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method creates a new instance of class BankAccount. The object will be initialized with the values of the
     * builder.
     * 
     * @return BankAccount Created object. The method never returns null.
     */
    public BankAccount build( ) {
      return new BankAccount(this);
    }

    /**
     * Method creates a new validated instance of class BankAccount. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return BankAccount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BankAccount buildValidated( ) throws ConstraintViolationException {
      BankAccount lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "iban".
   * 
   * 
   * @return String Value to which the attribute "iban" is set.
   */
  public String getIban( ) {
    return iban;
  }

  /**
   * Method sets the attribute "iban".
   * 
   * 
   * @param pIban Value to which the attribute "iban" should be set.
   */
  public void setIban( String pIban ) {
    // Assign value to attribute
    iban = pIban;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "iban", "" + iban));
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
