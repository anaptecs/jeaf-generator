/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.util;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.errorhandling.SystemException;
import com.anaptecs.jeaf.xfun.api.info.VersionInfo;

/**
 * System exception that is used by all JEAF tools in order to indicate technical problems.
 * 
 * @author JEAF Development Team
 * @version 1.0
 * 
 * @see com.anaptecs.jeaf.xfun.api.errorhandling.SystemException
 */
public class JEAFToolsSystemException extends SystemException {
  /**
   * Generated serial version uid for this class.
   */
  private static final long serialVersionUID = 6723470330593853877L;

  /**
   * Constructor initializes this system exception with the passed error code.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   */
  public JEAFToolsSystemException( ErrorCode pErrorCode ) {
    super(pErrorCode);
  }

  /**
   * Constructor initializes this system exception with the passed error code and message parameters.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pMessageParameters String array contains all values that are used to create a parameterized error message.
   * The message parameters usually describe the concrete context in which the exception occurred. The parameter may be
   * null.
   */
  public JEAFToolsSystemException( ErrorCode pErrorCode, String... pMessageParameters ) {
    super(pErrorCode, pMessageParameters);
  }

  /**
   * Constructor initializes this system exception with the passed error code and Throwable object that caused this
   * exception.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pCause Throwable object that caused this exception. The parameter may be null.
   */
  public JEAFToolsSystemException( ErrorCode pErrorCode, Throwable pCause ) {
    super(pErrorCode, pCause);
  }

  /**
   * Constructor initializes this system exception with the passed error code, message parameters and Throwable object
   * that caused this exception.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pMessageParameters String array contains all values that are used to create a parameterized error message.
   * The message parameters usably describe the concrete context in which the exception occurred. The parameter may be
   * null.
   * @param pCause Throwable object that caused this exception. The parameter may be null.
   */
  public JEAFToolsSystemException( ErrorCode pErrorCode, Throwable pCause, String... pMessageParameters ) {
    // Call empty constructor of base class.
    super(pErrorCode, pCause, pMessageParameters);
  }

  /**
   * Method resolves the version the JEAF framework.
   * 
   * @return VersionInfo Information about the used JEAF version. The method never returns null.
   */
  protected VersionInfo resolveVersionInfo( ) {
    return XFun.getVersionInfo();
  }
}