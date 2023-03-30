/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;

public interface MailTestService extends Service {
  /**
   * Test of method createMessage(). Creates an empty MimeMessage.
   */
  void testCreateEmptyMessage( );

  /**
   * Test of method createMessage( String pContent, String pSubject, Set<Address> pRecipients ). <br/>
   * Creates a MimeMessage filled with the content, subject and recipients specified within the parameters.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  void testCreateFilledMessage( String pAddress, String pPersonal, String pCharSet, String pContent, String pSubject );

  /**
   * Test of method sendMail( Message pMessage ). <br/>
   * Starts a local SMTPServer, creates a MimeMessage and tries to send it to the SMTPServer.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  void testSendMail( String pAddress, String pPersonal, String pCharSet, String pContent, String pSubject );

  /**
   * Test of method sendMail( String pContent, String pSubject, Set<Address> pRecipients ). <br/>
   * Starts a local SMTPServer and tries to send a Message to the SMTPServer using the given parameters.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  void testExtendedSendMail( String pAddress, String pPersonal, String pCharSet, String pContent, String pSubject );
}