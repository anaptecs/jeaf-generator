
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;

/**
 * Implementation of RESTProductService.
 */
final class RESTProductServiceImpl extends RESTProductServiceImplBase {
  /**
   * Initialize object.
   */
  RESTProductServiceImpl( Component pComponent ) {
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
    return null;
  }

  /**
   * Operation returns all available product.
   * 
   * 
   * @param pMaxResultSize
   * @return {@link Product}
   */

  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    return null;
  }

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */

  @Override
  public Product getProduct( String pProductID ) {
    return null;
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */

  @Override
  public boolean createProduct( Product pProduct ) {
    return false;
  }

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return null;
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */

  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
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
  */

  @Override
  public void testInit( ) {
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    return null;
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    return null;
  }

  /**
   * 
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */

  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    return null;
  }
}
