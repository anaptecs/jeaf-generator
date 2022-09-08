/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.junit.openapi.service1.ProductService;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Implementation of ProductService.
 */
abstract class ProductServiceImplBase implements ProductService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String ADDCURRENCIES_AUTH_TYPE =
      "addCurrencies.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String CHECKIBAN_AUTH_TYPE = "checkIBAN.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String CREATECHANNELCODEFROMOBJECT_AUTH_TYPE =
      "createChannelCodeFromObject.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String CREATECHANNELCODE_AUTH_TYPE =
      "createChannelCode.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String CREATEPRODUCT_AUTH_TYPE =
      "createProduct.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDBEANPARAM_AUTH_TYPE =
      "deprecatedBeanParam.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDBODY_AUTH_TYPE =
      "deprecatedBody.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDCOMPLEXRETURN_AUTH_TYPE =
      "deprecatedComplexReturn.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDCONTEXT_AUTH_TYPE =
      "deprecatedContext.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDOPERATION_AUTH_TYPE =
      "deprecatedOperation.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECATEDPARAMS_AUTH_TYPE =
      "deprecatedParams.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String DEPRECTEDCOMPLEXREQUESTBODY_AUTH_TYPE =
      "deprectedComplexRequestBody.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETCHANNELS_AUTH_TYPE =
      "getChannels.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETDEFAULTCHANNEL_AUTH_TYPE =
      "getDefaultChannel.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETPRODUCTS_AUTH_TYPE =
      "getProducts.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETPRODUCT_AUTH_TYPE =
      "getProduct.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETSORTIMENT_AUTH_TYPE =
      "getSortiment.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETSUPPORTEDCURRENCIESASYNC_AUTH_TYPE =
      "getSupportedCurrenciesAsync.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String GETSUPPORTEDCURRENCIES_AUTH_TYPE =
      "getSupportedCurrencies.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String ISCURRENCYSUPPORTED_AUTH_TYPE =
      "isCurrencySupported.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String LOADSPECIFICTHINGS_AUTH_TYPE =
      "loadSpecificThings.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String PING_AUTH_TYPE = "ping.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String TESTCHILDBEANPARAMETER_AUTH_TYPE =
      "testChildBeanParameter.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String TESTCODETYPEUSAGE_AUTH_TYPE =
      "testCodeTypeUsage.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String TESTDATEQUERYPARAMS_AUTH_TYPE =
      "testDateQueryParams.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String TESTEXTERNALBEANPARAMETERTYPE_AUTH_TYPE =
      "testExternalBeanParameterType.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  public static final String TESTLOCALBEANPARAMTYPE_AUTH_TYPE =
      "testLocalBeanParamType.com.anaptecs.jeaf.junit.openapi.service1.ProductService";

  /**
   * Reference to the component that provides this service implementation. The reference is never null.
   */
  private final Component component;

  /**
   * Reference to to trace object of the component to which this service instance belongs to. The reference is never
   * null since the trace object is set in the constructor. The reference is visible to sub classes in order to make
   * tracing as easy as possible.
   */
  final Trace trace;

  /**
   * Initialize object.
   */
  ProductServiceImplBase( Component pComponent ) {
    // Check parameter
    Assert.assertNotNull(pComponent, "pComponent");
    component = pComponent;
    trace = component.getTrace();
  }

  /**
   * Method returns the class object of the service that is implemented by this service instance.
   * 
   * @return Class Class object of the service interface that is implemented by the service instance. The method never
   * returns null.
   * 
   * @see ServiceImplementation#getServiceType()
   */
  public final Class<? extends Service> getServiceType( ) {
    return ProductService.class;
  }

  /**
   * Method returns the service invocation context for the current service call.
   * 
   * @return ServiceInvocationContext Service invocation context for the current call. The method never returns null as
   * long as it is called from within a service call.
   */
  protected final ServiceInvocationContext getCurrentServiceInvocationContext( ) {
    return JEAF.getContext().getServiceInvocationContext();
  }
}