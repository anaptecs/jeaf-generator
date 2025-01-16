/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * ServiceProxy class for JEAF service ValidationTestService.
 */
public final class ValidationTestServiceProxy extends ServiceProxy implements ValidationTestService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public ValidationTestServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(ValidationTestService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.ValidationTestService#validateInNOutput}
   */
  public String validateInNOutput( @NotNull String pString1, @NotEmpty String pString2 ) {
    try {
      Command lCommand = new ValidateInNOutput_String_String_ValidationTestService_Command(pString1, pString2);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.core.ValidationTestService#notValidOutput}
   */
  public String notValidOutput( String pString1, @NotEmpty String pString2 ) {
    try {
      Command lCommand = new NotValidOutput_String_String_ValidationTestService_Command(pString1, pString2);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.ValidationTestService#validateOutputOnly}
   */
  public String validateOutputOnly( String pString1, String pString2 ) {
    try {
      Command lCommand = new ValidateOutputOnly_String_String_ValidationTestService_Command(pString1, pString2);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.ValidationTestService#validateInputOnly}
   */
  public String validateInputOnly( String pString1, @Min(value = 4711) int pInteger ) {
    try {
      Command lCommand = new ValidateInputOnly_String_int_ValidationTestService_Command(pString1, pInteger);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.ValidationTestService#noMethodValidation}
   */
  public String noMethodValidation( String pString1, boolean pBool ) {
    try {
      Command lCommand = new NoMethodValidation_String_Boolean_ValidationTestService_Command(pString1, pBool);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.ValidationTestService#createValidationTestObject}
   */
  public void createValidationTestObject( @Valid ValidationTestObject pTestObject ) {
    try {
      Command lCommand = new CreateValidationTestObject_ValidationTestObject_ValidationTestService_Command(pTestObject);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "validateInNOutput".
 */
final class ValidateInNOutput_String_String_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("validateInNOutput", String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "validateInNOutput(String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pString1" to the service implementation via the service channel.
   */
  private final String string1;

  /**
   * Attribute transports the method parameter "pString2" to the service implementation via the service channel.
   */
  private final String string2;

  /**
   * Initialize object. All parameters from method "validateInNOutput" have to be passed as parameters to this command
   * object.
   *
   * @param pString1 String
   * @param pString2 String
   */
  ValidateInNOutput_String_String_ValidationTestService_Command( String pString1, String pString2 ) {
    super(ValidationTestService.class);
    string1 = pString1;
    string2 = pString2;
    parameters = new Object[] { string1, string2 };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.validateInNOutput(string1, string2);
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
 * Generated command class for service method "notValidOutput".
 */
final class NotValidOutput_String_String_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("notValidOutput", String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "notValidOutput(String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pString1" to the service implementation via the service channel.
   */
  private final String string1;

  /**
   * Attribute transports the method parameter "pString2" to the service implementation via the service channel.
   */
  private final String string2;

  /**
   * Initialize object. All parameters from method "notValidOutput" have to be passed as parameters to this command
   * object.
   *
   * @param pString1 String
   * @param pString2 String
   */
  NotValidOutput_String_String_ValidationTestService_Command( String pString1, String pString2 ) {
    super(ValidationTestService.class);
    string1 = pString1;
    string2 = pString2;
    parameters = new Object[] { string1, string2 };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.notValidOutput(string1, string2);
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
 * Generated command class for service method "validateOutputOnly".
 */
final class ValidateOutputOnly_String_String_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("validateOutputOnly", String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "validateOutputOnly(String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pString1" to the service implementation via the service channel.
   */
  private final String string1;

  /**
   * Attribute transports the method parameter "pString2" to the service implementation via the service channel.
   */
  private final String string2;

  /**
   * Initialize object. All parameters from method "validateOutputOnly" have to be passed as parameters to this command
   * object.
   *
   * @param pString1 String
   * @param pString2 String
   */
  ValidateOutputOnly_String_String_ValidationTestService_Command( String pString1, String pString2 ) {
    super(ValidationTestService.class);
    string1 = pString1;
    string2 = pString2;
    parameters = new Object[] { string1, string2 };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.validateOutputOnly(string1, string2);
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
 * Generated command class for service method "validateInputOnly".
 */
final class ValidateInputOnly_String_int_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("validateInputOnly", String.class, int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "validateInputOnly(String.class, int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pString1" to the service implementation via the service channel.
   */
  private final String string1;

  /**
   * Attribute transports the method parameter "pInteger" to the service implementation via the service channel.
   */
  private final int integer;

  /**
   * Initialize object. All parameters from method "validateInputOnly" have to be passed as parameters to this command
   * object.
   *
   * @param pString1 String
   * @param pInteger int
   */
  ValidateInputOnly_String_int_ValidationTestService_Command( String pString1, int pInteger ) {
    super(ValidationTestService.class);
    string1 = pString1;
    integer = pInteger;
    parameters = new Object[] { string1, integer };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.validateInputOnly(string1, integer);
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
 * Generated command class for service method "noMethodValidation".
 */
final class NoMethodValidation_String_Boolean_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("noMethodValidation", String.class, boolean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "noMethodValidation(String.class, boolean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pString1" to the service implementation via the service channel.
   */
  private final String string1;

  /**
   * Attribute transports the method parameter "pBool" to the service implementation via the service channel.
   */
  private final boolean bool;

  /**
   * Initialize object. All parameters from method "noMethodValidation" have to be passed as parameters to this command
   * object.
   *
   * @param pString1 String
   * @param pBool boolean
   */
  NoMethodValidation_String_Boolean_ValidationTestService_Command( String pString1, boolean pBool ) {
    super(ValidationTestService.class);
    string1 = pString1;
    bool = pBool;
    parameters = new Object[] { string1, bool };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.noMethodValidation(string1, bool);
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
 * Generated command class for service method "createValidationTestObject".
 */
final class CreateValidationTestObject_ValidationTestObject_ValidationTestService_Command extends Command {
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
      SERVICE_METHOD = ValidationTestService.class.getMethod("createValidationTestObject", ValidationTestObject.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ValidationTestService.class.getName(), "createValidationTestObject(ValidationTestObject.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pTestObject" to the service implementation via the service channel.
   */
  private final ValidationTestObject testObject;

  /**
   * Initialize object. All parameters from method "createValidationTestObject" have to be passed as parameters to this
   * command object.
   *
   * @param pTestObject ValidationTestObject
   */
  CreateValidationTestObject_ValidationTestObject_ValidationTestService_Command( ValidationTestObject pTestObject ) {
    super(ValidationTestService.class);
    testObject = pTestObject;
    parameters = new Object[] { testObject };
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
    ValidationTestService lService = (ValidationTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.createValidationTestObject(testObject);
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