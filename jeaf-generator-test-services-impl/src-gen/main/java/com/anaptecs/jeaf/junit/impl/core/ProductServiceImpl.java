/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.impl.core;

import java.util.List;

import com.anaptecs.jeaf.core.api.Component;
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
import com.anaptecs.jeaf.junit.openapi.service1.ChildBeanParameterType;
import com.anaptecs.jeaf.junit.openapi.service1.LocalBeanParamType;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;

/**
 * Implementation of ProductService.
 */
final class ProductServiceImpl extends ProductServiceImplBase {
  /**
   * Initialize object.
   */
  ProductServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // TODO Implement checks for this service
    return null;
  }

  /**
   * Operation returns all available product.
   * 
   * 
   * @return {@link Product}
   */
  @Override
  public List<Product> getProducts( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  @Override
  public Product getProduct( String pProductID ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */
  @Override
  public boolean createProduct( Product pProduct ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */
  @Override
  public Sortiment getSortiment( Context pContext ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
  * 
  */
  @Override
  public void ping( ) {
  }

  /**
   * 
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String deprecatedOperation( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pContext
   * @return {@link String}
   */
  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pBeanParam
   */
  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
  }

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  @Override
  public String deprecatedParams( @Deprecated int pParam1 ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pBody
   * @return {@link String}
   */
  @Override
  public String deprecatedBody( @Deprecated String pBody ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * 
   * 
   * @param pProduct
   */
  @Override
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
  }

  /**
   * 
   * @return {@link Product}
   */
  @Deprecated
  @Override
  public Product deprecatedComplexReturn( ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pContext
   */
  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
  }

  /**
   * 
   * @param pChannelCode Channel Code that should be created.
   * 
   * @return {@link ChannelCode} Created channel code
   * 
   */
  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pCurrencies
   * @return {@link CurrencyCode}
   */
  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pBeanParam
   * @return {@link String}
   */
  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pParent
   * @return {@link String}
   */
  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pChild
   * @return {@link String}
   */
  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pIBAN
   * @return {@link Boolean}
   */
  @Override
  public boolean checkIBAN( String pIBAN ) {
    // TODO Implement method and return real result
    return false;
  }

  /**
   * 
   * @param pChannelTypes
   * @return {@link Channel}
   */
  @Override
  public List<Channel> getChannels( List<ChannelType> pChannelTypes ) {
    // TODO Implement method and return real result
    return null;
  }

  /**
   * 
   * @param pChannelType
   * @return {@link Channel}
   */
  @Override
  public Channel getDefaultChannel( ChannelType pChannelType ) {
    // TODO Implement method and return real result
    return null;
  }
}
