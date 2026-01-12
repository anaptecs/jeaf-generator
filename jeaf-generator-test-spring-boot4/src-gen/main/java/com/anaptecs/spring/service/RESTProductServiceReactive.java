/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;
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
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.annotations.MyNotEmptyServiceParam;
import com.anaptecs.annotations.MyNotNullServiceParam;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCodeType;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.composite.ComplexBookingID;
import reactor.core.publisher.Mono;

public interface RESTProductServiceReactive {
  /**
   * Operation returns all available product.
   * <p/>
   * <b>Authorized Roles:</b> <code>`Customer`, `Sales Agent`</code>
   *
   * @param pMaxResultSize
   * @return {@link List<Product>} My default comment
   */
  Mono<List<Product>> getProducts( int pMaxResultSize );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pProductID
   * @return {@link Product} My default comment
   */
  @MyNotNullServiceParam
  Mono<Product> getProduct( @NotEmpty @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pProduct My default comment
   * @return boolean
   */
  Mono<Boolean> createProduct( @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext Default Comment
   * @return {@link Sortiment}
   */
  @MyNotNullServiceParam
  Mono<Sortiment> getSortiment( @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNullServiceParam
  Mono<ChannelCode> createChannelCode( @NotBlank @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Customer`, `Sales Agent`</code>
   */
  @MyNotNullServiceParam
  Mono<Void> ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   */
  @MyNotNullServiceParam
  Mono<Void> testInit( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  Mono<List<CurrencyCode>> getSupportedCurrencies( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  Mono<List<CurrencyCode>> getSupportedCurrenciesAsync( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testParams( @MyNotNullServiceParam BigDecimal pBigDecimalHeader, int pIntCookieParam,
      @MyNotNullServiceParam Locale pLocaleQueryParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNullServiceParam
  Mono<Void> testEnumParams( @MyNotNullServiceParam ChannelType pChannelType, @MyNotNullServiceParam TimeUnit pTimeUnit,
      @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNullServiceParam
  Mono<Void> testEnumHeaderParams( @MyNotNullServiceParam ChannelType pChannelType,
      @MyNotNullServiceParam TimeUnit pTimeUnit, @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
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
   * @param pCalendars
   */
  @MyNotNullServiceParam
  Mono<Void> testDateQueryParams( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam OffsetDateTime pStartTimestamp, @MyNotNullServiceParam OffsetTime pStartTime,
      @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp, @MyNotNullServiceParam LocalTime pLocalStartTime,
      @MyNotNullServiceParam LocalDate pLocalStartDate, @MyNotNullServiceParam Calendar pCalendar,
      @MyNotNullServiceParam java.util.Date pUtilDate, @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @MyNotNullServiceParam Time pSQLTime, @MyNotNullServiceParam Date pSQLDate, Set<Calendar> pCalendars );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNullServiceParam
  Mono<Void> testDateQueryParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
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
   * @param pUtilDates
   */
  @MyNotNullServiceParam
  Mono<Void> testDateHeaderParams( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam OffsetDateTime pOffsetDateTime, @MyNotNullServiceParam OffsetTime pOffsetTime,
      @MyNotNullServiceParam LocalDateTime pLocalDateTime, @MyNotNullServiceParam LocalTime pLocalTime,
      @MyNotNullServiceParam LocalDate pLocalDate, @MyNotNullServiceParam Calendar pCalendar,
      @MyNotNullServiceParam java.util.Date pUtilDate, @MyNotNullServiceParam Timestamp pSQLTimestamp,
      @MyNotNullServiceParam Time pSQLTime, @MyNotNullServiceParam Date pSQLDate, Set<java.util.Date> pUtilDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNullServiceParam
  Mono<Void> testDateHeaderParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pChannelTypeParam
   * @param pContext
   */
  @MyNotNullServiceParam
  Mono<Void> testCookieParams( @MyNotNullServiceParam ChannelType pChannelTypeParam,
      @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testOptionalQueryParams( String query1, int query2 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pComplextBookingID
   * @return boolean
   */
  Mono<Boolean> processComplexBookingID( @MyNotNullServiceParam ComplexBookingID pComplextBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCodeType pDoubleCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testDataTypesAsHeaderBeanParam( @MyNotNullServiceParam AdvancedHeader pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntegerArray
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testPrimitiveArrays( int[] pIntegerArray );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingCode
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testDataTypeAsQueryParam( @MyNotNullServiceParam BookingCode pBookingCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testDataTypeAsBeanQueryParam( @MyNotNullServiceParam QueryBeanParam pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntValues
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pStrings
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testSimpleTypesAsQueryParams( List<String> pStrings );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pIntegers
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testPrimitiveWrapperArrayAsQueryParam( @MyNotEmptyServiceParam Set<Integer> pIntegers );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testMultivaluedQueryParamsBean( @MyNotNullServiceParam MultivaluedQueryParamsBean pBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @param pTimestamps
   * @param pLocalDates
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes,
      @MyNotEmptyServiceParam Set<LongCode> pLongCodes, List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps,
      SortedSet<LocalDate> pLocalDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pQueryBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testMulitvaluedDataTypeAsBeanQueryParam( @MyNotNullServiceParam DataTypesQueryBean pQueryBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testMultiValuedHeaderFieldsInBeanParam(
      @MyNotNullServiceParam MultiValuedHeaderBeanParam pMultiValuedBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pNames
   * @param pInts
   * @param pDoubles
   * @param pCodes
   * @param pStartDate
   * @param pTimestamps
   * @param pTimes
   * @param pBase64
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testMultiValuedHeaderFields( Set<String> pNames, @MyNotEmptyServiceParam int[] pInts,
      Set<Double> pDoubles, Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps,
      Set<OffsetTime> pTimes, byte[] pBase64 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   */
  @MyNotNullServiceParam
  Mono<Void> testBookingIDAsPathParam( @MyNotNullServiceParam BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pBookingID
   */
  @MyNotNullServiceParam
  Mono<Void> testBookingIDAsHeaderParam( BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testContextWithPrimitives( @MyNotNullServiceParam ContextWithPrimitives pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> <code>`Sales Agent`</code>
   *
   * @param pAnInt
   * @param pAnInteger
   * @param pABoolean
   * @param pBooleanWrapper
   * @param pALong
   * @param pVeryLong
   * @return {@link String}
   */
  @MyNotNullServiceParam
  Mono<String> testPrimitivesAsParams( int pAnInt, @MyNotNullServiceParam Integer pAnInteger, boolean pABoolean,
      @MyNotNullServiceParam Boolean pBooleanWrapper, long pALong, @MyNotNullServiceParam Long pVeryLong );
}