/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
// @Something

@JEAFCustomAnnotationTest
public interface MailTestService extends Service {
  /**
   * Test of method createMessage(). Creates an empty MimeMessage.
   */
  @JEAFCustomAnnotationTest
  void testCreateEmptyMessage( );

  /**
   * Test of method createMessage( String pContent, String pSubject, Set<Address> pRecipients ).<br/>
   * Creates a MimeMessage filled with the content, subject and recipients specified within the parameters.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @JEAFCustomAnnotationTest
  void testCreateFilledMessage( @JEAFCustomAnnotationTest String pAddress, @JEAFCustomAnnotationTest String pPersonal,
      @JEAFCustomAnnotationTest String pCharSet, @JEAFCustomAnnotationTest String pContent,
      @JEAFCustomAnnotationTest String pSubject );

  /**
   * Test of method sendMail( Message pMessage ).<br/>
   * Starts a local SMTPServer, creates a MimeMessage and tries to send it to the SMTPServer.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @JEAFCustomAnnotationTest
  void testSendMail( @JEAFCustomAnnotationTest String pAddress, @JEAFCustomAnnotationTest String pPersonal,
      @JEAFCustomAnnotationTest String pCharSet, @JEAFCustomAnnotationTest String pContent,
      @JEAFCustomAnnotationTest String pSubject );

  /**
   * Test of method sendMail( String pContent, String pSubject, Set<Address> pRecipients ).<br/>
   * Starts a local SMTPServer and tries to send a Message to the SMTPServer using the given parameters.
   *
   * @param pAddress
   * @param pPersonal
   * @param pCharSet
   * @param pContent
   * @param pSubject
   */
  @JEAFCustomAnnotationTest
  void testExtendedSendMail( @JEAFCustomAnnotationTest String pAddress, @JEAFCustomAnnotationTest String pPersonal,
      @JEAFCustomAnnotationTest String pCharSet, @JEAFCustomAnnotationTest String pContent,
      @JEAFCustomAnnotationTest String pSubject );
}