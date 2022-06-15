/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;

@Service
public class ProductServiceRESTProxy implements RESTProductService {
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
    lURIBuilder.append("/rest-products");
    lRequestBuilder.setUri(lURIBuilder.toString());

    // Set content type information
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    // Execute request and return result
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    List<Product> lResult = httpClient.executeCollectionResultRequest(lRequest, 200, List.class, Product.class);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();

    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/rest-products");
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
    // TODO Also include @PathParam, @QueryParam for normal and bean params
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/rest-products");
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
  public void testInit( ) {
    XFun.getTrace().info("Starting REST Proxy Init Test");
    assertEquals("http://localhost:8099", externalServiceURL);
    assertNotNull(httpClient);
  }

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    // Create builder for GET request
    ClassicRequestBuilder lRequestBuilder = ClassicRequestBuilder.get();

    // Build URI of request
    StringBuilder lURIBuilder = new StringBuilder();
    lURIBuilder.append(externalServiceURL);
    lURIBuilder.append("/rest-products");
    lURIBuilder.append("/currencies/");
    lURIBuilder.append(pChannelCode.getCode());
    lRequestBuilder.setUri(lURIBuilder.toString());

    // Set content type information
    lRequestBuilder.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

    // Execute request and return result
    ClassicHttpRequest lRequest = lRequestBuilder.build();
    List<CurrencyCode> lResult =
        httpClient.executeCollectionResultRequest(lRequest, 200, List.class, CurrencyCode.class);
    if (lResult == null) {
      lResult = Collections.emptyList();
    }
    return lResult;
  }
}
