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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyServiceParam;
import com.anaptecs.annotations.MyNotNullServiceParam;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
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
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @return {@link List<Product>} My default comment
   */
  @Size(min = 0, max = 4711)
  @Size(min = 1, groups = { V7.class })
  @MyNotEmptyServiceParam
  List<Product> getProducts( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @NotNull
  @MyNotNullServiceParam
  Product getProduct( @NotEmpty @NotNull @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pProduct My default comment
   * @return boolean
   */
  boolean createProduct( @NotNull @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @NotNull
  @MyNotNullServiceParam
  Sortiment getSortiment( @NotNull @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @NotNull
  @MyNotNullServiceParam
  ChannelCode createChannelCode( @NotBlank @NotNull @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   */
  @NotNull
  @MyNotNullServiceParam
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @return {@link String}
   */
  @Deprecated
  @NotNull
  @MyNotNullServiceParam
  String deprecatedOperation( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String deprecatedContext( @NotNull @MyNotNullServiceParam DeprecatedContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pBeanParam
   */
  @NotNull
  @MyNotNullServiceParam
  void deprecatedBeanParam( @NotNull @MyNotNullServiceParam BeanParameter pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @NotNull
  @MyNotNullServiceParam
  String deprecatedParams( @Deprecated int pParam1 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String deprecatedBody( @Deprecated @NotNull @MyNotNullServiceParam String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pProduct My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @NotNull
  @MyNotNullServiceParam
  void deprectedComplexRequestBody( @Deprecated @NotNull @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @return {@link Product} My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @NotNull
  @MyNotNullServiceParam
  Product deprecatedComplexReturn( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pContext
   */
  @NotNull
  @MyNotNullServiceParam
  void loadSpecificThings( @NotNull @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @NotNull
  @MyNotNullServiceParam
  ChannelCode createChannelCodeFromObject( @NotNull @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 1, max = 20)
  @Size(min = 1, groups = { V7.class })
  @MyNotEmptyServiceParam
  List<CurrencyCode> addCurrencies( @Size(min = 1) @MyNotEmptyServiceParam List<CurrencyCode> pCurrencies );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @NotNull
  @MyNotNullServiceParam
  CurrencyCode isCurrencySupported( @NotNull @MyNotNullServiceParam CurrencyCode pCurrency );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @NotNull
  @MyNotNullServiceParam
  IntegerCodeType testCodeTypeUsage( @NotNull @MyNotNullServiceParam StringCodeType pStringCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @Size(min = 111, max = 666)
  @NotNull
  @MyNotNullServiceParam
  String testLocalBeanParamType( @NotNull @MyNotNullServiceParam LocalBeanParamType pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pParent
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testExternalBeanParameterType( @NotNull @MyNotNullServiceParam ParentBeanParamType pParent );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pChild
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testChildBeanParameter( @NotNull @MyNotNullServiceParam ChildBeanParameterType pChild );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
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
  @NotNull
  @MyNotNullServiceParam
  void testDateQueryParams( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam OffsetDateTime pStartTimestamp,
      @NotNull @MyNotNullServiceParam OffsetTime pStartTime,
      @NotNull @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp,
      @NotNull @MyNotNullServiceParam LocalTime pLocalStartTime,
      @NotNull @MyNotNullServiceParam LocalDate pLocalStartDate, @NotNull @MyNotNullServiceParam Calendar pCalendar,
      @NotNull @MyNotNullServiceParam java.util.Date pUtilDate, @NotNull @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @NotNull @MyNotNullServiceParam Time pSQLTime, @NotNull @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pPath
   * @param pQueryParams
   */
  @NotNull
  @MyNotNullServiceParam
  void testDateQueryParamsBean( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
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
  @NotNull
  @MyNotNullServiceParam
  void testDateHeaderParams( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam OffsetDateTime pOffsetDateTime,
      @NotNull @MyNotNullServiceParam OffsetTime pOffsetTime,
      @NotNull @MyNotNullServiceParam LocalDateTime pLocalDateTime,
      @NotNull @MyNotNullServiceParam LocalTime pLocalTime, @NotNull @MyNotNullServiceParam LocalDate pLocalDate,
      @NotNull @MyNotNullServiceParam Calendar pCalendar, @NotNull @MyNotNullServiceParam java.util.Date pUtilDate,
      @NotNull @MyNotNullServiceParam Timestamp pSQLTimestamp, @NotNull @MyNotNullServiceParam Time pSQLTime,
      @NotNull @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pPath
   * @param pHeaderParams
   */
  @NotNull
  @MyNotNullServiceParam
  void testDateHeaderParamsBean( @NotNull @MyNotNullServiceParam String pPath,
      @NotNull @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testTechnicalHeaderParam( @NotNull @MyNotNullServiceParam String pReseller );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String testTechnicalHeaderBean( @NotNull @MyNotNullServiceParam TechnicalHeaderContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`NO_ACCESS`</code>
   *
   * @param pCodes
   * @return {@link String}
   */
  @NotNull
  @MyNotNullServiceParam
  String processDataTypes( @Size(min = 0, groups = { V7.class }) List<AnotherDataType> pCodes );
}