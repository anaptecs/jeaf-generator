/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class Booking implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT = "amount";

  /**
   * Constant for the name of attribute "source".
   */
  public static final String SOURCE = "source";

  /**
   * Constant for the name of attribute "target".
   */
  public static final String TARGET = "target";

  /**
   * Constant for the name of attribute "token".
   */
  public static final String TOKEN = "token";

  /**
   * Constant for the name of attribute "remitters".
   */
  public static final String REMITTERS = "remitters";

  /**
   * Constant for the name of attribute "account".
   */
  public static final String ACCOUNT = "account";

  /**
   * Amount of the booking. The attribute must not be null.
   */
  @NotNull
  private Double amount;

  private Account source;

  private Account target;

  private SecurityToken token;

  private Set<Person> remitters;

  private transient Account account;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Booking( ) {
    remitters = new HashSet<Person>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Booking( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    amount = pBuilder.amount;
    source = pBuilder.source;
    target = pBuilder.target;
    token = pBuilder.token;
    if (pBuilder.remitters != null) {
      remitters = pBuilder.remitters;
    }
    else {
      remitters = new HashSet<Person>();
    }
    account = pBuilder.account;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Booking objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns null.
   */
  public static Builder builder( Booking pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Booking. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Amount of the booking. The attribute must not be null.
     */
    @NotNull
    private Double amount;

    /**
     * 
     */
    private Account source;

    /**
     * 
     */
    private Account target;

    /**
     * 
     */
    private SecurityToken token;

    /**
     * 
     */
    private Set<Person> remitters;

    /**
     * 
     */
    private Account account;

    /**
     * Use {@link Booking#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Booking#builder(Booking)} instead of private constructor to create new builder.
     */
    protected Builder( Booking pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        amount = pObject.amount;
        source = pObject.source;
        target = pObject.target;
        token = pObject.token;
        remitters = pObject.remitters;
        account = pObject.account;
      }
    }

    /**
     * Method sets the attribute "amount". Amount of the booking. The attribute must not be null.
     * 
     * @param pAmount Value to which the attribute "amount" should be set.
     */
    public Builder setAmount( Double pAmount ) {
      // Assign value to attribute
      amount = pAmount;
      return this;
    }

    /**
     * Method sets the association "source".
     * 
     * @param pSource Account to which the association "source" should be set.
     */
    public Builder setSource( Account pSource ) {
      source = pSource;
      return this;
    }

    /**
     * Method sets the association "target".
     * 
     * @param pTarget Account to which the association "target" should be set.
     */
    public Builder setTarget( Account pTarget ) {
      target = pTarget;
      return this;
    }

    /**
     * Method sets the association "token".
     * 
     * @param pToken SecurityToken to which the association "token" should be set.
     */
    public Builder setToken( SecurityToken pToken ) {
      token = pToken;
      return this;
    }

    /**
     * Method sets the association "remitters".
     * 
     * @param pRemitters Collection with objects to which the association should be set.
     */
    public Builder setRemitters( Set<Person> pRemitters ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pRemitters != null) {
        remitters = new HashSet<Person>(pRemitters);
      }
      else {
        remitters = null;
      }
      return this;
    }

    /**
     * Method sets the association "account".
     * 
     * @param pAccount Account to which the association "account" should be set.
     */
    public Builder setAccount( Account pAccount ) {
      account = pAccount;
      return this;
    }

    /**
     * Method creates a new instance of class Booking. The object will be initialized with the values of the builder.
     * 
     * @return Booking Created object. The method never returns null.
     */
    public Booking build( ) {
      return new Booking(this);
    }

    /**
     * Method creates a new validated instance of class Booking. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Booking Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Booking buildValidated( ) throws ConstraintViolationException {
      Booking lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #amount}.<br/>
   * Amount of the booking. The attribute must not be null.
   * 
   * @return {@link Double} Value to which {@link #amount} is set.
   */
  public Double getAmount( ) {
    return amount;
  }

  /**
   * Method sets attribute {@link #amount}.<br/>
   * Amount of the booking. The attribute must not be null.
   * 
   * @param pAmount Value to which {@link #amount} should be set.
   */
  public void setAmount( Double pAmount ) {
    // Assign value to attribute
    amount = pAmount;
  }

  /**
   * Method returns association {@link #source}.<br/>
   * 
   * @return {@link Account} Value to which {@link #source} is set.
   */
  public Account getSource( ) {
    return source;
  }

  /**
   * Method sets the association "source".
   * 
   * 
   * @param pSource Account to which the association "source" should be set.
   */
  public void setSource( Account pSource ) {
    source = pSource;
  }

  /**
   * Method unsets the association "source".
   * 
   */
  public final void unsetSource( ) {
    source = null;
  }

  /**
   * Method returns association {@link #target}.<br/>
   * 
   * @return {@link Account} Value to which {@link #target} is set.
   */
  public Account getTarget( ) {
    return target;
  }

  /**
   * Method sets the association "target".
   * 
   * 
   * @param pTarget Account to which the association "target" should be set.
   */
  public void setTarget( Account pTarget ) {
    target = pTarget;
  }

  /**
   * Method unsets the association "target".
   * 
   */
  public final void unsetTarget( ) {
    target = null;
  }

  /**
   * Method returns association {@link #token}.<br/>
   * 
   * @return {@link SecurityToken} Value to which {@link #token} is set.
   */
  public SecurityToken getToken( ) {
    return token;
  }

  /**
   * Method sets the association "token".
   * 
   * 
   * @param pToken SecurityToken to which the association "token" should be set.
   */
  public void setToken( SecurityToken pToken ) {
    // Release already referenced object before setting a new association.
    if (token != null) {
      token.unsetBooking();
    }
    token = pToken;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pToken != null && this.equals(pToken.getBooking()) == false) {
      pToken.setBooking((Booking) this);
    }
  }

  /**
   * Method unsets the association "token".
   * 
   */
  public final void unsetToken( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    SecurityToken lSecurityToken = token;
    token = null;
    if (lSecurityToken != null && this.equals(lSecurityToken.getBooking()) == true) {
      lSecurityToken.unsetBooking();
    }
  }

  /**
   * Method returns the association "remitters".
   * 
   *
   * @return Collection All Person objects that belong to the association "remitters". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Person> getRemitters( ) {
    // Return all Person objects as unmodifiable collection.
    return Collections.unmodifiableSet(remitters);
  }

  /**
   * Method adds the passed Person object to the association "remitters".
   * 
   * 
   * @param pRemitters Object that should be added to the association "remitters". The parameter must not be null.
   */
  public void addToRemitters( Person pRemitters ) {
    // Check parameter "pRemitters" for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Add passed object to collection of associated Person objects.
    remitters.add(pRemitters);
  }

  /**
   * Method adds all passed objects to the association "remitters".
   * 
   * 
   * @param pRemitters Collection with all objects that should be added to the association "remitters". The parameter
   * must not be null.
   */
  public void addToRemitters( Collection<Person> pRemitters ) {
    // Check parameter "pRemitters" for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Add all passed objects.
    for (Person lNextObject : pRemitters) {
      this.addToRemitters(lNextObject);
    }
  }

  /**
   * Method removes the passed Person object from the association "remitters".
   * 
   * 
   * @param pRemitters Object that should be removed from the association "remitters". The parameter must not be null.
   */
  public void removeFromRemitters( Person pRemitters ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Remove passed object from collection of associated Person objects.
    remitters.remove(pRemitters);
  }

  /**
   * Method removes all objects from the association "remitters".
   * 
   */
  public void clearRemitters( ) {
    // Remove all objects from association "remitters".
    remitters.clear();
  }

  /**
   * Method returns association {@link #account}.<br/>
   * 
   * @return {@link Account} Value to which {@link #account} is set.
   */
  public Account getAccount( ) {
    return account;
  }

  /**
   * Method sets the association "account".
   * 
   * 
   * @param pAccount Account to which the association "account" should be set.
   */
  public void setAccount( Account pAccount ) {
    // Release already referenced object before setting a new association.
    if (account != null) {
      account.removeFromBookings((Booking) this);
    }
    account = pAccount;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccount != null && pAccount.getBookings().contains(this) == false) {
      pAccount.addToBookings((Booking) this);
    }
  }

  /**
   * Method unsets the association "account".
   * 
   */
  public final void unsetAccount( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    Account lAccount = account;
    account = null;
    if (lAccount != null && lAccount.getBookings().contains(this) == true) {
      lAccount.removeFromBookings((Booking) this);
    }
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
    lBuilder.append("amount: ");
    lBuilder.append(amount);
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
