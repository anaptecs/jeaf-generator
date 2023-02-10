/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.deprecation;

import java.io.Serializable;
import java.lang.reflect.Method;

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
 * ServiceProxy class for JEAF service ServiceWithDeprecations.
 */
public final class ServiceWithDeprecationsProxy extends ServiceProxy implements ServiceWithDeprecations {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public ServiceWithDeprecationsProxy( TransactionBehavior pTransactionBehavior ) {
    super(ServiceWithDeprecations.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method "createSomething".
   * 
   * 
   */
  @Deprecated
  public void createSomething( ) {
    try {
      Command lCommand = new CreateSomething_ServiceWithDeprecations_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "createSomething".
   * 
   * 
   */
  public void createSomething( JustAType pBody, @Deprecated String pHeader, @Deprecated String pQueryParam,
      BeanParamWithDeprecations pContext ) {
    try {
      Command lCommand =
          new CreateSomething_JustAType_String_String_BeanParamWithDeprecations_ServiceWithDeprecations_Command(pBody,
              pHeader, pQueryParam, pContext);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "createSomething".
 */
final class CreateSomething_ServiceWithDeprecations_Command extends Command {
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
      SERVICE_METHOD = ServiceWithDeprecations.class.getMethod("createSomething");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ServiceWithDeprecations.class.getName(), "createSomething(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "createSomething" have to be passed as parameters to this command
   * object.
   * 
   * 
   */
  CreateSomething_ServiceWithDeprecations_Command( ) {
    super(ServiceWithDeprecations.class);
    parameters = new Object[] {};
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
    ServiceWithDeprecations lService = (ServiceWithDeprecations) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.createSomething();
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
 * Generated command class for service method "createSomething".
 */
final class CreateSomething_JustAType_String_String_BeanParamWithDeprecations_ServiceWithDeprecations_Command
    extends Command {
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
      SERVICE_METHOD = ServiceWithDeprecations.class.getMethod("createSomething", JustAType.class, String.class,
          String.class, BeanParamWithDeprecations.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          ServiceWithDeprecations.class.getName(),
          "createSomething(JustAType.class, String.class, String.class, BeanParamWithDeprecations.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBody" to the service implementation via the service channel.
   */
  private final JustAType body;

  /**
   * Attribute transports the method parameter "pHeader" to the service implementation via the service channel.
   */
  private final String header;

  /**
   * Attribute transports the method parameter "pQueryParam" to the service implementation via the service channel.
   */
  private final String queryParam;

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final BeanParamWithDeprecations context;

  /**
   * Initialize object. All parameters from method "createSomething" have to be passed as parameters to this command
   * object.
   * 
   * @param pBody JustAType
   * @param pHeader String
   * @param pQueryParam String
   * @param pContext BeanParamWithDeprecations
   */
  CreateSomething_JustAType_String_String_BeanParamWithDeprecations_ServiceWithDeprecations_Command( JustAType pBody,
      @Deprecated String pHeader, @Deprecated String pQueryParam, BeanParamWithDeprecations pContext ) {
    super(ServiceWithDeprecations.class);
    body = pBody;
    header = pHeader;
    queryParam = pQueryParam;
    context = pContext;
    parameters = new Object[] { body, header, queryParam, context };
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
    ServiceWithDeprecations lService = (ServiceWithDeprecations) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.createSomething(body, header, queryParam, context);
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
