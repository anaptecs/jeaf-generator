/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import com.anaptecs.jeaf.core.api.AbstractObjectID;
import com.anaptecs.jeaf.core.api.Identifiable;
import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class AccountInfoBase implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "iban".
   */
  public static final String IBAN = "iban";

  /**
   * Constant for the name of attribute "balance".
   */
  public static final String BALANCE = "balance";

  /**
   * Constant for the name of attribute "bankID".
   */
  public static final String BANKID = "bankID";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  private Long iban;

  /**
   * 
   */
  private Double balance;

  /**
   * 
   */
  private ServiceObjectID bankID;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AccountInfoBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    AbstractObjectID<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    iban = pBuilder.iban;
    balance = pBuilder.balance;
    bankID = pBuilder.bankID;
  }

  /**
   * Class implements builder to create a new instance of class AccountInfo. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class BuilderBase {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private AbstractObjectID<?> objectID;

    /**
     * 
     */
    private Long iban;

    /**
     * 
     */
    private Double balance;

    /**
     * 
     */
    private ServiceObjectID bankID;

    /**
     * Use {@link AccountInfo.Builder#newBuilder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AccountInfo.Builder#newBuilder(AccountInfo)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( AccountInfoBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        iban = pObject.iban;
        balance = pObject.balance;
        bankID = pObject.bankID;
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public BuilderBase setID( AbstractObjectID<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the attribute "iban".
     * 
     * @param pIban Value to which the attribute "iban" should be set.
     */
    public BuilderBase setIban( Long pIban ) {
      // Assign value to attribute
      iban = pIban;
      return this;
    }

    /**
     * Method sets the attribute "balance".
     * 
     * @param pBalance Value to which the attribute "balance" should be set.
     */
    public BuilderBase setBalance( Double pBalance ) {
      // Assign value to attribute
      balance = pBalance;
      return this;
    }

    /**
     * Method sets the attribute "bankID".
     * 
     * @param pBankID Value to which the attribute "bankID" should be set.
     */
    public BuilderBase setBankID( ServiceObjectID pBankID ) {
      // Assign value to attribute
      bankID = pBankID;
      return this;
    }

    /**
     * Method creates a new instance of class AccountInfo. The object will be initialized with the values of the
     * builder.
     * 
     * @return AccountInfo Created object. The method never returns null.
     */
    public AccountInfo build( ) {
      return new AccountInfo(this);
    }

    /**
     * Method creates a new instance of class AccountInfo. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return AccountInfo Created object. The method never returns null.
     */
    public AccountInfo build( boolean pValidate ) {
      AccountInfo lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the attribute "iban".
   * 
   * 
   * @return Long Value to which the attribute "iban" is set.
   */
  public Long getIban( ) {
    return iban;
  }

  /**
   * Method sets the attribute "iban".
   * 
   * 
   * @param pIban Value to which the attribute "iban" should be set.
   */
  public void setIban( Long pIban ) {
    // Assign value to attribute
    iban = pIban;
  }

  /**
   * Method returns the attribute "balance".
   * 
   * 
   * @return Double Value to which the attribute "balance" is set.
   */
  public Double getBalance( ) {
    return balance;
  }

  /**
   * Method sets the attribute "balance".
   * 
   * 
   * @param pBalance Value to which the attribute "balance" should be set.
   */
  public void setBalance( Double pBalance ) {
    // Assign value to attribute
    balance = pBalance;
  }

  /**
   * Method returns the attribute "bankID".
   * 
   * 
   * @return ServiceObjectID Value to which the attribute "bankID" is set.
   */
  public ServiceObjectID getBankID( ) {
    return bankID;
  }

  /**
   * Method sets the attribute "bankID".
   * 
   * 
   * @param pBankID Value to which the attribute "bankID" should be set.
   */
  public void setBankID( ServiceObjectID pBankID ) {
    // Assign value to attribute
    bankID = pBankID;
  }

  /**
   * 
   * @return {@link Double}
   */
  public abstract Double calclulateBalance( );

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
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "iban", "" + iban));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "balance", "" + balance));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "bankID", "" + bankID));
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