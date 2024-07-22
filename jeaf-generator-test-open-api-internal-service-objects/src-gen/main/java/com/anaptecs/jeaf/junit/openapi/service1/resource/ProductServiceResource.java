/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1.resource;

import java.math.BigDecimal;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
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
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductServiceResource {
  /**
   * {@link ProductService#getProducts()}
   */
  @GET
  public void getProducts( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    ProductService lService = this.getProductService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          List<Product> lResult = lService.getProducts();
          javax.ws.rs.core.Response lResponseObject =
              javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
          // Due to the asynchronous processing of the requests, the response can not be returned as return value.
          // Therefore we make use of the defined JAX-RS mechanisms.
          pAsyncResponse.resume(lResponseObject);
        }
        // All kinds of exceptions have to be reported to the client. Due to the asynchronous processing we have to
        // catch them here and return them to the client via class AsyncResponse.
        catch (RuntimeException e) {
          pAsyncResponse.resume(e);
        }
      }
    });
  }

  /**
   * {@link ProductService#getProduct()}
   */
  @Path("{id}")
  @GET
  public javax.ws.rs.core.Response getProduct( @PathParam("id") @DefaultValue("4711") String pProductID ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Product lResult = lService.getProduct(pProductID);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @POST
  public javax.ws.rs.core.Response createProduct( Product pProduct ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    boolean lResult = lService.createProduct(pProduct);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public javax.ws.rs.core.Response getSortiment( @BeanParam Context pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Sortiment lResult = lService.getSortiment(pContext);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public javax.ws.rs.core.Response createChannelCode( String pChannelCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#ping()}
   */
  @HEAD
  public javax.ws.rs.core.Response ping( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.ping();
    return javax.ws.rs.core.Response.status(Status.ACCEPTED).build();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @Path("deprecated/operation")
  @GET
  @Deprecated
  public javax.ws.rs.core.Response deprecatedOperation( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedOperation();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @Path("deprecated/context")
  @POST
  public javax.ws.rs.core.Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedContext(pContext);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @Path("deprecated/beanParams")
  @POST
  public javax.ws.rs.core.Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.deprecatedBeanParam(pBeanParam);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @Path("deprecated/params")
  @POST
  @Deprecated
  public javax.ws.rs.core.Response deprecatedParams( @HeaderParam("param1") @Deprecated int pParam1 ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedParams(pParam1);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @Path("deprecated/body")
  @POST
  public javax.ws.rs.core.Response deprecatedBody( @DefaultValue("Hello World!") @Deprecated String pBody ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedBody(pBody);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @Path("deprecated/complexBody")
  @POST
  public javax.ws.rs.core.Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.deprectedComplexRequestBody(pProduct);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @Path("deprecated/complexReturn")
  @GET
  @Deprecated
  public javax.ws.rs.core.Response deprecatedComplexReturn( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Product lResult = lService.deprecatedComplexReturn();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @Path("specific/{id}")
  @PATCH
  public javax.ws.rs.core.Response loadSpecificThings( @BeanParam SpecialContext pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.loadSpecificThings(pContext);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @Path("ChannelCodeObject")
  @POST
  public javax.ws.rs.core.Response createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCodeFromObject(pChannelCode);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @Path("currencies")
  @POST
  public javax.ws.rs.core.Response addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    List<CurrencyCode> lResult = lService.addCurrencies(pCurrencies);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @Path("currencies/valid")
  @POST
  public javax.ws.rs.core.Response isCurrencySupported( CurrencyCode pCurrency ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    CurrencyCode lResult = lService.isCurrencySupported(pCurrency);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @Path("codeTypeUsages")
  @POST
  public javax.ws.rs.core.Response testCodeTypeUsage( StringCodeType pStringCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    IntegerCodeType lResult = lService.testCodeTypeUsage(pStringCode);
    return javax.ws.rs.core.Response.status(Status.ACCEPTED).entity(lResult).build();
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @Path("LocalBeanParam")
  @GET
  public javax.ws.rs.core.Response testLocalBeanParamType( @BeanParam LocalBeanParamType pBeanParam ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testLocalBeanParamType(pBeanParam);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @Path("ExternalBeanParam")
  @GET
  public javax.ws.rs.core.Response testExternalBeanParameterType( @BeanParam ParentBeanParamType pParent ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testExternalBeanParameterType(pParent);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @Path("ChildBeanParam")
  @GET
  public javax.ws.rs.core.Response testChildBeanParameter( @BeanParam ChildBeanParameterType pChild ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testChildBeanParameter(pChild);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#checkIBAN()}
   */
  @Path("IBAN")
  @POST
  public javax.ws.rs.core.Response checkIBAN( String pIBAN ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    boolean lResult = lService.checkIBAN(pIBAN);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getChannels()}
   */
  @Path("channels")
  @GET
  public javax.ws.rs.core.Response getChannels(
      @QueryParam("channelTypes") @DefaultValue("MOBILE") List<ChannelType> pChannelTypes ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    List<Channel> lResult = lService.getChannels(pChannelTypes);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getDefaultChannel()}
   */
  @Path("DefaultChannel")
  @GET
  public javax.ws.rs.core.Response getDefaultChannel(
      @QueryParam("channelType") @DefaultValue("COUNTER") ChannelType pChannelType ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Channel lResult = lService.getDefaultChannel(pChannelType);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSupportedCurrencies()}
   */
  @Path("currencies/{channelCode}")
  @GET
  public javax.ws.rs.core.Response getSupportedCurrencies( @PathParam("channelCode") String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode;
    if (pChannelCodeAsBasicType != null) {
      pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    }
    else {
      pChannelCode = null;
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    List<CurrencyCode> lResult = lService.getSupportedCurrencies(pChannelCode);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSupportedCurrenciesAsync()}
   */
  @Path("async-currencies/{channelCode}")
  @GET
  public void getSupportedCurrenciesAsync( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest,
      @PathParam("channelCode") String pChannelCodeAsBasicType ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Lookup service that will be called later during async processing of the request
    ProductService lService = this.getProductService();
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          // Convert basic type parameters into "real" objects.
          ChannelCode pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
          List<CurrencyCode> lResult = lService.getSupportedCurrenciesAsync(pChannelCode);
          javax.ws.rs.core.Response lResponseObject =
              javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
          // Due to the asynchronous processing of the requests, the response can not be returned as return value.
          // Therefore we make use of the defined JAX-RS mechanisms.
          pAsyncResponse.resume(lResponseObject);
        }
        // All kinds of exceptions have to be reported to the client. Due to the asynchronous processing we have to
        // catch them here and return them to the client via class AsyncResponse.
        catch (RuntimeException e) {
          pAsyncResponse.resume(e);
        }
      }
    });
  }

  /**
   * {@link ProductService#testDateQueryParams()}
   */
  @Path("test-date-query-params/{path}")
  @GET
  public javax.ws.rs.core.Response testDateQueryParams( @PathParam("path") String pPath,
      @QueryParam("startTimestamp") OffsetDateTime pStartTimestamp, @QueryParam("startTime") OffsetTime pStartTime,
      @QueryParam("localStartTimestamp") LocalDateTime pLocalStartTimestamp,
      @QueryParam("localStartTime") LocalTime pLocalStartTime, @QueryParam("localStartDate") LocalDate pLocalStartDate,
      @QueryParam("calendar") Calendar pCalendar, @QueryParam("utilDate") java.util.Date pUtilDate,
      @QueryParam("sqlTimestamp") Timestamp pSQLTimestamp, @QueryParam("sqlTime") Time pSQLTime,
      @QueryParam("sqlDate") Date pSQLDate ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testDateQueryParamsBean()}
   */
  @Path("test-date-query-params-beans/{path}")
  @GET
  public javax.ws.rs.core.Response testDateQueryParamsBean( @PathParam("path") String pPath,
      @BeanParam DateQueryParamsBean pQueryParams ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDateQueryParamsBean(pPath, pQueryParams);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testOptionalQueryParams()}
   */
  @Path("test-optional-query-params")
  @GET
  public javax.ws.rs.core.Response testOptionalQueryParams(
      @QueryParam("query1") @DefaultValue("Just a default value") String query1, @QueryParam("query2") int query2 ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testOptionalQueryParams(query1, query2);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testSpecialHeaderParams()}
   */
  @Path("special-header-params")
  @GET
  public javax.ws.rs.core.Response testSpecialHeaderParams( @HeaderParam("authorization") String authorization,
      @HeaderParam("content-type") String pContentType, @HeaderParam("ACCEPT") String pAccept ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testSpecialHeaderParams(authorization, pContentType, pAccept);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderBean()}
   */
  @Path("technicalHeaderBeanParam")
  @GET
  public javax.ws.rs.core.Response testTechnicalHeaderBean( @BeanParam TechnicalHeaderContext pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testTechnicalHeaderBean(pContext);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderParam()}
   */
  @Path("technicalHeaderParam")
  @GET
  public javax.ws.rs.core.Response testTechnicalHeaderParam( @HeaderParam("Reseller") String pReseller ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testTechnicalHeaderParam(pReseller);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testNotInlinedBeanParam()}
   */
  @Path("testNotInlinedBeanParam")
  @POST
  public javax.ws.rs.core.Response testNotInlinedBeanParam( @BeanParam NotInlinedBeanParam pInlinedBeanParam ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testNotInlinedBeanParam(pInlinedBeanParam);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testPrimitiveArray()}
   */
  @Path("testStringArray")
  @POST
  public javax.ws.rs.core.Response testPrimitiveArray( int[] pIntegerArray ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testPrimitiveArray(pIntegerArray);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testPrimitiveArrayAsQueryParam()}
   */
  @Path("testPrimitiveArrayAsQueryParam")
  @GET
  public javax.ws.rs.core.Response testPrimitiveArrayAsQueryParam( @QueryParam("intValues") int[] pIntValues ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testPrimitiveArrayAsQueryParam(pIntValues);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testMultivaluedHeader()}
   */
  @Path("big-decimal-codes-header")
  @GET
  public javax.ws.rs.core.Response testMultivaluedHeader( @HeaderParam("pCodes") BigDecimal[] pCodesAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    List<BigDecimalCode> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<BigDecimalCode>();
      for (BigDecimal lNext : pCodesAsBasicType) {
        pCodes.add(BigDecimalCode.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testMultivaluedHeader(pCodes);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testMultivaluedQueryParams()}
   */
  @Path("big-decimal-codes-query")
  @GET
  public javax.ws.rs.core.Response testMultivaluedQueryParams( @QueryParam("pCodes") BigDecimal[] pCodesAsBasicType,
      @QueryParam("pEnums") List<BooleanLiteralsEnum> pEnums ) {
    // Convert basic type parameters into "real" objects.
    List<BigDecimalCode> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<BigDecimalCode>();
      for (BigDecimal lNext : pCodesAsBasicType) {
        pCodes.add(BigDecimalCode.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testMultivaluedQueryParams(pCodes, pEnums);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testMulitValuedBeanParams()}
   */
  @Path("testMulitValuedBeanParams")
  @GET
  public javax.ws.rs.core.Response testMulitValuedBeanParams( @BeanParam MultiValuedDataType pBeanParam,
      @QueryParam("pTheEnum") BooleanLiteralsEnum pTheEnum ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testMulitValuedBeanParams(pBeanParam, pTheEnum);
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#noReturnType()}
   */
  @Path("no-return-type")
  @POST
  public javax.ws.rs.core.Response noReturnType( @HeaderParam("The-Header") String pHeader,
      @BeanParam MultiValuedDataType pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.noReturnType(pHeader, pContext);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deleteSomething()}
   */
  @Path("delete-something/{id}")
  @DELETE
  public javax.ws.rs.core.Response deleteSomething( @PathParam("id") String pID ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.deleteSomething(pID);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#genericSingleValueResponse()}
   */
  @Path("generic-single-value")
  @GET
  public javax.ws.rs.core.Response genericSingleValueResponse( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    GenericSingleValuedReponse<BusinessServiceObject> lResult = lService.genericSingleValueResponse();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#genericMultiValueResponse()}
   */
  @Path("generic-multi-value")
  @GET
  public javax.ws.rs.core.Response genericMultiValueResponse( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    GenericPageableResponse<BusinessServiceObject> lResult = lService.genericMultiValueResponse();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testDataTypeWithRestrition()}
   */
  @Path("test-string-code-with-restriction/{string-code}")
  @POST
  public javax.ws.rs.core.Response testDataTypeWithRestrition( @PathParam("string-code") String pStringCodeAsBasicType,
      @QueryParam("short-codes") short[] pShortCodesAsBasicType, @QueryParam("byte-code") Byte pJustAByte ) {
    // Convert basic type parameters into "real" objects.
    StringCode pStringCode;
    if (pStringCodeAsBasicType != null) {
      pStringCode = StringCode.builder().setCode(pStringCodeAsBasicType).build();
    }
    else {
      pStringCode = null;
    }
    Set<ShortCode> pShortCodes;
    if (pShortCodesAsBasicType != null) {
      pShortCodes = new HashSet<ShortCode>();
      for (short lNext : pShortCodesAsBasicType) {
        pShortCodes.add(ShortCode.builder().setCode(lNext).build());
      }
    }
    else {
      pShortCodes = Collections.emptySet();
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDataTypeWithRestrition(pStringCode, pShortCodes, pJustAByte);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testContext()}
   */
  @Path("testContext")
  @GET
  public javax.ws.rs.core.Response testContext( @BeanParam Context pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
    }
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testContext(pContext);
    return javax.ws.rs.core.Response.status(Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testNestedGenericsResponse()}
   */
  @Path("nested-generics")
  @GET
  public javax.ws.rs.core.Response testNestedGenericsResponse( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Response<Pageable<BusinessServiceObject>> lResult = lService.testNestedGenericsResponse();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testNestedMultivaluedResponse()}
   */
  @Path("multivalued-generics")
  @GET
  public javax.ws.rs.core.Response testNestedMultivaluedResponse( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Response<List<Offer>> lResult = lService.testNestedMultivaluedResponse();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testDuplicateGenerics1()}
   */
  @Path("testDuplicateGenerics1")
  @GET
  public javax.ws.rs.core.Response testDuplicateGenerics1( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Response<Offer> lResult = lService.testDuplicateGenerics1();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testDuplicateGenerics2()}
   */
  @Path("testDuplicateGenerics2")
  @GET
  public javax.ws.rs.core.Response testDuplicateGenerics2( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Response<Offer> lResult = lService.testDuplicateGenerics2();
    return javax.ws.rs.core.Response.status(Status.OK).entity(lResult).build();
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return ProductService Service instance to which all requests will be delegated.
   */
  private ProductService getProductService( ) {
    return JEAF.getService(ProductService.class);
  }
}