package com.anaptecs.jeaf.accounting.impl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public abstract class BookingBOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1102, BookingBO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "BOOKINGBO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "amount".
   */
  public static final String AMOUNT_ROW = "AMOUNT";

  /**
   * Constant for the name of attribute "amount".
   */
  public static final String AMOUNT_ATTRIBUTE = "amount";

  /**
   * Constant for the name of the row that is used to store the values of attribute "sessionKey".
   */
  public static final String SESSIONKEY_ROW = "SESSIONKEY";

  /**
   * Constant for the name of attribute "sessionKey".
   */
  public static final String SESSIONKEY_ATTRIBUTE = "sessionKey";

  /**
   * Constant for the name of role "account".
   */
  public static final String ACCOUNT_ROLE = "account";

  /**
   * Constant for the name of role "remitters".
   */
  public static final String REMITTERS_ROLE = "remitters";

  /**
   * 
   */
  private Double amount;

  /**
   * 
   */
  private AccountBO account;

  /**
   * Person who authorized the booking.
   */
  private Set<MyPersonBO> remitters;

  /**
   * 
   */
  private byte[] sessionKey;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected BookingBOBase( ) {
    remitters = new HashSet<MyPersonBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<BookingBO> findAllBookingBOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(BookingBO.class);
  }

  /**
   * Method returns the attribute "amount".
   * 
   * 
   * @return Double Value to which the attribute "amount" is set.
   */
  public Double getAmount( ) {
    return amount;
  }

  /**
   * Method sets the attribute "amount".
   * 
   * 
   * @param pAmount Value to which the attribute "amount" should be set.
   */
  public void setAmount( Double pAmount ) {
    // Assign value to attribute
    amount = pAmount;
  }

  /**
   * Method returns the association "account".
   * 
   *
   * @return AccountBO AccountBO to which the association "account" is set.
   */
  public AccountBO getAccount( ) {
    account = this.unproxy(account);
    return account;
  }

  /**
   * Method sets the association "account".
   * 
   * 
   * @param pAccount AccountBO to which the association "account" should be set.
   */
  public void setAccount( AccountBO pAccount ) {
    // Release already referenced object before setting a new association.
    if (account != null) {
      account.removeFromBookings((BookingBO) this);
    }
    account = pAccount;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAccount != null && pAccount.getBookings().contains(this) == false) {
      pAccount.addToBookings((BookingBO) this);
    }
  }

  /**
   * Method unsets the association "account".
   * 
   */
  public final void unsetAccount( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    AccountBO lAccountBO = account;
    account = null;
    if (lAccountBO != null && lAccountBO.getBookings().contains(this) == true) {
      lAccountBO.removeFromBookings((BookingBO) this);
    }
  }

  /**
   * Method returns the association "remitters". Person who authorized the booking.
   *
   * @return Collection All MyPersonBO objects that belong to the association "remitters". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<MyPersonBO> getRemitters( ) {
    // Return all MyPersonBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(remitters);
  }

  /**
   * Method adds the passed MyPersonBO object to the association "remitters". Person who authorized the booking.
   * 
   * @param pRemitters Object that should be added to the association "remitters". The parameter must not be null.
   */
  public void addToRemitters( MyPersonBO pRemitters ) {
    // Check parameter "pRemitters" for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Add passed object to collection of associated MyPersonBO objects.
    remitters.add(pRemitters);
  }

  /**
   * Method adds all passed objects to the association "remitters". Person who authorized the booking.
   * 
   * @param pRemitters Collection with all objects that should be added to the association "remitters". The parameter
   * must not be null.
   */
  public void addToRemitters( Collection<MyPersonBO> pRemitters ) {
    // Check parameter "pRemitters" for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Add all passed objects.
    for (MyPersonBO lNextObject : pRemitters) {
      this.addToRemitters(lNextObject);
    }
  }

  /**
   * Method removes the passed MyPersonBO object from the association "remitters". Person who authorized the booking.
   * 
   * @param pRemitters Object that should be removed from the association "remitters". The parameter must not be null.
   */
  public void removeFromRemitters( MyPersonBO pRemitters ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pRemitters, "pRemitters");
    // Remove passed object from collection of associated MyPersonBO objects.
    remitters.remove(pRemitters);
  }

  /**
   * Method removes all objects from the association "remitters". Person who authorized the booking.
   */
  public void clearRemitters( ) {
    // Remove all objects from association "remitters".
    Collection<MyPersonBO> lRemitters = new HashSet<MyPersonBO>(remitters);
    Iterator<MyPersonBO> lIterator = lRemitters.iterator();
    while (lIterator.hasNext()) {
      this.removeFromRemitters(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "sessionKey".
   * 
   * 
   * @return byte Value to which the attribute "sessionKey" is set.
   */
  public byte[] getSessionKey( ) {
    byte[] lReturnValue;
    if (sessionKey != null) {
      lReturnValue = new byte[sessionKey.length];
      System.arraycopy(sessionKey, 0, lReturnValue, 0, sessionKey.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "sessionKey".
   * 
   * 
   * @param pSessionKey Value to which the attribute "sessionKey" should be set.
   */
  public void setSessionKey( byte[] pSessionKey ) {
    // Assign value to attribute
    if (pSessionKey != null) {
      sessionKey = new byte[pSessionKey.length];
      System.arraycopy(pSessionKey, 0, sessionKey, 0, pSessionKey.length);
    }
    else {
      sessionKey = null;
    }
  }

  /**
   * Method returns the class id of this business object class.
   * 
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}
