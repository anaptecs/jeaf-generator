/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.info.VersionInfo;

/**
 * Application exception that is used in order to indicate application specific problems.
 * 
 * @see com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException
 */
public final class InterceptorTestApplicationException extends ApplicationException {
  /**
   * Generated serial version uid for this class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor initializes this application exception with the passed error code.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   */
  public InterceptorTestApplicationException( ErrorCode pErrorCode ) {
    super(pErrorCode);
  }

  /**
   * Constructor initializes this application exception with the passed error code and message parameters.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pMessageParameters String array contains all values that are used to create a parameterized error message.
   * The message parameters usually describe the concrete context in which the exception occurred. The parameter may be
   * null.
   */
  public InterceptorTestApplicationException( ErrorCode pErrorCode, String... pMessageParameters ) {
    super(pErrorCode, pMessageParameters);
  }

  /**
   * Constructor initializes this application exception with the passed error code and Throwable object that caused this
   * exception.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pCause Throwable object that caused this exception. The parameter may be null.
   */
  public InterceptorTestApplicationException( ErrorCode pErrorCode, Throwable pCause ) {
    super(pErrorCode, pCause);
  }

  /**
   * Constructor initializes this application exception with the passed error code, message parameters and Throwable
   * object that caused this exception.
   * 
   * @param pErrorCode Error code identifying the occurred problem. Among other things the error code is used to
   * determine the corresponding error message. The parameter must not be null.
   * @param pCause Throwable object that caused this exception. The parameter may be null.
   * @param pMessageParameters String array contains all values that are used to create a parameterized error message.
   * The message parameters usually describe the concrete context in which the exception occurred. The parameter may be
   * null.
   */
  public InterceptorTestApplicationException( ErrorCode pErrorCode, Throwable pCause, String... pMessageParameters ) {
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