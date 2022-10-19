package com.anaptecs.jeaf.generator;

import com.anaptecs.jeaf.xfun.annotations.MessageResource;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageRepository;

/**
 * Class contains message constants for JEAF Generator.
 *
 * @author JEAF Development Team
 * @version 1.3
 */
@MessageResource(path = "AdditionalGeneratorMessages.xml")
public final class ErrorCodes {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "AdditionalGeneratorMessages.xml";

  /**
   * JEAF Generator expects a specific version of the so called JEAF Meta Model (JMM). The JMM version that is used by
   * your UML Model seems to be outdated. Please upgrade to latest version of JMM.
   */
  public static final ErrorCode INVALID_JMM;

  /**
   * When working with OpenAPI and REST there are some restrictions concerning the data types that can be used in Java.
   * This warning tells you that in a specific REST operation a incompatible parameter or return type is used. This will
   * lead to an invalid request / response from an OpenAPI perspective.
   */
  public static final ErrorCode INCOMPATIBLE_OPENAPI_TYPE;

  /**
   * Depending on how you export XMI files from your MagicDraw model it might happen that the files contain information
   * about file systems paths. This should not be an issue on the machine where you exported the files. However, it may
   * lead to problems on other devices or your CI/CD infrastructure where file system paths might not be the same.
   */
  public static final ErrorCode LOCAL_FILE_PATH_IN_XMI;

  /**
   * When working with OpenAPI and REST there are some restrictions concerning the data types that can be used in Java.
   * This warning tells you that in a defined "BeanParam" at least one property uses an incompatible type. This will
   * lead to an invalid request / response from an OpenAPI perspective.
   */
  public static final ErrorCode INCOMAPTIBLE_TYPE_IN_BEAN_PARAM;
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    MessageRepository lRepository = XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    // Handle all info messages.
    // Handle all messages for errors.
    INVALID_JMM = lRepository.getErrorCode(9100);
    INCOMPATIBLE_OPENAPI_TYPE = lRepository.getErrorCode(9101);
    LOCAL_FILE_PATH_IN_XMI = lRepository.getErrorCode(9102);
    INCOMAPTIBLE_TYPE_IN_BEAN_PARAM = lRepository.getErrorCode(9103);
    // Handle all localized strings.
  }

  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private ErrorCodes( ) {
    // Nothing to do.
  }
}