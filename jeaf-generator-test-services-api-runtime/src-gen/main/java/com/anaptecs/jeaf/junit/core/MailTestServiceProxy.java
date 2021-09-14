/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

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
 * ServiceProxy class for JEAF service MailTestService.
 */
public final class MailTestServiceProxy extends ServiceProxy implements MailTestService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public MailTestServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(MailTestService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method "testCreateEmptyMessage".
   * 
   * Test of method createMessage(). Creates an empty MimeMessage.
   */
  public void testCreateEmptyMessage( ) {
    try {
      Command lCommand = new TestCreateEmptyMessage_MailTestService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "testCreateFilledMessage".
   * 
   * Test of method createMessage( String pContent, String pSubject, Set<Address> pRecipients ). Creates a MimeMessage
   * filled with the content, subject and recipients specified within the parameters.
   */
  public void testCreateFilledMessage( String pAddress, String pPersonal, String pCharSet, String pContent,
      String pSubject ) {
    try {
      Command lCommand = new TestCreateFilledMessage_String_String_String_String_String_MailTestService_Command(
          pAddress, pPersonal, pCharSet, pContent, pSubject);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "testSendMail".
   * 
   * Test of method sendMail( Message pMessage ). Starts a local SMTPServer, creates a MimeMessage and tries to send it
   * to the SMTPServer.
   */
  public void testSendMail( String pAddress, String pPersonal, String pCharSet, String pContent, String pSubject ) {
    try {
      Command lCommand = new TestSendMail_String_String_String_String_String_MailTestService_Command(pAddress,
          pPersonal, pCharSet, pContent, pSubject);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method "testExtendedSendMail".
   * 
   * Test of method sendMail( String pContent, String pSubject, Set<Address> pRecipients ). Starts a local SMTPServer
   * and tries to send a Message to the SMTPServer using the given parameters.
   */
  public void testExtendedSendMail( String pAddress, String pPersonal, String pCharSet, String pContent,
      String pSubject ) {
    try {
      Command lCommand = new TestExtendedSendMail_String_String_String_String_String_MailTestService_Command(pAddress,
          pPersonal, pCharSet, pContent, pSubject);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "testCreateEmptyMessage".
 */
final class TestCreateEmptyMessage_MailTestService_Command extends Command {
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
      SERVICE_METHOD = MailTestService.class.getMethod("testCreateEmptyMessage");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, MailTestService.class.getName(),
          "testCreateEmptyMessage(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testCreateEmptyMessage" have to be passed as parameters to this
   * command object.
   * 
   * 
   */
  TestCreateEmptyMessage_MailTestService_Command( ) {
    super(MailTestService.class);
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
    MailTestService lService = (MailTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testCreateEmptyMessage();
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
 * Generated command class for service method "testCreateFilledMessage".
 */
final class TestCreateFilledMessage_String_String_String_String_String_MailTestService_Command extends Command {
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
      SERVICE_METHOD = MailTestService.class.getMethod("testCreateFilledMessage", String.class, String.class,
          String.class, String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, MailTestService.class.getName(),
          "testCreateFilledMessage(String.class, String.class, String.class, String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAddress" to the service implementation via the service channel.
   */
  private final String address;

  /**
   * Attribute transports the method parameter "pPersonal" to the service implementation via the service channel.
   */
  private final String personal;

  /**
   * Attribute transports the method parameter "pCharSet" to the service implementation via the service channel.
   */
  private final String charSet;

  /**
   * Attribute transports the method parameter "pContent" to the service implementation via the service channel.
   */
  private final String content;

  /**
   * Attribute transports the method parameter "pSubject" to the service implementation via the service channel.
   */
  private final String subject;

  /**
   * Initialize object. All parameters from method "testCreateFilledMessage" have to be passed as parameters to this
   * command object.
   * 
   * @param pAddress String
   * @param pPersonal String
   * @param pCharSet String
   * @param pContent String
   * @param pSubject String
   */
  TestCreateFilledMessage_String_String_String_String_String_MailTestService_Command( String pAddress, String pPersonal,
      String pCharSet, String pContent, String pSubject ) {
    super(MailTestService.class);
    address = pAddress;
    personal = pPersonal;
    charSet = pCharSet;
    content = pContent;
    subject = pSubject;
    parameters = new Object[] { address, personal, charSet, content, subject };
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
    MailTestService lService = (MailTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testCreateFilledMessage(address, personal, charSet, content, subject);
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
 * Generated command class for service method "testSendMail".
 */
final class TestSendMail_String_String_String_String_String_MailTestService_Command extends Command {
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
      SERVICE_METHOD = MailTestService.class.getMethod("testSendMail", String.class, String.class, String.class,
          String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, MailTestService.class.getName(),
          "testSendMail(String.class, String.class, String.class, String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAddress" to the service implementation via the service channel.
   */
  private final String address;

  /**
   * Attribute transports the method parameter "pPersonal" to the service implementation via the service channel.
   */
  private final String personal;

  /**
   * Attribute transports the method parameter "pCharSet" to the service implementation via the service channel.
   */
  private final String charSet;

  /**
   * Attribute transports the method parameter "pContent" to the service implementation via the service channel.
   */
  private final String content;

  /**
   * Attribute transports the method parameter "pSubject" to the service implementation via the service channel.
   */
  private final String subject;

  /**
   * Initialize object. All parameters from method "testSendMail" have to be passed as parameters to this command
   * object.
   * 
   * @param pAddress String
   * @param pPersonal String
   * @param pCharSet String
   * @param pContent String
   * @param pSubject String
   */
  TestSendMail_String_String_String_String_String_MailTestService_Command( String pAddress, String pPersonal,
      String pCharSet, String pContent, String pSubject ) {
    super(MailTestService.class);
    address = pAddress;
    personal = pPersonal;
    charSet = pCharSet;
    content = pContent;
    subject = pSubject;
    parameters = new Object[] { address, personal, charSet, content, subject };
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
    MailTestService lService = (MailTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testSendMail(address, personal, charSet, content, subject);
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
 * Generated command class for service method "testExtendedSendMail".
 */
final class TestExtendedSendMail_String_String_String_String_String_MailTestService_Command extends Command {
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
      SERVICE_METHOD = MailTestService.class.getMethod("testExtendedSendMail", String.class, String.class, String.class,
          String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, MailTestService.class.getName(),
          "testExtendedSendMail(String.class, String.class, String.class, String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pAddress" to the service implementation via the service channel.
   */
  private final String address;

  /**
   * Attribute transports the method parameter "pPersonal" to the service implementation via the service channel.
   */
  private final String personal;

  /**
   * Attribute transports the method parameter "pCharSet" to the service implementation via the service channel.
   */
  private final String charSet;

  /**
   * Attribute transports the method parameter "pContent" to the service implementation via the service channel.
   */
  private final String content;

  /**
   * Attribute transports the method parameter "pSubject" to the service implementation via the service channel.
   */
  private final String subject;

  /**
   * Initialize object. All parameters from method "testExtendedSendMail" have to be passed as parameters to this
   * command object.
   * 
   * @param pAddress String
   * @param pPersonal String
   * @param pCharSet String
   * @param pContent String
   * @param pSubject String
   */
  TestExtendedSendMail_String_String_String_String_String_MailTestService_Command( String pAddress, String pPersonal,
      String pCharSet, String pContent, String pSubject ) {
    super(MailTestService.class);
    address = pAddress;
    personal = pPersonal;
    charSet = pCharSet;
    content = pContent;
    subject = pSubject;
    parameters = new Object[] { address, personal, charSet, content, subject };
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
    MailTestService lService = (MailTestService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testExtendedSendMail(address, personal, charSet, content, subject);
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
