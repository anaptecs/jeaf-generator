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
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class SwiftAccount extends Account {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "bic".
   */
  public static final String BIC = "bic";

  @Pattern(regexp = "[A-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE })
  private String bic;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SwiftAccount( ) {
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
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SwiftAccount objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SwiftAccount objects. The method never returns
   * null.
   */
  public static Builder builder( SwiftAccount pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>SwiftAccount</code>.
   */
  public static class Builder extends Account.Builder {
    @Pattern(regexp = "[A-Z]+", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE })
    private String bic;

    /**
     * Use {@link SwiftAccount#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SwiftAccount#builder(SwiftAccount)} instead of private constructor to create new builder.
     */
    protected Builder( SwiftAccount pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        bic = pObject.bic;
      }
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
     * Method sets attribute {@link #iban}.<br/>
     *
     * @param pIban Value to which {@link #iban} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setIban( Long pIban ) {
      // Call super class implementation.
      super.setIban(pIban);
      return this;
    }

    /**
     * Method sets attribute {@link #balance}.<br/>
     *
     * @param pBalance Value to which {@link #balance} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setBalance( BigDecimal pBalance ) {
      // Call super class implementation.
      super.setBalance(pBalance);
      return this;
    }

    /**
     * Method sets association {@link #authorizedPersons}.<br/>
     *
     * @param pAuthorizedPersons Collection to which {@link #authorizedPersons} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setAuthorizedPersons( Set<Person> pAuthorizedPersons ) {
      // Call super class implementation.
      super.setAuthorizedPersons(pAuthorizedPersons);
      return this;
    }

    /**
     * Method sets association {@link #bookings}.<br/>
     *
     * @param pBookings Collection to which {@link #bookings} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setBookings( Set<Booking> pBookings ) {
      // Call super class implementation.
      super.setBookings(pBookings);
      return this;
    }

    /**
     * Method sets attribute {@link #bankID}.<br/>
     *
     * @param pBankID Value to which {@link #bankID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setBankID( ServiceObjectID pBankID ) {
      // Call super class implementation.
      super.setBankID(pBankID);
      return this;
    }

    /**
     * Method sets attribute {@link #bic}.<br/>
     *
     * @param pBic Value to which {@link #bic} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
      SwiftAccount lObject = new SwiftAccount(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class SwiftAccount. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return SwiftAccount Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SwiftAccount buildValidated( ) throws ConstraintViolationException {
      SwiftAccount lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #bic}.<br/>
   *
   * @return {@link String} Value to which {@link #bic} is set.
   */
  public String getBic( ) {
    return bic;
  }

  /**
   * Method sets attribute {@link #bic}.<br/>
   *
   * @param pBic Value to which {@link #bic} should be set.
   */
  public void setBic( String pBic ) {
    // Assign value to attribute
    bic = pBic;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("bic: ");
    lBuilder.append(bic);
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
