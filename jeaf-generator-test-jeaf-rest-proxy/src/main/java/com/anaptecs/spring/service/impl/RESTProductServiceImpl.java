
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.impl;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
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
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.AdvancedHeader;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.MultivaluedQueryParamsBean;
import com.anaptecs.spring.service.QueryBeanParam;
import com.anaptecs.spring.service.restproxy.RESTProductServiceRESTProxyServiceProvider;

/**
 * Implementation of RESTProductService.
 */
final class RESTProductServiceImpl extends RESTProductServiceImplBase {
  @JEAFServiceProvider
  private RESTProductServiceRESTProxyServiceProvider proxy;

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
    return proxy.getProducts(pMaxResultSize);
  }

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */

  @Override
  public Product getProduct( String pProductID ) {
    return proxy.getProduct(pProductID);
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */

  @Override
  public boolean createProduct( Product pProduct ) {
    return proxy.createProduct(pProduct);
  }

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return proxy.getSortiment(pContext);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */

  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    return proxy.createChannelCode(pChannelCode);
  }

  /**
  * 
  */

  @Override
  public void ping( ) {
    proxy.ping();
  }

  /**
  * 
  */

  @Override
  public void testInit( ) {
    proxy.testInit();
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    return proxy.getSupportedCurrencies(pChannelCode);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    return proxy.getSupportedCurrenciesAsync(pChannelCode);
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
    return proxy.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
  }

  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    proxy.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  @Override
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    proxy.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {

    proxy.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    proxy.testDateQueryParamsBean(pPath, pQueryParams);
  }

  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {

    proxy.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate, pCalendar,
        pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    proxy.testDateHeaderParamsBean(pPath, pHeaderParams);

  }

  @Override
  public void testCookieParams( ChannelType pChannelType, SpecialContext pContext ) {
    proxy.testCookieParams(pChannelType, pContext);
  }

  @Override
  public String testOptionalQueryParams( String pQuery1, int pQuery2 ) {
    return null;
  }

  @Override
  public boolean processComplexBookingID( ComplexBookingID pComplextBookingID ) {
    return false;
  }

  @Override
  public String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    return null;
  }

  @Override
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    return null;
  }

  @Override
  public String testPrimitiveArrays( int[] pIntegerArray ) {
    return null;
  }

  @Override
  public String testDataTypeAsQueryParam( BookingCode pBookingCode ) {
    return pBookingCode.getCode();
  }

  @Override
  public String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam ) {
    return pBeanParam.getBookingCode().getCode();
  }

  @Override
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    return Arrays.toString(pIntValues);
  }

  @Override
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    return pStrings.toString();
  }

  @Override
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    return pIntegers.toString();
  }

  @Override
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    return null;
  }

  @Override
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes ) {
    return null;
  }
}
