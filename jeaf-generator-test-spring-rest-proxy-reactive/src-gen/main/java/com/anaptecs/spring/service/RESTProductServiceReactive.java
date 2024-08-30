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

import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
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
   *
   * @param pMaxResultSize
   * @return {@link List<Product>}
   */
  Mono<List<Product>> getProducts( int pMaxResultSize );

  /**
   * @param pProductID
   * @return {@link Product}
   */
  Mono<Product> getProduct( @NotEmpty String pProductID );

  /**
   * @param pProduct
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
   */
  Mono<Void> testInit( );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  Mono<List<CurrencyCode>> getSupportedCurrencies( ChannelCode pChannelCode );

  /**
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  Mono<List<CurrencyCode>> getSupportedCurrenciesAsync( ChannelCode pChannelCode );

  /**
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  Mono<String> testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam );

  /**
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  Mono<Void> testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum );

  /**
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  Mono<Void> testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum );

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
   * @param pCalendars
   */
  Mono<Void> testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<Calendar> pCalendars );

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
   * @param pUtilDates
   */
  Mono<Void> testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<java.util.Date> pUtilDates );

  /**
   * @param pPath
   * @param pHeaderParams
   */
  Mono<Void> testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams );

  /**
   * @param pChannelTypeParam
   * @param pContext
   */
  Mono<Void> testCookieParams( ChannelType pChannelTypeParam, SpecialContext pContext );

  /**
   * @param query1
   * @param query2
   * @return {@link String}
   */
  Mono<String> testOptionalQueryParams( String query1, int query2 );

  /**
   * @param pComplextBookingID
   * @return boolean
   */
  Mono<Boolean> processComplexBookingID( ComplexBookingID pComplextBookingID );

  /**
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  Mono<String> testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode );

  /**
   * @param pContext
   * @return {@link String}
   */
  Mono<String> testDataTypesAsHeaderBeanParam( AdvancedHeader pContext );

  /**
   * @param pIntegerArray
   * @return {@link String}
   */
  Mono<String> testPrimitiveArrays( int[] pIntegerArray );

  /**
   * @param pBookingCode
   * @return {@link String}
   */
  Mono<String> testDataTypeAsQueryParam( BookingCode pBookingCode );

  /**
   * @param pBeanParam
   * @return {@link String}
   */
  Mono<String> testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam );

  /**
   * @param pIntValues
   * @return {@link String}
   */
  Mono<String> testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * @param pStrings
   * @return {@link String}
   */
  Mono<String> testSimpleTypesAsQueryParams( List<String> pStrings );

  /**
   * @param pIntegers
   * @return {@link String}
   */
  Mono<String> testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers );

  /**
   * @param pBean
   * @return {@link String}
   */
  Mono<String> testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean );

  /**
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @param pTimestamps
   * @param pLocalDates
   * @return {@link String}
   */
  Mono<String> testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates );

  /**
   * @param pQueryBean
   * @return {@link String}
   */
  Mono<String> testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean );

  /**
   * @param pMultiValuedBean
   * @return {@link String}
   */
  Mono<String> testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean );

  /**
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
  Mono<String> testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes,
      byte[] pBase64 );

  /**
   * @param pBookingID
   */
  Mono<Void> testBookingIDAsPathParam( BookingID pBookingID );

  /**
   * @param pBookingID
   */
  Mono<Void> testBookingIDAsHeaderParam( BookingID pBookingID );

  /**
   * @param pContext
   * @return {@link String}
   */
  Mono<String> testContextWithPrimitives( ContextWithPrimitives pContext );

  /**
   * @param pAnInt
   * @param pAnInteger
   * @param pABoolean
   * @param pBooleanWrapper
   * @param pALong
   * @param pVeryLong
   * @return {@link String}
   */
  Mono<String> testPrimitivesAsParams( int pAnInt, Integer pAnInteger, boolean pABoolean, Boolean pBooleanWrapper,
      long pALong, Long pVeryLong );
}