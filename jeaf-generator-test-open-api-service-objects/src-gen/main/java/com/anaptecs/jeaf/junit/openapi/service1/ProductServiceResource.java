/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

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
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
import com.anaptecs.jeaf.junit.openapi.base.ParentBeanParamType;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;
import com.anaptecs.jeaf.junit.openapi.base.StringCodeType;
import com.anaptecs.jeaf.workload.api.Workload;
import com.anaptecs.jeaf.workload.api.WorkloadManager;
import com.anaptecs.jeaf.workload.api.rest.RESTRequestType;
import com.anaptecs.jeaf.workload.api.rest.RESTWorkloadErrorHandler;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
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
  public Response getProduct( @PathParam("id") @DefaultValue("4711") String pProductID ) {
    ProductService lService = this.getProductService();
    Product lResult = lService.getProduct(pProductID);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createProduct()}
   */
  @POST
  public Response createProduct( Product pProduct ) {
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
    ProductService lService = this.getProductService();
    Sortiment lResult = lService.getSortiment(pContext);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#createChannelCode()}
   */
  @Path("ChannelCode")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public Response createChannelCode( String pChannelCode ) {
    ProductService lService = this.getProductService();
    ChannelCode lResult = lService.createChannelCode(pChannelCode);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#ping()}
   */
  @HEAD
  public Response ping( ) {
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
    ProductService lService = this.getProductService();
    IntegerCodeType lResult = lService.testCodeTypeUsage(pStringCode);
    return Response.status(Response.Status.ACCEPTED).entity(lResult).build();
  }

  /**
   * {@link ProductService#testLocalBeanParamType()}
   */
  @Path("/LocalBeanParam")
  @GET
  public Response testLocalBeanParamType( @BeanParam LocalBeanParamType pBeanParam ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testLocalBeanParamType(pBeanParam);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testExternalBeanParameterType()}
   */
  @Path("/ExternalBeanParam")
  @GET
  public Response testExternalBeanParameterType( @BeanParam ParentBeanParamType pParent ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testExternalBeanParameterType(pParent);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#testChildBeanParameter()}
   */
  @Path("/ChildBeanParam")
  @GET
  public Response testChildBeanParameter( @BeanParam ChildBeanParameterType pChild ) {
    ProductService lService = this.getProductService();
    String lResult = lService.testChildBeanParameter(pChild);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#checkIBAN()}
   */
  @Path("IBAN")
  @POST
  public Response checkIBAN( String pIBAN ) {
    ProductService lService = this.getProductService();
    boolean lResult = lService.checkIBAN(pIBAN);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getChannels()}
   */
  @Path("channels")
  @GET
  public Response getChannels( @QueryParam("channelTypes") @DefaultValue("MOBILE") List<ChannelType> pChannelTypes ) {
    ProductService lService = this.getProductService();
    List<Channel> lResult = lService.getChannels(pChannelTypes);
    return Response.status(Response.Status.OK).entity(lResult).build();
  }

  /**
   * {@link ProductService#getDefaultChannel()}
   */
  @Path("DefaultChannel")
  @GET
  public Response getDefaultChannel( @QueryParam("channelType") @DefaultValue("COUNTER") ChannelType pChannelType ) {
    ProductService lService = this.getProductService();
    Channel lResult = lService.getDefaultChannel(pChannelType);
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
}
