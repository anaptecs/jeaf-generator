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
import java.util.Calendar;
import java.util.List;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anaptecs.jeaf.core.api.JEAF;
import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.api.jeaf.CompositeTypeConverterServiceProvider;
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;
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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
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
  @Path("{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Product lResult = lService.getProduct(pProductID);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    boolean lResult = lService.createProduct(pProduct);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Sortiment lResult = lService.getSortiment(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createChannelCode( String pChannelCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#ping()}
   */
  @HEAD
  public Response ping( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.ping();
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedOperation()}
   */
  @Path("deprecated/operation")
  @GET
  @Deprecated
  public Response deprecatedOperation( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedOperation();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedContext()}
   */
  @Path("deprecated/context")
  @POST
  public Response deprecatedContext( @BeanParam DeprecatedContext pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedContext(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBeanParam()}
   */
  @Path("deprecated/beanParams")
  @POST
  public Response deprecatedBeanParam( @BeanParam BeanParameter pBeanParam ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.deprecatedBeanParam(pBeanParam);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedParams()}
   */
  @Path("deprecated/params")
  @POST
  @Deprecated
  public Response deprecatedParams( @HeaderParam("param1") @Deprecated int pParam1 ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedParams(pParam1);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprecatedBody()}
   */
  @Path("deprecated/body")
  @POST
  public Response deprecatedBody( @DefaultValue("Hello World!") @Deprecated String pBody ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.deprecatedBody(pBody);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#deprectedComplexRequestBody()}
   */
  @Path("deprecated/complexBody")
  @POST
  public Response deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.deprectedComplexRequestBody(pProduct);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#deprecatedComplexReturn()}
   */
  @Path("deprecated/complexReturn")
  @GET
  @Deprecated
  public Response deprecatedComplexReturn( ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    Product lResult = lService.deprecatedComplexReturn();
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#loadSpecificThings()}
   */
  @Path("specific/{id}")
  @PATCH
  public Response loadSpecificThings( @BeanParam SpecialContext pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.loadSpecificThings(pContext);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#createChannelCodeFromObject()}
   */
  @Path("ChannelCodeObject")
  @POST
  public Response createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCodeFromObject(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#addCurrencies()}
   */
  @Path("currencies")
  @POST
  public Response addCurrencies( List<CurrencyCode> pCurrencies ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    List<CurrencyCode> lResult = lService.addCurrencies(pCurrencies);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#isCurrencySupported()}
   */
  @Path("currencies/valid")
  @POST
  public Response isCurrencySupported( CurrencyCode pCurrency ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    CurrencyCode lResult = lService.isCurrencySupported(pCurrency);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testCodeTypeUsage()}
   */
  @Path("codeTypeUsages")
  @POST
  public Response testCodeTypeUsage( StringCodeType pStringCode ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    IntegerCodeType lResult = lService.testCodeTypeUsage(pStringCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @Path("LocalBeanParam")
  @GET
  public Response testLocalBeanParamType( @BeanParam LocalBeanParamType pBeanParam ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testLocalBeanParamType(pBeanParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @Path("ExternalBeanParam")
  @GET
  public Response testExternalBeanParameterType( @BeanParam ParentBeanParamType pParent ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testExternalBeanParameterType(pParent);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @Path("ChildBeanParam")
  @GET
  public Response testChildBeanParameter( @BeanParam ChildBeanParameterType pChild ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testChildBeanParameter(pChild);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testDateQueryParams()}
   */
  @Path("test-date-query-params/{path}")
  @GET
  public Response testDateQueryParams( @PathParam("path") String pPath,
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
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#testDateQueryParamsBean()}
   */
  @Path("test-date-query-params-beans/{path}")
  @GET
  public Response testDateQueryParamsBean( @PathParam("path") String pPath,
      @BeanParam DateQueryParamsBean pQueryParams ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDateQueryParamsBean(pPath, pQueryParams);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#testDateHeaderParams()}
   */
  @Path("test-date-header-params/{path}")
  @GET
  public Response testDateHeaderParams( @PathParam("path") String pPath,
      @HeaderParam("Offset-Date-Time") OffsetDateTime pOffsetDateTime,
      @HeaderParam("Offset-Time") OffsetTime pOffsetTime, @HeaderParam("Local-Date-Time") LocalDateTime pLocalDateTime,
      @HeaderParam("Local-Time") LocalTime pLocalTime, @HeaderParam("Local-Date") LocalDate pLocalDate,
      @HeaderParam("Calendar") Calendar pCalendar, @HeaderParam("Util-Date") java.util.Date pUtilDate,
      @HeaderParam("SQL-Timestamp") Timestamp pSQLTimestamp, @HeaderParam("SQL-Time") Time pSQLTime,
      @HeaderParam("SQL-Date") Date pSQLDate ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#testDateHeaderParamsBean()}
   */
  @Path("test-date-header-params-beans/{path}")
  @GET
  public Response testDateHeaderParamsBean( @PathParam("path") String pPath,
      @BeanParam DateHeaderParamsBean pHeaderParams ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    lService.testDateHeaderParamsBean(pPath, pHeaderParams);
    return Response.status(Response.Status.OK).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderParam()}
   */
  @Path("technicalHeaderParam")
  @GET
  public Response testTechnicalHeaderParam( @HeaderParam("Reseller") String pReseller ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testTechnicalHeaderParam(pReseller);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testTechnicalHeaderBean()}
   */
  @Path("technicalHeaderBeanParam")
  @GET
  public Response testTechnicalHeaderBean( @BeanParam TechnicalHeaderContext pContext ) {
    // Delegate request to service.
    ProductService lService = this.getProductService();
    String lResult = lService.testTechnicalHeaderBean(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return ProductService Service instance to which all requests will be delegated.
   */
  private ProductService getProductService( ) {
    return JEAF.getService(ProductService.class);
  }

  /**
   * Method returns the composite type converter that should be used in this environment. This REST interface makes
   * usage of so called composite data types. As Spring itself is not able to do conversions from a String
   * representation into a real object this is done in the generated REST Controller.
   * 
   * @return {@link CompositeTypeConverter} CompositeTypeConverter implementation that is configured to be used here.
   * The method never returns null.
   */
  private CompositeTypeConverter getCompositeTypeConverter( ) {
    return JEAF.getServiceProvider(CompositeTypeConverterServiceProvider.class);
  }
}
