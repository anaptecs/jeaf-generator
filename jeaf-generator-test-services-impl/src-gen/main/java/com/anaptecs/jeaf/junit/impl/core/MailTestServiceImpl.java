/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of MailTestService.
 */
final class MailTestServiceImpl extends MailTestServiceImplBase {
  /**
   * Initialize object.
   */
  MailTestServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * Test of method createMessage(). Creates an empty MimeMessage.
   * 
   * 
   */
  @Override
  public void testCreateEmptyMessage( ) {
  }

  /**
   * Test of method createMessage( String pContent, String pSubject, Set<Address> pRecipients ). Creates a MimeMessage
   * filled with the content, subject and recipients specified within the parameters.
   * 
   * 
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @Override
  public void testCreateFilledMessage( String pAddress, String pPersonal, String pCharSet, String pContent,
      String pSubject ) {
  }

  /**
   * Test of method sendMail( Message pMessage ). Starts a local SMTPServer, creates a MimeMessage and tries to send it
   * to the SMTPServer.
   * 
   * 
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @Override
  public void testSendMail( String pAddress, String pPersonal, String pCharSet, String pContent, String pSubject ) {
  }

  /**
   * Test of method sendMail( String pContent, String pSubject, Set<Address> pRecipients ). Starts a local SMTPServer
   * and tries to send a Message to the SMTPServer using the given parameters.
   * 
   * 
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @Override
  public void testExtendedSendMail( String pAddress, String pPersonal, String pCharSet, String pContent,
      String pSubject ) {
  }
}