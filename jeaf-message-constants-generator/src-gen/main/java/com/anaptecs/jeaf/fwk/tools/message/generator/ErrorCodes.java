package com.anaptecs.jeaf.fwk.tools.message.generator;

import com.anaptecs.jeaf.xfun.annotations.MessageResource;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageID;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class contains message constants for message constant generator.
 *
 * @author JEAF Development Team
 * @version 1.3
 */
@MessageResource(path = "GeneratorMessages.xml")
public final class ErrorCodes {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "GeneratorMessages.xml";

  /**
   * Exceptions with this error code are thrown if the style sheet that defines the transformation of the XML document
   * containing error messages is not located within the applications class path.
   */
  public static final ErrorCode STYLESHEET_NOT_AVAILABLE;

  /**
   * Exceptions with this error code are thrown if the generator can not create an output directory for a generated
   * class.
   */
  public static final ErrorCode UNABLE_TO_CREATE_DIR;

  /**
   * Exceptions with this error code are thrown if an exception occurs during the generation of the Java class using
   * XSLT.
   */
  public static final ErrorCode UNABLE_TO_PERFORM_TRANSFORMATION;

  /**
   * Exceptions with this error code are thrown if an exception occurs during the generation of the Java class using
   * XSLT.
   */
  public static final ErrorCode INVALID_CLASS_INFO;

  /**
   * Exceptions with this error code are thrown when an exception occurs when trying to open an Excel workbook.
   */
  public static final ErrorCode UNABLE_TO_OPEN_EXCEL_WORKBOOK;

  /**
   * Exceptions with this error code are thrown when an exception occurs when trying to close an Excel workbook.
   */
  public static final ErrorCode UNABLE_TO_CLOSE_EXCEL_WORKBOOK;

  /**
   * Exceptions with this error code are thrown if class info is missing in the provided Excel workbook.
   */
  public static final ErrorCode CLASS_INFO_SHEET_MISSING;

  /**
   * Exceptions with this error code are thrown if a new XML document could not be created.
   */
  public static final ErrorCode UNABLE_TO_CREATE_XML_DOCUMENT;

  /**
   * Exceptions with this error code are thrown if a new XML document could not be created.
   */
  public static final ErrorCode NO_MESSAGE_DATA_IN_WORKBOOK;

  /**
   * Exceptions with this error code are thrown if a required column in message data is missing.
   */
  public static final ErrorCode INVALID_MESSAGE_DATA;

  /**
   * Exceptions with this error code are thrown if values for one or more required fields are missing.
   */
  public static final MessageID IGNORING_ROW;

  /**
   * Exceptions with this error code are thrown if a message ID is used multiple times.
   */
  public static final ErrorCode MESSAGE_ID_NOT_UNIQUE;

  /**
   * Exceptions with this error code are thrown if a message name is used multiple times.
   */
  public static final ErrorCode MESSAGE_NAME_NOT_UNIQUE;

  /**
   * Exceptions with this error code are thrown if a message name is used multiple times.
   */
  public static final MessageID IGNORING_EMPTY_SHEET;
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    MessageRepository lRepository = XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    // Handle all info messages.
    IGNORING_ROW = lRepository.getMessageID(910);
    IGNORING_EMPTY_SHEET = lRepository.getMessageID(913);
    // Handle all messages for errors.
    STYLESHEET_NOT_AVAILABLE = lRepository.getErrorCode(900);
    UNABLE_TO_CREATE_DIR = lRepository.getErrorCode(901);
    UNABLE_TO_PERFORM_TRANSFORMATION = lRepository.getErrorCode(902);
    INVALID_CLASS_INFO = lRepository.getErrorCode(903);
    UNABLE_TO_OPEN_EXCEL_WORKBOOK = lRepository.getErrorCode(904);
    UNABLE_TO_CLOSE_EXCEL_WORKBOOK = lRepository.getErrorCode(905);
    CLASS_INFO_SHEET_MISSING = lRepository.getErrorCode(906);
    UNABLE_TO_CREATE_XML_DOCUMENT = lRepository.getErrorCode(907);
    NO_MESSAGE_DATA_IN_WORKBOOK = lRepository.getErrorCode(908);
    INVALID_MESSAGE_DATA = lRepository.getErrorCode(909);
    MESSAGE_ID_NOT_UNIQUE = lRepository.getErrorCode(911);
    MESSAGE_NAME_NOT_UNIQUE = lRepository.getErrorCode(912);
    // Handle all localized strings.
  }

  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private ErrorCodes( ) {
    // Nothing to do.
  }
}