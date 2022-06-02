/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.springframework.beans.factory.annotation.Value;

import com.anaptecs.jeaf.json.api.JSON;
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

// @Service
public class ProductServiceRESTProxy implements ProductService {
  /**
   * URL of the REST service that is proxied by this service implementation.
   */
  @Value("${productservice.externalURL}")
  private String externalServiceURL;

  @Inject
  private ProductServiceHttpClientSpring httpClient;

  @Override
  public List<Product> getProducts( ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();

    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/products");
    lRequestBuilder.setUri(lURIBuilder.toString());

    // Set content type information
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    // Execute request and return result
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeCollectionResultRequest(lRequest, 200, List.class, Product.class);
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();

    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/products");
    lURIBuilder.append("/");
    lURIBuilder.append(pProductID);
    lRequestBuilder.setUri(lURIBuilder.toString());

    // Set content type information
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    // Execute request and return result
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, 200, Product.class);
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    // Create builder for POST request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.post();

    // Build URI of request
    // TODO Also include @PathParam, @QueryParam from normal and bean params
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/products");
    lRequestBuilder.setUri(lURIBuilder.toString());

    // Set content type information
    // TODO Also add header params to request (from normal and bean params)
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    // Convert parameter pProduct into request body.
    String lRequestBody = JSON.getJSONTools().writeObjectToString(pProduct);
    lRequestBuilder.setEntity(lRequestBody, ContentType.APPLICATION_JSON);

    // Execute request and return result
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    return httpClient.executeSingleObjectResultRequest(lRequest, 200, Boolean.class);
  }

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return null;
  }

  @Override
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    return null;
  }

  @Override
  public void ping( ) {
  }

  @Override
  public String deprecatedOperation( ) {
    return null;
  }

  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    return null;
  }

  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
  }

  @Override
  public String deprecatedParams( int pParam1 ) {
    return null;
  }

  @Override
  public String deprecatedBody( String pBody ) {
    return null;
  }

  @Override
  public void deprectedComplexRequestBody( Product pProduct ) {
  }

  @Override
  public Product deprecatedComplexReturn( ) {
    return null;
  }

  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
  }

  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    return null;
  }

  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    return null;
  }

  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    return null;
  }

  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    return null;
  }

  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    return null;
  }

  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    return null;
  }

}
