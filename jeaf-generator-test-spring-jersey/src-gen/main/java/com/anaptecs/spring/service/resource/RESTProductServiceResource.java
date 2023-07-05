/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

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
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
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
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.MultivaluedQueryParamsBean;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.RESTProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/rest-products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RESTProductServiceResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  @Autowired
  private ObjectMapper objectMapper;

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
   * All request to this class will be delegated to {@link RESTProductService}.
   */
  @Autowired
  private RESTProductService rESTProductService;

  /**
   * {@link RESTProductService#getProducts()}
   */
  @GET
  public void getProducts( @Suspended AsyncResponse pAsyncResponse,
      @javax.ws.rs.core.Context HttpServletRequest pRequest, @QueryParam("maxResult") int pMaxResultSize ) {
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
          List<Product> lResult = rESTProductService.getProducts(pMaxResultSize);
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
   * {@link RESTProductService#getProduct()}
   */
  @Path("{id}")
  @GET
  public Response getProduct( @PathParam("id") String pProductID ) {
    // Delegate request to service.
    Product lResult = rESTProductService.getProduct(pProductID);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
    // Delegate request to service.
    boolean lResult = rESTProductService.createProduct(pProduct);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#getSortiment()}
   */
  @Path("sortiment/{id}")
  @GET
  public Response getSortiment( @BeanParam Context pContext, @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
      }
    }
    // Delegate request to service.
    Sortiment lResult = rESTProductService.getSortiment(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  public Response createChannelCode( String pChannelCode ) {
    // Delegate request to service.
    ChannelCode lResult = rESTProductService.createChannelCode(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#ping()}
   */
  @HEAD
  public Response ping( ) {
    // Delegate request to service.
    rESTProductService.ping();
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testInit()}
   */
  @Path("test-init")
  @GET
  public Response testInit( ) {
    // Delegate request to service.
    rESTProductService.testInit();
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#getSupportedCurrencies()}
   */
  @Path("currencies/{channelCode}")
  @GET
  public Response getSupportedCurrencies( @PathParam("channelCode") String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
    // Delegate request to service.
    List<CurrencyCode> lResult = rESTProductService.getSupportedCurrencies(pChannelCode);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#getSupportedCurrenciesAsync()}
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
    // Hand over current request to workload manager. Depending on its strategy and the current workload the request
    // will be either be directly executed, first queued or rejected.
    lWorkloadManager.execute(lRequestInfo, new RESTWorkloadErrorHandler(pAsyncResponse), new Runnable() {
      @Override
      public void run( ) {
        try {
          // Convert basic type parameters into "real" objects.
          ChannelCode pChannelCode = ChannelCode.builder().setCode(pChannelCodeAsBasicType).build();
          List<CurrencyCode> lResult = rESTProductService.getSupportedCurrenciesAsync(pChannelCode);
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
   * {@link RESTProductService#testParams()}
   */
  @Path("test-params")
  @GET
  public Response testParams( @HeaderParam("Big-Header") BigDecimal pBigDecimalHeader,
      @CookieParam("giveMeMoreCookies") int pIntCookieParam, @QueryParam("locale") Locale pLocaleQueryParam ) {
    // Delegate request to service.
    String lResult = rESTProductService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testEnumParams()}
   */
  @Path("test-enum-params/{channelType}")
  @GET
  public Response testEnumParams( @PathParam("channelType") ChannelType pChannelType,
      @QueryParam("timeUnit") TimeUnit pTimeUnit, @QueryParam("extensibleEnum") ExtensibleEnum pExtensibleEnum ) {
    // Delegate request to service.
    rESTProductService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testEnumHeaderParams()}
   */
  @Path("test-enum-header-params")
  @GET
  public Response testEnumHeaderParams( @HeaderParam("Channel-Type") ChannelType pChannelType,
      @HeaderParam("Time-Unit") TimeUnit pTimeUnit, @HeaderParam("Extensible-Enum") ExtensibleEnum pExtensibleEnum ) {
    // Delegate request to service.
    rESTProductService.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testDateQueryParams()}
   */
  @Path("test-date-query-params/{path}")
  @GET
  public Response testDateQueryParams( @PathParam("path") String pPath,
      @QueryParam("startTimestamp") OffsetDateTime pStartTimestamp, @QueryParam("startTime") OffsetTime pStartTime,
      @QueryParam("localStartTimestamp") LocalDateTime pLocalStartTimestamp,
      @QueryParam("localStartTime") LocalTime pLocalStartTime, @QueryParam("localStartDate") LocalDate pLocalStartDate,
      @QueryParam("calendar") Calendar pCalendar, @QueryParam("utilDate") java.util.Date pUtilDate,
      @QueryParam("sqlTimestamp") Timestamp pSQLTimestamp, @QueryParam("sqlTime") Time pSQLTime,
      @QueryParam("sqlDate") Date pSQLDate, @QueryParam("calendars") Set<Calendar> pCalendars ) {
    // Delegate request to service.
    rESTProductService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testDateQueryParamsBean()}
   */
  @Path("test-date-query-params-beans/{path}")
  @GET
  public Response testDateQueryParamsBean( @PathParam("path") String pPath,
      @BeanParam DateQueryParamsBean pQueryParams ) {
    // Delegate request to service.
    rESTProductService.testDateQueryParamsBean(pPath, pQueryParams);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testDateHeaderParams()}
   */
  @Path("test-date-header-params/{path}")
  @GET
  public Response testDateHeaderParams( @PathParam("path") String pPath,
      @HeaderParam("Offset-Date-Time") OffsetDateTime pOffsetDateTime,
      @HeaderParam("Offset-Time") OffsetTime pOffsetTime, @HeaderParam("Local-Date-Time") LocalDateTime pLocalDateTime,
      @HeaderParam("Local-Time") LocalTime pLocalTime, @HeaderParam("Local-Date") LocalDate pLocalDate,
      @HeaderParam("Calendar") Calendar pCalendar, @HeaderParam("Util-Date") java.util.Date pUtilDate,
      @HeaderParam("SQL-Timestamp") Timestamp pSQLTimestamp, @HeaderParam("SQL-Time") Time pSQLTime,
      @HeaderParam("SQL-Date") Date pSQLDate, @HeaderParam("util-dates") Set<java.util.Date> pUtilDates ) {
    // Delegate request to service.
    rESTProductService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testDateHeaderParamsBean()}
   */
  @Path("test-date-header-params-beans/{path}")
  @GET
  public Response testDateHeaderParamsBean( @PathParam("path") String pPath,
      @BeanParam DateHeaderParamsBean pHeaderParams ) {
    // Delegate request to service.
    rESTProductService.testDateHeaderParamsBean(pPath, pHeaderParams);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testCookieParams()}
   */
  @Path("cookies")
  @GET
  public Response testCookieParams( @CookieParam("Channel-Type-Param") ChannelType pChannelTypeParam,
      @BeanParam SpecialContext pContext, @javax.ws.rs.core.Context HttpHeaders pHeaders ) {
    // Add custom headers.
    for (Map.Entry<String, List<String>> lNextEntry : pHeaders.getRequestHeaders().entrySet()) {
      if (customHeaderFilter.test(lNextEntry.getKey())) {
        pContext.addCustomHeader(lNextEntry.getKey(), lNextEntry.getValue().get(0));
      }
    }
    // Delegate request to service.
    rESTProductService.testCookieParams(pChannelTypeParam, pContext);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testOptionalQueryParams()}
   */
  @Path("test-optional-query-params")
  @GET
  public Response testOptionalQueryParams( @QueryParam("query1") @DefaultValue("Just a default value") String query1,
      @QueryParam("query2") int query2 ) {
    // Delegate request to service.
    String lResult = rESTProductService.testOptionalQueryParams(query1, query2);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#processComplexBookingID()}
   */
  @Path("complex/{bookingID}")
  @GET
  public Response processComplexBookingID( @PathParam("bookingID") String pComplextBookingIDAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ComplexBookingID pComplextBookingID =
        this.deserializeCompositeDataType(pComplextBookingIDAsBasicType, ComplexBookingID.class);
    // Delegate request to service.
    boolean lResult = rESTProductService.processComplexBookingID(pComplextBookingID);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testDataTypesAsHeaderParam()}
   */
  @Path("dataTypesInHeader")
  @GET
  public Response testDataTypesAsHeaderParam( @HeaderParam("BookingID") String pBookingIDAsBasicType,
      @HeaderParam("BookingCode") String pBookingCodeAsBasicType,
      @HeaderParam("DoubleCode") Double pDoubleCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    BookingCode pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    DoubleCode pDoubleCode = DoubleCode.builder().setCode(pDoubleCodeAsBasicType).build();
    // Delegate request to service.
    String lResult = rESTProductService.testDataTypesAsHeaderParam(pBookingID, pBookingCode, pDoubleCode);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testDataTypesAsHeaderBeanParam()}
   */
  @Path("dataTypesInBeanHeader")
  @GET
  public Response testDataTypesAsHeaderBeanParam( @BeanParam AdvancedHeader pContext ) {
    // Delegate request to service.
    String lResult = rESTProductService.testDataTypesAsHeaderBeanParam(pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testPrimitiveArrays()}
   */
  @Path("testPrimitiveArrayAsBody")
  @POST
  public Response testPrimitiveArrays( int[] pIntegerArray ) {
    // Delegate request to service.
    String lResult = rESTProductService.testPrimitiveArrays(pIntegerArray);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testDataTypeAsQueryParam()}
   */
  @Path("testDataTypeAsQueryParam")
  @GET
  public Response testDataTypeAsQueryParam( @QueryParam("bookingCode") String pBookingCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingCode pBookingCode = BookingCode.builder().setCode(pBookingCodeAsBasicType).build();
    // Delegate request to service.
    String lResult = rESTProductService.testDataTypeAsQueryParam(pBookingCode);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testDataTypeAsBeanQueryParam()}
   */
  @Path("testDataTypeAsBeanQueryParam")
  @GET
  public Response testDataTypeAsBeanQueryParam( @BeanParam QueryBeanParam pBeanParam ) {
    // Delegate request to service.
    String lResult = rESTProductService.testDataTypeAsBeanQueryParam(pBeanParam);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testPrimitiveArrayAsQueryParam()}
   */
  @Path("testPrimitiveArrayAsQueryParam")
  @GET
  public Response testPrimitiveArrayAsQueryParam( @QueryParam("intValues") int[] pIntValues ) {
    // Delegate request to service.
    String lResult = rESTProductService.testPrimitiveArrayAsQueryParam(pIntValues);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testSimpleTypesAsQueryParams()}
   */
  @Path("testSimpleTypesAsQueryParams")
  @GET
  public Response testSimpleTypesAsQueryParams( @QueryParam("strings") List<String> pStrings ) {
    // Delegate request to service.
    String lResult = rESTProductService.testSimpleTypesAsQueryParams(pStrings);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testPrimitiveWrapperArrayAsQueryParam()}
   */
  @Path("testPrimitiveWrapperArrayAsQueryParam")
  @GET
  public Response testPrimitiveWrapperArrayAsQueryParam( @QueryParam("integers") Set<Integer> pIntegers ) {
    // Delegate request to service.
    String lResult = rESTProductService.testPrimitiveWrapperArrayAsQueryParam(pIntegers);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testMultivaluedQueryParamsBean()}
   */
  @Path("testMultivaluedQueryParamsBean")
  @GET
  public Response testMultivaluedQueryParamsBean( @BeanParam MultivaluedQueryParamsBean pBean ) {
    // Delegate request to service.
    String lResult = rESTProductService.testMultivaluedQueryParamsBean(pBean);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testMulitvaluedDataTypeAsQueryParam()}
   */
  @Path("testMulitvaluedDataTypeAsQueryParam")
  @GET
  public Response testMulitvaluedDataTypeAsQueryParam( @QueryParam("codes") int[] pCodesAsBasicType,
      @QueryParam("longCodes") Long[] pLongCodesAsBasicType, @QueryParam("bookingIDs") String[] pBookingIDsAsBasicType,
      @QueryParam("timestamps") List<OffsetDateTime> pTimestamps,
      @QueryParam("localDates") SortedSet<LocalDate> pLocalDates ) {
    // Convert basic type parameters into "real" objects.
    List<IntegerCodeType> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new ArrayList<IntegerCodeType>();
      for (int lNext : pCodesAsBasicType) {
        pCodes.add(IntegerCodeType.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptyList();
    }
    Set<LongCode> pLongCodes;
    if (pLongCodesAsBasicType != null) {
      pLongCodes = new HashSet<LongCode>();
      for (Long lNext : pLongCodesAsBasicType) {
        pLongCodes.add(LongCode.builder().setCode(lNext).build());
      }
    }
    else {
      pLongCodes = Collections.emptySet();
    }
    List<BookingID> pBookingIDs;
    if (pBookingIDsAsBasicType != null) {
      pBookingIDs = new ArrayList<BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        pBookingIDs.add(this.deserializeCompositeDataType(lNext, BookingID.class));
      }
    }
    else {
      pBookingIDs = Collections.emptyList();
    }
    // Delegate request to service.
    String lResult = rESTProductService.testMulitvaluedDataTypeAsQueryParam(pCodes, pLongCodes, pBookingIDs,
        pTimestamps, pLocalDates);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam()}
   */
  @Path("testMulitvaluedDataTypeAsBeanQueryParam")
  @GET
  public Response testMulitvaluedDataTypeAsBeanQueryParam( @BeanParam DataTypesQueryBean pQueryBean ) {
    // Delegate request to service.
    String lResult = rESTProductService.testMulitvaluedDataTypeAsBeanQueryParam(pQueryBean);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFieldsInBeanParam()}
   */
  @Path("testMultiValuedHeaderFieldsInBeanParam")
  @GET
  public Response testMultiValuedHeaderFieldsInBeanParam( @BeanParam MultiValuedHeaderBeanParam pMultiValuedBean ) {
    // Delegate request to service.
    String lResult = rESTProductService.testMultiValuedHeaderFieldsInBeanParam(pMultiValuedBean);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testMultiValuedHeaderFields()}
   */
  @Path("testMultiValuedHeaderFields")
  @GET
  public Response testMultiValuedHeaderFields( @HeaderParam("names") Set<String> pNames,
      @HeaderParam("ints") int[] pInts, @HeaderParam("doubles") Set<Double> pDoubles,
      @HeaderParam("codes") String[] pCodesAsBasicType, @HeaderParam("startDate") OffsetDateTime pStartDate,
      @HeaderParam("timestamps") Set<OffsetDateTime> pTimestamps, @HeaderParam("times") Set<OffsetTime> pTimes ) {
    // Convert basic type parameters into "real" objects.
    Set<StringCode> pCodes;
    if (pCodesAsBasicType != null) {
      pCodes = new HashSet<StringCode>();
      for (String lNext : pCodesAsBasicType) {
        pCodes.add(StringCode.builder().setCode(lNext).build());
      }
    }
    else {
      pCodes = Collections.emptySet();
    }
    // Delegate request to service.
    String lResult = rESTProductService.testMultiValuedHeaderFields(pNames, pInts, pDoubles, pCodes, pStartDate,
        pTimestamps, pTimes);
    // Validate response and return it.
    validationExecutor.validateResponse(RESTProductService.class, lResult);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link RESTProductService#testBookingIDAsPathParam()}
   */
  @Path("booking-id-as-path-param/{bookingID}")
  @PATCH
  public Response testBookingIDAsPathParam( @PathParam("bookingID") String pBookingIDAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    // Delegate request to service.
    rESTProductService.testBookingIDAsPathParam(pBookingID);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * {@link RESTProductService#testBookingIDAsHeaderParam()}
   */
  @Path("booking-id-as-header-param")
  @PATCH
  public Response testBookingIDAsHeaderParam( @HeaderParam("bookingID") String pBookingIDAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    BookingID pBookingID = this.deserializeCompositeDataType(pBookingIDAsBasicType, BookingID.class);
    // Delegate request to service.
    rESTProductService.testBookingIDAsHeaderParam(pBookingID);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
        lBuilder.append("\"");
        lBuilder.append(pCompositeDataTypeAsString);
        lBuilder.append("\"");
        lObject = objectMapper.readValue(lBuilder.toString(), pType);
      }
      else {
        lObject = null;
      }
      return lObject;
    }
    catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}
