/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.restproxy;

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
import java.util.Set;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.ExtensibleEnum;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
import com.anaptecs.jeaf.junit.openapi.base.LongCode;
import com.anaptecs.jeaf.junit.openapi.base.MultiValuedDataType;
import com.anaptecs.jeaf.junit.openapi.base.NotInlinedBeanParam;
import com.anaptecs.jeaf.junit.openapi.base.ParentBeanParamType;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.ShortCode;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;
import com.anaptecs.jeaf.junit.openapi.base.StringCode;
import com.anaptecs.jeaf.junit.openapi.base.StringCodeType;
import com.anaptecs.jeaf.junit.openapi.service1.ChildBeanParameterType;
import com.anaptecs.jeaf.junit.openapi.service1.DateQueryParamsBean;
import com.anaptecs.jeaf.junit.openapi.service1.LocalBeanParamType;
import com.anaptecs.jeaf.junit.openapi.service1.ProductService;
import com.anaptecs.jeaf.junit.openapi.service1.TechnicalHeaderContext;
import com.anaptecs.jeaf.junit.rest.generics.BusinessServiceObject;
import com.anaptecs.jeaf.junit.rest.generics.GenericPageableResponse;
import com.anaptecs.jeaf.junit.rest.generics.GenericSingleValuedReponse;
import com.anaptecs.jeaf.junit.rest.generics.Offer;
import com.anaptecs.jeaf.junit.rest.generics.Pageable;
import com.anaptecs.jeaf.junit.rest.generics.Response;
import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.TypeReference;
import com.anaptecs.jeaf.rest.executor.api.jeaf.RESTRequestExecutorServiceProvider;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

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
    lPathBuilder.append("/products");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
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
    lPathBuilder.append("/products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pProduct as request body.
    lRequestBuilder.setBody(pProduct);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Boolean.class);
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("sortiment/");
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
   * <p/>
   * <b>Breaking Change with 2.0:</b> Parameter will be mandatory
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("ChannelCode");
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
    lPathBuilder.append("/products");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 202);
  }

  /**
   * @return {@link String}
   * @deprecated This request is no longer supported. (<b>since:</b> 1.1.1, <b>removed with:</b> 2.3)
   */
  @Deprecated
  @Override
  public String deprecatedOperation( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/operation");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/context");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/beanParams");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/params");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/body");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/complexBody");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("deprecated/complexReturn");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("specific/");
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
      if (pContext.getDeprecatedHeader() != null) {
        lRequestBuilder.setHeader("deprecatedHeader", pContext.getDeprecatedHeader().getCode());
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("ChannelCodeObject");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("currencies");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("currencies/valid");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("codeTypeUsages");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pStringCode as request body.
    lRequestBuilder.setBody(pStringCode);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(IntegerCodeType.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 202, lObjectType);
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("LocalBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pBeanParam != null) {
      if (pBeanParam.getLocalKey() != null) {
        lRequestBuilder.setHeader("localKey", pBeanParam.getLocalKey());
      }
      if (pBeanParam.getLocalID() != null) {
        lRequestBuilder.setHeader("localID", pBeanParam.getLocalID());
      }
      if (pBeanParam.getAuthorization() != null) {
        lRequestBuilder.setHeader("authorization", pBeanParam.getAuthorization());
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("ExternalBeanParam");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("ChildBeanParam");
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
   * @param pIBAN
   * @return boolean
   */
  @Override
  public boolean checkIBAN( String pIBAN ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("IBAN");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pIBAN as request body.
    lRequestBuilder.setBody(pIBAN);
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Boolean.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChannelTypes
   * @return {@link List<Channel>}
   */
  @Override
  public List<Channel> getChannels( List<ChannelType> pChannelTypes ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("channels");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pChannelTypes != null) {
      lRequestBuilder.setQueryParameter("channelTypes", pChannelTypes);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Channel.class);
    List<Channel> lResult = requestExecutor.executeCollectionResultRequest(lRequest, 200, List.class, lObjectType);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  /**
   * @param pChannelType
   * @return {@link Channel}
   */
  @Override
  public Channel getDefaultChannel( ChannelType pChannelType ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("DefaultChannel");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pChannelType != null) {
      lRequestBuilder.setQueryParameter("channelType",
          XFun.getDatatypeConverterRegistry().getConverter(ChannelType.class, String.class).convert(pChannelType));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(Channel.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());
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
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("async-currencies/");
    lPathBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params/");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-date-query-params-beans/");
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
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @Override
  public String testOptionalQueryParams( String query1, int query2 ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-optional-query-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (query1 != null) {
      lRequestBuilder.setQueryParameter("query1", query1);
    }
    lRequestBuilder.setQueryParameter("query2", String.valueOf(query2));
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param authorization
   * @param pContentType
   * @param pAccept
   */
  @Override
  public void testSpecialHeaderParams( String authorization, String pContentType, String pAccept ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("special-header-params");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (authorization != null) {
      lRequestBuilder.setHeader("authorization", authorization);
    }
    if (pContentType != null) {
      lRequestBuilder.setHeader("content-type", pContentType);
    }
    if (pAccept != null) {
      lRequestBuilder.setHeader("ACCEPT", pAccept);
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("technicalHeaderBeanParam");
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
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("technicalHeaderParam");
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
   * @param pInlinedBeanParam
   */
  @Override
  public void testNotInlinedBeanParam( NotInlinedBeanParam pInlinedBeanParam ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testNotInlinedBeanParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pInlinedBeanParam != null) {
      if (pInlinedBeanParam.getHeader() != null) {
        lRequestBuilder.setHeader("header", pInlinedBeanParam.getHeader());
      }
      if (pInlinedBeanParam.getDoubleCode() != null) {
        lRequestBuilder.setHeader("doubleCode", pInlinedBeanParam.getDoubleCode().getCode());
      }
      if (pInlinedBeanParam.getExtensibleEnum() != null) {
        lRequestBuilder.setHeader("extensibleEnum", XFun.getDatatypeConverterRegistry()
            .getConverter(ExtensibleEnum.class, String.class).convert(pInlinedBeanParam.getExtensibleEnum()));
      }
      if (pInlinedBeanParam.getBookingID() != null) {
        lRequestBuilder.setHeader("bookingID", pInlinedBeanParam.getBookingID().getReferenceID());
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pIntegerArray
   */
  @Override
  public void testPrimitiveArray( int[] pIntegerArray ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testStringArray");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set parameter pIntegerArray as request body.
    lRequestBuilder.setBody(pIntegerArray);
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pIntValues
   * @return {@link String}
   */
  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testPrimitiveArrayAsQueryParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pIntValues != null) {
      lRequestBuilder.setQueryParameter("intValues", pIntValues);
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
  public String testMultivaluedHeader( List<BigDecimalCode> pCodes ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("big-decimal-codes-header");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (BigDecimalCode lNext : pCodes) {
        lValues.add(lNext.getCode());
      }
      lRequestBuilder.setHeader("pCodes", lValues);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pCodes
   * @param pEnums
   * @return {@link String}
   */
  @Override
  public String testMultivaluedQueryParams( List<BigDecimalCode> pCodes, List<BooleanLiteralsEnum> pEnums ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("big-decimal-codes-query");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (BigDecimalCode lNext : pCodes) {
        lValues.add(lNext.getCode());
      }
      lRequestBuilder.setQueryParameter("pCodes", lValues);
    }
    if (pEnums != null) {
      lRequestBuilder.setQueryParameter("pEnums", pEnums);
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pBeanParam
   * @param pTheEnum
   * @return {@link String}
   */
  @Override
  public String testMulitValuedBeanParams( MultiValuedDataType pBeanParam, BooleanLiteralsEnum pTheEnum ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testMulitValuedBeanParams");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pTheEnum != null) {
      lRequestBuilder.setQueryParameter("pTheEnum",
          XFun.getDatatypeConverterRegistry().getConverter(BooleanLiteralsEnum.class, String.class).convert(pTheEnum));
    }
    if (pBeanParam != null) {
      if (pBeanParam.getLongCodeQueryParam() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LongCode lNext : pBeanParam.getLongCodeQueryParam()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("longCodeQueryParam", lValues);
      }
      if (pBeanParam.getLiterals() != null) {
        lRequestBuilder.setQueryParameter("literals", pBeanParam.getLiterals());
      }
      if (pBeanParam.getStringProperty() != null) {
        lRequestBuilder.setQueryParameter("stringProperty", pBeanParam.getStringProperty());
      }
    }
    // Set HTTP header(s)
    if (pBeanParam != null) {
      if (pBeanParam.getStringCodeHeader() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pBeanParam.getStringCodeHeader()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("stringCodeHeader", lValues);
      }
      if (pBeanParam.getLongValues() != null) {
        lRequestBuilder.setHeader("longValues", pBeanParam.getLongValues());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pHeader
   * @param pContext
   */
  @Override
  public void noReturnType( String pHeader, MultiValuedDataType pContext ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("no-return-type");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pContext != null) {
      if (pContext.getLongCodeQueryParam() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LongCode lNext : pContext.getLongCodeQueryParam()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("longCodeQueryParam", lValues);
      }
      if (pContext.getLiterals() != null) {
        lRequestBuilder.setQueryParameter("literals", pContext.getLiterals());
      }
      if (pContext.getStringProperty() != null) {
        lRequestBuilder.setQueryParameter("stringProperty", pContext.getStringProperty());
      }
    }
    // Set HTTP header(s)
    if (pHeader != null) {
      lRequestBuilder.setHeader("The-Header", pHeader);
    }
    if (pContext != null) {
      if (pContext.getStringCodeHeader() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pContext.getStringCodeHeader()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("stringCodeHeader", lValues);
      }
      if (pContext.getLongValues() != null) {
        lRequestBuilder.setHeader("longValues", pContext.getLongValues());
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pID
   */
  @Override
  public void deleteSomething( String pID ) {
    // Create builder for DELETE request
    RESTRequest.Builder lRequestBuilder =
        RESTRequest.builder(ProductService.class, HttpMethod.DELETE, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("delete-something/");
    lPathBuilder.append(pID);
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @return {@link GenericSingleValuedReponse<BusinessServiceObject>}
   */
  @Override
  public GenericSingleValuedReponse<BusinessServiceObject> genericSingleValueResponse( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("generic-single-value");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<GenericSingleValuedReponse<BusinessServiceObject>> lTypeReference =
        new TypeReference<GenericSingleValuedReponse<BusinessServiceObject>>() {
        };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @return {@link GenericPageableResponse<BusinessServiceObject>}
   */
  @Override
  public GenericPageableResponse<BusinessServiceObject> genericMultiValueResponse( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("generic-multi-value");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<GenericPageableResponse<BusinessServiceObject>> lTypeReference =
        new TypeReference<GenericPageableResponse<BusinessServiceObject>>() {
        };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @param pStringCode
   * @param pShortCodes
   * @param pJustAByte
   */
  @Override
  public void testDataTypeWithRestrition( StringCode pStringCode, Set<ShortCode> pShortCodes, Byte pJustAByte ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("test-string-code-with-restriction/");
    lPathBuilder.append(pStringCode.getCode());
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pShortCodes != null) {
      List<Object> lValues = new ArrayList<Object>();
      for (ShortCode lNext : pShortCodes) {
        lValues.add(String.valueOf(lNext.getCode()));
      }
      lRequestBuilder.setQueryParameter("short-codes", lValues);
    }
    if (pJustAByte != null) {
      lRequestBuilder.setQueryParameter("byte-code",
          XFun.getDatatypeConverterRegistry().getConverter(Byte.class, String.class).convert(pJustAByte));
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pContext
   */
  @Override
  public void testContext( Context pContext ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testContext");
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
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @return {@link Response<Pageable<BusinessServiceObject>>}
   */
  @Override
  public Response<Pageable<BusinessServiceObject>> testNestedGenericsResponse( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("nested-generics");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<Response<Pageable<BusinessServiceObject>>> lTypeReference =
        new TypeReference<Response<Pageable<BusinessServiceObject>>>() {
        };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @return {@link Response<List<Offer>>}
   */
  @Override
  public Response<List<Offer>> testNestedMultivaluedResponse( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("multivalued-generics");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<Response<List<Offer>>> lTypeReference = new TypeReference<Response<List<Offer>>>() {
    };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @return {@link Response<Offer>}
   */
  @Override
  public Response<Offer> testDuplicateGenerics1( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testDuplicateGenerics1");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<Response<Offer>> lTypeReference = new TypeReference<Response<Offer>>() {
    };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }

  /**
   * @return {@link Response<Offer>}
   */
  @Override
  public Response<Offer> testDuplicateGenerics2( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(ProductService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/products");
    lPathBuilder.append('/');
    lPathBuilder.append("testDuplicateGenerics2");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    TypeReference<Response<Offer>> lTypeReference = new TypeReference<Response<Offer>>() {
    };
    ObjectType lObjectType = ObjectType.createTypeReferenceObjectType(lTypeReference);
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
  }
}
