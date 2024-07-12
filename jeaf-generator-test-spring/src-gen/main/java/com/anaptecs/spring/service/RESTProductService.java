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

public interface RESTProductService {
  /**
   * Operation returns all available product.
   * <p/>
   * <b>Authorized Roles:</b> Customer, Sales Agent
   *
   * @param pMaxResultSize
   * @return {@link List<Product>}
   */
  List<Product> getProducts( int pMaxResultSize );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pProductID
   * @return {@link Product}
   */
  @MyNotNullServiceParam
  Product getProduct( @NotEmpty @MyNotNullServiceParam String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pProduct
   * @return boolean
   */
  boolean createProduct( @MyNotNullServiceParam Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link Sortiment}
   */
  @MyNotNullServiceParam
  Sortiment getSortiment( @MyNotNullServiceParam Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNullServiceParam
  ChannelCode createChannelCode( @NotBlank @MyNotNullServiceParam String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Customer, Sales Agent
   */
  @MyNotNullServiceParam
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   */
  @MyNotNullServiceParam
  void testInit( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrencies( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( @MyNotNullServiceParam ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testParams( @MyNotNullServiceParam BigDecimal pBigDecimalHeader, int pIntCookieParam,
      @MyNotNullServiceParam Locale pLocaleQueryParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNullServiceParam
  void testEnumParams( @MyNotNullServiceParam ChannelType pChannelType, @MyNotNullServiceParam TimeUnit pTimeUnit,
      @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNullServiceParam
  void testEnumHeaderParams( @MyNotNullServiceParam ChannelType pChannelType, @MyNotNullServiceParam TimeUnit pTimeUnit,
      @MyNotNullServiceParam ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
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
  void testDateQueryParams( @MyNotNullServiceParam String pPath, @MyNotNullServiceParam OffsetDateTime pStartTimestamp,
      @MyNotNullServiceParam OffsetTime pStartTime, @MyNotNullServiceParam LocalDateTime pLocalStartTimestamp,
      @MyNotNullServiceParam LocalTime pLocalStartTime, @MyNotNullServiceParam LocalDate pLocalStartDate,
      @MyNotNullServiceParam Calendar pCalendar, @MyNotNullServiceParam java.util.Date pUtilDate,
      @MyNotNullServiceParam Timestamp pSQLTimestamp, @MyNotNullServiceParam Time pSQLTime,
      @MyNotNullServiceParam Date pSQLDate, Set<Calendar> pCalendars );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNullServiceParam
  void testDateQueryParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateQueryParamsBean pQueryParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
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
  void testDateHeaderParams( @MyNotNullServiceParam String pPath, @MyNotNullServiceParam OffsetDateTime pOffsetDateTime,
      @MyNotNullServiceParam OffsetTime pOffsetTime, @MyNotNullServiceParam LocalDateTime pLocalDateTime,
      @MyNotNullServiceParam LocalTime pLocalTime, @MyNotNullServiceParam LocalDate pLocalDate,
      @MyNotNullServiceParam Calendar pCalendar, @MyNotNullServiceParam java.util.Date pUtilDate,
      @MyNotNullServiceParam Timestamp pSQLTimestamp, @MyNotNullServiceParam Time pSQLTime,
      @MyNotNullServiceParam Date pSQLDate, Set<java.util.Date> pUtilDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNullServiceParam
  void testDateHeaderParamsBean( @MyNotNullServiceParam String pPath,
      @MyNotNullServiceParam DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelTypeParam
   * @param pContext
   */
  @MyNotNullServiceParam
  void testCookieParams( @MyNotNullServiceParam ChannelType pChannelTypeParam,
      @MyNotNullServiceParam SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testOptionalQueryParams( String query1, int query2 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pComplextBookingID
   * @return boolean
   */
  boolean processComplexBookingID( @MyNotNullServiceParam ComplexBookingID pComplextBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testDataTypesAsHeaderParam( @MyNotNullServiceParam BookingID pBookingID,
      @MyNotNullServiceParam BookingCode pBookingCode, @MyNotNullServiceParam DoubleCode pDoubleCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testDataTypesAsHeaderBeanParam( @MyNotNullServiceParam AdvancedHeader pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntegerArray
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testPrimitiveArrays( int[] pIntegerArray );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingCode
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testDataTypeAsQueryParam( @MyNotNullServiceParam BookingCode pBookingCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testDataTypeAsBeanQueryParam( @MyNotNullServiceParam QueryBeanParam pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntValues
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pStrings
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testSimpleTypesAsQueryParams( List<String> pStrings );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntegers
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testPrimitiveWrapperArrayAsQueryParam( @MyNotEmptyServiceParam Set<Integer> pIntegers );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMultivaluedQueryParamsBean( @MyNotNullServiceParam MultivaluedQueryParamsBean pBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pCodes
   * @param pLongCodes
   * @param pBookingIDs
   * @param pTimestamps
   * @param pLocalDates
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes,
      @MyNotEmptyServiceParam Set<LongCode> pLongCodes, List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps,
      SortedSet<LocalDate> pLocalDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pQueryBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMulitvaluedDataTypeAsBeanQueryParam( @MyNotNullServiceParam DataTypesQueryBean pQueryBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testMultiValuedHeaderFieldsInBeanParam( @MyNotNullServiceParam MultiValuedHeaderBeanParam pMultiValuedBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
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
  String testMultiValuedHeaderFields( Set<String> pNames, @MyNotEmptyServiceParam int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes,
      byte[] pBase64 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   */
  @MyNotNullServiceParam
  void testBookingIDAsPathParam( @MyNotNullServiceParam BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   */
  @MyNotNullServiceParam
  void testBookingIDAsHeaderParam( BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNullServiceParam
  String testContextWithPrimitives( @MyNotNullServiceParam ContextWithPrimitives pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
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
  String testPrimitivesAsParams( int pAnInt, @MyNotNullServiceParam Integer pAnInteger, boolean pABoolean,
      @MyNotNullServiceParam Boolean pBooleanWrapper, long pALong, @MyNotNullServiceParam Long pVeryLong );
}