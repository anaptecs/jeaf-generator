/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.RESTRequestExecutor;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.spring.base.AnotherDataType;
import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
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
import com.anaptecs.spring.service.monitoring.MonitoringService;

/**
 * Class implements a proxy for REST Service {@link ProductService}. The proxy is implemented as Spring services. This
 * way to developers it looks like a plain Spring Service.
 *
 * This implementation deals with everything that is required to call the external REST service including the following
 * things:
 * <ul>
 * <li>Serialization / deserialization between Java and JSON</li>
 * <li>Proper connection pooling and timeouts for HTTP requests</li>
 * <li>Proper setting of HTTP header</li>
 * <li>Circuit breaker in case of availabilities problems of the REST service</li>
 * </ul>
 *
 * However, as an transactional context can not be propagated to another REST resource developers still have to take
 * care about proper transaction handling if needed.
 */
@Service
public class ProductServiceRESTProxy implements ProductService {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  private final RESTRequestExecutor requestExecutor;

  /**
   * REST Service Proxy was generated with request / response validation enabled. The actual validation will be
   * delegated to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * Initialize object.
   *
   * @param pRequestExecutor Dependency on concrete {@link RESTRequestExecutor} implementation that should be used.
   */
  public ProductServiceRESTProxy( RESTRequestExecutor pRequestExecutor, ValidationExecutor pValidationExecutor ) {
    requestExecutor = pRequestExecutor;
    validationExecutor = pValidationExecutor;
  }

