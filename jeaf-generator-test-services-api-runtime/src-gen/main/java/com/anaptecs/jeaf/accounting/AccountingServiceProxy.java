/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * ServiceProxy class for JEAF service AccountingService.
 */
public final class AccountingServiceProxy extends ServiceProxy implements AccountingService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public AccountingServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(AccountingService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method "createAccount".
   * 
   * Method creates a new account for the passed customer. The method uses the passed person as authorized person.
   * 
   * @param pCustomer Customer for which the account will be created. The parameter must not be null.
   * @param pAuthorizedPerson Person who will be authorized for the passed account. The parameter must not be null.
   * @return {@link Account} Created account object. The method never returns null.
   * 
   */
  public Account createAccount( Customer pCustomer, Person pAuthorizedPerson ) {
    try {
      Command lCommand = new CreateAccount_Customer_Person_AccountingService_Command(pCustomer, pAuthorizedPerson);
      return (Account) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "getAccount".
   * 
   * Method returns the account with the passed account id.
   * 
   * @param pAccountID ID of the account that should be returned. The parameter must not be null.
   * @return {@link Account} Account service object with the passed id. The method never returns null.
   * 
   */
  public Account getAccount( ServiceObjectID pAccountID ) {
    try {
      Command lCommand = new GetAccount_ServiceObjectID_AccountingService_Command(pAccountID);
      return (Account) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "lockAccount".
   * 
   * Method locks the passed account. If the account is already locked, nothing will happen.
   * 
   * @param pAccount Account that should be locked. The parameter must not be null.
   * 
   */
  public void lockAccount( Account pAccount ) {
    try {
      Command lCommand = new LockAccount_Account_AccountingService_Command(pAccount);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "unlock".
   * 
   * Method unlocks the passed account. If the account is already unlocked, nothing will happen.
   * 
   * @param pAccount Account that should be unlocked. The parameter must not be null.
   * 
   */
  public void unlock( Account pAccount ) {
    try {
      Command lCommand = new Unlock_Account_AccountingService_Command(pAccount);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "performBooking".
   * 
   * Method performs a booking of the passed amount. Therefore besides the booking also the source and target account
   * have to be passed.
   * 
   * @param pBooking Booking that should be performed. The parameter must not be null and both, the source and target
   * account have to be set.
   * @param pSecurityToken Current security token of the caller. The parameter must not be null.
   * 
   */
  public void performBooking( Booking pBooking, SecurityToken pSecurityToken ) {
    try {
      Command lCommand = new PerformBooking_Booking_SecurityToken_AccountingService_Command(pBooking, pSecurityToken);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "createCustomer".
   * 
   * Method creates a new customer object from the data of the passed service object.
   * 
   * @param pNewCustomer Customer service object describing the data of the customer that should be created. The
   * parameter must not be null.
   * @param pAttendingEmployeeID ID of the employee that will be the attendant for the created customer. The parameter
   * must not be null.
   * @return {@link Customer} Customer object describing the created customer. The method never returns null and the
   * returned object is not same instance as the passed one.
   * 
   */
  public Customer createCustomer( Customer pNewCustomer, ServiceObjectID pAttendingEmployeeID ) {
    try {
      Command lCommand =
          new CreateCustomer_Customer_ServiceObjectID_AccountingService_Command(pNewCustomer, pAttendingEmployeeID);
      return (Customer) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "getCustomer".
   * 
   * Method returns the customer with the passed service object id.
   * 
   * @param pCustomerID ID of the customer that should be returned. The parameter must not be null.
   * @return {@link Customer} Customer object with the passed id or null if the object does not exist.
   */
  public Customer getCustomer( ServiceObjectID pCustomerID ) {
    try {
      Command lCommand = new GetCustomer_ServiceObjectID_AccountingService_Command(pCustomerID);
      return (Customer) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "createPerson".
   * 
   * Method creates a new Person object with the data of the passed service object.
   * 
   * @param pPerson Person service object whose data should be used to create a new persistent Person object. The
   * parameter must not be null.
   * @return {@link Person} Person service object describing the created person. The object is not the same instance as
   * the passed one. The method never returns null.
   * 
   */
  public Person createPerson( @Valid() Person pPerson ) {
    try {
      Command lCommand = new CreatePerson_Person_AccountingService_Command(pPerson);
      return (Person) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "searchCustomers".
   * 
   * 
   */
  @SuppressWarnings("unchecked")
  public Set<Customer> searchCustomers( CustomerQuery pQuery ) {
    try {
      Command lCommand = new SearchCustomers_CustomerQuery_AccountingService_Command(pQuery);
      return (Set<Customer>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "createAccount".
 */
final class CreateAccount_Customer_Person_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("createAccount", Customer.class, Person.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "createAccount(Customer.class, Person.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCustomer" to the service implementation via the service channel.
   */
  private final Customer customer;

  /**
   * Attribute transports the method parameter "pAuthorizedPerson" to the service implementation via the service
   * channel.
   */
  private final Person authorizedPerson;

  /**
   * Initialize object. All parameters from method "createAccount" have to be passed as parameters to this command
   * object.
   * 
   * @param pCustomer Customer
   * @param pAuthorizedPerson Person
   */
  CreateAccount_Customer_Person_AccountingService_Command( Customer pCustomer, Person pAuthorizedPerson ) {
    super(AccountingService.class);
    customer = pCustomer;
    authorizedPerson = pAuthorizedPerson;
    parameters = new Object[] { customer, authorizedPerson };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createAccount(customer, authorizedPerson);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getAccount".
 */
final class GetAccount_ServiceObjectID_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("getAccount", ServiceObjectID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "getAccount(ServiceObjectID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAccountID" to the service implementation via the service channel.
   */
  private final ServiceObjectID accountID;

  /**
   * Initialize object. All parameters from method "getAccount" have to be passed as parameters to this command object.
   * 
   * @param pAccountID ServiceObjectID
   */
  GetAccount_ServiceObjectID_AccountingService_Command( ServiceObjectID pAccountID ) {
    super(AccountingService.class);
    accountID = pAccountID;
    parameters = new Object[] { accountID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getAccount(accountID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "lockAccount".
 */
final class LockAccount_Account_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("lockAccount", Account.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "lockAccount(Account.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAccount" to the service implementation via the service channel.
   */
  private final Account account;

  /**
   * Initialize object. All parameters from method "lockAccount" have to be passed as parameters to this command object.
   * 
   * @param pAccount Account
   */
  LockAccount_Account_AccountingService_Command( Account pAccount ) {
    super(AccountingService.class);
    account = pAccount;
    parameters = new Object[] { account };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.lockAccount(account);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "unlock".
 */
final class Unlock_Account_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("unlock", Account.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "unlock(Account.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAccount" to the service implementation via the service channel.
   */
  private final Account account;

  /**
   * Initialize object. All parameters from method "unlock" have to be passed as parameters to this command object.
   * 
   * @param pAccount Account
   */
  Unlock_Account_AccountingService_Command( Account pAccount ) {
    super(AccountingService.class);
    account = pAccount;
    parameters = new Object[] { account };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.unlock(account);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "performBooking".
 */
final class PerformBooking_Booking_SecurityToken_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("performBooking", Booking.class, SecurityToken.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "performBooking(Booking.class, SecurityToken.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBooking" to the service implementation via the service channel.
   */
  private final Booking booking;

  /**
   * Attribute transports the method parameter "pSecurityToken" to the service implementation via the service channel.
   */
  private final SecurityToken securityToken;

  /**
   * Initialize object. All parameters from method "performBooking" have to be passed as parameters to this command
   * object.
   * 
   * @param pBooking Booking
   * @param pSecurityToken SecurityToken
   */
  PerformBooking_Booking_SecurityToken_AccountingService_Command( Booking pBooking, SecurityToken pSecurityToken ) {
    super(AccountingService.class);
    booking = pBooking;
    securityToken = pSecurityToken;
    parameters = new Object[] { booking, securityToken };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.performBooking(booking, securityToken);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createCustomer".
 */
final class CreateCustomer_Customer_ServiceObjectID_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("createCustomer", Customer.class, ServiceObjectID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "createCustomer(Customer.class, ServiceObjectID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pNewCustomer" to the service implementation via the service channel.
   */
  private final Customer newCustomer;

  /**
   * Attribute transports the method parameter "pAttendingEmployeeID" to the service implementation via the service
   * channel.
   */
  private final ServiceObjectID attendingEmployeeID;

  /**
   * Initialize object. All parameters from method "createCustomer" have to be passed as parameters to this command
   * object.
   * 
   * @param pNewCustomer Customer
   * @param pAttendingEmployeeID ServiceObjectID
   */
  CreateCustomer_Customer_ServiceObjectID_AccountingService_Command( Customer pNewCustomer,
      ServiceObjectID pAttendingEmployeeID ) {
    super(AccountingService.class);
    newCustomer = pNewCustomer;
    attendingEmployeeID = pAttendingEmployeeID;
    parameters = new Object[] { newCustomer, attendingEmployeeID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createCustomer(newCustomer, attendingEmployeeID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getCustomer".
 */
final class GetCustomer_ServiceObjectID_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("getCustomer", ServiceObjectID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "getCustomer(ServiceObjectID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCustomerID" to the service implementation via the service channel.
   */
  private final ServiceObjectID customerID;

  /**
   * Initialize object. All parameters from method "getCustomer" have to be passed as parameters to this command object.
   * 
   * @param pCustomerID ServiceObjectID
   */
  GetCustomer_ServiceObjectID_AccountingService_Command( ServiceObjectID pCustomerID ) {
    super(AccountingService.class);
    customerID = pCustomerID;
    parameters = new Object[] { customerID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getCustomer(customerID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createPerson".
 */
final class CreatePerson_Person_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("createPerson", Person.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "createPerson(Person.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPerson" to the service implementation via the service channel.
   */
  private final Person person;

  /**
   * Initialize object. All parameters from method "createPerson" have to be passed as parameters to this command
   * object.
   * 
   * @param pPerson Person
   */
  CreatePerson_Person_AccountingService_Command( @Valid() Person pPerson ) {
    super(AccountingService.class);
    person = pPerson;
    parameters = new Object[] { person };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createPerson(person);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "searchCustomers".
 */
final class SearchCustomers_CustomerQuery_AccountingService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = AccountingService.class.getMethod("searchCustomers", CustomerQuery.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "searchCustomers(CustomerQuery.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pQuery" to the service implementation via the service channel.
   */
  private final CustomerQuery query;

  /**
   * Initialize object. All parameters from method "searchCustomers" have to be passed as parameters to this command
   * object.
   * 
   * @param pQuery CustomerQuery
   */
  SearchCustomers_CustomerQuery_AccountingService_Command( CustomerQuery pQuery ) {
    super(AccountingService.class);
    query = pQuery;
    parameters = new Object[] { query };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   * 
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    AccountingService lService = (AccountingService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.searchCustomers(query);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   * 
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   * 
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}
