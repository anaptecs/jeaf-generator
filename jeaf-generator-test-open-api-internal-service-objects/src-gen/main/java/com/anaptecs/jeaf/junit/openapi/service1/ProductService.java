/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.Service;
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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public interface ProductService extends Service {
  /**
   * Operation returns all available product.
   * 
   * 
   * @return {@link Product}
   */
  List<Product> getProducts( );

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  Product getProduct( @NotEmpty String pProductID );

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */
  boolean createProduct( Product pProduct );

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */
  Sortiment getSortiment( Context pContext );

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  ChannelCode createChannelCode( @NotBlank String pChannelCode );

  /**
  * 
  */
  void ping( );

  /**
   * 
   * @return {@link String}
   */
  @Deprecated
  String deprecatedOperation( );

  /**
   * 
   * @param pContext
   * @return {@link String}
   */
  String deprecatedContext( DeprecatedContext pContext );

  /**
   * 
   * @param pBeanParam
   */
  void deprecatedBeanParam( BeanParameter pBeanParam );

  /**
   * 
   * @param pParam1
   * @return {@link String}
   */
  @Deprecated
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * 
   * @param pBody
   * @return {@link String}
   */
  String deprecatedBody( @Deprecated String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * 
   * 
   * @param pProduct
   */
  void deprectedComplexRequestBody( @Deprecated Product pProduct );

  /**
   * 
   * @return {@link Product}
   */
  @Deprecated
  Product deprecatedComplexReturn( );

  /**
   * 
   * @param pContext
   */
  void loadSpecificThings( SpecialContext pContext );

  /**
   * 
   * @param pChannelCode Channel Code that should be created.
   * 
   * @return {@link ChannelCode} Created channel code
   * 
   */
  ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode );

  /**
   * 
   * @param pCurrencies
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies );

  /**
   * 
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  CurrencyCode isCurrencySupported( CurrencyCode pCurrency );

  /**
   * 
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode );

  /**
   * 
   * @param pBeanParam
   * @return {@link String}
   */
  String testLocalBeanParamType( LocalBeanParamType pBeanParam );

  /**
   * 
   * @param pParent
   * @return {@link String}
   */
  String testExternalBeanParameterType( ParentBeanParamType pParent );

  /**
   * 
   * @param pChild
   * @return {@link String}
   */
  String testChildBeanParameter( ChildBeanParameterType pChild );

  /**
   * 
   * @param pIBAN
   * @return {@link Boolean}
   */
  boolean checkIBAN( String pIBAN );

  /**
   * 
   * @param pChannelTypes
   * @return {@link Channel}
   */
  List<Channel> getChannels( List<ChannelType> pChannelTypes );

  /**
   * 
   * @param pChannelType
   * @return {@link Channel}
   */
  Channel getDefaultChannel( ChannelType pChannelType );

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode );

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode );

  /**
   * 
   * @param pPath
   * @param pStartTimestamp
   * @param pStartTime
   * @param pLocalStartTimestamp
   * @param pLocalStartTime
   * @param pLocalStartDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate );

  /**
   * 
   * @param pPath
   * @param pQueryParams
   */
  void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams );
}