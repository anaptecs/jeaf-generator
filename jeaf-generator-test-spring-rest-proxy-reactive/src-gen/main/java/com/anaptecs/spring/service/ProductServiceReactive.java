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
   *
   * @return {@link List<Product>} My default comment
   */
  @Size(min = 0, max = 4711)
  Mono<List<Product>> getProducts( );

  /**
   * @param pProductID
   * @return {@link Product} My default comment
   */
  Mono<Product> getProduct( @NotEmpty String pProductID );

  /**
   * @param pProduct My default comment
   * @return boolean
   */
  Mono<Boolean> createProduct( Product pProduct );

  /**
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  Mono<Sortiment> getSortiment( Context pContext );

  /**
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  Mono<ChannelCode> createChannelCode( @NotBlank String pChannelCode );

  /**
   */
  Mono<Void> ping( );

  /**
   * @return {@link String}
   */
  @Deprecated
  Mono<String> deprecatedOperation( );

  /**
   * @param pContext
   * @return {@link String}
   */
  Mono<String> deprecatedContext( DeprecatedContext pContext );

  /**
   * @param pBeanParam
   */
  Mono<Void> deprecatedBeanParam( BeanParameter pBeanParam );

  /**
   * @param pParam1 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  Mono<String> deprecatedParams( @Deprecated int pParam1 );

  /**
   * @param pBody <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String}
   */
  Mono<String> deprecatedBody( @Deprecated String pBody );

  /**
   * Please be aware that deprecations on complex bodies are not supported. Instead the whole operation needs to be set
   * to deprecated.
   *
   * @param pProduct My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  Mono<Void> deprectedComplexRequestBody( @Deprecated Product pProduct );

  /**
   * @return {@link Product} My default comment <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  Mono<Product> deprecatedComplexReturn( );

  /**
   * @param pContext
   */
  Mono<Void> loadSpecificThings( SpecialContext pContext );

  /**
   * @param pChannelCode Channel Code that should be created.
   * @return {@link ChannelCode} Created channel code
   */
  Mono<ChannelCode> createChannelCodeFromObject( ChannelCode pChannelCode );

  /**
   * @param pCurrencies
   * @return {@link List<CurrencyCode>}
   */
  @Size(min = 1, max = 20)
  Mono<List<CurrencyCode>> addCurrencies( List<CurrencyCode> pCurrencies );

  /**
   * @param pCurrency
   * @return {@link CurrencyCode}
   */
  Mono<CurrencyCode> isCurrencySupported( CurrencyCode pCurrency );

  /**
   * @param pStringCode
   * @return {@link IntegerCodeType}
   */
  Mono<IntegerCodeType> testCodeTypeUsage( StringCodeType pStringCode );

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  @Size(min = 111, max = 666)
  Mono<String> testLocalBeanParamType( LocalBeanParamType pBeanParam );

  /**
   * @param pParent
   * @return {@link String}
   */
  Mono<String> testExternalBeanParameterType( ParentBeanParamType pParent );

  /**
   * @param pChild
   * @return {@link String}
   */
  Mono<String> testChildBeanParameter( ChildBeanParameterType pChild );

  /**
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
  Mono<Void> testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate );

  /**
   * @param pPath
   * @param pQueryParams
   */
  Mono<Void> testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams );

  /**
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
  Mono<Void> testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate );

  /**
   * @param pPath
   * @param pHeaderParams
   */
  Mono<Void> testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams );

  /**
   * @param pReseller
   * @param pAuthenticationToken
   * @return {@link String}
   */
  Mono<String> testTechnicalHeaderParam( String pReseller );

  /**
   * @param pContext
   * @return {@link String}
   */
  Mono<String> testTechnicalHeaderBean( TechnicalHeaderContext pContext );

  /**
   * @param pCodes
   * @return {@link String}
   */
  Mono<String> processDataTypes( List<AnotherDataType> pCodes );
}