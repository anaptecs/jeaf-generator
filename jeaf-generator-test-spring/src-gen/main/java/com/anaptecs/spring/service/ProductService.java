/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

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

import com.anaptecs.annotations.MyNotEmpty;
import com.anaptecs.annotations.MyNotNull;
import com.anaptecs.spring.base.AnotherDataType;
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
import com.anaptecs.spring.service.monitoring.MonitoringService;

public interface ProductService extends MonitoringService {
  /**
   * Operation returns all available product.
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link List<Product>}
   */
  List<Product> getProducts( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProductID
   * @return {@link Product}
   */
  @MyNotNull
  Product getProduct( @NotEmpty @MyNotNull String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProduct
   * @return boolean
   */
  boolean createProduct( @MyNotNull Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   * @return {@link Sortiment}
   */
  @MyNotNull
  Sortiment getSortiment( @MyNotNull Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNull
  ChannelCode createChannelCode( @NotBlank @MyNotNull String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   */
  @MyNotNull
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  @Deprecated
  @MyNotNull
  String deprecatedOperation( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String deprecatedContext( @MyNotNull DeprecatedContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBeanParam
   */
  @MyNotNull
  void deprecatedBeanParam( @MyNotNull BeanParameter pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNull
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @MyNotNull
  String deprecatedBody( @Deprecated @MyNotNull String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProduct <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @MyNotNull
  void deprectedComplexRequestBody( @Deprecated @MyNotNull Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link Product} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNull
  Product deprecatedComplexReturn( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   */
  @MyNotNull
  void loadSpecificThings( @MyNotNull SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @MyNotNull
  ChannelCode createChannelCodeFromObject( @MyNotNull ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @MyNotEmpty
  List<CurrencyCode> addCurrencies( @MyNotEmpty List<CurrencyCode> pCurrencies );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @MyNotNull
  CurrencyCode isCurrencySupported( @MyNotNull CurrencyCode pCurrency );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @MyNotNull
  IntegerCodeType testCodeTypeUsage( @MyNotNull StringCodeType pStringCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNull
  String testLocalBeanParamType( @MyNotNull LocalBeanParamType pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pParent
   * @return {@link String}
   */
  @MyNotNull
  String testExternalBeanParameterType( @MyNotNull ParentBeanParamType pParent );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChild
   * @return {@link String}
   */
  @MyNotNull
  String testChildBeanParameter( @MyNotNull ChildBeanParameterType pChild );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
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
  @MyNotNull
  void testDateQueryParams( @MyNotNull String pPath, @MyNotNull OffsetDateTime pStartTimestamp,
      @MyNotNull OffsetTime pStartTime, @MyNotNull LocalDateTime pLocalStartTimestamp,
      @MyNotNull LocalTime pLocalStartTime, @MyNotNull LocalDate pLocalStartDate, @MyNotNull Calendar pCalendar,
      @MyNotNull java.util.Date pUtilDate, @MyNotNull Timestamp pSQLTimestamp, @MyNotNull Time pSQLTime,
      @MyNotNull Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNull
  void testDateQueryParamsBean( @MyNotNull String pPath, @MyNotNull DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pPath
   * @param pOffsetDateTime
   * @param pOffsetTime
   * @param pLocalDateTime
   * @param pLocalTime
   * @param pLocalDate
   * @param pCalendar
   * @param pUtilDate
   * @param pSQLTimestamp
   * @param pSQLTime
   * @param pSQLDate
   */
  @MyNotNull
  void testDateHeaderParams( @MyNotNull String pPath, @MyNotNull OffsetDateTime pOffsetDateTime,
      @MyNotNull OffsetTime pOffsetTime, @MyNotNull LocalDateTime pLocalDateTime, @MyNotNull LocalTime pLocalTime,
      @MyNotNull LocalDate pLocalDate, @MyNotNull Calendar pCalendar, @MyNotNull java.util.Date pUtilDate,
      @MyNotNull Timestamp pSQLTimestamp, @MyNotNull Time pSQLTime, @MyNotNull Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNull
  void testDateHeaderParamsBean( @MyNotNull String pPath, @MyNotNull DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @MyNotNull
  String testTechnicalHeaderParam( @MyNotNull String pReseller );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String testTechnicalHeaderBean( @MyNotNull TechnicalHeaderContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCodes
   * @return {@link String}
   */
  @MyNotNull
  String processDataTypes( List<AnotherDataType> pCodes );
}
