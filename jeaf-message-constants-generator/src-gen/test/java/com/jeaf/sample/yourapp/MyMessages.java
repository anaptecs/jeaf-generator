package com.jeaf.sample.yourapp;

import com.anaptecs.jeaf.xfun.annotations.MessageResource;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class contains constants to test JEAF X-Fun localization mechanism
 *
 * @author JEAF Test Team
 * @version 1.5.x
 */
@MessageResource(path = "test-messages.xml")
public final class MyMessages {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "test-messages.xml";

  /**
   * Info message that a bank account has an insufficent balance.
   */
  @Deprecated
  public static final ErrorCode BANK_BALANCE_NOT_SUFFICIENT;

  /**
   * 
   */
  public static final ErrorCode SOURCE_BANK_ACCOUNT_LOCKED;

  /**
   * 
   */
  public static final ErrorCode INVALID_TARGET_BANK_ACCOUNT;

  /**
   * 
   */
  public static final MessageID TRACE_MESSAGE;

  /**
   * 
   */
  public static final MessageID DEBUG_MESSAGE;

  /**
   * 
   */
  public static final MessageID INFO_MESSAGE;

  /**
   * 
   */
  public static final MessageID WARN_MESSAGE;

  /**
   * 
   */
  public static final MessageID ERROR_MESSAGE;

  /**
   * 
   */
  public static final MessageID FATAL_MESSAGE;
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    MessageRepository lRepository = XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    // Handle all info messages.
    TRACE_MESSAGE = lRepository.getMessageID(20003);
    DEBUG_MESSAGE = lRepository.getMessageID(20004);
    INFO_MESSAGE = lRepository.getMessageID(20005);
    WARN_MESSAGE = lRepository.getMessageID(20006);
    ERROR_MESSAGE = lRepository.getMessageID(20007);
    FATAL_MESSAGE = lRepository.getMessageID(20008);
    // Handle all messages for errors.
    BANK_BALANCE_NOT_SUFFICIENT = lRepository.getErrorCode(20000);
    SOURCE_BANK_ACCOUNT_LOCKED = lRepository.getErrorCode(20001);
    INVALID_TARGET_BANK_ACCOUNT = lRepository.getErrorCode(20002);
    // Handle all localized strings.
  }

  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private MyMessages( ) {
    // Nothing to do.
  }
}