  /**
   * Operation returns all available product.
   *
   * @return {@link List<Product>} My default comment
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
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @Override
  public Product getProduct( String pProductID ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProductID);
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
    Product lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pProduct My default comment
   * @return boolean
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProduct);
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
    boolean lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
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
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
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
    Sortiment lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChannelCode);
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
    ChannelCode lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
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
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
      }
    }
    // Handle cookie parameters
    if (pContext != null) {
      lRequestBuilder.setCookie("reseller", String.valueOf(pContext.getResellerID()));
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBeanParam
   */
  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBeanParam);
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
        lRequestBuilder.setHeader("lang", pBeanParam.getLanguage().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pParam1);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @Override
  public String deprecatedBody( @Deprecated String pBody ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBody);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Override
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pProduct);
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
   * @return {@link Product} My default comment <br/>
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
    Product lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext
   */
  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
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
        lRequestBuilder.setHeader("lang", pContext.getLanguage().toString());
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
        lRequestBuilder.setCookie("Channel-Type", pContext.getChannelType().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChannelCode);
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
    ChannelCode lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pCurrencies);
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
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pCurrency);
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
    CurrencyCode lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pStringCode);
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
    IntegerCodeType lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pBeanParam);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pParent
   * @return {@link String}
   */
  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pParent);
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
      if (pParent.getCode() != null) {
        lRequestBuilder.setHeader("code", pParent.getCode().getCode());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pChild
   * @return {@link String}
   */
  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pChild);
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
      if (pChild.getCode() != null) {
        lRequestBuilder.setHeader("code", pChild.getCode().getCode());
      }
      if (pChild.getChildProperty() != null) {
        lRequestBuilder.setHeader("X-Child-Property", pChild.getChildProperty());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp,
        pLocalStartTime, pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
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
      lRequestBuilder.setQueryParameter("startTimestamp",
          DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pStartTimestamp));
    }
    if (pStartTime != null) {
      lRequestBuilder.setQueryParameter("startTime", DateTimeFormatter.ISO_OFFSET_TIME.format(pStartTime));
    }
    if (pLocalStartTimestamp != null) {
      lRequestBuilder.setQueryParameter("localStartTimestamp",
          DateTimeFormatter.ISO_DATE_TIME.format(pLocalStartTimestamp));
    }
    if (pLocalStartTime != null) {
      lRequestBuilder.setQueryParameter("localStartTime", DateTimeFormatter.ISO_TIME.format(pLocalStartTime));
    }
    if (pLocalStartDate != null) {
      lRequestBuilder.setQueryParameter("localStartDate", DateTimeFormatter.ISO_DATE.format(pLocalStartDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setQueryParameter("calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setQueryParameter("utilDate",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setQueryParameter("sqlTimestamp", pSQLTimestamp.toString());
    }
    if (pSQLTime != null) {
      lRequestBuilder.setQueryParameter("sqlTime", pSQLTime.toString());
    }
    if (pSQLDate != null) {
      lRequestBuilder.setQueryParameter("sqlDate", pSQLDate.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pQueryParams);
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
        lRequestBuilder.setQueryParameter("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQueryParams.getOffsetDateTime()));
      }
      if (pQueryParams.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQueryParams.getOffsetTime()));
      }
      if (pQueryParams.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQueryParams.getLocalDateTime()));
      }
      if (pQueryParams.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", DateTimeFormatter.ISO_TIME.format(pQueryParams.getLocalTime()));
      }
      if (pQueryParams.getLocalDate() != null) {
        lRequestBuilder.setQueryParameter("localDate", DateTimeFormatter.ISO_DATE.format(pQueryParams.getLocalDate()));
      }
      if (pQueryParams.getUtilDate() != null) {
        lRequestBuilder.setQueryParameter("utilDate",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getUtilDate()));
      }
      if (pQueryParams.getCalendar() != null) {
        lRequestBuilder.setQueryParameter("calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pQueryParams.getCalendar().getTime()));
      }
      if (pQueryParams.getSqlTimestamp() != null) {
        lRequestBuilder.setQueryParameter("sqlTimestamp", pQueryParams.getSqlTimestamp().toString());
      }
      if (pQueryParams.getSqlTime() != null) {
        lRequestBuilder.setQueryParameter("sqlTime", pQueryParams.getSqlTime().toString());
      }
      if (pQueryParams.getSqlDate() != null) {
        lRequestBuilder.setQueryParameter("sqlDate", pQueryParams.getSqlDate().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime,
        pLocalTime, pLocalDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
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
      lRequestBuilder.setHeader("Offset-Date-Time", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pOffsetDateTime));
    }
    if (pOffsetTime != null) {
      lRequestBuilder.setHeader("Offset-Time", DateTimeFormatter.ISO_OFFSET_TIME.format(pOffsetTime));
    }
    if (pLocalDateTime != null) {
      lRequestBuilder.setHeader("Local-Date-Time", DateTimeFormatter.ISO_DATE_TIME.format(pLocalDateTime));
    }
    if (pLocalTime != null) {
      lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pLocalTime));
    }
    if (pLocalDate != null) {
      lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pLocalDate));
    }
    if (pCalendar != null) {
      lRequestBuilder.setHeader("Calendar",
          new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pCalendar.getTime()));
    }
    if (pUtilDate != null) {
      lRequestBuilder.setHeader("Util-Date", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pUtilDate));
    }
    if (pSQLTimestamp != null) {
      lRequestBuilder.setHeader("SQL-Timestamp", pSQLTimestamp.toString());
    }
    if (pSQLTime != null) {
      lRequestBuilder.setHeader("SQL-Time", pSQLTime.toString());
    }
    if (pSQLDate != null) {
      lRequestBuilder.setHeader("SQL-Date", pSQLDate.toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pPath, pHeaderParams);
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
        lRequestBuilder.setHeader("Offset-Date-Time",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pHeaderParams.getOffsetDateTime()));
      }
      if (pHeaderParams.getOffsetTime() != null) {
        lRequestBuilder.setHeader("Offset-Time",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pHeaderParams.getOffsetTime()));
      }
      if (pHeaderParams.getLocalDateTime() != null) {
        lRequestBuilder.setHeader("Local-Date-Time",
            DateTimeFormatter.ISO_DATE_TIME.format(pHeaderParams.getLocalDateTime()));
      }
      if (pHeaderParams.getLocalTime() != null) {
        lRequestBuilder.setHeader("Local-Time", DateTimeFormatter.ISO_TIME.format(pHeaderParams.getLocalTime()));
      }
      if (pHeaderParams.getLocalDate() != null) {
        lRequestBuilder.setHeader("Local-Date", DateTimeFormatter.ISO_DATE.format(pHeaderParams.getLocalDate()));
      }
      if (pHeaderParams.getUtilDate() != null) {
        lRequestBuilder.setHeader("Util-Date",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getUtilDate()));
      }
      if (pHeaderParams.getCalendar() != null) {
        lRequestBuilder.setHeader("Calendar",
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(pHeaderParams.getCalendar().getTime()));
      }
      if (pHeaderParams.getSqlTimestamp() != null) {
        lRequestBuilder.setHeader("SQL-Timestamp", pHeaderParams.getSqlTimestamp().toString());
      }
      if (pHeaderParams.getSqlTime() != null) {
        lRequestBuilder.setHeader("SQL-Time", pHeaderParams.getSqlTime().toString());
      }
      if (pHeaderParams.getSqlDate() != null) {
        lRequestBuilder.setHeader("SQL-Date", pHeaderParams.getSqlDate().toString());
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pReseller);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String testTechnicalHeaderBean( TechnicalHeaderContext pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pContext);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
  }

  /**
   * @param pCodes
   * @return {@link String}
   */
  @Override
  public String processDataTypes( List<AnotherDataType> pCodes ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(ProductService.class, pCodes);
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return lResult;
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
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(MonitoringService.class, lResult);
    return lResult;
  }
}