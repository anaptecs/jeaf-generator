/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.service;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

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
  CloseableHttpClient getHttpClient( ) {
    // Ensure that configuration of http client matches to the called REST service
    return null;
  }

  @Override
  public List<Product> getProducts( ) {
    return null;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    return null;
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    return false;
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
