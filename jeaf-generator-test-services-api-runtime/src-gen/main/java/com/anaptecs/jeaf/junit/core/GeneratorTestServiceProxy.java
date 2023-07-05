/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.junit.otherpackage.Input;
import com.anaptecs.jeaf.junit.otherpackage.Output;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * ServiceProxy class for JEAF service GeneratorTestService.
 */
public final class GeneratorTestServiceProxy extends ServiceProxy implements GeneratorTestService, ParentService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public GeneratorTestServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(GeneratorTestService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#processSimpleDatatypes}
   */
  public void processSimpleDatatypes( SimpleDatatypeServiceObject pDatatypes ) {
    try {
      Command lCommand =
          new ProcessSimpleDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command(pDatatypes);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#convertToWrapperDatatypes}
   */
  public WrapperDatatypeServiceObject convertToWrapperDatatypes( SimpleDatatypeServiceObject pSimpleTypes ) {
    try {
      Command lCommand =
          new ConvertToWrapperDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command(pSimpleTypes);
      return (WrapperDatatypeServiceObject) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#convertToSimpleDatatypes}
   */
  public SimpleDatatypeServiceObject convertToSimpleDatatypes( WrapperDatatypeServiceObject pWrapperTypes ) {
    try {
      Command lCommand =
          new ConvertToSimpleDatatypes_WrapperDatatypeServiceObject_GeneratorTestService_Command(pWrapperTypes);
      return (SimpleDatatypeServiceObject) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitivesAsParameter}
   */
  public boolean testPrimitivesAsParameter( int pInteger, byte[] pByteArray, double pDoubleValue ) {
    try {
      Command lCommand = new TestPrimitivesAsParameter_int_byte_double_GeneratorTestService_Command(pInteger,
          pByteArray, pDoubleValue);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testGenericsAsParameter}
   */
  public void testGenericsAsParameter( Set<SimpleDatatypeServiceObject> pSimpleObjects ) {
    try {
      Command lCommand =
          new TestGenericsAsParameter_SimpleDatatypeServiceObject_GeneratorTestService_Command(pSimpleObjects);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testGenericsAsResult}
   */
  @SuppressWarnings("unchecked")
  public Set<SimpleDatatypeServiceObject> testGenericsAsResult( ) {
    try {
      Command lCommand = new TestGenericsAsResult_GeneratorTestService_Command();
      return (Set<SimpleDatatypeServiceObject>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#doWhatIMean}
   */
  public void doWhatIMean( int pParam1 ) {
    try {
      Command lCommand = new DoWhatIMean_int_GeneratorTestService_Command(pParam1);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#doWhatIMean}
   */
  public void doWhatIMean( ) {
    try {
      Command lCommand = new DoWhatIMean_GeneratorTestService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#doWhatIMean}
   */
  public void doWhatIMean( Double pParam1 ) {
    try {
      Command lCommand = new DoWhatIMean_Double_GeneratorTestService_Command(pParam1);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#doWithObjectsFromOtherPAckages}
   */
  @SuppressWarnings("unchecked")
  public Set<Output> doWithObjectsFromOtherPAckages( Input pInput ) {
    try {
      Command lCommand = new DoWithObjectsFromOtherPAckages_Input_GeneratorTestService_Command(pInput);
      return (Set<Output>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimiveIntResult}
   */
  public int testPrimiveIntResult( ) {
    try {
      Command lCommand = new TestPrimiveIntResult_GeneratorTestService_Command();
      return (int) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitiveBooleanResult}
   */
  public boolean testPrimitiveBooleanResult( ) {
    try {
      Command lCommand = new TestPrimitiveBooleanResult_GeneratorTestService_Command();
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitiveShortResult}
   */
  public short testPrimitiveShortResult( ) {
    try {
      Command lCommand = new TestPrimitiveShortResult_GeneratorTestService_Command();
      return (short) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitveByteResult}
   */
  public byte testPrimitveByteResult( ) {
    try {
      Command lCommand = new TestPrimitveByteResult_GeneratorTestService_Command();
      return (byte) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitiveCharResult}
   */
  public char testPrimitiveCharResult( ) {
    try {
      Command lCommand = new TestPrimitiveCharResult_GeneratorTestService_Command();
      return (char) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitiveLongResult}
   */
  public long testPrimitiveLongResult( ) {
    try {
      Command lCommand = new TestPrimitiveLongResult_GeneratorTestService_Command();
      return (long) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitiveFloatResult}
   */
  public float testPrimitiveFloatResult( ) {
    try {
      Command lCommand = new TestPrimitiveFloatResult_GeneratorTestService_Command();
      return (float) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.core.GeneratorTestService#testPrimitveDoubleResult}
   */
  public double testPrimitveDoubleResult( ) {
    try {
      Command lCommand = new TestPrimitveDoubleResult_GeneratorTestService_Command();
      return (double) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link ParentService#parentServiceMethod}
   */
  public void parentServiceMethod( ) {
    try {
      Command lCommand = new ParentServiceMethod_ParentService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "processSimpleDatatypes".
 */
final class ProcessSimpleDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command extends Command {
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
          GeneratorTestService.class.getMethod("processSimpleDatatypes", SimpleDatatypeServiceObject.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "processSimpleDatatypes(SimpleDatatypeServiceObject.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pDatatypes" to the service implementation via the service channel.
   */
  private final SimpleDatatypeServiceObject datatypes;

  /**
   * Initialize object. All parameters from method "processSimpleDatatypes" have to be passed as parameters to this
   * command object.
   *
   * @param pDatatypes SimpleDatatypeServiceObject
   */
  ProcessSimpleDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command(
      SimpleDatatypeServiceObject pDatatypes ) {
    super(GeneratorTestService.class);
    datatypes = pDatatypes;
    parameters = new Object[] { datatypes };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.processSimpleDatatypes(datatypes);
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
 * Generated command class for service method "convertToWrapperDatatypes".
 */
final class ConvertToWrapperDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command extends Command {
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
          GeneratorTestService.class.getMethod("convertToWrapperDatatypes", SimpleDatatypeServiceObject.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "convertToWrapperDatatypes(SimpleDatatypeServiceObject.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pSimpleTypes" to the service implementation via the service channel.
   */
  private final SimpleDatatypeServiceObject simpleTypes;

  /**
   * Initialize object. All parameters from method "convertToWrapperDatatypes" have to be passed as parameters to this
   * command object.
   *
   * @param pSimpleTypes SimpleDatatypeServiceObject
   */
  ConvertToWrapperDatatypes_SimpleDatatypeServiceObject_GeneratorTestService_Command(
      SimpleDatatypeServiceObject pSimpleTypes ) {
    super(GeneratorTestService.class);
    simpleTypes = pSimpleTypes;
    parameters = new Object[] { simpleTypes };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.convertToWrapperDatatypes(simpleTypes);
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
 * Generated command class for service method "convertToSimpleDatatypes".
 */
final class ConvertToSimpleDatatypes_WrapperDatatypeServiceObject_GeneratorTestService_Command extends Command {
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
          GeneratorTestService.class.getMethod("convertToSimpleDatatypes", WrapperDatatypeServiceObject.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "convertToSimpleDatatypes(WrapperDatatypeServiceObject.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pWrapperTypes" to the service implementation via the service channel.
   */
  private final WrapperDatatypeServiceObject wrapperTypes;

  /**
   * Initialize object. All parameters from method "convertToSimpleDatatypes" have to be passed as parameters to this
   * command object.
   *
   * @param pWrapperTypes WrapperDatatypeServiceObject
   */
  ConvertToSimpleDatatypes_WrapperDatatypeServiceObject_GeneratorTestService_Command(
      WrapperDatatypeServiceObject pWrapperTypes ) {
    super(GeneratorTestService.class);
    wrapperTypes = pWrapperTypes;
    parameters = new Object[] { wrapperTypes };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.convertToSimpleDatatypes(wrapperTypes);
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
 * Generated command class for service method "testPrimitivesAsParameter".
 */
final class TestPrimitivesAsParameter_int_byte_double_GeneratorTestService_Command extends Command {
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
          GeneratorTestService.class.getMethod("testPrimitivesAsParameter", int.class, byte[].class, double.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitivesAsParameter(int.class, byte[].class, double.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pInteger" to the service implementation via the service channel.
   */
  private final int integer;

  /**
   * Attribute transports the method parameter "pByteArray" to the service implementation via the service channel.
   */
  private final byte[] byteArray;

  /**
   * Attribute transports the method parameter "pDoubleValue" to the service implementation via the service channel.
   */
  private final double doubleValue;

  /**
   * Initialize object. All parameters from method "testPrimitivesAsParameter" have to be passed as parameters to this
   * command object.
   *
   * @param pInteger int
   * @param pByteArray byte[]
   * @param pDoubleValue double
   */
  TestPrimitivesAsParameter_int_byte_double_GeneratorTestService_Command( int pInteger, byte[] pByteArray,
      double pDoubleValue ) {
    super(GeneratorTestService.class);
    integer = pInteger;
    byteArray = pByteArray;
    doubleValue = pDoubleValue;
    parameters = new Object[] { integer, byteArray, doubleValue };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitivesAsParameter(integer, byteArray, doubleValue);
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
 * Generated command class for service method "testGenericsAsParameter".
 */
final class TestGenericsAsParameter_SimpleDatatypeServiceObject_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testGenericsAsParameter", Set.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testGenericsAsParameter(Set.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pSimpleObjects" to the service implementation via the service channel.
   */
  private final Set<SimpleDatatypeServiceObject> simpleObjects;

  /**
   * Initialize object. All parameters from method "testGenericsAsParameter" have to be passed as parameters to this
   * command object.
   *
   * @param pSimpleObjects Set<SimpleDatatypeServiceObject>
   */
  TestGenericsAsParameter_SimpleDatatypeServiceObject_GeneratorTestService_Command(
      Set<SimpleDatatypeServiceObject> pSimpleObjects ) {
    super(GeneratorTestService.class);
    simpleObjects = pSimpleObjects;
    parameters = new Object[] { simpleObjects };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testGenericsAsParameter(simpleObjects);
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
 * Generated command class for service method "testGenericsAsResult".
 */
final class TestGenericsAsResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testGenericsAsResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testGenericsAsResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testGenericsAsResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestGenericsAsResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testGenericsAsResult();
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
 * Generated command class for service method "doWhatIMean".
 */
final class DoWhatIMean_int_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("doWhatIMean", int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "doWhatIMean(int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParam1" to the service implementation via the service channel.
   */
  private final int param1;

  /**
   * Initialize object. All parameters from method "doWhatIMean" have to be passed as parameters to this command object.
   *
   * @param pParam1 int
   */
  DoWhatIMean_int_GeneratorTestService_Command( int pParam1 ) {
    super(GeneratorTestService.class);
    param1 = pParam1;
    parameters = new Object[] { param1 };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.doWhatIMean(param1);
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
 * Generated command class for service method "doWhatIMean".
 */
final class DoWhatIMean_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("doWhatIMean");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "doWhatIMean(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "doWhatIMean" have to be passed as parameters to this command object.
   *
   *
   */
  DoWhatIMean_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.doWhatIMean();
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
 * Generated command class for service method "doWhatIMean".
 */
final class DoWhatIMean_Double_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("doWhatIMean", Double.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "doWhatIMean(Double.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParam1" to the service implementation via the service channel.
   */
  private final Double param1;

  /**
   * Initialize object. All parameters from method "doWhatIMean" have to be passed as parameters to this command object.
   *
   * @param pParam1 Double
   */
  DoWhatIMean_Double_GeneratorTestService_Command( Double pParam1 ) {
    super(GeneratorTestService.class);
    param1 = pParam1;
    parameters = new Object[] { param1 };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.doWhatIMean(param1);
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
 * Generated command class for service method "doWithObjectsFromOtherPAckages".
 */
final class DoWithObjectsFromOtherPAckages_Input_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("doWithObjectsFromOtherPAckages", Input.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "doWithObjectsFromOtherPAckages(Input.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pInput" to the service implementation via the service channel.
   */
  private final Input input;

  /**
   * Initialize object. All parameters from method "doWithObjectsFromOtherPAckages" have to be passed as parameters to
   * this command object.
   *
   * @param pInput Input
   */
  DoWithObjectsFromOtherPAckages_Input_GeneratorTestService_Command( Input pInput ) {
    super(GeneratorTestService.class);
    input = pInput;
    parameters = new Object[] { input };
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.doWithObjectsFromOtherPAckages(input);
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
 * Generated command class for service method "testPrimiveIntResult".
 */
final class TestPrimiveIntResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimiveIntResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimiveIntResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimiveIntResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimiveIntResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimiveIntResult();
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
 * Generated command class for service method "testPrimitiveBooleanResult".
 */
final class TestPrimitiveBooleanResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitiveBooleanResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitiveBooleanResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitiveBooleanResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitiveBooleanResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveBooleanResult();
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
 * Generated command class for service method "testPrimitiveShortResult".
 */
final class TestPrimitiveShortResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitiveShortResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitiveShortResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitiveShortResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitiveShortResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveShortResult();
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
 * Generated command class for service method "testPrimitveByteResult".
 */
final class TestPrimitveByteResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitveByteResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitveByteResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitveByteResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitveByteResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitveByteResult();
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
 * Generated command class for service method "testPrimitiveCharResult".
 */
final class TestPrimitiveCharResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitiveCharResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitiveCharResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitiveCharResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitiveCharResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveCharResult();
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
 * Generated command class for service method "testPrimitiveLongResult".
 */
final class TestPrimitiveLongResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitiveLongResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitiveLongResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitiveLongResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitiveLongResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveLongResult();
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
 * Generated command class for service method "testPrimitiveFloatResult".
 */
final class TestPrimitiveFloatResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitiveFloatResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitiveFloatResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitiveFloatResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitiveFloatResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveFloatResult();
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
 * Generated command class for service method "testPrimitveDoubleResult".
 */
final class TestPrimitveDoubleResult_GeneratorTestService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("testPrimitveDoubleResult");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "testPrimitveDoubleResult(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testPrimitveDoubleResult" have to be passed as parameters to this
   * command object.
   *
   *
   */
  TestPrimitveDoubleResult_GeneratorTestService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitveDoubleResult();
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
 * Generated command class for service method "parentServiceMethod".
 */
final class ParentServiceMethod_ParentService_Command extends Command {
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
      SERVICE_METHOD = GeneratorTestService.class.getMethod("parentServiceMethod");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          GeneratorTestService.class.getName(), "parentServiceMethod(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "parentServiceMethod" have to be passed as parameters to this command
   * object.
   *
   *
   */
  ParentServiceMethod_ParentService_Command( ) {
    super(GeneratorTestService.class);
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
    GeneratorTestService lService = (GeneratorTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.parentServiceMethod();
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
