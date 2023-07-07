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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#createAccount}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#getAccount}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#lockAccount}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#unlock}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#performBooking}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#createCustomer}
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
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#getCustomer}
   */
  public Customer getCustomer( ServiceObjectID pCustomerID, CustomerLoadStrategy pLoadStrategy ) {
    try {
      Command lCommand =
          new GetCustomer_ServiceObjectID_CustomerLoadStrategy_AccountingService_Command(pCustomerID, pLoadStrategy);
      return (Customer) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#createPerson}
   */
  public Person createPerson( @Valid Person pPerson ) {
    try {
      Command lCommand = new CreatePerson_Person_AccountingService_Command(pPerson);
      return (Person) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.accounting.AccountingService#searchCustomers}
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
final class GetCustomer_ServiceObjectID_CustomerLoadStrategy_AccountingService_Command extends Command {
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
      SERVICE_METHOD =
          AccountingService.class.getMethod("getCustomer", ServiceObjectID.class, CustomerLoadStrategy.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          AccountingService.class.getName(), "getCustomer(ServiceObjectID.class, CustomerLoadStrategy.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCustomerID" to the service implementation via the service channel.
   */
  private final ServiceObjectID customerID;

  /**
   * Attribute transports the method parameter "pLoadStrategy" to the service implementation via the service channel.
   */
  private final CustomerLoadStrategy loadStrategy;

  /**
   * Initialize object. All parameters from method "getCustomer" have to be passed as parameters to this command object.
   *
   * @param pCustomerID ServiceObjectID
   * @param pLoadStrategy CustomerLoadStrategy
   */
  GetCustomer_ServiceObjectID_CustomerLoadStrategy_AccountingService_Command( ServiceObjectID pCustomerID,
      CustomerLoadStrategy pLoadStrategy ) {
    super(AccountingService.class);
    customerID = pCustomerID;
    loadStrategy = pLoadStrategy;
    parameters = new Object[] { customerID, loadStrategy };
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
    Serializable lResult = (Serializable) lService.getCustomer(customerID, loadStrategy);
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
  CreatePerson_Person_AccountingService_Command( @Valid Person pPerson ) {
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
