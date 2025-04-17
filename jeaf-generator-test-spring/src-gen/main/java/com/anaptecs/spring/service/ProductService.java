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
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyServiceParam;
import com.anaptecs.annotations.MyNotNullServiceParam;
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
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @return {@link List<Product>} My default comment
   */
  @Size(min = 0, max = 4711)
  @MyNotEmptyServiceParam
  List<Product> getProducts( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @MyNotNullServiceParam
  Product getProduct( @NotEmpty @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pProduct My default comment
   * @return boolean
   */
  boolean createProduct( @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @MyNotNullServiceParam
  Sortiment getSortiment( @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNullServiceParam
  ChannelCode createChannelCode( @NotBlank @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   */
  @MyNotNullServiceParam
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @return {@link String}
   */
  @Deprecated
  @MyNotNullServiceParam
  String deprecatedOperation( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String deprecatedContext( @MyNotNullServiceParam DeprecatedContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pBeanParam
   */
  @MyNotNullServiceParam
  void deprecatedBeanParam( @MyNotNullServiceParam BeanParameter pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNullServiceParam
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String deprecatedBody( @Deprecated @MyNotNullServiceParam String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pProduct My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @MyNotNullServiceParam
  void deprectedComplexRequestBody( @Deprecated @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @return {@link Product} My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNullServiceParam
  Product deprecatedComplexReturn( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pContext
   */
  @MyNotNullServiceParam
  void loadSpecificThings( @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @MyNotNullServiceParam
  ChannelCode createChannelCodeFromObject( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 1, max = 20)
  @MyNotEmptyServiceParam
  List<CurrencyCode> addCurrencies( @MyNotEmptyServiceParam List<CurrencyCode> pCurrencies );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @MyNotNullServiceParam
  CurrencyCode isCurrencySupported( @MyNotNullServiceParam CurrencyCode pCurrency );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @MyNotNullServiceParam
  IntegerCodeType testCodeTypeUsage( @MyNotNullServiceParam StringCodeType pStringCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @Size(min = 111, max = 666)
  @MyNotNullServiceParam
  String testLocalBeanParamType( @MyNotNullServiceParam LocalBeanParamType pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pParent
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testExternalBeanParameterType( @MyNotNullServiceParam ParentBeanParamType pParent );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pChild
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testChildBeanParameter( @MyNotNullServiceParam ChildBeanParameterType pChild );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
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
  @MyNotNullServiceParam
  void testDateQueryParams( @MyNotNullServiceParam String pPath, @MyNotNullServiceParam OffsetDateTime pStartTimestamp,
      @MyNotNullServiceParam OffsetTime pStartTime, @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp,
      @MyNotNullServiceParam LocalTime pLocalStartTime, @MyNotNullServiceParam LocalDate pLocalStartDate,
      @MyNotNullServiceParam Calendar pCalendar, @MyNotNullServiceParam java.util.Date pUtilDate,
      @MyNotNullServiceParam Timestamp pSQLTimestamp, @MyNotNullServiceParam Time pSQLTime,
      @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNullServiceParam
  void testDateQueryParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
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
  @MyNotNullServiceParam
  void testDateHeaderParams( @MyNotNullServiceParam String pPath, @MyNotNullServiceParam OffsetDateTime pOffsetDateTime,
      @MyNotNullServiceParam OffsetTime pOffsetTime, @MyNotNullServiceParam LocalDateTime pLocalDateTime,
      @MyNotNullServiceParam LocalTime pLocalTime, @MyNotNullServiceParam LocalDate pLocalDate,
      @MyNotNullServiceParam Calendar pCalendar, @MyNotNullServiceParam java.util.Date pUtilDate,
      @MyNotNullServiceParam Timestamp pSQLTimestamp, @MyNotNullServiceParam Time pSQLTime,
      @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNullServiceParam
  void testDateHeaderParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testTechnicalHeaderParam( @MyNotNullServiceParam String pReseller );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testTechnicalHeaderBean( @MyNotNullServiceParam TechnicalHeaderContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>NO_ACCESS</code>
   *
   * @param pCodes
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String processDataTypes( List<AnotherDataType> pCodes );
}