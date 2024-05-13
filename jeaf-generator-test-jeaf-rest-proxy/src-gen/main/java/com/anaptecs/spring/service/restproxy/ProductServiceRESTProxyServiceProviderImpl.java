/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.jeaf.RESTRequestExecutorServiceProvider;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.AnotherDataType;
import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;
import com.anaptecs.spring.base.TechnicalHeaderContext;
import com.anaptecs.spring.service.ChildBeanParameterType;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.LocalBeanParamType;
import com.anaptecs.spring.service.ProductService;

/**
 * Class implements a service provider that acts as proxy for REST service {@link ProductService}.
 */
public final class ProductServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, ProductServiceRESTProxyServiceProvider {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  @JEAFServiceProvider
  private RESTRequestExecutorServiceProvider requestExecutor;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Nothing to do.
  }

  /**
   * Method checks state of this service provider implementation.
   *
   * @return {@link HealthCheckResult} Result of the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    return null;
  }

  /**
   * Operation returns all available product.
   *
   * @return {@link List<Product>}
   */
  @Override
  public List<Product> getProducts( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Product.class);
    List<Product> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pProductID
   * @return {@link Product}
   */
  @Override
  public Product getProduct( String pProductID ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/");
    lPathBuilder.append(pProductID);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Product.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pProduct
   * @return boolean
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pProduct as request body.
    lRequestBuilder.setBody(pProduct);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(boolean.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/sortiment/");
    lPathBuilder.append(pContext.getPathParam());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      // First we process custom headers then the explicit ones.
      for (Map.Entry<String, String> lNextEntry : pContext.getCustomHeaders().entrySet()) {
        lRequestBuilder.setHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
      }
      if (pContext.getIntCode() != null) {
        lRequestBuilder.setHeader("intCode", pContext.getIntCode().getCode());
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Sortiment.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/ChannelCode");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pChannelCode as request body.
    lRequestBuilder.setBody(pChannelCode);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(ChannelCode.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   */
  @Override
  public void ping( ) {
    // Create builder for HEAD request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.HEAD, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String deprecatedOperation( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/operation");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/context");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBeanParam
   */
  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/beanParams");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pBeanParam != null) {
      if (pBeanParam.getOldStyle() != null) {
        lRequestBuilder.setQueryParameter("q2", pBeanParam.getOldStyle());
      }
    }
    // Set HTTP header(s)
    if (pBeanParam != null) {
      if (pBeanParam.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pBeanParam.getAccessToken());
      }
      if (pBeanParam.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pBeanParam.getLanguage()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public String deprecatedParams( @Deprecated int pParam1 ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    lRequestBuilder.setHeader("param1", pParam1);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @Override
  public String deprecatedBody( @Deprecated String pBody ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/body");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pBody as request body.
    lRequestBuilder.setBody(pBody);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Override
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/complexBody");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pProduct as request body.
    lRequestBuilder.setBody(pProduct);
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @Override
  public Product deprecatedComplexReturn( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/deprecated/complexReturn");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Product.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext
   */
  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
    // Create builder for PATCH request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.PATCH, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/specific/");
    lPathBuilder.append(pContext.getPathParam());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getQueryParam() != null) {
        lRequestBuilder.setQueryParameter("q1", pContext.getQueryParam());
      }
    }
    // Set HTTP header(s)
    if (pContext != null) {
      // First we process custom headers then the explicit ones.
      for (Map.Entry<String, String> lNextEntry : pContext.getCustomHeaders().entrySet()) {
        lRequestBuilder.setHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
      if (pContext.getAccessToken() != null) {
        lRequestBuilder.setHeader("token", pContext.getAccessToken());
      }
      if (pContext.getLanguage() != null) {
        lRequestBuilder.setHeader("lang", XFun.getDatatypeConverterRegistry().getConverter(Locale.class, String.class)
            .convert(pContext.getLanguage()));
      }
      if (pContext.getIntCode() != null) {
        lRequestBuilder.setHeader("intCode", pContext.getIntCode().getCode());
      }
      if (pContext.getSpecificHeader() != null) {
        lRequestBuilder.setHeader("specificHeader", pContext.getSpecificHeader());
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
      if (pContext.getChannelType() != null) {
        lRequestBuilder.setCookie("Channel-Type", XFun.getDatatypeConverterRegistry()
            .getConverter(ChannelType.class, String.class).convert(pContext.getChannelType()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/ChannelCodeObject");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pChannelCode as request body.
    lRequestBuilder.setBody(pChannelCode);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(ChannelCode.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/currencies");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pCurrencies as request body.
    lRequestBuilder.setBody(pCurrencies);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(CurrencyCode.class);
    List<CurrencyCode> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/currencies/valid");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pCurrency as request body.
    lRequestBuilder.setBody(pCurrency);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(CurrencyCode.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/codeTypeUsages");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pStringCode as request body.
    lRequestBuilder.setBody(pStringCode);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(IntegerCodeType.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/LocalBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pBeanParam != null) {
      if (pBeanParam.getLocalKey() != null) {
        lRequestBuilder.setHeader("localKey", pBeanParam.getLocalKey());
      }
      if (pBeanParam.getLocalID() != null) {
        lRequestBuilder.setHeader("localID", pBeanParam.getLocalID());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pParent
   * @return {@link String}
   */
  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/ExternalBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pParent != null) {
      if (pParent.getNovaKey() != null) {
        lRequestBuilder.setHeader("novaKey", pParent.getNovaKey());
      }
      if (pParent.getTkID() != null) {
        lRequestBuilder.setHeader("tkID", pParent.getTkID());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChild
   * @return {@link String}
   */
  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/ChildBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pChild != null) {
      if (pChild.getNovaKey() != null) {
        lRequestBuilder.setHeader("novaKey", pChild.getNovaKey());
      }
      if (pChild.getTkID() != null) {
        lRequestBuilder.setHeader("tkID", pChild.getTkID());
      }
      if (pChild.getChildProperty() != null) {
        lRequestBuilder.setHeader("X-Child-Property", pChild.getChildProperty());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pPath
   * @param pStartTimestamp
   * @param pStartTime
   * @param pLocalStartTimestamp
   * @param pLocalStartTime
   * @param pLocalStartDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/test-date-query-params/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("startTimestamp", XFun.getDatatypeConverterRegistry()
          .getConverter(OffsetDateTime.class, String.class).convert(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.setQueryParameter("startTime",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetTime.class, String.class).convert(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("localStartTimestamp", XFun.getDatatypeConverterRegistry()
          .getConverter(LocalDateTime.class, String.class).convert(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.setQueryParameter("localStartTime",
          XFun.getDatatypeConverterRegistry().getConverter(LocalTime.class, String.class).convert(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.setQueryParameter("localStartDate",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDate.class, String.class).convert(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setQueryParameter("calendar",
          XFun.getDatatypeConverterRegistry().getConverter(Calendar.class, String.class).convert(pCalendar));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setQueryParameter("utilDate",
          XFun.getDatatypeConverterRegistry().getConverter(java.util.Date.class, String.class).convert(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setQueryParameter("sqlTimestamp",
          XFun.getDatatypeConverterRegistry().getConverter(Timestamp.class, String.class).convert(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.setQueryParameter("sqlTime",
          XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class).convert(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.setQueryParameter("sqlDate",
          XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class).convert(pSQLDate));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pPath
   * @param pQueryParams
   */
  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/test-date-query-params-beans/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pQueryParams != null) {
      if (pQueryParams.getOffsetDateTime() != null) {
        lRequestBuilder.setQueryParameter("offsetDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.setQueryParameter("localDate", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.setQueryParameter("utilDate", XFun.getDatatypeConverterRegistry()
            .getConverter(java.util.Date.class, String.class).convert(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.setQueryParameter("calendar", XFun.getDatatypeConverterRegistry()
            .getConverter(Calendar.class, String.class).convert(pQueryParams.getCalendar()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.setQueryParameter("sqlTimestamp", XFun.getDatatypeConverterRegistry()
            .getConverter(Timestamp.class, String.class).convert(pQueryParams.getSqlTimestamp()));
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.setQueryParameter("sqlTime", XFun.getDatatypeConverterRegistry()
            .getConverter(Time.class, String.class).convert(pQueryParams.getSqlTime()));
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.setQueryParameter("sqlDate", XFun.getDatatypeConverterRegistry()
            .getConverter(Date.class, String.class).convert(pQueryParams.getSqlDate()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pPath
   * @param pOffsetDateTime
   * @param pOffsetTime
   * @param pLocalDateTime
   * @param pLocalTime
   * @param pLocalDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/test-date-header-params/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pOffsetDateTime != null) {
      lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
          .getConverter(OffsetDateTime.class, String.class).convert(pOffsetDateTime));
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time",
          XFun.getDatatypeConverterRegistry().getConverter(OffsetTime.class, String.class).convert(pOffsetTime));
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDateTime.class, String.class).convert(pLocalDateTime));
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time",
          XFun.getDatatypeConverterRegistry().getConverter(LocalTime.class, String.class).convert(pLocalTime));
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date",
          XFun.getDatatypeConverterRegistry().getConverter(LocalDate.class, String.class).convert(pLocalDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          XFun.getDatatypeConverterRegistry().getConverter(Calendar.class, String.class).convert(pCalendar));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date",
          XFun.getDatatypeConverterRegistry().getConverter(java.util.Date.class, String.class).convert(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp",
          XFun.getDatatypeConverterRegistry().getConverter(Timestamp.class, String.class).convert(pSQLTimestamp));
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time",
          XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class).convert(pSQLTime));
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date",
          XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class).convert(pSQLDate));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pPath
   * @param pHeaderParams
   */
  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/test-date-header-params-beans/");
    lPathBuilder.append(pPath);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pHeaderParams != null) {
      if (pHeaderParams.getOffsetDateTime() != null) {
        lRequestBuilder.setHeader("Offset-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pHeaderParams.getOffsetDateTime()));
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pHeaderParams.getOffsetTime()));
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pHeaderParams.getLocalDateTime()));
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pHeaderParams.getLocalTime()));
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pHeaderParams.getLocalDate()));
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date", XFun.getDatatypeConverterRegistry()
            .getConverter(java.util.Date.class, String.class).convert(pHeaderParams.getUtilDate()));
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar", XFun.getDatatypeConverterRegistry()
            .getConverter(Calendar.class, String.class).convert(pHeaderParams.getCalendar()));
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp", XFun.getDatatypeConverterRegistry()
            .getConverter(Timestamp.class, String.class).convert(pHeaderParams.getSqlTimestamp()));
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time", XFun.getDatatypeConverterRegistry().getConverter(Time.class, String.class)
            .convert(pHeaderParams.getSqlTime()));
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", XFun.getDatatypeConverterRegistry().getConverter(Date.class, String.class)
            .convert(pHeaderParams.getSqlDate()));
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @Override
  public String testTechnicalHeaderParam( String pReseller ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/technicalHeaderParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pReseller != null) {
      lRequestBuilder.setHeader("Reseller", pReseller);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testTechnicalHeaderBean( TechnicalHeaderContext pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/technicalHeaderBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pContext != null) {
      // First we process custom headers then the explicit ones.
      for (Map.Entry<String, String> lNextEntry : pContext.getCustomHeaders().entrySet()) {
        lRequestBuilder.setHeader(lNextEntry.getKey(), lNextEntry.getValue());
      }
      if (pContext.getReseller() != null) {
        lRequestBuilder.setHeader("Reseller", pContext.getReseller());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pCodes
   * @return {@link String}
   */
  @Override
  public String processDataTypes( List<AnotherDataType> pCodes ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/product-codes");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (AnotherDataType lNext : pCodes) {
        lValues.add(lNext.getData());
      }
      lRequestBuilder.setQueryParameter("pCodes", lValues);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @return {@link String}
   */
  @Override
  public String getVersionInfo( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("products/info");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }
}
