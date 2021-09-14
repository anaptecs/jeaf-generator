/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@Valid()
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
  @NotNull()
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
  private Set<Person> remitters = new HashSet<Person>();

  /**
   * 
   */
  private Account account;

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
      remitters.addAll(pBuilder.remitters);
    }
    account = pBuilder.account;
  }

  /**
   * Class implements builder to create a new instance of class Booking. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Amount of the booking. The attribute must not be null.
     */
    @NotNull()
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Booking)} instead of private constructor to create new builder.
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
     * @return {@link Builder} New builder that can be used to create new Booking objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Booking pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class Booking. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Booking Created object. The method never returns null.
     */
    public Booking build( boolean pValidate ) {
      Booking lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "amount". Amount of the booking. The attribute must not be null.
   * 
   * @return Double Value to which the attribute "amount" is set.
   */
  public Double getAmount( ) {
    return amount;
  }

  /**
   * Method sets the attribute "amount". Amount of the booking. The attribute must not be null.
   * 
   * @param pAmount Value to which the attribute "amount" should be set.
   */
  public void setAmount( Double pAmount ) {
    // Assign value to attribute
    amount = pAmount;
  }

  /**
   * Method returns the association "source".
   * 
   *
   * @return Account Account to which the association "source" is set.
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
   * Method returns the association "target".
   * 
   *
   * @return Account Account to which the association "target" is set.
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
   * Method returns the association "token".
   * 
   *
   * @return SecurityToken SecurityToken to which the association "token" is set.
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
   * Method sets the association "remitters" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pRemitters Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setRemitters( Set<Person> pRemitters ) {
    // Check of parameter is not required.
    // Remove all objects from association "remitters".
    this.clearRemitters();
    // If the association is null, removing all entries is sufficient.
    if (pRemitters != null) {
      remitters = new HashSet<Person>(pRemitters);
    }
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
    Collection<Person> lRemitters = new HashSet<Person>(remitters);
    Iterator<Person> lIterator = lRemitters.iterator();
    while (lIterator.hasNext()) {
      this.removeFromRemitters(lIterator.next());
    }
  }

  /**
   * Method returns the association "account".
   * 
   *
   * @return Account Account to which the association "account" is set.
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
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "amount", "" + amount));
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
