/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.impl;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.api.ServiceInvocationContext;
import com.anaptecs.jeaf.core.spi.ServiceImplementation;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.spring.service.RESTProductService;

/**
 * Implementation of RESTProductService.
 */
abstract class RESTProductServiceImplBase implements RESTProductService, ServiceImplementation {
  /*
   * The following constants define the names of all authorization types of the service.
   */
  public static final String CREATECHANNELCODE_AUTH_TYPE =
      "createChannelCode.com.anaptecs.spring.service.RESTProductService";

  public static final String CREATEPRODUCT_AUTH_TYPE = "createProduct.com.anaptecs.spring.service.RESTProductService";

  public static final String GETPRODUCTS_AUTH_TYPE = "getProducts.com.anaptecs.spring.service.RESTProductService";

  public static final String GETPRODUCT_AUTH_TYPE = "getProduct.com.anaptecs.spring.service.RESTProductService";

  public static final String GETSORTIMENT_AUTH_TYPE = "getSortiment.com.anaptecs.spring.service.RESTProductService";

  public static final String GETSUPPORTEDCURRENCIESASYNC_AUTH_TYPE =
      "getSupportedCurrenciesAsync.com.anaptecs.spring.service.RESTProductService";

  public static final String GETSUPPORTEDCURRENCIES_AUTH_TYPE =
      "getSupportedCurrencies.com.anaptecs.spring.service.RESTProductService";

  public static final String PING_AUTH_TYPE = "ping.com.anaptecs.spring.service.RESTProductService";

  public static final String PROCESSCOMPLEXBOOKINGID_AUTH_TYPE =
      "processComplexBookingID.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTBOOKINGIDASHEADERPARAM_AUTH_TYPE =
      "testBookingIDAsHeaderParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTBOOKINGIDASPATHPARAM_AUTH_TYPE =
      "testBookingIDAsPathParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTCOOKIEPARAMS_AUTH_TYPE =
      "testCookieParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATATYPEASBEANQUERYPARAM_AUTH_TYPE =
      "testDataTypeAsBeanQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATATYPEASQUERYPARAM_AUTH_TYPE =
      "testDataTypeAsQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATATYPESASHEADERBEANPARAM_AUTH_TYPE =
      "testDataTypesAsHeaderBeanParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATATYPESASHEADERPARAM_AUTH_TYPE =
      "testDataTypesAsHeaderParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATEHEADERPARAMSBEAN_AUTH_TYPE =
      "testDateHeaderParamsBean.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATEHEADERPARAMS_AUTH_TYPE =
      "testDateHeaderParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATEQUERYPARAMSBEAN_AUTH_TYPE =
      "testDateQueryParamsBean.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTDATEQUERYPARAMS_AUTH_TYPE =
      "testDateQueryParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTENUMHEADERPARAMS_AUTH_TYPE =
      "testEnumHeaderParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTENUMPARAMS_AUTH_TYPE = "testEnumParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTINIT_AUTH_TYPE = "testInit.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTMULITVALUEDDATATYPEASBEANQUERYPARAM_AUTH_TYPE =
      "testMulitvaluedDataTypeAsBeanQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTMULITVALUEDDATATYPEASQUERYPARAM_AUTH_TYPE =
      "testMulitvaluedDataTypeAsQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTMULTIVALUEDHEADERFIELDSINBEANPARAM_AUTH_TYPE =
      "testMultiValuedHeaderFieldsInBeanParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTMULTIVALUEDHEADERFIELDS_AUTH_TYPE =
      "testMultiValuedHeaderFields.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTMULTIVALUEDQUERYPARAMSBEAN_AUTH_TYPE =
      "testMultivaluedQueryParamsBean.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTOPTIONALQUERYPARAMS_AUTH_TYPE =
      "testOptionalQueryParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTPARAMS_AUTH_TYPE = "testParams.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTPRIMITIVEARRAYASQUERYPARAM_AUTH_TYPE =
      "testPrimitiveArrayAsQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTPRIMITIVEARRAYS_AUTH_TYPE =
      "testPrimitiveArrays.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTPRIMITIVEWRAPPERARRAYASQUERYPARAM_AUTH_TYPE =
      "testPrimitiveWrapperArrayAsQueryParam.com.anaptecs.spring.service.RESTProductService";

  public static final String TESTSIMPLETYPESASQUERYPARAMS_AUTH_TYPE =
      "testSimpleTypesAsQueryParams.com.anaptecs.spring.service.RESTProductService";

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
  RESTProductServiceImplBase( Component pComponent ) {
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
    return RESTProductService.class;
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