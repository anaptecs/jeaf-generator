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

import com.anaptecs.annotations.MyNotEmpty;
import com.anaptecs.annotations.MyNotNull;
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
  @MyNotNull
  Product getProduct( @NotEmpty @MyNotNull String pProductID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pProduct
   * @return boolean
   */
  boolean createProduct( @MyNotNull Product pProduct );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link Sortiment}
   */
  @MyNotNull
  Sortiment getSortiment( @MyNotNull Context pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link ChannelCode}
   */
  @MyNotNull
  ChannelCode createChannelCode( @NotBlank @MyNotNull String pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Customer, Sales Agent
   */
  @MyNotNull
  void ping( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   */
  @MyNotNull
  void testInit( );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrencies( @MyNotNull ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelCode
   * @return {@link List<CurrencyCode>}
   */
  List<CurrencyCode> getSupportedCurrenciesAsync( @MyNotNull ChannelCode pChannelCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */
  @MyNotNull
  String testParams( @MyNotNull BigDecimal pBigDecimalHeader, int pIntCookieParam,
      @MyNotNull Locale pLocaleQueryParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNull
  void testEnumParams( @MyNotNull ChannelType pChannelType, @MyNotNull TimeUnit pTimeUnit,
      @MyNotNull ExtensibleEnum pExtensibleEnum );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelType
   * @param pTimeUnit
   * @param pExtensibleEnum
   */
  @MyNotNull
  void testEnumHeaderParams( @MyNotNull ChannelType pChannelType, @MyNotNull TimeUnit pTimeUnit,
      @MyNotNull ExtensibleEnum pExtensibleEnum );

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
  @MyNotNull
  void testDateQueryParams( @MyNotNull String pPath, @MyNotNull OffsetDateTime pStartTimestamp,
      @MyNotNull OffsetTime pStartTime, @MyNotNull LocalDateTime pLocalStartTimestamp,
      @MyNotNull LocalTime pLocalStartTime, @MyNotNull LocalDate pLocalStartDate, @MyNotNull Calendar pCalendar,
      @MyNotNull java.util.Date pUtilDate, @MyNotNull Timestamp pSQLTimestamp, @MyNotNull Time pSQLTime,
      @MyNotNull Date pSQLDate, Set<Calendar> pCalendars );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pPath
   * @param pQueryParams
   */
  @MyNotNull
  void testDateQueryParamsBean( @MyNotNull String pPath, @MyNotNull DateQueryParamsBean pQueryParams );

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
  @MyNotNull
  void testDateHeaderParams( @MyNotNull String pPath, @MyNotNull OffsetDateTime pOffsetDateTime,
      @MyNotNull OffsetTime pOffsetTime, @MyNotNull LocalDateTime pLocalDateTime, @MyNotNull LocalTime pLocalTime,
      @MyNotNull LocalDate pLocalDate, @MyNotNull Calendar pCalendar, @MyNotNull java.util.Date pUtilDate,
      @MyNotNull Timestamp pSQLTimestamp, @MyNotNull Time pSQLTime, @MyNotNull Date pSQLDate,
      Set<java.util.Date> pUtilDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pPath
   * @param pHeaderParams
   */
  @MyNotNull
  void testDateHeaderParamsBean( @MyNotNull String pPath, @MyNotNull DateHeaderParamsBean pHeaderParams );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pChannelTypeParam
   * @param pContext
   */
  @MyNotNull
  void testCookieParams( @MyNotNull ChannelType pChannelTypeParam, @MyNotNull SpecialContext pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param query1
   * @param query2
   * @return {@link String}
   */
  @MyNotNull
  String testOptionalQueryParams( String query1, int query2 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pComplextBookingID
   * @return boolean
   */
  boolean processComplexBookingID( @MyNotNull ComplexBookingID pComplextBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   * @param pBookingCode
   * @param pDoubleCode
   * @return {@link String}
   */
  @MyNotNull
  String testDataTypesAsHeaderParam( @MyNotNull BookingID pBookingID, @MyNotNull BookingCode pBookingCode,
      @MyNotNull DoubleCode pDoubleCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String testDataTypesAsHeaderBeanParam( @MyNotNull AdvancedHeader pContext );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntegerArray
   * @return {@link String}
   */
  @MyNotNull
  String testPrimitiveArrays( int[] pIntegerArray );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingCode
   * @return {@link String}
   */
  @MyNotNull
  String testDataTypeAsQueryParam( @MyNotNull BookingCode pBookingCode );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBeanParam
   * @return {@link String}
   */
  @MyNotNull
  String testDataTypeAsBeanQueryParam( @MyNotNull QueryBeanParam pBeanParam );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntValues
   * @return {@link String}
   */
  @MyNotNull
  String testPrimitiveArrayAsQueryParam( int[] pIntValues );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pStrings
   * @return {@link String}
   */
  @MyNotNull
  String testSimpleTypesAsQueryParams( List<String> pStrings );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pIntegers
   * @return {@link String}
   */
  @MyNotNull
  String testPrimitiveWrapperArrayAsQueryParam( @MyNotEmpty Set<Integer> pIntegers );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBean
   * @return {@link String}
   */
  @MyNotNull
  String testMultivaluedQueryParamsBean( @MyNotNull MultivaluedQueryParamsBean pBean );

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
  @MyNotNull
  String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, @MyNotEmpty Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pQueryBean
   * @return {@link String}
   */
  @MyNotNull
  String testMulitvaluedDataTypeAsBeanQueryParam( @MyNotNull DataTypesQueryBean pQueryBean );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pMultiValuedBean
   * @return {@link String}
   */
  @MyNotNull
  String testMultiValuedHeaderFieldsInBeanParam( @MyNotNull MultiValuedHeaderBeanParam pMultiValuedBean );

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
  @MyNotNull
  String testMultiValuedHeaderFields( Set<String> pNames, @MyNotEmpty int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes,
      byte[] pBase64 );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   */
  @MyNotNull
  void testBookingIDAsPathParam( @MyNotNull BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pBookingID
   */
  @MyNotNull
  void testBookingIDAsHeaderParam( BookingID pBookingID );

  /**
   * <p/>
   * <b>Authorized Roles:</b> Sales Agent
   *
   * @param pContext
   * @return {@link String}
   */
  @MyNotNull
  String testContextWithPrimitives( @MyNotNull ContextWithPrimitives pContext );

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
  @MyNotNull
  String testPrimitivesAsParams( int pAnInt, @MyNotNull Integer pAnInteger, boolean pABoolean,
      @MyNotNull Boolean pBooleanWrapper, long pALong, @MyNotNull Long pVeryLong );
}
