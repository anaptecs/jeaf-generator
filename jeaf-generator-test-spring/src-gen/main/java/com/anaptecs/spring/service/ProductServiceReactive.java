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
import com.anaptecs.spring.service.monitoring.MonitoringServiceReactive;
import reactor.core.publisher.Mono;

public interface ProductServiceReactive extends MonitoringServiceReactive {
  /**
   * Operation returns all available product.
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link List<Product>} My default comment
   */
  @Size(min = 0, max = 4711)
  @MyNotEmptyServiceParam
  Mono<List<Product>> getProducts( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @MyNotNullServiceParam
  Mono<Product> getProduct( @NotEmpty @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProduct My default comment
   * @return boolean
   */
  Mono<Boolean> createProduct( @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @MyNotNullServiceParam
  Mono<Sortiment> getSortiment( @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNullServiceParam
  Mono<ChannelCode> createChannelCode( @NotBlank @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   */
  @MyNotNullServiceParam
  Mono<Void> ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link String}
   */
  @Deprecated
  @MyNotNullServiceParam
  Mono<String> deprecatedOperation( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> deprecatedContext( @MyNotNullServiceParam DeprecatedContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBeanParam
   */
  @MyNotNullServiceParam
  Mono<Void> deprecatedBeanParam( @MyNotNullServiceParam BeanParameter pBeanParam );

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
  @MyNotNullServiceParam
  Mono<String> deprecatedParams( @Deprecated int pParam1 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> deprecatedBody( @Deprecated @MyNotNullServiceParam String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pProduct My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @MyNotNullServiceParam
  Mono<Void> deprectedComplexRequestBody( @Deprecated @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @return {@link Product} My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  @MyNotNullServiceParam
  Mono<Product> deprecatedComplexReturn( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   */
  @MyNotNullServiceParam
  Mono<Void> loadSpecificThings( @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  @MyNotNullServiceParam
  Mono<ChannelCode> createChannelCodeFromObject( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 1, max = 20)
  @MyNotEmptyServiceParam
  Mono<List<CurrencyCode>> addCurrencies( @MyNotEmptyServiceParam List<CurrencyCode> pCurrencies );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  @MyNotNullServiceParam
  Mono<CurrencyCode> isCurrencySupported( @MyNotNullServiceParam CurrencyCode pCurrency );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  @MyNotNullServiceParam
  Mono<IntegerCodeType> testCodeTypeUsage( @MyNotNullServiceParam StringCodeType pStringCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @Size(min = 111, max = 666)
  @MyNotNullServiceParam
  Mono<String> testLocalBeanParamType( @MyNotNullServiceParam LocalBeanParamType pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pParent
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testExternalBeanParameterType( @MyNotNullServiceParam ParentBeanParamType pParent );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pChild
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testChildBeanParameter( @MyNotNullServiceParam ChildBeanParameterType pChild );

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
  @MyNotNullServiceParam
  Mono<Void> testDateQueryParams( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam OffsetDateTime pStartTimestamp, @MyNotNullServiceParam OffsetTime pStartTime,
      @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp, @MyNotNullServiceParam LocalTime pLocalStartTime,
      @MyNotNullServiceParam LocalDate pLocalStartDate, @MyNotNullServiceParam Calendar pCalendar,
      @MyNotNullServiceParam java.util.Date pUtilDate, @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @MyNotNullServiceParam Time pSQLTime, @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNullServiceParam
  Mono<Void> testDateQueryParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

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
  @MyNotNullServiceParam
  Mono<Void> testDateHeaderParams( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam OffsetDateTime pOffsetDateTime, @MyNotNullServiceParam OffsetTime pOffsetTime,
      @MyNotNullServiceParam LocalDateTime pLocalDateTime, @MyNotNullServiceParam LocalTime pLocalTime,
      @MyNotNullServiceParam LocalDate pLocalDate, @MyNotNullServiceParam Calendar pCalendar,
      @MyNotNullServiceParam java.util.Date pUtilDate, @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @MyNotNullServiceParam Time pSQLTime, @MyNotNullServiceParam Date pSQLDate );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNullServiceParam
  Mono<Void> testDateHeaderParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testTechnicalHeaderParam( @MyNotNullServiceParam String pReseller );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testTechnicalHeaderBean( @MyNotNullServiceParam TechnicalHeaderContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> NO_ACCESS
   *
   * @param pCodes
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> processDataTypes( List<AnotherDataType> pCodes );
}