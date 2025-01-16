/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;
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

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  @Autowired
  private ValidationExecutor validationExecutor;

  /**
   * Filter is used to provide only those headers that are configured to be processed by this REST resource.
   */
  @Autowired
  private CustomHeaderFilter customHeaderFilter;

  /**
   * All request to this class will be delegated to {@link ProductService}.
   */
  @Autowired
  private ProductService productService;

  /**
   * {@link ProductService#getProducts()}
   */
  @Path("products/")
  @GET
  public void getProducts( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest ) {
    // Lookup workload manager that takes care that the system will have an optimal throughput.
    WorkloadManager lWorkloadManager = Workload.getWorkloadManager();
    // Prepare meta information about the request.
    String lEndpointURL = pRequest.getServletPath() + pRequest.getPathInfo();
    RESTRequestType lRequestInfo = new RESTRequestType(lEndpointURL, pRequest.getMethod());
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          List<Product> lResult = productService.getProducts();
          Response lResponseObject = Response.status(Response.Status.OK).entity(lResult).build();
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
  @Path("products/{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    // Delegate request to service.
    Product lResult = productService.getProduct(pProductID);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @Path("products/")
  @POST
  public Response createProduct( Product pProduct ) {
    // Delegate request to service.
    boolean lResult = productService.createProduct(pProduct);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @Path("products/sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext, @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
      }
    }
    // Delegate request to service.
    Sortiment lResult = productService.getSortiment(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @Path("products/ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createChannelCode( String pChannelCode ) {
    // Delegate request to service.
    ChannelCode lResult = productService.createChannelCode(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#ping()}
   */
  @Path("products/")
  @HEAD
  public Response ping( ) {
    // Delegate request to service.
    productService.ping();
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @Path("products/deprecated/operation")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    // Delegate request to service.
    String lResult = productService.deprecatedOperation();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @Path("products/deprecated/context")
  @POST
  public Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    // Delegate request to service.
    String lResult = productService.deprecatedContext(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @Path("products/deprecated/beanParams")
  @POST
  public Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    // Delegate request to service.
    productService.deprecatedBeanParam(pBeanParam);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @Path("products/deprecated/params")
  @POST
  @Deprecated
  public Response deprecatedParams( @HeaderParam("param1") @Deprecated int pParam1 ) {
    // Delegate request to service.
    String lResult = productService.deprecatedParams(pParam1);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @Path("products/deprecated/body")
  @POST
  public Response deprecatedBody( @DefaultValue("Hello World!") @Deprecated String pBody ) {
    // Delegate request to service.
    String lResult = productService.deprecatedBody(pBody);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @Path("products/deprecated/complexBody")
  @POST
  public Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Delegate request to service.
    productService.deprectedComplexRequestBody(pProduct);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @Path("products/deprecated/complexReturn")
  @GET
  @Deprecated
  public Response deprecatedComplexReturn( ) {
    // Delegate request to service.
    Product lResult = productService.deprecatedComplexReturn();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @Path("products/specific/{id}")
  @PATCH
  public Response loadSpecificThings( @BeanParam SpecialContext pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
      }
    }
    // Delegate request to service.
    productService.loadSpecificThings(pContext);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @Path("products/ChannelCodeObject")
  @POST
  public Response createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // Delegate request to service.
    ChannelCode lResult = productService.createChannelCodeFromObject(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @Path("products/currencies")
  @POST
  public Response addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Delegate request to service.
    List<CurrencyCode> lResult = productService.addCurrencies(pCurrencies);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @Path("products/currencies/valid")
  @POST
  public Response isCurrencySupported( CurrencyCode pCurrency ) {
    // Delegate request to service.
    CurrencyCode lResult = productService.isCurrencySupported(pCurrency);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @Path("products/codeTypeUsages")
  @POST
  public Response testCodeTypeUsage( StringCodeType pStringCode ) {
    // Delegate request to service.
    IntegerCodeType lResult = productService.testCodeTypeUsage(pStringCode);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @Path("products/LocalBeanParam")
  @GET
  public Response testLocalBeanParamType( @BeanParam LocalBeanParamType pBeanParam ) {
    // Delegate request to service.
    String lResult = productService.testLocalBeanParamType(pBeanParam);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @Path("products/ExternalBeanParam")
  @GET
  public Response testExternalBeanParameterType( @BeanParam ParentBeanParamType pParent ) {
    // Delegate request to service.
    String lResult = productService.testExternalBeanParameterType(pParent);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @Path("products/ChildBeanParam")
  @GET
  public Response testChildBeanParameter( @BeanParam ChildBeanParameterType pChild ) {
    // Delegate request to service.
    String lResult = productService.testChildBeanParameter(pChild);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testDateQueryParams()}
   */
  @Path("products/test-date-query-params/{path}")
  @GET
  public Response testDateQueryParams( @PathParam("path") String pPath,
      @QueryParam("startTimestamp") OffsetDateTime pStartTimestamp, @QueryParam("startTime") OffsetTime pStartTime,
      @QueryParam("localStartTimestamp") LocalDateTime pLocalStartTimestamp,
      @QueryParam("localStartTime") LocalTime pLocalStartTime, @QueryParam("localStartDate") LocalDate pLocalStartDate,
      @QueryParam("calendar") Calendar pCalendar, @QueryParam("utilDate") java.util.Date pUtilDate,
      @QueryParam("sqlTimestamp") Timestamp pSQLTimestamp, @QueryParam("sqlTime") Time pSQLTime,
      @QueryParam("sqlDate") Date pSQLDate ) {
    // Delegate request to service.
    productService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testDateQueryParamsBean()}
   */
  @Path("products/test-date-query-params-beans/{path}")
  @GET
  public Response testDateQueryParamsBean( @PathParam("path") String pPath,
      @BeanParam DateQueryParamsBean pQueryParams ) {
    // Delegate request to service.
    productService.testDateQueryParamsBean(pPath, pQueryParams);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testDateHeaderParams()}
   */
  @Path("products/test-date-header-params/{path}")
  @GET
  public Response testDateHeaderParams( @PathParam("path") String pPath,
      @HeaderParam("Offset-Date-Time") OffsetDateTime pOffsetDateTime,
      @HeaderParam("Offset-Time") OffsetTime pOffsetTime, @HeaderParam("Local-Date-Time") LocalDateTime pLocalDateTime,
      @HeaderParam("Local-Time") LocalTime pLocalTime, @HeaderParam("Local-Date") LocalDate pLocalDate,
      @HeaderParam("Calendar") Calendar pCalendar, @HeaderParam("Util-Date") java.util.Date pUtilDate,
      @HeaderParam("SQL-Timestamp") Timestamp pSQLTimestamp, @HeaderParam("SQL-Time") Time pSQLTime,
      @HeaderParam("SQL-Date") Date pSQLDate ) {
    // Delegate request to service.
    productService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testDateHeaderParamsBean()}
   */
  @Path("products/test-date-header-params-beans/{path}")
  @GET
  public Response testDateHeaderParamsBean( @PathParam("path") String pPath,
      @BeanParam DateHeaderParamsBean pHeaderParams ) {
    // Delegate request to service.
    productService.testDateHeaderParamsBean(pPath, pHeaderParams);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderParam()}
   */
  @Path("products/technicalHeaderParam")
  @GET
  public Response testTechnicalHeaderParam( @HeaderParam("Reseller") String pReseller ) {
    // Delegate request to service.
    String lResult = productService.testTechnicalHeaderParam(pReseller);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderBean()}
   */
  @Path("products/technicalHeaderBeanParam")
  @GET
  public Response testTechnicalHeaderBean( @BeanParam TechnicalHeaderContext pContext,
      @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
      }
    }
    // Delegate request to service.
    String lResult = productService.testTechnicalHeaderBean(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#processDataTypes()}
   */
  @Path("products/product-codes")
  @GET
  public Response processDataTypes( @QueryParam("pCodes") String[] pCodesAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    List<AnotherDataType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<AnotherDataType>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(AnotherDataType.builder().setData(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    // Delegate request to service.
    String lResult = productService.processDataTypes(pCodes);
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link com.anaptecs.spring.service.monitoring.MonitoringService#getVersionInfo()}
   */
  @Path("products/info")
  @GET
  public Response getVersionInfo( ) {
    // Delegate request to service.
    String lResult = productService.getVersionInfo();
    // Validate response and return it.
    validationExecutor.validateResponse(ProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }
}