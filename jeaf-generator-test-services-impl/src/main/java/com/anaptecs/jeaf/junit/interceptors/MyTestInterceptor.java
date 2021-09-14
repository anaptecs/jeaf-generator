/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.junit.interceptors;

import com.anaptecs.jeaf.core.spi.ServiceCall;
import com.anaptecs.jeaf.core.spi.ServiceChannelInterceptor;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.SystemException;

public class MyTestInterceptor implements ServiceChannelInterceptor {
  /**
   * Static field counts the number of pre service call invocations.
   */
  public static int preInvocations = 0;

  /**
   * Static field counts the number of post service call invocations without any exceptions.
   */
  public static int postInvocations = 0;

  /**
   * Static field counts the number of post service call invocations where runtime exceptions were thrown.
   */
  public static int postInvocationsRTE = 0;

  /**
   * Static field counts the number of post service call invocations where errors were thrown.
   */
  public static int postInvocationsERR = 0;

  /**
   * Static field counts the number of post service call invocations where application exceptions were thrown.
   */
  public static int postInvocationsAPE = 0;

  /**
   * Static field counts the number of post service call invocations where system exceptions were thrown.
   */
  public static int postInvocationsSYE = 0;

  public void preServiceCall( ServiceCall serviceCall ) {
    preInvocations++;
  }

  public void postServiceCall( ServiceCall serviceCall, Object pResult ) {
    postInvocations++;
  }

  public void postServiceCall( ServiceCall serviceCall, RuntimeException runtimeException ) {
    postInvocationsRTE++;
  }

  public void postServiceCall( ServiceCall serviceCall, Error error ) {
    postInvocationsERR++;
  }

  public void postServiceCall( ServiceCall serviceCall, ApplicationException applicationException ) {
    postInvocationsAPE++;
  }

  public void postServiceCall( ServiceCall serviceCall, SystemException systemException ) {
    postInvocationsSYE++;
  }
}
