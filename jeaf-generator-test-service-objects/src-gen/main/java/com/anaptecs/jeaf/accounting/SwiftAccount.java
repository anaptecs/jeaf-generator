/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Pattern;

import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class SwiftAccount extends Account {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "bic".
   */
  public static final String BIC = "bic";

  /**
   * 
   */
  @Pattern(regexp = "[A-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE })
  private String bic;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SwiftAccount( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SwiftAccount( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    bic = pBuilder.bic;
  }

  /**
   * Class implements builder to create a new instance of class SwiftAccount. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Account.Builder {
    /**
     * 
     */
    @Pattern(regexp = "[A-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE })
    private String bic;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(SwiftAccount)} instead of private constructor to create new builder.
     */
    protected Builder( SwiftAccount pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        bic = pObject.bic;
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
     * @return {@link Builder} New builder that can be used to create new SwiftAccount objects. The method never returns
     * null.
     */
    public static Builder newBuilder( SwiftAccount pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    @Override
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      super.setID(pObjectID);
      return this;
    }

    /**
     * Method sets the attribute "iban".
     * 
     * @param pIban Value to which the attribute "iban" should be set.
     */
    @Override
    public Builder setIban( Long pIban ) {
      // Call super class implementation.
      super.setIban(pIban);
      return this;
    }

    /**
     * Method sets the attribute "balance".
     * 
     * @param pBalance Value to which the attribute "balance" should be set.
     */
    @Override
    public Builder setBalance( BigDecimal pBalance ) {
      // Call super class implementation.
      super.setBalance(pBalance);
      return this;
    }

    /**
     * Method sets the association "authorizedPersons".
     * 
     * @param pAuthorizedPersons Collection with objects to which the association should be set.
     */
    @Override
    public Builder setAuthorizedPersons( Set<Person> pAuthorizedPersons ) {
      // Call super class implementation.
      super.setAuthorizedPersons(pAuthorizedPersons);
      return this;
    }

    /**
     * Method sets the association "bookings".
     * 
     * @param pBookings Collection with objects to which the association should be set.
     */
    @Override
    public Builder setBookings( Set<Booking> pBookings ) {
      // Call super class implementation.
      super.setBookings(pBookings);
      return this;
    }

    /**
     * Method sets the attribute "bankID".
     * 
     * @param pBankID Value to which the attribute "bankID" should be set.
     */
    @Override
    public Builder setBankID( ServiceObjectID pBankID ) {
      // Call super class implementation.
      super.setBankID(pBankID);
      return this;
    }

    /**
     * Method sets the attribute "bic".
     * 
     * @param pBic Value to which the attribute "bic" should be set.
     */
    public Builder setBic( String pBic ) {
      // Assign value to attribute
      bic = pBic;
      return this;
    }

    /**
     * Method creates a new instance of class SwiftAccount. The object will be initialized with the values of the
     * builder.
     * 
     * @return SwiftAccount Created object. The method never returns null.
     */
    public SwiftAccount build( ) {
      return new SwiftAccount(this);
    }

    /**
     * Method creates a new validated instance of class SwiftAccount. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return SwiftAccount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SwiftAccount buildValidated( ) throws ConstraintViolationException {
      SwiftAccount lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "bic".
   * 
   * 
   * @return String Value to which the attribute "bic" is set.
   */
  public String getBic( ) {
    return bic;
  }

  /**
   * Method sets the attribute "bic".
   * 
   * 
   * @param pBic Value to which the attribute "bic" should be set.
   */
  public void setBic( String pBic ) {
    // Assign value to attribute
    bic = pBic;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "bic", "" + bic));
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
